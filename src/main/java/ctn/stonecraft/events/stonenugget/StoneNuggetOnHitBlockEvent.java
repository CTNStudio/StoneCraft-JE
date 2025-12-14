package ctn.stonecraft.events.stonenugget;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.ICancellableEvent;

/**
 * 石粒投射物击中方块事件
 * <p>
 * 当石粒投射物击中方块时触发此事件，分为Pre和Post两个阶段
 */
public abstract class StoneNuggetOnHitBlockEvent extends StoneNuggetEvent {
	private final BlockHitResult oldResult;
	private final Level          oldLevel;
	private final BlockPos       oldBlockpos;
	private final BlockState     oldBlockState;
	private final boolean        oldIsBreakable;
	private final int            oldImpactsCount;
	private final int            oldBouncesCount;

	/**
	 * 构造函数
	 *
	 * @param entity       石粒投射物实体
	 * @param result       方块击中结果
	 * @param level        世界对象
	 * @param blockpos     方块位置
	 * @param blockState   方块状态
	 * @param isBreakable  是否可破坏
	 * @param impactsCount 撞击次数
	 * @param bouncesCount 弹跳次数
	 */
	public StoneNuggetOnHitBlockEvent(AbsStoneNuggetProjectile entity, BlockHitResult result,
			Level level, BlockPos blockpos, BlockState blockState,
			boolean isBreakable, int impactsCount, int bouncesCount) {
		super(entity);
		this.oldResult       = result;
		this.oldLevel        = level;
		this.oldBlockpos     = blockpos;
		this.oldBlockState   = blockState;
		this.oldIsBreakable  = isBreakable;
		this.oldImpactsCount = impactsCount;
		this.oldBouncesCount = bouncesCount;
	}

	/**
	 * 获取原始弹跳次数
	 *
	 * @return 原始弹跳次数
	 */
	public int getOldBouncesCount() {
		return oldBouncesCount;
	}

	/**
	 * 获取原始撞击次数
	 *
	 * @return 原始撞击次数
	 */
	public int getOldImpactsCount() {
		return oldImpactsCount;
	}

	/**
	 * 获取原始是否可破坏状态
	 *
	 * @return 原始是否可破坏状态
	 */
	public boolean isOldIsBreakable() {
		return oldIsBreakable;
	}

	/**
	 * 获取原始方块状态
	 *
	 * @return 原始方块状态
	 */
	public BlockState getOldBlockState() {
		return oldBlockState;
	}

	/**
	 * 获取原始方块位置
	 *
	 * @return 原始方块位置
	 */
	public BlockPos getOldBlockpos() {
		return oldBlockpos;
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
	 * 获取原始方块击中结果
	 *
	 * @return 原始方块击中结果
	 */
	public BlockHitResult getOldResult() {
		return oldResult;
	}

	/**
	 * 击中方块前事件
	 * <p>
	 * 在石粒投射物实际击中方块前触发，可取消并允许修改相关参数
	 */
	public static class Pre extends StoneNuggetOnHitBlockEvent implements ICancellableEvent {
		private boolean newIsBreakable;
		private int     newImpactsCount;
		private int     newBouncesCount;

		/**
		 * 构造函数
		 *
		 * @param entity       石粒投射物实体
		 * @param result       方块击中结果
		 * @param level        世界对象
		 * @param blockpos     方块位置
		 * @param blockState   方块状态
		 * @param isBreakable  是否可破坏
		 * @param impactsCount 撞击次数
		 * @param bouncesCount 弹跳次数
		 */
		public Pre(AbsStoneNuggetProjectile entity, BlockHitResult result, Level level, BlockPos blockpos, BlockState blockState, boolean isBreakable, int impactsCount, int bouncesCount) {
			super(entity, result, level, blockpos, blockState, isBreakable, impactsCount, bouncesCount);
			this.newIsBreakable  = isBreakable;
			this.newBouncesCount = bouncesCount;
			this.newImpactsCount = impactsCount;
		}

		/**
		 * 获取新的是否可破坏状态
		 *
		 * @return 新的是否可破坏状态
		 */
		public boolean isNewIsBreakable() {
			return newIsBreakable;
		}

		/**
		 * 设置新的是否可破坏状态
		 *
		 * @param newIsBreakable 新的是否可破坏状态
		 */
		public void setNewIsBreakable(boolean newIsBreakable) {
			this.newIsBreakable = newIsBreakable;
		}

		/**
		 * 获取新的弹跳次数
		 *
		 * @return 新的弹跳次数
		 */
		public int getNewBouncesCount() {
			return newBouncesCount;
		}

		/**
		 * 设置新的弹跳次数
		 *
		 * @param newBouncesCount 新的弹跳次数
		 */
		public void setNewBouncesCount(int newBouncesCount) {
			this.newBouncesCount = newBouncesCount;
		}

		/**
		 * 获取新的撞击次数
		 *
		 * @return 新的撞击次数
		 */
		public int getNewImpactsCount() {
			return newImpactsCount;
		}

		/**
		 * 设置新的撞击次数
		 *
		 * @param newImpactsCount 新的撞击次数
		 */
		public void setNewImpactsCount(int newImpactsCount) {
			this.newImpactsCount = newImpactsCount;
		}
	}

	/**
	 * 击中方块后事件
	 * <p>
	 * 在石粒投射物击中方块后触发
	 */
	public static class Post extends StoneNuggetOnHitBlockEvent {

		/**
		 * 构造函数
		 *
		 * @param entity       石粒投射物实体
		 * @param result       方块击中结果
		 * @param level        世界对象
		 * @param blockpos     方块位置
		 * @param blockState   方块状态
		 * @param isBreakable  是否可破坏
		 * @param impactsCount 撞击次数
		 * @param bouncesCount 弹跳次数
		 */
		public Post(AbsStoneNuggetProjectile entity, BlockHitResult result, Level level, BlockPos blockpos, BlockState blockState, boolean isBreakable, int impactsCount, int bouncesCount) {
			super(entity, result, level, blockpos, blockState, isBreakable, impactsCount, bouncesCount);
		}
	}
}
