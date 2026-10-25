package ctn.stonecraft.init;

import ctn.stonecraft.common.block.StoneConvertTableBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, SC_ID);

    public static final Supplier<BlockEntityType<StoneConvertTableBlockEntity>> STONE_CONVERT_TABLE =
            BLOCK_ENTITIES.register("stone_convert_table",
                    () -> BlockEntityType.Builder.of(
                            StoneConvertTableBlockEntity::new,
                            ScBlocks.STONE_CONVERT_TABLE.get()
                    ).build(null));
}