package ctn.stonecraft.datagen;

import ctn.stonecraft.core.StoneCraft;
import ctn.stonecraft.event.client.ItemPropertyEvents;
import ctn.stonecraft.init.ScItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static ctn.stonecraft.core.StoneCraft.ID;


/**
 * 物品模型生成器类，用于为模组中的物品生成对应的模型文件
 */
public class ScItemModel extends ItemModelProvider {
  /**
   * 构造函数
   *
   * @param output             数据包输出位置
   * @param existingFileHelper 已存在文件助手，用于检查引用的文件是否存在
   */
  public ScItemModel(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, ID, existingFileHelper);
  }

  /**
   * 生成物品模型
   */
  @Override
  protected void registerModels() {
    basicItem(ScItems.STONE_STAR.get());
    basicItem(ScItems.STONE_NUGGET.get());
    basicItem(ScItems.STONE_COIN.get());
    basicItem(ScItems.STONE_APPLE.get(), "food/");
    basicItem(ScItems.STONE_BREAD.get(), "food/");
    basicItem(ScItems.STONE_CARROT.get(), "food/");
    basicItem(ScItems.STONE_KELP.get(), "food/");
    basicItem(ScItems.STONE_MELON_SLICE.get(), "food/");
    basicItem(ScItems.STONE_POTATO.get(), "food/");
    basicItem(ScItems.STONE_HODGEPODGE.get(), "food/");
    basicItem(ScItems.STONE_COOKED_COD.get(), "food/");
    basicItem(ScItems.STONE_COOKIE.get(), "food/");
    basicItem(ScItems.STONE_GLOW_BERRIES.get(), "food/");
    basicItem(ScItems.STONE_COOKED_BEEF.get(), "food/");
    basicItem(ScItems.STONE_SWEET_BERRIES.get(), "food/");
    handheldItem(ScItems.STONICKERS.get(), "food/");
    handheldItem(ScItems.COMPRESSED_STONICKERS_LV1.get(),"food/");
    handheldItem(ScItems.COMPRESSED_STONICKERS_LV2.get(),"food/");
    handheldItem(ScItems.COMPRESSED_STONICKERS_LV3.get(),"food/");
    handheldItem(ScItems.COMPRESSED_STONICKERS_LV4.get(),"food/");
    handheldItem(ScItems.COMPRESSED_STONICKERS_LV5.get(),"food/");
    handheldItem(ScItems.COMPRESSED_STONE_AXE_LV1.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_AXE_LV2.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_AXE_LV3.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_AXE_LV4.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_AXE_LV5.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_HOE_LV1.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_HOE_LV2.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_HOE_LV3.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_HOE_LV4.get(), "tool/");
    handheldItem(ScItems.COMPRESSED_STONE_HOE_LV5.get(), "tool/");
    handheldItem(ScItems.VERSATILE_STONE_TOOL.get(), "tool/");
    handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(), "tool/");
    handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(), "tool/");
    handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(), "tool/");
    handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(), "tool/");
    handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get(), "tool/");
    basicItem(ScItems.STONE_HELMET.get(), "armor/");
    basicItem(ScItems.STONE_CHESTPLATE.get(), "armor/");
    basicItem(ScItems.STONE_LEGGINGS.get(), "armor/");
    basicItem(ScItems.STONE_BOOTS.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_HELMET_LV1.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV1.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_HELMET_LV2.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV2.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_HELMET_LV3.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV3.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_HELMET_LV4.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV4.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_HELMET_LV5.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get(), "armor/");
    basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV5.get(), "armor/");
    handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV1.get(), "weapon/");
    handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV2.get(), "weapon/");
    handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV3.get(), "weapon/");
    handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV4.get(), "weapon/");
    handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV5.get(), "weapon/");
    handheldItem(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(), "weapon/");
    handheldItem(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(), "weapon/");
    handheldItem(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get(), "weapon/");

    multiModelFile(ScItems.STONE_COIN, Map.of(
        0.00f, "",
        0.16f, "1",
        0.32f, "2",
        0.48f, "3",
        0.64f, "4"),
      ItemPropertyEvents.STACKING);

    var slingshotList = List.of(-1f, 0.5f, 1f);
    slingshot(ScItems.WOOD_SLINGSHOT, slingshotList);
    slingshot(ScItems.STONE_SLINGSHOT, slingshotList);
    slingshot(ScItems.IRON_SLINGSHOT, slingshotList);
    slingshot(ScItems.GOLD_SLINGSHOT, slingshotList);
    slingshot(ScItems.DIAMOND_SLINGSHOT, slingshotList);
    slingshot(ScItems.NETHERITE_SLINGSHOT, slingshotList);
  }

  private void slingshot(ItemLike itemLike, List<Float> suffixList) {
    var item = itemLike.asItem(); // 获取物品
    var slingshotModelFile = new ModelFile.UncheckedModelFile(StoneCraft.modRL("item/slingshot")); // 获取弹弓模版模型
    var mod = basicItem(item, "weapon/").parent(slingshotModelFile);
    int count = 1;
    for (Float f : suffixList) {
      var suffix = String.valueOf(count);

      var modOverride = mod.override();
      var model = uncheckedModelFile(item, suffix);
      modOverride.model(model);
      modOverride.predicate(ItemPropertyEvents.PULLING, 1f);

      if (f != -1f) {
        modOverride.predicate(ItemPropertyEvents.PULL, f);
      }

      modOverride.end();
      count++;
      getBuilder(item + suffix).parent(mod).texture("layer0", getItemTextureRl(item, "item/weapon/", suffix));
    }
  }

  /**
   * 多模型物品生成
   *
   * @param item       物品
   * @param texture    纹理集
   * @param predicates 属性名
   */
  private void multiModelFile(ItemLike item, Map<Float, String> texture, ResourceLocation... predicates) {
    var itemItem = item.asItem();
    var mod = basicItem(itemItem);
    var predicate = predicates[0];
    var iteratorKey = texture.keySet().iterator();
    Float key;
    String value;
    for (int i = 0; i < texture.size(); i++) {
      key = iteratorKey.next();
      value = texture.get(key);
      if (predicates.length > 1) {
        predicate = predicates[i];
      }
      mod.override().model(uncheckedModelFile(itemItem, value)).predicate(predicate, key).end();
      if (!(value.isEmpty() || value.equals(String.valueOf(0)) || value.equals("_"))) {
        specialItem(itemItem, value);
      } else {
        basicItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(itemItem)));
      }
    }
  }

  private @NotNull ResourceLocation getItemTextureRl(Item item) {
    return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
  }

  private @NotNull ResourceLocation getItemTextureRl(Item item, String name) {
    return getItemTextureRl(item).withSuffix(name);
  }

  private @NotNull ResourceLocation getItemTextureRl(Item item, String prefix, String suffix) {
    return getItemTextureRl(item).withPrefix(prefix).withSuffix(suffix);
  }

  private String getItemTexturePath(Item item){
    return getItemTextureRl(item).getPath();
  }

  private String getItemTextureNamespace(Item item) {
    return  getItemTextureRl(item).getNamespace();
  }

  private ModelFile.UncheckedModelFile uncheckedModelFile(Item item) {
    return new ModelFile.UncheckedModelFile(getItemTextureRl(item));
  }

  private ModelFile.UncheckedModelFile uncheckedModelFile(Item item, String name) {
    return new ModelFile.UncheckedModelFile(getItemTextureRl(item, name).withPrefix("item/"));
  }

  private ModelFile.ExistingModelFile existingModelFile(Item item) {
    return new ModelFile.ExistingModelFile(getItemTextureRl(item).withPrefix("item/"), existingFileHelper);
  }

  /**
   * 创建特殊物品模型
   */
  private ItemModelBuilder specialItem(Item item, String name) {
    return basicItem(getItemTextureRl(item, name));
  }

  private ItemModelBuilder basicItem(Item item, String prefix) {
    return uncheckedModelItem(item, ResourceLocation.parse("generated"), prefix + getItemTexturePath(item));
  }

  private ItemModelBuilder handheldItem(Item item, String prefix) {
    return uncheckedModelItem(item, ResourceLocation.parse("handheld"), prefix + getItemTexturePath(item));
  }

  private ItemModelBuilder item(Item item, ModelFile modelFile) {
    return item(item, modelFile, getItemTextureRl(item));
  }

  /**
   * 已有模型物品
   */
  private ItemModelBuilder uncheckedModelItem(Item item, ResourceLocation modelRl, String textureRl) {
    return item(item, new ModelFile.UncheckedModelFile(modelRl.withPrefix("item/")), StoneCraft.modRL(textureRl));
  }

  private ItemModelBuilder item(Item item, ModelFile modelFile, String textureRl) {
    return item(item, modelFile, StoneCraft.modRL(textureRl));
  }

  private ItemModelBuilder item(Item item, ModelFile modelFile, ResourceLocation textureRl) {
    return getBuilder(item.toString())
      .parent(modelFile)
      .texture("layer0", textureRl.withPrefix("item/"));
  }
}
