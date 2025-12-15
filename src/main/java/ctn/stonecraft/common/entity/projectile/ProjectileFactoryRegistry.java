package ctn.stonecraft.common.entity.projectile;

import ctn.stonecraft.common.entity.projectile.stone_nugget.flint.FlintProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.StoneNuggetProjectileBuilder;
import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;
import ctn.stonecraft.init.ScEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.Map;

import static ctn.stonecraft.common.entity.projectile.stone_nugget.flint.FlintProjectile.FLINT_BASE_NUGGET_PROPS;
import static ctn.stonecraft.init.ScItems.STONE_NUGGET;

/**
 * 弹射物工厂注册表
 * 管理所有弹药类型对应的弹射物创建逻辑
 */
public class ProjectileFactoryRegistry {
  private static final Map<Item, ProjectileFactory> FACTORIES = new HashMap<>();
  private static ProjectileFactory DEFAULT_FACTORY;

  /**
   * 注册弹药对应的弹射物工厂
   */
  public static void register(Item ammo, ProjectileFactory factory) {
    FACTORIES.put(ammo, factory);
  }

  public static void setDefaultFactory(ProjectileFactory factory){
    DEFAULT_FACTORY = factory;
  }

  /**
   * 根据 Item 获取弹射物工厂
   */
  public static ProjectileFactory getFacory(Item item){

    // 1. 如果是 AbsStoneNuggetItem，使用其自带的工厂
    if (item instanceof AbsStoneNuggetItem nuggetItem) {
      return (level, shooter, weapon, ammoStack) -> {
        return nuggetItem.getProjectile(level, shooter, weapon);
      };
    }

    // 2. 查找注册的工厂
    ProjectileFactory factory = FACTORIES.get(item);
    if (factory != null) {
      return factory;
    }
    // 3. 返回默认工厂
    return DEFAULT_FACTORY != null ? DEFAULT_FACTORY : createDefaultFactory();
  }

  /**
   * 创建默认工厂
   */
  private static ProjectileFactory createDefaultFactory() {
    return (level, shooter, weapon, ammo) -> {
      AbsStoneNuggetItem item = STONE_NUGGET.get();
      return item.getProjectile(level, shooter, weapon);
    };
  }

  /**
   * 初始化注册所有工厂
   */
  public static void init() {
    // 默认弹药工厂
    setDefaultFactory((level, shooter, weapon, ammo) -> {
      AbsStoneNuggetItem item = STONE_NUGGET.get();
      return item.getProjectile(level, shooter, weapon);
    });

    // 燧石弹射物工厂
    register(Items.FLINT, (level, shooter, weapon, ammo) ->
      new FlintProjectile(
        new StoneNuggetProjectileBuilder(FLINT_BASE_NUGGET_PROPS),  // ← 使用专用构建器
        ScEntityTypes.FLINT_PROJECTILE.get(),
        shooter,
        level,
        weapon
      )
    );
  }
}


