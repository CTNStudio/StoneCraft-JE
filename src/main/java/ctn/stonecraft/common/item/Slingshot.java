package ctn.stonecraft.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class Slingshot extends ProjectileWeaponItem {
	private final int chargingTime;
	private final float damageMultiplier;
	
	public Slingshot(Item.Properties properties, Properties properties2) {
		super(properties);
		this.chargingTime     = properties2.chargingTime;
		this.damageMultiplier = properties2.damageMultiplier;
	}
	
	/**
	 * @deprecated Use ItemStack sensitive version {@link ProjectileWeaponItem#getAllSupportedProjectiles(ItemStack)}
	 */
	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return null;
	}
	
	@Override
	public int getDefaultProjectileRange() {
		return 7;
	}
	
	@Override
	protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
	
	}
	
	/**
	 * Override this method if the weapon stack allows special projectile that would only be used if it's in hand.
	 * The default return value is a union-predicate of {@link ProjectileWeaponItem#getAllSupportedProjectiles(ItemStack)}
	 * and {@link ProjectileWeaponItem#getSupportedHeldProjectiles()}
	 *
	 * @param stack The ProjectileWeapon stack
	 * @return A predicate that returns true for supported projectile stack in hand
	 */
	public Predicate<ItemStack> getSupportedHeldProjectiles(ItemStack stack) {
		return getAllSupportedProjectiles(stack).or(getSupportedHeldProjectiles());
	}
	
	/**
	 * Override this method if the allowed projectile is weapon stack dependent.
	 *
	 * @param stack The ProjectileWeapon stack
	 * @return A predicate that returns true for all supported projectile stack
	 */
	public Predicate<ItemStack> getAllSupportedProjectiles(ItemStack stack) {
		return getAllSupportedProjectiles();
	}
	
	public int getChargingTime() {
		return chargingTime;
	}
	
	public float getDamageMultiplier() {
		return damageMultiplier;
	}
	
	public static class Properties{
		private int chargingTime = 20 * 3;      // 满蓄力所需时间
		private float damageMultiplier = 1.0f;  // 伤害系数
		public static Properties builder() {
			return new Properties();
		}
		
		private Properties() {
		}
		
		public Properties chargingTime(int chargingTime) {
			this.chargingTime = chargingTime;
			return this;
		}
		
		public Properties damageMultiplier(float damageMultiplier) {
			this.damageMultiplier = damageMultiplier;
			return this;
		}
	}
}
