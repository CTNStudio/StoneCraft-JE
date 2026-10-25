package ctn.stonecraft.effect;

import ctn.stonecraft.init.ScDamageType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;

import java.awt.*;

public class FossilizationLeg extends MobEffect {
  protected FossilizationLeg() {
    super(MobEffectCategory.HARMFUL, Color.GRAY.getRGB());
  }

  // TODO - 移动到伤害事件。
  @Override
  @Deprecated
  public void onMobHurt(LivingEntity livingEntity, int amplifier,
                        DamageSource damageSource, float amount) {
    super.onMobHurt(livingEntity, amplifier, damageSource, amount);

    if (!(damageSource.getEntity() instanceof Player player)) {
      return;
    }

    final var itemInHand = player.getItemInHand(player.getUsedItemHand());
    if (itemInHand.isEmpty() || !(itemInHand.getItem() instanceof PickaxeItem)) {
      return;
    }

    final var addonDamage = amplifier * 0.1f * amount;
    livingEntity.hurt(new DamageSource(ScDamageType.DIG), addonDamage);
  }
}
