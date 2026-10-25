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

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile.SHOW_SKIP_RESULT_OTHERS_TEXT;
import static ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile.SHOW_SKIP_RESULT_OWNER_TEXT;
import static ctn.stonecraft.datagen.advancement.ScAdvancementGenerator.*;
import static ctn.stonecraft.init.ScEnchantments.*;

public class ScI18EnUs extends LanguageProvider {
	public static final String[] GRADE = {" Tier 1", " Tier 2", " Tier 3", " Tier 4", " Tier 5"};

	public ScI18EnUs(PackOutput output) {
		super(output, SC_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		getModName(SC_ID, "Stone Craft");

		//region 方块
		addBlocks(ScBlocks.COMPRESSED_COBBLESTONE, "Compressed Cobblestone");
		addBlocks(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE, "Compressed Mossy Cobblestone");
		addBlocks(ScBlocks.COMPRESSED_STONE, "Compressed Stone");
		addBlocks(ScBlocks.COMPRESSED_GRANITE, "Compressed Granite");
		addBlocks(ScBlocks.COMPRESSED_ANDESITE, "Compressed Andesite");
		addBlocks(ScBlocks.COMPRESSED_DIORITE, "Compressed Diorite");
		addBlocks(ScBlocks.COMPRESSED_BEDROCK, "Compressed Bedrock");
		addBlocks(ScBlocks.COMPRESSED_END_STONE, "Compressed End Stone");
		addBlocks(ScBlocks.COMPRESSED_OBSIDIAN, "Compressed Obsidian");
		addBlock(ScBlocks.GLOWINGOBSIDIAN, "Glowing Obsidian");
		addBlocks(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN, "Compressed Glowing Obsidian");
		addBlocks(ScBlocks.COMPRESSED_CRYING_OBSIDIAN, "Compressed Crying Obsidian");
		addBlocks(ScBlocks.COMPRESSED_PRISMARINE, "Compressed Prismarine");
		addBlocks(ScBlocks.COMPRESSED_DARK_PRISMARINE, "Compressed Dark Prismarine");
		addBlocks(ScBlocks.COMPRESSED_NETHERRACK, "Compressed Netherrack");
		addBlocks(ScBlocks.COMPRESSED_GLOWSTONE, "Compressed Glowstone");
		addBlocks(ScBlocks.COMPRESSED_BLACKSTONE, "Compressed Blackstone");
		addBlocks(ScBlocks.COMPRESSED_CALCITE, "Compressed Calcite");
		addBlocks(ScBlocks.COMPRESSED_DEEPSLATE, "Compressed Deepslate");
		addBlocks(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE, "Compressed Cobbled Deepslate");
		addBlocks(ScBlocks.COMPRESSED_BASALT, "Compressed Basalt");
		addBlocks(ScBlocks.COMPRESSED_TUFF, "Compressed Tuff");
		addBlocks(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK, "Compressed Dripstone Block");
		add(ScBlocks.STONE_CONVERT_TABLE.get(), "Stone Convert Table");
		add("container.stonecraft.stone_convert_table", "Convert");
		//endregion

		//region 创造模式分页面
		add(ScCreativeModeTabs.BLOCK, "Stone Craft-Blocks");
		add(ScCreativeModeTabs.ITEM, "Stone Craft-Items");
		add(ScCreativeModeTabs.TOOL, "Stone Craft-Tools");
		add(ScCreativeModeTabs.COMBAT_SUPPLIES, "Stone Craft-Combat");
		add(ScCreativeModeTabs.FOOD, "Stone Craft-Food");
		//endregion

		//region 物品
		add(ScItems.COMPRESSED_STONE_SWORD_LV1.get(), "Compressed Stone Sword Tier 1");
		add(ScItems.COMPRESSED_STONE_SWORD_LV2.get(), "Compressed Stone Sword Tier 2");
		add(ScItems.COMPRESSED_STONE_SWORD_LV3.get(), "Compressed Stone Sword Tier 3");
		add(ScItems.COMPRESSED_STONE_SWORD_LV4.get(), "Compressed Stone Sword Tier 4");
		add(ScItems.COMPRESSED_STONE_SWORD_LV5.get(), "Compressed Stone Sword Tier 5");
		add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(), "Ultimate Compressed Stone Sword ACT1");
		add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(), "Ultimate Compressed Stone Sword ACT2");
		add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get(), "Ultimate Compressed Stone Sword ACT3");
		add(ScItems.COMPRESSED_STONE_AXE_LV1.get(), "Compressed Stone Axe Tier 1");
		add(ScItems.COMPRESSED_STONE_AXE_LV2.get(), "Compressed Stone Axe Tier 2");
		add(ScItems.COMPRESSED_STONE_AXE_LV3.get(), "Compressed Stone Axe Tier 3");
		add(ScItems.COMPRESSED_STONE_AXE_LV4.get(), "Compressed Stone Axe Tier 4");
		add(ScItems.COMPRESSED_STONE_AXE_LV5.get(), "Compressed Stone Axe Tier 5");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(), "Compressed Stone Pickaxe Tier 1");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(), "Compressed Stone Pickaxe Tier 2");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(), "Compressed Stone Pickaxe Tier 3");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(), "Compressed Stone Pickaxe Tier 4");
		add(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(), "Compressed Stone Pickaxe Tier 5");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(), "Compressed Stone Shovel Tier 1");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(), "Compressed Stone Shovel Tier 2");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(), "Compressed Stone Shovel Tier 3");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(), "Compressed Stone Shovel Tier 4");
		add(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(), "Compressed Stone Shovel Tier 5");
		add(ScItems.COMPRESSED_STONE_HOE_LV1.get(), "Compressed Stone Hoe Tier 1");
		add(ScItems.COMPRESSED_STONE_HOE_LV2.get(), "Compressed Stone Hoe Tier 2");
		add(ScItems.COMPRESSED_STONE_HOE_LV3.get(), "Compressed Stone Hoe Tier 3");
		add(ScItems.COMPRESSED_STONE_HOE_LV4.get(), "Compressed Stone Hoe Tier 4");
		add(ScItems.COMPRESSED_STONE_HOE_LV5.get(), "Compressed Stone Hoe Tier 5");
		add(ScItems.VERSATILE_STONE_TOOL.get(), "Stone Multi-Tool");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(), "Compressed Stone Multi-Tool Tier 1");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(), "Compressed Stone Multi-Tool Tier 2");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(), "Compressed Stone Multi-Tool Tier 3");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(), "Compressed Stone Multi-Tool Tier 4");
		add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get(), "Compressed Stone Multi-Tool Tier 5");
		add(ScItems.COMPRESSED_STONE_HAMMER_LV0.get(), "Stone Hammer");
		add(ScItems.COMPRESSED_STONE_HAMMER_LV1.get(), "Compressed Stone Hammer Tier 1");
		add(ScItems.COMPRESSED_STONE_HAMMER_LV2.get(), "Compressed Stone Hammer Tier 2");
		add(ScItems.COMPRESSED_STONE_HAMMER_LV3.get(), "Compressed Stone Hammer Tier 3");
		add(ScItems.COMPRESSED_STONE_HAMMER_LV4.get(), "Compressed Stone Hammer Tier 4");
		add(ScItems.COMPRESSED_STONE_HAMMER_LV5.get(), "Compressed Stone Hammer Tier 5");
		add(ScItems.STONE_APPLE.get(), "Stone Apple");
		add(ScItems.STONE_BREAD.get(), "Stone Bread");
		add(ScItems.STONE_CARROT.get(), "Stone Carrot");
		add(ScItems.STONE_KELP.get(), "Stone Kelp");
		add(ScItems.STONE_MELON_SLICE.get(), "Stone Melon Slice");
		add(ScItems.STONE_POTATO.get(), "Stone Potato");
		add(ScItems.STONE_HODGEPODGE.get(), "Stone Hodgepodge");
		add(ScItems.STONE_STAR.get(), "Stone Star");
		add(ScItems.STONE_NUGGET.get(), "Stone Nugget");
		add(ScItems.STONE_COIN.get(), "Stone Coin");
		add(ScItems.STONE_HELMET.get(), "Stone Helmet");
		add(ScItems.STONE_CHESTPLATE.get(), "Stone Chestplate");
		add(ScItems.STONE_LEGGINGS.get(), "Stone Leggings");
		add(ScItems.STONE_BOOTS.get(), "Stone Boots");
		add(ScItems.COMPRESSED_STONE_HELMET_LV1.get(), "Compressed Stone Helmet Tier 1");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get(), "Compressed Stone Chestplate Tier 1");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get(), "Compressed Stone Leggings Tier 1");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV1.get(), "Compressed Stone Boots Tier 1");
		add(ScItems.COMPRESSED_STONE_HELMET_LV2.get(), "Compressed Stone Helmet Tier 2");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get(), "Compressed Stone Chestplate Tier 2");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get(), "Compressed Stone Leggings Tier 2");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV2.get(), "Compressed Stone Boots Tier 2");
		add(ScItems.COMPRESSED_STONE_HELMET_LV3.get(), "Compressed Stone Helmet Tier 3");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get(), "Compressed Stone Chestplate Tier 3");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get(), "Compressed Stone Leggings Tier 3");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV3.get(), "Compressed Stone Boots Tier 3");
		add(ScItems.COMPRESSED_STONE_HELMET_LV4.get(), "Compressed Stone Helmet Tier 4");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get(), "Compressed Stone Chestplate Tier 4");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get(), "Compressed Stone Leggings Tier 4");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV4.get(), "Compressed Stone Boots Tier 4");
		add(ScItems.COMPRESSED_STONE_HELMET_LV5.get(), "Compressed Stone Helmet Tier 5");
		add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get(), "Compressed Stone Chestplate Tier 5");
		add(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get(), "Compressed Stone Leggings Tier 5");
		add(ScItems.COMPRESSED_STONE_BOOTS_LV5.get(), "Compressed Stone Boots Tier 5");
		add(ScItems.STONICKERS.get(), "Stonickers");
		add(ScItems.COMPRESSED_STONICKERS_LV1.get(), "Compressed Stonickers Tier 1");
		add(ScItems.COMPRESSED_STONICKERS_LV2.get(), "Compressed Stonickers Tier 2");
		add(ScItems.COMPRESSED_STONICKERS_LV3.get(), "Compressed Stonickers Tier 3");
		add(ScItems.COMPRESSED_STONICKERS_LV4.get(), "Compressed Stonickers Tier 4");
		add(ScItems.COMPRESSED_STONICKERS_LV5.get(), "Compressed Stonickers Tier 5");
		add(ScItems.STONE_COOKED_COD.get(), "Stone Cooked Cod");
		add(ScItems.STONE_COOKIE.get(), "Stone Cookie");
		add(ScItems.STONE_GLOW_BERRIES.get(), "Stone Glow Berries");
		add(ScItems.STONE_COOKED_BEEF.get(), "Stone Steak");
		add(ScItems.STONE_SWEET_BERRIES.get(), "Stone Sweet Berries");
		add(ScItems.WOOD_SLINGSHOT.get(), "Wooden Slingshot");
		add(ScItems.STONE_SLINGSHOT.get(), "Stone Slingshot");
		add(ScItems.IRON_SLINGSHOT.get(), "Iron Slingshot");
		add(ScItems.GOLD_SLINGSHOT.get(), "Golden Slingshot");
		add(ScItems.DIAMOND_SLINGSHOT.get(), "Diamond Slingshot");
		add(ScItems.NETHERITE_SLINGSHOT.get(), "Netherite Slingshot");
		add(ScItems.STONE_BALL.get(), "Stone Ball");
		add(ScItems.STONE_ARROW.get(), "Stone Arrow");
		addEntityType(ScEntityTypes.STONE_ARROW, "Stone Arrow");
		add(ScItems.STONE_BOW.get(), "Stone Bow");
		//endregion

		//region 附魔
		addEnchantment(STONE_DESTROYER, "Stonebreaker");
		addEnchantment(STONE_BUFFER, "Stone Landing");
		addEnchantment(OLDB, "oldb's Power");
		//endregion

		//region 成就
		addAdvancement(STONE_ADVENTURE_ID, "Stone Craft", "Obtain Stone");
		addAdvancement(saAdvancementId(GET_COBBLESTONE), "Cobblestone Impact, PLAY!", "Obtain Cobblestone");
		addAdvancement(saAdvancementId(GET_ANDESITE), "Press w to start thinking.jpg", "Obtain Andesite");
		addAdvancement(saAdvancementId(GET_DIORITE), "That's Why You Mine Quartz?", "Obtain Diorite");
		addAdvancement(saAdvancementId(GET_TUFF), "Amethyst Here", "Obtain Tuff");
		addAdvancement(saAdvancementId(GET_CALCITE), "Beautiful", "Obtain Calcite");
		addAdvancement(saAdvancementId(GET_COBBLED_DEEPSLATE), "Rock Solid!", "Obtain Cobbled Deepslate");
		addAdvancement(saAdvancementId(GET_OBSIDIAN), "Rock Solid! 2.0", "Obtain Obsidian");
		addAdvancement(saAdvancementId(GET_BEDROCK), "Rock Solid! 3.0", "Obtain Bedrock");
		addAdvancement(saAdvancementId(GET_END_STONE), "Fire and Dragon Proof", "Obtain End Stone");
		addAdvancement(saAdvancementId(GET_NETHERRACK), "Crispy", "Obtain Netherrack");
		addAdvancement(saAdvancementId(GET_BLACKSTONE), "Cobblestone Impact, PLAY! 2.0", "Obtain Blackstone");
		addAdvancement(saAdvancementId(GET_MOSSY_COBBLESTONE), "Green as Nori", "Obtain Mossy Cobblestone");
		addAdvancement(saAdvancementId(GET_GRANITE), "Sorry I Forgot This One", "Obtain Granite");
		addAdvancement(saAdvancementId(OUR_TRIO), "The Forgotten Three", "Obtain Andesite, Diorite and Granite");
		addAdvancement(saAdvancementId(GET_FLINT), "I Guess This Counts Too", "Obtain Flint");
		addAdvancement(saAdvancementId(VILLAGER_MASON_ON_TRADES), "Hard Deals", "Trade with Mason");
		addAdvancement(saAdvancementId(STONE_EATER), "Stone Eater", "Consume any type of stone food");
		addAdvancement(saAdvancementId(TEN_STONES_EATEN), "Stone Gourmet", "Consume ten different types of stone food");
		addAdvancement(saAdvancementId(EPIC_STONE_FEAST), "Stone Diet", "Consume all types of stone food");
		addAdvancement(saAdvancementId("stone_convert"), "Stone Alchemy", "Use Stone Convert Table for the first time");
		addAdvancement(saAdvancementId("get_redstone"), "Redstone", "Obtain Redstone");
		//endregion

		//region 实体
		addEntityType(ScEntityTypes.STONE_NUGGET, "Stone Nugget");
		add(SHOW_SKIP_RESULT_OWNER_TEXT, "Your Score: %d skips!");
		add(SHOW_SKIP_RESULT_OTHERS_TEXT, "%s's Score: %d skips!");
		//endregion
	}

	//region 工具方法
	public void addBlocks(List<DeferredBlock<Block>> blocks, String name) {
		for (int i = 0, blocksSize = blocks.size(); i < blocksSize; i++) {
			add(blocks.get(i).get(), name + GRADE[i]);
		}
	}

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
			add(item.get(i).asItem(), name + GRADE[i]);
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

	public void addAttribute(Holder<Attribute> attributeHolder, String name) {
		add(attributeHolder.value().getDescriptionId(), name);
	}

	public void addDeathMessage(ResourceKey<DamageType> damageType, String name) {
		add("death.attack." + damageType.location().getPath(), name);
	}
	//endregion
}