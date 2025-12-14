package ctn.stonecraft.init;

import ctn.stonecraft.core.StoneCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.core.StoneCraft.ID;

public class ScSoundEvents {
	public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(Registries.SOUND_EVENT, ID);

	private static Supplier<SoundEvent> registerVariableRange(String name) {
		return REGISTER.register(name, () -> SoundEvent.createVariableRangeEvent(StoneCraft.modRL(name)));
	}

	private static Supplier<SoundEvent> registerFixedRange(String name, float range) {
		return REGISTER.register(name, () -> SoundEvent.createFixedRangeEvent(StoneCraft.modRL(name), range));
	}
}
