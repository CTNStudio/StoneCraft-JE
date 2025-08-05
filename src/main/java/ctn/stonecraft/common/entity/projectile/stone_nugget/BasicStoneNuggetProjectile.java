package ctn.stonecraft.common.entity.projectile.stone_nugget;

import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;
import net.minecraft.core.Position;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BasicStoneNuggetProjectile<I extends AbsStoneNuggetItem> extends AbsStoneNuggetProjectile<I> {
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, Position pos, Level level) {
		super(snpProperties, pos.x(), pos.y(), pos.z(), level);
	}
	
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, Position pos, Level level) {
		super(snpProperties, entityType, pos.x(), pos.y(), pos.z(), level);
	}
	
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, double x, double y, double z, Level level) {
		super(snpProperties, x, y, z, level);
	}
	
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, double x, double y, double z, Level level) {
		super(snpProperties, entityType, x, y, z, level);
	}
	
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, Level level) {
		super(snpProperties, level);
	}
	
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, Level level) {
		super(snpProperties, entityType, level);
	}
	
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, LivingEntity shooter, Level level) {
		super(snpProperties, shooter, level);
	}
	
	public BasicStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, LivingEntity shooter, Level level) {
		super(snpProperties, entityType, shooter, level);
	}
}
