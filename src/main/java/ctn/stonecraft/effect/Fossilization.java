package ctn.stonecraft.effect;

import ctn.stonecraft.init.ScDamageType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.PickaxeItem;

import java.awt.*;

public class Fossilization extends MobEffect {
  protected Fossilization() {
    super(MobEffectCategory.HARMFUL, Color.GRAY.getRGB());
  }

  // TODO - 移动到伤害事件。
  @Override
  @Deprecated
  public void onMobHurt(LivingEntity livingEntity, int amplifier, DamageSource damageSource, float amount) {
    super.onMobHurt(livingEntity, amplifier, damageSource, amount);
    if (!(damageSource.getEntity() instanceof Player player)) {
      return;
    }

    final var itemInHand = player.getItemInHand(player.getUsedItemHand());
    if (itemInHand.isEmpty()) {
      return;
    }

    if (itemInHand.getItem() instanceof PickaxeItem) {
      final var addonDamage = 1.2f * amount;
      livingEntity.hurt(new DamageSource(ScDamageType.DIG), addonDamage);
    }
  }
}
