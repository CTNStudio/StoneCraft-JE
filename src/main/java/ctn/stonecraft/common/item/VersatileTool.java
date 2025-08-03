package ctn.stonecraft.common.item;

import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static ctn.stonecraft.datagen.tag.ScTags.ScBlocks.MINEABLE_WITH_VERSATILE;
import static net.minecraft.world.item.HoeItem.changeIntoState;
import static net.neoforged.neoforge.common.ItemAbilities.*;

/// 多功能工具
public class VersatileTool extends DiggerItem {
	public VersatileTool(Tier tier, Properties properties) {
		super(tier, MINEABLE_WITH_VERSATILE, properties);
	}
	
	@Override
	public @NotNull DataComponentMap components() {
		return super.components();
	}
	
	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		Level level = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		Player player = context.getPlayer();
		
		// 对方块使用
		block:
		{
			// 斧头功能
			axe:
			{
				// 如果玩家正在使用盾牌则不执行
				if (playerHasShieldUseIntent(context)) {
					break block;
				}
				
				Optional<BlockState> optional = this.evaluateNewBlockState(level, blockpos, player, level.getBlockState(blockpos), context);
				if (optional.isEmpty()) {
					break axe;
				}
				ItemStack itemstack = context.getItemInHand();
				if (player instanceof ServerPlayer) {
					CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, blockpos, itemstack);
				}
				
				level.setBlock(blockpos, optional.get(), 11);
				level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional.get()));
				if (player != null) {
					itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
				}
				
				return InteractionResult.sidedSuccess(level.isClientSide);
			}
			
			// 锄头功能
			hoe:
			{
				BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(context, net.neoforged.neoforge.common.ItemAbilities.HOE_TILL, false);
				if (toolModifiedState == null) {
					break hoe;
				}
				
				Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = Pair.of(ctx -> true, changeIntoState(toolModifiedState));
				Predicate<UseOnContext> predicate = pair.getFirst();
				Consumer<UseOnContext> consumer = pair.getSecond();
				
				if (!predicate.test(context)) {
					break hoe;
				}
				
				Player player2 = context.getPlayer();
				level.playSound(player2, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				
				if (!level.isClientSide) {
					consumer.accept(context);
					if (player2 != null) {
						context.getItemInHand().hurtAndBreak(1, player2, LivingEntity.getSlotForHand(context.getHand()));
					}
				}
				
				return InteractionResult.sidedSuccess(level.isClientSide);
			}
		}
		
		return InteractionResult.PASS;
	}
	
	/**
	 * 来自原版
	 * <p>
	 * 判断玩家是否有使用盾牌的意图
	 * 此方法用于确定玩家是否在主手中使用物品，而副手持有盾牌，并且没有激活次要使用动作
	 * 主要用于游戏逻辑中判断玩家行为
	 *
	 * @param context 使用上下文，包含玩家和手部信息
	 * @return 如果玩家有使用盾牌的意图，则返回true；否则返回false
	 */
	private static boolean playerHasShieldUseIntent(UseOnContext context) {
		Player player = context.getPlayer();
		return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
	}
	
	/**
	 * 来自原版
	 * <p>
	 * 评估并返回新的方块状态
	 * 该方法尝试使用斧头对方块进行剥皮、刮擦和去除蜡层的操作，并返回相应的方块状态
	 * 如果操作成功，还会播放相应的音效和视觉效果
	 *
	 * @param level   当前的等级对象，用于播放音效和触发等级事件
	 * @param pos     方块的位置，用于确定音效播放的位置
	 * @param player  执行操作的玩家，可以为null
	 * @param state   当前方块的状态
	 * @param context 使用方块的上下文
	 * @return 返回新的方块状态，如果操作失败，则返回Optional.empty()
	 */
	private Optional<BlockState> evaluateNewBlockState(Level level, BlockPos pos, @Nullable Player player, BlockState state, UseOnContext context) {
		// 尝试使用斧头剥皮方块
		Optional<BlockState> optional = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_STRIP, false));
		if (optional.isPresent()) {
			level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
			return optional;
		}
		// 尝试使用斧头刮擦方块
		Optional<BlockState> optional1 = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_SCRAPE, false));
		if (optional1.isPresent()) {
			level.playSound(player, pos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, 3005, pos, 0);
			return optional1;
		}
		// 尝试使用斧头去除方块上的蜡层
		Optional<BlockState> optional2 = Optional.ofNullable(state.getToolModifiedState(context, ItemAbilities.AXE_WAX_OFF, false));
		if (optional2.isPresent()) {
			level.playSound(player, pos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
			level.levelEvent(player, 3004, pos, 0);
			return optional2;
		}
		// 如果以上操作都失败，则返回空
		return Optional.empty();
	}
	
	@Override
	public boolean canPerformAction(@NotNull ItemStack stack, net.neoforged.neoforge.common.@NotNull ItemAbility itemAbility) {
		return Stream.of(DEFAULT_AXE_ACTIONS, DEFAULT_PICKAXE_ACTIONS, DEFAULT_SHOVEL_ACTIONS, DEFAULT_HOE_ACTIONS).anyMatch(itemAbilities -> itemAbilities.contains(itemAbility));
	}
}