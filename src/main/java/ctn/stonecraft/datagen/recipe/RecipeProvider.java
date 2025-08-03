package ctn.stonecraft.datagen.recipe;

import com.jcraft.jorbis.Block;
import ctn.stonecraft.datagen.tag.ScItemTags;
import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.datagen.recipe.RecipeTool.*;
import static ctn.stonecraft.datagen.tag.ScTags.ScItems.*;

/**
 * @author 尽
 */
@SuppressWarnings("UnusedReturnValue")
public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {
	private final String modId;
	
	public RecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
		modId = SC_ID;
	}
	
	//region 静态方法
	public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(MinMaxBounds.@NotNull Ints count, @NotNull ItemLike item) {
		return net.minecraft.data.recipes.RecipeProvider.has(count, item);
	}
	
	public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NotNull TagKey<Item> tag) {
		return net.minecraft.data.recipes.RecipeProvider.has(tag);
	}
	
	public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NotNull ItemLike itemLike) {
		return net.minecraft.data.recipes.RecipeProvider.has(itemLike);
	}
	//endregion
	
	// 注册
	@Override
	protected void buildRecipes(@NotNull RecipeOutput output) {
		//region 压缩方块
		unpackedPackedRecipes(output, Items.COBBLESTONE, ScItems.COMPRESSED_COBBLESTONE);
		unpackedPackedRecipes(output, Items.MOSSY_COBBLESTONE, ScItems.COMPRESSED_MOSSY_COBBLESTONE);
		unpackedPackedRecipes(output, Items.STONE, ScItems.COMPRESSED_STONE);
		unpackedPackedRecipes(output, Items.GRANITE, ScItems.COMPRESSED_GRANITE);
		unpackedPackedRecipes(output, Items.ANDESITE, ScItems.COMPRESSED_ANDESITE);
		unpackedPackedRecipes(output, Items.DIORITE, ScItems.COMPRESSED_DIORITE);
		unpackedPackedRecipes(output, Items.BEDROCK, ScItems.COMPRESSED_BEDROCK);
		unpackedPackedRecipes(output, Items.END_STONE, ScItems.COMPRESSED_END_STONE);
		unpackedPackedRecipes(output, Items.OBSIDIAN, ScItems.COMPRESSED_OBSIDIAN);
		unpackedPackedRecipes(output, ScItems.GLOWINGOBSIDIAN, ScItems.COMPRESSED_GLOWINGOBSIDIAN);
		unpackedPackedRecipes(output, Items.CRYING_OBSIDIAN, ScItems.COMPRESSED_CRYING_OBSIDIAN);
		unpackedPackedRecipes(output, Items.PRISMARINE, ScItems.COMPRESSED_PRISMARINE);
		unpackedPackedRecipes(output, Items.DARK_PRISMARINE, ScItems.COMPRESSED_DARK_PRISMARINE);
		unpackedPackedRecipes(output, Items.NETHERRACK, ScItems.COMPRESSED_NETHERRACK);
		unpackedPackedRecipes(output, Items.GLOWSTONE, ScItems.COMPRESSED_GLOWSTONE);
		unpackedPackedRecipes(output, Items.BLACKSTONE, ScItems.COMPRESSED_BLACKSTONE);
		unpackedPackedRecipes(output, Items.CALCITE, ScItems.COMPRESSED_CALCITE);
		unpackedPackedRecipes(output, Items.DEEPSLATE, ScItems.COMPRESSED_DEEPSLATE);
		unpackedPackedRecipes(output, Items.COBBLED_DEEPSLATE, ScItems.COMPRESSED_COBBLED_DEEPSLATE);
		unpackedPackedRecipes(output, Items.BASALT, ScItems.COMPRESSED_BASALT);
		unpackedPackedRecipes(output, Items.TUFF, ScItems.COMPRESSED_TUFF);
		unpackedPackedRecipes(output, Items.DRIPSTONE_BLOCK, ScItems.COMPRESSED_DRIPSTONE_BLOCK);
		//endregion
		
		//region 工具
		//region 多功能工具
		versatileTool(output, null,
				ScItems.VERSATILE_STONE_TOOL,
				Items.STONE_AXE,
				Items.STONE_PICKAXE,
				Items.STONE_SHOVEL,
				Items.STONE_HOE);
		versatileTool(output, ScItems.VERSATILE_STONE_TOOL,
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1,
				ScItems.COMPRESSED_STONE_AXE_LV1,
				ScItems.COMPRESSED_STONE_PICKAXE_LV1,
				ScItems.COMPRESSED_STONE_SHOVEL_LV1,
				ScItems.COMPRESSED_STONE_HOE_LV1);
		versatileTool(output, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1,
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2,
				ScItems.COMPRESSED_STONE_AXE_LV2,
				ScItems.COMPRESSED_STONE_PICKAXE_LV2,
				ScItems.COMPRESSED_STONE_SHOVEL_LV2,
				ScItems.COMPRESSED_STONE_HOE_LV2);
		versatileTool(output, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2,
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3,
				ScItems.COMPRESSED_STONE_AXE_LV3,
				ScItems.COMPRESSED_STONE_PICKAXE_LV3,
				ScItems.COMPRESSED_STONE_SHOVEL_LV3,
				ScItems.COMPRESSED_STONE_HOE_LV3);
		versatileTool(output, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3,
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4,
				ScItems.COMPRESSED_STONE_AXE_LV4,
				ScItems.COMPRESSED_STONE_PICKAXE_LV4,
				ScItems.COMPRESSED_STONE_SHOVEL_LV4,
				ScItems.COMPRESSED_STONE_HOE_LV4);
		versatileTool(output, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4,
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5,
				ScItems.COMPRESSED_STONE_AXE_LV5,
				ScItems.COMPRESSED_STONE_PICKAXE_LV5,
				ScItems.COMPRESSED_STONE_SHOVEL_LV5,
				ScItems.COMPRESSED_STONE_HOE_LV5);
		//endregion
		
		//region 剑
		swordRecipe(output, ScItems.COMPRESSED_STONE_SWORD_LV1,
				Items.STONE_SWORD,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		swordRecipe(output, ScItems.COMPRESSED_STONE_SWORD_LV2,
				ScItems.COMPRESSED_STONE_SWORD_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		swordRecipe(output, ScItems.COMPRESSED_STONE_SWORD_LV3,
				ScItems.COMPRESSED_STONE_SWORD_LV2,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV3));
		swordRecipe(output, ScItems.COMPRESSED_STONE_SWORD_LV4,
				ScItems.COMPRESSED_STONE_SWORD_LV3,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV4));
		swordRecipe(output, ScItems.COMPRESSED_STONE_SWORD_LV5,
				ScItems.COMPRESSED_STONE_SWORD_LV4,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV5));
		//region 终极压缩剑
		ShapedBuilder.basicBuilder(output, ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1, RecipeCategory.MISC,
				shapedBuilder -> shapedBuilder
						.define('*', ScItems.STONE_STAR)
						.define('A', ScItems.COMPRESSED_STONE_SWORD_LV5)
						.pattern(" * ")
						.pattern("*A*")
						.pattern(" * "));
		ShapedBuilder.basicBuilder(output, ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2, RecipeCategory.MISC,
				shapedBuilder -> shapedBuilder
						.define('*', ScItems.STONE_STAR)
						.define('A', ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1)
						.pattern(" * ")
						.pattern("*A*")
						.pattern(" * "));
		ShapedBuilder.basicBuilder(output, ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3, RecipeCategory.MISC,
				shapedBuilder -> shapedBuilder
						.define('*', ScItems.STONE_STAR)
						.define('A', ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2)
						.pattern(" * ")
						.pattern("*A*")
						.pattern(" * "));
		//endregion
		//endregion
		
		//region 斧
		axeRecipe(output, ScItems.COMPRESSED_STONE_AXE_LV1,
				Items.STONE_AXE,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		axeRecipe(output, ScItems.COMPRESSED_STONE_AXE_LV2,
				ScItems.COMPRESSED_STONE_AXE_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		axeRecipe(output, ScItems.COMPRESSED_STONE_AXE_LV3,
				ScItems.COMPRESSED_STONE_AXE_LV2,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV3));
		axeRecipe(output, ScItems.COMPRESSED_STONE_AXE_LV4,
				ScItems.COMPRESSED_STONE_AXE_LV3,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV4));
		axeRecipe(output, ScItems.COMPRESSED_STONE_AXE_LV5,
				ScItems.COMPRESSED_STONE_AXE_LV4,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV5));
		//endregion
		
		//region 镐
		pickaxeRecipe(output, ScItems.COMPRESSED_STONE_PICKAXE_LV1,
				Items.STONE_PICKAXE,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		pickaxeRecipe(output, ScItems.COMPRESSED_STONE_PICKAXE_LV2,
				ScItems.COMPRESSED_STONE_PICKAXE_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		pickaxeRecipe(output, ScItems.COMPRESSED_STONE_PICKAXE_LV3,
				ScItems.COMPRESSED_STONE_PICKAXE_LV2,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV3));
		pickaxeRecipe(output, ScItems.COMPRESSED_STONE_PICKAXE_LV4,
				ScItems.COMPRESSED_STONE_PICKAXE_LV3,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV4));
		pickaxeRecipe(output, ScItems.COMPRESSED_STONE_PICKAXE_LV5,
				ScItems.COMPRESSED_STONE_PICKAXE_LV4,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV5));
		//endregion
		
		//region 锹
		shovelRecipe(output, ScItems.COMPRESSED_STONE_SHOVEL_LV1,
				Items.STONE_SHOVEL,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		shovelRecipe(output, ScItems.COMPRESSED_STONE_SHOVEL_LV2,
				ScItems.COMPRESSED_STONE_SHOVEL_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		shovelRecipe(output, ScItems.COMPRESSED_STONE_SHOVEL_LV3,
				ScItems.COMPRESSED_STONE_SHOVEL_LV2,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV3));
		shovelRecipe(output, ScItems.COMPRESSED_STONE_SHOVEL_LV4,
				ScItems.COMPRESSED_STONE_SHOVEL_LV3,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV4));
		shovelRecipe(output, ScItems.COMPRESSED_STONE_SHOVEL_LV5,
				ScItems.COMPRESSED_STONE_SHOVEL_LV4,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV5));
		//endregion
		
		//region 锄
		hoeRecipe(output, ScItems.COMPRESSED_STONE_HOE_LV1,
				Items.STONE_HOE,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		hoeRecipe(output, ScItems.COMPRESSED_STONE_HOE_LV2,
				ScItems.COMPRESSED_STONE_HOE_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		hoeRecipe(output, ScItems.COMPRESSED_STONE_HOE_LV3,
				ScItems.COMPRESSED_STONE_HOE_LV2,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV3));
		hoeRecipe(output, ScItems.COMPRESSED_STONE_HOE_LV4,
				ScItems.COMPRESSED_STONE_HOE_LV3,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV4));
		hoeRecipe(output, ScItems.COMPRESSED_STONE_HOE_LV5,
				ScItems.COMPRESSED_STONE_HOE_LV4,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV5));
		//endregion
		//endregion
		
		//region 食物
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_APPLE, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.APPLE), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_BREAD, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.BREAD), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_CARROT, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.CARROT), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_KELP, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.KELP), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_MELON_SLICE, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.MELON_SLICE), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_POTATO, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.POTATO), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_COOKED_COD, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.COOKED_COD), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_COOKIE, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.COOKIE), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_GLOW_BERRIES, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.GLOW_BERRIES), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_COOKED_BEEF, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.COOKED_BEEF), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONE_SWEET_BERRIES, getIngredient(ItemTags.STONE_CRAFTING_MATERIALS), getIngredient(Items.SWEET_BERRIES), "stone_food");
		
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.STONICKERS, getIngredient(COMPRESSED_STONE_MATERIAL_LV1), getIngredient(Items.COOKIE), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.COMPRESSED_STONICKERS_LV1, getIngredient(COMPRESSED_STONE_MATERIAL_LV2), getIngredient(Items.COOKIE), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.COMPRESSED_STONICKERS_LV2, getIngredient(COMPRESSED_STONE_MATERIAL_LV3), getIngredient(Items.COOKIE), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.COMPRESSED_STONICKERS_LV3, getIngredient(COMPRESSED_STONE_MATERIAL_LV4), getIngredient(Items.COOKIE), "stone_food");
		coreFrameRecipe(output, RecipeCategory.FOOD, ScItems.COMPRESSED_STONICKERS_LV4, getIngredient(COMPRESSED_STONE_MATERIAL_LV5), getIngredient(Items.COOKIE), "stone_food");
		packedRecipes(output, RecipeCategory.FOOD, ScItems.COMPRESSED_STONICKERS_LV5, ScItems.COMPRESSED_STONICKERS_LV4, "stone_food");
		
		{
			var item = ScItems.STONE_HODGEPODGE;
			ShapelessBuilder.shaped(getLocation(getItemName(item)), RecipeCategory.FOOD, new ItemStack(item.get()))
					.requires(Items.BOWL)
					.requires(ScItems.STONE_APPLE)
					.requires(ScItems.STONE_BREAD)
					.requires(ScItems.STONE_CARROT)
					.requires(ScItems.STONE_KELP)
					.requires(ScItems.STONE_MELON_SLICE)
					.requires(ScItems.STONE_POTATO)
					.group("stone_food")
					.basicUnlockedBy()
					.save(output);
		}
		
		//endregion
		
		//region 材料
		ShapedBuilder.basicBuilder(output, ScItems.STONE_STAR, RecipeCategory.MISC,
				shapedBuilder -> shapedBuilder
						.define('*', COMPRESSED_STONE_MATERIAL_LV5)
						.pattern(" * ")
						.pattern("***")
						.pattern(" * "));
		ShapedBuilder.basicBuilder(output, Items.COBBLESTONE, RecipeCategory.MISC,
				shapedBuilder -> shapedBuilder
						.define('*', ScItems.STONE_NUGGET)
						.pattern("**")
						.pattern("**"));
		//endregion
		
		//region 盔甲
		helmetRecipe(output, ScItems.STONE_HELMET,
				null,
				getIngredient(ItemTags.STONE_CRAFTING_MATERIALS));
		chestplateRecipe(output, ScItems.STONE_CHESTPLATE,
				null,
				getIngredient(ItemTags.STONE_CRAFTING_MATERIALS));
		leggingsRecipe(output, ScItems.STONE_LEGGINGS,
				null,
				getIngredient(ItemTags.STONE_CRAFTING_MATERIALS));
		bootsRecipe(output, ScItems.STONE_BOOTS,
				null,
				getIngredient(ItemTags.STONE_CRAFTING_MATERIALS));
		
		helmetRecipe(output, ScItems.COMPRESSED_STONE_HELMET_LV1,
				ScItems.STONE_HELMET,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		chestplateRecipe(output, ScItems.COMPRESSED_STONE_CHESTPLATE_LV1,
				ScItems.STONE_CHESTPLATE,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		leggingsRecipe(output, ScItems.COMPRESSED_STONE_LEGGINGS_LV1,
				ScItems.STONE_LEGGINGS,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		bootsRecipe(output, ScItems.COMPRESSED_STONE_BOOTS_LV1,
				ScItems.STONE_BOOTS,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV1));
		
		helmetRecipe(output, ScItems.COMPRESSED_STONE_HELMET_LV2,
				ScItems.COMPRESSED_STONE_HELMET_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		chestplateRecipe(output, ScItems.COMPRESSED_STONE_CHESTPLATE_LV2,
				ScItems.COMPRESSED_STONE_CHESTPLATE_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		leggingsRecipe(output, ScItems.COMPRESSED_STONE_LEGGINGS_LV2,
				ScItems.COMPRESSED_STONE_LEGGINGS_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		bootsRecipe(output, ScItems.COMPRESSED_STONE_BOOTS_LV2,
				ScItems.COMPRESSED_STONE_BOOTS_LV1,
				getIngredient(COMPRESSED_STONE_MATERIAL_LV2));
		
		helmetRecipe(output, ScItems.COMPRESSED_STONE_HELMET_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(1)), "helmet");
		chestplateRecipe(output, ScItems.COMPRESSED_STONE_CHESTPLATE_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(1)), "chestplate");
		leggingsRecipe(output, ScItems.COMPRESSED_STONE_LEGGINGS_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(1)), "leggings");
		bootsRecipe(output, ScItems.COMPRESSED_STONE_BOOTS_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(1)), "boots");
		
		helmetRecipe(output, ScItems.COMPRESSED_STONE_HELMET_LV4,
				ScItems.COMPRESSED_STONE_HELMET_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(2)));
		chestplateRecipe(output, ScItems.COMPRESSED_STONE_CHESTPLATE_LV4,
				ScItems.COMPRESSED_STONE_CHESTPLATE_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(2)));
		leggingsRecipe(output, ScItems.COMPRESSED_STONE_LEGGINGS_LV4,
				ScItems.COMPRESSED_STONE_LEGGINGS_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(2)));
		bootsRecipe(output, ScItems.COMPRESSED_STONE_BOOTS_LV4,
				ScItems.COMPRESSED_STONE_BOOTS_LV3,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(2)));
		
		helmetRecipe(output, ScItems.COMPRESSED_STONE_HELMET_LV5,
				ScItems.COMPRESSED_STONE_HELMET_LV4,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(3)));
		chestplateRecipe(output, ScItems.COMPRESSED_STONE_CHESTPLATE_LV5,
				ScItems.COMPRESSED_STONE_CHESTPLATE_LV4,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(3)));
		leggingsRecipe(output, ScItems.COMPRESSED_STONE_LEGGINGS_LV5,
				ScItems.COMPRESSED_STONE_LEGGINGS_LV4,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(3)));
		bootsRecipe(output, ScItems.COMPRESSED_STONE_BOOTS_LV5,
				ScItems.COMPRESSED_STONE_BOOTS_LV4,
				getIngredient(ScItems.COMPRESSED_OBSIDIAN.get(3)));
		//endregion
		
		//region 方块
		ShapedBuilder.basicBuilder(output, ScItems.GLOWINGOBSIDIAN, RecipeCategory.BUILDING_BLOCKS, shapedBuilder -> shapedBuilder
				.define('*', Tags.Items.OBSIDIANS)
				.define('A', Items.REDSTONE)
				.define('B', Items.GLOWSTONE_DUST)
				.pattern("BAB")
				.pattern("A*A")
				.pattern("BAB")
				.setRecipesId(getLocation("%s_%d".formatted(getItemName(ScItems.GLOWINGOBSIDIAN), 1))
				));
		
		ShapedBuilder.basicBuilder(output, ScItems.GLOWINGOBSIDIAN, RecipeCategory.BUILDING_BLOCKS, shapedBuilder -> shapedBuilder
				.define('*', Tags.Items.OBSIDIANS)
				.define('A', Items.REDSTONE)
				.define('B', Items.GLOWSTONE_DUST)
				.pattern("ABA")
				.pattern("B*B")
				.pattern("ABA")
				.setRecipesId(getLocation("%s_%d".formatted(getItemName(ScItems.GLOWINGOBSIDIAN), 2))
				));
		//endregion
	}
	
	//region 预制方法
	public @NotNull ShapedBuilder buildingRecipeBuilder(ItemLike result) {
		return buildingRecipeBuilder(result, 1);
	}
	
	protected void helmetRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "helmet";
		helmetRecipe(recipeOutput, result, material, group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	protected void chestplateRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "chestplate";
		chestplateRecipe(recipeOutput, result, material, group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	protected void leggingsRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "leggings";
		leggingsRecipe(recipeOutput, result, material, group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	protected void bootsRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "boots";
		bootsRecipe(recipeOutput, result, material, group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	protected void versatileTool(RecipeOutput output,
			ItemLike upOneLevel, ItemLike result, ItemLike axe, ItemLike pickaxe, ItemLike shovel, ItemLike hoe) {
		final String groupName = "versatileTool";
		ShapedBuilder.basicBuilder(output, result, RecipeCategory.TOOLS, groupName,
				shapedBuilder -> shapedBuilder
						.define('A', axe)
						.define('P', pickaxe)
						.define('S', shovel)
						.define('I', Items.STICK)
						.define('H', hoe)
						.pattern("APH")
						.pattern(" I ")
						.pattern(" S "));
		if (upOneLevel == null) {
			return;
		}
		packedRecipes(output, RecipeCategory.TOOLS, result, upOneLevel, groupName);
	}
	
	protected <I extends ItemLike> void unpackedPackedRecipes(RecipeOutput output, ItemLike packed, List<I> unpacked) {
		ItemLike unpackedItem = unpacked.getFirst();
		final RecipeCategory category = RecipeCategory.BUILDING_BLOCKS;
		unpackedPackedRecipes(output, category, unpackedItem, null, category, packed, null);
		unpackedPackedRecipes(output, unpacked);
	}
	
	/**
	 * 创建一个解压和压缩的配方
	 */
	protected void unpackedPackedRecipes(RecipeOutput recipeOutput,
			RecipeCategory unpackedCategory, ItemLike unpacked, String unpackedGroup,
			RecipeCategory packedCategory, ItemLike packed, String packedGroup) {
		this.packedRecipes(recipeOutput, packedCategory, unpacked, packed, packedGroup);
		this.unpackedRecipes(recipeOutput, unpackedCategory, packed, unpacked, unpackedGroup);
	}
	
	/**
	 * 创建解压配方
	 */
	private void unpackedRecipes(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
			ItemLike requires, String recipeGroup) {
		ResourceLocation location = getLocation(getItemName(requires) + "_unpacked");
		ShapelessBuilder builder = ShapelessBuilder.shaped(location, category, result, 9);
		builder.requires(requires)
				.basicUnlockedBy()
				.group(recipeGroup)
				.save(recipeOutput);
	}
	
	protected <I extends ItemLike> void unpackedPackedRecipes(RecipeOutput output, List<I> material) {
		final RecipeCategory category = RecipeCategory.BUILDING_BLOCKS;
		for (int i = 0, deferredBlocksSize = material.size() - 1; i < deferredBlocksSize; i++) {
			I packed = material.get(i);
			I unpacked = material.get(i + 1);
			unpackedPackedRecipes(output, category, unpacked, null, category, packed, null);
		}
	}
	
	/**
	 * 矿物块类型压缩配方
	 */
	protected void packedRecipes(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
			ItemLike requires, String recipeGroup) {
		ResourceLocation location = getLocation(getItemName(requires) + "_packed");
		ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
		fullWrapPattern(builder);
		defineRequires(builder, Map.of('#', getIngredient(requires)))
				.clearCriteria()
				.basicUnlockedBy()
				.group(recipeGroup)
				.save(recipeOutput);
	}
	
	protected void swordRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "sword";
		swordRecipe(recipeOutput, result, material, getIngredient(Items.STICK), group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	/**
	 * 创建剑配方
	 */
	protected void swordRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
		swordFramePattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	protected void axeRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "axe";
		axeRecipe(recipeOutput, result, material, getIngredient(Items.STICK), group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	/**
	 * 创建斧头配方
	 */
	protected void axeRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
		axeFramePattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	protected void pickaxeRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "pickaxe";
		pickaxeRecipe(recipeOutput, result, material, getIngredient(Items.STICK), group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	/**
	 * 创建镐类配方
	 */
	protected void pickaxeRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
		pickaxeFramePattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	protected void shovelRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "shove";
		shovelRecipe(recipeOutput, result, material, getIngredient(Items.STICK), group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	/**
	 * 创建锹类配方
	 */
	protected void shovelRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
		shovelFramePattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	protected void hoeRecipe(RecipeOutput recipeOutput, ItemLike result, ItemLike manager, Ingredient material) {
		final RecipeCategory category = RecipeCategory.TOOLS;
		final String group = "hoe";
		hoeRecipe(recipeOutput, result, material, getIngredient(Items.STICK), group);
		if (manager == null) {
			return;
		}
		packedRecipes(recipeOutput, category, result, manager, group);
	}
	
	/**
	 * 创建锄类配方
	 */
	protected void hoeRecipe(RecipeOutput recipeOutput,
			ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.TOOLS, result);
		hoeFramePattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	protected void armorRecipe(RecipeOutput output,
			ItemLike helmet,
			ItemLike chestplate,
			ItemLike leggings,
			ItemLike boots,
			Ingredient requires) {
		if (helmet != null) {
			helmetRecipe(output, helmet, requires, "helmet");
		}
		if (chestplate != null) {
			chestplateRecipe(output, helmet, requires, "chestplate");
		}
		if (leggings != null) {
			leggingsRecipe(output, helmet, requires, "leggings");
		}
		if (boots != null) {
			bootsRecipe(output, helmet, requires, "boots");
		}
	}
	
	/**
	 * 创建头盔配方
	 */
	protected void helmetRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
		helmetPattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建胸甲配方
	 */
	protected void chestplateRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
		chestplatePattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建护腿配方
	 */
	protected void leggingsRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
		leggingsPattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建靴子配方
	 */
	protected void bootsRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
		bootsPattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	private @NotNull ResourceLocation getLocation(String unpackedName) {
		return ResourceLocation.fromNamespaceAndPath(modId, unpackedName);
	}
	
	public static @NotNull String getItemName(ItemLike itemLike) {
		return net.minecraft.data.recipes.RecipeProvider.getItemName(itemLike);
	}
	
	/**
	 * 创建盾牌配方
	 */
	protected void shieldRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, RecipeCategory.COMBAT, result);
		shieldPattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	/**
	 * 创建核心框架配方（如末影箱）
	 */
	protected void coreFrameRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
		coreFramePattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	/**
	 * 创建环形配方（如箱子）
	 */
	protected void circularFrameRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
			Ingredient requires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
		circularFramePattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建解压配方
	 */
	private void unpackedRecipes(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
			Ingredient requires, String requiresName, String recipeGroup) {
		ResourceLocation location = getLocation(requiresName + "_unpacked");
		ShapelessBuilder builder = ShapelessBuilder.shaped(location, category, result, 9);
		builder.requires(requires)
				.basicUnlockedBy()
				.group(recipeGroup)
				.save(recipeOutput);
	}
	
	/**
	 * 矿物块类型压缩配方
	 */
	protected void packedRecipes(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
			Ingredient requires, String requiresName, String recipeGroup) {
		ResourceLocation location = getLocation(requiresName + "_packed");
		ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
		fullWrapPattern(builder);
		requires(builder, Map.of('#', requires), recipeGroup, recipeOutput);
	}
	
	/**
	 * 创建3x3全包裹式配方（如矿物块）
	 */
	protected void fullWrapRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result,
			Ingredient requires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapedBuilder builder = ShapedBuilder.shaped(location, category, result);
		fullWrapPattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建一个单格物品的配方
	 */
	protected void singleRecipe(RecipeOutput recipeOutput, RecipeCategory category, ItemLike result, int count,
			Ingredient requires, String group) {
		ResourceLocation location = getLocation(getItemName(result));
		ShapelessBuilder builder = ShapelessBuilder.shaped(location, category, result, count);
		builder.requires(requires)
				.basicUnlockedBy()
				.group(group)
				.save(recipeOutput);
	}
	
	private void buildingBlockRecipe(RecipeOutput recipeOutput,
			ItemLike singlePlate,
			ItemLike stair,
			ItemLike fence,
			ItemLike fenceDoor,
			ItemLike trapdoor,
			ItemLike door,
			ItemLike pressurePlate,
			ItemLike button,
			Ingredient requires,
			Ingredient secondaryRequires
	) {
		if (singlePlate != null) {
			stairRecipe(recipeOutput, singlePlate, requires, "single_plate");
		}
		if (stair != null) {
			stairRecipe(recipeOutput, stair, requires, "stair");
		}
		if (fence != null) {
			fenceRecipe(recipeOutput, fence, requires, secondaryRequires, "fence");
		}
		if (fenceDoor != null) {
			fenceDoorRecipe(recipeOutput, fenceDoor, requires, secondaryRequires, "fence_door");
		}
		if (trapdoor != null) {
			trapdoorRecipe(recipeOutput, trapdoor, requires, "trapdoor");
		}
		if (door != null) {
			doorRecipe(recipeOutput, door, requires, "door");
		}
		if (pressurePlate != null) {
			pressurePlateRecipe(recipeOutput, pressurePlate, requires, "pressure_plate");
		}
		if (button != null) {
			singleRecipe(recipeOutput, RecipeCategory.BUILDING_BLOCKS, button, 1, requires, "button");
		}
	}
	
	/**
	 * 创建楼梯配方
	 */
	protected void stairRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ShapedBuilder builder = buildingRecipeBuilder(result, 4);
		stairPattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建栅栏配方
	 */
	protected void fenceRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ShapedBuilder builder = buildingRecipeBuilder(result, 3);
		fencePattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	/**
	 * 创建栅栏门配方
	 */
	protected void fenceDoorRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, Ingredient secondaryRequires, String group) {
		ShapedBuilder builder = buildingRecipeBuilder(result);
		fenceDoorPattern(builder);
		requires(builder, Map.of('#', requires, 'O', secondaryRequires), group, recipeOutput);
	}
	
	/**
	 * 创建活板门配方
	 */
	protected void trapdoorRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ShapedBuilder builder = buildingRecipeBuilder(result, 2);
		trapdoorPattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建台阶配方
	 */
	protected void singlePlateRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ShapedBuilder builder = buildingRecipeBuilder(result, 6);
		singlePlatePattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	public @NotNull ShapedBuilder buildingRecipeBuilder(ItemLike result, int count) {
		ResourceLocation location = getLocation(getItemName(result));
		return ShapedBuilder.shaped(location, RecipeCategory.BUILDING_BLOCKS, result, count);
	}
	
	/**
	 * 创建门配方
	 */
	protected void doorRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ShapedBuilder builder = buildingRecipeBuilder(result, 3);
		singlePlatePattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	
	/**
	 * 创建压力板配方
	 */
	protected void pressurePlateRecipe(RecipeOutput recipeOutput, ItemLike result,
			Ingredient requires, String group) {
		ShapedBuilder builder = buildingRecipeBuilder(result);
		singlePlatePattern(builder);
		requires(builder, Map.of('#', requires), group, recipeOutput);
	}
	//endregion
}
