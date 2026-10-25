package ctn.stonecraft.common;

import ctn.stonecraft.init.ScItems;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.providers.EnchantmentProvider;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class StoneCoinForItems implements VillagerTrades.ItemListing {
	protected final ItemStack                                  itemStack;
	protected final int                                        coinCost;
	protected final int                                        maxUses;
	protected final int                                        villagerXp;
	protected final float                                      priceMultiplier;
	protected final Optional<ResourceKey<EnchantmentProvider>> enchantmentProvider;
	
	public StoneCoinForItems(Block block, int coinCost, int numberOfItems, int maxUses, int villagerXp) {
		this(new ItemStack(block), coinCost, numberOfItems, maxUses, villagerXp);
	}
	
	public StoneCoinForItems(ItemStack itemStack, int coinCost, int numberOfItems, int maxUses, int villagerXp) {
		this(itemStack, coinCost, numberOfItems, maxUses, villagerXp, 0.05F);
	}
	
	public StoneCoinForItems(ItemStack itemStack, int coinCost, int numberOfItems, int maxUses, int villagerXp, float priceMultiplier) {
		this(itemStack, coinCost, numberOfItems, maxUses, villagerXp, priceMultiplier, Optional.empty());
	}
	
	public StoneCoinForItems(
			ItemStack itemStack,
			int coinCost,
			int numberOfItems,
			int maxUses,
			int villagerXp,
			float priceMultiplier,
			Optional<ResourceKey<EnchantmentProvider>> enchantmentProvider
	) {
		this.itemStack = itemStack;
		this.coinCost  = coinCost;
		this.itemStack.setCount(numberOfItems);
		this.maxUses             = maxUses;
		this.villagerXp          = villagerXp;
		this.priceMultiplier     = priceMultiplier;
		this.enchantmentProvider = enchantmentProvider;
	}
	
	public StoneCoinForItems(Item item, int coinCost, int numberOfItems, int villagerXp) {
		this(new ItemStack(item), coinCost, numberOfItems, 12, villagerXp);
	}
	
	public StoneCoinForItems(Item item, int coinCost, int numberOfItems, int maxUses, int villagerXp) {
		this(new ItemStack(item), coinCost, numberOfItems, maxUses, villagerXp);
	}
	
	public StoneCoinForItems(Item item, int coinCost, int numberOfItems, int maxUses, int villagerXp, float priceMultiplier) {
		this(new ItemStack(item), coinCost, numberOfItems, maxUses, villagerXp, priceMultiplier);
	}
	
	public StoneCoinForItems(
			Item item, int coinCost, int numberOfItems, int maxUses, int villagerXp, float priceMultiplier, ResourceKey<EnchantmentProvider> enchantmentProvider
	) {
		this(new ItemStack(item), coinCost, numberOfItems, maxUses, villagerXp, priceMultiplier, Optional.of(enchantmentProvider));
	}
	
	@Override
	public MerchantOffer getOffer(Entity trader, @NotNull RandomSource random) {
		ItemStack itemstack = this.itemStack.copy();
		Level level = trader.level();
		this.enchantmentProvider
				.ifPresent(
						key -> EnchantmentHelper.enchantItemFromProvider(
								itemstack,
								level.registryAccess(),
								key,
								level.getCurrentDifficultyAt(trader.blockPosition()),
								random
						)
				);
		int villagerXp = random.nextInt(Math.max(1, this.villagerXp - 2), this.villagerXp + 2);
		int maxUses = random.nextInt((Math.max(1, this.maxUses - 2)), this.maxUses + 2);
		return new MerchantOffer(new ItemCost(ScItems.STONE_COIN.get(), this.coinCost),
				itemstack,
				maxUses, villagerXp,
				this.priceMultiplier);
	}
}
