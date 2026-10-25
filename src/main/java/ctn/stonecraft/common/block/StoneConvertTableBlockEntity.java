package ctn.stonecraft.common.block;

import ctn.stonecraft.init.ScBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StoneConvertTableBlockEntity extends BlockEntity {
    public StoneConvertTableBlockEntity(BlockPos pos, BlockState state) {
        super(ScBlockEntities.STONE_CONVERT_TABLE.get(), pos, state);
    }
}