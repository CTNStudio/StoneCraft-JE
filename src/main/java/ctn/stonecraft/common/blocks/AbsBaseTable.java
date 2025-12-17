package ctn.stonecraft.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

/**
 * 简单工作台 Block 基类 包含了一个Menu和Title
 */
public abstract class AbsBaseTable<T extends AbstractContainerMenu> extends Block {
  public AbsBaseTable(Properties properties) {
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
      return InteractionResult.SUCCESS;
    } else {
      player.openMenu(state.getMenuProvider(level, pos));
      player.awardStat(Stats.INTERACT_WITH_STONECUTTER);
      return InteractionResult.CONSUME;
    }
  }

  @Override
  protected @NotNull MenuProvider getMenuProvider(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos) {

    return new SimpleMenuProvider(
      (id, inventory, player) -> createMenu(id, inventory, ContainerLevelAccess.create(level, pos)),
      ContainerTitle()
    );
  }

  // 创建 Menu
  public abstract T createMenu(int containerId, Inventory inventory, ContainerLevelAccess access);

  // 标题组件
  protected abstract Component ContainerTitle();
}
