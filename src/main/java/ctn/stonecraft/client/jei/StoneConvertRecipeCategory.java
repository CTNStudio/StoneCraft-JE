package ctn.stonecraft.client.jei;

import ctn.stonecraft.common.recipe.StoneConvertRecipe;
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
import net.minecraft.world.item.ItemStack;

public class StoneConvertRecipeCategory implements IRecipeCategory<StoneConvertRecipe> {

    private final IDrawable icon;
    private final Component localizedName;
    private final IDrawable arrow;
    private final IDrawable slotBackground;

    public StoneConvertRecipeCategory(IGuiHelper guiHelper) {
        this.icon = guiHelper.createDrawableItemStack(
                new ItemStack(ScBlocks.STONE_CONVERT_TABLE.get()));
        this.localizedName = Component.translatable("container.stonecraft.stone_convert_table");
        this.arrow = guiHelper.getRecipeArrow();
        this.slotBackground = guiHelper.getSlotDrawable();
    }

    @Override
    public RecipeType<StoneConvertRecipe> getRecipeType() {
        return StoneCraftJeiPlugin.STONE_CONVERT_TYPE;
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public int getWidth() {
        return 130;
    }

    @Override
    public int getHeight() {
        return 56;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, StoneConvertRecipe recipe, IFocusGroup focuses) {
        int startX = 1;
        int startY = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int slotX = startX + col * 18;
                int slotY = startY + row * 18;
                if (row == 1 && col == 1) {
                    builder.addSlot(RecipeIngredientRole.INPUT, slotX, slotY)
                            .addIngredients(recipe.getInput());
                } else {
                    builder.addSlot(RecipeIngredientRole.INPUT, slotX, slotY);
                }
            }
        }

        // 输出槽
        builder.addSlot(RecipeIngredientRole.OUTPUT, 100, 19)
                .addItemStack(recipe.getResult());
    }

    @Override
    public void draw(StoneConvertRecipe recipe, IRecipeSlotsView recipeSlotsView,
                     GuiGraphics guiGraphics, double mouseX, double mouseY) {
        // 输入槽背景
        int startX = 1;
        int startY = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int slotX = startX + col * 18;
                int slotY = startY + row * 18;
                slotBackground.draw(guiGraphics, slotX - 1, slotY - 1);
            }
        }
        // 输出槽背景
        slotBackground.draw(guiGraphics, 99, 18);
        // 箭头
        arrow.draw(guiGraphics, 70, 19);
    }
}