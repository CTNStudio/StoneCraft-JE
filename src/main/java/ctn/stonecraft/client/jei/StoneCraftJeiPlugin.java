package ctn.stonecraft.client.jei;

import ctn.stonecraft.StoneCraft;
import ctn.stonecraft.common.recipe.StoneConvertRecipe;
import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@JeiPlugin
public class StoneCraftJeiPlugin implements IModPlugin {

    public static final ResourceLocation UID =
            ResourceLocation.fromNamespaceAndPath(StoneCraft.SC_ID, "jei_plugin");

    public static final RecipeType<StoneConvertRecipe> STONE_CONVERT_TYPE =
            RecipeType.create(StoneCraft.SC_ID, "stone_converting", StoneConvertRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new StoneConvertRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var level = Minecraft.getInstance().level;
        if (level == null) return;

        List<StoneConvertRecipe> recipes = level.getRecipeManager()
                .getAllRecipesFor(ScRecipeTypes.STONE_CONVERTING.get())
                .stream()
                .map(holder -> holder.value())
                .toList();

        registration.addRecipes(STONE_CONVERT_TYPE, recipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(
                new ItemStack(ScBlocks.STONE_CONVERT_TABLE.get()),
                STONE_CONVERT_TYPE);
    }
}