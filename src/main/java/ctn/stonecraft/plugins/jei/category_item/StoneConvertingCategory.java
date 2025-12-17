package ctn.stonecraft.plugins.jei.category_item;

import ctn.stonecraft.core.StoneCraft;
import ctn.stonecraft.datagen.recipe.stone_converting.StoneConvertingRecipe;
import ctn.stonecraft.init.ScBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import static ctn.stonecraft.common.blocks.stone_converting_table.StoneConvertingTable.STONE_CONVERTING_TABLE_CONTAINER_TITLE;

/**
 * 石头转换台 JEI 分类
 */
public class StoneConvertingCategory implements IRecipeCategory<RecipeHolder<StoneConvertingRecipe>> {
  public static final RecipeType<RecipeHolder<StoneConvertingRecipe>> TYPE = RecipeType.create(StoneCraft.ID, "stone_converting", (Class<RecipeHolder<StoneConvertingRecipe>>) (Class<?>) RecipeHolder.class);

  private final IDrawable background;  //背景
  private final IDrawable icon; //JEI 类型图标
  private final IDrawable arrow; //合成箭头
  private final IDrawable inputSlot; //输入背景槽
  private final IDrawable outputSlot; //输出背景槽

  public StoneConvertingCategory(IGuiHelper guiHelper) {
    this.background = guiHelper.createBlankDrawable(70, 30);
    this.icon = guiHelper.createDrawableItemStack(
      new ItemStack(ScBlocks.STONE_CONVERTING_TABLE.get())
    );

    this.arrow = guiHelper.getRecipeArrow();
    this.inputSlot = guiHelper.getSlotDrawable();
    this.outputSlot = guiHelper.getOutputSlot();
  }

  // 返回配方类型
  @Override
  public @NotNull RecipeType<RecipeHolder<StoneConvertingRecipe>> getRecipeType() {
    return TYPE;
  }

  @Override
  public @NotNull Component getTitle() {
    return Component.translatable(STONE_CONVERTING_TABLE_CONTAINER_TITLE);
  }

  @Override
  public @NotNull IDrawable getIcon() {
    return this.icon;
  }

  @Override
  public int getWidth() {
    return background.getWidth();
  }

  @Override
  public int getHeight() {
    return background.getHeight();
  }

  // 返回配方 ID 支持 EMI
  @Override
  public @Nullable ResourceLocation getRegistryName(@NotNull RecipeHolder<StoneConvertingRecipe> recipeHolder) {
    return recipeHolder.id();
  }

  @Override
  public void draw(@NotNull RecipeHolder<StoneConvertingRecipe> holder,
                   @NotNull IRecipeSlotsView recipeSlotsView,
                   @NotNull GuiGraphics guiGraphics,
                   double mouseX,
                   double mouseY) {

    inputSlot.draw(guiGraphics, 0, 6); //输入槽位
    arrow.draw(guiGraphics, 20, 7); //合成箭头
    outputSlot.draw(guiGraphics, 44, 2);//输出大槽位
  }

  @Override
  public void setRecipe(@NotNull IRecipeLayoutBuilder builder,
                        @NotNull RecipeHolder<StoneConvertingRecipe> holder,
                        @NotNull IFocusGroup focuses) {
    // 从 Holder 中取出真正的配方逻辑
    StoneConvertingRecipe recipe = holder.value();
    // 获取输入原料
    Ingredient inputIngredient = recipe.getIngredients().getFirst();
    // 获取该配方需要的数量
    int requiredCount = recipe.getInputCount();
    // 将 Ingredient 转换为带有正确数量的 ItemStack 列表
    List<ItemStack> inputStacks = Arrays.stream(inputIngredient.getItems())
      .map(stack -> {
        ItemStack copy = stack.copy(); // 必须 copy，防止修改原始数据
        copy.setCount(requiredCount);  // 设置为配方要求的数量 (例如 5)
        return copy;
      })
      .toList();

    //输入槽
    builder.addSlot(RecipeIngredientRole.INPUT, 1, 7)
      .addItemStacks(inputStacks);

    //输出槽 (保持不变)
    builder.addSlot(RecipeIngredientRole.OUTPUT, 49, 7)
      .addItemStack(recipe.getResultItem(null));
  }
}
