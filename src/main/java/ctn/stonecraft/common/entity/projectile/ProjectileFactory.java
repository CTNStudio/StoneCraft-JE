package ctn.stonecraft.common.entity.projectile;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * 弹射物工厂接口
 * 用于创建不同类型的弹射物
 */
@FunctionalInterface
public interface ProjectileFactory {
  /**
   * 创建弹射物
   *
   * @param level   世界
   * @param shooter 发射者
   * @param weapon  武器
   * @param ammo    弹药
   * @return 弹射物实例
   */
  @NotNull AbsStoneNuggetProjectile create(@NotNull Level level,
                                           @NotNull LivingEntity shooter,
                                           @NotNull ItemStack weapon,
                                           @NotNull ItemStack ammo);
}
