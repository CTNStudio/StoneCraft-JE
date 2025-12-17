package ctn.stonecraft.datagen;

import ctn.stonecraft.init.ScBlocks;
import ctn.stonecraft.init.ScCreativeModeTabs;
import ctn.stonecraft.init.ScEntityTypes;
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

import static ctn.stonecraft.common.blocks.stone_converting_table.StoneConvertingTable.STONE_CONVERTING_TABLE_CONTAINER_TITLE;
import static ctn.stonecraft.common.blocks.stone_crafting_table.StoneCraftingTable.STONE_CRAFTING_TABLE_CONTAINER_TITLE;
import static ctn.stonecraft.core.StoneCraft.ID;
import static ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile.SHOW_SKIP_RESULT_OTHERS_TEXT;
import static ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile.SHOW_SKIP_RESULT_OWNER_TEXT;
import static ctn.stonecraft.datagen.advancement.ScAdvancementGenerator.*;
import static ctn.stonecraft.init.ScEnchantments.*;


public class ScI18ZhCn extends LanguageProvider {
	public static final String[] GRADE = {"一级压缩", "二级压缩", "三级压缩", "四级压缩", "五级压缩"};

	public ScI18ZhCn(PackOutput output) {
		super(output, ID, "zh_cn");
	}

	@Override
	protected void addTranslations() {
		getModName(ID, "石头工艺");

		//region 方块
		addBlocks(ScBlocks.COMPRESSED_COBBLESTONE, "圆石");
		addBlocks(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE, "苔石");
		addBlocks(ScBlocks.COMPRESSED_STONE, "石头");
		addBlocks(ScBlocks.COMPRESSED_GRANITE, "花岗岩");
		addBlocks(ScBlocks.COMPRESSED_ANDESITE, "安山岩");
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
		addBlocks(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE, "深板岩圆石");
		addBlocks(ScBlocks.COMPRESSED_BASALT, "玄武岩");
		addBlocks(ScBlocks.COMPRESSED_TUFF, "凝灰岩");
		addBlocks(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK, "滴水石");
    add(ScBlocks.STONE_CRAFTING_TABLE.get(), "石质工作台");
    add(ScBlocks.STONE_CONVERTING_TABLE.get(), "石头转换台");
		//endregion

		//region 创造模式分页面
		add(ScCreativeModeTabs.BLOCK, "石头工艺-方块");
		add(ScCreativeModeTabs.ITEM, "石头工艺-物品");
		add(ScCreativeModeTabs.TOOL, "石头工艺-工具");
		add(ScCreativeModeTabs.COMBAT_SUPPLIES, "石头工艺-战斗用品");
		add(ScCreativeModeTabs.FOOD, "石头工艺-食物");
		//endregion

		//region 物品
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
		add(ScItems.WOOD_SLINGSHOT.get(), "木质弹弓");
		add(ScItems.STONE_SLINGSHOT.get(), "石质弹弓");
		add(ScItems.IRON_SLINGSHOT.get(), "铁质弹弓");
		add(ScItems.GOLD_SLINGSHOT.get(), "金质弹弓");
		add(ScItems.DIAMOND_SLINGSHOT.get(), "钻石质弹弓");
		add(ScItems.NETHERITE_SLINGSHOT.get(), "下界合金质弹弓");
		//endregion

		//region 附魔
		addEnchantment(STONE_DESTROYER, "石力挖掘");
		addEnchantment(STONE_BUFFER, "地母之拥");
		addEnchantment(OLDB, "oldb神力");
		//endregion

		//region 成就
		addAdvancement(STONE_ADVENTURE_ID, "石头工艺&磐石之旅", "获得“石头”");
		addAdvancement(saAdvancementId(GET_COBBLESTONE), "圆石人启动！", "获得圆石");
		addAdvancement(saAdvancementId(GET_ANDESITE), "按w键进行进行思索.jpg！", "获得安山岩");
		addAdvancement(saAdvancementId(GET_DIORITE), "你搞石英就为了这个？", "获得闪长岩");
		addAdvancement(saAdvancementId(GET_TUFF), "紫水晶必定在此！", "获得凝灰岩");
		addAdvancement(saAdvancementId(GET_CALCITE), "这玩意好看", "获得方解石");
		addAdvancement(saAdvancementId(GET_COBBLED_DEEPSLATE), "真硬！", "获得深板岩圆石");
		addAdvancement(saAdvancementId(GET_OBSIDIAN), "真硬！2.0", "获得黑曜石");
		addAdvancement(saAdvancementId(GET_BEDROCK), "真硬！3.0", "获得基岩");
		addAdvancement(saAdvancementId(GET_END_STONE), "防火，防龙！", "获得末地石");
		addAdvancement(saAdvancementId(GET_NETHERRACK), "嘎嘣脆", "获得下界岩");
		addAdvancement(saAdvancementId(GET_BLACKSTONE), "圆石人启动！2.0", "获得黑石");
		addAdvancement(saAdvancementId(GET_MOSSY_COBBLESTONE), "绿绿的有好多海苔", "获得苔石");
		addAdvancement(saAdvancementId(GET_GRANITE), "抱歉，我忘了", "获得花岗岩");
		addAdvancement(saAdvancementId(OUR_TRIO), "《我们仨》", "获取安山岩、闪长岩和花岗岩");
		addAdvancement(saAdvancementId(GET_FLINT), "这玩意...也算？", "获得燧石");
		addAdvancement(saAdvancementId(VILLAGER_MASON_ON_TRADES), "这都是硬货！", "与石匠交易");
		addAdvancement(saAdvancementId(STONE_EATER), "食石食", "吃掉任意一个石头食物");
		addAdvancement(saAdvancementId(TEN_STONES_EATEN), "食十石食", "吃掉十种不一样的石头食物");
		addAdvancement(saAdvancementId(EPIC_STONE_FEAST), "史诗食世石", "吃掉所有种类的石头食物");
		//endregion

		//region 实体
		addEntityType(ScEntityTypes.STONE_NUGGET, "石粒");
		add(SHOW_SKIP_RESULT_OWNER_TEXT, "你的成绩是：%d次！");
		add(SHOW_SKIP_RESULT_OTHERS_TEXT, "%s的成绩是：%d次！");
		//endregion

    //region 菜单
    add(STONE_CRAFTING_TABLE_CONTAINER_TITLE, "石质工作台");
    add(STONE_CONVERTING_TABLE_CONTAINER_TITLE, "石头转换台");
    //endregion
	}

	//region 工具
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
		add("advancements.%s.%s.title".formatted(ID, title), name);
	}

	private void addAdvancementDescription(String description, String name) {
		add("advancements.%s.%s.description".formatted(ID, description), name);
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
		return ID + ".configgui." + string;
	}

	public static String commentKey(String string) {
		return ID + ".configgui." + string + ".tooltip";
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
	//endregion
}
