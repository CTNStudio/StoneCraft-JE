package ctn.stonecraft.init;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.BasicStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.SnpProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;

/**
 * 实体类型注册类
 * <p>
 * 该类负责注册游戏中的所有实体类型，包括投射物等实体
 */
public class ScEntityTypes {
	/**
	 * 实体类型注册器
	 * 用于向Minecraft注册实体类型
	 */
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(Registries.ENTITY_TYPE, SC_ID);
	
	/**
	 * 石头粒投射物实体类型
	 * 用于注册石头粒投射物实体
	 */
	public static final Supplier<EntityType<AbsStoneNuggetProjectile>> STONE_NUGGET =
			registerDefaultStoneNugget("stone_nugget",
					(entityType, level) ->
							new BasicStoneNuggetProjectile(SnpProperties.builder(), entityType, level));
	
	/**
	 * 注册投射物实体类型（使用自定义构建器）
	 *
	 * @param name     实体名称
	 * @param function 实体构建器函数
	 * @param factory  实体工厂，用于创建实体实例
	 * @param <T>      投射物实体类型
	 * @return 实体类型供应器
	 */
	private static <T extends AbsStoneNuggetProjectile> @NotNull Supplier<EntityType<T>> registerStoneNugget(
			String name, BiFunction<EntityType.Builder<T>, EntityType.EntityFactory<T>, EntityType.Builder<T>> function, EntityType.EntityFactory<T> factory) {
		// 应用构建器函数并设置客户端追踪范围和更新间隔
		return registerEntity(name, function.apply(EntityType.Builder.of(factory, MobCategory.MISC), factory)
				.clientTrackingRange(4)
				.updateInterval(10));
	}
	
	/**
	 * 注册默认配置的投射物实体类型
	 *
	 * @param name    实体名称
	 * @param factory 实体工厂，用于创建实体实例
	 * @param <T>     投射物实体类型
	 * @return 实体类型供应器
	 */
	private static <T extends AbsStoneNuggetProjectile> @NotNull Supplier<EntityType<T>> registerDefaultStoneNugget(String name, EntityType.EntityFactory<T> factory) {
		// 使用默认大小(0.25f, 0.15f)注册投射物实体
		return registerStoneNugget(name, (b, f) -> b.sized(0.25f, 0.15f), factory);
	}
	
	/**
	 * 注册实体类型
	 *
	 * @param name 实体名称
	 * @param sup  实体类型构建器
	 * @param <I>  实体类型
	 * @return 实体类型供应器
	 */
	private static <I extends Entity> Supplier<EntityType<I>> registerEntity(final String name, final EntityType.Builder<I> sup) {
		return register(name, () -> sup.build(name));
	}
	
	/**
	 * 向注册器注册实体类型
	 *
	 * @param name 实体名称
	 * @param sup  实体类型供应器
	 * @param <I>  实体类型
	 * @return 注册后的实体类型持有者
	 */
	private static <I extends EntityType<?>> DeferredHolder<EntityType<?>, I> register(final String name, final Supplier<? extends I> sup) {
		return ENTITY_TYPE.register(name, sup);
	}
}