package ctn.stonecraft.common.blocks.stone_crafting_table;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 * 石质工作台菜单(复用原版工作台)
 */
public class StoneCraftingMenu extends CraftingMenu {
  private final ContainerLevelAccess access;
  private final Block block;

  public StoneCraftingMenu(int containerId, Inventory playerInventory,
                           ContainerLevelAccess access, Block block) {
    super(containerId, playerInventory, access);
    this.access = access;
    this.block = block;
  }

  @Override
  public boolean stillValid(@NotNull Player player) {
    return stillValid(this.access, player, this.block);
  }
}
