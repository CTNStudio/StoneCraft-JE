package ctn.stonecraft.common.blocks.stone_converting_table;

import ctn.stonecraft.datagen.recipe.stone_converting.StoneConvertingRecipe;
import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScMenuTypes;
import ctn.stonecraft.init.ScRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class StoneConvertingMenu extends AbstractContainerMenu  {

  private final ContainerLevelAccess access;
  private final DataSlot selectedRecipeIndex = DataSlot.standalone();
  private final Level level;
  // 监听器
  private Runnable slotUpdateListener = () -> {};

  // 输入槽容器
  private final Container container = new SimpleContainer(1) {
    @Override
    public void setChanged() {
      super.setChanged();
      slotsChanged(this);
    }
  };

  // 输出槽容器
  private final ResultContainer resultContainer = new ResultContainer();
  // 输入槽
  private final Slot input;
  // 输出槽
  private final Slot result;

  // 可用配方列表
  private List<RecipeHolder<StoneConvertingRecipe>> recipes = List.of();

  // 当前输入物品
  private ItemStack inputItem = ItemStack.EMPTY;

  // 配方是否需要更新
  private long lastSoundTime;

  // 构造函数 - 用于注册
  public StoneConvertingMenu(int containerId, Inventory playerInventory) {
    this(containerId, playerInventory, ContainerLevelAccess.NULL);
  }

  // 构造函数 - 用于实际使用
  public StoneConvertingMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
    super(ScMenuTypes.STONE_CONVERTING.get(), containerId);  // 暂时使用原版类型
    this.access = access;
    this.level = playerInventory.player.level();

    // 添加输入槽
    this.input = this.addSlot(new Slot(this.container, 0, 20, 33) {
      @Override
      public boolean mayPlace(@NotNull ItemStack stack) {
        // 我们创建一个"假"的满堆叠物品去查询配方
        // 这样即使玩家手里只有 1 个物品，而配方需要 5 个，这里也会返回 true (允许放入)
        ItemStack checkStack = stack.copy();
        checkStack.setCount(checkStack.getMaxStackSize());

        // 检查该物品是否有对应的配方
        return level.getRecipeManager()
          .getRecipeFor(ScRecipes.STONE_CONVERTING_TYPE.get(),
            new SingleRecipeInput(checkStack),
            level)
          .isPresent();
      }
    });

    // 添加输出槽
    this.result = this.addSlot(new Slot(this.resultContainer, 0, 143, 33) {
      @Override
      public boolean mayPlace(@NotNull ItemStack stack) {
        return false;  // 输出槽不允许放入物品
      }

      @Override
      public void onTake(@NotNull Player player, @NotNull ItemStack stack) {
        // 消耗输入槽的物品
        stack.onCraftedBy(player.level(), player, stack.getCount());
        resultContainer.awardUsedRecipes(player, List.of(input.getItem()));

        int consumeAmount = 1; // 默认消耗 1
        int recipeIndex = selectedRecipeIndex.get();

        // 获取配方要求的输入数量
        if (isValidRecipeIndex(recipeIndex)) {
          StoneConvertingRecipe recipe = recipes.get(recipeIndex).value();
          consumeAmount = recipe.getInputCount();
        }

        input.remove(consumeAmount);

        // 播放音效
        long currentTime = level.getGameTime();
        if (lastSoundTime != currentTime) {
          level.playSound(null, access.evaluate((world, pos) -> pos, player.blockPosition()),
            SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
          lastSoundTime = currentTime;
        }
        // 继续合成
        if (!input.getItem().isEmpty() && isValidRecipeIndex(selectedRecipeIndex.get())) {
          setupResultSlot(selectedRecipeIndex.get());
        } else {
          // 如果输入空了，确保输出槽也是空的
          result.set(ItemStack.EMPTY);
        }
        // 标记改变
        container.setChanged();
        super.onTake(player, stack);
      }
    });

    // 添加玩家背包槽位（3 行 x 9 列）
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 9; col++) {
        this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
      }
    }

    // 添加玩家快捷栏槽位（1 行 x 9 列）
    for (int col = 0; col < 9; col++) {
      this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
    }

    // 添加数据槽（用于同步选中的配方索引）
    this.addDataSlot(this.selectedRecipeIndex);
  }

  /**
   * 注册槽位更新监听器，当配方列表改变时会调用此监听器
   */
  public void registerUpdateListener(Runnable listener) {
    this.slotUpdateListener = listener;
  }

  /**
   * 获取选中的配方索引
   */
  public int getSelectedRecipeIndex() {
    return this.selectedRecipeIndex.get();
  }

  /**
   * 获取可用配方列表
   */
  public List<RecipeHolder<StoneConvertingRecipe>> getRecipes() {
    return this.recipes;
  }

  /**
   * 获取可用配方数量
   */
  public int getNumRecipes() {
    return this.recipes.size();
  }

  /**
   * 检查是否有输入物品
   */
  public boolean hasInputItem() {
    return this.input.hasItem() && !this.recipes.isEmpty();
  }

  /**
   * 检查菜单是否仍然有效
   */
  @Override
  public boolean stillValid(@NotNull Player player) {
    return stillValid(this.access, player, ScBlocks.STONE_CONVERTING_TABLE.get());
  }

  /**
   * 当输入槽内容改变时调用
   */
  @Override
  public void slotsChanged(@NotNull Container container) {
    ItemStack inputStack = this.input.getItem();
    // 检查物品类型是否改变
    boolean typeChanged = !inputStack.is(this.inputItem.getItem());
    // 检查物品数量是否改变 (防止类型没变但数量变了导致无法更新结果)
    boolean countChanged = inputStack.getCount() != this.inputItem.getCount();

    // 如果类型和数量变了，必须重新生成配方列表
    if (typeChanged || countChanged) {
      this.inputItem = inputStack.copy();
      this.setupRecipeList(inputStack);
    }
    // 触发监听器，通知界面更新
    this.slotUpdateListener.run();
  }

  /**
   * 设置可用配方列表
   */
  private void setupRecipeList(ItemStack inputStack) {
    // 在重置前，先记住当前选中的配方ID
    int oldIndex = this.selectedRecipeIndex.get();
    ResourceLocation oldRecipeId = null;
    if (oldIndex != -1 && oldIndex < this.recipes.size()) {
      oldRecipeId = this.recipes.get(oldIndex).id();
    }

    // 重置状态
    this.selectedRecipeIndex.set(-1);
    this.result.set(ItemStack.EMPTY);

    if (!inputStack.isEmpty()) {
      // 获取所有潜在配方
      ItemStack checkStack = inputStack.copy();
      checkStack.setCount(checkStack.getMaxStackSize());

      List<RecipeHolder<StoneConvertingRecipe>> allRecipes = this.level.getRecipeManager()
        .getRecipesFor(ScRecipes.STONE_CONVERTING_TYPE.get(),
          new SingleRecipeInput(checkStack),
          this.level);

      // 过滤配方
      this.recipes = allRecipes.stream()
        .filter(r -> inputStack.getCount() >= r.value().getInputCount())
        .collect(Collectors.toList());

      // 尝试恢复之前的选择
      if (oldRecipeId != null) {
        for (int i = 0; i < this.recipes.size(); i++) {
          // 如果新列表中还有这个配方（说明数量依然足够）
          if (this.recipes.get(i).id().equals(oldRecipeId)) {
            this.selectedRecipeIndex.set(i);
            this.setupResultSlot(i); // 立即恢复输出槽物品
            break;
          }
        }
      }

    } else {
      this.recipes = List.of();
    }
  }

  /**
   * 选择配方（由客户端调用）
   */
  public boolean clickMenuButton(@NotNull Player player, int recipeIndex) {
    if (this.isValidRecipeIndex(recipeIndex)) {
      this.selectedRecipeIndex.set(recipeIndex);
      this.setupResultSlot(recipeIndex);
    }
    return true;
  }

  /**
   * 检查配方索引是否有效
   */
  private boolean isValidRecipeIndex(int index) {
    return index >= 0 && index < this.recipes.size();
  }

  /**
   * 设置输出槽的物品
   */
  private void setupResultSlot(int recipeIndex) {
    if (!this.recipes.isEmpty() && this.isValidRecipeIndex(recipeIndex)) {
      RecipeHolder<StoneConvertingRecipe> recipeHolder = this.recipes.get(recipeIndex);
      StoneConvertingRecipe recipe = recipeHolder.value();

      // 获取配方的输出物品
      ItemStack resultStack = recipe.assemble(
        new SingleRecipeInput(this.input.getItem()),
        this.level.registryAccess()
      );

      // 设置输出槽
      if (resultStack.isItemEnabled(this.level.enabledFeatures())) {
        this.resultContainer.setRecipeUsed(recipeHolder);
        this.result.set(resultStack);
      } else {
        this.result.set(ItemStack.EMPTY);
      }
    } else {
      this.result.set(ItemStack.EMPTY);
    }

    this.broadcastChanges();
  }

  /**
   * 获取菜单类型
   */
  @Override
  public @NotNull MenuType<?> getType() {
    return ScMenuTypes.STONE_CONVERTING.get();
  }

  /**
   * 禁止玩家通过双击/拖拽来拿取输出槽的物品
   */
  @Override
  public boolean canTakeItemForPickAll(@NotNull ItemStack stack, Slot slot) {
    return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
  }

  /**
   * 快速移动物品（Shift + 左键）
   */
  @Override
  public @NotNull ItemStack quickMoveStack(@NotNull Player player, int slotIndex) {
    ItemStack itemStack = ItemStack.EMPTY;
    Slot slot = this.slots.get(slotIndex);

    if ( slot.hasItem()) {
      ItemStack slotStack = slot.getItem();
      Item item = slotStack.getItem();
      itemStack = slotStack.copy();

      if (slotIndex == 1) {
        // 从输出槽快速移动到背包
        item.onCraftedBy(slotStack, player.level(), player);
        if (!this.moveItemStackTo(slotStack, 2, 38, true)) {
          return ItemStack.EMPTY;
        }
        slot.onQuickCraft(slotStack, itemStack);
      } else if (slotIndex == 0) {
        // 从输入槽快速移动到背包
        if (!this.moveItemStackTo(slotStack, 2, 38, false)) {
          return ItemStack.EMPTY;
        }
      } else if (this.level.getRecipeManager()
        .getRecipeFor(ScRecipes.STONE_CONVERTING_TYPE.get(),
          new SingleRecipeInput(slotStack),
          this.level)
        .isPresent()) {
        // 从背包快速移动到输入槽
        if (!this.moveItemStackTo(slotStack, 0, 1, false)) {
          return ItemStack.EMPTY;
        }
      } else if (slotIndex >= 2 && slotIndex < 29) {
        // 从背包上方快速移动到快捷栏
        if (!this.moveItemStackTo(slotStack, 29, 38, false)) {
          return ItemStack.EMPTY;
        }
      } else if (slotIndex >= 29 && slotIndex < 38) {
        // 从快捷栏快速移动到背包上方
        if (!this.moveItemStackTo(slotStack, 2, 29, false)) {
          return ItemStack.EMPTY;
        }
      }

      if (slotStack.isEmpty()) {
        slot.setByPlayer(ItemStack.EMPTY);
      }

      slot.setChanged();
      if (slotStack.getCount() == itemStack.getCount()) {
        return ItemStack.EMPTY;
      }

      slot.onTake(player, slotStack);
      this.broadcastChanges();
    }

    return itemStack;
  }


  /**
   * 关闭菜单时调用
   */
  @Override
  public void removed(@NotNull Player player) {
    super.removed(player);
    this.resultContainer.removeItemNoUpdate(0);
    this.access.execute((level, pos) -> this.clearContainer(player, this.container));
  }
}
