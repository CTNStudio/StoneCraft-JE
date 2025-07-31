package ctn.stonecraft.datagen;

import ctn.stonecraft.datagen.tool.TextureMapBuilder;
import ctn.stonecraft.events.ItemPropertyEvents;
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

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;
import static net.minecraft.resources.ResourceLocation.parse;


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
		super(output, SC_ID, existingFileHelper);
	}
	
	/**
	 * 生成物品模型
	 */
	@Override
	protected void registerModels() {
		handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV1.get());
		handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV2.get());
		handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV3.get());
		handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV4.get());
		handheldItem(ScItems.COMPRESSED_STONE_SWORD_LV5.get());
		handheldItem(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get());
		handheldItem(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get());
		handheldItem(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get());
		handheldItem(ScItems.COMPRESSED_STONE_AXE_LV1.get());
		handheldItem(ScItems.COMPRESSED_STONE_AXE_LV2.get());
		handheldItem(ScItems.COMPRESSED_STONE_AXE_LV3.get());
		handheldItem(ScItems.COMPRESSED_STONE_AXE_LV4.get());
		handheldItem(ScItems.COMPRESSED_STONE_AXE_LV5.get());
		handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get());
		handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get());
		handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get());
		handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get());
		handheldItem(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get());
		handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get());
		handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get());
		handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get());
		handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get());
		handheldItem(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get());
		handheldItem(ScItems.COMPRESSED_STONE_HOE_LV1.get());
		handheldItem(ScItems.COMPRESSED_STONE_HOE_LV2.get());
		handheldItem(ScItems.COMPRESSED_STONE_HOE_LV3.get());
		handheldItem(ScItems.COMPRESSED_STONE_HOE_LV4.get());
		handheldItem(ScItems.COMPRESSED_STONE_HOE_LV5.get());
		handheldItem(ScItems.VERSATILE_STONE_TOOL.get());
		handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get());
		handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get());
		handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get());
		handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get());
		handheldItem(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get());
		handheldItem(ScItems.STONICKERS.get());
		handheldItem(ScItems.COMPRESSED_STONICKERS_LV1.get());
		handheldItem(ScItems.COMPRESSED_STONICKERS_LV2.get());
		handheldItem(ScItems.COMPRESSED_STONICKERS_LV3.get());
		handheldItem(ScItems.COMPRESSED_STONICKERS_LV4.get());
		handheldItem(ScItems.COMPRESSED_STONICKERS_LV5.get());
		basicItem(ScItems.STONE_STAR.get());
		basicItem(ScItems.STONE_NUGGET.get());
		basicItem(ScItems.STONE_COIN.get());
		basicItem(ScItems.STONE_APPLE.get());
		basicItem(ScItems.STONE_BREAD.get());
		basicItem(ScItems.STONE_CARROT.get());
		basicItem(ScItems.STONE_KELP.get());
		basicItem(ScItems.STONE_MELON_SLICE.get());
		basicItem(ScItems.STONE_POTATO.get());
		basicItem(ScItems.STONE_HODGEPODGE.get());
		basicItem(ScItems.STONE_HELMET.get());
		basicItem(ScItems.STONE_CHESTPLATE.get());
		basicItem(ScItems.STONE_LEGGINGS.get());
		basicItem(ScItems.STONE_BOOTS.get());
		basicItem(ScItems.STONE_COOKED_COD.get());
		basicItem(ScItems.STONE_COOKIE.get());
		basicItem(ScItems.STONE_GLOW_BERRIES.get());
		basicItem(ScItems.STONE_COOKED_BEEF.get());
		basicItem(ScItems.STONE_SWEET_BERRIES.get());
		basicItem(ScItems.COMPRESSED_STONE_HELMET_LV1.get());
		basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get());
		basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get());
		basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV1.get());
		basicItem(ScItems.COMPRESSED_STONE_HELMET_LV2.get());
		basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get());
		basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get());
		basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV2.get());
		basicItem(ScItems.COMPRESSED_STONE_HELMET_LV3.get());
		basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get());
		basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get());
		basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV3.get());
		basicItem(ScItems.COMPRESSED_STONE_HELMET_LV4.get());
		basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get());
		basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get());
		basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV4.get());
		basicItem(ScItems.COMPRESSED_STONE_HELMET_LV5.get());
		basicItem(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get());
		basicItem(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get());
		basicItem(ScItems.COMPRESSED_STONE_BOOTS_LV5.get());
		
		Map<Float, String> builder = new TextureMapBuilder().sharingWithoutHeadAndTail("_", 3)
				.head("")
				.tail("_" + 4)
				.builder();
		createModelFile(ScItems.STONE_COIN, builder, ItemPropertyEvents.STACKING);
	}
	
	
	/**
	 * 获取指定名称的父模型文件
	 *
	 * @param name 父模型名称
	 * @return 未检查的模型文件
	 */
	private ModelFile.@NotNull UncheckedModelFile getParent(String name) {
		return new ModelFile.UncheckedModelFile(ResourceLocation.withDefaultNamespace(name));
	}
	
	/**
	 * 多模型物品生成
	 *
	 * @param item       物品
	 * @param texture    纹理集
	 * @param predicates 属性名
	 */
	public void createModelFile(ItemLike item, Map<Float, String> texture, ResourceLocation... predicates) {
		Item itemItem = item.asItem();
		ItemModelBuilder mod = basicItem(itemItem);
		ResourceLocation predicate = predicates[0];
		Iterator<Float> iteratorKey = texture.keySet().iterator();
		Float key;
		String value;
		for (int i = 0; i < texture.size(); i++) {
			key   = iteratorKey.next();
			value = texture.get(key);
			if (predicates.length > 1) {
				predicate = predicates[i];
			}
			mod.override().model(createModelFile(itemItem, value)).predicate(predicate, key).end();
			if (!(value.isEmpty() || value.equals(String.valueOf(0)) || value.equals("_"))) {
				specialItem(itemItem, value);
			} else {
				basicItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(itemItem)));
			}
		}
	}
	
	/**
	 * 多模型物品生成
	 *
	 * @param item       物品
	 * @param texture    纹理集
	 * @param parent     父模型
	 * @param predicates 属性名
	 */
	public void createModelFile(ItemLike item, Map<Float, String> texture, ModelFile parent, ResourceLocation... predicates) {
		Item itemItem = item.asItem();
		ItemModelBuilder mod = basicItem(itemItem).parent(parent);
		ResourceLocation predicate = predicates[0];
		Iterator<Float> iteratorKey = texture.keySet().iterator();
		Float key;
		String value;
		for (int i = 0; i < texture.size(); i++) {
			key   = iteratorKey.next();
			value = texture.get(key);
			if (predicates.length > 1) {
				predicate = predicates[i];
			}
			mod.override().model(createModelFile(itemItem, value)).predicate(predicate, key).end();
			specialItem(itemItem, value).parent(parent);
		}
	}
	
	/**
	 * 创建模型文件
	 *
	 * @param item 物品
	 * @param name 模型名称
	 * @return 未检查的模型文件
	 */
	public ModelFile.UncheckedModelFile createModelFile(Item item, String name) {
		return new ModelFile.UncheckedModelFile(getItemResourceLocation(item, name).withPrefix("item/"));
	}
	
	/**
	 * 创建特殊物品模型
	 *
	 * @param item 物品
	 * @param name 模型名称
	 * @return 物品模型构建器
	 */
	public ItemModelBuilder specialItem(Item item, String name) {
		return basicItem(getItemResourceLocation(item, name));
	}
	
	/**
	 * 获取物品的资源位置
	 *
	 * @param item 物品
	 * @param name 名称后缀
	 * @return 资源位置
	 */
	private @NotNull ResourceLocation getItemResourceLocation(Item item, String name) {
		return Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)).withSuffix(name);
	}
	
	/**
	 * 创建模型物品
	 *
	 * @param item   物品
	 * @param parent 父模型
	 * @return 物品模型构建器
	 */
	public ItemModelBuilder createModelItem(Item item, ModelFile parent) {
		ResourceLocation resourceLocation = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item));
		return getBuilder(item.toString())
				.parent(parent)
				.texture("layer0", fromNamespaceAndPath(resourceLocation.getNamespace(), "item/" + resourceLocation.getPath()));
	}
	
	/**
	 * 用于给于特殊渲染模型生成的
	 */
	public void specialItem(Item item) {
		getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile(parse("builtin/entity")));
	}
	
	/**
	 * 创建基础物品模型
	 *
	 * @param item 物品
	 * @param name 模型名称
	 * @return 物品模型构建器
	 */
	public ItemModelBuilder basicItem(Item item, String name) {
		return basicItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), name);
	}
	
	/**
	 * 创建基础物品模型
	 *
	 * @param item 物品资源位置
	 * @param name 模型名称
	 * @return 物品模型构建器
	 */
	public ItemModelBuilder basicItem(ResourceLocation item, String name) {
		return getBuilder(item.toString())
				.parent(customModelFile("models/item/" + name))
				.texture("layer0", fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
	}
	
	/**
	 * 创建自定义模型文件
	 *
	 * @param name 模型文件名称
	 * @return 未检查的模型文件
	 */
	public ModelFile customModelFile(String name) {
		return new ModelFile.UncheckedModelFile(fromNamespaceAndPath(SC_ID, name));
	}
}
