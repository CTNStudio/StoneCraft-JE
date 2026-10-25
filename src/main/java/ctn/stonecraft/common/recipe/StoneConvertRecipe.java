package ctn.stonecraft.common.recipe;

import ctn.stonecraft.init.ScRecipeSerializers;
import ctn.stonecraft.init.ScRecipeTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class StoneConvertRecipe implements Recipe<RecipeInput> {
    private final Ingredient input;
    private final ItemStack result;

    public StoneConvertRecipe(Ingredient input, ItemStack result) {
        this.input = input;
        this.result = result;
    }

    public Ingredient getInput() { return input; }
    public ItemStack getResult() { return result; }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return input.test(recipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return result;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ScRecipeSerializers.STONE_CONVERTING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ScRecipeTypes.STONE_CONVERTING.get();
    }
}