package ctn.stonecraft.plugins.jei;

import ctn.stonecraft.core.StoneCraft;
import ctn.stonecraft.datagen.recipe.stone_converting.StoneConvertingRecipe;
import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScRecipes;
import ctn.stonecraft.plugins.jei.category_item.StoneConvertingCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class JEIModPlugin implements IModPlugin {

  /**
   * 获取插件的唯一标识符
   */
  @Override
  public @NotNull ResourceLocation getPluginUid() {
    return ResourceLocation.fromNamespaceAndPath(StoneCraft.ID, "jei_plugin");
  }

  /**
   * 注册配方分类
   */
  @Override
  public void registerCategories(IRecipeCategoryRegistration registration) {
    registration.addRecipeCategories(
      new StoneConvertingCategory(registration.getJeiHelpers().getGuiHelper()) //石头转换台
    );
  }

  /**
   * 注册具体的配方数据
   */
  @Override
  public void registerRecipes(@NotNull IRecipeRegistration registration) {
    Minecraft minecraft = Minecraft.getInstance();
    // 确保世界已加载
    if (minecraft.level == null) {
      return;
    }

    // 获取原版配方管理器
    RecipeManager recipeManager = minecraft.level.getRecipeManager();

    // 获取所有“石质转换”类型的配方 Holder
    List<RecipeHolder<StoneConvertingRecipe>> recipeHolders = recipeManager
      .getAllRecipesFor(ScRecipes.STONE_CONVERTING_TYPE.get());

    // 将提取出的配方列表注册到 JEI 对应的类型中
    registration.addRecipes(StoneConvertingCategory.TYPE, recipeHolders);
  }

  /**
   * 注册配方催化剂
   */
  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    // 石质工作台
    registration.addRecipeCatalyst(
      new ItemStack(ScBlocks.STONE_CRAFTING_TABLE.get()),
      //TODO 石质工作台先关联原版的
      RecipeTypes.CRAFTING //先关联原版
    );

    // 石质转换
    registration.addRecipeCatalyst(
      new ItemStack(ScBlocks.STONE_CONVERTING_TABLE.get()),
      StoneConvertingCategory.TYPE
    );
  }
}
