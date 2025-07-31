package ctn.stonecraft.api.tool;

import net.minecraft.nbt.CompoundTag;
import org.jetbrains.annotations.NotNull;

/**
 * @author wang_
 * @version 2024.3.4.1
 * @description
 * @date 2025/7/27
 */
public class NbtTool {
	/// 获取nbt如果没有则创建
	public static @NotNull CompoundTag getOrCreateCompoundTag(CompoundTag nbt, String nbtName) {
		if (!nbt.contains(nbtName)) nbt.put(nbtName, new CompoundTag());
		return nbt.getCompound(nbtName);
	}
}
