package ctn.stonecraft.api.util;

import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;

public class NbtUtil {
	/// 获取nbt如果没有则创建
	public static @NotNull CompoundTag getOrCreateCompoundTag(CompoundTag nbt, String nbtName) {
		if (!nbt.contains(nbtName)) nbt.put(nbtName, new CompoundTag());
		return nbt.getCompound(nbtName);
	}
}
