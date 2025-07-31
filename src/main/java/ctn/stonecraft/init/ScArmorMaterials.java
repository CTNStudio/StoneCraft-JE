package ctn.stonecraft.init;

import ctn.stonecraft.datagen.tag.ScItemTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.StoneCraft.path;

public class ScArmorMaterials {
	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, SC_ID);
	
	public static final Holder<ArmorMaterial> LV0 = register(
			"stone", 1, 4, 5, 2, 9, 0.5F, 0.05F,
			() -> Ingredient.of(ItemTags.STONE_CRAFTING_MATERIALS)
	);
	public static final Holder<ArmorMaterial> LV1 = register(
			"compressed_stone_lv1", 2, 5, 6, 2, 10, 1.0F, 0.1F,
			() -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV1)
	);
	public static final Holder<ArmorMaterial> LV2 = register(
			"compressed_stone_lv2", 3, 6, 7, 3, 11, 2.5F, 0.15F,
			() -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV2)
	);
	public static final Holder<ArmorMaterial> LV3 = register(
			"compressed_stone_lv3", 4, 7, 8, 4, 12, 3.5F, 0.2F,
			() -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV3)
	);
	public static final Holder<ArmorMaterial> LV4 = register(
			"compressed_stone_lv4", 5, 8, 9, 5, 13, 4.0F, 0.3F,
			() -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV4)
	);
	public static final Holder<ArmorMaterial> LV5 = register(
			"compressed_stone_lv5", 6, 9, 10, 6, 14, 5.4F, 0.4F,
			() -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV5)
	);
	
	private static Holder<ArmorMaterial> register(
			String name,
			int boots,
			int leggings,
			int chestplate,
			int helmet,
			int enchantmentValue,
			float toughness,
			float knockbackResistance,
			Supplier<Ingredient> repairIngredient
	) {
		List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(path(name)));
		EnumMap<ArmorItem.Type, Integer> enumMap = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
			map.put(ArmorItem.Type.BOOTS, boots);
			map.put(ArmorItem.Type.LEGGINGS, leggings);
			map.put(ArmorItem.Type.CHESTPLATE, chestplate);
			map.put(ArmorItem.Type.HELMET, helmet);
		});
		return register(name, enumMap, enchantmentValue, SoundEvents.ARMOR_EQUIP_CHAIN, toughness, knockbackResistance, repairIngredient, list);
	}
	
	private static Holder<ArmorMaterial> register(
			String name,
			EnumMap<ArmorItem.Type, Integer> defense,
			int enchantmentValue,
			Holder<SoundEvent> equipSound,
			float toughness,
			float knockbackResistance,
			Supplier<Ingredient> repairIngridient,
			List<ArmorMaterial.Layer> layers
	) {
		EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);
		
		for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
			enummap.put(armoritem$type, defense.get(armoritem$type));
		}
		return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(enummap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance));
	}
	
}
