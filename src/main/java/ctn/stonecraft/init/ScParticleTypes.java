package ctn.stonecraft.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

import static ctn.stonecraft.core.StoneCraft.ID;

public class ScParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTER = DeferredRegister.create(Registries.PARTICLE_TYPE, ID);

}
