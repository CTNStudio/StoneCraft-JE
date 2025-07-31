package ctn.stonecraft.init;

import com.google.common.base.Suppliers;
import ctn.stonecraft.datagen.tag.ScItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ScTiers implements Tier {
	LV1(BlockTags.INCORRECT_FOR_IRON_TOOL,
			350, 6.0F, 6, 6, () -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV1)
	),
	LV2(BlockTags.INCORRECT_FOR_IRON_TOOL,
			500, 7.0F, 7, 7, () -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV2)
	),
	LV3(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
			700, 8.0F, 8, 8, () -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV3)
	),
	LV4(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
			1500, 9.0F, 9, 10, () -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV4)
	),
	LV5(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
			3500, 10.0F, 10, 15, () -> Ingredient.of(ScItemTags.COMPRESSED_STONE_MATERIAL_LV5)
	);
	
	private final TagKey<Block>        incorrectBlocksForDrops;
	private final int                  uses;
	private final float                speed;
	private final float                damage;
	private final int                  enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;
	
	ScTiers(TagKey<Block> incorrectBlockForDrops,
			int uses,
			float speed,
			float damage,
			int enchantmentValue,
			Supplier<Ingredient> repairIngredient) {
		this.incorrectBlocksForDrops = incorrectBlockForDrops;
		this.uses                    = uses;
		this.speed                   = speed;
		this.damage                  = damage;
		this.enchantmentValue        = enchantmentValue;
		this.repairIngredient        = Suppliers.memoize(repairIngredient::get);
	}
	
	@Override
	public int getUses() {
		return this.uses;
	}
	
	@Override
	public float getSpeed() {
		return this.speed;
	}
	
	@Override
	public float getAttackDamageBonus() {
		return this.damage;
	}
	
	@Override
	public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
		return this.incorrectBlocksForDrops;
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	
	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
}
