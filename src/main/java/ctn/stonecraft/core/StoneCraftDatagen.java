package ctn.stonecraft.core;

import ctn.stonecraft.datagen.ScBlockModel;
import ctn.stonecraft.datagen.ScDatapackBuiltinEntriesProvider;
import ctn.stonecraft.datagen.ScI18ZhCn;
import ctn.stonecraft.datagen.ScItemModel;
import ctn.stonecraft.datagen.advancement.ScAdvancementProvider;
import ctn.stonecraft.datagen.loot.ScLootTableProvider;
import ctn.stonecraft.datagen.recipe.RecipeProvider;
import ctn.stonecraft.datagen.tag.ScBlockTags;
import ctn.stonecraft.datagen.tag.ScEntityTypeTags;
import ctn.stonecraft.datagen.tag.ScItemTags;
import net.minecraft.DetectedVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

import static ctn.stonecraft.core.StoneCraft.ID;

/**
 * 数据生成主类
 */
@EventBusSubscriber
public class StoneCraftDatagen {
  public static final MutableComponent TRANSLATABLE = Component.translatable("pack." + StoneCraft.ID + ".description");

  @SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		boolean server = event.includeServer();
		boolean client = event.includeClient();
    var dataGenerator = event.getGenerator();
		var packGenerator = dataGenerator.getVanillaPack(server);
    var output = dataGenerator.getPackOutput();
    var helper = event.getExistingFileHelper();
    var completableFuture = event.getLookupProvider();

		dataGenerator.addProvider(true, new PackMetadataGenerator(output)
      .add(PackMetadataSection.TYPE, new PackMetadataSection(TRANSLATABLE, DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA))));

		// 客户端数据生成
		dataGenerator.addProvider(client, new ScBlockModel(output, helper));
		dataGenerator.addProvider(client, new ScItemModel(output, helper));
		dataGenerator.addProvider(client, new ScI18ZhCn(output));

		// 服务端数据生成
		dataGenerator.addProvider(server, new ScDatapackBuiltinEntriesProvider(output, completableFuture));
		ScBlockTags blockTags = new ScBlockTags(output, completableFuture, helper);
		dataGenerator.addProvider(server, blockTags);
		dataGenerator.addProvider(server, new ScItemTags(output, completableFuture, blockTags.contentsGetter(), helper));
		dataGenerator.addProvider(server, new ScEntityTypeTags(output, completableFuture, helper));
		dataGenerator.addProvider(server, new RecipeProvider(output, completableFuture));
		dataGenerator.addProvider(server, new ScLootTableProvider(output, completableFuture));
		dataGenerator.addProvider(server, new ScAdvancementProvider(output, completableFuture, helper));
	}

	private static <T extends DataProvider> DataProvider.Factory<T> bindRegistries(
			BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> tagProviderFactory, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		return packOutput -> tagProviderFactory.apply(packOutput, lookupProvider);
	}
}
