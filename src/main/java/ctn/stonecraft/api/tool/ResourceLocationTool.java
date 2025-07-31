package ctn.stonecraft.api.tool;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ResourceLocationTool {
	public static @NotNull ResourceLocation getResourceLocation(String[] id) {
		if (id.length < 2) {
			throw new IllegalArgumentException("Invalid resource location: " + Arrays.toString(id));
		}
		return ResourceLocation.fromNamespaceAndPath(id[0], id[1]);
	}
	
	public static @NotNull ResourceLocation getResourceLocation(String id) {
		return getResourceLocation(id.split(":"));
	}
}
