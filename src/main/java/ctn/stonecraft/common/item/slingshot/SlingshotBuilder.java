package ctn.stonecraft.common.item.slingshot;

/**
 * 弹弓构建器属性
 */
public final class SlingshotBuilder {
	int   chargingTime     = 20; // 满蓄力所需时间
	float damageMultiplier = 1.0f;   // 伤害加成系数
	float damageBonus      = 0f;     // 伤害加成
	float speedBonus       = 0.0f;   // 速度加成
	
	public SlingshotBuilder() {
	}
	
	public SlingshotBuilder chargingTime(int chargingTime) {
		this.chargingTime = chargingTime;
		return this;
	}
	
	public SlingshotBuilder damageMultiplier(float damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
		return this;
		
	}
	
	public SlingshotBuilder speedBonus(float speedBonus) {
		this.speedBonus = speedBonus;
		return this;
	}
	
	public SlingshotBuilder damageBonus(float damageBonus) {
		this.damageBonus = damageBonus;
		return this;
	}
}