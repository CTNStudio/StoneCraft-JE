package ctn.stonecraft.common.item;

import ctn.stonecraft.common.entity.projectile.AbsStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.StoneNuggetProjectile;
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
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * 抽象石粒物品
 */
public abstract class AbsStoneNuggetItem extends Item implements ProjectileItem {
	private final float damage;
	private final float damageRandom;
	private final float weight;
	private final double   gravity;
	
	public AbsStoneNuggetItem(Item.Properties properties, Properties snProperties, ItemLike material) {
		super(properties);
		this.damage       = snProperties.damage;
		this.damageRandom = snProperties.damageRandom;
		this.weight       = snProperties.weight;
		this.gravity    = snProperties.gravity;
	}
	
	@Override
	public @NotNull Projectile asProjectile(@NotNull Level level, @NotNull Position pos, @NotNull ItemStack stack, @NotNull Direction direction) {
		AbsStoneNuggetProjectile projectile = getStoneNuggetProjectile(level, pos);
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
		AbsStoneNuggetProjectile projectile = getStoneNuggetProjectile(level, player);
		projectile.setItem(itemstack);
		float velocity = 1.5F;
		if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
			MobEffectInstance effect = player.getEffect(MobEffects.DAMAGE_BOOST);
			if (effect != null) {
				velocity += (effect.getAmplifier() + 1) * 0.01F;
			}
		}
		velocity /= weight;
		projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity, 0);
		return projectile;
	}
	
	
	public abstract @NotNull StoneNuggetProjectile getStoneNuggetProjectile(@NotNull Level level,@NotNull Player player);
	public abstract @NotNull StoneNuggetProjectile getStoneNuggetProjectile(@NotNull Level level, @NotNull Position pos);
	
	
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
	
	/**
	 * 石粒属性构建器
	 */
	public static class Properties {
		/// 伤害
		private float damage       = 4.0f;
		/// 伤害浮动
		private float damageRandom = 0.0f;
		/// 重量
		private float weight       = 1f;
		/// 重力（下坠）
		private double gravity    = 0.03f;
		
		public void hurt(float hurt) {
			this.damage = hurt;
		}
		
		public void weight(float weight) {
			this.weight = weight;
		}
		
		public void gravity(double gravity) {
			this.gravity = gravity;
		}
		
		public void hurtRandom(float hurtRandom) {
			this.damageRandom = hurtRandom;
		}
	}
}
