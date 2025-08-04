package ctn.stonecraft.common.entity.projectile;

import ctn.stonecraft.common.item.AbsStoneNuggetItem;
import ctn.stonecraft.init.ScItems;
import net.minecraft.core.Position;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class StoneNuggetProjectile extends AbsStoneNuggetProjectile {
	public StoneNuggetProjectile(Properties properties, Position pos, Level level) {
		super(properties, pos.x(), pos.y(), pos.z(), level);
	}
	
	public StoneNuggetProjectile(Properties properties, EntityType<AbsStoneNuggetProjectile> entityType, Position pos, Level level) {
		super(properties, entityType, pos.x(), pos.y(), pos.z(), level);
	}
	
	public StoneNuggetProjectile(Properties properties, double x, double y, double z, Level level) {
		super(properties, x, y, z, level);
	}
	
	public StoneNuggetProjectile(Properties properties, EntityType<AbsStoneNuggetProjectile> entityType, double x, double y, double z, Level level) {
		super(properties, entityType, x, y, z, level);
	}
	
	public StoneNuggetProjectile(Properties properties, Level level) {
		super(properties, level);
	}
	
	public StoneNuggetProjectile(Properties properties, EntityType<AbsStoneNuggetProjectile> entityType, Level level) {
		super(properties, entityType, level);
	}
	
	public StoneNuggetProjectile(Properties properties, LivingEntity shooter, Level level) {
		super(properties, shooter, level);
	}
	
	public StoneNuggetProjectile(Properties properties, EntityType<AbsStoneNuggetProjectile> entityType, LivingEntity shooter, Level level) {
		super(properties, entityType, shooter, level);
	}
	
	@Override
	protected @NotNull AbsStoneNuggetItem getDefaultItem() {
		return ScItems.STONE_NUGGET.get();
	}
}
