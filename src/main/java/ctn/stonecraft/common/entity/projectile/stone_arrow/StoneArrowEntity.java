package ctn.stonecraft.common.entity.projectile.stone_arrow;

import ctn.stonecraft.init.ScEntityTypes;
import ctn.stonecraft.init.ScItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Nullable;

public class StoneArrowEntity extends AbstractArrow {

    public StoneArrowEntity(EntityType<? extends StoneArrowEntity> type, Level level) {
        super(type, level);
        this.setBaseDamage(1.0D);
    }

    public StoneArrowEntity(Level level, LivingEntity shooter, ItemStack pickupItem, @Nullable ItemStack weapon) {
        super(ScEntityTypes.STONE_ARROW.get(), shooter, level, pickupItem, weapon);
    }

    public StoneArrowEntity(Level level, double x, double y, double z, ItemStack pickupItem, @Nullable ItemStack weapon) {
        super(ScEntityTypes.STONE_ARROW.get(), x, y, z, level, pickupItem, weapon);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(ScItems.STONE_ARROW.get());
    }

    // ---- 岩浆每 tick 4 点 ----
    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide && this.isInLava()) {
            this.hurt(this.damageSources().lava(), 4.0F);
        }
    }

    private boolean isFromPlayer() {
        return this.getOwner() instanceof Player;
    }

    private boolean isFromPillager() {
        Entity owner = this.getOwner();
        return owner != null && owner.getType() == EntityType.PILLAGER;
    }

    private boolean isHardDifficulty() {
        return this.level().getDifficulty() == Difficulty.HARD;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity target = result.getEntity();
        double damage;

        if (isFromPlayer()) {
            //暴击固定 10
            damage = 1.0D + this.random.nextDouble();
            if (this.isCritArrow()) {
                damage = 10.0D;
            }
        } else if (isFromPillager()) {
            damage = 3.0D + this.random.nextDouble() * 4.0D;
        } else if (isHardDifficulty()) {
            // 缓慢 10 tick
            damage = 6.0D + this.random.nextDouble() * 2.0D;
            if (target instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 0), this);
            }
        } else {
            // 默认 damage [1,5]
            damage = 1.0D + this.random.nextDouble() * 4.0D;
        }

        Entity owner = this.getOwner();
        net.minecraft.world.damagesource.DamageSource source =
                this.damageSources().arrow(this, owner == null ? this : owner);

        if (target.hurt(source, (float) damage)) {
            if (target instanceof LivingEntity living) {
                this.doPostHurtEffects(living);
            }
        }

        // 原版命中音效
        if (target instanceof Player) {
            this.playSound(SoundEvents.ARROW_HIT_PLAYER, 1.0F,
                    1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        } else {
            this.playSound(SoundEvents.ARROW_HIT, 1.0F,
                    1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
        }
    }

    // ---- 原版插地逻辑 ----

    @Override
    protected float getWaterInertia() {
        return 0.6F;
    }
}