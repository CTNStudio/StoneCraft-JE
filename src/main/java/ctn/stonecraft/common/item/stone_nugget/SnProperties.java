package ctn.stonecraft.common.item.stone_nugget;

import com.mojang.datafixers.util.Function3;
import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.SnpProperties;
import net.minecraft.core.Position;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 石粒属性构建器
 */
public final class SnProperties<I extends AbsStoneNuggetItem, P extends AbsStoneNuggetProjectile> {
	float  damage       = 4.0f;  // 伤害
	float  damageRandom = 0.0f;  // 伤害浮动
	float  weight       = 1.0f;  // 重量
	double gravity      = 0.03f; // 重力（下坠）
	
	Function3<SnpProperties<I>, Level, Player, Supplier<P>> projectile1;
	Function3<SnpProperties<I>, Level, Position, Supplier<P>> projectile2;
	
	public SnProperties(Supplier<I> defaultItem, SnpProperties<I> snpProperties,
			BiFunction<Supplier<I>, SnpProperties<I>, Function3<SnpProperties<I>, Level, Player, Supplier<P>>> projectile1,
			BiFunction<Supplier<I>, SnpProperties<I>, Function3<SnpProperties<I>, Level, Position, Supplier<P>>> projectile2) {
		this.projectile1 = projectile1.apply(defaultItem, snpProperties);
		this.projectile2 = projectile2.apply(defaultItem, snpProperties);
	}
	
	public SnProperties<I, P> hurt(float hurt) {
		this.damage = hurt;
		return this;
	}
	
	public SnProperties<I, P> weight(float weight) {
		this.weight = weight;
		return this;
	}
	
	public SnProperties<I, P> gravity(double gravity) {
		this.gravity = gravity;
		return this;
	}
	
	public SnProperties<I, P> hurtRandom(float hurtRandom) {
		this.damageRandom = hurtRandom;
		return this;
	}
}