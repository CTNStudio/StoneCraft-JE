package ctn.stonecraft.events;

import ctn.stonecraft.datagen.tag.ScBlockTags;
import ctn.stonecraft.init.ScEnchantments;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;

@EventBusSubscriber
public class EntityEvents {
	/**
	 * 处理实体受到坠落伤害时的事件，若满足条件则使实体对该伤害免疫。<br>
	 * 监听: {@link EntityInvulnerabilityCheckEvent}
	 */
	@SubscribeEvent
	public static void fallingDamage(EntityInvulnerabilityCheckEvent event) {
		DamageSource source = event.getSource();
		if (!source.is(DamageTypeTags.IS_FALL)) {
			return;
		}
		if (!(event.getEntity() instanceof LivingEntity livingEntity)) {
			return;
		}
		Level level = livingEntity.level();
		
		// 获取实体脚下位置的方块状态
		BlockState blockState = level.getBlockState(livingEntity.getOnPos());
		if (!blockState.is(ScBlockTags.STONE_BUFFER_EFFECT_BLOCKS)) {
			return;
		}
		
		ItemStack boots = livingEntity.getItemBySlot(EquipmentSlot.FEET);
		
		// 获取注册表访问权限并获取 STONE_BUFFER 附魔的 Holder
		RegistryAccess registryAccess = level.registryAccess();
		Holder<Enchantment> enchantment = registryAccess.holderOrThrow(ScEnchantments.STONE_BUFFER);
		if (boots.getEnchantmentLevel(enchantment) < 1) {
			return;
		}
		
		// 满足条件：穿戴了石之缓冲附魔靴子且位于支持方块上，设置为免疫坠落伤害
		event.setInvulnerable(true);
	}
}
