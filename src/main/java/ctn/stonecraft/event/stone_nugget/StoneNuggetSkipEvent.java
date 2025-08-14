package ctn.stonecraft.event.stone_nugget;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * 石粒投射物弹射事件
 * <p>
 * 该事件在石粒投射物执行弹射逻辑时触发，分为Pre和Post两个阶段
 */
public abstract class StoneNuggetSkipEvent extends StoneNuggetEvent {
	private final Vec3       oldDeltaMovement;
	private final float      oldFloatHeight;
	private final Level      level;
	private final Vec3       movement;
	private final FluidState fluidState;
	private final Vec3       bottomPos;
	private final float      absPitch;
	private final Vec3       pos;
	
	/**
	 * 构造函数
	 *
	 * @param entity           石粒投射物实体
	 * @param oldDeltaMovement 原始运动向量
	 * @param oldFloatHeight   原始浮起高度
	 * @param level            世界对象
	 * @param movement         当前运动向量
	 * @param fluidState       流体状态
	 * @param bottomPos        底部位置
	 * @param absPitch         绝对俯仰角
	 * @param pos              位置
	 */
	public StoneNuggetSkipEvent(AbsStoneNuggetProjectile entity, Vec3 oldDeltaMovement, float oldFloatHeight,
			final Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos) {
		super(entity);
		this.oldDeltaMovement = oldDeltaMovement;
		this.oldFloatHeight   = oldFloatHeight;
		this.level            = level;
		this.movement         = movement;
		this.fluidState       = fluidState;
		this.bottomPos        = bottomPos;
		this.absPitch         = absPitch;
		this.pos              = pos;
	}
	
	/**
	 * 获取原始运动向量
	 *
	 * @return 原始运动向量
	 */
	public Vec3 getOldDeltaMovement() {
		return oldDeltaMovement;
	}
	
	/**
	 * 获取原始浮起高度
	 *
	 * @return 原始浮起高度
	 */
	public float getOldFloatHeight() {
		return oldFloatHeight;
	}
	
	/**
	 * 获取世界对象
	 *
	 * @return 世界对象
	 */
	public Level getLevel() {
		return level;
	}
	
	/**
	 * 获取当前运动向量
	 *
	 * @return 当前运动向量
	 */
	public Vec3 getMovement() {
		return movement;
	}
	
	/**
	 * 获取流体状态
	 *
	 * @return 流体状态
	 */
	public FluidState getFluidState() {
		return fluidState;
	}
	
	/**
	 * 获取底部位置
	 *
	 * @return 底部位置
	 */
	public Vec3 getBottomPos() {
		return bottomPos;
	}
	
	/**
	 * 获取绝对俯仰角
	 *
	 * @return 绝对俯仰角
	 */
	public float getAbsPitch() {
		return absPitch;
	}
	
	/**
	 * 获取位置
	 *
	 * @return 位置
	 */
	public Vec3 getPos() {
		return pos;
	}
	
	/**
	 * 弹射前事件
	 * <p>
	 * 在石粒投射物执行弹射逻辑之前触发，允许修改弹射参数
	 * <p>
	 * 可以取消
	 */
	public static class Pre extends StoneNuggetSkipEvent implements ICancellableEvent {
		private Vec3  newDeltaMovement;
		private float newFloatHeight;
		
		/**
		 * 构造函数
		 *
		 * @param entity        石粒投射物实体
		 * @param deltaMovement 运动向量
		 * @param floatHeight   浮起高度
		 * @param level         世界对象
		 * @param movement      当前运动向量
		 * @param fluidState    流体状态
		 * @param bottomPos     底部位置
		 * @param absPitch      绝对俯仰角
		 * @param pos           位置
		 */
		public Pre(AbsStoneNuggetProjectile entity, Vec3 deltaMovement, float floatHeight,
				final Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos) {
			super(entity, deltaMovement, floatHeight, level, movement, fluidState, bottomPos, absPitch, pos);
			this.newDeltaMovement = deltaMovement;
			this.newFloatHeight   = floatHeight;
		}
		
		/**
		 * 获取新的运动向量
		 *
		 * @return 新的运动向量
		 */
		public Vec3 getNewDeltaMovement() {
			return newDeltaMovement;
		}
		
		/**
		 * 设置新的运动向量
		 *
		 * @param newDeltaMovement 新的运动向量
		 */
		public void setNewDeltaMovement(Vec3 newDeltaMovement) {
			this.newDeltaMovement = newDeltaMovement;
		}
		
		/**
		 * 获取新的浮起高度
		 *
		 * @return 新的浮起高度
		 */
		public float getNewFloatHeight() {
			return newFloatHeight;
		}
		
		/**
		 * 设置新的浮起高度
		 *
		 * @param newFloatHeight 新的浮起高度
		 */
		public void setNewFloatHeight(float newFloatHeight) {
			this.newFloatHeight = newFloatHeight;
		}
	}
	
	/**
	 * 弹射后事件
	 * <p>
	 * 在石粒投射物执行弹射逻辑之后触发
	 * <p>
	 * 无法取消
	 */
	public static class Post extends StoneNuggetSkipEvent {
		/**
		 * 构造函数
		 *
		 * @param entity        石粒投射物实体
		 * @param deltaMovement 运动向量
		 * @param floatHeight   浮起高度
		 * @param level         世界对象
		 * @param movement      当前运动向量
		 * @param fluidState    流体状态
		 * @param bottomPos     底部位置
		 * @param absPitch      绝对俯仰角
		 * @param pos           位置
		 */
		public Post(AbsStoneNuggetProjectile entity, Vec3 deltaMovement, float floatHeight,
				final Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos) {
			super(entity, deltaMovement, floatHeight, level, movement, fluidState, bottomPos, absPitch, pos);
		}
	}
}
