package ctn.stonecraft.common.entity.projectile.stone_nugget;

import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;
import ctn.stonecraft.common.item.stone_nugget.BaseNuggetProps;

import java.util.function.Supplier;

/**
 * 石粒投射物构建器
 */
public final class StoneNuggetProjectileBuilder {
	double verticalVelocityLowAngleFactor  = 0.7;
	double verticalVelocityHighAngleFactor = 1.3;
	double lowAngleThreshold               = 10.0;
	double highAngleThreshold              = 10.0;
	float  maxBounceAngle                  = 20.0f;
	float  minBounceAngle                  = 0.0f;
	float  minBounceSpeed                  = 0.001f;
  final Supplier<AbsStoneNuggetItem> projectileItem;
  final BaseNuggetProps baseNuggetProps;

	public StoneNuggetProjectileBuilder(Supplier<AbsStoneNuggetItem> projectileItem) {
		this.projectileItem = projectileItem;
    var item = projectileItem.get();
    this.baseNuggetProps = new BaseNuggetProps(item.Damage(), item.Weight(), item.Gravity());
	}

	public StoneNuggetProjectileBuilder(AbsStoneNuggetItem absStoneNuggetItem) {
		projectileItem = () -> absStoneNuggetItem;
    var item = projectileItem.get();
    this.baseNuggetProps = new BaseNuggetProps(item.Damage(), item.Weight(), item.Gravity());
	}

  /**
   * 根据投掷物属性创建通用构建器-用于兼容原版物品
   */
  public StoneNuggetProjectileBuilder (BaseNuggetProps baseNuggetProps) {
    projectileItem = null;
    this.baseNuggetProps = baseNuggetProps;
  }

	public StoneNuggetProjectileBuilder verticalVelocityLowAngleFactor(double factor) {
		this.verticalVelocityLowAngleFactor = factor;
		return this;
	}

	public StoneNuggetProjectileBuilder verticalVelocityHighAngleFactor(double factor) {
		this.verticalVelocityHighAngleFactor = factor;
		return this;
	}

	public StoneNuggetProjectileBuilder lowAngleThreshold(double threshold) {
		this.lowAngleThreshold = threshold;
		return this;
	}

	public StoneNuggetProjectileBuilder highAngleThreshold(double threshold) {
		this.highAngleThreshold = threshold;
		return this;
	}

	public StoneNuggetProjectileBuilder maxBounceAngle(float angle) {
		this.maxBounceAngle = angle;
		return this;
	}

	public StoneNuggetProjectileBuilder minBounceAngle(float angle) {
		this.minBounceAngle = angle;
		return this;
	}

	public StoneNuggetProjectileBuilder minBounceSpeed(float speed) {
		this.minBounceSpeed = speed;
		return this;
	}
}
