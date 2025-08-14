package ctn.stonecraft.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static ctn.stonecraft.StoneCraft.path;

/**
 * @author wang_
 * @version 2024.3.4.1
 * @description
 * @date 2025/8/3
 */
public class ScTags {
	public static class ScItems {
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
		public static final TagKey<Item> BREAKABLE_BY_STONE_NUGGET     = createTag("breakable_by_stone_nugget");
		public static final TagKey<Item> STONE_DESTROYER_EFFECT_BLOCKS = createTag("enchantment/stone_destroyer_effect_blocks");
		
		public static final TagKey<Item> STONE_NUGGET = createCTag("stone_nugget");
		
		public static final TagKey<Item> SLINGSHOT = createTag("slingshot");
		
		protected static TagKey<Item> createTag(String name) {
			return ItemTags.create(path(name));
		}
		
		protected static TagKey<Item> createCTag(String name) {
			return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
		}
		
		protected static TagKey<Item> createMcTag(String name) {
			return ItemTags.create(ResourceLocation.withDefaultNamespace(name));
		}
	}
	
	public static class ScBlocks {
		public static final TagKey<Block> COMPRESSED_BLOCK     = createTag("compressed_lv/compressed_blocks");
		public static final TagKey<Block> COMPRESSED_BLOCK_LV1 = createTag("compressed_lv/lv1");
		public static final TagKey<Block> COMPRESSED_BLOCK_LV2 = createTag("compressed_lv/lv2");
		public static final TagKey<Block> COMPRESSED_BLOCK_LV3 = createTag("compressed_lv/lv3");
		public static final TagKey<Block> COMPRESSED_BLOCK_LV4 = createTag("compressed_lv/lv4");
		public static final TagKey<Block> COMPRESSED_BLOCK_LV5 = createTag("compressed_lv/lv5");
		
		public static final TagKey<Block> COMPRESSED_COBBLESTONE       = createTag("compressed/cobblestone");
		public static final TagKey<Block> COMPRESSED_MOSSY_COBBLESTONE = createTag("compressed/mossy_cobblestone");
		public static final TagKey<Block> COMPRESSED_STONE             = createTag("compressed/stone");
		public static final TagKey<Block> COMPRESSED_GRANITE           = createTag("compressed/granite");
		public static final TagKey<Block> COMPRESSED_ANDESITE          = createTag("compressed/andesite");
		public static final TagKey<Block> COMPRESSED_DIORITE           = createTag("compressed/diorite");
		public static final TagKey<Block> COMPRESSED_BEDROCK           = createTag("compressed/bedrock");
		public static final TagKey<Block> COMPRESSED_END_STONE         = createTag("compressed/end_stone");
		public static final TagKey<Block> COMPRESSED_OBSIDIAN          = createTag("compressed/obsidian");
		public static final TagKey<Block> COMPRESSED_GLOWINGOBSIDIAN   = createTag("compressed/glowingobsidian");
		public static final TagKey<Block> COMPRESSED_CRYING_OBSIDIAN   = createTag("compressed/crying_obsidian");
		public static final TagKey<Block> COMPRESSED_PRISMARINE        = createTag("compressed/prismarine");
		public static final TagKey<Block> COMPRESSED_DARK_PRISMARINE   = createTag("compressed/dark_prismarine");
		public static final TagKey<Block> COMPRESSED_NETHERRACK        = createTag("compressed/netherrack");
		public static final TagKey<Block> COMPRESSED_GLOWSTONE         = createTag("compressed/glowstone");
		public static final TagKey<Block> COMPRESSED_BLACKSTONE        = createTag("compressed/blackstone");
		public static final TagKey<Block> COMPRESSED_CALCITE           = createTag("compressed/calcite");
		public static final TagKey<Block> COMPRESSED_DEEPSLATE         = createTag("compressed/deepslate");
		public static final TagKey<Block> COMPRESSED_COBBLED_DEEPSLATE = createTag("compressed/cobbled_deepslate");
		public static final TagKey<Block> COMPRESSED_BASALT            = createTag("compressed/basalt");
		public static final TagKey<Block> COMPRESSED_TUFF              = createTag("compressed/tuff");
		public static final TagKey<Block> COMPRESSED_DRIPSTONE_BLOCK   = createTag("compressed/dripstone_block");
		
		public static final TagKey<Block> MINEABLE_WITH_VERSATILE = createTag("mineable/versatile");
		
		// 可以掉落石粒的方块
		public static final TagKey<Block> FALL_AWAY_STONE_NUGGET        = createTag("fall_away_stone_nugget");
		// 可以受到 石力挖掘 附魔影响的方块
		public static final TagKey<Block> STONE_DESTROYER_EFFECT_BLOCKS = createTag("enchantment/stone_destroyer_effect_blocks");
		// 受到 石之缓冲 附魔免疫影响的方块
		public static final TagKey<Block> STONE_BUFFER_EFFECT_BLOCKS    = createTag("enchantment/stone_buffer_effect_blocks");
		// 根进度可触发方块
		public static final TagKey<Block> ADVANCEMENT_ROOT_BLOCK        = createTag("advancement/root_block");
		// 可以被石粒破坏的方块
		public static final TagKey<Block> BREAKABLE_BY_STONE_NUGGET     = createTag("breakable_by_stone_nugget");
		
		protected static TagKey<Block> createTag(String name) {
			return BlockTags.create(path(name));
		}
		
		protected static TagKey<Block> createCTag(String name) {
			return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
		}
		
		protected static TagKey<Block> createMcTag(String name) {
			return BlockTags.create(ResourceLocation.withDefaultNamespace(name));
		}
	}
	
	public static class ScEntityTypes {
		protected static TagKey<EntityType<?>> createTag(String name) {
			return TagKey.create(Registries.ENTITY_TYPE, path(name));
		}
	}
	
	public static class ScEnchantmentTags {
	
	}
}
