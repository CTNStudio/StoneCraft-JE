package ctn.stonecraft.init;

import ctn.stonecraft.common.entity.projectile.StoneNuggetProjectile;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;

public class ScEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(Registries.ENTITY_TYPE, SC_ID);
	
	public static final Supplier<EntityType<StoneNuggetProjectile>> STONE_NUGGET = registerEntity("stone_nugget",
			EntityType.Builder.<StoneNuggetProjectile>of(StoneNuggetProjectile::new, MobCategory.MISC)
					.sized(0.25f, 0.15f)
					.clientTrackingRange(4)
					.updateInterval(10));
	
	private static <I extends Entity> Supplier<EntityType<I>> registerEntity(final String name, final EntityType.Builder<I> sup) {
		return register(name, () -> sup.build(name));
	}
	
	private static <I extends EntityType<?>> DeferredHolder<EntityType<?>, I> register(final String name, final Supplier<? extends I> sup) {
		return ENTITY_TYPE.register(name, sup);
	}
}
