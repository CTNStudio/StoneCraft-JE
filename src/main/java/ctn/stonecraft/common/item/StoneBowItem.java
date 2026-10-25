package ctn.stonecraft.common.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;

import java.util.List;

public class StoneBowItem extends BowItem {

    public static final int MAX_DRAW_DURATION = 30; // 自定义：1.5 秒拉满

    public StoneBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            ItemStack ammo = player.getProjectile(stack);
            if (!ammo.isEmpty()) {
                int used = this.getUseDuration(stack, entityLiving) - timeLeft;

                // 允许其他模组干预
                used = EventHooks.onArrowLoose(stack, level, player, used, !ammo.isEmpty());
                if (used < 0) {
                    return;
                }

                // 限制最大拉弓时间为你设定的 30 tick
                used = Math.min(used, MAX_DRAW_DURATION);
                float power = getPowerForTime(used);

                if (!((double) power < 0.1)) {
                    // draw 方法自动处理：附魔（力量/火矢/无限）、创造模式不消耗弹药、以及无限附魔时的拾取限制
                    List<ItemStack> drawnAmmo = draw(stack, ammo, player);

                    if (level instanceof ServerLevel serverLevel) {
                        if (!drawnAmmo.isEmpty()) {
                            // shoot 方法自动处理：箭矢实体生成、附魔伤害加成、火矢点燃等
                            this.shoot(serverLevel, player, player.getUsedItemHand(), stack, drawnAmmo, power * 3.0F, 1.0F, power == 1.0F, null);
                        }
                    }

                    // 播放音效
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS,
                            1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + power * 0.5F);

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    /**
     * 拉弓威力：30 刻（1.5 秒）拉满
     */
    public static float getPowerForTime(int charge) {
        float f = (float) charge / MAX_DRAW_DURATION;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        return f;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.is(Items.BLACKSTONE)
                || repair.is(Items.COBBLED_DEEPSLATE)
                || repair.is(Items.COBBLESTONE);
    }
}