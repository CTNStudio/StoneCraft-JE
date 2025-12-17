package ctn.stonecraft.init;

import ctn.stonecraft.common.blocks.stone_converting_table.StoneConvertingTable;
import ctn.stonecraft.common.blocks.stone_crafting_table.StoneCraftingTable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CryingObsidianBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static ctn.stonecraft.core.StoneCraft.ID;

public class ScBlocks {
	public static final DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(ID);
	public static final List<DeferredBlock<Block>> COMPRESSED_COBBLESTONE       = registerGradeBlock("compressed_cobblestone_lv", Blocks.COBBLESTONE, 2, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_MOSSY_COBBLESTONE = registerGradeBlock("compressed_mossy_cobblestone_lv", Blocks.MOSSY_COBBLESTONE, 2, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_STONE             = registerGradeBlock("compressed_stone_lv", Blocks.STONE, 1.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_GRANITE           = registerGradeBlock("compressed_granite_lv", Blocks.GRANITE, 1.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_ANDESITE          = registerGradeBlock("compressed_andesite_lv", Blocks.ANDESITE, 1.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_DIORITE           = registerGradeBlock("compressed_diorite_lv", Blocks.DIORITE, 1.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_BEDROCK           = registerGradeBlock("compressed_bedrock_lv", Blocks.BEDROCK, -1, 3600000);
	public static final List<DeferredBlock<Block>> COMPRESSED_END_STONE         = registerGradeBlock("compressed_end_stone_lv", Blocks.END_STONE, 3, 9);
	public static final List<DeferredBlock<Block>> COMPRESSED_OBSIDIAN          = registerGradeBlock("compressed_obsidian_lv", Blocks.OBSIDIAN, 50, 1200);
	public static final DeferredBlock<Block>       GLOWINGOBSIDIAN              = registerBlock("glowingobsidian", Block::new, BlockBehaviour.Properties.ofLegacyCopy(Blocks.CRYING_OBSIDIAN).requiresCorrectToolForDrops().strength(50, 1200));
	public static final List<DeferredBlock<Block>> COMPRESSED_GLOWINGOBSIDIAN   = registerGradeBlock("compressed_glowingobsidian_lv", Blocks.CRYING_OBSIDIAN, 50, 1200);
	public static final List<DeferredBlock<Block>> COMPRESSED_CRYING_OBSIDIAN   = registerGradeBlock("compressed_crying_obsidian_lv", Blocks.CRYING_OBSIDIAN, CryingObsidianBlock::new, 50, 1200);
	public static final List<DeferredBlock<Block>> COMPRESSED_PRISMARINE        = registerGradeBlock("compressed_prismarine_lv", Blocks.PRISMARINE, 1.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_DARK_PRISMARINE   = registerGradeBlock("compressed_dark_prismarine_lv", Blocks.DARK_PRISMARINE, 1.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_NETHERRACK        = registerGradeBlock("compressed_netherrack_lv", Blocks.NETHERRACK, 0.4f, 0.4f);
	public static final List<DeferredBlock<Block>> COMPRESSED_GLOWSTONE         = registerGradeBlock("compressed_glowstone_lv", Blocks.GLOWSTONE, 0.3f, 0.3f);
	public static final List<DeferredBlock<Block>> COMPRESSED_BLACKSTONE        = registerGradeBlock("compressed_blackstone_lv", Blocks.BLACKSTONE, 1.5f, 6f);
	public static final List<DeferredBlock<Block>> COMPRESSED_CALCITE           = registerGradeBlock("compressed_calcite_lv", Blocks.CALCITE, 0.75f, 0.75f);
	public static final List<DeferredBlock<Block>> COMPRESSED_DEEPSLATE         = registerGradeBlock("compressed_deepslate_lv", Blocks.DEEPSLATE, 3, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_COBBLED_DEEPSLATE = registerGradeBlock("compressed_cobbled_deepslate_lv", Blocks.COBBLED_DEEPSLATE, 3.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_BASALT            = registerGradeBlock("compressed_basalt_lv", Blocks.BASALT, 1.25f, 4.2f);
	public static final List<DeferredBlock<Block>> COMPRESSED_TUFF              = registerGradeBlock("compressed_tuff_lv", Blocks.TUFF, 1.5f, 6);
	public static final List<DeferredBlock<Block>> COMPRESSED_DRIPSTONE_BLOCK   = registerGradeBlock("compressed_dripstone_block_lv", Blocks.DRIPSTONE_BLOCK, 1.5f, 6);

  // region 工具方块

  // 石质工作台
  public static final DeferredBlock<Block> STONE_CRAFTING_TABLE = registerBlock("stone_crafting_table", StoneCraftingTable::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.5f).sound(SoundType.STONE));
  // 石头转换台
  public static final DeferredBlock<Block> STONE_CONVERTING_TABLE = registerBlock("stone_converting_table", StoneConvertingTable::new, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(2.5f).sound((SoundType.STONE)));
  //endregion

	private static <B extends Block> List<DeferredBlock<B>> registerGradeBlock(@NotNull String name, Block block,
			Function<BlockBehaviour.Properties, ? extends B> func, float destroyTime, float explosionResistance) {
		return registerGradeBlock(name, block, func, destroyTime, explosionResistance, 5);
	}

	private static <B extends Block> List<DeferredBlock<B>> registerGradeBlock(@NotNull String name, Block block,
			Function<BlockBehaviour.Properties, ? extends B> func,
			float destroyTime, float explosionResistance, int count) {
		if (count <= 0) {
			return List.of();
		}
		List<DeferredBlock<B>> blocks = new ArrayList<>(count - 1);
		for (int i = 1; i <= count; i++) {
			float currentDestroyTime = destroyTime <= 0 ? destroyTime : destroyTime * i * 0.2f * 9;
			float currentExplosionResistance = explosionResistance * i * 9 * 0.35f;
			blocks.add(registerBlock(name + i, func,
					BlockBehaviour.Properties.ofLegacyCopy(block).requiresCorrectToolForDrops()
							.strength(currentDestroyTime, currentExplosionResistance <= 0 ? Float.MAX_VALUE : currentExplosionResistance)));
		}
		return Collections.unmodifiableList(blocks);
	}

	private static <B extends Block> DeferredBlock<B> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends B> func, BlockBehaviour.Properties props) {
		return REGISTER.registerBlock(name, func, props);
	}

	private static List<DeferredBlock<Block>> registerGradeBlock(@NotNull String name, Block block, float destroyTime, float explosionResistance) {
		return registerGradeBlock(name, block, Block::new, destroyTime, explosionResistance, 5);
	}
}
