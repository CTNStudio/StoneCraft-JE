package ctn.stonecraft.init;

import ctn.stonecraft.common.blocks.stone_converting_table.StoneConvertingMenu;
import ctn.stonecraft.core.StoneCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 菜单类型注册
 */
public class ScMenuTypes {
  public static final DeferredRegister<MenuType<?>> MENU_TYPES_REGISTER = DeferredRegister.create(Registries.MENU, StoneCraft.ID);

  public static final DeferredHolder<MenuType<?>, MenuType<StoneConvertingMenu>> STONE_CONVERTING = MENU_TYPES_REGISTER.register("stone_converting",
      () -> new MenuType<>(StoneConvertingMenu::new, FeatureFlags.DEFAULT_FLAGS));

  public static void register(IEventBus eventBus) {
    MENU_TYPES_REGISTER.register(eventBus);
  }
}
