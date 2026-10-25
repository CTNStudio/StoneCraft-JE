package ctn.stonecraft.init;

import ctn.stonecraft.common.trigger.CountCriterionTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScTriggerTypes {
	public static final DeferredRegister<CriterionTrigger<?>> TRIGGER_TYPES = DeferredRegister.create(Registries.TRIGGER_TYPE, SC_ID);
	
	public static final Supplier<CountCriterionTrigger> COUNT_CRITERION_TRIGGER = TRIGGER_TYPES.register("count_criterion_trigger", CountCriterionTrigger::new);
}
