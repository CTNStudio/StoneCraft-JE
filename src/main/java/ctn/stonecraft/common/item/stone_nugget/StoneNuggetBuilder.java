package ctn.stonecraft.common.item.stone_nugget;

import com.mojang.datafixers.util.Function4;
import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.StoneNuggetProjectileBuilder;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Function;

/**
 * 石粒属性构建器
 */
public final class StoneNuggetBuilder {

	BaseNuggetProps nuggetProps = BaseNuggetProps.defaultStoneNuggetProps();

	final Function<AbsStoneNuggetItem, StoneNuggetProjectileBuilder>                                        snpProperties;
	final Function4<StoneNuggetProjectileBuilder, LivingEntity, Level, ItemStack, AbsStoneNuggetProjectile> projectilePlayer;
	final Function4<StoneNuggetProjectileBuilder, Position, Level, ItemStack, AbsStoneNuggetProjectile>     projectilePosition;

	public StoneNuggetBuilder(Function<AbsStoneNuggetItem, StoneNuggetProjectileBuilder> snpProperties,
			Function4<StoneNuggetProjectileBuilder, LivingEntity, Level, ItemStack, AbsStoneNuggetProjectile> projectilePlayer,
			Function4<StoneNuggetProjectileBuilder, Position, Level, ItemStack, AbsStoneNuggetProjectile> projectilePosition) {
		this.snpProperties      = snpProperties;
		this.projectilePlayer   = projectilePlayer;
		this.projectilePosition = projectilePosition;
	}

	public StoneNuggetBuilder hurt(float hurt) {
		this.nuggetProps.damage = hurt;
		return this;
	}

	public StoneNuggetBuilder weight(float weight) {
		this.nuggetProps.weight = weight;
		return this;
	}

	public StoneNuggetBuilder gravity(double gravity) {
		this.nuggetProps.gravity = gravity;
		return this;
	}
}
