package ctn.stonecraft.core;

import ctn.stonecraft.common.entity.projectile.ProjectileFactoryRegistry;
import ctn.stonecraft.init.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(StoneCraft.ID)
public class StoneCraft {
	public static final String ID = "stonecraft";
	public static final Logger LOGGER = LogManager.getLogger(ID);

	public StoneCraft(IEventBus eventBus, ModContainer container) {
    container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    //初始化注册
    initRegister(eventBus);
		NeoForge.EVENT_BUS.register(this);
    // 注册通用设置事件
    eventBus.addListener(this::commonSetup);
	}

	public static ResourceLocation modRL(String name) {
		return ResourceLocation.fromNamespaceAndPath(ID, name);
	}

	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		LOGGER.info("HELLO from server starting");
	}

  // 初始化注册器
  private void initRegister(IEventBus eventBus){
    ScArmorMaterials.REGISTER.register(eventBus);
    ScItems.REGISTER.register(eventBus);
    ScBlocks.REGISTER.register(eventBus);
    ScEntityTypes.REGISTER.register(eventBus);
    ScEnchantments.REGISTER.register(eventBus);
    ScCreativeModeTabs.REGISTER.register(eventBus);
    ScTriggerTypes.REGISTER.register(eventBus);
    ScParticleTypes.REGISTER.register(eventBus);
    ScSoundEvents.REGISTER.register(eventBus);
    ScDamageType.REGISTER.register(eventBus);
  }

  // 通用设置初始化
  private void commonSetup(final FMLCommonSetupEvent event){
    //初始化弹射物工厂注册表
    ProjectileFactoryRegistry.init();
  }
}
