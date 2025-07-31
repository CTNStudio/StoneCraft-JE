package ctn.stonecraft.datagen.tag;

import ctn.stonecraft.init.ScItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckForNull;
import java.util.concurrent.CompletableFuture;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.StoneCraft.path;
import static net.minecraft.tags.ItemTags.*;

public class ScItemTags extends ItemTagsProvider {
	public static final TagKey<Item> COMPRESSED_STONE_TOOL     = createTag("compressed_stone_tools_vl/compressed_tools");
	public static final TagKey<Item> COMPRESSED_STONE_TOOL_LV1 = createTag("compressed_stone_tools_vl/lv1");
	public static final TagKey<Item> COMPRESSED_STONE_TOOL_LV2 = createTag("compressed_stone_tools_vl/lv2");
	public static final TagKey<Item> COMPRESSED_STONE_TOOL_LV3 = createTag("compressed_stone_tools_vl/lv3");
	public static final TagKey<Item> COMPRESSED_STONE_TOOL_LV4 = createTag("compressed_stone_tools_vl/lv4");
	public static final TagKey<Item> COMPRESSED_STONE_TOOL_LV5 = createTag("compressed_stone_tools_vl/lv5");
	
	public static final TagKey<Item> VERSATILE_COMPRESSED_STONE_TOOL = createTag("compressed_tools/versatile");
	public static final TagKey<Item> VERSATILE_STONE_TOOL            = createTag("tools/versatile");
	
	public static final TagKey<Item> COMPRESSED_SWORD_TOOL          = createTag("compressed_tools/sword");
	public static final TagKey<Item> ULTIMATE_COMPRESSED_SWORD_TOOL = createTag("compressed_tools/ultimate_sword");
	public static final TagKey<Item> COMPRESSED_AXE_TOOL            = createTag("compressed_tools/axe");
	public static final TagKey<Item> COMPRESSED_PICKAXE_TOOL        = createTag("compressed_tools/pickaxe");
	public static final TagKey<Item> COMPRESSED_SHOVEL_TOOL         = createTag("compressed_tools/shovel");
	public static final TagKey<Item> COMPRESSED_HOE_TOOL            = createTag("compressed_tools/hoe");
	
	public static final TagKey<Item> COMPRESSED_BLOCK     = createTag("compressed_lv/compressed_blocks");
	public static final TagKey<Item> COMPRESSED_BLOCK_LV1 = createTag("compressed_lv/lv1");
	public static final TagKey<Item> COMPRESSED_BLOCK_LV2 = createTag("compressed_lv/lv2");
	public static final TagKey<Item> COMPRESSED_BLOCK_LV3 = createTag("compressed_lv/lv3");
	public static final TagKey<Item> COMPRESSED_BLOCK_LV4 = createTag("compressed_lv/lv4");
	public static final TagKey<Item> COMPRESSED_BLOCK_LV5 = createTag("compressed_lv/lv5");
	
	// 压缩石材料
	public static final TagKey<Item> COMPRESSED_STONE_MATERIAL     = createTag("material/compressed_stone");
	public static final TagKey<Item> COMPRESSED_STONE_MATERIAL_LV1 = createTag("material/compressed_stone_lv1");
	public static final TagKey<Item> COMPRESSED_STONE_MATERIAL_LV2 = createTag("material/compressed_stone_lv2");
	public static final TagKey<Item> COMPRESSED_STONE_MATERIAL_LV3 = createTag("material/compressed_stone_lv3");
	public static final TagKey<Item> COMPRESSED_STONE_MATERIAL_LV4 = createTag("material/compressed_stone_lv4");
	public static final TagKey<Item> COMPRESSED_STONE_MATERIAL_LV5 = createTag("material/compressed_stone_lv5");
	
	// 石头食物
	public static final TagKey<Item> STONE_FOOD                = createTag("stone_food");
	public static final TagKey<Item> COMPRESSED_STONE_FOOD     = createTag("compressed_stone_food");
	public static final TagKey<Item> COMPRESSED_STONE_FOOD_LV1 = createTag("compressed_stone_food_lv1");
	public static final TagKey<Item> COMPRESSED_STONE_FOOD_LV2 = createTag("compressed_stone_food_lv2");
	public static final TagKey<Item> COMPRESSED_STONE_FOOD_LV3 = createTag("compressed_stone_food_lv3");
	public static final TagKey<Item> COMPRESSED_STONE_FOOD_LV4 = createTag("compressed_stone_food_lv4");
	public static final TagKey<Item> COMPRESSED_STONE_FOOD_LV5 = createTag("compressed_stone_food_lv5");
	
	//region 压缩方块
	public static final TagKey<Item> COMPRESSED_COBBLESTONE       = createTag("compressed/cobblestone");
	public static final TagKey<Item> COMPRESSED_MOSSY_COBBLESTONE = createTag("compressed/mossy_cobblestone");
	public static final TagKey<Item> COMPRESSED_STONE             = createTag("compressed/stone");
	public static final TagKey<Item> COMPRESSED_GRANITE           = createTag("compressed/granite");
	public static final TagKey<Item> COMPRESSED_ANDESITE          = createTag("compressed/andesite");
	public static final TagKey<Item> COMPRESSED_DIORITE           = createTag("compressed/diorite");
	public static final TagKey<Item> COMPRESSED_BEDROCK           = createTag("compressed/bedrock");
	public static final TagKey<Item> COMPRESSED_END_STONE         = createTag("compressed/end_stone");
	public static final TagKey<Item> COMPRESSED_OBSIDIAN          = createTag("compressed/obsidian");
	public static final TagKey<Item> COMPRESSED_GLOWINGOBSIDIAN   = createTag("compressed/glowingobsidian");
	public static final TagKey<Item> COMPRESSED_CRYING_OBSIDIAN   = createTag("compressed/crying_obsidian");
	public static final TagKey<Item> COMPRESSED_PRISMARINE        = createTag("compressed/prismarine");
	public static final TagKey<Item> COMPRESSED_DARK_PRISMARINE   = createTag("compressed/dark_prismarine");
	public static final TagKey<Item> COMPRESSED_NETHERRACK        = createTag("compressed/netherrack");
	public static final TagKey<Item> COMPRESSED_GLOWSTONE         = createTag("compressed/glowstone");
	public static final TagKey<Item> COMPRESSED_BLACKSTONE        = createTag("compressed/blackstone");
	public static final TagKey<Item> COMPRESSED_CALCITE           = createTag("compressed/calcite");
	public static final TagKey<Item> COMPRESSED_DEEPSLATE         = createTag("compressed/deepslate");
	public static final TagKey<Item> COMPRESSED_COBBLED_DEEPSLATE = createTag("compressed/cobbled_deepslate");
	public static final TagKey<Item> COMPRESSED_BASALT            = createTag("compressed/basalt");
	public static final TagKey<Item> COMPRESSED_TUFF              = createTag("compressed/tuff");
	public static final TagKey<Item> COMPRESSED_DRIPSTONE_BLOCK   = createTag("compressed/dripstone_block");
	//endregion
	
	//region 装备
	public static final TagKey<Item> STONE_ARMOR                = createTag("armor/stone");
	public static final TagKey<Item> COMPRESSED_STONE_ARMOR     = createTag("armor/compressed_stone");
	public static final TagKey<Item> COMPRESSED_STONE_ARMOR_LV1 = createTag("armor/compressed_stone_lv1");
	public static final TagKey<Item> COMPRESSED_STONE_ARMOR_LV2 = createTag("armor/compressed_stone_lv2");
	public static final TagKey<Item> COMPRESSED_STONE_ARMOR_LV3 = createTag("armor/compressed_stone_lv3");
	public static final TagKey<Item> COMPRESSED_STONE_ARMOR_LV4 = createTag("armor/compressed_stone_lv4");
	public static final TagKey<Item> COMPRESSED_STONE_ARMOR_LV5 = createTag("armor/compressed_stone_lv5");
	
	public static final TagKey<Item> STONE_HELMET                = createTag("helmet/stone");
	public static final TagKey<Item> COMPRESSED_STONE_HELMET     = createTag("helmet/compressed_stone");
	public static final TagKey<Item> COMPRESSED_STONE_HELMET_LV1 = createTag("helmet/compressed_stone_lv1");
	public static final TagKey<Item> COMPRESSED_STONE_HELMET_LV2 = createTag("helmet/compressed_stone_lv2");
	public static final TagKey<Item> COMPRESSED_STONE_HELMET_LV3 = createTag("helmet/compressed_stone_lv3");
	public static final TagKey<Item> COMPRESSED_STONE_HELMET_LV4 = createTag("helmet/compressed_stone_lv4");
	public static final TagKey<Item> COMPRESSED_STONE_HELMET_LV5 = createTag("helmet/compressed_stone_lv5");
	
	public static final TagKey<Item> STONE_CHESTPLATE                = createTag("chestplate/stone");
	public static final TagKey<Item> COMPRESSED_STONE_CHESTPLATE     = createTag("chestplate/compressed_stone");
	public static final TagKey<Item> COMPRESSED_STONE_CHESTPLATE_LV1 = createTag("chestplate/compressed_stone_lv1");
	public static final TagKey<Item> COMPRESSED_STONE_CHESTPLATE_LV2 = createTag("chestplate/compressed_stone_lv2");
	public static final TagKey<Item> COMPRESSED_STONE_CHESTPLATE_LV3 = createTag("chestplate/compressed_stone_lv3");
	public static final TagKey<Item> COMPRESSED_STONE_CHESTPLATE_LV4 = createTag("chestplate/compressed_stone_lv4");
	public static final TagKey<Item> COMPRESSED_STONE_CHESTPLATE_LV5 = createTag("chestplate/compressed_stone_lv5");
	
	public static final TagKey<Item> STONE_LEGGINGS                = createTag("leggings/stone");
	public static final TagKey<Item> COMPRESSED_STONE_LEGGINGS     = createTag("leggings/compressed_stone");
	public static final TagKey<Item> COMPRESSED_STONE_LEGGINGS_LV1 = createTag("leggings/compressed_stone_lv1");
	public static final TagKey<Item> COMPRESSED_STONE_LEGGINGS_LV2 = createTag("leggings/compressed_stone_lv2");
	public static final TagKey<Item> COMPRESSED_STONE_LEGGINGS_LV3 = createTag("leggings/compressed_stone_lv3");
	public static final TagKey<Item> COMPRESSED_STONE_LEGGINGS_LV4 = createTag("leggings/compressed_stone_lv4");
	public static final TagKey<Item> COMPRESSED_STONE_LEGGINGS_LV5 = createTag("leggings/compressed_stone_lv5");
	
	public static final TagKey<Item> STONE_BOOTS                = createTag("boots/stone");
	public static final TagKey<Item> COMPRESSED_STONE_BOOTS     = createTag("boots/compressed_stone");
	public static final TagKey<Item> COMPRESSED_STONE_BOOTS_LV1 = createTag("boots/compressed_stone_lv1");
	public static final TagKey<Item> COMPRESSED_STONE_BOOTS_LV2 = createTag("boots/compressed_stone_lv2");
	public static final TagKey<Item> COMPRESSED_STONE_BOOTS_LV3 = createTag("boots/compressed_stone_lv3");
	public static final TagKey<Item> COMPRESSED_STONE_BOOTS_LV4 = createTag("boots/compressed_stone_lv4");
	public static final TagKey<Item> COMPRESSED_STONE_BOOTS_LV5 = createTag("boots/compressed_stone_lv5");
	//endregion
	
	public static final TagKey<Item> BASE_STONE_NETHER     = createMcTag("base_stone_nether");
	public static final TagKey<Item> BASE_STONE_OVERWORLD  = createMcTag("base_stone_overworld");
	public static final TagKey<Item> FALL_AWAY_STONE_NUGGE = createTag("fall_away_stone_nugget");
	
	// 根进度可触发物品
	public static final TagKey<Item> ADVANCEMENT_ROOT_ITEM         = createTag("advancement/root_item");
	public static final TagKey<Item> STONE_DESTROYER_EFFECT_BLOCKS = createTag("enchantment/stone_destroyer_effect_blocks");
	
	public ScItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
			CompletableFuture<TagLookup<Block>> blockTags, @CheckForNull ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTags, SC_ID, existingFileHelper);
	}
	
	protected static TagKey<Item> createTag(String name) {
		return ItemTags.create(path(name));
	}
	
	protected static TagKey<Item> createCTag(String name) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}
	
	protected static TagKey<Item> createMcTag(String name) {
		return ItemTags.create(ResourceLocation.withDefaultNamespace(name));
	}
	
	@Override
	protected void addTags(HolderLookup.@NotNull Provider capability) {
		tag(COMPRESSED_STONE_HELMET_LV1).add(ScItems.COMPRESSED_STONE_HELMET_LV1.get());
		tag(COMPRESSED_STONE_HELMET_LV2).add(ScItems.COMPRESSED_STONE_HELMET_LV2.get());
		tag(COMPRESSED_STONE_HELMET_LV3).add(ScItems.COMPRESSED_STONE_HELMET_LV3.get());
		tag(COMPRESSED_STONE_HELMET_LV4).add(ScItems.COMPRESSED_STONE_HELMET_LV4.get());
		tag(COMPRESSED_STONE_HELMET_LV5).add(ScItems.COMPRESSED_STONE_HELMET_LV5.get());
		tag(COMPRESSED_STONE_HELMET).addTags(
				COMPRESSED_STONE_HELMET_LV1,
				COMPRESSED_STONE_HELMET_LV2,
				COMPRESSED_STONE_HELMET_LV3,
				COMPRESSED_STONE_HELMET_LV4,
				COMPRESSED_STONE_HELMET_LV5);
		tag(STONE_HELMET).addTag(COMPRESSED_STONE_HELMET).add(ScItems.STONE_HELMET.get());
		
		tag(COMPRESSED_STONE_CHESTPLATE_LV1).add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get());
		tag(COMPRESSED_STONE_CHESTPLATE_LV2).add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get());
		tag(COMPRESSED_STONE_CHESTPLATE_LV3).add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get());
		tag(COMPRESSED_STONE_CHESTPLATE_LV4).add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get());
		tag(COMPRESSED_STONE_CHESTPLATE_LV5).add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get());
		tag(COMPRESSED_STONE_CHESTPLATE).addTags(
				COMPRESSED_STONE_CHESTPLATE_LV1,
				COMPRESSED_STONE_CHESTPLATE_LV2,
				COMPRESSED_STONE_CHESTPLATE_LV3,
				COMPRESSED_STONE_CHESTPLATE_LV4,
				COMPRESSED_STONE_CHESTPLATE_LV5);
		tag(STONE_CHESTPLATE).addTag(COMPRESSED_STONE_CHESTPLATE).add(ScItems.STONE_CHESTPLATE.get());
		
		tag(COMPRESSED_STONE_LEGGINGS_LV1).add(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get());
		tag(COMPRESSED_STONE_LEGGINGS_LV2).add(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get());
		tag(COMPRESSED_STONE_LEGGINGS_LV3).add(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get());
		tag(COMPRESSED_STONE_LEGGINGS_LV4).add(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get());
		tag(COMPRESSED_STONE_LEGGINGS_LV5).add(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get());
		tag(COMPRESSED_STONE_LEGGINGS).addTags(
				COMPRESSED_STONE_LEGGINGS_LV1,
				COMPRESSED_STONE_LEGGINGS_LV2,
				COMPRESSED_STONE_LEGGINGS_LV3,
				COMPRESSED_STONE_LEGGINGS_LV4,
				COMPRESSED_STONE_LEGGINGS_LV5);
		tag(STONE_LEGGINGS).addTag(COMPRESSED_STONE_LEGGINGS).add(ScItems.STONE_LEGGINGS.get());
		
		tag(COMPRESSED_STONE_BOOTS_LV1).add(ScItems.COMPRESSED_STONE_BOOTS_LV1.get());
		tag(COMPRESSED_STONE_BOOTS_LV2).add(ScItems.COMPRESSED_STONE_BOOTS_LV2.get());
		tag(COMPRESSED_STONE_BOOTS_LV3).add(ScItems.COMPRESSED_STONE_BOOTS_LV3.get());
		tag(COMPRESSED_STONE_BOOTS_LV4).add(ScItems.COMPRESSED_STONE_BOOTS_LV4.get());
		tag(COMPRESSED_STONE_BOOTS_LV5).add(ScItems.COMPRESSED_STONE_BOOTS_LV5.get());
		tag(COMPRESSED_STONE_BOOTS).addTags(
				COMPRESSED_STONE_BOOTS_LV1,
				COMPRESSED_STONE_BOOTS_LV2,
				COMPRESSED_STONE_BOOTS_LV3,
				COMPRESSED_STONE_BOOTS_LV4,
				COMPRESSED_STONE_BOOTS_LV5);
		tag(STONE_BOOTS).addTag(COMPRESSED_STONE_BOOTS).add(ScItems.STONE_BOOTS.get());
		
		tag(COMPRESSED_STONE_ARMOR_LV1).addTags(
				COMPRESSED_STONE_HELMET_LV1,
				COMPRESSED_STONE_CHESTPLATE_LV1,
				COMPRESSED_STONE_LEGGINGS_LV1,
				COMPRESSED_STONE_BOOTS_LV1);
		tag(COMPRESSED_STONE_ARMOR_LV2).addTags(
				COMPRESSED_STONE_HELMET_LV2,
				COMPRESSED_STONE_CHESTPLATE_LV2,
				COMPRESSED_STONE_LEGGINGS_LV2,
				COMPRESSED_STONE_BOOTS_LV2);
		tag(COMPRESSED_STONE_ARMOR_LV3).addTags(
				COMPRESSED_STONE_HELMET_LV3,
				COMPRESSED_STONE_CHESTPLATE_LV3,
				COMPRESSED_STONE_LEGGINGS_LV3,
				COMPRESSED_STONE_BOOTS_LV3);
		tag(COMPRESSED_STONE_ARMOR_LV4).addTags(
				COMPRESSED_STONE_HELMET_LV4,
				COMPRESSED_STONE_CHESTPLATE_LV4,
				COMPRESSED_STONE_LEGGINGS_LV4,
				COMPRESSED_STONE_BOOTS_LV4);
		tag(COMPRESSED_STONE_ARMOR_LV5).addTags(
				COMPRESSED_STONE_HELMET_LV5,
				COMPRESSED_STONE_CHESTPLATE_LV5,
				COMPRESSED_STONE_LEGGINGS_LV5,
				COMPRESSED_STONE_BOOTS_LV5);
		tag(COMPRESSED_STONE_ARMOR).addTags(
				COMPRESSED_STONE_ARMOR_LV1,
				COMPRESSED_STONE_ARMOR_LV2,
				COMPRESSED_STONE_ARMOR_LV3,
				COMPRESSED_STONE_ARMOR_LV4,
				COMPRESSED_STONE_ARMOR_LV5);
		tag(STONE_ARMOR).addTag(COMPRESSED_STONE_ARMOR);
		
		tag(FOOT_ARMOR).addTag(STONE_BOOTS);
		tag(LEG_ARMOR).addTag(STONE_LEGGINGS);
		tag(CHEST_ARMOR).addTag(STONE_CHESTPLATE);
		tag(HEAD_ARMOR).addTag(STONE_HELMET);
		tag(TRIMMABLE_ARMOR).addTag(STONE_ARMOR);
		
		tag(COMPRESSED_STONE_TOOL_LV1).add(
				ScItems.COMPRESSED_STONE_SWORD_LV1.get(),
				ScItems.COMPRESSED_STONE_AXE_LV1.get(),
				ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(),
				ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(),
				ScItems.COMPRESSED_STONE_HOE_LV1.get()
		);
		tag(COMPRESSED_STONE_TOOL_LV2).add(
				ScItems.COMPRESSED_STONE_SWORD_LV2.get(),
				ScItems.COMPRESSED_STONE_AXE_LV2.get(),
				ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(),
				ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(),
				ScItems.COMPRESSED_STONE_HOE_LV2.get()
		);
		tag(COMPRESSED_STONE_TOOL_LV3).add(
				ScItems.COMPRESSED_STONE_SWORD_LV3.get(),
				ScItems.COMPRESSED_STONE_AXE_LV3.get(),
				ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(),
				ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(),
				ScItems.COMPRESSED_STONE_HOE_LV3.get()
		);
		tag(COMPRESSED_STONE_TOOL_LV4).add(
				ScItems.COMPRESSED_STONE_SWORD_LV4.get(),
				ScItems.COMPRESSED_STONE_AXE_LV4.get(),
				ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(),
				ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(),
				ScItems.COMPRESSED_STONE_HOE_LV4.get()
		);
		tag(COMPRESSED_STONE_TOOL_LV5).add(
				ScItems.COMPRESSED_STONE_SWORD_LV5.get(),
				ScItems.COMPRESSED_STONE_AXE_LV5.get(),
				ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(),
				ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(),
				ScItems.COMPRESSED_STONE_HOE_LV5.get(),
				ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(),
				ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(),
				ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get()
		);
		tag(VERSATILE_COMPRESSED_STONE_TOOL).add(
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(),
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(),
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(),
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(),
				ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get()
		);
		tag(VERSATILE_STONE_TOOL)
				.addTag(VERSATILE_COMPRESSED_STONE_TOOL)
				.add(ScItems.VERSATILE_STONE_TOOL.get());
		tag(ULTIMATE_COMPRESSED_SWORD_TOOL).add(
				ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(),
				ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(),
				ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get()
		);
		tag(COMPRESSED_SWORD_TOOL)
				.addTag(ULTIMATE_COMPRESSED_SWORD_TOOL)
				.add(
						ScItems.COMPRESSED_STONE_SWORD_LV1.get(),
						ScItems.COMPRESSED_STONE_SWORD_LV2.get(),
						ScItems.COMPRESSED_STONE_SWORD_LV3.get(),
						ScItems.COMPRESSED_STONE_SWORD_LV4.get(),
						ScItems.COMPRESSED_STONE_SWORD_LV5.get()
				);
		tag(COMPRESSED_AXE_TOOL)
				.addTag(VERSATILE_COMPRESSED_STONE_TOOL)
				.add(
						ScItems.COMPRESSED_STONE_AXE_LV1.get(),
						ScItems.COMPRESSED_STONE_AXE_LV2.get(),
						ScItems.COMPRESSED_STONE_AXE_LV3.get(),
						ScItems.COMPRESSED_STONE_AXE_LV4.get(),
						ScItems.COMPRESSED_STONE_AXE_LV5.get()
				);
		tag(COMPRESSED_PICKAXE_TOOL)
				.addTag(VERSATILE_COMPRESSED_STONE_TOOL)
				.add(
						ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(),
						ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(),
						ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(),
						ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(),
						ScItems.COMPRESSED_STONE_PICKAXE_LV5.get()
				);
		tag(COMPRESSED_SHOVEL_TOOL)
				.addTag(VERSATILE_COMPRESSED_STONE_TOOL)
				.add(
						ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(),
						ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(),
						ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(),
						ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(),
						ScItems.COMPRESSED_STONE_SHOVEL_LV5.get()
				);
		tag(COMPRESSED_HOE_TOOL)
				.addTag(VERSATILE_COMPRESSED_STONE_TOOL)
				.add(
						ScItems.COMPRESSED_STONE_HOE_LV1.get(),
						ScItems.COMPRESSED_STONE_HOE_LV2.get(),
						ScItems.COMPRESSED_STONE_HOE_LV3.get(),
						ScItems.COMPRESSED_STONE_HOE_LV4.get(),
						ScItems.COMPRESSED_STONE_HOE_LV5.get()
				);
		tag(COMPRESSED_STONE_TOOL).addTags(
				COMPRESSED_SWORD_TOOL,
				COMPRESSED_AXE_TOOL,
				COMPRESSED_PICKAXE_TOOL,
				COMPRESSED_SHOVEL_TOOL,
				COMPRESSED_HOE_TOOL
		);
		tag(ItemTags.SWORDS).addTag(COMPRESSED_SWORD_TOOL);
		tag(ItemTags.AXES).addTags(
				COMPRESSED_AXE_TOOL,
				VERSATILE_STONE_TOOL
		);
		tag(ItemTags.PICKAXES).addTags(
				COMPRESSED_PICKAXE_TOOL,
				VERSATILE_STONE_TOOL
		);
		tag(ItemTags.CLUSTER_MAX_HARVESTABLES).addTags(
				COMPRESSED_PICKAXE_TOOL,
				VERSATILE_STONE_TOOL
		);
		tag(Tags.Items.MINING_TOOL_TOOLS).addTags(
				COMPRESSED_PICKAXE_TOOL,
				VERSATILE_STONE_TOOL
		);
		tag(Tags.Items.MELEE_WEAPON_TOOLS).addTags(
				COMPRESSED_SWORD_TOOL,
				COMPRESSED_AXE_TOOL
		);
		tag(ItemTags.SHOVELS).addTags(
				COMPRESSED_SHOVEL_TOOL,
				VERSATILE_STONE_TOOL
		);
		tag(ItemTags.HOES).addTags(
				COMPRESSED_HOE_TOOL,
				VERSATILE_STONE_TOOL
		);
		tag(Tags.Items.TOOLS).addTags(
				COMPRESSED_STONE_TOOL,
				VERSATILE_STONE_TOOL
		);
		copy(ScBlockTags.COMPRESSED_BLOCK_LV1, COMPRESSED_BLOCK_LV1);
		copy(ScBlockTags.COMPRESSED_BLOCK_LV2, COMPRESSED_BLOCK_LV2);
		copy(ScBlockTags.COMPRESSED_BLOCK_LV3, COMPRESSED_BLOCK_LV3);
		copy(ScBlockTags.COMPRESSED_BLOCK_LV4, COMPRESSED_BLOCK_LV4);
		copy(ScBlockTags.COMPRESSED_BLOCK_LV5, COMPRESSED_BLOCK_LV5);
		copy(ScBlockTags.COMPRESSED_BLOCK, COMPRESSED_BLOCK);
		copy(ScBlockTags.COMPRESSED_COBBLESTONE, COMPRESSED_COBBLESTONE);
		copy(ScBlockTags.COMPRESSED_MOSSY_COBBLESTONE, COMPRESSED_MOSSY_COBBLESTONE);
		copy(ScBlockTags.COMPRESSED_STONE, COMPRESSED_STONE);
		copy(ScBlockTags.COMPRESSED_GRANITE, COMPRESSED_GRANITE);
		copy(ScBlockTags.COMPRESSED_ANDESITE, COMPRESSED_ANDESITE);
		copy(ScBlockTags.COMPRESSED_DIORITE, COMPRESSED_DIORITE);
		copy(ScBlockTags.COMPRESSED_BEDROCK, COMPRESSED_BEDROCK);
		copy(ScBlockTags.COMPRESSED_END_STONE, COMPRESSED_END_STONE);
		copy(ScBlockTags.COMPRESSED_OBSIDIAN, COMPRESSED_OBSIDIAN);
		copy(ScBlockTags.COMPRESSED_GLOWINGOBSIDIAN, COMPRESSED_GLOWINGOBSIDIAN);
		copy(ScBlockTags.COMPRESSED_CRYING_OBSIDIAN, COMPRESSED_CRYING_OBSIDIAN);
		copy(ScBlockTags.COMPRESSED_PRISMARINE, COMPRESSED_PRISMARINE);
		copy(ScBlockTags.COMPRESSED_DARK_PRISMARINE, COMPRESSED_DARK_PRISMARINE);
		copy(ScBlockTags.COMPRESSED_NETHERRACK, COMPRESSED_NETHERRACK);
		copy(ScBlockTags.COMPRESSED_GLOWSTONE, COMPRESSED_GLOWSTONE);
		copy(ScBlockTags.COMPRESSED_BLACKSTONE, COMPRESSED_BLACKSTONE);
		copy(ScBlockTags.COMPRESSED_CALCITE, COMPRESSED_CALCITE);
		copy(ScBlockTags.COMPRESSED_DEEPSLATE, COMPRESSED_DEEPSLATE);
		copy(ScBlockTags.COMPRESSED_COBBLED_DEEPSLATE, COMPRESSED_COBBLED_DEEPSLATE);
		copy(ScBlockTags.COMPRESSED_BASALT, COMPRESSED_BASALT);
		copy(ScBlockTags.COMPRESSED_TUFF, COMPRESSED_TUFF);
		copy(ScBlockTags.COMPRESSED_DRIPSTONE_BLOCK, COMPRESSED_DRIPSTONE_BLOCK);
		
		tag(COMPRESSED_STONE_MATERIAL).addTags(
				COMPRESSED_COBBLESTONE,
				COMPRESSED_GRANITE,
				COMPRESSED_ANDESITE,
				COMPRESSED_DIORITE,
				COMPRESSED_END_STONE,
				COMPRESSED_NETHERRACK,
				COMPRESSED_BLACKSTONE,
				COMPRESSED_CALCITE,
				COMPRESSED_COBBLED_DEEPSLATE,
				COMPRESSED_BASALT,
				COMPRESSED_TUFF,
				COMPRESSED_DRIPSTONE_BLOCK
		);
		tag(COMPRESSED_STONE_MATERIAL_LV1).add(
				ScItems.COMPRESSED_COBBLESTONE.getFirst().get(),
				ScItems.COMPRESSED_GRANITE.getFirst().get(),
				ScItems.COMPRESSED_ANDESITE.getFirst().get(),
				ScItems.COMPRESSED_DIORITE.getFirst().get(),
				ScItems.COMPRESSED_END_STONE.getFirst().get(),
				ScItems.COMPRESSED_NETHERRACK.getFirst().get(),
				ScItems.COMPRESSED_BLACKSTONE.getFirst().get(),
				ScItems.COMPRESSED_CALCITE.getFirst().get(),
				ScItems.COMPRESSED_COBBLED_DEEPSLATE.getFirst().get(),
				ScItems.COMPRESSED_BASALT.getFirst().get(),
				ScItems.COMPRESSED_TUFF.getFirst().get(),
				ScItems.COMPRESSED_DRIPSTONE_BLOCK.getFirst().get()
		);
		tag(COMPRESSED_STONE_MATERIAL_LV2).add(
				ScItems.COMPRESSED_COBBLESTONE.get(1).get(),
				ScItems.COMPRESSED_GRANITE.get(1).get(),
				ScItems.COMPRESSED_ANDESITE.get(1).get(),
				ScItems.COMPRESSED_DIORITE.get(1).get(),
				ScItems.COMPRESSED_END_STONE.get(1).get(),
				ScItems.COMPRESSED_NETHERRACK.get(1).get(),
				ScItems.COMPRESSED_BLACKSTONE.get(1).get(),
				ScItems.COMPRESSED_CALCITE.get(1).get(),
				ScItems.COMPRESSED_COBBLED_DEEPSLATE.get(1).get(),
				ScItems.COMPRESSED_BASALT.get(1).get(),
				ScItems.COMPRESSED_TUFF.get(1).get(),
				ScItems.COMPRESSED_DRIPSTONE_BLOCK.get(1).get()
		);
		tag(COMPRESSED_STONE_MATERIAL_LV3).add(
				ScItems.COMPRESSED_COBBLESTONE.get(2).get(),
				ScItems.COMPRESSED_GRANITE.get(2).get(),
				ScItems.COMPRESSED_ANDESITE.get(2).get(),
				ScItems.COMPRESSED_DIORITE.get(2).get(),
				ScItems.COMPRESSED_END_STONE.get(2).get(),
				ScItems.COMPRESSED_NETHERRACK.get(2).get(),
				ScItems.COMPRESSED_BLACKSTONE.get(2).get(),
				ScItems.COMPRESSED_CALCITE.get(2).get(),
				ScItems.COMPRESSED_COBBLED_DEEPSLATE.get(2).get(),
				ScItems.COMPRESSED_BASALT.get(2).get(),
				ScItems.COMPRESSED_TUFF.get(2).get(),
				ScItems.COMPRESSED_DRIPSTONE_BLOCK.get(2).get()
		);
		tag(COMPRESSED_STONE_MATERIAL_LV4).add(
				ScItems.COMPRESSED_COBBLESTONE.get(3).get(),
				ScItems.COMPRESSED_GRANITE.get(3).get(),
				ScItems.COMPRESSED_ANDESITE.get(3).get(),
				ScItems.COMPRESSED_DIORITE.get(3).get(),
				ScItems.COMPRESSED_END_STONE.get(3).get(),
				ScItems.COMPRESSED_NETHERRACK.get(3).get(),
				ScItems.COMPRESSED_BLACKSTONE.get(3).get(),
				ScItems.COMPRESSED_CALCITE.get(3).get(),
				ScItems.COMPRESSED_COBBLED_DEEPSLATE.get(3).get(),
				ScItems.COMPRESSED_BASALT.get(3).get(),
				ScItems.COMPRESSED_TUFF.get(3).get(),
				ScItems.COMPRESSED_DRIPSTONE_BLOCK.get(3).get()
		);
		tag(COMPRESSED_STONE_MATERIAL_LV5).add(
				ScItems.COMPRESSED_COBBLESTONE.get(4).get(),
				ScItems.COMPRESSED_GRANITE.get(4).get(),
				ScItems.COMPRESSED_ANDESITE.get(4).get(),
				ScItems.COMPRESSED_DIORITE.get(4).get(),
				ScItems.COMPRESSED_END_STONE.get(4).get(),
				ScItems.COMPRESSED_NETHERRACK.get(4).get(),
				ScItems.COMPRESSED_BLACKSTONE.get(4).get(),
				ScItems.COMPRESSED_CALCITE.get(4).get(),
				ScItems.COMPRESSED_COBBLED_DEEPSLATE.get(4).get(),
				ScItems.COMPRESSED_BASALT.get(4).get(),
				ScItems.COMPRESSED_TUFF.get(4).get(),
				ScItems.COMPRESSED_DRIPSTONE_BLOCK.get(4).get()
		);
		
		tag(COMPRESSED_STONE_FOOD_LV1).add(ScItems.COMPRESSED_STONICKERS_LV1.get());
		tag(COMPRESSED_STONE_FOOD_LV2).add(ScItems.COMPRESSED_STONICKERS_LV2.get());
		tag(COMPRESSED_STONE_FOOD_LV3).add(ScItems.COMPRESSED_STONICKERS_LV3.get());
		tag(COMPRESSED_STONE_FOOD_LV4).add(ScItems.COMPRESSED_STONICKERS_LV4.get());
		tag(COMPRESSED_STONE_FOOD_LV5).add(ScItems.COMPRESSED_STONICKERS_LV5.get());
		tag(COMPRESSED_STONE_FOOD).addTags(
				COMPRESSED_STONE_FOOD_LV1,
				COMPRESSED_STONE_FOOD_LV2,
				COMPRESSED_STONE_FOOD_LV3,
				COMPRESSED_STONE_FOOD_LV4,
				COMPRESSED_STONE_FOOD_LV5
		);
		tag(STONE_FOOD).add(
				ScItems.STONE_APPLE.get(),
				ScItems.STONE_BREAD.get(),
				ScItems.STONE_CARROT.get(),
				ScItems.STONE_KELP.get(),
				ScItems.STONE_MELON_SLICE.get(),
				ScItems.STONE_POTATO.get(),
				ScItems.STONE_HODGEPODGE.get(),
				ScItems.STONICKERS.get(),
				ScItems.STONE_COOKED_COD.get(),
				ScItems.STONE_COOKIE.get(),
				ScItems.STONE_COOKED_BEEF.get(),
				ScItems.STONE_GLOW_BERRIES.get(),
				ScItems.STONE_SWEET_BERRIES.get()
		).addTag(COMPRESSED_STONE_FOOD);
		tag(WOLF_FOOD).addTag(STONE_FOOD);
		
		copy(BlockTags.BASE_STONE_NETHER, BASE_STONE_NETHER);
		copy(BlockTags.BASE_STONE_OVERWORLD, BASE_STONE_OVERWORLD);
		copy(ScBlockTags.FALL_AWAY_STONE_NUGGET, FALL_AWAY_STONE_NUGGE);
		
		copy(ScBlockTags.STONE_DESTROYER_EFFECT_BLOCKS, STONE_DESTROYER_EFFECT_BLOCKS);
		copy(ScBlockTags.ADVANCEMENT_ROOT_BLOCK, ADVANCEMENT_ROOT_ITEM);
	}
}