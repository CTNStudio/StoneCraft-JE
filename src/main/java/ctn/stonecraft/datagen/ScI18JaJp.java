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

public class ScI18JaJp extends LanguageProvider {
    public static final String[] GRADE = {" T1", " T2", " T3", " T4", " T5"};

    public ScI18JaJp(PackOutput output) {
        super(output, SC_ID, "ja_jp");
    }

    @Override
    protected void addTranslations() {
        getModName(SC_ID, "Stonecraft");

        //region
        addBlocks(ScBlocks.COMPRESSED_COBBLESTONE, "圧縮丸石");
        addBlocks(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE, "圧縮苔むした丸石");
        addBlocks(ScBlocks.COMPRESSED_STONE, "圧縮石");
        addBlocks(ScBlocks.COMPRESSED_GRANITE, "圧縮花崗岩");
        addBlocks(ScBlocks.COMPRESSED_ANDESITE, "圧縮安山岩");
        addBlocks(ScBlocks.COMPRESSED_DIORITE, "圧縮閃緑岩");
        addBlocks(ScBlocks.COMPRESSED_BEDROCK, "圧縮岩盤");
        addBlocks(ScBlocks.COMPRESSED_END_STONE, "圧縮エンドストーン");
        addBlocks(ScBlocks.COMPRESSED_OBSIDIAN, "圧縮黒曜石");
        addBlock(ScBlocks.GLOWINGOBSIDIAN, "光る黒曜石");
        addBlocks(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN, "圧縮光る黒曜石");
        addBlocks(ScBlocks.COMPRESSED_CRYING_OBSIDIAN, "圧縮泣く黒曜石");
        addBlocks(ScBlocks.COMPRESSED_PRISMARINE, "圧縮プリズマリン");
        addBlocks(ScBlocks.COMPRESSED_DARK_PRISMARINE, "圧縮ダークプリズマリン");
        addBlocks(ScBlocks.COMPRESSED_NETHERRACK, "圧縮ネザーラック");
        addBlocks(ScBlocks.COMPRESSED_GLOWSTONE, "圧縮グロウストーン");
        addBlocks(ScBlocks.COMPRESSED_BLACKSTONE, "圧縮ブラックストーン");
        addBlocks(ScBlocks.COMPRESSED_CALCITE, "圧縮方解石");
        addBlocks(ScBlocks.COMPRESSED_DEEPSLATE, "圧縮深層岩");
        addBlocks(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE, "圧縮深層岩の丸石");
        addBlocks(ScBlocks.COMPRESSED_BASALT, "圧縮玄武岩");
        addBlocks(ScBlocks.COMPRESSED_TUFF, "圧縮凝灰岩");
        addBlocks(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK, "圧縮鍾乳石ブロック");
        add(ScBlocks.STONE_CONVERT_TABLE.get(), "石の変換台");
        add("container.stonecraft.stone_convert_table", "変換");
        //endregion

        //region クリエイティブタブ (创造模式分页面)
        add(ScCreativeModeTabs.BLOCK, "Stonecraft·ブロック");
        add(ScCreativeModeTabs.ITEM, "Stonecraft·アイテム");
        add(ScCreativeModeTabs.TOOL, "Stonecraft·ツール");
        add(ScCreativeModeTabs.COMBAT_SUPPLIES, "Stonecraft·戦闘");
        add(ScCreativeModeTabs.FOOD, "Stonecraft·食品");
        //endregion

        //region アイテム (物品)
        add(ScItems.COMPRESSED_STONE_SWORD_LV1.get(), "圧縮石の剣 T1");
        add(ScItems.COMPRESSED_STONE_SWORD_LV2.get(), "圧縮石の剣 T2");
        add(ScItems.COMPRESSED_STONE_SWORD_LV3.get(), "圧縮石の剣 T3");
        add(ScItems.COMPRESSED_STONE_SWORD_LV4.get(), "圧縮石の剣 T4");
        add(ScItems.COMPRESSED_STONE_SWORD_LV5.get(), "圧縮石の剣 T5");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(), "究極圧縮石の剣 ACT1");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(), "究極圧縮石の剣 ACT2");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get(), "究極圧縮石の剣 ACT3");
        add(ScItems.COMPRESSED_STONE_AXE_LV1.get(), "圧縮石の斧 T1");
        add(ScItems.COMPRESSED_STONE_AXE_LV2.get(), "圧縮石の斧 T2");
        add(ScItems.COMPRESSED_STONE_AXE_LV3.get(), "圧縮石の斧 T3");
        add(ScItems.COMPRESSED_STONE_AXE_LV4.get(), "圧縮石の斧 T4");
        add(ScItems.COMPRESSED_STONE_AXE_LV5.get(), "圧縮石の斧 T5");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(), "圧縮石のツルハシ T1");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(), "圧縮石のツルハシ T2");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(), "圧縮石のツルハシ T3");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(), "圧縮石のツルハシ T4");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(), "圧縮石のツルハシ T5");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(), "圧縮石のシャベル T1");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(), "圧縮石のシャベル T2");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(), "圧縮石のシャベル T3");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(), "圧縮石のシャベル T4");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(), "圧縮石のシャベル T5");
        add(ScItems.COMPRESSED_STONE_HOE_LV1.get(), "圧縮石のクワ T1");
        add(ScItems.COMPRESSED_STONE_HOE_LV2.get(), "圧縮石のクワ T2");
        add(ScItems.COMPRESSED_STONE_HOE_LV3.get(), "圧縮石のクワ T3");
        add(ScItems.COMPRESSED_STONE_HOE_LV4.get(), "圧縮石のクワ T4");
        add(ScItems.COMPRESSED_STONE_HOE_LV5.get(), "圧縮石のクワ T5");
        add(ScItems.VERSATILE_STONE_TOOL.get(), "汎用石ツール");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(), "汎用圧縮石ツール T1");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(), "汎用圧縮石ツール T2");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(), "汎用圧縮石ツール T3");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(), "汎用圧縮石ツール T4");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get(), "汎用圧縮石ツール T5");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV0.get(), "石のハンマー");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV1.get(), "圧縮石のハンマー T1");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV2.get(), "圧縮石のハンマー T2");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV3.get(), "圧縮石のハンマー T3");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV4.get(), "圧縮石のハンマー T4");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV5.get(), "圧縮石のハンマー T5");
        add(ScItems.STONE_APPLE.get(), "石のリンゴ");
        add(ScItems.STONE_BREAD.get(), "石のパン");
        add(ScItems.STONE_CARROT.get(), "石のニンジン");
        add(ScItems.STONE_KELP.get(), "石のコンブ");
        add(ScItems.STONE_MELON_SLICE.get(), "石のスイカの薄切り");
        add(ScItems.STONE_POTATO.get(), "石のジャガイモ");
        add(ScItems.STONE_HODGEPODGE.get(), "石のすき焼き");
        add(ScItems.STONE_STAR.get(), "石のスダー");
        add(ScItems.STONE_NUGGET.get(), "石塊");
        add(ScItems.STONE_COIN.get(), "石のコイン");
        add(ScItems.STONE_HELMET.get(), "石のヘルメット");
        add(ScItems.STONE_CHESTPLATE.get(), "石のチェストプレート");
        add(ScItems.STONE_LEGGINGS.get(), "石のレギンス");
        add(ScItems.STONE_BOOTS.get(), "石のブーツ");
        add(ScItems.COMPRESSED_STONE_HELMET_LV1.get(), "圧縮石のヘルメット T1");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get(), "圧縮石のチェストプレート T1");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get(), "圧縮石のレギンス T1");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV1.get(), "圧縮石のブーツ T1");
        add(ScItems.COMPRESSED_STONE_HELMET_LV2.get(), "圧縮石のヘルメット T2");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get(), "圧縮石のチェストプレート T2");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get(), "圧縮石のレギンス T2");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV2.get(), "圧縮石のブーツ T2");
        add(ScItems.COMPRESSED_STONE_HELMET_LV3.get(), "圧縮石のヘルメット T3");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get(), "圧縮石のチェストプレート T3");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get(), "圧縮石のレギンス T3");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV3.get(), "圧縮石のブーツ T3");
        add(ScItems.COMPRESSED_STONE_HELMET_LV4.get(), "圧縮石のヘルメット T4");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get(), "圧縮石のチェストプレート T4");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get(), "圧縮石のレギンス T4");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV4.get(), "圧縮石のブーツ T4");
        add(ScItems.COMPRESSED_STONE_HELMET_LV5.get(), "圧縮石のヘルメット T5");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get(), "圧縮石のチェストプレート T5");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get(), "圧縮石のレギンス T5");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV5.get(), "圧縮石のブーツ T5");
        add(ScItems.STONICKERS.get(), "ストーンニッカーズ");
        add(ScItems.COMPRESSED_STONICKERS_LV1.get(), "圧縮ストーンニッカーズ T1");
        add(ScItems.COMPRESSED_STONICKERS_LV2.get(), "圧縮ストーンニッカーズ T2");
        add(ScItems.COMPRESSED_STONICKERS_LV3.get(), "圧縮ストーンニッカーズ T3");
        add(ScItems.COMPRESSED_STONICKERS_LV4.get(), "圧縮ストーンニッカーズ T4");
        add(ScItems.COMPRESSED_STONICKERS_LV5.get(), "圧縮ストーンニッカーズ T5");
        add(ScItems.STONE_COOKED_COD.get(), "石焼タラ");
        add(ScItems.STONE_COOKIE.get(), "石のクッキー");
        add(ScItems.STONE_GLOW_BERRIES.get(), "石のグロウベリー");
        add(ScItems.STONE_COOKED_BEEF.get(), "石焼ビーフ");
        add(ScItems.STONE_SWEET_BERRIES.get(), "石のスイートベリー");
        add(ScItems.WOOD_SLINGSHOT.get(), "木製パチンコ");
        add(ScItems.STONE_SLINGSHOT.get(), "石製パチンコ");
        add(ScItems.IRON_SLINGSHOT.get(), "鉄製パチンコ");
        add(ScItems.GOLD_SLINGSHOT.get(), "金製パチンコ");
        add(ScItems.DIAMOND_SLINGSHOT.get(), "ダイヤモンド製パチンコ");
        add(ScItems.NETHERITE_SLINGSHOT.get(), "ネザライト製パチンコ");
        add(ScItems.STONE_BALL.get(), "石の球");
        add(ScItems.STONE_ARROW.get(), "石の矢");
        addEntityType(ScEntityTypes.STONE_ARROW, "石の矢");
        add(ScItems.STONE_BOW.get(), "石の弓");
        //endregion

        //region エンチャント (附魔)
        addEnchantment(STONE_DESTROYER, "石破壊効率強化");
        addEnchantment(STONE_BUFFER, "石の緩衝");
        addEnchantment(OLDB, "oldbの神力");
        //endregion

        //region 実績 (成就)
        addAdvancement(STONE_ADVENTURE_ID, "Stone Craft", "「石」を入手する");
        addAdvancement(saAdvancementId(GET_COBBLESTONE), "「リンク·スタート！」", "丸石を入手する");
        addAdvancement(saAdvancementId(GET_ANDESITE), "これは「Create」じゃないよ！", "安山岩を入手する");
        addAdvancement(saAdvancementId(GET_DIORITE), "この閃綠岩だ！", "閃緑岩を入手する");
        addAdvancement(saAdvancementId(GET_TUFF), "試練はここにある！", "凝灰岩を入手する");
        addAdvancement(saAdvancementId(GET_CALCITE), "Nice Stone", "方解石を入手する");
        addAdvancement(saAdvancementId(GET_COBBLED_DEEPSLATE), "「Undertale」？", "深層岩の丸石を入手する");
        addAdvancement(saAdvancementId(GET_OBSIDIAN), "「アイス·バケツ·チャレンジ」？", "黒曜石を入手する");
        addAdvancement(saAdvancementId(GET_BEDROCK), "何これ？", "岩盤を入手する");
        addAdvancement(saAdvancementId(GET_END_STONE), "耐火・防龍！", "エンドストーンを入手する");
        addAdvancement(saAdvancementId(GET_NETHERRACK), "貧弱、貧弱！", "ネザーラックを入手する");
        addAdvancement(saAdvancementId(GET_BLACKSTONE), "黒剣士·キリト？", "ブラックストーンを入手する");
        addAdvancement(saAdvancementId(GET_MOSSY_COBBLESTONE), "昆布？", "苔むした丸石を入手する");
        addAdvancement(saAdvancementId(GET_GRANITE), "あっ、忘れてた~", "花崗岩を入手する");
        addAdvancement(saAdvancementId(OUR_TRIO), "三人組", "安山岩、閃緑岩、花崗岩を入手する");
        addAdvancement(saAdvancementId(GET_FLINT), "これは...石？", "火打石を入手する");
        addAdvancement(saAdvancementId(VILLAGER_MASON_ON_TRADES), "石の商人", "石工と交易する");
        addAdvancement(saAdvancementId(STONE_EATER), "石食い", "石の食べ物を1つ食べる");
        addAdvancement(saAdvancementId(TEN_STONES_EATEN), "十石食い", "10種類の石の食べ物を食べる");
        addAdvancement(saAdvancementId(EPIC_STONE_FEAST), "石のフルコース", "全ての種類の石の食べ物を食べる");
        addAdvancement(saAdvancementId("stone_convert"), "石の錬金術", "初めて石の変換台を使用する");
        addAdvancement(saAdvancementId("get_redstone"), "赤石", "レッドストーンを入手する");
        //endregion

        //region エンティティ (实体)
        addEntityType(ScEntityTypes.STONE_NUGGET, "石塊");
        add(SHOW_SKIP_RESULT_OWNER_TEXT, "あなたの記録：%d回！");
        add(SHOW_SKIP_RESULT_OTHERS_TEXT, "%sの記録：%d回！");
        //endregion
    }

    //region ツール (工具)
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