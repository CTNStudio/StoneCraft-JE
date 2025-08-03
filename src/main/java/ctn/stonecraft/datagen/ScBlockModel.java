package ctn.stonecraft.datagen;

import ctn.stonecraft.init.ScBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.List;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScBlockModel extends BlockStateProvider {
	public ScBlockModel(PackOutput output, ExistingFileHelper exFileHelper) {
		super(output, SC_ID, exFileHelper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		blockItems(ScBlocks.COMPRESSED_COBBLESTONE);
		blockItems(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE);
		blockItems(ScBlocks.COMPRESSED_STONE);
		blockItems(ScBlocks.COMPRESSED_GRANITE);
		blockItems(ScBlocks.COMPRESSED_ANDESITE);
		blockItems(ScBlocks.COMPRESSED_DIORITE);
		blockItems(ScBlocks.COMPRESSED_BEDROCK);
		blockItems(ScBlocks.COMPRESSED_END_STONE);
		blockItems(ScBlocks.COMPRESSED_OBSIDIAN);
		blockItems(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN);
		blockItems(ScBlocks.GLOWINGOBSIDIAN);
		blockItems(ScBlocks.COMPRESSED_CRYING_OBSIDIAN);
		blockItems(ScBlocks.COMPRESSED_PRISMARINE);
		blockItems(ScBlocks.COMPRESSED_DARK_PRISMARINE);
		blockItems(ScBlocks.COMPRESSED_NETHERRACK);
		blockItems(ScBlocks.COMPRESSED_GLOWSTONE);
		blockItems(ScBlocks.COMPRESSED_BLACKSTONE);
		blockItems(ScBlocks.COMPRESSED_CALCITE);
		blockItems(ScBlocks.COMPRESSED_DEEPSLATE);
		blockItems(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE);
		blockItems(ScBlocks.COMPRESSED_BASALT);
		blockItems(ScBlocks.COMPRESSED_TUFF);
		blockItems(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK);
	}
	
	private void blockItems(DeferredBlock<Block> blockItem) {
		Block block = blockItem.get();
		simpleBlockWithItem(block, cubeAll(block));
	}
	
	private void blockItems(List<DeferredBlock<Block>> blockItems) {
		for (DeferredBlock<Block> blockItem : blockItems) {
			Block block = blockItem.get();
			ResourceLocation name = key(block);
			String path = name.getPath();
			String nameBlock = name(block);
			
			// 分割路径并检查格式是否符合预期
			String[] split = path.split("_lv");
			if (split.length < 2) {
				throw new IllegalArgumentException("Invalid block path format: " + path + ". Expected pattern '***_lv*'");
			}
			
			String namespace = name.getNamespace();
			String modelName = split[0] + "/" + "lv" + split[1];
			ResourceLocation modelLocation = ResourceLocation.fromNamespaceAndPath(namespace, ModelProvider.BLOCK_FOLDER + "/" + modelName);
			
			ModelFile modelFile = models().cubeAll(nameBlock, modelLocation);
			ConfiguredModel configuredModel = new ConfiguredModel(modelFile);
			
			getVariantBuilder(block).partialState().setModels(configuredModel);
			
			itemModels().getBuilder(path).parent(modelFile);
		}
	}
	
	private ResourceLocation key(Block block) {
		return BuiltInRegistries.BLOCK.getKey(block);
	}
	
	private String name(Block block) {
		return key(block).getPath();
	}
}
