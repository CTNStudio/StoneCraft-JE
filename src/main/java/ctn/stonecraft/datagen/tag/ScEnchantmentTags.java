package ctn.stonecraft.datagen.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static ctn.stonecraft.core.StoneCraft.ID;
import static ctn.stonecraft.init.ScEnchantments.STONE_BUFFER;
import static ctn.stonecraft.init.ScEnchantments.STONE_DESTROYER;

public class ScEnchantmentTags extends EnchantmentTagsProvider {
	public ScEnchantmentTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(EnchantmentTags.TRADEABLE).add(
				STONE_DESTROYER,
				STONE_BUFFER
		);
		tag(EnchantmentTags.TREASURE).add(
				STONE_DESTROYER,
				STONE_BUFFER
		);
	}
}
