package ctn.stonecraft.core;

import ctn.stonecraft.common.blocks.stone_converting_table.StoneConvertingScreen;
import ctn.stonecraft.init.ScMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@EventBusSubscriber(modid = StoneCraft.ID, value = Dist.CLIENT)
public class StoneCraftClient {
  @SubscribeEvent
  public static void onClientSetup(FMLClientSetupEvent event) {
    StoneCraft.LOGGER.info("HELLO FROM CLIENT SETUP");
  }
  @SubscribeEvent
  public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
    event.register(ScMenuTypes.STONE_CONVERTING.get(), StoneConvertingScreen::new); //石头转换台菜单注册
  }
}
