package ctn.stonecraft.core;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import ctn.stonecraft.events.stonenugget.StoneNuggetOnHitBlockEvent;
import ctn.stonecraft.events.stonenugget.StoneNuggetOnHitEntityEvent;
import ctn.stonecraft.events.stonenugget.StoneNuggetSkipEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;

public class StoneCraftEventHooks {
	//region 石粒投射物事件

	/**
	 * 触发石粒投射物弹射前事件
	 * <p>
	 * 在石粒投射物于流体表面弹射之前触发此事件，允许修改弹射参数
	 *
	 * @param projectile    石粒投射物实体
	 * @param level         世界对象
	 * @param movement      当前运动向量
	 * @param fluidState    流体状态
	 * @param bottomPos     底部位置
	 * @param absPitch      绝对俯仰角
	 * @param pos           位置
	 * @param deltaMovement 运动向量
	 * @param floatHeight   浮起高度
	 * @return StoneNuggetSkipEvent.Pre事件对象，可用于检查事件是否被取消
	 */
	public static StoneNuggetSkipEvent.Pre stoneNuggetSkipPre(AbsStoneNuggetProjectile projectile, Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos, Vec3 deltaMovement, float floatHeight) {
		return NeoForge.EVENT_BUS.post(new StoneNuggetSkipEvent.Pre(projectile, deltaMovement, floatHeight, level, movement, fluidState, bottomPos, absPitch, pos));
	}

	/**
	 * 触发石粒投射物弹射后事件
	 * <p>
	 * 在石粒投射物于流体表面弹射之后触发此事件
	 *
	 * @param level                    世界对象
	 * @param movement                 当前运动向量
	 * @param fluidState               流体状态
	 * @param bottomPos                底部位置
	 * @param absPitch                 绝对俯仰角
	 * @param pos                      位置
	 * @param deltaMovement            运动向量
	 * @param floatHeight              浮起高度
	 * @param absStoneNuggetProjectile 石粒投射物实体
	 */
	public static void stoneNuggetSkipPost(Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos, Vec3 deltaMovement, float floatHeight, AbsStoneNuggetProjectile absStoneNuggetProjectile) {
		NeoForge.EVENT_BUS.post(new StoneNuggetSkipEvent.Post(absStoneNuggetProjectile, deltaMovement, floatHeight, level, movement, fluidState, bottomPos, absPitch, pos));
	}

	/**
	 * 触发石粒投射物击中方块前事件
	 * <p>
	 * 在石粒投射物击中方块之前触发此事件，允许修改击中参数或取消事件
	 *
	 * @param projectile   石粒投射物实体
	 * @param result       方块击中结果
	 * @param level        世界对象
	 * @param blockpos     方块位置
	 * @param blockState   方块状态
	 * @param isBreakable  是否可破坏
	 * @param impactsCount 撞击次数
	 * @param bouncesCount 弹跳次数
	 * @return StoneNuggetOnHitBlockEvent.Pre事件对象，可用于检查事件是否被取消
	 */
	public static StoneNuggetOnHitBlockEvent.Pre stoneNuggetOnHitBlockPre(AbsStoneNuggetProjectile projectile, @NotNull BlockHitResult result, Level level, BlockPos blockpos, BlockState blockState, boolean isBreakable, int impactsCount, int bouncesCount) {
		return NeoForge.EVENT_BUS.post(new StoneNuggetOnHitBlockEvent.Pre(projectile, result, level, blockpos, blockState, isBreakable, impactsCount, bouncesCount));
	}

	/**
	 * 触发石粒投射物击中方块后事件
	 * <p>
	 * 在石粒投射物击中方块之后触发此事件
	 *
	 * @param result                   方块击中结果
	 * @param level                    世界对象
	 * @param blockpos                 方块位置
	 * @param blockState               方块状态
	 * @param isBreakable              是否可破坏
	 * @param absStoneNuggetProjectile 石粒投射物实体
	 * @param impactsCount             撞击次数
	 * @param bouncesCount             弹跳次数
	 */
	public static void stoneNuggetOnHitBlockPost(@NotNull BlockHitResult result, Level level, BlockPos blockpos, BlockState blockState, boolean isBreakable, AbsStoneNuggetProjectile absStoneNuggetProjectile, int impactsCount, int bouncesCount) {
		NeoForge.EVENT_BUS.post(new StoneNuggetOnHitBlockEvent.Post(absStoneNuggetProjectile, result, level, blockpos, blockState, isBreakable, impactsCount, bouncesCount));
	}

	/**
	 * 触发石粒投射物击中实体前事件
	 * <p>
	 * 在石粒投射物击中实体并造成伤害之前触发此事件，允许修改伤害值或取消事件
	 *
	 * @param projectile    石粒投射物实体
	 * @param result        实体击中结果
	 * @param level         世界对象
	 * @param entity        被击中的实体
	 * @param movementSpeed 运动速度
	 * @param owner         投射物拥有者
	 * @param hurt          伤害值
	 * @param damageSource  伤害源
	 * @param impactsCount  剩余撞击次数
	 * @return StoneNuggetOnHitEntityEvent.Pre事件对象，可用于检查事件是否被取消
	 */
	public static StoneNuggetOnHitEntityEvent.Pre stoneNuggetOnHitEntityPre(AbsStoneNuggetProjectile projectile, @NotNull EntityHitResult result, Level level, Entity entity, double movementSpeed, Entity owner, float hurt, DamageSource damageSource, int impactsCount) {
		return NeoForge.EVENT_BUS.post(new StoneNuggetOnHitEntityEvent.Pre(projectile, result, level, entity, movementSpeed, owner, hurt, damageSource, impactsCount));
	}

	/**
	 * 触发石粒投射物击中实体后事件
	 * <p>
	 * 在石粒投射物击中实体并造成伤害之后触发此事件
	 *
	 * @param result                   实体击中结果
	 * @param level                    世界对象
	 * @param entity                   被击中的实体
	 * @param movementSpeed            运动速度
	 * @param owner                    投射物拥有者
	 * @param hurt                     伤害值
	 * @param damageSource             伤害源
	 * @param absStoneNuggetProjectile 石粒投射物实体
	 * @param impactsCount             剩余撞击次数
	 */
	public static void stoneNuggetOnHitEntityPost(@NotNull EntityHitResult result, Level level, Entity entity, double movementSpeed, Entity owner, float hurt, DamageSource damageSource, AbsStoneNuggetProjectile absStoneNuggetProjectile, int impactsCount) {
		NeoForge.EVENT_BUS.post(new StoneNuggetOnHitEntityEvent.Post(absStoneNuggetProjectile, result, level, entity, movementSpeed, owner, hurt, damageSource, impactsCount));
	}
	//endregion
}
