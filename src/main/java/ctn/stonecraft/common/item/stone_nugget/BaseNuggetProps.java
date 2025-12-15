package ctn.stonecraft.common.item.stone_nugget;

/**
 * 基础弹弓弹药属性
 */
public class  BaseNuggetProps{

  public float damage;
  public float weight;
  public double gravity;

  public BaseNuggetProps() {
    this(2.0f, 1.0f, 0.03f);
  }
  public BaseNuggetProps(float damage, float weight, double gravity) {
    this.damage = damage;
    this.weight = weight;
    this.gravity = gravity;
  }

  /**
   * 默认石粒属性
   */
  public static BaseNuggetProps defaultStoneNuggetProps() {
    return new BaseNuggetProps(2.0f, 1.0f, 0.03f);
  }

  /**
   * 默认燧石属性
   */
  public static BaseNuggetProps defaultFlintNuggetProps() {
    return new BaseNuggetProps(3.0f, 1.15f, 0.05f);
  }

}
