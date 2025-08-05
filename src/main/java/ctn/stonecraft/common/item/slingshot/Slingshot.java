package ctn.stonecraft.common.item.slingshot;

import ctn.stonecraft.datagen.ScTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class Slingshot extends ProjectileWeaponItem {
	public static final Predicate<ItemStack> STONE_NUGGET_ONLY = itemStack -> itemStack.is(ScTags.ScItems.STONE_NUGGET);
	private final       int                  chargingTime;
	private final       float                damageMultiplier;
	
	public Slingshot(Item.Properties properties, SlingshotProperties slingshotProperties2) {
		super(properties);
		this.chargingTime     = slingshotProperties2.chargingTime;
		this.damageMultiplier = slingshotProperties2.damageMultiplier;
	}
	
	/**
	 * @deprecated
	 */
	@Override
	@Deprecated
	public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
		return STONE_NUGGET_ONLY;
	}
	
	@Override
	public int getDefaultProjectileRange() {
		return 7;
	}
	
	@Override
	protected void shootProjectile(@NotNull LivingEntity shooter, Projectile projectile,
			int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
		if (shooter.hasEffect(MobEffects.DAMAGE_BOOST)) {
			MobEffectInstance effect = shooter.getEffect(MobEffects.DAMAGE_BOOST);
			if (effect != null) {
				velocity += (effect.getAmplifier() + 1) * 0.01F;
			}
		}
		velocity *= damageMultiplier;
		projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
	}
	
	public @NotNull Predicate<ItemStack> getAllSupportedProjectiles(ItemStack stack) {
		return STONE_NUGGET_ONLY;
	}
	
	public int getChargingTime() {
		return chargingTime;
	}
	
	public float getDamageMultiplier() {
		return damageMultiplier;
	}
	
	
}
