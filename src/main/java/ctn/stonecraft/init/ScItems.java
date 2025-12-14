package ctn.stonecraft.init;

import com.mojang.datafixers.util.Function3;
import ctn.stonecraft.common.entity.projectile.stone_nugget.BasicStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.StoneNuggetProjectileBuilder;
import ctn.stonecraft.common.item.VersatileTool;
import ctn.stonecraft.common.item.slingshot.Slingshot;
import ctn.stonecraft.common.item.slingshot.SlingshotBuilder;
import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;
import ctn.stonecraft.common.item.stone_nugget.BasicStoneNuggetItem;
import ctn.stonecraft.common.item.stone_nugget.StoneNuggetBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static ctn.stonecraft.builder.FoodPropertiesBuilder.foodBuilder;
import static ctn.stonecraft.core.StoneCraft.ID;

public class ScItems {
  public static final DeferredRegister.Items REGISTER = DeferredRegister.createItems(ID);

  //region 压缩方块
	public static final List<DeferredItem<BlockItem>> COMPRESSED_COBBLESTONE       = registerGradeBlockItem(ScBlocks.COMPRESSED_COBBLESTONE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_MOSSY_COBBLESTONE = registerGradeBlockItem(ScBlocks.COMPRESSED_MOSSY_COBBLESTONE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_STONE             = registerGradeBlockItem(ScBlocks.COMPRESSED_STONE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_GRANITE           = registerGradeBlockItem(ScBlocks.COMPRESSED_GRANITE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_ANDESITE          = registerGradeBlockItem(ScBlocks.COMPRESSED_ANDESITE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_DIORITE           = registerGradeBlockItem(ScBlocks.COMPRESSED_DIORITE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_BEDROCK           = registerGradeBlockItem(ScBlocks.COMPRESSED_BEDROCK);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_END_STONE         = registerGradeBlockItem(ScBlocks.COMPRESSED_END_STONE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_OBSIDIAN          = registerGradeBlockItem(ScBlocks.COMPRESSED_OBSIDIAN);
	public static final DeferredItem<BlockItem>       GLOWINGOBSIDIAN              = registerBlockItem(ScBlocks.GLOWINGOBSIDIAN);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_GLOWINGOBSIDIAN   = registerGradeBlockItem(ScBlocks.COMPRESSED_GLOWINGOBSIDIAN);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_CRYING_OBSIDIAN   = registerGradeBlockItem(ScBlocks.COMPRESSED_CRYING_OBSIDIAN);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_PRISMARINE        = registerGradeBlockItem(ScBlocks.COMPRESSED_PRISMARINE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_DARK_PRISMARINE   = registerGradeBlockItem(ScBlocks.COMPRESSED_DARK_PRISMARINE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_NETHERRACK        = registerGradeBlockItem(ScBlocks.COMPRESSED_NETHERRACK);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_GLOWSTONE         = registerGradeBlockItem(ScBlocks.COMPRESSED_GLOWSTONE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_BLACKSTONE        = registerGradeBlockItem(ScBlocks.COMPRESSED_BLACKSTONE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_CALCITE           = registerGradeBlockItem(ScBlocks.COMPRESSED_CALCITE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_DEEPSLATE         = registerGradeBlockItem(ScBlocks.COMPRESSED_DEEPSLATE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_COBBLED_DEEPSLATE = registerGradeBlockItem(ScBlocks.COMPRESSED_COBBLED_DEEPSLATE);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_BASALT            = registerGradeBlockItem(ScBlocks.COMPRESSED_BASALT);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_TUFF              = registerGradeBlockItem(ScBlocks.COMPRESSED_TUFF);
	public static final List<DeferredItem<BlockItem>> COMPRESSED_DRIPSTONE_BLOCK   = registerGradeBlockItem(ScBlocks.COMPRESSED_DRIPSTONE_BLOCK);
	//endregion

  //region 功能方块

  // 石质工作台
  public static final DeferredItem<BlockItem> STONE_CRAFTING_TABLE = REGISTER.registerSimpleBlockItem("stone_crafting_table", ScBlocks.STONE_CRAFTING_TABLE);
  //endregion

	//region 工具

	public static final DeferredItem<Item> COMPRESSED_STONE_AXE_LV1 = registerDiggerItem("compressed_stone_axe_lv1", AxeItem::new, ScTiers.LV1, 5, -3.2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_AXE_LV2 = registerDiggerItem("compressed_stone_axe_lv2", AxeItem::new, ScTiers.LV2, 5, -3.2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_AXE_LV3 = registerDiggerItem("compressed_stone_axe_lv3", AxeItem::new, ScTiers.LV3, 5, -3.2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_AXE_LV4 = registerDiggerItem("compressed_stone_axe_lv4", AxeItem::new, ScTiers.LV4, 5, -3.2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_AXE_LV5 = registerDiggerItem("compressed_stone_axe_lv5", AxeItem::new, ScTiers.LV5, 5, -3.2f);

	public static final DeferredItem<Item> COMPRESSED_STONE_PICKAXE_LV1 = registerDiggerItem("compressed_stone_pickaxe_lv1", PickaxeItem::new, ScTiers.LV1, -3, -2.8f);
	public static final DeferredItem<Item> COMPRESSED_STONE_PICKAXE_LV2 = registerDiggerItem("compressed_stone_pickaxe_lv2", PickaxeItem::new, ScTiers.LV2, -3, -2.8f);
	public static final DeferredItem<Item> COMPRESSED_STONE_PICKAXE_LV3 = registerDiggerItem("compressed_stone_pickaxe_lv3", PickaxeItem::new, ScTiers.LV3, -3, -2.8f);
	public static final DeferredItem<Item> COMPRESSED_STONE_PICKAXE_LV4 = registerDiggerItem("compressed_stone_pickaxe_lv4", PickaxeItem::new, ScTiers.LV4, -3, -2.8f);
	public static final DeferredItem<Item> COMPRESSED_STONE_PICKAXE_LV5 = registerDiggerItem("compressed_stone_pickaxe_lv5", PickaxeItem::new, ScTiers.LV5, -3, -2.8f);

	public static final DeferredItem<Item> COMPRESSED_STONE_SHOVEL_LV1 = registerDiggerItem("compressed_stone_shovel_lv1", ShovelItem::new, ScTiers.LV1, -2.5f, -3.0f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SHOVEL_LV2 = registerDiggerItem("compressed_stone_shovel_lv2", ShovelItem::new, ScTiers.LV2, -2.5f, -3.0f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SHOVEL_LV3 = registerDiggerItem("compressed_stone_shovel_lv3", ShovelItem::new, ScTiers.LV3, -2.5f, -3.0f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SHOVEL_LV4 = registerDiggerItem("compressed_stone_shovel_lv4", ShovelItem::new, ScTiers.LV4, -2.5f, -3.0f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SHOVEL_LV5 = registerDiggerItem("compressed_stone_shovel_lv5", ShovelItem::new, ScTiers.LV5, -2.5f, -3.0f);

	public static final DeferredItem<Item> COMPRESSED_STONE_HOE_LV1 = registerDiggerItem("compressed_stone_hoe_lv1", HoeItem::new, ScTiers.LV1, -4f, -2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_HOE_LV2 = registerDiggerItem("compressed_stone_hoe_lv2", HoeItem::new, ScTiers.LV2, -4f, -2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_HOE_LV3 = registerDiggerItem("compressed_stone_hoe_lv3", HoeItem::new, ScTiers.LV3, -4f, -2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_HOE_LV4 = registerDiggerItem("compressed_stone_hoe_lv4", HoeItem::new, ScTiers.LV4, -4f, -2f);
	public static final DeferredItem<Item> COMPRESSED_STONE_HOE_LV5 = registerDiggerItem("compressed_stone_hoe_lv5", HoeItem::new, ScTiers.LV5, -4f, -2f);

	public static final DeferredItem<Item> VERSATILE_STONE_TOOL                = registerDiggerItem("versatile_stone_tool", VersatileTool::new, new Item.Properties(), Tiers.STONE, 10, -2.0f);
	public static final DeferredItem<Item> VERSATILE_COMPRESSED_STONE_TOOL_LV1 = registerDiggerItem("versatile_compressed_stone_tool_lv1", VersatileTool::new, new Item.Properties(), ScTiers.LV1, 5, -3.2f);
	public static final DeferredItem<Item> VERSATILE_COMPRESSED_STONE_TOOL_LV2 = registerDiggerItem("versatile_compressed_stone_tool_lv2", VersatileTool::new, new Item.Properties(), ScTiers.LV2, 5, -3.2f);
	public static final DeferredItem<Item> VERSATILE_COMPRESSED_STONE_TOOL_LV3 = registerDiggerItem("versatile_compressed_stone_tool_lv3", VersatileTool::new, new Item.Properties(), ScTiers.LV3, 5, -3.2f);
	public static final DeferredItem<Item> VERSATILE_COMPRESSED_STONE_TOOL_LV4 = registerDiggerItem("versatile_compressed_stone_tool_lv4", VersatileTool::new, new Item.Properties(), ScTiers.LV4, 5, -3.2f);
	public static final DeferredItem<Item> VERSATILE_COMPRESSED_STONE_TOOL_LV5 = registerDiggerItem("versatile_compressed_stone_tool_lv5", VersatileTool::new, new Item.Properties(), ScTiers.LV5, 5, -3.2f);
	//endregion

	//region 剑
	public static final DeferredItem<Item> COMPRESSED_STONE_SWORD_LV1 = registerSwordItem("compressed_stone_sword_lv1", SwordItem::new, ScTiers.LV1, 0, -2.4f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SWORD_LV2 = registerSwordItem("compressed_stone_sword_lv2", SwordItem::new, ScTiers.LV2, 0, -2.4f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SWORD_LV3 = registerSwordItem("compressed_stone_sword_lv3", SwordItem::new, ScTiers.LV3, 0, -2.4f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SWORD_LV4 = registerSwordItem("compressed_stone_sword_lv4", SwordItem::new, ScTiers.LV4, 0, -2.4f);
	public static final DeferredItem<Item> COMPRESSED_STONE_SWORD_LV5 = registerSwordItem("compressed_stone_sword_lv5", SwordItem::new, ScTiers.LV5, 0, -2.4f);

	public static final DeferredItem<Item> ULTIMATE_COMPRESSED_STONE_SWORD_ACT1 = registerSwordItem("ultimate_compressed_stone_sword_act1", SwordItem::new, ScTiers.LV5, 4, -2.4f);
	public static final DeferredItem<Item> ULTIMATE_COMPRESSED_STONE_SWORD_ACT2 = registerSwordItem("ultimate_compressed_stone_sword_act2", SwordItem::new, ScTiers.LV5, 7, -2.4f);
	public static final DeferredItem<Item> ULTIMATE_COMPRESSED_STONE_SWORD_ACT3 = registerSwordItem("ultimate_compressed_stone_sword_act3", SwordItem::new, ScTiers.LV5, 11, -2.4f);
	//endregion

	//region 弹弓
	public static final DeferredItem<Slingshot> WOOD_SLINGSHOT      = registerSlingshot("wood_slingshot", Tiers.WOOD,
			new Item.Properties(), new SlingshotBuilder().damageBonus(-1f).chargingTime(15).speedBonus(0.14f));
	public static final DeferredItem<Slingshot> STONE_SLINGSHOT     = registerSlingshot("stone_slingshot", Tiers.STONE,
			new Item.Properties(), new SlingshotBuilder().damageBonus(0f).chargingTime(25).speedBonus(0.16f));
	public static final DeferredItem<Slingshot> IRON_SLINGSHOT      = registerSlingshot("iron_slingshot", Tiers.IRON,
			new Item.Properties(), new SlingshotBuilder().damageBonus(1).speedBonus(0.24f));
	public static final DeferredItem<Slingshot> GOLD_SLINGSHOT      = registerSlingshot("gold_slingshot", Tiers.GOLD,
			new Item.Properties(), new SlingshotBuilder().damageBonus(-0.5f).chargingTime(10).speedBonus(0.15f));
	public static final DeferredItem<Slingshot> DIAMOND_SLINGSHOT   = registerSlingshot("diamond_slingshot", Tiers.DIAMOND,
			new Item.Properties(), new SlingshotBuilder().damageBonus(2f).speedBonus(0.25f));
	public static final DeferredItem<Slingshot> NETHERITE_SLINGSHOT = registerSlingshot("netherite_slingshot", Tiers.NETHERITE,
			new Item.Properties(), new SlingshotBuilder().damageBonus(3f).speedBonus(0.27f));
	//endregion

  //region 材料
	public static final DeferredItem<Item> STONE_STAR = registerItem("stone_star");
	public static final DeferredItem<Item> STONE_COIN = registerItem("stone_coin");
	//endregion

  //region 石粒
	public static final DeferredItem<AbsStoneNuggetItem> STONE_NUGGET = registerStoneNuggetItem("stone_nugget",
			new StoneNuggetBuilder(StoneNuggetProjectileBuilder::new, BasicStoneNuggetProjectile::new, BasicStoneNuggetProjectile::new), new Item.Properties());

  //endregion

  //region 食物
	public static final DeferredItem<Item> STONE_APPLE         = registerFood("stone_apple",
			foodBuilder().nutrition(6).saturation(4.8f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_BREAD         = registerFood("stone_bread",
			foodBuilder().nutrition(7).saturation(12f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_CARROT        = registerFood("stone_carrot",
			foodBuilder().nutrition(5).saturation(7.2f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_KELP          = registerFood("stone_kelp",
			foodBuilder().nutrition(3).saturation(1.2f).eatSeconds(1.9f).build());
	public static final DeferredItem<Item> STONE_MELON_SLICE   = registerFood("stone_melon_slice",
			foodBuilder().nutrition(4).saturation(2.4f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_POTATO        = registerFood("stone_potato",
			foodBuilder().nutrition(3).saturation(1.2f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_COOKED_COD    = registerFood("stone_cooked_cod",
			foodBuilder().nutrition(7).saturation(1.6f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_COOKIE        = registerFood("stone_cookie",
			foodBuilder().nutrition(4).saturation(0.8f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_GLOW_BERRIES  = registerFood("stone_glow_berries",
			foodBuilder().nutrition(4).saturation(0.8f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_COOKED_BEEF   = registerFood("stone_cooked_beef",
			foodBuilder().nutrition(10).saturation(23.6f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_SWEET_BERRIES = registerFood("stone_sweet_berries",
			foodBuilder().nutrition(4).saturation(0.8f).eatSeconds(2.1f).build());
	public static final DeferredItem<Item> STONE_HODGEPODGE    = registerFood("stone_hodgepodge",
			foodBuilder().nutrition(10).saturation(5).eatSeconds(3f)
					.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1))
					.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1))
					.addEffect(new MobEffectInstance(MobEffects.SATURATION, 200, 1))
					.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0))
					.usingConvertsTo(Items.BOWL)
					.build()
	);

  public static final DeferredItem<Item> STONICKERS                = registerFood("stonickers",
			foodBuilder().nutrition(10).saturation(5).eatSeconds(1f)
					.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0))
					.alwaysEdible()
					.build()
	);
	public static final DeferredItem<Item> COMPRESSED_STONICKERS_LV1 = registerFood("compressed_stonickers_lv1",
			foodBuilder().nutrition(12).saturation(6).eatSeconds(1f)
					.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400, 1))
					.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0))
					.alwaysEdible()
					.build()
	);
	public static final DeferredItem<Item> COMPRESSED_STONICKERS_LV2 = registerFood("compressed_stonickers_lv2",
			foodBuilder().nutrition(14).saturation(7).eatSeconds(1f)
					.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 600, 2))
					.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 1))
					.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 0))
					.alwaysEdible()
					.build()
	);
	public static final DeferredItem<Item> COMPRESSED_STONICKERS_LV3 = registerFood("compressed_stonickers_lv3",
			foodBuilder().nutrition(16).saturation(8).eatSeconds(1f)
					.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1000, 3))
					.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600, 2))
					.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400, 1))
					.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200, 0))
					.alwaysEdible()
					.build()
	);
	public static final DeferredItem<Item> COMPRESSED_STONICKERS_LV4 = registerFood("compressed_stonickers_lv4",
			foodBuilder().nutrition(18).saturation(9).eatSeconds(1f)
					.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1400, 4))
					.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000, 3))
					.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 600, 2))
					.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 400, 1))
					.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0))
					.alwaysEdible()
					.build()
	);
	public static final DeferredItem<Item> COMPRESSED_STONICKERS_LV5 = registerFood("compressed_stonickers_lv5",
			foodBuilder().nutrition(20).saturation(10).eatSeconds(1f)
					.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3000, 5))
					.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2000, 4))
					.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1600, 3))
					.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1400, 2))
					.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 1))
					.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0))
					.alwaysEdible()
					.build()
	);
	//endregion

  //region 盔甲
	private static final int                BASE_HELMET_MAX_DAMAGE     = 165;
	private static final int                BASE_CHESTPLATE_MAX_DAMAGE = 240;
	private static final int                BASE_LEGGINGS_MAX_DAMAGE   = 225;
	private static final int                BASE_BOOTS_MAX_DAMAGE      = 195;
	public static final  DeferredItem<Item> STONE_LEGGINGS             = registerLeggings("stone_leggings", ScArmorMaterials.LV0, BASE_LEGGINGS_MAX_DAMAGE);
	public static final  DeferredItem<Item> STONE_CHESTPLATE           = registerChestplate("stone_chestplate", ScArmorMaterials.LV0, BASE_CHESTPLATE_MAX_DAMAGE);
	public static final  DeferredItem<Item> STONE_HELMET               = registerHelmet("stone_helmet", ScArmorMaterials.LV0, BASE_HELMET_MAX_DAMAGE);
	public static final  DeferredItem<Item> STONE_BOOTS                = registerBoots("stone_boots", ScArmorMaterials.LV0, BASE_BOOTS_MAX_DAMAGE);

  private static final float              LV1_MAX_DAMAGE                  = 2f;
	public static final  DeferredItem<Item> COMPRESSED_STONE_HELMET_LV1     = registerHelmet("compressed_stone_helmet_lv1", ScArmorMaterials.LV1, (int) (BASE_HELMET_MAX_DAMAGE * LV1_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_CHESTPLATE_LV1 = registerChestplate("compressed_stone_chestplate_lv1", ScArmorMaterials.LV1, (int) (BASE_CHESTPLATE_MAX_DAMAGE * LV1_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_LEGGINGS_LV1   = registerLeggings("compressed_stone_leggings_lv1", ScArmorMaterials.LV1, (int) (BASE_LEGGINGS_MAX_DAMAGE * LV1_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_BOOTS_LV1      = registerBoots("compressed_stone_boots_lv1", ScArmorMaterials.LV1, (int) (BASE_BOOTS_MAX_DAMAGE * LV1_MAX_DAMAGE));

  private static final float              LV2_MAX_DAMAGE                  = 3.5f;
	public static final  DeferredItem<Item> COMPRESSED_STONE_HELMET_LV2     = registerHelmet("compressed_stone_helmet_lv2", ScArmorMaterials.LV2, (int) (BASE_HELMET_MAX_DAMAGE * LV2_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_CHESTPLATE_LV2 = registerChestplate("compressed_stone_chestplate_lv2", ScArmorMaterials.LV2, (int) (BASE_CHESTPLATE_MAX_DAMAGE * LV2_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_LEGGINGS_LV2   = registerLeggings("compressed_stone_leggings_lv2", ScArmorMaterials.LV2, (int) (BASE_LEGGINGS_MAX_DAMAGE * LV2_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_BOOTS_LV2      = registerBoots("compressed_stone_boots_lv2", ScArmorMaterials.LV2, (int) (BASE_BOOTS_MAX_DAMAGE * LV2_MAX_DAMAGE));

  private static final float              LV3_MAX_DAMAGE                  = 4.5f;
	public static final  DeferredItem<Item> COMPRESSED_STONE_HELMET_LV3     = registerHelmet("compressed_stone_helmet_lv3", ScArmorMaterials.LV3, (int) (BASE_HELMET_MAX_DAMAGE * LV3_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_CHESTPLATE_LV3 = registerChestplate("compressed_stone_chestplate_lv3", ScArmorMaterials.LV3, (int) (BASE_CHESTPLATE_MAX_DAMAGE * LV3_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_LEGGINGS_LV3   = registerLeggings("compressed_stone_leggings_lv3", ScArmorMaterials.LV3, (int) (BASE_LEGGINGS_MAX_DAMAGE * LV3_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_BOOTS_LV3      = registerBoots("compressed_stone_boots_lv3", ScArmorMaterials.LV3, (int) (BASE_BOOTS_MAX_DAMAGE * LV3_MAX_DAMAGE));

  private static final float              LV4_MAX_DAMAGE                  = 6f;
	public static final  DeferredItem<Item> COMPRESSED_STONE_HELMET_LV4     = registerHelmet("compressed_stone_helmet_lv4", ScArmorMaterials.LV4, (int) (BASE_HELMET_MAX_DAMAGE * LV4_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_CHESTPLATE_LV4 = registerChestplate("compressed_stone_chestplate_lv4", ScArmorMaterials.LV4, (int) (BASE_CHESTPLATE_MAX_DAMAGE * LV4_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_LEGGINGS_LV4   = registerLeggings("compressed_stone_leggings_lv4", ScArmorMaterials.LV4, (int) (BASE_LEGGINGS_MAX_DAMAGE * LV4_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_BOOTS_LV4      = registerBoots("compressed_stone_boots_lv4", ScArmorMaterials.LV4, (int) (BASE_BOOTS_MAX_DAMAGE * LV4_MAX_DAMAGE));

  private static final float              LV5_MAX_DAMAGE                  = 7.5f;
	public static final  DeferredItem<Item> COMPRESSED_STONE_HELMET_LV5     = registerHelmet("compressed_stone_helmet_lv5", ScArmorMaterials.LV5, (int) (BASE_HELMET_MAX_DAMAGE * LV5_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_CHESTPLATE_LV5 = registerChestplate("compressed_stone_chestplate_lv5", ScArmorMaterials.LV5, (int) (BASE_CHESTPLATE_MAX_DAMAGE * LV5_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_LEGGINGS_LV5   = registerLeggings("compressed_stone_leggings_lv5", ScArmorMaterials.LV5, (int) (BASE_LEGGINGS_MAX_DAMAGE * LV5_MAX_DAMAGE));
	public static final  DeferredItem<Item> COMPRESSED_STONE_BOOTS_LV5      = registerBoots("compressed_stone_boots_lv5", ScArmorMaterials.LV5, (int) (BASE_BOOTS_MAX_DAMAGE * LV5_MAX_DAMAGE));
	//endregion

  //region 注册方法
	private static DeferredItem<Slingshot> registerSlingshot(String name, Tier tier, Item.Properties properties, SlingshotBuilder builder) {
		return registerSlingshot(name, Slingshot::new, tier, properties, builder);
	}

  private static DeferredItem<Slingshot> registerSlingshot(String name, Function3<Tier, Item.Properties, SlingshotBuilder, Slingshot> supplier, Tier tier, Item.Properties properties, SlingshotBuilder builder) {
    return REGISTER.register(name, () -> supplier.apply(tier, properties, builder));
	}

  private static DeferredItem<Item> registerHelmet(String name, Holder<ArmorMaterial> material, int maxDamage) {
		return registerArmor(name, ArmorItem.Type.HELMET, material, maxDamage);
	}

  private static DeferredItem<Item> registerArmor(String name, ArmorItem.Type type, Holder<ArmorMaterial> material, int maxDamage) {
    return REGISTER.register(name, () -> new ArmorItem(material, type, new Item.Properties().durability(maxDamage)));
	}

  private static DeferredItem<Item> registerChestplate(String name, Holder<ArmorMaterial> material, int maxDamage) {
		return registerArmor(name, ArmorItem.Type.CHESTPLATE, material, maxDamage);
	}

  private static DeferredItem<Item> registerLeggings(String name, Holder<ArmorMaterial> material, int maxDamage) {
		return registerArmor(name, ArmorItem.Type.LEGGINGS, material, maxDamage);
	}

  private static DeferredItem<Item> registerBoots(String name, Holder<ArmorMaterial> material, int maxDamage) {
		return registerArmor(name, ArmorItem.Type.BOOTS, material, maxDamage);
	}

  private static DeferredItem<Item> registerItem(String name, Item.Properties props) {
    return REGISTER.registerSimpleItem(name, props);
	}

  private static <I extends Item> DeferredItem<I> registerItem(String name, Function<Item.Properties, ? extends I> func) {
		return registerItem(name, func, new Item.Properties());
	}

  private static <I extends Item> DeferredItem<I> registerItem(String name, Function<Item.Properties, ? extends I> func, Item.Properties props) {
    return REGISTER.registerItem(name, func, props);
	}

  private static DeferredItem<AbsStoneNuggetItem> registerStoneNuggetItem(String name,
			StoneNuggetBuilder stoneNuggetBuilder, Item.Properties properties) {
		return registerStoneNuggetItem(name, BasicStoneNuggetItem::new, stoneNuggetBuilder, properties);
	}

  private static DeferredItem<AbsStoneNuggetItem> registerStoneNuggetItem(String name,
			BiFunction<Item.Properties, StoneNuggetBuilder, AbsStoneNuggetItem> item, StoneNuggetBuilder stoneNuggetBuilder, Item.Properties properties) {
    return REGISTER.registerItem(name, (p) -> item.apply(p, stoneNuggetBuilder), properties);
	}

  private static DeferredItem<Item> registerItem(String name) {
    return REGISTER.registerSimpleItem(name, new Item.Properties());
	}

  private static DeferredItem<Item> registerFood(String name, FoodProperties foodProperties) {
    return REGISTER.registerItem(name, Item::new, new Item.Properties().food(foodProperties));
	}

  // 注册一个带有默认属性的挖掘物品
	private static <I extends TieredItem> @NotNull DeferredItem<Item> registerDiggerItem(String name, BiFunction<Tier, Item.Properties, I> func, Tier pTier, float attackDamage, float attackSpeed) {
		return registerDiggerItem(name, func, new Item.Properties(), pTier, attackDamage, attackSpeed);
	}

  // 使用指定属性注册一个挖掘物品
	private static <I extends TieredItem> @NotNull DeferredItem<Item> registerDiggerItem(String name, BiFunction<Tier, Item.Properties, I> func, Item.Properties properties, Tier pTier, float attackDamage, float attackSpeed) {
		return registerTieredItem(name, func, properties.attributes(DiggerItem.createAttributes(pTier, attackDamage, attackSpeed)), pTier);
	}

  private static <I extends TieredItem> DeferredItem<Item> registerTieredItem(String name, BiFunction<Tier, Item.Properties, ? extends I> func, Item.Properties properties, Tier pTier) {
    return REGISTER.register(name, () -> func.apply(pTier, properties));
	}

  // 使用指定函数和等级注册一个剑类物品，并应用自定义攻击伤害和速度
	private static <I extends TieredItem> @NotNull DeferredItem<Item> registerSwordItem(String name, BiFunction<Tier, Item.Properties, I> func, Tier pTier, int attackDamage, float attackSpeed) {
		return registerSwordItem(name, func, new Item.Properties(), pTier, attackDamage, attackSpeed);
	}

  // 使用指定函数和属性注册一个剑类物品，并应用自定义攻击伤害和速度
	private static <I extends TieredItem> @NotNull DeferredItem<Item> registerSwordItem(String name, BiFunction<Tier, Item.Properties, I> func, Item.Properties properties, Tier pTier, int attackDamage, float attackSpeed) {
		return registerTieredItem(name, func, properties.attributes(SwordItem.createAttributes(pTier, attackDamage, attackSpeed)), pTier);
	}

  // 将给定的方块列表转换为不可变的方块物品列表
	private static <B extends Block> List<DeferredItem<BlockItem>> registerGradeBlockItem(List<DeferredBlock<B>> blocks) {
		if (blocks == null || blocks.isEmpty()) {
			return List.of();
		}
		int size = blocks.size();
		List<DeferredItem<BlockItem>> blockItems = new ArrayList<>(size - 1);

    for (DeferredBlock<B> block : blocks) {
			blockItems.add(registerBlockItem(block));
		}
		return Collections.unmodifiableList(blockItems);
	}

  // 注册一个简单的方块物品
	private static DeferredItem<BlockItem> registerBlockItem(Holder<Block> block) {
    return REGISTER.registerSimpleBlockItem(block);
	}
	//endregion
}
