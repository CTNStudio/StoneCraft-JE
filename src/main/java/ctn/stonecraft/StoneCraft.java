package ctn.stonecraft;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import static ctn.stonecraft.init.ScArmorMaterials.ARMOR_MATERIALS;
import static ctn.stonecraft.init.ScBlocks.BLOCK_REGISTER;
import static ctn.stonecraft.init.ScCreativeModeTabs.PROJECT_MOON_TAB_REGISTER;
import static ctn.stonecraft.init.ScEnchantments.ENCHANTMENT_REGISTER;
import static ctn.stonecraft.init.ScEntityTypes.ENTITY_TYPE;
import static ctn.stonecraft.init.ScItems.ITEM_REGISTER;
import static ctn.stonecraft.init.ScTriggerTypes.TRIGGER_TYPES;

@Mod(StoneCraft.SC_ID)
public class StoneCraft {
	public static final  String SC_ID  = "stonecraft";
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public StoneCraft(IEventBus eventBus, ModContainer container) {
		eventBus.addListener(this::commonSetup);
		
		ARMOR_MATERIALS.register(eventBus);
		ITEM_REGISTER.register(eventBus);
		BLOCK_REGISTER.register(eventBus);
		ENTITY_TYPE.register(eventBus);
		ENCHANTMENT_REGISTER.register(eventBus);
		PROJECT_MOON_TAB_REGISTER.register(eventBus);
		TRIGGER_TYPES.register(eventBus);
		NeoForge.EVENT_BUS.register(this);
	}
	
	private void commonSetup(FMLCommonSetupEvent event) {
		LOGGER.info("HELLO FROM COMMON SETUP");
	}
	
	public static ResourceLocation path(String name) {
		return ResourceLocation.fromNamespaceAndPath(SC_ID, name);
	}
	
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		LOGGER.info("HELLO from server starting");
	}
	
	@EventBusSubscriber(modid = SC_ID)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			LOGGER.info("HELLO FROM CLIENT SETUP");
			LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
		}
	}
}
