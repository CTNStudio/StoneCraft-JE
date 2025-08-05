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
	public static final String TEN_STONES_EATEN   = advancementId("ten_stones_eaten");
	
	public static final Item[] STONE_FOOD = {
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
				saver, advancementId("root"));
		AdvancementHolder getCobblestone = createObtainAdv(
				root, saver, advancementId("get_cobblestone"),
				Items.COBBLESTONE, AdvancementType.TASK,
				false);
		AdvancementHolder getBlackstone = createObtainAdv(
				getCobblestone, saver, advancementId("get_blackstone"),
				Items.BLACKSTONE, AdvancementType.TASK,
				false);
		AdvancementHolder getAndesite = createObtainAdv(
				root, saver, advancementId("get_andesite"),
				Items.ANDESITE, AdvancementType.TASK,
				false);
		AdvancementHolder getDiorite = createObtainAdv(
				root, saver, advancementId("get_diorite"),
				Items.DIORITE, AdvancementType.TASK,
				false);
		AdvancementHolder getTuff = createObtainAdv(
				root, saver, advancementId("get_tuff"),
				Items.TUFF, AdvancementType.TASK,
				false);
		AdvancementHolder getCalcite = createObtainAdv(
				root, saver, advancementId("get_calcite"),
				Items.CALCITE, AdvancementType.TASK,
				false);
		AdvancementHolder getCobbledDeepslate = createObtainAdv(
				root, saver, advancementId("get_cobbled_deepslate"),
				Items.COBBLED_DEEPSLATE, AdvancementType.TASK,
				false);
		AdvancementHolder getObsidian = createObtainAdv(
				getCobbledDeepslate, saver, advancementId("get_obsidian"),
				Items.OBSIDIAN, AdvancementType.TASK,
				false);
		AdvancementHolder getBedrock = createObtainAdv(
				getObsidian, saver, advancementId("get_bedrock"),
				Items.BEDROCK, AdvancementType.TASK,
				false);
		AdvancementHolder getEndStone = createObtainAdv(
				root, saver, advancementId("get_end_stone"),
				Items.END_STONE, AdvancementType.TASK,
				false);
		AdvancementHolder getNetherrack = createObtainAdv(
				root, saver, advancementId("get_netherrack"),
				Items.NETHERRACK, AdvancementType.TASK,
				false);
		AdvancementHolder getMossyCobblestone = createObtainAdv(
				root, saver, advancementId("get_mossy_cobblestone"),
				Items.MOSSY_COBBLESTONE, AdvancementType.TASK,
				false);
		AdvancementHolder getGranite = createObtainAdv(
				root, saver, advancementId("get_granite"),
				Items.GRANITE, AdvancementType.TASK,
				false);
		AdvancementHolder getFlint = createObtainAdv(
				root, saver, advancementId("get_flint"),
				Items.FLINT, AdvancementType.TASK,
				false);
		AdvancementHolder ourTrio = save(
				Advancement.Builder.advancement().parent(root).display(
								Items.COBBLESTONE,
								titleText(advancementId("our_trio")),
								descriptionText(advancementId("our_trio")),
								null,
								AdvancementType.TASK,
								true,
								true,
								false)
						.addCriterion("get_granite", obtainItem(matchItems(Items.GRANITE)))
						.addCriterion("get_andesite", obtainItem(matchItems(Items.ANDESITE)))
						.addCriterion("get_diorite", obtainItem(matchItems(Items.DIORITE))),
				saver, advancementId("our_trio"));
		
		/// 食石
		AdvancementHolder edibleStoneFood = save(
				Advancement.Builder.advancement().parent(root).display(
						ScItems.STONE_APPLE,
						titleText(advancementId("stone_eater")),
						descriptionText(advancementId("stone_eater")),
						null,
						AdvancementType.TASK,
						true,
						true,
						false
				).addCriterion("eater_stone_food", ConsumeItemTrigger.TriggerInstance.usedItem(matchItems(STONE_FOOD))),
				saver, advancementId("stone_eater"));
		
		Advancement.Builder edibleTenStoneFoodBuilder = Advancement.Builder.advancement().parent(edibleStoneFood).display(
				ScItems.STONE_HODGEPODGE,
				titleText(advancementId("ten_stones_eaten")),
				descriptionText(advancementId("ten_stones_eaten")),
				null,
				AdvancementType.TASK,
				true,
				true,
				false);
		
		ResourceLocation tenStonesEaten = path("ten_stones_eaten");
		for (int i = 0; i < 10; i++) {
			edibleTenStoneFoodBuilder.addCriterion(String.valueOf(i),
					CountCriterionTrigger.TriggerInstance.createCriterion(
							tenStonesEaten,
							matchItems(STONE_FOOD)));
		}
		
		AdvancementHolder edibleTenStoneFood = save(edibleTenStoneFoodBuilder, saver, advancementId("ten_stones_eaten"));
		
		Advancement.Builder edibleAllStoneFoodBuilder = Advancement.Builder.advancement().parent(edibleTenStoneFood).display(
				ScItems.STONICKERS,
				titleText(advancementId("epic_stone_feast")),
				descriptionText(advancementId("epic_stone_feast")),
				null,
				AdvancementType.CHALLENGE,
				true,
				true,
				false);
		
		for (Item item : STONE_FOOD) {
			edibleAllStoneFoodBuilder.addCriterion(item.getDescriptionId(),
					ConsumeItemTrigger.TriggerInstance.usedItem(matchItems(item)));
		}
		
		AdvancementHolder edibleAllStoneFood = save(edibleAllStoneFoodBuilder, saver, advancementId("epic_stone_feast"));
		
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
							titleText(advancementId("villager_mason_on_trades")),
							descriptionText(advancementId("villager_mason_on_trades")),
							null,
							AdvancementType.TASK,
							true,
							true,
							false
					).addCriterion("mason", CriteriaTriggers.TRADE.createCriterion(triggerInstance)),
					saver, advancementId("villager_mason_on_trades"));
		}
	}
	
	public static @NotNull String advancementId(String id) {
		return AdvancementProviderTool.advancementId(STONE_ADVENTURE_ID, id);
	}
}