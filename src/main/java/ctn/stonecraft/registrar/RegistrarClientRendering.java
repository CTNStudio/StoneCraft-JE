package ctn.stonecraft.registrar;

import ctn.stonecraft.init.ScEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import static ctn.stonecraft.core.StoneCraft.ID;

@EventBusSubscriber(modid = ID)
public class RegistrarClientRendering {

	/**
	 * 注册实体渲染器
	 */
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		EntityRenderers.register(ScEntityTypes.STONE_NUGGET.get(), ThrownItemRenderer::new);
    EntityRenderers.register(ScEntityTypes.FLINT_PROJECTILE.get(), ThrownItemRenderer::new); //燧石
	}

	/** 注册粒子渲染器 */
	@SubscribeEvent
	public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
	}

	/**
	 * 注册菜单渲染器
	 */
	@SubscribeEvent
	public static void registerMenuScreens(RegisterMenuScreensEvent event) {
	}
}
