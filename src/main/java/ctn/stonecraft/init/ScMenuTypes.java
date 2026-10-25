package ctn.stonecraft.init;

import ctn.stonecraft.common.menu.StoneConvertMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(Registries.MENU, SC_ID);

    public static final Supplier<MenuType<StoneConvertMenu>> STONE_CONVERT_MENU =
            MENU_TYPES.register("stone_convert", () -> IMenuTypeExtension.create(
                    (windowId, inv, data) -> new StoneConvertMenu(windowId, inv, ContainerLevelAccess.NULL)));
}