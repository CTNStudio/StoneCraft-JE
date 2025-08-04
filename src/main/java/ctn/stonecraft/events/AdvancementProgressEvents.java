package ctn.stonecraft.events;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AdvancementEvent;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.api.tool.NbtTool.getOrCreateCompoundTag;
import static ctn.stonecraft.common.trigger.CountCriterionTrigger.ADVANCEMENT;

/**
 * 进度事件
 */
@EventBusSubscriber(modid = SC_ID)
public class AdvancementProgressEvents {
	
	@SubscribeEvent
	public static void executeCommand(AdvancementEvent.AdvancementProgressEvent event) {
		if (!(event.getEntity() instanceof ServerPlayer player)) {
			return;
		}
		if (event.getProgressType() != AdvancementEvent.AdvancementProgressEvent.ProgressType.REVOKE) {
			return;
		}
		ResourceLocation advancement = event.getAdvancement().id();
		
		CompoundTag nbt = player.getPersistentData();
		CompoundTag scNbt = getOrCreateCompoundTag(nbt, SC_ID);
		CompoundTag advancementNbt = getOrCreateCompoundTag(scNbt, ADVANCEMENT);
		ResourceLocation tenStonesEaten = ResourceLocation.fromNamespaceAndPath(SC_ID, "ten_stones_eaten");
		
		if (advancement.equals(tenStonesEaten)) {
			advancementNbt.remove(tenStonesEaten.toString());
		}
	}
}
