package ctn.stonecraft.init;

import ctn.stonecraft.StoneCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScSoundEvents {
	public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(Registries.SOUND_EVENT, SC_ID);
	
	private static Supplier<SoundEvent> registerVariableRange(String name) {
		return SOUND_EVENT.register(name, () -> SoundEvent.createVariableRangeEvent(StoneCraft.path(name)));
	}
	
	private static Supplier<SoundEvent> registerFixedRange(String name, float range) {
		return SOUND_EVENT.register(name, () -> SoundEvent.createFixedRangeEvent(StoneCraft.path(name), range));
	}
}