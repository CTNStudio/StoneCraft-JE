package ctn.stonecraft.common.item.stone_nugget;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 抽象石粒物品
 */
public abstract class AbsStoneNuggetItem<P extends AbsStoneNuggetProjectile, I extends AbsStoneNuggetItem> extends Item implements ProjectileItem {
	private final     float                                    damage;
	private final     float                                    damageRandom;
	private final     float                                    weight;
	private final     double                                   gravity;
	private final     BiFunction<Level, Player, Supplier<P>>   projectile1;
	private final     BiFunction<Level, Position, Supplier<P>> projectile2;
	
	public AbsStoneNuggetItem(Item.Properties properties, SnProperties<I, P> snSnProperties) {
		super(properties);
		this.damage       = snSnProperties.damage;
		this.damageRandom = snSnProperties.damageRandom;
		this.weight       = snSnProperties.weight;
		this.gravity      = snSnProperties.gravity;
		this.projectile1 = snSnProperties.projectile1;
		this.projectile2 = snSnProperties.projectile2;
	}
	
	@Override
	public @NotNull Projectile asProjectile(@NotNull Level level, @NotNull Position pos, @NotNull ItemStack stack, @NotNull Direction direction) {
		@NotNull P projectile = getProjectile(level, pos);
		projectile.setItem(stack);
		return projectile;
	}
	
	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
//		level.playSound(
//				null,
//				player.getX(),
//				player.getY(),
//				player.getZ(),
//				SoundEvents.EGG_THROW, TODO：添加自己的声音
//				SoundSource.PLAYERS,
//				0.5F,
//				0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F)
//		);
		if (!level.isClientSide) {
			Projectile freshEntity = getFreshEntity(level, player, itemstack, hand);
			level.addFreshEntity(freshEntity);
		}
		
		player.awardStat(Stats.ITEM_USED.get(this));
		itemstack.consume(1, player);
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
	
	/**
	 * 射弹
	 */
	protected Projectile getFreshEntity(Level level, Player player, ItemStack itemstack, InteractionHand hand) {
		P projectile = getProjectile(level, player);
		projectile.setItem(itemstack);
		float velocity = 1.5F;
		if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
			MobEffectInstance effect = player.getEffect(MobEffects.DAMAGE_BOOST);
			if (effect != null) {
				velocity += (effect.getAmplifier() + 1) * 0.01F;
			}
		}
		velocity *= weight;
		projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity, 0);
		return projectile;
	}
	
	
	public @NotNull P getProjectile(@NotNull Level level, @NotNull Player player) {
		return projectile1.apply(level, player).get();
	}
	
	public @NotNull P getProjectile(@NotNull Level level, @NotNull Position pos) {
		return projectile2.apply(level, pos).get();
	}
	
	//region get方法
	public float getDamage() {
		return damage;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	public float getDamageRandom() {
		return damageRandom;
	}
	//endregion
	
	
}
