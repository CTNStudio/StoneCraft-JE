package ctn.stonecraft.common;

import ctn.stonecraft.init.ScItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

public class ItemsForStoneCoin implements VillagerTrades.ItemListing {
	protected final ItemCost itemStack;
	protected final int      maxUses;
	protected final int      villagerXp;
	protected final int      coinAmount;
	protected final float    priceMultiplier;
	
	public ItemsForStoneCoin(ItemLike item, int cost, int maxUses, int villagerXp) {
		this(item, cost, maxUses, villagerXp, 1);
	}
	
	public ItemsForStoneCoin(ItemLike item, int cost, int maxUses, int villagerXp, int coinAmount) {
		this(new ItemCost(item.asItem(), cost), maxUses, villagerXp, coinAmount);
	}
	
	public ItemsForStoneCoin(ItemCost itemStack, int maxUses, int villagerXp, int coinAmount) {
		this.itemStack       = itemStack;
		this.maxUses         = maxUses;
		this.villagerXp      = villagerXp;
		this.coinAmount      = coinAmount;
		this.priceMultiplier = 0.05F;
	}
	
	@Override
	public MerchantOffer getOffer(@NotNull Entity trader, @NotNull RandomSource random) {
		int villagerXp = random.nextInt(Math.max(1, this.villagerXp - 2), this.villagerXp + 2);
		int maxUses = random.nextInt((Math.max(1, this.maxUses - 2)), this.maxUses + 2);
		return new MerchantOffer(this.itemStack, new ItemStack(ScItems.STONE_COIN.get(), this.coinAmount), maxUses, villagerXp, this.priceMultiplier);
	}
}
