package ctn.stonecraft.common.trigger;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ctn.stonecraft.StoneCraft.SC_ID;
import static ctn.stonecraft.api.tool.NbtTool.getOrCreateCompoundTag;
import static ctn.stonecraft.api.tool.ResourceLocationTool.getResourceLocation;
import static ctn.stonecraft.init.ScTriggerTypes.COUNT_CRITERION_TRIGGER;

/**
 * 计数触发器
 * 用于跟踪玩家获取特定类型物品的进度
 * <p>
 * 该类通过NBT数据持久化存储玩家已获得的物品，防止重复触发同一进度条件
 */
public class CountCriterionTrigger extends SimpleCriterionTrigger<CountCriterionTrigger.TriggerInstance> {
	private static final Logger LOG            = LogUtils.getLogger();
	public static final  String ADVANCEMENT    = "advancement";
	public static final  String ITEM_DATA_LIST = "itemDataList";
	public static final  String ITEM_ID        = "itemId";
	
	/**
	 * 获取触发器实例的编解码器
	 *
	 * @return TriggerInstance的编解码器
	 */
	@Override
	public @NotNull Codec<TriggerInstance> codec() {
		return TriggerInstance.CODEC;
	}
	
	/**
	 * 触发计数条件检查
	 * 当玩家获得一个物品时调用此方法，检查是否满足进度条件
	 *
	 * @param player 触发条件的玩家
	 * @param stack  触发条件的物品堆
	 */
	public void trigger(ServerPlayer player, ItemStack stack) {
		if (player == null) {
			return;
		}
		if (stack == null || stack.isEmpty()) {
			return;
		}
		ServerLevel serverLevel = player.serverLevel();
		RegistryAccess registryAccess = serverLevel.registryAccess();
		Registry<Item> itemRegistry = registryAccess.registry(Registries.ITEM).orElse(null);
		if (itemRegistry == null) {
			return;
		}
		
		// 获取或创建必要的NBT结构
		CompoundTag scNbt = getOrCreateCompoundTag(player.getPersistentData(), SC_ID);
		CompoundTag advancementNbt = getOrCreateCompoundTag(scNbt, ADVANCEMENT);
		
		// 触发条件检查
		trigger(player, triggerInstance -> {
			CompoundTag advancementIdNbt = getOrCreateCompoundTag(advancementNbt, triggerInstance.advancementId().toString());
			
			if (!advancementIdNbt.contains(ITEM_DATA_LIST)) advancementIdNbt.put(ITEM_DATA_LIST, new ListTag());
			ListTag listNbt = advancementIdNbt.getList(ITEM_DATA_LIST, 10);
			
			// 解析物品列表
			List<Item> excludesList = new ArrayList<>();
			
			// 遍历列表中的每个NBT元素
			for (int i = 0; i < listNbt.size(); i++) {
				CompoundTag compoundtag = listNbt.getCompound(i);
				String itemId = compoundtag.getString(ITEM_ID);
				String[] id = itemId.split(":");
				if (id.length < 2) {
					continue;
				}
				try {
					Item item = itemRegistry.get(getResourceLocation(id));
					if (item == null || item == Items.AIR) {
						LOG.warn("Invalid itemId: {}", itemId);
						continue;
					}
					excludesList.add(item);
				} catch (Exception e) {
					LOG.warn("Invalid itemId: {}", itemId, e);
				}
			}
			
			boolean result = triggerInstance.matches(excludesList, stack);
			
			// 保存更新后的物品列表
			ListTag listNbt2 = new ListTag();
			
			for (Item item : excludesList) {
				if (item == null) {
					continue;
				}
				CompoundTag compoundtag = new CompoundTag();
				ResourceLocation key = itemRegistry.getKey(item);
				if (key == null) {
					continue;
				}
				compoundtag.putString(ITEM_ID, key.toString());
				listNbt2.add(compoundtag);
			}
			advancementIdNbt.put(ITEM_DATA_LIST, listNbt2);
			
			return result;
		});
	}
	
	/**
	 * 计数触发器实例
	 * 定义具体的触发条件和匹配逻辑
	 */
	public record TriggerInstance(ResourceLocation advancementId, Optional<ContextAwarePredicate> player,
	                              Optional<ItemPredicate> item) implements SimpleInstance {
		public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								ResourceLocation.CODEC.fieldOf("advancementId").forGetter(TriggerInstance::advancementId),
								EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player),
								ItemPredicate.CODEC.optionalFieldOf("item").forGetter(TriggerInstance::item))
						.apply(instance, TriggerInstance::new)
		);
		
		/**
		 * 创建进度条件
		 *
		 * @param item 物品标签谓词
		 * @return 进度条件
		 */
		public static Criterion<TriggerInstance> createCriterion(ResourceLocation advancementId, ItemPredicate.Builder item) {
			return COUNT_CRITERION_TRIGGER.get().createCriterion(new TriggerInstance(advancementId, Optional.empty(), Optional.of(item.build())));
		}
		
		@Override
		public @NotNull Optional<ContextAwarePredicate> player() {
			return player;
		}
		
		public boolean matches(List<Item> excludesList, ItemStack stack) {
			if (item.isEmpty()) {
				return false;
			}
			// 遍历排除列表
			Item triggerItem = stack.getItem();
			boolean isExcludes = excludesList.contains(triggerItem);
			
			if (!isExcludes && item.get().test(stack)) {
				excludesList.add(triggerItem);
				return true;
			}
			return false;
		}
	}
}
