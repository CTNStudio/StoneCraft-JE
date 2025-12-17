package ctn.stonecraft.datagen.recipe.stone_converting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * 石头转换台配方
 */
public class StoneConvertingRecipe implements Recipe<SingleRecipeInput> {

  private final String group;           // 配方分组
  private final Ingredient ingredient;  // 输入材料
  private final int inputCount;         // 输入数量
  private final ItemStack result;       // 输出物品


  public StoneConvertingRecipe(String group, Ingredient ingredient, int inputCount, ItemStack result) {
    this.group = group;
    this.ingredient = ingredient;
    this.inputCount = inputCount;
    this.result = result;
  }

  // 检查玩家放入的物品是否符合配方要求
  @Override
  public boolean matches(SingleRecipeInput singleRecipeInput, @NotNull Level level) {
    ItemStack inputStack = singleRecipeInput.getItem(0);
    return this.ingredient.test(inputStack) && inputStack.getCount() >= this.inputCount;
  }

  // 配方合成逻辑
  @Override
  public @NotNull ItemStack assemble(@NotNull SingleRecipeInput singleRecipeInput, HolderLookup.@NotNull Provider provider) {
    return this.result.copy(); //防止多个玩家共享同一个 ItemStack 对象
  }

  // 配方尺寸检查
  @Override
  public boolean canCraftInDimensions(int i, int i1) {
    return true;
  }

  // 获取输入物品数量
  public int getInputCount() {
    return this.inputCount;
  }

  // 获取输出物品
  @Override
  public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
    return this.result;
  }

  // 获取配方分组
  @Override
  public @NotNull String getGroup() {
    return this.group;
  }

  // 定义解锁提示显示的图标（建议显示你的机器图标）
  @Override
  public @NotNull ItemStack getToastSymbol() {
    return new ItemStack(ScBlocks.STONE_CONVERTING_TABLE.get());
  }

  // 输入材料
  public Ingredient getIngredient() {
    return this.ingredient;
  }

  @Override
  public @NotNull NonNullList<Ingredient> getIngredients() {
    NonNullList<Ingredient> list = NonNullList.create();
    list.add(this.ingredient);
    return list;
  }

  // 返回配方的序列化器
  @Override
  public @NotNull RecipeSerializer<?> getSerializer() {
    return ScRecipes.STONE_CONVERTING_SERIALIZER.get();
  }

  // 返回配方的类型标识符
  @Override
  public @NotNull RecipeType<?> getType() {
    return ScRecipes.STONE_CONVERTING_TYPE.get();
  }

  /**
   * 配方序列化器
   */
  public static class Serializer implements RecipeSerializer<StoneConvertingRecipe> {

    private static final MapCodec<StoneConvertingRecipe> CODEC =
      RecordCodecBuilder.mapCodec(instance -> instance.group(
        Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
        Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
        Codec.INT.optionalFieldOf("input_count", 1).forGetter(recipe -> recipe.inputCount),
        ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result)
      ).apply(instance, StoneConvertingRecipe::new));

    private static final StreamCodec<RegistryFriendlyByteBuf, StoneConvertingRecipe> STREAM_CODEC = StreamCodec.composite(
      StreamCodec.of(RegistryFriendlyByteBuf::writeUtf, RegistryFriendlyByteBuf::readUtf),
      recipe -> recipe.group,
      Ingredient.CONTENTS_STREAM_CODEC,
      recipe -> recipe.ingredient,
      ByteBufCodecs.INT,
      recipe -> recipe.inputCount,
      ItemStack.STREAM_CODEC,
      recipe -> recipe.result,
      StoneConvertingRecipe::new
    );


    @Override
    public @NotNull MapCodec<StoneConvertingRecipe> codec() {
      return CODEC;
    }

    @Override
    public @NotNull StreamCodec<RegistryFriendlyByteBuf, StoneConvertingRecipe> streamCodec() {
      return STREAM_CODEC;
    }
  }

}
