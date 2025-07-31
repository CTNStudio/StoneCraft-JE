package ctn.stonecraft.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ScLootTableProvider extends net.minecraft.data.loot.LootTableProvider {
	public ScLootTableProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, Collections.emptySet(), new ArrayList<>(), registries);
		addLoot(getTables());
	}
	
	public void addLoot(List<SubProviderEntry> tables) {
		tables.add(new SubProviderEntry(ScBlockLootTable::new, LootContextParamSets.BLOCK));
	}
}
