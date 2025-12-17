package ctn.stonecraft.datagen.loot;

import ctn.stonecraft.init.ScBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class ScBlockLootTable extends BlockLootSubProvider {
	public ScBlockLootTable(HolderLookup.Provider lookupProvider) {
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
	}

	@Override
	protected void generate() {
		dropSelf(ScBlocks.COMPRESSED_COBBLESTONE);
		dropSelf(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE);
		dropSelf(ScBlocks.COMPRESSED_STONE);
		dropSelf(ScBlocks.COMPRESSED_GRANITE);
		dropSelf(ScBlocks.COMPRESSED_ANDESITE);
		dropSelf(ScBlocks.COMPRESSED_DIORITE);
		dropSelf(ScBlocks.COMPRESSED_BEDROCK);
		dropSelf(ScBlocks.COMPRESSED_END_STONE);
		dropSelf(ScBlocks.GLOWINGOBSIDIAN.get());
		dropSelf(ScBlocks.COMPRESSED_OBSIDIAN);
		dropSelf(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN);
		dropSelf(ScBlocks.COMPRESSED_CRYING_OBSIDIAN);
		dropSelf(ScBlocks.COMPRESSED_PRISMARINE);
		dropSelf(ScBlocks.COMPRESSED_DARK_PRISMARINE);
		dropSelf(ScBlocks.COMPRESSED_NETHERRACK);
		dropSelf(ScBlocks.COMPRESSED_GLOWSTONE);
		dropSelf(ScBlocks.COMPRESSED_BLACKSTONE);
		dropSelf(ScBlocks.COMPRESSED_CALCITE);
		dropSelf(ScBlocks.COMPRESSED_DEEPSLATE);
		dropSelf(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE);
		dropSelf(ScBlocks.COMPRESSED_BASALT);
		dropSelf(ScBlocks.COMPRESSED_TUFF);
		dropSelf(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK);
    dropSelf(ScBlocks.STONE_CRAFTING_TABLE.get());     //石质工作台
    dropSelf(ScBlocks.STONE_CONVERTING_TABLE.get());   //石头转换台
	}

	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		@SuppressWarnings("UnnecessaryLocalVariable")
		List<Block> blocks = new java.util.ArrayList<>(ScBlocks.REGISTER.getEntries()
				.stream()
				.map(e -> (Block) e.value())
				.toList());
		return blocks;
	}

	protected void dropSelf(List<DeferredBlock<Block>> blocks) {
		for (DeferredBlock<Block> block : blocks) {
			dropSelf(block.get());
		}
	}
}
