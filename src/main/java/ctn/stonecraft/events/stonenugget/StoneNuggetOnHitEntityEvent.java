package ctn.stonecraft.events.stonenugget;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * 石粒投射物击中实体事件
 * <p>
 * 当石粒投射物击中实体时触发此事件，分为Pre和Post两个阶段
 */
public abstract class StoneNuggetOnHitEntityEvent extends StoneNuggetEvent {
	private final EntityHitResult oldResult;
	private final Level           oldLevel;
	private final Entity          oldBeHitEntity;
	private final double          oldMovementSpeed;
	private final Entity          oldOwner;
	private final float           oldHurt;
	private final DamageSource    oldDamageSource;
	private final int             oldImpactsCount;

	/**
	 * 构造函数
	 *
	 * @param entity        石粒投射物实体
	 * @param result        实体击中结果
	 * @param level         世界对象
	 * @param beHitEntity   被击中的实体
	 * @param movementSpeed 运动速度
	 * @param owner         投射物拥有者
	 * @param hurt          伤害值
	 * @param damageSource  伤害源
	 * @param impactsCount  剩余撞击次数
	 */
	public StoneNuggetOnHitEntityEvent(AbsStoneNuggetProjectile entity, EntityHitResult result, Level level,
			Entity beHitEntity, double movementSpeed, Entity owner, float hurt,
			DamageSource damageSource, int impactsCount) {
		super(entity);
		this.oldResult        = result;
		this.oldLevel         = level;
		this.oldBeHitEntity   = beHitEntity;
		this.oldMovementSpeed = movementSpeed;
		this.oldOwner         = owner;
		this.oldHurt          = hurt;
		this.oldDamageSource  = damageSource;
		this.oldImpactsCount  = impactsCount;
	}

	/**
	 * 获取原始伤害源
	 *
	 * @return 原始伤害源
	 */
	public DamageSource getOldDamageSource() {
		return oldDamageSource;
	}

	/**
	 * 获取原始剩余撞击次数
	 *
	 * @return 原始剩余撞击次数
	 */
	public int getOldImpactsCount() {
		return oldImpactsCount;
	}

	/**
	 * 击中实体前事件
	 * <p>
	 * 在石粒投射物实际对实体造成伤害前触发，可取消并允许修改伤害值和伤害源
	 */
	public static class Pre extends StoneNuggetOnHitEntityEvent implements ICancellableEvent {
		private float        newHurt;
		private DamageSource newDamageSource;
		private int          newImpactsCount;

		/**
		 * 构造函数
		 *
		 * @param entity        石粒投射物实体
		 * @param result        实体击中结果
		 * @param level         世界对象
		 * @param beHitEntity   被击中的实体
		 * @param movementSpeed 运动速度
		 * @param owner         投射物拥有者
		 * @param hurt          伤害值
		 * @param damageSource  伤害源
		 * @param impactsCount  剩余撞击次数
		 */
		public Pre(AbsStoneNuggetProjectile entity, EntityHitResult result, Level level, Entity beHitEntity,
				double movementSpeed, Entity owner, float hurt, DamageSource damageSource,
				int impactsCount) {
			super(entity, result, level, beHitEntity, movementSpeed, owner, hurt, damageSource, impactsCount);
			this.newHurt         = hurt;
			this.newDamageSource = damageSource;
			this.newImpactsCount = impactsCount;
		}

		/**
		 * 获取新的伤害值
		 *
		 * @return 新的伤害值
		 */
		public float getNewHurt() {
			return newHurt;
		}

		/**
		 * 设置新的伤害值
		 *
		 * @param newHurt 新的伤害值
		 */
		public void setNewHurt(float newHurt) {
			this.newHurt = newHurt;
		}

		/**
		 * 获取新的伤害源
		 *
		 * @return 新的伤害源
		 */
		public DamageSource getNewDamageSource() {
			return newDamageSource;
		}

		/**
		 * 设置新的伤害源
		 *
		 * @param newDamageSource 新的伤害源
		 */
		public void setNewDamageSource(DamageSource newDamageSource) {
			this.newDamageSource = newDamageSource;
		}

		/**
		 * 获取新的剩余撞击次数
		 *
		 * @return 新的剩余撞击次数
		 */
		public int getNewImpactsCount() {
			return newImpactsCount;
		}

		/**
		 * 设置新的剩余撞击次数
		 *
		 * @param newImpactsCount 新的剩余撞击次数
		 */
		public void setNewImpactsCount(int newImpactsCount) {
			this.newImpactsCount = newImpactsCount;
		}
	}

	/**
	 * 击中实体后事件
	 * <p>
	 * 在石粒投射物对实体造成伤害后触发
	 */
	public static class Post extends StoneNuggetOnHitEntityEvent {
		/**
		 * 构造函数
		 *
		 * @param entity        石粒投射物实体
		 * @param result        实体击中结果
		 * @param level         世界对象
		 * @param beHitEntity   被击中的实体
		 * @param movementSpeed 运动速度
		 * @param owner         投射物拥有者
		 * @param hurt          伤害值
		 * @param damageSource  伤害源
		 * @param impactsCount  剩余撞击次数
		 */
		public Post(AbsStoneNuggetProjectile entity, EntityHitResult result, Level level, Entity beHitEntity,
				double movementSpeed, Entity owner, float hurt, DamageSource damageSource,
				int impactsCount) {
			super(entity, result, level, beHitEntity, movementSpeed, owner, hurt, damageSource, impactsCount);
		}
	}

	/**
	 * 获取原始伤害值
	 *
	 * @return 原始伤害值
	 */
	public float getOldHurt() {
		return oldHurt;
	}

	/**
	 * 获取原始实体击中结果
	 *
	 * @return 原始实体击中结果
	 */
	public EntityHitResult getOldResult() {
		return oldResult;
	}

	/**
	 * 获取原始世界对象
	 *
	 * @return 原始世界对象
	 */
	public Level getOldLevel() {
		return oldLevel;
	}

	/**
	 * 获取原始被击中实体
	 *
	 * @return 原始被击中实体
	 */
	public Entity getOldBeHitEntity() {
		return oldBeHitEntity;
	}

	/**
	 * 获取原始运动速度
	 *
	 * @return 原始运动速度
	 */
	public double getOldMovementSpeed() {
		return oldMovementSpeed;
	}

	/**
	 * 获取原始投射物拥有者
	 *
	 * @return 原始投射物拥有者
	 */
	public Entity getOldOwner() {
		return oldOwner;
	}
}
