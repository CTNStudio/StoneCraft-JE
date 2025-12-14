package ctn.stonecraft.event;

import ctn.stonecraft.init.ScItems;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import static ctn.stonecraft.api.util.LevelUtil.summonLootItems;
import static ctn.stonecraft.datagen.ScTags.ScBlocks.FALL_AWAY_STONE_NUGGET;
import static ctn.stonecraft.datagen.ScTags.ScBlocks.STONE_DESTROYER_EFFECT_BLOCKS;
import static ctn.stonecraft.init.ScEnchantments.STONE_DESTROYER;

@EventBusSubscriber
public class BlockEvents {

	@SubscribeEvent
	public static void registerBlocks(final BlockEvent.BreakEvent event) {
		if (event.getPlayer().isCreative()) {
			return;
		}
		BlockState state = event.getState();
		if (!state.is(FALL_AWAY_STONE_NUGGET)) {
			return;
		}
		LevelAccessor accessor = event.getLevel();
		if (!(accessor instanceof ServerLevel level)) {
			return;
		}
		BlockPos pos = event.getPos();
		Player player = event.getPlayer();
		boolean flag1 = state.canHarvestBlock(level, pos, player);
		if (flag1) {
			return;
		}
		//添加到世界
		summonLootItems(level, pos, ScItems.STONE_NUGGET.asItem());
	}

	@SubscribeEvent
	public static void onBlockBreak(PlayerEvent.BreakSpeed event) {
		Player player = event.getEntity();
		BlockState state = event.getState();
		float original = event.getOriginalSpeed();
		if (!state.is(STONE_DESTROYER_EFFECT_BLOCKS)) {
			return;
		}
		ItemStack stack = player.getMainHandItem();
		ItemEnchantments itemenchantments = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
		int level = 0;
		for (Object2IntMap.Entry<Holder<Enchantment>> entry : itemenchantments.entrySet()) {
			if (entry.getKey().is(STONE_DESTROYER)) {
				level = entry.getIntValue();
			}
		}
		if (level <= 0) {
			return;
		}
		event.setNewSpeed(original + original * level);
	}
}
