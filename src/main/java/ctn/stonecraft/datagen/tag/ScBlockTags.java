package ctn.stonecraft.datagen.tag;

import ctn.stonecraft.init.ScBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.datagen.ScTags.ScBlocks.*;

public class ScBlockTags extends BlockTagsProvider {
	public ScBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @CheckForNull ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, SC_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags(HolderLookup.@NotNull Provider capability) {
		tag(MINEABLE_WITH_VERSATILE).addTags(
				BlockTags.MINEABLE_WITH_AXE,
				BlockTags.MINEABLE_WITH_HOE,
				BlockTags.MINEABLE_WITH_PICKAXE,
				BlockTags.MINEABLE_WITH_SHOVEL
		);
		tag(COMPRESSED_BLOCK_LV1).add(
				ScBlocks.COMPRESSED_COBBLESTONE.get(0).get(),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(0).get(),
				ScBlocks.COMPRESSED_STONE.get(0).get(),
				ScBlocks.COMPRESSED_GRANITE.get(0).get(),
				ScBlocks.COMPRESSED_ANDESITE.get(0).get(),
				ScBlocks.COMPRESSED_DIORITE.get(0).get(),
				ScBlocks.COMPRESSED_BEDROCK.get(0).get(),
				ScBlocks.COMPRESSED_END_STONE.get(0).get(),
				ScBlocks.COMPRESSED_OBSIDIAN.get(0).get(),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(0).get(),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(0).get(),
				ScBlocks.COMPRESSED_PRISMARINE.get(0).get(),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(0).get(),
				ScBlocks.COMPRESSED_NETHERRACK.get(0).get(),
				ScBlocks.COMPRESSED_GLOWSTONE.get(0).get(),
				ScBlocks.COMPRESSED_BLACKSTONE.get(0).get(),
				ScBlocks.COMPRESSED_CALCITE.get(0).get(),
				ScBlocks.COMPRESSED_DEEPSLATE.get(0).get(),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(0).get(),
				ScBlocks.COMPRESSED_BASALT.get(0).get(),
				ScBlocks.COMPRESSED_TUFF.get(0).get(),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(0).get()
		);
		tag(COMPRESSED_BLOCK_LV2).add(
				ScBlocks.COMPRESSED_COBBLESTONE.get(1).get(),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(1).get(),
				ScBlocks.COMPRESSED_STONE.get(1).get(),
				ScBlocks.COMPRESSED_GRANITE.get(1).get(),
				ScBlocks.COMPRESSED_ANDESITE.get(1).get(),
				ScBlocks.COMPRESSED_DIORITE.get(1).get(),
				ScBlocks.COMPRESSED_BEDROCK.get(1).get(),
				ScBlocks.COMPRESSED_END_STONE.get(1).get(),
				ScBlocks.COMPRESSED_OBSIDIAN.get(1).get(),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(1).get(),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(1).get(),
				ScBlocks.COMPRESSED_PRISMARINE.get(1).get(),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(1).get(),
				ScBlocks.COMPRESSED_NETHERRACK.get(1).get(),
				ScBlocks.COMPRESSED_GLOWSTONE.get(1).get(),
				ScBlocks.COMPRESSED_BLACKSTONE.get(1).get(),
				ScBlocks.COMPRESSED_CALCITE.get(1).get(),
				ScBlocks.COMPRESSED_DEEPSLATE.get(1).get(),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(1).get(),
				ScBlocks.COMPRESSED_BASALT.get(1).get(),
				ScBlocks.COMPRESSED_TUFF.get(1).get(),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(1).get()
		);
		tag(COMPRESSED_BLOCK_LV3).add(
				ScBlocks.COMPRESSED_COBBLESTONE.get(2).get(),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(2).get(),
				ScBlocks.COMPRESSED_STONE.get(2).get(),
				ScBlocks.COMPRESSED_GRANITE.get(2).get(),
				ScBlocks.COMPRESSED_ANDESITE.get(2).get(),
				ScBlocks.COMPRESSED_DIORITE.get(2).get(),
				ScBlocks.COMPRESSED_BEDROCK.get(2).get(),
				ScBlocks.COMPRESSED_END_STONE.get(2).get(),
				ScBlocks.COMPRESSED_OBSIDIAN.get(2).get(),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(2).get(),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(2).get(),
				ScBlocks.COMPRESSED_PRISMARINE.get(2).get(),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(2).get(),
				ScBlocks.COMPRESSED_NETHERRACK.get(2).get(),
				ScBlocks.COMPRESSED_GLOWSTONE.get(2).get(),
				ScBlocks.COMPRESSED_BLACKSTONE.get(2).get(),
				ScBlocks.COMPRESSED_CALCITE.get(2).get(),
				ScBlocks.COMPRESSED_DEEPSLATE.get(2).get(),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(2).get(),
				ScBlocks.COMPRESSED_BASALT.get(2).get(),
				ScBlocks.COMPRESSED_TUFF.get(2).get(),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(2).get()
		);
		tag(COMPRESSED_BLOCK_LV4).add(
				ScBlocks.COMPRESSED_COBBLESTONE.get(3).get(),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(3).get(),
				ScBlocks.COMPRESSED_STONE.get(3).get(),
				ScBlocks.COMPRESSED_GRANITE.get(3).get(),
				ScBlocks.COMPRESSED_ANDESITE.get(3).get(),
				ScBlocks.COMPRESSED_DIORITE.get(3).get(),
				ScBlocks.COMPRESSED_BEDROCK.get(3).get(),
				ScBlocks.COMPRESSED_END_STONE.get(3).get(),
				ScBlocks.COMPRESSED_OBSIDIAN.get(3).get(),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(3).get(),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(3).get(),
				ScBlocks.COMPRESSED_PRISMARINE.get(3).get(),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(3).get(),
				ScBlocks.COMPRESSED_NETHERRACK.get(3).get(),
				ScBlocks.COMPRESSED_GLOWSTONE.get(3).get(),
				ScBlocks.COMPRESSED_BLACKSTONE.get(3).get(),
				ScBlocks.COMPRESSED_CALCITE.get(3).get(),
				ScBlocks.COMPRESSED_DEEPSLATE.get(3).get(),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(3).get(),
				ScBlocks.COMPRESSED_BASALT.get(3).get(),
				ScBlocks.COMPRESSED_TUFF.get(3).get(),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(3).get()
		);
		tag(COMPRESSED_BLOCK_LV5).add(
				ScBlocks.COMPRESSED_COBBLESTONE.get(4).get(),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(4).get(),
				ScBlocks.COMPRESSED_STONE.get(4).get(),
				ScBlocks.COMPRESSED_GRANITE.get(4).get(),
				ScBlocks.COMPRESSED_ANDESITE.get(4).get(),
				ScBlocks.COMPRESSED_DIORITE.get(4).get(),
				ScBlocks.COMPRESSED_BEDROCK.get(4).get(),
				ScBlocks.COMPRESSED_END_STONE.get(4).get(),
				ScBlocks.COMPRESSED_OBSIDIAN.get(4).get(),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(4).get(),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(4).get(),
				ScBlocks.COMPRESSED_PRISMARINE.get(4).get(),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(4).get(),
				ScBlocks.COMPRESSED_NETHERRACK.get(4).get(),
				ScBlocks.COMPRESSED_GLOWSTONE.get(4).get(),
				ScBlocks.COMPRESSED_BLACKSTONE.get(4).get(),
				ScBlocks.COMPRESSED_CALCITE.get(4).get(),
				ScBlocks.COMPRESSED_DEEPSLATE.get(4).get(),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(4).get(),
				ScBlocks.COMPRESSED_BASALT.get(4).get(),
				ScBlocks.COMPRESSED_TUFF.get(4).get(),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(4).get()
		);
		addTags(COMPRESSED_COBBLESTONE, ScBlocks.COMPRESSED_COBBLESTONE);
		addTags(COMPRESSED_MOSSY_COBBLESTONE, ScBlocks.COMPRESSED_MOSSY_COBBLESTONE);
		addTags(COMPRESSED_STONE, ScBlocks.COMPRESSED_STONE);
		addTags(COMPRESSED_GRANITE, ScBlocks.COMPRESSED_GRANITE);
		addTags(COMPRESSED_ANDESITE, ScBlocks.COMPRESSED_ANDESITE);
		addTags(COMPRESSED_DIORITE, ScBlocks.COMPRESSED_DIORITE);
		addTags(COMPRESSED_BEDROCK, ScBlocks.COMPRESSED_BEDROCK);
		addTags(COMPRESSED_END_STONE, ScBlocks.COMPRESSED_END_STONE);
		addTags(COMPRESSED_OBSIDIAN, ScBlocks.COMPRESSED_OBSIDIAN);
		addTags(COMPRESSED_GLOWINGOBSIDIAN, ScBlocks.COMPRESSED_GLOWINGOBSIDIAN);
		addTags(COMPRESSED_CRYING_OBSIDIAN, ScBlocks.COMPRESSED_CRYING_OBSIDIAN);
		addTags(COMPRESSED_PRISMARINE, ScBlocks.COMPRESSED_PRISMARINE);
		addTags(COMPRESSED_DARK_PRISMARINE, ScBlocks.COMPRESSED_DARK_PRISMARINE);
		addTags(COMPRESSED_NETHERRACK, ScBlocks.COMPRESSED_NETHERRACK);
		addTags(COMPRESSED_GLOWSTONE, ScBlocks.COMPRESSED_GLOWSTONE);
		addTags(COMPRESSED_BLACKSTONE, ScBlocks.COMPRESSED_BLACKSTONE);
		addTags(COMPRESSED_CALCITE, ScBlocks.COMPRESSED_CALCITE);
		addTags(COMPRESSED_DEEPSLATE, ScBlocks.COMPRESSED_DEEPSLATE);
		addTags(COMPRESSED_COBBLED_DEEPSLATE, ScBlocks.COMPRESSED_COBBLED_DEEPSLATE);
		addTags(COMPRESSED_BASALT, ScBlocks.COMPRESSED_BASALT);
		addTags(COMPRESSED_TUFF, ScBlocks.COMPRESSED_TUFF);
		addTags(COMPRESSED_DRIPSTONE_BLOCK, ScBlocks.COMPRESSED_DRIPSTONE_BLOCK);
		tag(COMPRESSED_BLOCK).addTags(
				COMPRESSED_BLOCK_LV1,
				COMPRESSED_BLOCK_LV2,
				COMPRESSED_BLOCK_LV3,
				COMPRESSED_BLOCK_LV4,
				COMPRESSED_BLOCK_LV5
		);
		addTags(BlockTags.MINEABLE_WITH_PICKAXE,
				ScBlocks.COMPRESSED_COBBLESTONE,
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE,
				ScBlocks.COMPRESSED_STONE,
				ScBlocks.COMPRESSED_GRANITE,
				ScBlocks.COMPRESSED_ANDESITE,
				ScBlocks.COMPRESSED_DIORITE,
				ScBlocks.COMPRESSED_BEDROCK,
				ScBlocks.COMPRESSED_END_STONE,
				ScBlocks.COMPRESSED_OBSIDIAN,
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN,
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN,
				ScBlocks.COMPRESSED_PRISMARINE,
				ScBlocks.COMPRESSED_DARK_PRISMARINE,
				ScBlocks.COMPRESSED_NETHERRACK,
				ScBlocks.COMPRESSED_GLOWSTONE,
				ScBlocks.COMPRESSED_BLACKSTONE,
				ScBlocks.COMPRESSED_CALCITE,
				ScBlocks.COMPRESSED_DEEPSLATE,
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE,
				ScBlocks.COMPRESSED_BASALT,
				ScBlocks.COMPRESSED_TUFF,
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK
		);
		addTags(Tags.Blocks.NEEDS_WOOD_TOOL,
				ScBlocks.COMPRESSED_COBBLESTONE.get(0),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(0),
				ScBlocks.COMPRESSED_STONE.get(0),
				ScBlocks.COMPRESSED_GRANITE.get(0),
				ScBlocks.COMPRESSED_ANDESITE.get(0),
				ScBlocks.COMPRESSED_DIORITE.get(0),
				ScBlocks.COMPRESSED_END_STONE.get(0),
				ScBlocks.COMPRESSED_PRISMARINE.get(0),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(0),
				ScBlocks.COMPRESSED_NETHERRACK.get(0),
				ScBlocks.COMPRESSED_GLOWSTONE.get(0),
				ScBlocks.COMPRESSED_BLACKSTONE.get(0),
				ScBlocks.COMPRESSED_CALCITE.get(0),
				ScBlocks.COMPRESSED_DEEPSLATE.get(0),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(0),
				ScBlocks.COMPRESSED_BASALT.get(0),
				ScBlocks.COMPRESSED_TUFF.get(0),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(0)
		);
		addTags(BlockTags.NEEDS_STONE_TOOL,
				ScBlocks.COMPRESSED_COBBLESTONE.get(1),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(1),
				ScBlocks.COMPRESSED_STONE.get(1),
				ScBlocks.COMPRESSED_GRANITE.get(1),
				ScBlocks.COMPRESSED_ANDESITE.get(1),
				ScBlocks.COMPRESSED_DIORITE.get(1),
				ScBlocks.COMPRESSED_END_STONE.get(1),
				ScBlocks.COMPRESSED_PRISMARINE.get(1),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(1),
				ScBlocks.COMPRESSED_NETHERRACK.get(1),
				ScBlocks.COMPRESSED_GLOWSTONE.get(1),
				ScBlocks.COMPRESSED_BLACKSTONE.get(1),
				ScBlocks.COMPRESSED_CALCITE.get(1),
				ScBlocks.COMPRESSED_DEEPSLATE.get(1),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(1),
				ScBlocks.COMPRESSED_BASALT.get(1),
				ScBlocks.COMPRESSED_TUFF.get(1),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(1)
		);
		addTags(BlockTags.NEEDS_IRON_TOOL,
				ScBlocks.COMPRESSED_COBBLESTONE.get(2),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(2),
				ScBlocks.COMPRESSED_STONE.get(2),
				ScBlocks.COMPRESSED_GRANITE.get(2),
				ScBlocks.COMPRESSED_ANDESITE.get(2),
				ScBlocks.COMPRESSED_DIORITE.get(2),
				ScBlocks.COMPRESSED_END_STONE.get(2),
				ScBlocks.COMPRESSED_PRISMARINE.get(2),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(2),
				ScBlocks.COMPRESSED_NETHERRACK.get(2),
				ScBlocks.COMPRESSED_GLOWSTONE.get(2),
				ScBlocks.COMPRESSED_BLACKSTONE.get(2),
				ScBlocks.COMPRESSED_CALCITE.get(2),
				ScBlocks.COMPRESSED_DEEPSLATE.get(2),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(2),
				ScBlocks.COMPRESSED_BASALT.get(2),
				ScBlocks.COMPRESSED_TUFF.get(2),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(2)
		);
		addTags(BlockTags.NEEDS_DIAMOND_TOOL,
				ScBlocks.COMPRESSED_COBBLESTONE.get(3),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(3),
				ScBlocks.COMPRESSED_STONE.get(3),
				ScBlocks.COMPRESSED_GRANITE.get(3),
				ScBlocks.COMPRESSED_ANDESITE.get(3),
				ScBlocks.COMPRESSED_DIORITE.get(3),
				ScBlocks.COMPRESSED_END_STONE.get(3),
				ScBlocks.COMPRESSED_PRISMARINE.get(3),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(3),
				ScBlocks.COMPRESSED_NETHERRACK.get(3),
				ScBlocks.COMPRESSED_GLOWSTONE.get(3),
				ScBlocks.COMPRESSED_BLACKSTONE.get(3),
				ScBlocks.COMPRESSED_CALCITE.get(3),
				ScBlocks.COMPRESSED_DEEPSLATE.get(3),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(3),
				ScBlocks.COMPRESSED_BASALT.get(3),
				ScBlocks.COMPRESSED_TUFF.get(3),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(3),
				ScBlocks.COMPRESSED_OBSIDIAN.get(0),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(0),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(0),
				ScBlocks.GLOWINGOBSIDIAN
		);
		addTags(Tags.Blocks.NEEDS_NETHERITE_TOOL,
				ScBlocks.COMPRESSED_COBBLESTONE.get(4),
				ScBlocks.COMPRESSED_MOSSY_COBBLESTONE.get(4),
				ScBlocks.COMPRESSED_STONE.get(4),
				ScBlocks.COMPRESSED_GRANITE.get(4),
				ScBlocks.COMPRESSED_ANDESITE.get(4),
				ScBlocks.COMPRESSED_DIORITE.get(4),
				ScBlocks.COMPRESSED_END_STONE.get(4),
				ScBlocks.COMPRESSED_PRISMARINE.get(4),
				ScBlocks.COMPRESSED_DARK_PRISMARINE.get(4),
				ScBlocks.COMPRESSED_NETHERRACK.get(4),
				ScBlocks.COMPRESSED_GLOWSTONE.get(4),
				ScBlocks.COMPRESSED_BLACKSTONE.get(4),
				ScBlocks.COMPRESSED_CALCITE.get(4),
				ScBlocks.COMPRESSED_DEEPSLATE.get(4),
				ScBlocks.COMPRESSED_COBBLED_DEEPSLATE.get(4),
				ScBlocks.COMPRESSED_BASALT.get(4),
				ScBlocks.COMPRESSED_TUFF.get(4),
				ScBlocks.COMPRESSED_DRIPSTONE_BLOCK.get(4),
				ScBlocks.COMPRESSED_OBSIDIAN.get(1),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(1),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(1),
				ScBlocks.COMPRESSED_OBSIDIAN.get(2),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(2),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(2),
				ScBlocks.COMPRESSED_OBSIDIAN.get(3),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(3),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(3),
				ScBlocks.COMPRESSED_OBSIDIAN.get(4),
				ScBlocks.COMPRESSED_GLOWINGOBSIDIAN.get(4),
				ScBlocks.COMPRESSED_CRYING_OBSIDIAN.get(4));
		tag(FALL_AWAY_STONE_NUGGET).add(
				Blocks.STONE,
				Blocks.COBBLESTONE,
				Blocks.END_STONE,
				Blocks.INFESTED_STONE,
				Blocks.BLACKSTONE,
				Blocks.DRIPSTONE_BLOCK,
				Blocks.PRISMARINE,
				Blocks.DARK_PRISMARINE);
		tag(STONE_DESTROYER_EFFECT_BLOCKS).addTags(
				Tags.Blocks.STONES,
				Tags.Blocks.COBBLESTONES,
				Tags.Blocks.COBBLESTONES_NORMAL,
				BlockTags.TERRACOTTA,
				Tags.Blocks.GLAZED_TERRACOTTAS,
				Tags.Blocks.SANDSTONE_BLOCKS,
				COMPRESSED_BLOCK,
				BlockTags.BASE_STONE_NETHER,
				BlockTags.BASE_STONE_OVERWORLD,
				FALL_AWAY_STONE_NUGGET
		).add(
				Blocks.CALCITE,
				Blocks.SMOOTH_BASALT,
				Blocks.OBSIDIAN,
				Blocks.CRYING_OBSIDIAN);
		tag(STONE_BUFFER_EFFECT_BLOCKS).addTag(STONE_DESTROYER_EFFECT_BLOCKS);
		
		tag(BlockTags.BASE_STONE_NETHER);
		tag(BlockTags.BASE_STONE_OVERWORLD);
		
		tag(ADVANCEMENT_ROOT_BLOCK).addTag(STONE_DESTROYER_EFFECT_BLOCKS);
		
		tag(Tags.Blocks.OBSIDIANS).add(
				ScBlocks.GLOWINGOBSIDIAN.get()
		);
	}
	
	protected final void addTags(TagKey<Block> tagKey, List<DeferredBlock<Block>> blocks) {
		for (DeferredBlock<Block> block : blocks) {
			tag(tagKey).add(block.getKey());
		}
	}
	
	@SafeVarargs
	protected final void addTags(TagKey<Block> tagKey,
			List<DeferredBlock<Block>>... blocks) {
		for (List<DeferredBlock<Block>> block : blocks) {
			addTags(tagKey, block);
		}
	}
	
	@SafeVarargs
	protected final void addTags(TagKey<Block> tagKey, DeferredBlock<Block>... blocks) {
		for (DeferredBlock<Block> block : blocks) {
			tag(tagKey).add(block.getKey());
		}
	}
}