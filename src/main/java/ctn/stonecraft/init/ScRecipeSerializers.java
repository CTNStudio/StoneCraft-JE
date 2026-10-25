package ctn.stonecraft.init;

import ctn.stonecraft.common.recipe.StoneConvertRecipe;
import ctn.stonecraft.common.recipe.StoneConvertRecipeSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, SC_ID);

    public static final Supplier<RecipeSerializer<StoneConvertRecipe>> STONE_CONVERTING =
            RECIPE_SERIALIZERS.register("stone_converting", StoneConvertRecipeSerializer::new);
}