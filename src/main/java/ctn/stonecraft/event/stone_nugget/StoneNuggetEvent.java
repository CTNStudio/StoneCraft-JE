package ctn.stonecraft.event.stone_nugget;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import net.neoforged.neoforge.event.entity.EntityEvent;

/**
 * 石粒事件基类
 * <p>
 * 所有石粒相关事件的基类，继承自EntityEvent
 */
public abstract class StoneNuggetEvent extends EntityEvent {
	/**
	 * 构造函数
	 *
	 * @param entity 石粒投射物实体
	 */
	public StoneNuggetEvent(AbsStoneNuggetProjectile entity) {
		super(entity);
	}
}
