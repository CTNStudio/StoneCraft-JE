package ctn.stonecraft.common.blocks.stone_converting_table;

import ctn.stonecraft.common.blocks.AbsBaseTable;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerLevelAccess;

/**
 * 石头转换台
 */
public class StoneConvertingTable extends AbsBaseTable<StoneConvertingMenu> {

  public static final String STONE_CONVERTING_TABLE_CONTAINER_TITLE  = "container.stonecraft.stone_converting_table";

  public StoneConvertingTable(Properties properties) {
    super(properties);
  }

  @Override
  public StoneConvertingMenu createMenu(int containerId, Inventory inventory, ContainerLevelAccess access) {
    return new StoneConvertingMenu(containerId, inventory, access);
  }


  @Override
  protected Component ContainerTitle(){
    return Component.translatable(STONE_CONVERTING_TABLE_CONTAINER_TITLE);
  }
}
