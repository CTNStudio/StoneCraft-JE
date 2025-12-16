package ctn.stonecraft.common.item.stone_nugget;

import com.mojang.datafixers.util.Function4;
import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.StoneNuggetProjectileBuilder;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

/**
 * 抽象石粒物品
 * 实现了可以作为弹射物使用的物品的基本功能
 */
public abstract class AbsStoneNuggetItem extends Item implements ProjectileItem {
  private final BaseNuggetProps                                                                                   baseNuggetProps;      //石粒基本属性
	private       StoneNuggetProjectileBuilder                                                                      stoneNuggetProperties;
	private final Function<AbsStoneNuggetItem, StoneNuggetProjectileBuilder>                                        stoneNuggetPropertiesProvider;
	private final Function4<StoneNuggetProjectileBuilder, LivingEntity, Level, ItemStack, AbsStoneNuggetProjectile> playerProjectileFactory;
	private final Function4<StoneNuggetProjectileBuilder, Position, Level, ItemStack, AbsStoneNuggetProjectile>     positionProjectileFactory;

	/**
	 * 构造函数，创建一个新的石粒物品
	 *
	 * @param properties         物品属性
	 * @param stoneNuggetBuilder 石粒构建器，包含石粒的各种属性和工厂方法
	 */
	public AbsStoneNuggetItem(Item.Properties properties, StoneNuggetBuilder stoneNuggetBuilder) {
		super(properties);
		this.baseNuggetProps                       = stoneNuggetBuilder.nuggetProps;
		this.stoneNuggetPropertiesProvider = stoneNuggetBuilder.snpProperties;
		this.playerProjectileFactory       = stoneNuggetBuilder.projectilePlayer;
		this.positionProjectileFactory     = stoneNuggetBuilder.projectilePosition;
		DispenserBlock.registerProjectileBehavior(this);
	}

	/**
	 * 将物品作为弹射物实体创建
	 *
	 * @param level     世界对象
	 * @param pos       位置
	 * @param stack     物品堆
	 * @param direction 方向
	 * @return 创建的弹射物实体
	 */
	@Override
	public @NotNull Projectile asProjectile(@NotNull Level level, @NotNull Position pos, @NotNull ItemStack stack, @NotNull Direction direction) {
		@NotNull AbsStoneNuggetProjectile projectile = getProjectile(level, pos, null);
		projectile.setItem(stack);
		return projectile;
	}

	/**
	 * 处理物品的使用事件
	 *
	 * @param level  世界对象
	 * @param player 使用物品的玩家
	 * @param hand   使用物品的手
	 * @return 交互结果
	 */
	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		level.playSound(
				null,
				player.getX(),
				player.getY(),
				player.getZ(),
				SoundEvents.SNOWBALL_THROW,
				SoundSource.NEUTRAL,
				0.5F,
				0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F)
		);
		if (!level.isClientSide) {
			AbsStoneNuggetProjectile projectile = createProjectile(level, player, itemstack, hand);
			level.addFreshEntity(projectile);
		}

		player.awardStat(Stats.ITEM_USED.get(this));
		itemstack.consume(1, player);
		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}

	/**
	 * 根据玩家创建弹射物
	 *
	 * @param level     世界对象
	 * @param player    玩家
	 * @param itemstack 物品堆
	 * @param hand      使用的手
	 * @return 创建的弹射物
	 */
	protected AbsStoneNuggetProjectile createProjectile(Level level, Player player, ItemStack itemstack, InteractionHand hand) {
		AbsStoneNuggetProjectile projectile = getProjectile(level, player, null);
		projectile.setItem(itemstack);
		float velocity = 1.5F;
		// 如果玩家有力量效果，增加发射速度
		if (player.hasEffect(MobEffects.DAMAGE_BOOST)) {
			MobEffectInstance effect = player.getEffect(MobEffects.DAMAGE_BOOST);
			if (effect != null) {
				velocity += (effect.getAmplifier() + 1) * 0.05F;
			}
		}
		projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity, getInaccuracy(velocity));
		return projectile;
	}

	/**
	 * 获取发射的偏移
	 *
	 * @param velocity 弹射速度
	 * @return 发射的偏移
	 */
	protected float getInaccuracy(float velocity) {
		return 1.5f + 1 * (velocity * 0.1f);
	}

	/**
	 * 获取玩家发射的弹射物实例
	 *
	 * @param level   世界对象
	 * @param shooter 玩家
	 * @return 弹射物实例
	 */
	public @NotNull AbsStoneNuggetProjectile getProjectile(@NotNull Level level, @NotNull LivingEntity shooter, @Nullable ItemStack weapon) {
		getStoneNuggetProperties();
		return playerProjectileFactory.apply(stoneNuggetProperties, shooter, level, weapon);
	}

	/**
	 * 获取指定位置的弹射物实例
	 *
	 * @param level 世界对象
	 * @param pos   位置
	 * @return 弹射物实例
	 */
	public @NotNull AbsStoneNuggetProjectile getProjectile(@NotNull Level level, @NotNull Position pos, @Nullable ItemStack weapon) {
		getStoneNuggetProperties();
		return positionProjectileFactory.apply(stoneNuggetProperties, pos, level, weapon);
	}

	/**
	 * 获取石粒投射物属性，如果尚未初始化则进行初始化
	 */
	private void getStoneNuggetProperties() {
		if (stoneNuggetProperties == null) {
			stoneNuggetProperties = stoneNuggetPropertiesProvider.apply(this);
		}
	}

	//region get方法

	/**
	 * 获取石粒的基础伤害值
	 *
	 * @return 基础伤害值
	 */
	public float damage() { return this.baseNuggetProps.damage; }

	/**
	 * 获取石粒的重量
	 *
	 * @return 重量值
	 */
	public float weight() {
		return this.baseNuggetProps.weight;
	}

	/**
	 * 获取石粒的重力值
	 *
	 * @return 重力值
	 */
	public double gravity() {
		return this.baseNuggetProps.gravity;
	}
	//endregion
}
