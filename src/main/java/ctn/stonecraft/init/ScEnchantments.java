package ctn.stonecraft.init;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import static ctn.stonecraft.core.StoneCraft.ID;
import static ctn.stonecraft.core.StoneCraft.modRL;
import static net.minecraft.core.registries.Registries.ENCHANTMENT;

public class ScEnchantments {
	public static final DeferredRegister<Enchantment> REGISTER = DeferredRegister.create(ENCHANTMENT, ID);

	public static final ResourceKey<Enchantment> STONE_DESTROYER = key("stone_destroyer");
	public static final ResourceKey<Enchantment> STONE_BUFFER    = key("stone_buffer");
	public static final ResourceKey<Enchantment> OLDB            = key("oldb");

	public static void bootstrap(BootstrapContext<Enchantment> context) {
		HolderGetter<DamageType> holdergetter = context.lookup(Registries.DAMAGE_TYPE);
		HolderGetter<Enchantment> holdergetter1 = context.lookup(ENCHANTMENT);
		HolderGetter<Item> holdergetter2 = context.lookup(Registries.ITEM);
		HolderGetter<Block> holdergetter3 = context.lookup(Registries.BLOCK);
		register(context, STONE_DESTROYER, Enchantment.enchantment(
				Enchantment.definition(
						holdergetter2.getOrThrow(ItemTags.MINING_ENCHANTABLE),
						1,
						5,
						Enchantment.dynamicCost(3, 1),
						Enchantment.dynamicCost(4, 2),
						1,
						EquipmentSlotGroup.MAINHAND)
		));
		register(context, STONE_BUFFER, Enchantment.enchantment(
				Enchantment.definition(
						holdergetter2.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),
						1,
						1,
						Enchantment.dynamicCost(3, 1),
						Enchantment.dynamicCost(4, 2),
						1,
						EquipmentSlotGroup.FEET)
		));
		register(context, OLDB, Enchantment.enchantment(
				Enchantment.definition(
						HolderSet.empty(),
						11,
						1,
						Enchantment.constantCost(4),
						Enchantment.constantCost(5),
						14,
						EquipmentSlotGroup.FEET)
		));
	}

	private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
		Enchantment enchantment = builder.build(key.location());
		context.register(key, enchantment);
		REGISTER.register(key.location().getPath(), () -> enchantment);
	}

	public static @NotNull String getEnchantmentTranslatable(ResourceKey<Enchantment> enchantment) {
		return "enchantment." + enchantment.location().toString().replace(":", ".");
	}

	public static @NotNull ResourceKey<Enchantment> key(String name) {
		return ResourceKey.create(ENCHANTMENT, modRL(name));
	}
}
