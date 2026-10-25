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

public class ScI18RuRu extends LanguageProvider {
    public static final String[] GRADE = {", уровень 1", ", уровень 2", ", уровень 3", ", уровень 4", ", уровень 5"};

    public ScI18RuRu(PackOutput output) {
        super(output, SC_ID, "ru_ru");
    }

    @Override
    protected void addTranslations() {
        getModName(SC_ID, "StoneCraft");

        //region Блоки (方块)
        addBlocks(ScBlocks.COMPRESSED_COBBLESTONE, "Прессованный булыжник");
        addBlocks(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE, "Прессованный замшелый булыжник");
        addBlocks(ScBlocks.COMPRESSED_STONE, "Прессованный камень");
        addBlocks(ScBlocks.COMPRESSED_GRANITE, "Прессованный гранит");
        addBlocks(ScBlocks.COMPRESSED_ANDESITE, "Прессованный андезит");
        addBlocks(ScBlocks.COMPRESSED_DIORITE, "Прессованный диорит");
        addBlocks(ScBlocks.COMPRESSED_BEDROCK, "Прессованный бедрок");
        addBlocks(ScBlocks.COMPRESSED_END_STONE, "Прессованный эндерняк");
        addBlocks(ScBlocks.COMPRESSED_OBSIDIAN, "Прессованный обсидиан");
        addBlock(ScBlocks.GLOWINGOBSIDIAN, "Светящийся обсидиан");
        addBlocks(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN, "Прессованный светящийся обсидиан");
        addBlocks(ScBlocks.COMPRESSED_CRYING_OBSIDIAN, "Прессованный плачущий обсидиан");
        addBlocks(ScBlocks.COMPRESSED_PRISMARINE, "Прессованный призмарин");
        addBlocks(ScBlocks.COMPRESSED_DARK_PRISMARINE, "Прессованный тёмный призмарин");
        addBlocks(ScBlocks.COMPRESSED_NETHERRACK, "Прессованный незерак");
        addBlocks(ScBlocks.COMPRESSED_GLOWSTONE, "Прессованный светокамень");
        addBlocks(ScBlocks.COMPRESSED_BLACKSTONE, "Прессованный чернит");
        addBlocks(ScBlocks.COMPRESSED_CALCITE, "Прессованный кальцит");
        addBlocks(ScBlocks.COMPRESSED_DEEPSLATE, "Прессованный сланец");
        addBlocks(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE, "Прессованный колотый сланец");
        addBlocks(ScBlocks.COMPRESSED_BASALT, "Прессованный базальт");
        addBlocks(ScBlocks.COMPRESSED_TUFF, "Прессованный туф");
        addBlocks(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK, "Прессованный натёчный камень");
        add(ScBlocks.STONE_CONVERT_TABLE.get(), "Каменный преобразовательный стол");
        add("container.stonecraft.stone_convert_table", "Камень-преобразователь");
        //endregion

        //region Вкладки творческого режима (创造模式分页面)
        add(ScCreativeModeTabs.BLOCK, "Блоки StoneCraft");
        add(ScCreativeModeTabs.ITEM, "Предметы StoneCraft");
        add(ScCreativeModeTabs.TOOL, "Инструменты StoneCraft");
        add(ScCreativeModeTabs.COMBAT_SUPPLIES, "Оружие StoneCraft");
        add(ScCreativeModeTabs.FOOD, "Еда StoneCraft");
        //endregion

        //region Предметы (物品)
        add(ScItems.COMPRESSED_STONE_SWORD_LV1.get(), "Прессованный каменный меч, уровень 1");
        add(ScItems.COMPRESSED_STONE_SWORD_LV2.get(), "Прессованный каменный меч, уровень 2");
        add(ScItems.COMPRESSED_STONE_SWORD_LV3.get(), "Прессованный каменный меч, уровень 3");
        add(ScItems.COMPRESSED_STONE_SWORD_LV4.get(), "Прессованный каменный меч, уровень 4");
        add(ScItems.COMPRESSED_STONE_SWORD_LV5.get(), "Прессованный каменный меч, уровень 5");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT1.get(), "Конечный прессованный каменный меч, акт 1");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT2.get(), "Конечный прессованный каменный меч, акт 2");
        add(ScItems.ULTIMATE_COMPRESSED_STONE_SWORD_ACT3.get(), "Конечный прессованный каменный меч, акт 3");
        add(ScItems.COMPRESSED_STONE_AXE_LV1.get(), "Прессованный каменный топор, уровень 1");
        add(ScItems.COMPRESSED_STONE_AXE_LV2.get(), "Прессованный каменный топор, уровень 2");
        add(ScItems.COMPRESSED_STONE_AXE_LV3.get(), "Прессованный каменный топор, уровень 3");
        add(ScItems.COMPRESSED_STONE_AXE_LV4.get(), "Прессованный каменный топор, уровень 4");
        add(ScItems.COMPRESSED_STONE_AXE_LV5.get(), "Прессованный каменный топор, уровень 5");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV1.get(), "Прессованная каменная кирка, уровень 1");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV2.get(), "Прессованная каменная кирка, уровень 2");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV3.get(), "Прессованная каменная кирка, уровень 3");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV4.get(), "Прессованная каменная кирка, уровень 4");
        add(ScItems.COMPRESSED_STONE_PICKAXE_LV5.get(), "Прессованная каменная кирка, уровень 5");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV1.get(), "Прессованная каменная лопата, уровень 1");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV2.get(), "Прессованная каменная лопата, уровень 2");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV3.get(), "Прессованная каменная лопата, уровень 3");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV4.get(), "Прессованная каменная лопата, уровень 4");
        add(ScItems.COMPRESSED_STONE_SHOVEL_LV5.get(), "Прессованная каменная лопата, уровень 5");
        add(ScItems.COMPRESSED_STONE_HOE_LV1.get(), "Прессованная каменная мотыга, уровень 1");
        add(ScItems.COMPRESSED_STONE_HOE_LV2.get(), "Прессованная каменная мотыга, уровень 2");
        add(ScItems.COMPRESSED_STONE_HOE_LV3.get(), "Прессованная каменная мотыга, уровень 3");
        add(ScItems.COMPRESSED_STONE_HOE_LV4.get(), "Прессованная каменная мотыга, уровень 4");
        add(ScItems.COMPRESSED_STONE_HOE_LV5.get(), "Прессованная каменная мотыга, уровень 5");
        add(ScItems.VERSATILE_STONE_TOOL.get(), "Каменный мульти-тул");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV1.get(), "Прессованный каменный мульти-тул, уровень 1");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV2.get(), "Прессованный каменный мульти-тул, уровень 2");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV3.get(), "Прессованный каменный мульти-тул, уровень 3");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV4.get(), "Прессованный каменный мульти-тул, уровень 4");
        add(ScItems.VERSATILE_COMPRESSED_STONE_TOOL_LV5.get(), "Прессованный каменный мульти-тул, уровень 5");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV0.get(), "Каменный молот");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV1.get(), "Прессованный каменный молот, уровень 1");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV2.get(), "Прессованный каменный молот, уровень 2");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV3.get(), "Прессованный каменный молот, уровень 3");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV4.get(), "Прессованный каменный молот, уровень 4");
        add(ScItems.COMPRESSED_STONE_HAMMER_LV5.get(), "Прессованный каменный молот, уровень 5");
        add(ScItems.STONE_APPLE.get(), "Каменное яблоко");
        add(ScItems.STONE_BREAD.get(), "Каменный хлеб");
        add(ScItems.STONE_CARROT.get(), "Каменная морковь");
        add(ScItems.STONE_KELP.get(), "Каменная ламинария");
        add(ScItems.STONE_MELON_SLICE.get(), "Каменный кусочек арбуза");
        add(ScItems.STONE_POTATO.get(), "Каменный картофель");
        add(ScItems.STONE_HODGEPODGE.get(), "Каменная солянка");
        add(ScItems.STONE_STAR.get(), "Каменная звезда");
        add(ScItems.STONE_NUGGET.get(), "Каменный кусочек");
        add(ScItems.STONE_COIN.get(), "Каменная монетка");
        add(ScItems.STONE_HELMET.get(), "Каменный шлем");
        add(ScItems.STONE_CHESTPLATE.get(), "Каменный нагрудник");
        add(ScItems.STONE_LEGGINGS.get(), "Каменные поножи");
        add(ScItems.STONE_BOOTS.get(), "Каменные ботинки");
        add(ScItems.COMPRESSED_STONE_HELMET_LV1.get(), "Прессованный каменный шлем, уровень 1");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV1.get(), "Прессованный каменный нагрудник, уровень 1");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV1.get(), "Прессованные каменные поножи, уровень 1");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV1.get(), "Прессованные каменные ботинки, уровень 1");
        add(ScItems.COMPRESSED_STONE_HELMET_LV2.get(), "Прессованный каменный шлем, уровень 2");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV2.get(), "Прессованный каменный нагрудник, уровень 2");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV2.get(), "Прессованные каменные поножи, уровень 2");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV2.get(), "Прессованные каменные ботинки, уровень 2");
        add(ScItems.COMPRESSED_STONE_HELMET_LV3.get(), "Прессованный каменный шлем, уровень 3");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV3.get(), "Прессованный каменный нагрудник, уровень 3");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV3.get(), "Прессованные каменные поножи, уровень 3");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV3.get(), "Прессованные каменные ботинки, уровень 3");
        add(ScItems.COMPRESSED_STONE_HELMET_LV4.get(), "Прессованный каменный шлем, уровень 4");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV4.get(), "Прессованный каменный нагрудник, уровень 4");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV4.get(), "Прессованные каменные поножи, уровень 4");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV4.get(), "Прессованные каменные ботинки, уровень 4");
        add(ScItems.COMPRESSED_STONE_HELMET_LV5.get(), "Прессованный каменный шлем, уровень 5");
        add(ScItems.COMPRESSED_STONE_CHESTPLATE_LV5.get(), "Прессованный каменный нагрудник, уровень 5");
        add(ScItems.COMPRESSED_STONE_LEGGINGS_LV5.get(), "Прессованные каменные поножи, уровень 5");
        add(ScItems.COMPRESSED_STONE_BOOTS_LV5.get(), "Прессованные каменные ботинки, уровень 5");
        add(ScItems.STONICKERS.get(), "Стоуникерс");
        add(ScItems.COMPRESSED_STONICKERS_LV1.get(), "Прессованный Стоуникерс, уровень 1");
        add(ScItems.COMPRESSED_STONICKERS_LV2.get(), "Прессованный Стоуникерс, уровень 2");
        add(ScItems.COMPRESSED_STONICKERS_LV3.get(), "Прессованный Стоуникерс, уровень 3");
        add(ScItems.COMPRESSED_STONICKERS_LV4.get(), "Прессованный Стоуникерс, уровень 4");
        add(ScItems.COMPRESSED_STONICKERS_LV5.get(), "Прессованный Стоуникерс, уровень 5");
        add(ScItems.STONE_COOKED_COD.get(), "Каменная жареная треска");
        add(ScItems.STONE_COOKIE.get(), "Каменное печенье");
        add(ScItems.STONE_GLOW_BERRIES.get(), "Каменные светящиеся ягоды");
        add(ScItems.STONE_COOKED_BEEF.get(), "Каменный стейк");
        add(ScItems.STONE_SWEET_BERRIES.get(), "Каменные сладкие ягоды");
        add(ScItems.WOOD_SLINGSHOT.get(), "Деревянная рогатка");
        add(ScItems.STONE_SLINGSHOT.get(), "Каменная рогатка");
        add(ScItems.IRON_SLINGSHOT.get(), "Железная рогатка");
        add(ScItems.GOLD_SLINGSHOT.get(), "Золотая рогатка");
        add(ScItems.DIAMOND_SLINGSHOT.get(), "Алмазная рогатка");
        add(ScItems.NETHERITE_SLINGSHOT.get(), "Незеритовая рогатка");
        add(ScItems.STONE_BALL.get(), "Каменный шар");
        add(ScItems.STONE_ARROW.get(), "Каменная стрела");
        addEntityType(ScEntityTypes.STONE_ARROW, "Каменная стрела");
        add(ScItems.STONE_BOW.get(), "Каменный лук");
        //endregion

        //region Зачарования (附魔)
        addEnchantment(STONE_DESTROYER, "Дробитель");
        addEnchantment(STONE_BUFFER, "Мягкая посадка");
        addEnchantment(OLDB, "Мощь oldb");
        //endregion

        //region Достижения (成就)
        addAdvancement(STONE_ADVENTURE_ID, "StoneCraft", "Получите камень");
        addAdvancement(saAdvancementId(GET_COBBLESTONE), "Cobblestone Impact!", "Получите булыжник");
        addAdvancement(saAdvancementId(GET_ANDESITE), "Press w чтобы начать думать.jpg", "Получите андезит");
        addAdvancement(saAdvancementId(GET_DIORITE), "Причина не добывать кварц?", "Получите диорит");
        addAdvancement(saAdvancementId(GET_TUFF), "Тут аметисты", "Получите туф");
        addAdvancement(saAdvancementId(GET_CALCITE), "Красота!", "Получите кальцит");
        addAdvancement(saAdvancementId(GET_COBBLED_DEEPSLATE), "Прочный как скала!", "Получите колотый сланец");
        addAdvancement(saAdvancementId(GET_OBSIDIAN), "Прочный как скала! 2.0", "Получите обсидиан");
        addAdvancement(saAdvancementId(GET_BEDROCK), "Прочный как скала! 3.0", "Получите бедрок");
        addAdvancement(saAdvancementId(GET_END_STONE), "Средство от огня", "Получите эндерняк");
        addAdvancement(saAdvancementId(GET_NETHERRACK), "Хрустим...", "Получите незерак");
        addAdvancement(saAdvancementId(GET_BLACKSTONE), "Cobblestone Impact! 2.0", "Получите чернит");
        addAdvancement(saAdvancementId(GET_MOSSY_COBBLESTONE), "Зелёный как водоросли", "Получите замшелый булыжник");
        addAdvancement(saAdvancementId(GET_GRANITE), "Прости, забыл это", "Получите гранит");
        addAdvancement(saAdvancementId(OUR_TRIO), "Могучая кучка", "Получите андезит, диорит и гранит");
        addAdvancement(saAdvancementId(GET_FLINT), "Думаю, считается", "Получите кремень");
        addAdvancement(saAdvancementId(VILLAGER_MASON_ON_TRADES), "Опасная сделка", "Поторгуйтесь с масоном");
        addAdvancement(saAdvancementId(STONE_EATER), "Каменный сомелье", "Попробуйте каменную еду");
        addAdvancement(saAdvancementId(TEN_STONES_EATEN), "Каменный гурмэ", "Попробуйте 10 видов каменной еды");
        addAdvancement(saAdvancementId(EPIC_STONE_FEAST), "Каменная диета", "Попробуйте все виды каменной еды");
        addAdvancement(saAdvancementId("stone_convert"), "Каменная алхимия", "Впервые используйте Каменный преобразовательный стол");
        addAdvancement(saAdvancementId("get_redstone"), "Красный камень", "Получите редстоун");
        //endregion

        //region Сущности (实体)
        addEntityType(ScEntityTypes.STONE_NUGGET, "Каменный кусочек");
        add(SHOW_SKIP_RESULT_OWNER_TEXT, "Твой счёт: %d готово!");
        add(SHOW_SKIP_RESULT_OTHERS_TEXT, "Счёт %s: %d готово!");
        //endregion
    }

    //region Инструменты (工具)
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