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

public class ScI18Lzh extends LanguageProvider {
    public static final String[] GRADE = {"壹等壓縮", "貳等壓縮", "叄等壓縮", "肆等壓縮", "伍等壓縮"};

    public ScI18Lzh(PackOutput output) {
        super(output, SC_ID, "lzh");
    }

    @Override
    protected void addTranslations() {
        getModName(SC_ID, "石藝");

        //region 塊方
        addBlocks(ScBlocks.COMPRESSED_COBBLESTONE, "䃮");
        addBlocks(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE, "苔䃮");
        addBlocks(ScBlocks.COMPRESSED_STONE, "石");
        addBlocks(ScBlocks.COMPRESSED_GRANITE, "花崗岩");
        addBlocks(ScBlocks.COMPRESSED_ANDESITE, "安山石");
        addBlocks(ScBlocks.COMPRESSED_DIORITE, "閃綠石");
        addBlocks(ScBlocks.COMPRESSED_BEDROCK, "基石");
        addBlocks(ScBlocks.COMPRESSED_END_STONE, "終界石");
        addBlocks(ScBlocks.COMPRESSED_OBSIDIAN, "黑曜石");
        addBlock(ScBlocks.GLOWINGOBSIDIAN, "耀光黑曜石");
        addBlocks(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN, "耀光黑曜石");
        addBlocks(ScBlocks.COMPRESSED_CRYING_OBSIDIAN, "泣黑曜石");
        addBlocks(ScBlocks.COMPRESSED_PRISMARINE, "海磷石");
        addBlocks(ScBlocks.COMPRESSED_DARK_PRISMARINE, "黯海磷石");
        addBlocks(ScBlocks.COMPRESSED_NETHERRACK, "焱界石");
        addBlocks(ScBlocks.COMPRESSED_GLOWSTONE, "硄");
        addBlocks(ScBlocks.COMPRESSED_BLACKSTONE, "墨石");
        addBlocks(ScBlocks.COMPRESSED_CALCITE, "滑方石");
        addBlocks(ScBlocks.COMPRESSED_DEEPSLATE, "板岩");
        addBlocks(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE, "碎板岩");
        addBlocks(ScBlocks.COMPRESSED_BASALT, "黑堦石");
        addBlocks(ScBlocks.COMPRESSED_TUFF, "積塊石");
        addBlocks(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK, "鐘乳石");
        add(ScBlocks.STONE_CONVERT_TABLE.get(), "轉化之臺");
        add("container.stonecraft.stone_convert_table", "轉化");
        //endregion

        //region 創造模式分頁
        add(ScCreativeModeTabs.BLOCK, "石藝·塊方");
        add(ScCreativeModeTabs.ITEM, "石藝·原料");
        add(ScCreativeModeTabs.TOOL, "石藝·器具");
        add(ScCreativeModeTabs.COMBAT_SUPPLIES, "石藝·戰鬥");
        add(ScCreativeModeTabs.FOOD, "石藝·石食");
        //endregion

        //region 物品
        add(ScItems.COMPRESSED_STONE_SWORD_LV1.get(), "壹等壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV2.get(), "貳等壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV3.get(), "叄等壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV4.get(), "肆等壓縮石劍");
        add(ScItems.COMPRESSED_STONE_SWORD_LV5.get(), "伍等壓縮石劍");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(), "終等壓縮石劍·凡品");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(), "終等壓縮石劍·佳品");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get(), "終等壓縮石劍·上品");
        add(ScItems.COMPRESSED_STONE_AXE_LV1.get(), "壹等壓縮石斧");
        add(ScItems.COMPRESSED_STONE_AXE_LV2.get(), "貳等壓縮石斧");
        add(ScItems.COMPRESSED_STONE_AXE_LV3.get(), "叄等壓縮石斧");
        add(ScItems.COMPRESSED_STONE_AXE_LV4.get(), "肆等壓縮石斧");
        add(ScItems.COMPRESSED_STONE_AXE_LV5.get(), "伍等壓縮石斧");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(), "壹等壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(), "貳等壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(), "叄等壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(), "肆等壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(), "伍等壓縮石鎬");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(), "壹等壓縮石鍁");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(), "貳等壓縮石鍁");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(), "叄等壓縮石鍁");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(), "肆等壓縮石鍁");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(), "伍等壓縮石鍁");
        add(ScItems.COMPRESSED_STONE_HOE_LV1.get(), "壹等壓縮石鋤");
        add(ScItems.COMPRESSED_STONE_HOE_LV2.get(), "貳等壓縮石鋤");
        add(ScItems.COMPRESSED_STONE_HOE_LV3.get(), "叄等壓縮石鋤");
        add(ScItems.COMPRESSED_STONE_HOE_LV4.get(), "肆等壓縮石鋤");
        add(ScItems.COMPRESSED_STONE_HOE_LV5.get(), "伍等壓縮石鋤");
        add(ScItems.VERSATILE_STONE_TOOL.get(), "百用石器");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(), "壹等壓縮百用石器");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(), "貳等壓縮百用石器");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(), "叄等壓縮百用石器");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(), "肆等壓縮百用石器");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get(), "伍等壓縮百用石器");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV0.get(), "石鎚");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV1.get(), "壹等壓縮石鎚");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV2.get(), "貳等壓縮石鎚");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV3.get(), "叄等壓縮石鎚");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV4.get(), "肆等壓縮石鎚");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV5.get(), "伍等壓縮石鎚");
        add(ScItems.STONE_APPLE.get(), "石林檎");
        add(ScItems.STONE_BREAD.get(), "石饢");
        add(ScItems.STONE_CARROT.get(), "石蘆菔");
        add(ScItems.STONE_KELP.get(), "石海帶");
        add(ScItems.STONE_MELON_SLICE.get(), "石寒瓜片");
        add(ScItems.STONE_POTATO.get(), "石洋芋");
        add(ScItems.STONE_HODGEPODGE.get(), "石食燴");
        add(ScItems.STONE_STAR.get(), "石之星");
        add(ScItems.STONE_NUGGET.get(), "石粒");
        add(ScItems.STONE_COIN.get(), "石錢");
        add(ScItems.STONE_HELMET.get(), "石胄");
        add(ScItems.STONE_CHESTPLATE.get(), "石鎧");
        add(ScItems.STONE_LEGGINGS.get(), "石護腿");
        add(ScItems.STONE_BOOTS.get(), "石鞾");
        add(ScItems.COMPRESSED_STONE_HELMET_LV1.get(), "壹等壓縮石胄");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get(), "壹等壓縮石鎧");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get(), "壹等壓縮石護腿");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV1.get(), "壹等壓縮石鞾");
        add(ScItems.COMPRESSED_STONE_HELMET_LV2.get(), "貳等壓縮石胄");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get(), "貳等壓縮石鎧");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get(), "貳等壓縮石護腿");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV2.get(), "貳等壓縮石鞾");
        add(ScItems.COMPRESSED_STONE_HELMET_LV3.get(), "叄等壓縮石胄");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get(), "叄等壓縮石鎧");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get(), "叄等壓縮石護腿");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV3.get(), "叄等壓縮石鞾");
        add(ScItems.COMPRESSED_STONE_HELMET_LV4.get(), "肆等壓縮石胄");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get(), "肆等壓縮石鎧");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get(), "肆等壓縮石護腿");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV4.get(), "肆等壓縮石鞾");
        add(ScItems.COMPRESSED_STONE_HELMET_LV5.get(), "伍等壓縮石胄");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get(), "伍等壓縮石鎧");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get(), "伍等壓縮石護腿");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV5.get(), "伍等壓縮石鞾");
        add(ScItems.STONICKERS.get(), "石糧餅");
        add(ScItems.COMPRESSED_STONICKERS_LV1.get(), "壹等壓縮石糧餅");
        add(ScItems.COMPRESSED_STONICKERS_LV2.get(), "貳等壓縮石糧餅");
        add(ScItems.COMPRESSED_STONICKERS_LV3.get(), "叄等壓縮石糧餅");
        add(ScItems.COMPRESSED_STONICKERS_LV4.get(), "肆等壓縮石糧餅");
        add(ScItems.COMPRESSED_STONICKERS_LV5.get(), "伍等壓縮石糧餅");
        add(ScItems.STONE_COOKED_COD.get(), "石魚");
        add(ScItems.STONE_COOKIE.get(), "石餅");
        add(ScItems.STONE_GLOW_BERRIES.get(), "石發光漿果");
        add(ScItems.STONE_COOKED_BEEF.get(), "石肉");
        add(ScItems.STONE_SWEET_BERRIES.get(), "石甜莓");
        add(ScItems.WOOD_SLINGSHOT.get(), "木彈弓");
        add(ScItems.STONE_SLINGSHOT.get(), "石彈弓");
        add(ScItems.IRON_SLINGSHOT.get(), "鐵彈弓");
        add(ScItems.GOLD_SLINGSHOT.get(), "金彈弓");
        add(ScItems.DIAMOND_SLINGSHOT.get(), "金剛石彈弓");
        add(ScItems.NETHERITE_SLINGSHOT.get(), "玄鈺彈弓");
        add(ScItems.STONE_BALL.get(), "石毬");
        add(ScItems.STONE_ARROW.get(), "石矢");
        addEntityType(ScEntityTypes.STONE_ARROW, "石矢");
        add(ScItems.STONE_BOW.get(), "石弓");
        //endregion

        //region 附魔
        addEnchantment(STONE_DESTROYER, "速岩");
        addEnchantment(STONE_BUFFER, "墜岩赦");
        addEnchantment(OLDB, "「歐奧蒂吡」之神力");
        //endregion

        //region 成就
        addAdvancement(STONE_ADVENTURE_ID, "石藝", "得「石」");
        addAdvancement(saAdvancementId(GET_COBBLESTONE), "初涉石藝", "得一䃮");
        addAdvancement(saAdvancementId(GET_ANDESITE), "宿雲凝魄", "得安山石");
        addAdvancement(saAdvancementId(GET_DIORITE), "碎瓊亂玉", "得閃綠石");
        addAdvancement(saAdvancementId(GET_TUFF), "紫水玉定在此！", "得積塊石");
        addAdvancement(saAdvancementId(GET_CALCITE), "潔白如花", "得滑方石");
        addAdvancement(saAdvancementId(GET_COBBLED_DEEPSLATE), "甚硬", "得碎板岩");
        addAdvancement(saAdvancementId(GET_OBSIDIAN), "堅如磐石", "得一黑曜石");
        addAdvancement(saAdvancementId(GET_BEDROCK), "豈是人力所為？", "得基石");
        addAdvancement(saAdvancementId(GET_END_STONE), "涉墟得石", "得終界石");
        addAdvancement(saAdvancementId(GET_NETHERRACK), "火焰相燒滿天赤", "得焱界石");
        addAdvancement(saAdvancementId(GET_BLACKSTONE), "始帝喜玄", "得墨石");
        addAdvancement(saAdvancementId(GET_MOSSY_COBBLESTONE), "雨後綠苔生石井", "得苔䃮");
        addAdvancement(saAdvancementId(GET_GRANITE), "霞染磲礪", "得花崗岩");
        addAdvancement(saAdvancementId(OUR_TRIO), "岩壑三廢", "得安山石、閃綠石與花崗岩");
        addAdvancement(saAdvancementId(GET_FLINT), "然算乎？", "得一燧石");
        addAdvancement(saAdvancementId(VILLAGER_MASON_ON_TRADES), "些許硬貨！", "石匠商賈之");
        addAdvancement(saAdvancementId(STONE_EATER), "請君細嚼", "食任一石食");
        addAdvancement(saAdvancementId(TEN_STONES_EATEN), "其食石兽乎？", "十食之石食");
        addAdvancement(saAdvancementId(EPIC_STONE_FEAST), "食言者當受食岩之罰", "食天下之石食");
        addAdvancement(saAdvancementId("stone_convert"), "煉石術", "初用轉化之臺");
        addAdvancement(saAdvancementId("get_redstone"), "赤石", "得紅石");
        //endregion

        //region 實體
        addEntityType(ScEntityTypes.STONE_NUGGET, "石粒");
        add(SHOW_SKIP_RESULT_OWNER_TEXT, "君得績為%d回！");
        add(SHOW_SKIP_RESULT_OTHERS_TEXT, "%s得績為%d回！");
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