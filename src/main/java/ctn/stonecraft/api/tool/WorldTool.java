package ctn.stonecraft.api.tool;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;

public class WorldTool {
	/**
	 * 获取指定位置的流体状态
	 */
	public static FluidState getFluidState(Level level, double x, double y, double z) {
		return getFluidState(level, BlockPos.containing(x, y, z));
	}
	
	/**
	 * 获取指定位置的流体状态
	 */
	public static FluidState getFluidState(Level level, Position pos) {
		return getFluidState(level, BlockPos.containing(pos));
	}
	
	/**
	 * 获取指定位置的流体状态
	 */
	public static FluidState getFluidState(Level level, BlockPos pos) {
		return level.getFluidState(pos);
	}
	
	/**
	 * 判断指定位置是否处于指定流体状态中
	 */
	public static boolean isInFluid(Level level,FluidState fluidState, BlockPos fluidPos, Position pos) {
		double posY = pos.y();
		int fluidPosY = fluidPos.getY();
		float floatHeight = getFloatHeight(level, fluidState, fluidPos);
		// 先进行垂直方向的边界检查
		if (posY < fluidPosY || posY >= floatHeight) {
			return false;
		}
		// 获取流体的实际高度并进行精确判断
		return posY < floatHeight;
	}
	
	/**
	 * 判断指定位置是否处于指定流体状态中
	 */
	public static boolean isInFluid(Level level, FluidState fluidState, Position pos) {
		return isInFluid(level, fluidState, BlockPos.containing(pos), pos);
	}
	
	/**
	 * 获取流体高度坐标
	 */
	public static float getFloatHeight(Level level,FluidState fluidState, BlockPos fluidPos) {
		return fluidPos.getY() + fluidState.getHeight(level, fluidPos);
	}
	
	/**
	 * 获取流体高度坐标
	 */
	public static float getFloatHeight(Level level, FluidState fluidState, Position pos) {
		return getFloatHeight(level, fluidState, BlockPos.containing(pos));
	}
	
	/**
	 * 获取流体高度坐标
	 */
	public static float getFloatHeight(Level level,FluidState fluidState, double x, double y, double z) {
		return getFloatHeight(level, fluidState, BlockPos.containing(x, y, z));
	}
	
	/**
	 * 从速度向量获取水平角度（Yaw）
	 *
	 * @param movement 速度向量
	 * @return 水平角度（度数）
	 */
	public static float getYawFromVelocity(Vec3 movement) {
		// 使用atan2计算角度，结果为弧度
		double yawRadians = Math.atan2(movement.z, movement.x);
		// 转换为度数并调整为Minecraft的方向系统
		float yaw = (float) Math.toDegrees(yawRadians) - 90.0F;
		// 确保角度在-180到180之间
		while (yaw < -180.0F) yaw += 360.0F;
		while (yaw >= 180.0F) yaw -= 360.0F;
		return yaw;
	}
	
	/**
	 * 从速度向量获取垂直角度（Pitch）
	 *
	 * @param movement 速度向量
	 * @return 垂直角度（度数）
	 */
	public static float getPitchFromVelocity(Vec3 movement) {
		// 计算水平距离
		double horizontalDistance = Math.sqrt(movement.x * movement.x + movement.z * movement.z);
		// 计算垂直角度
		double pitchRadians = Math.atan2(movement.y, horizontalDistance);
		// 转换为度数
		return (float) Math.toDegrees(pitchRadians);
	}
}
