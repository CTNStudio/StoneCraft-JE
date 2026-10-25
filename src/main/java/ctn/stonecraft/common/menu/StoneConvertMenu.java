package ctn.stonecraft.common.menu;

import ctn.stonecraft.common.recipe.StoneConvertRecipe;
import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScMenuTypes;
import ctn.stonecraft.init.ScRecipeTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StoneConvertMenu extends AbstractContainerMenu {
    private final CraftingContainer craftSlots;
    private final ResultContainer resultSlots = new ResultContainer();
    private final ContainerLevelAccess access;
    private final Player player;

    public StoneConvertMenu(int windowId, Inventory playerInventory, ContainerLevelAccess access) {
        super(ScMenuTypes.STONE_CONVERT_MENU.get(), windowId);
        this.access = access;
        this.player = playerInventory.player;
        this.craftSlots = new TransientCraftingContainer(this, 3, 3);

        // 输出槽
        this.addSlot(new Slot(resultSlots, 0, 124, 35) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                // 消耗一个输入物品
                for (int i = 0; i < craftSlots.getContainerSize(); i++) {
                    ItemStack in = craftSlots.getItem(i);
                    if (!in.isEmpty()) {
                        craftSlots.removeItem(i, 1);
                        break;
                    }
                }
                super.onTake(player, stack);
            }
        });

        // 3x3 输入槽
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlot(new Slot(craftSlots, col + row * 3, 30 + col * 18, 17 + row * 18));
            }
        }

        // 玩家背包 3x9
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // 快捷栏 9 格
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
        }
    }

    @Override
    public void slotsChanged(net.minecraft.world.Container container) {
        super.slotsChanged(container);
        if (container == this.craftSlots) {
            this.updateResult();
        }
    }

    private void updateResult() {
        Level level = this.player.level();
        if (level.isClientSide) return;

        List<ItemStack> inputs = new ArrayList<>();
        for (int i = 0; i < this.craftSlots.getContainerSize(); i++) {
            ItemStack stack = this.craftSlots.getItem(i);
            if (!stack.isEmpty()) inputs.add(stack);
        }

        if (inputs.isEmpty()) {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
            return;
        }

        RecipeInput recipeInput = new RecipeInput() {
            @Override
            public ItemStack getItem(int index) {
                return index < inputs.size() ? inputs.get(index) : ItemStack.EMPTY;
            }

            @Override
            public int size() {
                return inputs.size();
            }
        };

        @SuppressWarnings("unchecked")
        RecipeType<StoneConvertRecipe> type =
                (RecipeType<StoneConvertRecipe>) ScRecipeTypes.STONE_CONVERTING.get();

        Optional<RecipeHolder<StoneConvertRecipe>> recipe = level.getRecipeManager()
                .getRecipeFor(type, recipeInput, level);

        if (recipe.isPresent()) {
            this.resultSlots.setItem(0, recipe.get().value().getResultItem(level.registryAccess()));
        } else {
            this.resultSlots.setItem(0, ItemStack.EMPTY);
        }
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.resultSlots.clearContent();
        if (!player.level().isClientSide) {
            clearContainer(player, this.craftSlots);
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access, player, ScBlocks.STONE_CONVERT_TABLE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index == 0) {
                if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index >= 10 && index < 46) {
                if (!this.moveItemStackTo(itemstack1, 1, 10, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 1 && index < 10) {
                if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemstack1);
        }
        return itemstack;
    }
}