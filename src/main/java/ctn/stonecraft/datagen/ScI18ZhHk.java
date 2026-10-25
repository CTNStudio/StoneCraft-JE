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

public class ScI18ZhHk extends LanguageProvider {
    public static final String[] GRADE = {"一級壓縮", "二級壓縮", "三級壓縮", "四級壓縮", "五級壓縮"};

    public ScI18ZhHk(PackOutput output) {
        super(output, SC_ID, "zh_hk");
    }

    @Override
    protected void addTranslations() {
        getModName(SC_ID, "石頭工藝");

        //region 方塊
        addBlocks(ScBlocks.COMPRESSED_COBBLESTONE, "碎石");
        addBlocks(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE, "青苔碎石");
        addBlocks(ScBlocks.COMPRESSED_STONE, "石頭");
        addBlocks(ScBlocks.COMPRESSED_GRANITE, "花崗岩");
        addBlocks(ScBlocks.COMPRESSED_ANDESITE, "安山岩");
        addBlocks(ScBlocks.COMPRESSED_DIORITE, "閃長岩");
        addBlocks(ScBlocks.COMPRESSED_BEDROCK, "基岩");
        addBlocks(ScBlocks.COMPRESSED_END_STONE, "終界石");
        addBlocks(ScBlocks.COMPRESSED_OBSIDIAN, "黑曜石");
        addBlock(ScBlocks.GLOWINGOBSIDIAN, "爍耀石");
        addBlocks(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN, "爍耀石");
        addBlocks(ScBlocks.COMPRESSED_CRYING_OBSIDIAN, "哭曜石");
        addBlocks(ScBlocks.COMPRESSED_PRISMARINE, "海磷石");
        addBlocks(ScBlocks.COMPRESSED_DARK_PRISMARINE, "暗海磷石");
        addBlocks(ScBlocks.COMPRESSED_NETHERRACK, "地獄岩");
        addBlocks(ScBlocks.COMPRESSED_GLOWSTONE, "熒石");
        addBlocks(ScBlocks.COMPRESSED_BLACKSTONE, "黑石");
        addBlocks(ScBlocks.COMPRESSED_CALCITE, "方解石");
        addBlocks(ScBlocks.COMPRESSED_DEEPSLATE, "深板岩");
        addBlocks(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE, "深板岩碎石");
        addBlocks(ScBlocks.COMPRESSED_BASALT, "玄武岩");
        addBlocks(ScBlocks.COMPRESSED_TUFF, "凝灰岩");
        addBlocks(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK, "滴水石");
        add(ScBlocks.STONE_CONVERT_TABLE.get(), "石頭轉換台");
        add("container.stonecraft.stone_convert_table", "轉換");
        //endregion

        //region 創造模式分頁面
        add(ScCreativeModeTabs.BLOCK, "石頭工藝·方塊");
        add(ScCreativeModeTabs.ITEM, "石頭工藝·物品");
        add(ScCreativeModeTabs.TOOL, "石頭工藝·工具");
        add(ScCreativeModeTabs.COMBAT_SUPPLIES, "石頭工藝·戰鬥用品");
        add(ScCreativeModeTabs.FOOD, "石頭工藝·食物");
        //endregion

        //region 物品
        add(ScItems.COMPRESSED_STONE_SWORD_LV1.get(), "一級壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV2.get(), "二級壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV3.get(), "三級壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV4.get(), "四級壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV5.get(), "五級壓縮石劍");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(), "究極壓縮石劍 ACT1");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(), "究極壓縮石劍 ACT2");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get(), "究極壓縮石劍 ACT3");
        add(ScItems.COMPRESSED_STONE_AXE_LV1.get(), "一級壓縮石斧頭");
        add(ScItems.COMPRESSED_STONE_AXE_LV2.get(), "二級壓縮石斧頭");
        add(ScItems.COMPRESSED_STONE_AXE_LV3.get(), "三級壓縮石斧頭");
        add(ScItems.COMPRESSED_STONE_AXE_LV4.get(), "四級壓縮石斧頭");
        add(ScItems.COMPRESSED_STONE_AXE_LV5.get(), "五級壓縮石斧頭");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(), "一級壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(), "二級壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(), "三級壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(), "四級壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(), "五級壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(), "一級壓縮石鍬");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(), "二級壓縮石鍬");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(), "三級壓縮石鍬");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(), "四級壓縮石鍬");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(), "五級壓縮石鍬");
        add(ScItems.COMPRESSED_STONE_HOE_LV1.get(), "一級壓縮石鋤頭");
        add(ScItems.COMPRESSED_STONE_HOE_LV2.get(), "二級壓縮石鋤頭");
        add(ScItems.COMPRESSED_STONE_HOE_LV3.get(), "三級壓縮石鋤頭");
        add(ScItems.COMPRESSED_STONE_HOE_LV4.get(), "四級壓縮石鋤頭");
        add(ScItems.COMPRESSED_STONE_HOE_LV5.get(), "五級壓縮石鋤頭");
        add(ScItems.VERSATILE_STONE_TOOL.get(), "石制多功能工具");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(), "一級壓縮石制多功能工具");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(), "二級壓縮石制多功能工具");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(), "三級壓縮石制多功能工具");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(), "四級壓縮石制多功能工具");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get(), "五級壓縮石制多功能工具");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV0.get(), "石錘");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV1.get(), "一級壓縮石錘");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV2.get(), "二級壓縮石錘");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV3.get(), "三級壓縮石錘");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV4.get(), "四級壓縮石錘");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV5.get(), "五級壓縮石錘");
        add(ScItems.STONE_APPLE.get(), "石頭蘋果");
        add(ScItems.STONE_BREAD.get(), "石頭麵包");
        add(ScItems.STONE_CARROT.get(), "石頭胡蘿卜");
        add(ScItems.STONE_KELP.get(), "石頭海帶");
        add(ScItems.STONE_MELON_SLICE.get(), "石頭西瓜片");
        add(ScItems.STONE_POTATO.get(), "石頭薯仔");
        add(ScItems.STONE_HODGEPODGE.get(), "石物大雜燴");
        add(ScItems.STONE_STAR.get(), "石頭之星");
        add(ScItems.STONE_NUGGET.get(), "石粒");
        add(ScItems.STONE_COIN.get(), "石幣");
        add(ScItems.STONE_HELMET.get(), "石盔");
        add(ScItems.STONE_CHESTPLATE.get(), "石甲");
        add(ScItems.STONE_LEGGINGS.get(), "石護腳");
        add(ScItems.STONE_BOOTS.get(), "石靴");
        add(ScItems.COMPRESSED_STONE_HELMET_LV1.get(), "一級壓縮石盔");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get(), "一級壓縮石甲");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get(), "一級壓縮石護腳");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV1.get(), "一級壓縮石靴");
        add(ScItems.COMPRESSED_STONE_HELMET_LV2.get(), "二級壓縮石盔");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get(), "二級壓縮石甲");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get(), "二級壓縮石護腳");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV2.get(), "二級壓縮石靴");
        add(ScItems.COMPRESSED_STONE_HELMET_LV3.get(), "三級壓縮石盔");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get(), "三級壓縮石甲");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get(), "三級壓縮石護腳");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV3.get(), "三級壓縮石靴");
        add(ScItems.COMPRESSED_STONE_HELMET_LV4.get(), "四級壓縮石盔");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get(), "四級壓縮石甲");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get(), "四級壓縮石護腳");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV4.get(), "四級壓縮石靴");
        add(ScItems.COMPRESSED_STONE_HELMET_LV5.get(), "五級壓縮石盔");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get(), "五級壓縮石甲");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get(), "五級壓縮石護腳");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV5.get(), "五級壓縮石靴");
        add(ScItems.STONICKERS.get(), "石力架");
        add(ScItems.COMPRESSED_STONICKERS_LV1.get(), "一級壓縮石力架");
        add(ScItems.COMPRESSED_STONICKERS_LV2.get(), "二級壓縮石力架");
        add(ScItems.COMPRESSED_STONICKERS_LV3.get(), "三級壓縮石力架");
        add(ScItems.COMPRESSED_STONICKERS_LV4.get(), "四級壓縮石力架");
        add(ScItems.COMPRESSED_STONICKERS_LV5.get(), "五級壓縮石力架");
        add(ScItems.STONE_COOKED_COD.get(), "石鱈魚");
        add(ScItems.STONE_COOKIE.get(), "石曲奇");
        add(ScItems.STONE_GLOW_BERRIES.get(), "石發光漿果");
        add(ScItems.STONE_COOKED_BEEF.get(), "石牛扒");
        add(ScItems.STONE_SWEET_BERRIES.get(), "石甜漿果");
        add(ScItems.WOOD_SLINGSHOT.get(), "木彈弓");
        add(ScItems.STONE_SLINGSHOT.get(), "石質彈弓");
        add(ScItems.IRON_SLINGSHOT.get(), "鐵彈弓");
        add(ScItems.GOLD_SLINGSHOT.get(), "金彈弓");
        add(ScItems.DIAMOND_SLINGSHOT.get(), "鑽石彈弓");
        add(ScItems.NETHERITE_SLINGSHOT.get(), "地獄合金彈弓");
        add(ScItems.STONE_BALL.get(), "石球");
        add(ScItems.STONE_ARROW.get(), "石箭");
        addEntityType(ScEntityTypes.STONE_ARROW, "石箭");
        add(ScItems.STONE_BOW.get(), "石弓");
        //endregion

        //region 附魔
        addEnchantment(STONE_DESTROYER, "石力挖掘");
        addEnchantment(STONE_BUFFER, "石之緩衝");
        addEnchantment(OLDB, "oldb神力");
        //endregion

        //region 成就
        addAdvancement(STONE_ADVENTURE_ID, "石頭工藝", "得到「石頭」");
        addAdvancement(saAdvancementId(GET_COBBLESTONE), "揾到野生嘅碎石喇！", "得到碎石");
        addAdvancement(saAdvancementId(GET_ANDESITE), "按w鍵以進行思索.jpg！", "得到安山岩");
        addAdvancement(saAdvancementId(GET_DIORITE), "你挖石英就為咗呢樣嘢？", "得到閃長岩");
        addAdvancement(saAdvancementId(GET_TUFF), "礦脈必定在此！", "得到凝灰岩");
        addAdvancement(saAdvancementId(GET_CALCITE), "哇多麼靚的石頭啊", "得到方解石");
        addAdvancement(saAdvancementId(GET_COBBLED_DEEPSLATE), "好硬！", "得到深板岩碎石");
        addAdvancement(saAdvancementId(GET_OBSIDIAN), "固若金湯！", "得到黑曜石");
        addAdvancement(saAdvancementId(GET_BEDROCK), "牢不可破！", "得到基岩");
        addAdvancement(saAdvancementId(GET_END_STONE), "唔怕火，唔怕龍！", "得到終界石");
        addAdvancement(saAdvancementId(GET_NETHERRACK), "嘎嘣脆", "得到地獄岩");
        addAdvancement(saAdvancementId(GET_BLACKSTONE), "揾到野生嘅黑石喇！", "得到黑石");
        addAdvancement(saAdvancementId(GET_MOSSY_COBBLESTONE), "誒你怎麼被綠了", "得到青苔碎石");
        addAdvancement(saAdvancementId(GET_GRANITE), "唔該，我唔記得啦", "得到花崗岩");
        addAdvancement(saAdvancementId(OUR_TRIO), "月下三兄貴", "得到安山岩、閃長岩和花崗岩");
        addAdvancement(saAdvancementId(GET_FLINT), "點解呢樣嘢都算啊？！", "得到燧石");
        addAdvancement(saAdvancementId(VILLAGER_MASON_ON_TRADES), "這都是硬貨！", "與切石工匠交易");
        addAdvancement(saAdvancementId(STONE_EATER), "食石食", "隨便吃掉一個石頭食物");
        addAdvancement(saAdvancementId(TEN_STONES_EATEN), "食十石食", "吃掉十個不一樣的石頭食物");
        addAdvancement(saAdvancementId(EPIC_STONE_FEAST), "史詩食世石", "吃遍所有的石頭食物");
        addAdvancement(saAdvancementId("stone_convert"), "煉石學", "初次使用石頭轉換台");
        addAdvancement(saAdvancementId("get_redstone"), "赤石", "得到紅石");
        //endregion

        //region 實體
        addEntityType(ScEntityTypes.STONE_NUGGET, "石粒");
        add(SHOW_SKIP_RESULT_OWNER_TEXT, "你的成績是：%d次！");
        add(SHOW_SKIP_RESULT_OTHERS_TEXT, "%s的成績是：%d次！");
        //endregion
    }

    //region 工具
    public void addBlocks(List<DeferredBlock<Block>> blocks, String name) {
        for (int i = 0, blocksSize = blocks.size(); i < blocksSize; i++) {
            add(blocks.get(i).get(), GRADE[i] + name);
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

    public void addAttribute(Holder<Attribute> attributeHolder, String name) {
        add(attributeHolder.value().getDescriptionId(), name);
    }

    public void addDeathMessage(ResourceKey<DamageType> damageType, String name) {
        add("death.attack." + damageType.location().getPath(), name);
    }
    //endregion
}