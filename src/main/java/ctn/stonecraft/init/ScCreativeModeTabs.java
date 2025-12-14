package ctn.stonecraft.init;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static ctn.stonecraft.core.StoneCraft.ID;
import static ctn.stonecraft.init.ScEnchantments.*;

public class ScCreativeModeTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCK                     =
			register("block", (name) -> registerCreativeModeTab(
					name,
					(parameters, output) -> {
						registerBlockListItems(output, ScItems.COMPRESSED_COBBLESTONE);
						registerBlockListItems(output, ScItems.COMPRESSED_MOSSY_COBBLESTONE);
						registerBlockListItems(output, ScItems.COMPRESSED_STONE);
						registerBlockListItems(output, ScItems.COMPRESSED_GRANITE);
						registerBlockListItems(output, ScItems.COMPRESSED_ANDESITE);
						registerBlockListItems(output, ScItems.COMPRESSED_DIORITE);
						registerBlockListItems(output, ScItems.COMPRESSED_BEDROCK);
						registerBlockListItems(output, ScItems.COMPRESSED_END_STONE);
						registerBlockListItems(output, ScItems.COMPRESSED_OBSIDIAN);
						output.accept(ScItems.GLOWINGOBSIDIAN);
						registerBlockListItems(output, ScItems.COMPRESSED_GLOWINGOBSIDIAN);
						registerBlockListItems(output, ScItems.COMPRESSED_CRYING_OBSIDIAN);
						registerBlockListItems(output, ScItems.COMPRESSED_PRISMARINE);
						registerBlockListItems(output, ScItems.COMPRESSED_DARK_PRISMARINE);
						registerBlockListItems(output, ScItems.COMPRESSED_NETHERRACK);
						registerBlockListItems(output, ScItems.COMPRESSED_GLOWSTONE);
						registerBlockListItems(output, ScItems.COMPRESSED_BLACKSTONE);
						registerBlockListItems(output, ScItems.COMPRESSED_CALCITE);
						registerBlockListItems(output, ScItems.COMPRESSED_DEEPSLATE);
						registerBlockListItems(output, ScItems.COMPRESSED_COBBLED_DEEPSLATE);
						registerBlockListItems(output, ScItems.COMPRESSED_BASALT);
						registerBlockListItems(output, ScItems.COMPRESSED_TUFF);
						registerBlockListItems(output, ScItems.COMPRESSED_DRIPSTONE_BLOCK);
            output.accept(ScItems.STONE_CRAFTING_TABLE); //石质工作台
					}, () -> ScItems.COMPRESSED_COBBLESTONE.getFirst().get().getDefaultInstance()));

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEM =
			register("item", (name) -> registerCreativeModeTab(
					name,
					(parameters, output) -> {
						outputEnchantmentBook(parameters, output, STONE_DESTROYER);
						outputEnchantmentBook(parameters, output, STONE_BUFFER);
						outputEnchantmentBook(parameters, output, OLDB);
						output.accept(ScItems.STONE_STAR);
						output.accept(ScItems.STONE_NUGGET);
						output.accept(ScItems.STONE_COIN);
					}, () -> ScItems.STONE_COIN.get().getDefaultInstance()));
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TOOL =
			register("tool", (name) -> registerCreativeModeTab(
					name,
					(parameters, output) -> {

						output.accept(ScItems.STONE_HELMET);
						output.accept(ScItems.STONE_CHESTPLATE);
						output.accept(ScItems.STONE_LEGGINGS);
						output.accept(ScItems.STONE_BOOTS);

						output.accept(ScItems.VERSATILE_STONE_TOOL);
						output.accept(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1);
						output.accept(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2);
						output.accept(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3);
						output.accept(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4);
						output.accept(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5);

						output.accept(ScItems.COMPRESSED_STONE_AXE_LV1);
						output.accept(ScItems.COMPRESSED_STONE_AXE_LV2);
						output.accept(ScItems.COMPRESSED_STONE_AXE_LV3);
						output.accept(ScItems.COMPRESSED_STONE_AXE_LV4);
						output.accept(ScItems.COMPRESSED_STONE_AXE_LV5);

						output.accept(ScItems.COMPRESSED_STONE_PICKAXE_LV1);
						output.accept(ScItems.COMPRESSED_STONE_PICKAXE_LV2);
						output.accept(ScItems.COMPRESSED_STONE_PICKAXE_LV3);
						output.accept(ScItems.COMPRESSED_STONE_PICKAXE_LV4);
						output.accept(ScItems.COMPRESSED_STONE_PICKAXE_LV5);

						output.accept(ScItems.COMPRESSED_STONE_SHOVEL_LV1);
						output.accept(ScItems.COMPRESSED_STONE_SHOVEL_LV2);
						output.accept(ScItems.COMPRESSED_STONE_SHOVEL_LV3);
						output.accept(ScItems.COMPRESSED_STONE_SHOVEL_LV4);
						output.accept(ScItems.COMPRESSED_STONE_SHOVEL_LV5);

						output.accept(ScItems.COMPRESSED_STONE_HOE_LV1);
						output.accept(ScItems.COMPRESSED_STONE_HOE_LV2);
						output.accept(ScItems.COMPRESSED_STONE_HOE_LV3);
						output.accept(ScItems.COMPRESSED_STONE_HOE_LV4);
						output.accept(ScItems.COMPRESSED_STONE_HOE_LV5);
					}, () -> ScItems.COMPRESSED_STONE_SWORD_LV1.get().getDefaultInstance()));

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOOD =
			register("food", (name) -> registerCreativeModeTab(
					name,
					(parameters, output) -> {
						output.accept(ScItems.STONE_APPLE);
						output.accept(ScItems.STONE_BREAD);
						output.accept(ScItems.STONE_CARROT);
						output.accept(ScItems.STONE_KELP);
						output.accept(ScItems.STONE_MELON_SLICE);
						output.accept(ScItems.STONE_POTATO);
						output.accept(ScItems.STONE_HODGEPODGE);
						output.accept(ScItems.STONE_COOKED_COD);
						output.accept(ScItems.STONE_COOKIE);
						output.accept(ScItems.STONE_GLOW_BERRIES);
						output.accept(ScItems.STONE_COOKED_BEEF);
						output.accept(ScItems.STONE_SWEET_BERRIES);
						output.accept(ScItems.STONICKERS);
						output.accept(ScItems.COMPRESSED_STONICKERS_LV1);
						output.accept(ScItems.COMPRESSED_STONICKERS_LV2);
						output.accept(ScItems.COMPRESSED_STONICKERS_LV3);
						output.accept(ScItems.COMPRESSED_STONICKERS_LV4);
						output.accept(ScItems.COMPRESSED_STONICKERS_LV5);
					}, () -> ScItems.STONE_APPLE.get().getDefaultInstance()));

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> COMBAT_SUPPLIES =
			register("combat_supplies", (name) -> registerCreativeModeTab(
					name,
					(parameters, output) -> {
						output.accept(ScItems.COMPRESSED_STONE_SWORD_LV1);
						output.accept(ScItems.COMPRESSED_STONE_SWORD_LV2);
						output.accept(ScItems.COMPRESSED_STONE_SWORD_LV3);
						output.accept(ScItems.COMPRESSED_STONE_SWORD_LV4);
						output.accept(ScItems.COMPRESSED_STONE_SWORD_LV5);

						output.accept(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1);
						output.accept(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2);
						output.accept(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3);

						output.accept(ScItems.WOOD_SLINGSHOT);
						output.accept(ScItems.STONE_SLINGSHOT);
						output.accept(ScItems.IRON_SLINGSHOT);
						output.accept(ScItems.GOLD_SLINGSHOT);
						output.accept(ScItems.DIAMOND_SLINGSHOT);
						output.accept(ScItems.NETHERITE_SLINGSHOT);

						output.accept(ScItems.COMPRESSED_STONE_HELMET_LV1);
						output.accept(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1);
						output.accept(ScItems.COMPRESSED_STONE_LEGGINGS_LV1);
						output.accept(ScItems.COMPRESSED_STONE_BOOTS_LV1);

						output.accept(ScItems.COMPRESSED_STONE_HELMET_LV2);
						output.accept(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2);
						output.accept(ScItems.COMPRESSED_STONE_LEGGINGS_LV2);
						output.accept(ScItems.COMPRESSED_STONE_BOOTS_LV2);

						output.accept(ScItems.COMPRESSED_STONE_HELMET_LV3);
						output.accept(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3);
						output.accept(ScItems.COMPRESSED_STONE_LEGGINGS_LV3);
						output.accept(ScItems.COMPRESSED_STONE_BOOTS_LV3);

						output.accept(ScItems.COMPRESSED_STONE_HELMET_LV4);
						output.accept(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4);
						output.accept(ScItems.COMPRESSED_STONE_LEGGINGS_LV4);
						output.accept(ScItems.COMPRESSED_STONE_BOOTS_LV4);

						output.accept(ScItems.COMPRESSED_STONE_HELMET_LV5);
						output.accept(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5);
						output.accept(ScItems.COMPRESSED_STONE_LEGGINGS_LV5);
						output.accept(ScItems.COMPRESSED_STONE_BOOTS_LV5);
					}, () -> ScItems.STONE_APPLE.get().getDefaultInstance()));

	private static void outputEnchantmentBook(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output, ResourceKey<Enchantment> stoneDestroyer) {
		parameters.holders().lookup(Registries.ENCHANTMENT).ifPresent(lookup ->
				generateEnchantmentBookTypesAllLevels(output, lookup, stoneDestroyer));
	}

	private static void generateEnchantmentBookTypesAllLevels(CreativeModeTab.Output output,
			HolderLookup<Enchantment> enchantments,
			ResourceKey<Enchantment> resourceKey) {
		enchantments.listElements().filter(reference -> reference.is(resourceKey))
				.flatMap(reference -> IntStream.rangeClosed(reference.value().getMinLevel(), reference.value().getMaxLevel())
						.mapToObj(i -> EnchantedBookItem.createForEnchantment(new EnchantmentInstance(reference, i))))
				.forEach(output::accept);
	}

	public static void registerBlockListItems(CreativeModeTab.Output output, List<DeferredItem<BlockItem>> listItem) {
		for (DeferredItem<BlockItem> item : listItem) {
			output.accept(item);
		}
	}

	public static DeferredHolder<CreativeModeTab, CreativeModeTab> register(String name, Function<String, CreativeModeTab.Builder> builder) {
		return REGISTER.register(name, builder.apply(name)::build);
	}

	public static CreativeModeTab.Builder registerCreativeModeTab(
			String name,
			CreativeModeTab.DisplayItemsGenerator displayItemsGenerator,
			Supplier<ItemStack> icon,
			ResourceKey<CreativeModeTab> withTabsBefore) {
		return registerCreativeModeTab(name, displayItemsGenerator, icon).withTabsBefore(withTabsBefore);
	}

	public static CreativeModeTab.Builder registerCreativeModeTab(
			String name,
			CreativeModeTab.DisplayItemsGenerator displayItemsGenerator,
			Supplier<ItemStack> icon) {
		return registerCreativeModeTab(name, displayItemsGenerator).icon(icon);
	}

	public static CreativeModeTab.Builder registerCreativeModeTab(String name, CreativeModeTab.DisplayItemsGenerator displayItemsGenerator) {
		return CreativeModeTab.builder().title(getComponent(name)).displayItems(displayItemsGenerator);
	}

	private static @NotNull MutableComponent getComponent(String imagePath) {
		return Component.translatable("itemGroup." + ID + "." + imagePath);
	}
}
