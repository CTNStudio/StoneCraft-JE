package ctn.stonecraft.registrar;

<<<<<<< HEAD
import ctn.stonecraft.init.ScEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
=======
import ctn.stonecraft.client.renderer.StoneArrowRenderer;
import ctn.stonecraft.init.ScEntityTypes;
import ctn.stonecraft.init.ScItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
>>>>>>> main
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import static ctn.stonecraft.StoneCraft.SC_ID;

@EventBusSubscriber(modid = SC_ID)
public class RegistrarClientRendering {
<<<<<<< HEAD
	
	/**
	 * 注册实体渲染器
	 */
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		EntityRenderers.register(ScEntityTypes.STONE_NUGGET.get(), ThrownItemRenderer::new);
	}
	
=======

	/**
	 * 注册实体渲染器 + 石弓拉弓属性
	 */
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			EntityRenderers.register(ScEntityTypes.STONE_NUGGET.get(), ThrownItemRenderer::new);
			EntityRenderers.register(ScEntityTypes.STONE_ARROW.get(), StoneArrowRenderer::new);

			// 石弓 pull 属性：按 30 刻计算，上限 1.0
			ItemProperties.register(ScItems.STONE_BOW.get(),
					ResourceLocation.fromNamespaceAndPath(SC_ID, "pull"),
					(stack, level, living, seed) -> {
						if (living == null || living.getUseItem() != stack) {
							return 0.0F;
						}
						int used = stack.getUseDuration(living) - living.getUseItemRemainingTicks();
						return Math.min((float) used / 30.0F, 1.0F);
					});

			// 石弓 pulling 属性：正在拉弓时为 1
			ItemProperties.register(ScItems.STONE_BOW.get(),
					ResourceLocation.fromNamespaceAndPath(SC_ID, "pulling"),
					(stack, level, living, seed) -> {
						if (living == null || !living.isUsingItem() || living.getUseItem() != stack) {
							return 0.0F;
						}
						return 1.0F;
					});
		});
	}

>>>>>>> main
	/** 注册粒子渲染器 */
	@SubscribeEvent
	public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
	}
<<<<<<< HEAD
	
=======

>>>>>>> main
	/**
	 * 注册菜单渲染器
	 */
	@SubscribeEvent
	public static void registerMenuScreens(RegisterMenuScreensEvent event) {
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> main
