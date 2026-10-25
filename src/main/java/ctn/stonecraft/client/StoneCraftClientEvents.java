package ctn.stonecraft.client;

import ctn.stonecraft.client.renderer.StoneArrowRenderer;
import ctn.stonecraft.client.screen.StoneConvertScreen;
import ctn.stonecraft.init.ScEntityTypes;
import ctn.stonecraft.init.ScMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = "stonecraft", value = Dist.CLIENT)
public class StoneCraftClientEvents {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ScMenuTypes.STONE_CONVERT_MENU.get(), StoneConvertScreen::new);
    }
}