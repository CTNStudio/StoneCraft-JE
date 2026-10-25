package ctn.stonecraft.common.entity.projectile.stone_nugget;

import ctn.stonecraft.init.ScEntityTypes;
import net.minecraft.core.Position;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BasicStoneNuggetProjectile extends AbsStoneNuggetProjectile {
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, EntityType<AbsStoneNuggetProjectile> entityType, Position pos, Level level, ItemStack weapon) {
		super(stoneNuggetProjectileBuilder, entityType, pos, level, weapon);
	}
	
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, EntityType<AbsStoneNuggetProjectile> entityType, double x, double y, double z, Level level, ItemStack weapon) {
		super(stoneNuggetProjectileBuilder, entityType, x, y, z, level, weapon);
	}
	
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, EntityType<AbsStoneNuggetProjectile> entityType, Level level, ItemStack weapon) {
		super(stoneNuggetProjectileBuilder, entityType, level, weapon);
	}
	
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, EntityType<AbsStoneNuggetProjectile> entityType, LivingEntity shooter, Level level, ItemStack weapon) {
		super(stoneNuggetProjectileBuilder, entityType, shooter, level, weapon);
	}
	
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, Position pos, Level level, ItemStack weapon) {
		this(stoneNuggetProjectileBuilder, ScEntityTypes.STONE_NUGGET.get(), pos, level, weapon);
	}
	
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, double x, double y, double z, Level level, ItemStack weapon) {
		this(stoneNuggetProjectileBuilder, ScEntityTypes.STONE_NUGGET.get(), x, y, z, level, weapon);
	}
	
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, Level level, ItemStack weapon) {
		this(stoneNuggetProjectileBuilder, ScEntityTypes.STONE_NUGGET.get(), level, weapon);
	}
	
	public BasicStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, LivingEntity shooter, Level level, ItemStack weapon) {
		this(stoneNuggetProjectileBuilder, ScEntityTypes.STONE_NUGGET.get(), shooter, level, weapon);
	}
}
