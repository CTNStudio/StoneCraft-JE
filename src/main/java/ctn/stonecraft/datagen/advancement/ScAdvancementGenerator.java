package ctn.stonecraft.datagen.advancement;

import ctn.stonecraft.common.trigger.CountCriterionTrigger;
import ctn.stonecraft.datagen.tool.AdvancementProviderTool;
import ctn.stonecraft.init.ScItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.NbtPredicate;
import net.minecraft.advancements.critereon.TradeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Consumer;

import static ctn.stonecraft.StoneCraft.path;
import static ctn.stonecraft.datagen.ScTags.ScItems.ADVANCEMENT_ROOT_ITEM;
import static ctn.stonecraft.datagen.tool.AdvancementProviderTool.*;
import static net.neoforged.neoforge.common.data.AdvancementProvider.AdvancementGenerator;

public final class ScAdvancementGenerator implements AdvancementGenerator {
	public static final String STONE_ADVENTURE_ID = "stone_adventure";
	public static final Item[] ALL_STONE_FOOD     = {
			ScItems.STONE_APPLE.get(),
			ScItems.STONE_BREAD.get(),
			ScItems.STONE_CARROT.get(),
			ScItems.STONE_KELP.get(),
			ScItems.STONE_MELON_SLICE.get(),
			ScItems.STONE_POTATO.get(),
			ScItems.STONE_HODGEPODGE.get(),
			ScItems.STONICKERS.get(),
			ScItems.STONE_COOKED_COD.get(),
			ScItems.STONE_COOKIE.get(),
			ScItems.STONE_COOKED_BEEF.get(),
			ScItems.STONE_GLOW_BERRIES.get(),
			ScItems.STONE_SWEET_BERRIES.get(),
			ScItems.COMPRESSED_STONICKERS_LV1.get(),
			ScItems.COMPRESSED_STONICKERS_LV2.get(),
			ScItems.COMPRESSED_STONICKERS_LV3.get(),
			ScItems.COMPRESSED_STONICKERS_LV4.get(),
			ScItems.COMPRESSED_STONICKERS_LV5.get()
	};
	
	public static final String TEN_STONES_EATEN         = "ten_stones_eaten";
	public static final String GET_COBBLESTONE          = "get_cobblestone";
	public static final String GET_BLACKSTONE           = "get_blackstone";
	public static final String GET_ANDESITE             = "get_andesite";
	public static final String GET_DIORITE              = "get_diorite";
	public static final String GET_TUFF                 = "get_tuff";
	public static final String GET_CALCITE              = "get_calcite";
	public static final String GET_COBBLED_DEEPSLATE    = "get_cobbled_deepslate";
	public static final String GET_OBSIDIAN             = "get_obsidian";
	public static final String GET_BEDROCK              = "get_bedrock";
	public static final String GET_END_STONE            = "get_end_stone";
	public static final String GET_NETHERRACK           = "get_netherrack";
	public static final String GET_MOSSY_COBBLESTONE    = "get_mossy_cobblestone";
	public static final String GET_GRANITE              = "get_granite";
	public static final String GET_FLINT                = "get_flint";
	public static final String OUR_TRIO                 = "our_trio";
	public static final String STONE_EATER              = "stone_eater";
	public static final String EPIC_STONE_FEAST         = "epic_stone_feast";
	public static final String VILLAGER_MASON_ON_TRADES = "villager_mason_on_trades";
	
	@Override
	public void generate(HolderLookup.@NotNull Provider provider,
			@NotNull Consumer<AdvancementHolder> saver,
			@NotNull ExistingFileHelper helper) {
		AdvancementHolder root = save(Advancement.Builder.advancement().display(
								Items.COBBLESTONE,
								titleText(STONE_ADVENTURE_ID),
								descriptionText(STONE_ADVENTURE_ID),
								path("textures/block/compressed_cobblestone/lv1.png"),
								AdvancementType.TASK,
								true,
								true,
								false)
						.requirements(AdvancementRequirements.Strategy.OR)
						.addCriterion("get_stone", obtainItem(matchItems(ADVANCEMENT_ROOT_ITEM))),
				saver, saAdvancementId("root"));
		AdvancementHolder getCobblestone = createObtainAdv(
				root, saver, saAdvancementId(GET_COBBLESTONE),
				Items.COBBLESTONE, AdvancementType.TASK,
				false);
		AdvancementHolder getBlackstone = createObtainAdv(
				getCobblestone, saver, saAdvancementId(GET_BLACKSTONE),
				Items.BLACKSTONE, AdvancementType.TASK,
				false);
		AdvancementHolder getAndesite = createObtainAdv(
				root, saver, saAdvancementId(GET_ANDESITE),
				Items.ANDESITE, AdvancementType.TASK,
				false);
		AdvancementHolder getDiorite = createObtainAdv(
				root, saver, saAdvancementId(GET_DIORITE),
				Items.DIORITE, AdvancementType.TASK,
				false);
		AdvancementHolder getTuff = createObtainAdv(
				root, saver, saAdvancementId(GET_TUFF),
				Items.TUFF, AdvancementType.TASK,
				false);
		AdvancementHolder getCalcite = createObtainAdv(
				root, saver, saAdvancementId(GET_CALCITE),
				Items.CALCITE, AdvancementType.TASK,
				false);
		AdvancementHolder getCobbledDeepslate = createObtainAdv(
				root, saver, saAdvancementId(GET_COBBLED_DEEPSLATE),
				Items.COBBLED_DEEPSLATE, AdvancementType.TASK,
				false);
		AdvancementHolder getObsidian = createObtainAdv(
				getCobbledDeepslate, saver, saAdvancementId(GET_OBSIDIAN),
				Items.OBSIDIAN, AdvancementType.TASK,
				false);
		AdvancementHolder getBedrock = createObtainAdv(
				getObsidian, saver, saAdvancementId(GET_BEDROCK),
				Items.BEDROCK, AdvancementType.TASK,
				false);
		AdvancementHolder getEndStone = createObtainAdv(
				root, saver, saAdvancementId(GET_END_STONE),
				Items.END_STONE, AdvancementType.TASK,
				false);
		AdvancementHolder getNetherrack = createObtainAdv(
				root, saver, saAdvancementId(GET_NETHERRACK),
				Items.NETHERRACK, AdvancementType.TASK,
				false);
		AdvancementHolder getMossyCobblestone = createObtainAdv(
				root, saver, saAdvancementId(GET_MOSSY_COBBLESTONE),
				Items.MOSSY_COBBLESTONE, AdvancementType.TASK,
				false);
		AdvancementHolder getGranite = createObtainAdv(
				root, saver, saAdvancementId(GET_GRANITE),
				Items.GRANITE, AdvancementType.TASK,
				false);
		AdvancementHolder getFlint = createObtainAdv(
				root, saver, saAdvancementId(GET_FLINT),
				Items.FLINT, AdvancementType.TASK,
				false);
		AdvancementHolder ourTrio = save(
				Advancement.Builder.advancement().parent(root).display(
								Items.COBBLESTONE,
								titleText(saAdvancementId(OUR_TRIO)),
								descriptionText(saAdvancementId(OUR_TRIO)),
								null,
								AdvancementType.TASK,
								true,
								true,
								false)
						.addCriterion(GET_GRANITE, obtainItem(matchItems(Items.GRANITE)))
						.addCriterion(GET_ANDESITE, obtainItem(matchItems(Items.ANDESITE)))
						.addCriterion(GET_DIORITE, obtainItem(matchItems(Items.DIORITE))),
				saver, saAdvancementId(OUR_TRIO));
		
		/// 食石
		AdvancementHolder edibleStoneFood = save(
				Advancement.Builder.advancement().parent(root).display(
						ScItems.STONE_APPLE,
						titleText(saAdvancementId(STONE_EATER)),
						descriptionText(saAdvancementId(STONE_EATER)),
						null,
						AdvancementType.TASK,
						true,
						true,
						false
				).addCriterion("eater_stone_food", ConsumeItemTrigger.TriggerInstance.usedItem(matchItems(ALL_STONE_FOOD))),
				saver, saAdvancementId(STONE_EATER));
		
		Advancement.Builder edibleTenStoneFoodBuilder = Advancement.Builder.advancement().parent(edibleStoneFood).display(
				ScItems.STONE_HODGEPODGE,
				titleText(saAdvancementId(TEN_STONES_EATEN)),
				descriptionText(saAdvancementId(TEN_STONES_EATEN)),
				null,
				AdvancementType.TASK,
				true,
				true,
				false);
		
		ResourceLocation tenStonesEaten = path(TEN_STONES_EATEN);
		for (int i = 0; i < 10; i++) {
			edibleTenStoneFoodBuilder.addCriterion(String.valueOf(i),
					CountCriterionTrigger.TriggerInstance.createCriterion(
							tenStonesEaten,
							matchItems(ALL_STONE_FOOD)));
		}
		
		AdvancementHolder edibleTenStoneFood = save(edibleTenStoneFoodBuilder, saver, saAdvancementId(TEN_STONES_EATEN));
		
		Advancement.Builder edibleAllStoneFoodBuilder = Advancement.Builder.advancement().parent(edibleTenStoneFood).display(
				ScItems.STONICKERS,
				titleText(saAdvancementId(EPIC_STONE_FEAST)),
				descriptionText(saAdvancementId(EPIC_STONE_FEAST)),
				null,
				AdvancementType.CHALLENGE,
				true,
				true,
				false);
		
		for (Item item : ALL_STONE_FOOD) {
			edibleAllStoneFoodBuilder.addCriterion(item.getDescriptionId(),
					ConsumeItemTrigger.TriggerInstance.usedItem(matchItems(item)));
		}
		
		AdvancementHolder edibleAllStoneFood = save(edibleAllStoneFoodBuilder, saver, saAdvancementId(EPIC_STONE_FEAST));
		
		AdvancementHolder villagerMasonOnTrades;
		{
			CompoundTag nbt = new CompoundTag();
			CompoundTag nbt2 = new CompoundTag();
			nbt2.putString("profession", "minecraft:mason");
			nbt.put("VillagerData", nbt2);
			EntityPredicate.Builder villager = EntityPredicate.Builder.entity().nbt(new NbtPredicate(nbt));
			TradeTrigger.TriggerInstance triggerInstance = new TradeTrigger.TriggerInstance(Optional.empty(),
					Optional.of(EntityPredicate.wrap(villager)), Optional.empty());
			villagerMasonOnTrades = save(
					Advancement.Builder.advancement().parent(root).display(
							ScItems.STONE_COIN,
							titleText(saAdvancementId(VILLAGER_MASON_ON_TRADES)),
							descriptionText(saAdvancementId(VILLAGER_MASON_ON_TRADES)),
							null,
							AdvancementType.TASK,
							true,
							true,
							false
					).addCriterion("mason", CriteriaTriggers.TRADE.createCriterion(triggerInstance)),
					saver, saAdvancementId(VILLAGER_MASON_ON_TRADES));
		}
	}
	
	public static @NotNull String saAdvancementId(String id) {
		return AdvancementProviderTool.advancementId(STONE_ADVENTURE_ID, id);
	}
}