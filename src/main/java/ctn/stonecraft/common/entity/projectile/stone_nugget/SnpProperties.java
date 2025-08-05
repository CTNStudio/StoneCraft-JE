package ctn.stonecraft.common.entity.projectile.stone_nugget;

import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;

import java.util.function.Supplier;

/**
 * 石粒投射物构建器
 */
public final class SnpProperties<I extends AbsStoneNuggetItem> {
	double verticalVelocityLowAngleFactor  = 0.7;
	double verticalVelocityHighAngleFactor = 1.3;
	double lowAngleThreshold               = 10.0;
	double highAngleThreshold              = 10.0;
	float  maxBounceAngle                  = 20.0f;
	float  minBounceAngle                  = 0.0f;
	float  minBounceSpeed                  = 0.001f;
	Supplier<I> defaultItem;
	
	public SnpProperties(Supplier<I> defaultItem) {
		this.defaultItem = defaultItem;
	}
	
	public SnpProperties<I> verticalVelocityLowAngleFactor(double factor) {
		this.verticalVelocityLowAngleFactor = factor;
		return this;
	}
	
	public SnpProperties<I> verticalVelocityHighAngleFactor(double factor) {
		this.verticalVelocityHighAngleFactor = factor;
		return this;
	}
	
	public SnpProperties<I> lowAngleThreshold(double threshold) {
		this.lowAngleThreshold = threshold;
		return this;
	}
	
	public SnpProperties<I> highAngleThreshold(double threshold) {
		this.highAngleThreshold = threshold;
		return this;
	}
	
	public SnpProperties<I> maxBounceAngle(float angle) {
		this.maxBounceAngle = angle;
		return this;
	}
	
	public SnpProperties<I> minBounceAngle(float angle) {
		this.minBounceAngle = angle;
		return this;
	}
	
	public SnpProperties<I> minBounceSpeed(float speed) {
		this.minBounceSpeed = speed;
		return this;
	}
}