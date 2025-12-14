package ctn.stonecraft.event.client;

import ctn.ctnapi.client.util.TextureMapBuilder;
import ctn.stonecraft.common.item.slingshot.Slingshot;
import ctn.stonecraft.init.ScItems;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredItem;

import static ctn.stonecraft.core.StoneCraft.ID;
import static ctn.stonecraft.core.StoneCraft.modRL;

/**
 * 物品渲染附加
 */
@EventBusSubscriber(modid = ID)
public class ItemPropertyEvents {
	// 物品堆叠 0~0.63 对应1~64
	public static final ResourceLocation STACKING = modRL("stacking");
	public static final ResourceLocation PULL = ResourceLocation.withDefaultNamespace("pull");
	public static final ResourceLocation PULLING = ResourceLocation.withDefaultNamespace("pulling");

	public static final ClampedItemPropertyFunction STACKING_PRICE_64 = (itemStack, clientLevel, livingEntity, seed) ->
			TextureMapBuilder.round((itemStack.getCount() - 1) * 0.01f);

	public static final  ClampedItemPropertyFunction PULL_FUNCTION = (itemStack, clientLevel, livingEntity, seed) -> {
		if (livingEntity == null) {
			return 0.0F;
		} else {
			ItemStack stack = livingEntity.getUseItem();
			int useDuration = stack.getUseDuration(livingEntity);
			if (!(stack.getItem() instanceof Slingshot slingshot)) {
				return 0.0f;
			}
			int useItemRemainingTicks = livingEntity.getUseItemRemainingTicks();
			return stack != itemStack ? 0.0F : (float) (useDuration - useItemRemainingTicks) / slingshot.getChargingTime();
		}
	};

	public static final ClampedItemPropertyFunction PULLING_FUNCTION = (itemStack, clientLevel, livingEntity, seed) ->
			livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;



	/**
	 * 注册物品渲染附加
	 */
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		register(event, ScItems.STONE_COIN, STACKING, STACKING_PRICE_64);
		slingshot(event, ScItems.WOOD_SLINGSHOT);
		slingshot(event, ScItems.STONE_SLINGSHOT);
		slingshot(event, ScItems.IRON_SLINGSHOT);
		slingshot(event, ScItems.GOLD_SLINGSHOT);
		slingshot(event, ScItems.DIAMOND_SLINGSHOT);
		slingshot(event, ScItems.NETHERITE_SLINGSHOT);
	}

	private static void slingshot(FMLClientSetupEvent event, DeferredItem<Slingshot> woodSlingshot) {
		register(event, woodSlingshot, PULL, PULL_FUNCTION);
		register(event, woodSlingshot, PULLING, PULLING_FUNCTION);
	}

	private static void register(FMLClientSetupEvent event, ItemLike item, ResourceLocation name, ClampedItemPropertyFunction property) {
		event.enqueueWork(() -> ItemProperties.register(item.asItem(), name, property));
	}
}
