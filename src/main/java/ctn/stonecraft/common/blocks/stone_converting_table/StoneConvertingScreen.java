package ctn.stonecraft.common.blocks.stone_converting_table;

import ctn.stonecraft.datagen.recipe.stone_converting.StoneConvertingRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * 复刻原版切石器的 UI
 */
public class StoneConvertingScreen extends AbstractContainerScreen<StoneConvertingMenu> {

  // 直接复用原版切石器的 Sprite 资源 (Minecraft 1.21+)
  private static final ResourceLocation SCROLLER_SPRITE =
    ResourceLocation.withDefaultNamespace("container/stonecutter/scroller");
  private static final ResourceLocation SCROLLER_DISABLED_SPRITE =
    ResourceLocation.withDefaultNamespace("container/stonecutter/scroller_disabled");
  private static final ResourceLocation RECIPE_SELECTED_SPRITE =
    ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_selected");
  private static final ResourceLocation RECIPE_HIGHLIGHTED_SPRITE =
    ResourceLocation.withDefaultNamespace("container/stonecutter/recipe_highlighted");
  private static final ResourceLocation RECIPE_SPRITE =
    ResourceLocation.withDefaultNamespace("container/stonecutter/recipe");
  private static final ResourceLocation BG_LOCATION =
    ResourceLocation.withDefaultNamespace("textures/gui/container/stonecutter.png");

  // 布局常量
  private static final int RECIPES_X = 52;
  private static final int RECIPES_Y = 14;

  private float scrollOffs;
  private boolean scrolling;
  private int startIndex;
  private boolean displayRecipes;


  public StoneConvertingScreen(StoneConvertingMenu menu, Inventory playerInventory, Component title) {
    super(menu, playerInventory, title);
    menu.registerUpdateListener(this::containerChanged);
    --this.titleLabelY; //稍微上移标题，防止遮挡
  }

  @Override
  public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
    super.render(guiGraphics, mouseX, mouseY, partialTick);
    this.renderTooltip(guiGraphics, mouseX, mouseY);
  }

  @Override
  protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
    int i = this.leftPos;
    int j = this.topPos;
    guiGraphics.blit(BG_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
    // 计算滚动条位置
    int k = (int) (41.0F * this.scrollOffs);
    ResourceLocation scrollerSprite = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
    guiGraphics.blitSprite(scrollerSprite, i + 119, j + 15 + k, 12, 15);
    int l = this.leftPos + RECIPES_X;
    int i1 = this.topPos + RECIPES_Y;
    int j1 = this.startIndex + 12;
    this.renderButtons(guiGraphics, mouseX, mouseY, l, i1, j1);
    this.renderRecipes(guiGraphics, l, i1, j1);
  }

  @Override
  protected void renderTooltip(@NotNull GuiGraphics guiGraphics, int x, int y) {
    super.renderTooltip(guiGraphics, x, y);
    if (this.displayRecipes) {
      int i = this.leftPos + RECIPES_X;
      int j = this.topPos + RECIPES_Y;
      int k = this.startIndex + 12;
      List<RecipeHolder<StoneConvertingRecipe>> list = this.menu.getRecipes();

      for (int l = this.startIndex; l < k && l < this.menu.getNumRecipes(); l++) {
        int i1 = l - this.startIndex;
        int j1 = i + i1 % 4 * 16;
        int k1 = j + i1 / 4 * 18 + 2;
        if (x >= j1 && x < j1 + 16 && y >= k1 && y < k1 + 18) {
          RecipeHolder<StoneConvertingRecipe> recipeHolder = list.get(l);
          if (this.minecraft != null && this.minecraft.level != null) {
            guiGraphics.renderTooltip(this.font, recipeHolder.value().getResultItem(
              this.minecraft.level.registryAccess()), x, y);
          }
        }
      }
    }
  }

  private void renderButtons(GuiGraphics guiGraphics, int mouseX, int mouseY, int x, int y, int lastVisibleElementIndex) {
    for (int i = this.startIndex; i < lastVisibleElementIndex && i < this.menu.getNumRecipes(); i++) {
      int j = i - this.startIndex;
      int k = x + j % 4 * 16;
      int l = j / 4;
      int i1 = y + l * 18 + 2;
      ResourceLocation sprite;
      if (i == this.menu.getSelectedRecipeIndex()) {
        sprite = RECIPE_SELECTED_SPRITE;
      } else if (mouseX >= k && mouseY >= i1 && mouseX < k + 16 && mouseY < i1 + 18) {
        sprite = RECIPE_HIGHLIGHTED_SPRITE;
      } else {
        sprite = RECIPE_SPRITE;
      }

      guiGraphics.blitSprite(sprite, k, i1 - 1, 16, 18);
    }
  }

  private void renderRecipes(GuiGraphics guiGraphics, int left, int top, int recipeIndexOffsetMax) {
    List<RecipeHolder<StoneConvertingRecipe>> list = this.menu.getRecipes();

    for (int i = this.startIndex; i < recipeIndexOffsetMax && i < this.menu.getNumRecipes(); i++) {
      int j = i - this.startIndex;
      int k = left + j % 4 * 16;
      int l = j / 4;
      int i1 = top + l * 18 + 2;
      if (this.minecraft != null && this.minecraft.level != null) {
        guiGraphics.renderItem(list.get(i).value().getResultItem(
          this.minecraft.level.registryAccess()), k, i1);
      }
    }
  }

  @Override
  public boolean mouseClicked(double mouseX, double mouseY, int button) {
    this.scrolling = false;
    if (this.displayRecipes) {
      int i = this.leftPos + RECIPES_X;
      int j = this.topPos + RECIPES_Y;
      int k = this.startIndex + 12;
      // 检查是否点击了配方按钮
      for (int l = this.startIndex; l < k; l++) {
        int i1 = l - this.startIndex;
        double d0 = mouseX - (double) (i + i1 % 4 * 16);
        double d1 = mouseY - (double) (j + i1 / 4 * 18);
        if ( this.minecraft != null && this.minecraft.player != null && d0 >= 0.0 && d1 >= 0.0 && d0 < 16.0 && d1 < 18.0
          && this.menu.clickMenuButton(this.minecraft.player, l)) {
          Minecraft.getInstance().getSoundManager()
            .play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
          if (this.minecraft.gameMode != null) {
            this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, l);
          }
          return true;
        }
      }
      // 检查是否点击了滚动条区域
      i = this.leftPos + 119;
      j = this.topPos + 9;
      if (mouseX >= (double) i && mouseX < (double) (i + 12)
        && mouseY >= (double) j && mouseY < (double) (j + 54)) {
        this.scrolling = true;
      }
    }

    return super.mouseClicked(mouseX, mouseY, button);
  }

  @Override
  public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
    if (this.scrolling && this.isScrollBarActive()) {
      int i = this.topPos + 14;
      int j = i + 54;
      this.scrollOffs = ((float) mouseY - (float) i - 7.5F) / ((float) (j - i) - 15.0F);
      this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0F, 1.0F);
      this.startIndex = (int) ((double) (this.scrollOffs * (float) this.getOffscreenRows()) + 0.5) * 4;
      return true;
    } else {
      return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }
  }

  @Override
  public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
    if (this.isScrollBarActive()) {
      int i = this.getOffscreenRows();
      float f = (float) scrollY / (float) i;
      this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0F, 1.0F);
      this.startIndex = (int) ((double) (this.scrollOffs * (float) i) + 0.5) * 4;
      return true;
    }

    return false; //如果滚动条不活跃不消耗事件
  }

  private boolean isScrollBarActive() {
    return this.displayRecipes && this.menu.getNumRecipes() > 12;
  }

  protected int getOffscreenRows() {
    return (this.menu.getNumRecipes() + 4 - 1) / 4 - 3;
  }

  private void containerChanged() {
    this.displayRecipes = this.menu.hasInputItem();
    if (!this.displayRecipes) {
      this.scrollOffs = 0.0F;
      this.startIndex = 0;
    }
  }
}
