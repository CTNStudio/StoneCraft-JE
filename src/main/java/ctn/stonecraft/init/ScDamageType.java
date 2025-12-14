package ctn.stonecraft.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static ctn.stonecraft.core.StoneCraft.ID;

public class ScDamageType {
  public static final DeferredRegister<DamageType> REGISTER =
      DeferredRegister.create(Registries.DAMAGE_TYPE, ID);

  public static final DeferredHolder<DamageType, DamageType> DIG = REGISTER.register("dig",
      () -> new DamageType("dig", DamageScaling.NEVER, 0.0F,
          DamageEffects.FREEZING));
}
