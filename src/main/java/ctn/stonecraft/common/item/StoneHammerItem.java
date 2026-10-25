package ctn.stonecraft.common.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class StoneHammerItem extends PickaxeItem {

    private final float digSpeed;
    private final Supplier<ItemLike> repairMaterial;

    public StoneHammerItem(Tier tier, float digSpeed, Supplier<ItemLike> repairMaterial, Properties properties) {
        super(tier, properties);
        this.digSpeed = digSpeed;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return this.digSpeed;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(this.repairMaterial.get().asItem());
    }
}