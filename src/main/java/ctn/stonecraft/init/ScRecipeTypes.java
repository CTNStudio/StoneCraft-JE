package ctn.stonecraft.init;

import ctn.stonecraft.common.recipe.StoneConvertRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, SC_ID);

    @SuppressWarnings("unchecked")
    public static final DeferredHolder<RecipeType<?>, RecipeType<StoneConvertRecipe>> STONE_CONVERTING =
            RECIPE_TYPES.register("stone_converting", () ->
                    (RecipeType<StoneConvertRecipe>) (RecipeType<?>) RecipeType.simple(
                            ResourceLocation.fromNamespaceAndPath(SC_ID, "stone_converting")));
}