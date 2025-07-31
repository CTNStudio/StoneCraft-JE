package ctn.stonecraft.events;

import ctn.stonecraft.datagen.tool.TextureMapBuilder;
import ctn.stonecraft.init.ScItems;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.StoneCraft.path;

/**
 * 物品渲染附加
 */
@EventBusSubscriber(modid = SC_ID)
public class ItemPropertyEvents {
	// TODO 待完善
	// 物品堆叠 0~0.63
	public static final ResourceLocation STACKING = path("stacking");
	
	public static final ClampedItemPropertyFunction STACKING_PRICE =
			(itemStack, clientLevel, livingEntity, seed) -> {
				float correctValue = 1.0f;
				for (int i = 0, j = String.valueOf(itemStack.getMaxStackSize()).length(); i < j; i++) {
					correctValue *= 0.1f;
				}
				return TextureMapBuilder.round((itemStack.getCount() - 1) * correctValue);
			};
	
	public static final ClampedItemPropertyFunction STACKING_PRICE_64 =
			(itemStack, clientLevel, livingEntity, seed) -> TextureMapBuilder.round((itemStack.getCount() - 1) * 0.01f);
	
	/**
	 * 注册物品渲染附加
	 */
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		createStackingProperties64(event, ScItems.STONE_COIN, STACKING);
	}
	
	// 创建物品堆叠属性
	private static void createStackingProperties64(FMLClientSetupEvent event, ItemLike item, ResourceLocation propertiesName) {
		event.enqueueWork(() -> ItemProperties.register(item.asItem(), propertiesName, STACKING_PRICE_64));
	}
	
	private static void createStackingProperties(FMLClientSetupEvent event, ItemLike item, ResourceLocation propertiesName) {
		event.enqueueWork(() -> ItemProperties.register(item.asItem(), propertiesName, STACKING_PRICE));
	}
}
