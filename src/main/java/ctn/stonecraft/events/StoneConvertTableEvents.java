package ctn.stonecraft.events;

import ctn.stonecraft.StoneCraft;
import ctn.stonecraft.init.ScBlocks;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static ctn.stonecraft.StoneCraft.SC_ID;

@EventBusSubscriber(modid = SC_ID)
public class StoneConvertTableEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) {
            return;
        }
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }
        if (!event.getLevel().getBlockState(event.getPos()).is(ScBlocks.STONE_CONVERT_TABLE.get())) {
            return;
        }

        // grant 进度
        AdvancementHolder advancement = player.server.getAdvancements()
                .get(ResourceLocation.fromNamespaceAndPath(SC_ID, "stone_adventure/stone_convert"));
        if (advancement != null) {
            player.getAdvancements().award(advancement, "use_stone_convert_table");
        }
    }
}