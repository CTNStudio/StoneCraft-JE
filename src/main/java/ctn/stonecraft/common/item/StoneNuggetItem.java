package ctn.stonecraft.common.item;

import ctn.stonecraft.common.entity.projectile.AbsStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.StoneNuggetProjectile;
import net.minecraft.core.Position;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StoneNuggetItem extends AbsStoneNuggetItem{
	public StoneNuggetItem(Item.Properties properties, Properties snProperties, ItemLike material) {
		super(properties, snProperties, material);
	}
	
	@Override
	public @NotNull StoneNuggetProjectile getStoneNuggetProjectile(@NotNull Level level,@NotNull Player player) {
		return new StoneNuggetProjectile(AbsStoneNuggetProjectile.Properties.builder(), player, level);
	}
	
	@Override
	public @NotNull StoneNuggetProjectile getStoneNuggetProjectile(@NotNull Level level, @NotNull Position pos) {
		return new StoneNuggetProjectile(AbsStoneNuggetProjectile.Properties.builder(), pos, level);
	}
}
