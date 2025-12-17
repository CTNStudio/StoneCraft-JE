package ctn.stonecraft.datagen.recipe.stone_converting;

import ctn.stonecraft.core.StoneCraft;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 石头转换台配方构建起
 */
public class StoneConvertingRecipeBuilder implements RecipeBuilder {

  private final RecipeCategory category;
  private final Ingredient ingredient;
  private int inputCount = 1;
  private final ItemStack result;
  private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

  @Nullable
  private String group;

  private StoneConvertingRecipeBuilder(RecipeCategory category, Ingredient ingredient, ItemStack result) {
    this.category = category;
    this.ingredient = ingredient;
    this.result = result;
  }

  /**
   * 创建一个配方构建器实例
   */
  public static StoneConvertingRecipeBuilder stoneConverting(
    Ingredient ingredient,
    RecipeCategory category,
    ItemLike result,
    int count) {
    return new StoneConvertingRecipeBuilder(category, ingredient, new ItemStack(result, count));
  }

  /**
   * 设置输入数量
   */
  public StoneConvertingRecipeBuilder requiresInputCount(int count) {
    this.inputCount = count;
    return this;
  }

  /**
   * 添加解锁条件
   */
  @Override
  public @NotNull StoneConvertingRecipeBuilder unlockedBy(@NotNull String name, @NotNull Criterion<?> criterion) {
    this.criteria.put(name, criterion);
    return this;
  }

  /**
   * 设置配方组
   */
  @Override
  public @NotNull StoneConvertingRecipeBuilder group(@Nullable String group) {
    this.group = group;
    return this;
  }

  /**
   * 获取结果物品
   */
  @Override
  public @NotNull Item getResult() {
    return this.result.getItem();
  }

  /**
   * 保存配方
   */
  @Override
  public void save(@NotNull RecipeOutput output, @NotNull ResourceLocation id) {
    // 验证至少有一个解锁条件
    if (this.criteria.isEmpty()) {
      throw new IllegalStateException("No way of obtaining recipe " + id);
    }

    // 创建进度
    Advancement.Builder advancementBuilder = output.advancement()
      .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
      .rewards(AdvancementRewards.Builder.recipe(id))
      .requirements(AdvancementRequirements.Strategy.OR);

    // 添加所有解锁条件
    this.criteria.forEach(advancementBuilder::addCriterion);

    // 如果 group 为 null，传入空字符串 ""
    StoneConvertingRecipe recipe = new StoneConvertingRecipe(
      Objects.requireNonNullElse(this.group, ""),
      this.ingredient,
      this.inputCount,
      this.result
    );

    // 保存配方和进度
    output.accept(
      id,
      recipe,
      advancementBuilder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/"))
    );
  }

  /**
   * 自动使用输出物品的注册名作为配方 ID
   * 例如：输出是 stone_bricks，ID 就会是 stonecraft:stone_bricks
   */
  public void save(@NotNull RecipeOutput output) {
    this.save(output, ResourceLocation.fromNamespaceAndPath(StoneCraft.ID, getResult().toString()));
  }

  /**
   * 允许自定义 ID 后缀
   * 例如：save(output, "stone_bricks_from_converting") -> stonecraft:stone_bricks_from_converting
   */
  public void save(@NotNull RecipeOutput output, @NotNull String id) {
    ResourceLocation location = ResourceLocation.parse(id);
    // 如果传入的 ID 没有命名空间（例如只传了 "my_recipe"），自动加上模组 ID
    if (location.getNamespace().equals("minecraft")) {
      location = ResourceLocation.fromNamespaceAndPath(StoneCraft.ID, id);
    }
    this.save(output, location);
  }

}
