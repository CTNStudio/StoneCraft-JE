package ctn.stonecraft.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScDamageType {
  public static final DeferredRegister<DamageType> DAMAGE_TYPE =
      DeferredRegister.create(Registries.DAMAGE_TYPE, SC_ID);

  public static final DeferredHolder<DamageType, DamageType> DIG = DAMAGE_TYPE.register("dig",
      () -> new DamageType("dig", DamageScaling.NEVER, 0.0F,
          DamageEffects.FREEZING));
}
