package ctn.stonecraft.common.item.slingshot;

import ctn.stonecraft.common.entity.projectile.stone_nugget.AbsStoneNuggetProjectile;
import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;
import ctn.stonecraft.datagen.ScTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static ctn.stonecraft.init.ScItems.STONE_NUGGET;

/**
 * 弹弓类，继承自ProjectileWeaponItem，用于发射石子
 */
public class Slingshot extends ProjectileWeaponItem {
	public static final Predicate<ItemStack> STONE_NUGGET_ONLY = itemStack -> itemStack.is(ScTags.ScItems.STONE_NUGGET);
	
	private final Tier  tier;
	private final int   chargingTime;     // 满蓄力所需时间
	private final float damageMultiplier; // 伤害系数
	private final float damageBonus;      // 伤害加成
	private final float speedBonus;  // 速度系数
	
	/**
	 * 构造函数，创建一个新的弹弓物品
	 *
	 * @param properties       物品属性
	 * @param slingshotBuilder 弹弓特定属性（如蓄力时间和伤害倍数）
	 */
	public Slingshot(Tier tier, Properties properties, SlingshotBuilder slingshotBuilder) {
		super(properties.durability(tier.getUses()));
		this.tier             = tier;
		this.chargingTime     = slingshotBuilder.chargingTime;
		this.damageMultiplier = slingshotBuilder.damageMultiplier;
		this.damageBonus      = slingshotBuilder.damageBonus;
		this.speedBonus       = slingshotBuilder.speedBonus;
	}
	
	/**
	 * @deprecated
	 */
	@Override
	@Deprecated
	public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
		return STONE_NUGGET_ONLY;
	}
	
	/**
	 * 获取支持的弹药物品谓词
	 *
	 * @param stack 弹弓物品堆
	 * @return 只接受STONE_NUGGET的谓词
	 */
	public @NotNull Predicate<ItemStack> getAllSupportedProjectiles(@NotNull ItemStack stack) {
		return STONE_NUGGET_ONLY;
	}
	
	/**
	 * 获取弹弓的默认射程
	 *
	 * @return 默认射程为7格
	 */
	@Override
	public int getDefaultProjectileRange() {
		return 7;
	}
	
	/**
	 * 发射弹射物的具体实现
	 *
	 * @param shooter    发射者
	 * @param projectile 要发射的弹射物
	 * @param index      弹射物索引
	 * @param velocity   发射速度
	 * @param inaccuracy 不准确度
	 * @param angle      发射角度
	 * @param target     目标实体（可为空）
	 */
	@Override
	protected void shootProjectile(@NotNull LivingEntity shooter, @NotNull Projectile projectile,
			int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
		// 如果发射者有力量效果，则增加发射速度
		if (shooter.hasEffect(MobEffects.DAMAGE_BOOST)) {
			MobEffectInstance effect = shooter.getEffect(MobEffects.DAMAGE_BOOST);
			if (effect != null) {
				velocity += (effect.getAmplifier() + 1) * 0.01F;
			}
		}
		velocity *= 1.5f;
		velocity += velocity * speedBonus;
		projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
	}
	
	/**
	 * 创建弹射物
	 *
	 * @param level   当前世界
	 * @param shooter 发射者
	 * @param weapon  弹弓物品
	 * @param ammo    弹药物品
	 * @param isCrit  是否是暴击
	 * @return 弹射物
	 */
	@Override
	protected @NotNull AbsStoneNuggetProjectile createProjectile(@NotNull Level level, @NotNull LivingEntity shooter,
			@NotNull ItemStack weapon, ItemStack ammo, boolean isCrit) {
		AbsStoneNuggetItem item = ammo.getItem() instanceof AbsStoneNuggetItem item1 ? item1 : STONE_NUGGET.get();
		AbsStoneNuggetProjectile projectile = item.getProjectile(level, shooter, weapon);
		projectile.setDamageBonus(getDamageBonus());
		projectile.setDamageMultiplier(getDamageMultiplier());
		return projectile;
	}
	
	/**
	 * @deprecated
	 */
	@Override
	@Deprecated
	public AbstractArrow customArrow(@NotNull AbstractArrow arrow, @NotNull ItemStack projectileStack, @NotNull ItemStack weaponStack) {
		return null;
	}
	
	/**
	 * 获取创造模式下的默认弹药
	 *
	 * @param player               玩家（可能为空）
	 * @param projectileWeaponItem 弹射武器物品
	 * @return 默认的石子物品
	 */
	@Override
	public @NotNull ItemStack getDefaultCreativeAmmo(@Nullable Player player, @NotNull ItemStack projectileWeaponItem) {
		if (player == null) {
			return STONE_NUGGET.get().getDefaultInstance();
		}
		Inventory inventory = player.getInventory();
		
		// 先检查副手，再检查主手物品栏
		return Stream.concat(inventory.offhand.stream(), inventory.items.stream())
				.filter(stack -> stack.is(ScTags.ScItems.STONE_NUGGET))
				.findFirst()
				.orElse(STONE_NUGGET.get().getDefaultInstance());
	}
	
	
	public float getDamageMultiplier() {
		return damageMultiplier;
	}
	
	/**
	 * 获取弹弓的伤害倍数
	 *
	 * @return 伤害倍数
	 */
	public float getDamageBonus() {
		return damageBonus;
	}
	
	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		boolean flag = !player.getProjectile(itemstack).isEmpty();
		
		if (!player.hasInfiniteMaterials() && !flag) {
			return InteractionResultHolder.fail(itemstack);
		}
		player.startUsingItem(hand);
		return InteractionResultHolder.consume(itemstack);
		
	}
	
	@Override
	public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
		return UseAnim.BOW;
	}
	
	@Override
	public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
		return 72000;
	}
	
	@Override
	public void releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entityLiving, int timeLeft) {
		if (!(entityLiving instanceof Player player)) {
			return;
		}
		ItemStack itemstack = player.getProjectile(stack);
		if (itemstack.isEmpty()) {
			return;
		}
		int i = this.getUseDuration(stack, entityLiving) - timeLeft;
		if (i < 0) return;
		float f = getPowerForTime(i);
		if ((double) f < 0.1) {
			return;
		}
		List<ItemStack> list = draw(stack, itemstack, player);
		if (level instanceof ServerLevel serverlevel && !list.isEmpty()) {
			boolean isCrit = f == 1.0F;
			this.shoot(serverlevel, player, player.getUsedItemHand(), stack, list,
					f, 1.0F, isCrit, null);
		}
		
		level.playSound(
				null,
				player.getX(),
				player.getY(),
				player.getZ(),
				SoundEvents.ARROW_SHOOT,
				SoundSource.PLAYERS,
				1.0F,
				1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F
		);
		player.awardStat(Stats.ITEM_USED.get(this));
	}
	
	public Tier getTier() {
		return this.tier;
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.tier.getEnchantmentValue();
	}
	
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return this.tier.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
	}
	
	public float getPowerForTime(int charge) {
		if (charge <= 0) {
			return 0.0f;
		}
		
		float power = ((float) charge / chargingTime);
		if (power > 1.0f) {
			power = 1.0f;
		}
		return power;
	}
	
	/**
	 * 获取弹弓的蓄力时间
	 *
	 * @return 蓄力时间
	 */
	public int getChargingTime() {
		return chargingTime;
	}
}
