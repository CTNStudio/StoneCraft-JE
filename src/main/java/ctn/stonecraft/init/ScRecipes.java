package ctn.stonecraft.init;

import ctn.stonecraft.core.StoneCraft;
import ctn.stonecraft.datagen.recipe.stone_converting.StoneConvertingRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * 配方类型注册
 */
public class ScRecipes {
  // 配方类型注册器
  public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES_REGISTER = DeferredRegister.create(Registries.RECIPE_TYPE, StoneCraft.ID);

  // 配方序列化器注册器
  public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS_REGISTER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, StoneCraft.ID);

  // 注册配方类型
  public static final DeferredHolder<RecipeType<?>, RecipeType<StoneConvertingRecipe>> STONE_CONVERTING_TYPE =
    RECIPE_TYPES_REGISTER.register("stone_converting",
      () -> new RecipeType<>() {
        @Override
        public String toString() {
          return "stone_converting";
        }
      });

  // 注册配方序列化器
  public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<StoneConvertingRecipe>> STONE_CONVERTING_SERIALIZER =
    RECIPE_SERIALIZERS_REGISTER.register("stone_converting",
      StoneConvertingRecipe.Serializer::new);

  public static void register(IEventBus eventBus) {
    RECIPE_TYPES_REGISTER.register(eventBus);
    RECIPE_SERIALIZERS_REGISTER.register(eventBus);
  }
}
