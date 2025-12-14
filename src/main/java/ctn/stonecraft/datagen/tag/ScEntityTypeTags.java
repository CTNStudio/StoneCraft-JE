package ctn.stonecraft.datagen.tag;

import ctn.stonecraft.init.ScEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckForNull;
import java.util.concurrent.CompletableFuture;

import static ctn.stonecraft.core.StoneCraft.ID;
import static net.minecraft.tags.EntityTypeTags.IMPACT_PROJECTILES;

public class ScEntityTypeTags extends EntityTypeTagsProvider {

	public ScEntityTypeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @CheckForNull ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.@NotNull Provider capability) {
		tag(IMPACT_PROJECTILES).add(ScEntityTypes.STONE_NUGGET.get());
	}
}
