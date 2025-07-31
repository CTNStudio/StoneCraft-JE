package ctn.stonecraft.events;

import ctn.stonecraft.common.ItemsForStoneCoin;
import ctn.stonecraft.common.StoneCoinForItems;
import ctn.stonecraft.init.ScEnchantments;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static ctn.stonecraft.init.ScItems.*;

@EventBusSubscriber
public class VillagerEvents {
	
	@SubscribeEvent
	public static void addTrading(VillagerTradesEvent event) {
		VillagerProfession type = event.getType();
		if (type != VillagerProfession.MASON) {
			return;
		}
		Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
		trades.get(1).addAll(List.of(
				itemsForStoneCoin(COMPRESSED_COBBLESTONE, 1),
				itemsForStoneCoin(COMPRESSED_MOSSY_COBBLESTONE, 2),
				itemsForStoneCoin(COMPRESSED_STONE, 2),
				itemsForStoneCoin(COMPRESSED_GRANITE, 2),
				itemsForStoneCoin(COMPRESSED_ANDESITE, 2),
				itemsForStoneCoin(COMPRESSED_DIORITE, 2),
				itemsForStoneCoin(COMPRESSED_CALCITE, 2),
				itemsForStoneCoin(COMPRESSED_DEEPSLATE, 2),
				itemsForStoneCoin(COMPRESSED_BASALT, 2),
				itemsForStoneCoin(COMPRESSED_TUFF, 2),
				itemsForStoneCoin(COMPRESSED_DRIPSTONE_BLOCK, 2)
		));
		trades.get(2).addAll(List.of(
				stoneCoinForItems(Items.STONE, 2, 1),
				stoneCoinForItems(Items.COBBLESTONE, 4, 1),
				stoneCoinForItems(Items.MOSSY_COBBLESTONE, 2, 1),
				stoneCoinForItems(Items.SMOOTH_STONE, 1, 2),
				stoneCoinForItems(Items.GRANITE, 2, 1),
				stoneCoinForItems(Items.DIORITE, 2, 1),
				stoneCoinForItems(Items.ANDESITE, 2, 1),
				stoneCoinForItems(Items.DEEPSLATE, 1, 2),
				stoneCoinForItems(Items.COBBLED_DEEPSLATE, 1, 1),
				stoneCoinForItems(Items.DEEPSLATE_BRICKS, 1, 2),
				stoneCoinForItems(Items.DEEPSLATE_TILES, 1, 2),
				stoneCoinForItems(Items.CRACKED_DEEPSLATE_BRICKS, 1, 2),
				stoneCoinForItems(Items.CRACKED_DEEPSLATE_TILES, 1, 2),
				stoneCoinForItems(Items.TUFF, 2, 1),
				stoneCoinForItems(Items.CHISELED_TUFF, 1, 2),
				stoneCoinForItems(Items.TUFF_BRICKS, 1, 2),
				stoneCoinForItems(Items.CHISELED_TUFF_BRICKS, 1, 2),
				stoneCoinForItems(Items.GILDED_BLACKSTONE, 1, 1),
				stoneCoinForItems(Items.PACKED_MUD, 1, 1),
				stoneCoinForItems(Items.SANDSTONE, 1, 1),
				stoneCoinForItems(Items.CUT_SANDSTONE, 1, 2),
				stoneCoinForItems(Items.CHISELED_SANDSTONE, 1, 2),
				stoneCoinForItems(Items.SMOOTH_SANDSTONE, 1, 2),
				stoneCoinForItems(Items.RED_SANDSTONE, 1, 1),
				stoneCoinForItems(Items.CUT_RED_SANDSTONE, 1, 2),
				stoneCoinForItems(Items.CHISELED_RED_SANDSTONE, 1, 2),
				stoneCoinForItems(Items.SMOOTH_RED_SANDSTONE, 1, 2)
		
		));
		trades.get(3).addAll(List.of(
				stoneCoinForItems(Items.POLISHED_GRANITE, 1, 1),
				stoneCoinForItems(Items.POLISHED_ANDESITE, 1, 1),
				stoneCoinForItems(Items.POLISHED_TUFF, 1, 2),
				stoneCoinForItems(Items.POLISHED_DIORITE, 1, 1),
				itemsForStoneCoin(COMPRESSED_BEDROCK, 99),
				itemsForStoneCoin(COMPRESSED_END_STONE, 4),
				itemsForStoneCoin(COMPRESSED_OBSIDIAN, 10),
				itemsForStoneCoin(COMPRESSED_GLOWINGOBSIDIAN, 11),
				itemsForStoneCoin(COMPRESSED_CRYING_OBSIDIAN, 12),
				itemsForStoneCoin(COMPRESSED_PRISMARINE, 5),
				itemsForStoneCoin(COMPRESSED_DARK_PRISMARINE, 5),
				itemsForStoneCoin(COMPRESSED_NETHERRACK, 1),
				itemsForStoneCoin(COMPRESSED_BLACKSTONE, 4),
				itemsForStoneCoin(COMPRESSED_COBBLED_DEEPSLATE, 3)
		));
		trades.get(4).addAll(List.of(
				stoneCoinForItems(Items.PRISMARINE, 1, 1),
				stoneCoinForItems(Items.NETHER_BRICKS, 1, 2),
				stoneCoinForItems(Items.RED_NETHER_BRICKS, 1, 3),
				stoneCoinForItems(Items.CRACKED_NETHER_BRICKS, 1, 2),
				stoneCoinForItems(Items.CHISELED_NETHER_BRICKS, 1, 2),
				stoneCoinForItems(Items.DARK_PRISMARINE, 1, 1),
				stoneCoinForItems(Items.NETHERRACK, 4, 1),
				stoneCoinForItems(Items.BASALT, 2, 1),
				stoneCoinForItems(Items.POLISHED_BASALT, 1, 1),
				stoneCoinForItems(Items.SMOOTH_BASALT, 1, 1),
				stoneCoinForItems(Items.BLACKSTONE, 1, 1),
				stoneCoinForItems(Items.POLISHED_BLACKSTONE, 1, 2),
				stoneCoinForItems(Items.CHISELED_POLISHED_BLACKSTONE, 1, 2),
				stoneCoinForItems(Items.PRISMARINE_BRICKS, 1, 3),
				itemsForStoneCoin(Items.GILDED_BLACKSTONE, 2)
		));
		RegistryAccess registryAccess = event.getRegistryAccess();
		trades.get(5).addAll(List.of(
				stoneCoinForItems(Items.QUARTZ_BLOCK, 1, 2),
				stoneCoinForItems(Items.QUARTZ_BRICKS, 1, 2),
				stoneCoinForItems(Items.QUARTZ_PILLAR, 1, 2),
				stoneCoinForItems(Items.CHISELED_QUARTZ_BLOCK, 1, 2),
				stoneCoinForItems(Items.SMOOTH_QUARTZ, 1, 2),
				stoneCoinForItems(Items.END_STONE, 1, 5),
				stoneCoinForItems(Items.END_STONE_BRICKS, 1, 5),
				stoneCoinForItems(Items.PURPUR_BLOCK, 1, 7),
				stoneCoinForItems(Items.PURPUR_PILLAR, 1, 7),
				stoneCoinForEnchantedBook(registryAccess, 16, 0, 1),
				stoneCoinForEnchantedBook(registryAccess, 32, 0, 2),
				stoneCoinForEnchantedBook(registryAccess, 64, 0, 3),
				stoneCoinForEnchantedBook(registryAccess, 64, 64, 4),
				stoneBuffer(registryAccess)
		));
		
	}
	
	private static @NotNull BasicItemListing stoneBuffer(RegistryAccess registryAccess) {
		ItemStack forSaleBook = Items.ENCHANTED_BOOK.getDefaultInstance();
		ItemStack priceBook = Items.ENCHANTED_BOOK.getDefaultInstance();
		forSaleBook.enchant(registryAccess.holderOrThrow(ScEnchantments.STONE_BUFFER), 1);
		priceBook.enchant(registryAccess.holderOrThrow(Enchantments.FEATHER_FALLING), 4);
		return new BasicItemListing(new ItemStack(STONE_COIN.get(), 64), priceBook, forSaleBook, 3, 10, 0.5f);
	}
	
	private static @NotNull VillagerTrades.ItemListing itemsForStoneCoin(List<DeferredItem<BlockItem>> blockItems, int coinCost) {
		return new ItemsForStoneCoin(blockItems.getFirst().get(), 1, 20, coinCost, coinCost);
	}
	
	private static @NotNull VillagerTrades.ItemListing stoneCoinForItems(Item item, int numberOfItems, int coinCost) {
		return new StoneCoinForItems(item, coinCost, numberOfItems, 20, coinCost);
	}
	
	private static @NotNull VillagerTrades.ItemListing itemsForStoneCoin(Item item, int numberOfItems, int coinCost) {
		return new ItemsForStoneCoin(item, numberOfItems, 20, coinCost, coinCost);
	}
	
	private static VillagerTrades.ItemListing stoneCoinForEnchantedBook(RegistryAccess registryAccess, int cost, int cost2, int level) {
		ItemStack forSaleBook = Items.ENCHANTED_BOOK.getDefaultInstance();
		forSaleBook.enchant(registryAccess.holderOrThrow(ScEnchantments.STONE_DESTROYER), level);
		Item stoneCoin = STONE_COIN.get();
		return new BasicItemListing(new ItemStack(stoneCoin, cost), new ItemStack(stoneCoin, cost2), forSaleBook, 3, 10, 0.5f);
	}
	
	private static @NotNull VillagerTrades.ItemListing itemsForStoneCoin(Item item, int coinCost) {
		return new ItemsForStoneCoin(item, 1, 20, coinCost, coinCost);
	}
}
