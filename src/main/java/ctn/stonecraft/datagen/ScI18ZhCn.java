package ctn.stonecraft.datagen;

import ctn.stonecraft.datagen.advancement.ScAdvancementGenerator;
import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScCreativeModeTabs;
import ctn.stonecraft.init.ScItems;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;
import java.util.function.Supplier;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.init.ScEnchantments.*;


public class ScI18ZhCn extends LanguageProvider {
	public static final String[] GRADE = {
			"一级压缩",
			"二级压缩",
			"三级压缩",
			"四级压缩",
			"五级压缩"
	};
	
	public ScI18ZhCn(PackOutput output) {
		super(output, SC_ID, "zh_cn");
	}
	
	@Override
	protected void addTranslations() {
		addBlocks(ScBlocks.COMPRESSED_COBBLESTONE, "原石");
		addBlocks(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE, "苔石");
		addBlocks(ScBlocks.COMPRESSED_STONE, "石头");
		addBlocks(ScBlocks.COMPRESSED_GRANITE, "花岗岩");
		addBlocks(ScBlocks.COMPRESSED_ANDESITE, "鞍山岩");
		addBlocks(ScBlocks.COMPRESSED_DIORITE, "闪长岩");
		addBlocks(ScBlocks.COMPRESSED_BEDROCK, "基岩");
		addBlocks(ScBlocks.COMPRESSED_END_STONE, "末地石");
		addBlocks(ScBlocks.COMPRESSED_OBSIDIAN, "黑耀石");
		addBlock(ScBlocks.GLOWINGOBSIDIAN, "发光的黑耀石");
		addBlocks(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN, "发光的黑耀石");
		addBlocks(ScBlocks.COMPRESSED_CRYING_OBSIDIAN, "哭泣的黑耀石");
		addBlocks(ScBlocks.COMPRESSED_PRISMARINE, "海晶石");
		addBlocks(ScBlocks.COMPRESSED_DARK_PRISMARINE, "暗海晶石");
		addBlocks(ScBlocks.COMPRESSED_NETHERRACK, "下界岩");
		addBlocks(ScBlocks.COMPRESSED_GLOWSTONE, "荧石");
		addBlocks(ScBlocks.COMPRESSED_BLACKSTONE, "黑石");
		addBlocks(ScBlocks.COMPRESSED_CALCITE, "方解石");
		addBlocks(ScBlocks.COMPRESSED_DEEPSLATE, "深板岩");
		addBlocks(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE, "深板岩原石");
		addBlocks(ScBlocks.COMPRESSED_BASALT, "玄武岩");
		addBlocks(ScBlocks.COMPRESSED_TUFF, "凝灰岩");
		addBlocks(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK, "滴水石");
		
		add(ScCreativeModeTabs.BLOCK, "石头工艺-方块");
		add(ScCreativeModeTabs.ITEM, "石头工艺-物品");
		add(ScCreativeModeTabs.EQUIPMENT, "石头工艺-装备");
		add(ScCreativeModeTabs.FOOD, "石头工艺-食物");
		
		getModName(SC_ID, "石头工艺");
		
		add(ScItems.COMPRESSED_STONE_SWORD_LV1.get(), "一级压缩石剑");
		add(ScItems.COMPRESSED_STONE_SWORD_LV2.get(), "二级压缩石剑");
		add(ScItems.COMPRESSED_STONE_SWORD_LV3.get(), "三级压缩石剑");
		add(ScItems.COMPRESSED_STONE_SWORD_LV4.get(), "四级压缩石剑");
		add(ScItems.COMPRESSED_STONE_SWORD_LV5.get(), "五级压缩石剑");
		add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(), "终极压缩石剑 ACT1");
		add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(), "终极压缩石剑 ACT2");
		add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get(), "终极压缩石剑 ACT3");
		add(ScItems.COMPRESSED_STONE_AXE_LV1.get(), "一级压缩石斧");
		add(ScItems.COMPRESSED_STONE_AXE_LV2.get(), "二级压缩石斧");
		add(ScItems.COMPRESSED_STONE_AXE_LV3.get(), "三级压缩石斧");
		add(ScItems.COMPRESSED_STONE_AXE_LV4.get(), "四级压缩石斧");
		add(ScItems.COMPRESSED_STONE_AXE_LV5.get(), "五级压缩石斧");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(), "一级压缩石镐");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(), "二级压缩石镐");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(), "三级压缩石镐");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(), "四级压缩石镐");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(), "五级压缩石镐");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(), "一级压缩石锹");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(), "二级压缩石锹");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(), "三级压缩石锹");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(), "四级压缩石锹");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(), "五级压缩石锹");
		add(ScItems.COMPRESSED_STONE_HOE_LV1.get(), "一级压缩石锄");
		add(ScItems.COMPRESSED_STONE_HOE_LV2.get(), "二级压缩石锄");
		add(ScItems.COMPRESSED_STONE_HOE_LV3.get(), "三级压缩石锄");
		add(ScItems.COMPRESSED_STONE_HOE_LV4.get(), "四级压缩石锄");
		add(ScItems.COMPRESSED_STONE_HOE_LV5.get(), "五级压缩石锄");
		add(ScItems.VERSATILE_STONE_TOOL.get(), "石制多功能工具");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(), "一级压缩石制多功能工具");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(), "二级压缩石制多功能工具");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(), "三级压缩石制多功能工具");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(), "四级压缩石制多功能工具");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get(), "五级压缩石制多功能工具");
		add(ScItems.STONE_APPLE.get(), "石头苹果");
		add(ScItems.STONE_BREAD.get(), "石头面包");
		add(ScItems.STONE_CARROT.get(), "石头胡萝卜");
		add(ScItems.STONE_KELP.get(), "石头海带");
		add(ScItems.STONE_MELON_SLICE.get(), "石头西瓜片");
		add(ScItems.STONE_POTATO.get(), "石头马铃薯");
		add(ScItems.STONE_HODGEPODGE.get(), "石物大杂烩");
		add(ScItems.STONE_STAR.get(), "石头之星");
		add(ScItems.STONE_NUGGET.get(), "石粒");
		add(ScItems.STONE_COIN.get(), "石币");
		add(ScItems.STONE_HELMET.get(), "石盔");
		add(ScItems.STONE_CHESTPLATE.get(), "石甲");
		add(ScItems.STONE_LEGGINGS.get(), "石护腿");
		add(ScItems.STONE_BOOTS.get(), "石靴");
		add(ScItems.COMPRESSED_STONE_HELMET_LV1.get(), "一级压缩石盔");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get(), "一级压缩石甲");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get(), "一级压缩石护腿");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV1.get(), "一级压缩石靴");
		add(ScItems.COMPRESSED_STONE_HELMET_LV2.get(), "二级压缩石盔");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get(), "二级压缩石甲");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get(), "二级压缩石护腿");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV2.get(), "二级压缩石靴");
		add(ScItems.COMPRESSED_STONE_HELMET_LV3.get(), "三级压缩石盔");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get(), "三级压缩石甲");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get(), "三级压缩石护腿");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV3.get(), "三级压缩石靴");
		add(ScItems.COMPRESSED_STONE_HELMET_LV4.get(), "四级压缩石盔");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get(), "四级压缩石甲");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get(), "四级压缩石护腿");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV4.get(), "四级压缩石靴");
		add(ScItems.COMPRESSED_STONE_HELMET_LV5.get(), "五级压缩石盔");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get(), "五级压缩石甲");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get(), "五级压缩石护腿");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV5.get(), "五级压缩石靴");
		add(ScItems.STONICKERS.get(), "石力架");
		add(ScItems.COMPRESSED_STONICKERS_LV1.get(), "一级压缩石力架");
		add(ScItems.COMPRESSED_STONICKERS_LV2.get(), "二级压缩石力架");
		add(ScItems.COMPRESSED_STONICKERS_LV3.get(), "三级压缩石力架");
		add(ScItems.COMPRESSED_STONICKERS_LV4.get(), "四级压缩石力架");
		add(ScItems.COMPRESSED_STONICKERS_LV5.get(), "五级压缩石力架");
		add(ScItems.STONE_COOKED_COD.get(), "石鳕鱼");
		add(ScItems.STONE_COOKIE.get(), "石曲奇");
		add(ScItems.STONE_GLOW_BERRIES.get(), "石发光浆果");
		add(ScItems.STONE_COOKED_BEEF.get(), "石牛排");
		add(ScItems.STONE_SWEET_BERRIES.get(), "石甜浆果");
		addEnchantment(STONE_DESTROYER, "石力挖掘");
		addEnchantment(STONE_BUFFER, "石之缓冲");
		addEnchantment(OLDB, "oldb神力");
		
		addAdvancement("stone_adventure", "石头工艺&磐石之旅", "获得“石头”");
		
		addAdvancement(ScAdvancementGenerator.advancementId("get_cobblestone"), "圆石人启动！", "获得圆石");
		addAdvancement(ScAdvancementGenerator.advancementId("get_andesite"), "按w键进行进行思索.jpg！", "获得安山岩");
		addAdvancement(ScAdvancementGenerator.advancementId("get_diorite"), "你搞石英就为了这个？", "获得闪长岩");
		addAdvancement(ScAdvancementGenerator.advancementId("get_tuff"), "紫水晶必定在此！", "获得凝灰岩");
		addAdvancement(ScAdvancementGenerator.advancementId("get_calcite"), "这玩意好看", "获得方解石");
		addAdvancement(ScAdvancementGenerator.advancementId("get_cobbled_deepslate"), "真硬！", "获得深板岩圆石");
		addAdvancement(ScAdvancementGenerator.advancementId("get_obsidian"), "真硬！2.0", "获得黑曜石");
		addAdvancement(ScAdvancementGenerator.advancementId("get_bedrock"), "真硬！3.0", "获得基岩");
		addAdvancement(ScAdvancementGenerator.advancementId("get_end_stone"), "防火，防龙！", "获得末地石");
		addAdvancement(ScAdvancementGenerator.advancementId("get_netherrack"), "嘎嘣脆", "获得下界岩");
		addAdvancement(ScAdvancementGenerator.advancementId("get_blackstone"), "圆石人启动！2.0", "获得黑石");
		addAdvancement(ScAdvancementGenerator.advancementId("get_mossy_cobblestone"), "绿绿的有好多海苔", "获得苔石");
		addAdvancement(ScAdvancementGenerator.advancementId("get_granite"), "抱歉，我忘了", "获得花岗岩");
		addAdvancement(ScAdvancementGenerator.advancementId("our_trio"), "《我们仨》", "获取安山岩、闪长岩和花岗岩");
		addAdvancement(ScAdvancementGenerator.advancementId("get_flint"), "这玩意...也算？", "获得燧石");
		
		addAdvancement(ScAdvancementGenerator.advancementId("villager_mason_on_trades"), "这都是硬货！", "与石匠交易");
		addAdvancement(ScAdvancementGenerator.advancementId("stone_eater"), "食石食", "吃掉任意一个石头食物");
		addAdvancement(ScAdvancementGenerator.advancementId("ten_stones_eaten"), "食十石食", "吃掉十种不一样的石头食物");
		addAdvancement(ScAdvancementGenerator.advancementId("epic_stone_feast"), "史诗食世石", "吃掉所有种类的石头食物");
		addAdvancement(ScAdvancementGenerator.advancementId("one_stone_two_birds"), "一石二鸟", "使用弹弓或者石粒同时击中两个目标获得");
		addAdvancement(ScAdvancementGenerator.advancementId("mischievous_child"), "调皮娃子", "使用弹弓或者石粒搞破坏！");
		addAdvancement(ScAdvancementGenerator.advancementId("stone_skipping"), "打水漂", "将石粒投掷水中获得");
		addAdvancement(ScAdvancementGenerator.advancementId("perfect_ten"), "十全十美", "获取所有至少10种压缩石头");
		addAdvancement(ScAdvancementGenerator.advancementId("tears_of_the_stone_age"), "石代眼泪", "利用合成获取发光黑曜石");
		addAdvancement(ScAdvancementGenerator.advancementId("alchemy_of_stone"), "炼石术", "初次使用石头转化台");
		addAdvancement(ScAdvancementGenerator.advancementId("absolute_hardness"), "绝对硬度！", "初次使用石头转化台获取基岩");
		addAdvancement(ScAdvancementGenerator.advancementId("peak_of_obsidian"), "黑曜之巅", "初次使用石头转化台获取黑曜石");
		addAdvancement(ScAdvancementGenerator.advancementId("armor_of_bedrock"), "磐石之甲", "初次获取五级压缩石甲");
		addAdvancement(ScAdvancementGenerator.advancementId("as_hard_as_bedrock"), "坚如磐石", "初次获取任意种类的五级压缩石");
		addAdvancement(ScAdvancementGenerator.advancementId("king_of_children_born"), "孩子王诞生！", "打水漂打出十米之外");
		addAdvancement(ScAdvancementGenerator.advancementId("neighbors_glass_in_trouble"), "邻居家的玻璃要遭殃了！", "初次获取弹弓");
		addAdvancement(ScAdvancementGenerator.advancementId("stone_free_reference"), "免费石头", "将石粒抛出三十米以上");
		addAdvancement(ScAdvancementGenerator.advancementId("grows_with_water"), "遇水变大吗？", "初次合成任意种类的压缩石");
	}
	
	public void addBlocks(List<DeferredBlock<Block>> blocks, String name) {
		for (int i = 0, blocksSize = blocks.size(); i < blocksSize; i++) {
			add(blocks.get(i).get(), GRADE[i] + name);
		}
	}
	
	/**
	 * 创造模式物品栏名称翻译
	 */
	public <R, T extends R> void add(DeferredHolder<R, T> itemGroup, String name) {
		add("itemGroup." + itemGroup.getId().toString().replace(":", "."), name);
	}
	
	private void getModName(String modid, String name) {
		add("pack." + modid + ".description", name);
	}
	
	public void addEnchantment(ResourceKey<Enchantment> enchantment, String name) {
		add(getEnchantmentTranslatable(enchantment), name);
	}
	
	private void addAdvancement(String key, String titleName, String descriptionName) {
		addAdvancementTitle(key, titleName);
		addAdvancementDescription(key, descriptionName);
	}
	
	private void addAdvancementTitle(String title, String name) {
		add("advancements.%s.%s.title".formatted(SC_ID, title), name);
	}
	
	private void addAdvancementDescription(String description, String name) {
		add("advancements.%s.%s.description".formatted(SC_ID, description), name);
	}
	
	private void add(Component key, String name) {
		add(key.getString(), name);
	}
	
	public void addItems(List<DeferredItem<Item>> item, String name) {
		for (int i = 0, blocksSize = item.size(); i < blocksSize; i++) {
			add(item.get(i).asItem(), GRADE[i] + name);
		}
	}
	
	public void addConfig(String configKey, String translationDescribe, String commentDescribe) {
		add(translationKey(configKey), translationDescribe);
		add(commentKey(configKey), commentDescribe);
	}
	
	public static String translationKey(String string) {
		return SC_ID + ".configgui." + string;
	}
	
	public static String commentKey(String string) {
		return SC_ID + ".configgui." + string + ".tooltip";
	}
	
	public void addConfig(String configKey, String translationDescribe) {
		add(translationKey(configKey), translationDescribe);
	}
	
	public <T> void addAttribute(Supplier<DataComponentType<T>> dataComponentType, String name) {
		add(dataComponentType.get().toString(), name);
	}
	
	/**
	 * 生物属性翻译
	 */
	public void addAttribute(Holder<Attribute> attributeHolder, String name) {
		add(attributeHolder.value().getDescriptionId(), name);
	}
	
	/**
	 * 死亡消息翻译
	 */
	public void addDeathMessage(ResourceKey<DamageType> damageType, String name) {
		add("death.attack." + damageType.location().getPath(), name);
	}
}
