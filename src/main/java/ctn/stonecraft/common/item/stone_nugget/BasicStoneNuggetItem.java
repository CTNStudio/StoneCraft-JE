package ctn.stonecraft.common.item.stone_nugget;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import net.minecraft.world.item.Item;

public class BasicStoneNuggetItem<P extends AbsStoneNuggetProjectile, I extends AbsStoneNuggetItem> extends AbsStoneNuggetItem<P, I> {
	public BasicStoneNuggetItem(Item.Properties properties, SnProperties<I, P> snSnProperties) {
		super(properties, snSnProperties);
	}
}
