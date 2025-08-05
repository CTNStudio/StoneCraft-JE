package ctn.stonecraft.common.item.slingshot;

/**
 * 弹弓构建器属性
 */
public final class SlingshotProperties {
	int   chargingTime     = 20 * 3;      // 满蓄力所需时间
	float damageMultiplier = 1.0f;  // 伤害系数
	
	public SlingshotProperties() {
	}
	
	public SlingshotProperties chargingTime(int chargingTime) {
		this.chargingTime = chargingTime;
		return this;
	}
	
	public SlingshotProperties damageMultiplier(float damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
		return this;
	}
}