package ctn.stonecraft.common.blocks.stone_crafting_table;

import ctn.stonecraft.core.StoneCraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;


public class StoneCraftingTable extends CraftingTableBlock {

  public static final String STONE_CRAFTING_TABLE_CONTAINER_TITLE  = "container.stonecraft.stone_crafting_table";

  public StoneCraftingTable(Properties properties) {
    super(properties);
  }

  @Override
  protected @NotNull InteractionResult useWithoutItem(
    @NotNull BlockState state,
    Level level,
    @NotNull BlockPos pos,
    @NotNull Player player,
    @NotNull BlockHitResult hitResult) {

    if (level.isClientSide) {
      StoneCraft.LOGGER.info("=== CLIENT: useWithoutItem ===");

    } else {
      StoneCraft.LOGGER.info("=== SERVER: useWithoutItem ===");
      player.openMenu(state.getMenuProvider(level, pos));
      player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
    }

    return InteractionResult.sidedSuccess(level.isClientSide);
  }

  @Override
  protected @NotNull MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {

    return new SimpleMenuProvider(
      (id, inventory, player) -> {
        return new StoneCraftingMenu(id, inventory,
          ContainerLevelAccess.create(level, pos),
          this);
      },
      ContainerTitle()
    );
  }

  private Component ContainerTitle(){
    return Component.translatable(STONE_CRAFTING_TABLE_CONTAINER_TITLE);
  }
}
