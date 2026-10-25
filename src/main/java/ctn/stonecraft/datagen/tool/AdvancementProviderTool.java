package ctn.stonecraft.datagen.tool;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.StoneCraft.path;

/**
 * 进度数据生成工具
 */
public class AdvancementProviderTool {
	public static @NotNull AdvancementHolder createObtainAdv(
			AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver,
			String advId, ItemLike icon, AdvancementType type,
			boolean isHidden, TagKey<Item> tag) {
		return save(Advancement.Builder.advancement().parent(parent).display(
						icon,
						titleText(advId),
						descriptionText(advId),
						null,
						type,
						true,
						true,
						isHidden)
				.addCriterion(advId, obtainItem(matchItems(tag))), saver, advId);
	}
	
	/// 保存进度（一般用于创建根进度）
	public static AdvancementHolder save(Advancement.Builder builder, Consumer<AdvancementHolder> output, String id) {
		AdvancementHolder advancementholder = builder.build(path(id));
		output.accept(advancementholder);
		return advancementholder;
	}
	
	/// 获取进度标题
	public static @NotNull MutableComponent titleText(String name) {
		return translatable("%s.title".formatted(name));
	}
	
	/// 获取进度描述
	public static @NotNull MutableComponent descriptionText(String name) {
		return translatable("%s.description".formatted(name));
	}
	
	/// 获取物品
	public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> obtainItem(ItemPredicate.Builder... items) {
		return InventoryChangeTrigger.TriggerInstance.hasItems(items);
	}
	
	/// 匹配物品
	public static ItemPredicate.@NotNull Builder matchItems(TagKey<Item> tag) {
		return ItemPredicate.Builder.item().of(tag);
	}
	
	/// 获取文本
	public static @NotNull MutableComponent translatable(String key) {
		return Component.translatable("advancements.%s.%s".formatted(SC_ID, key));
	}
	
	public static @NotNull AdvancementHolder createObtainAdv(
			AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver,
			String advId, ItemLike itemLike, AdvancementType type,
			boolean isHidden) {
		return createObtainAdv(parent, saver, advId, itemLike, type, isHidden, itemLike);
	}
	
	/// 创建 获取物品为条件 的进度
	public static @NotNull AdvancementHolder createObtainAdv(
			AdvancementHolder parent, @NotNull Consumer<AdvancementHolder> saver,
			String advId, ItemLike icon, AdvancementType type,
			boolean isHidden, ItemLike... matchItems) {
		return save(Advancement.Builder.advancement().parent(parent).display(
						icon,
						titleText(advId),
						descriptionText(advId),
						null,
						type,
						true,
						true,
						isHidden)
				.addCriterion(advId, obtainItem(matchItems(matchItems))), saver, advId);
	}
	
	/// 匹配物品
	public static ItemPredicate.@NotNull Builder matchItems(ItemLike... items) {
		return ItemPredicate.Builder.item().of(items);
	}
	
	public static @NotNull String advancementId(String id, String name) {
		return "%s/%s".formatted(id, name);
	}
}
