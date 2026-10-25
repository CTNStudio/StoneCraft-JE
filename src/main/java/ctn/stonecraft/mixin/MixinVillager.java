package ctn.stonecraft.mixin;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ReputationEventHandler;
import net.minecraft.world.entity.npc.*;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Villager.class)
public abstract class MixinVillager extends AbstractVillager implements ReputationEventHandler, VillagerDataHolder {
	@Shadow
	private int foodLevel;
	
	public MixinVillager(EntityType<? extends AbstractVillager> entityType, Level level) {
		super(entityType, level);
	}
	
	@Inject(method = "updateTrades", at = @At("HEAD"), cancellable = true)
	private void stonecraft$updateTrades(CallbackInfo ci) {
		VillagerData data = this.getVillagerData();
		VillagerProfession type = data.getProfession();
		if (type != VillagerProfession.MASON) {
			return;
		}
		Int2ObjectMap<VillagerTrades.ItemListing[]> map;
		if (this.level().enabledFeatures().contains(FeatureFlags.TRADE_REBALANCE)) {
			Int2ObjectMap<VillagerTrades.ItemListing[]> map1 = VillagerTrades.EXPERIMENTAL_TRADES.get(data.getProfession());
			map = map1 != null ? map1 : VillagerTrades.TRADES.get(data.getProfession());
		} else {
			map = VillagerTrades.TRADES.get(data.getProfession());
		}
		
		if (map != null && !map.isEmpty()) {
			int dataLevel = data.getLevel();
			VillagerTrades.ItemListing[] itemlisting = map.get(dataLevel);
			if (itemlisting != null) {
				MerchantOffers merchantoffers = this.getOffers();
				int numbers = getRandom().nextInt(2 + dataLevel, 10 + dataLevel);
				this.addOffersFromItemListings(merchantoffers, itemlisting, numbers);
			}
		}
		ci.cancel();
	}
}
