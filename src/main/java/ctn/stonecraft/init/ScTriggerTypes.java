package ctn.stonecraft.init;

import ctn.stonecraft.common.trigger.CountCriterionTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.core.StoneCraft.ID;

public class ScTriggerTypes {
	public static final DeferredRegister<CriterionTrigger<?>> REGISTER = DeferredRegister.create(Registries.TRIGGER_TYPE, ID);

	public static final Supplier<CountCriterionTrigger> COUNT_CRITERION_TRIGGER = REGISTER.register("count_criterion_trigger", CountCriterionTrigger::new);
}
