package ctn.stonecraft.events;

import ctn.stonecraft.init.ScItems;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;

/**
 * 物品事件
 */
@EventBusSubscriber
public class ItemEvents {
	@SubscribeEvent
	public static void modifyDefaultComponentsFrom(ModifyDefaultComponentsEvent event) {
		
		// 修改耐久
		modifyMaxDamage(event, ScItems.VERSATILE_STONE_TOOL);
		modifyMaxDamage(event, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1);
		modifyMaxDamage(event, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2);
		modifyMaxDamage(event, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3);
		modifyMaxDamage(event, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4);
		modifyMaxDamage(event, ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5);
	}
	
	private static void modifyMaxDamage(ModifyDefaultComponentsEvent event, DeferredItem<Item> versatileStoneTool) {
		TieredItem tieredItem = (TieredItem) versatileStoneTool.get();
		int value = tieredItem.getTier().getUses() * 4;
		event.modify(versatileStoneTool, builder -> builder.set(DataComponents.MAX_DAMAGE, value));
	}
}
