package ctn.stonecraft.common.blocks.stone_crafting_table;

import ctn.stonecraft.common.blocks.AbsBaseTable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;

/**
 * 石质工作台
 */
public class StoneCraftingTable extends AbsBaseTable<StoneCraftingMenu> {

  public static final String STONE_CRAFTING_TABLE_CONTAINER_TITLE  = "container.stonecraft.stone_crafting_table";

  public StoneCraftingTable(Properties properties) {
    super(properties);
  }

  @Override
  public StoneCraftingMenu createMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
    return new StoneCraftingMenu(containerId, inventory, access, this);
  }

  @Override
  protected Component ContainerTitle(){
    return Component.translatable(STONE_CRAFTING_TABLE_CONTAINER_TITLE);
  }
}
