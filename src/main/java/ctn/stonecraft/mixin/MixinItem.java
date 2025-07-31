package ctn.stonecraft.mixin;

import ctn.stonecraft.init.ScTriggerTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class MixinItem implements FeatureElement, ItemLike, IItemExtension {
	@Inject(at = @At("RETURN"), method = "finishUsingItem")
	public void stonecraft$finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
		if (livingEntity instanceof ServerPlayer serverplayer) {
			ScTriggerTypes.COUNT_CRITERION_TRIGGER.get().trigger(serverplayer, stack);
			serverplayer.awardStat(Stats.ITEM_USED.get((Item) (Object) this));
		}
	}
}
