package ctn.stonecraft.datagen.recipe.stone_converting;


import ctn.stonecraft.datagen.recipe.ShapedBuilder;
import ctn.stonecraft.init.ScItems;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import static ctn.stonecraft.core.StoneCraft.ID;
import static ctn.stonecraft.datagen.recipe.RecipeProvider.getItemName;
import static ctn.stonecraft.datagen.recipe.RecipeProvider.has;
import static ctn.stonecraft.datagen.recipe.RecipeUtil.getIngredient;

/**
 * 石头转换台配方
 */
public class StoneConvertingRecipeProvider  {

  //注册
  public static void buildRecipes(@NotNull RecipeOutput output){
    //石头转换台本体配方
    ShapedBuilder.basicBuilder(output, ScItems.STONE_CONVERTING_TABLE, RecipeCategory.BUILDING_BLOCKS, shapedBuilder -> shapedBuilder
      .define('A', Tags.Items.STONES)
      .define('B', Tags.Items.COBBLESTONES)
      .pattern("AAA")
      .pattern("BBB")
      .pattern("AAA"));

    // 花岗岩、闪长岩、安山岩相互转换
    createCyclicConversion(output,
      Items.GRANITE,   // 花岗岩
      Items.DIORITE,   // 闪长岩
      Items.ANDESITE   // 安山岩
    );

    // 磨制变种循环：磨制花岗岩 <-> 磨制闪长岩 <-> 磨制安山岩
    createCyclicConversion(output,
      Items.POLISHED_GRANITE,   // 磨制花岗岩
      Items.POLISHED_DIORITE,   // 磨制闪长岩
      Items.POLISHED_ANDESITE   // 磨制安山岩
    );

    //黑曜石 <-> 64圆石
    createTwoWayConversion(output, RecipeCategory.BUILDING_BLOCKS, Items.OBSIDIAN, 1, Items.COBBLESTONE, 64);
    // 2 圆石 <-> 1石头
    createTwoWayConversion(output, RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE, 2, Items.STONE, 1);
  }


  /**
   * 创建循环转换配方（A → B → C → A）
   */
  private static void createCyclicConversion(RecipeOutput output, ItemLike... items) {
    if (items.length < 2) return; // 至少需要2个物品

    for (int i = 0; i < items.length; i++) {
      ItemLike input = items[i];
      ItemLike output1 = items[(i + 1) % items.length];  // 下一个

      // 基础转换：A -> B
      stoneConvertingByItem(output, input, RecipeCategory.BUILDING_BLOCKS, output1, 1, "");

      // 跨步转换：A -> C 仅当物品总数大于2时才生成防止重复
      if (items.length > 2) {
        ItemLike output2 = items[(i + 2) % items.length];
        stoneConvertingByItem(output, input, RecipeCategory.BUILDING_BLOCKS, output2, 1, "_alt");
      }
    }
  }

  /**
   * 可以互相转换的配方 支持自定义数量
   */
  private static void createTwoWayConversion(RecipeOutput output, RecipeCategory category,
                                     ItemLike itemA, int countA,
                                     ItemLike itemB, int countB) {
    // 正向: A -> B
    stoneConvertingByItem(output, itemA, countA, category, itemB, countB, "_two_way");

    // 反向: B -> A
    stoneConvertingByItem(output, itemB, countB, category, itemA, countA, "_two_way");
  }

  /**
   * 单个物品转换 (输入数量为1的重载)
   */
  private static void stoneConvertingByItem(RecipeOutput output, ItemLike input, RecipeCategory category, ItemLike result, int count, String suffix) {
    stoneConvertingByItem(output, input, 1, category, result, count, suffix);
  }

  /**
   * 单个物品转换(支持多个数量的消耗)
   */
  private static void stoneConvertingByItem(RecipeOutput output, ItemLike input, int inputCount, RecipeCategory category, ItemLike result, int resultCount, String suffix) {
    String inputName = getItemName(input);
    String resultName = getItemName(result);

    // 输入数量大于1在ID中体现，避免ID冲突
    String countPrefix = (inputCount > 1) ? inputCount + "_" : "";
    String recipeId = resultName + "_via_" + countPrefix + inputName + suffix;

    StoneConvertingRecipeBuilder
      .stoneConverting(getIngredient(input), category, result, resultCount)
      .requiresInputCount(inputCount) // ✨ 调用新方法设置输入数量
      .group("stone_converting")
      .unlockedBy("has_" + inputName, has(input))
      .save(output, ResourceLocation.fromNamespaceAndPath(ID, recipeId));
  }



}
