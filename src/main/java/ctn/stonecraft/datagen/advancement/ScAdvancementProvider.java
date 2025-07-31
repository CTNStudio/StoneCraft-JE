package ctn.stonecraft.datagen.advancement;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScAdvancementProvider extends AdvancementProvider {
	public ScAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
		super(output, registries, existingFileHelper, List.of(
				new ScAdvancementGenerator()
		));
	}
	
	public static @NotNull AdvancementHolder createPlaceholder(String location) {
		return AdvancementSubProvider.createPlaceholder("%s:location".formatted(SC_ID));
	}
}
