package ctn.stonecraft.common.entity.projectile.stone_nugget;

import ctn.stonecraft.common.item.slingshot.Slingshot;
import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;
import ctn.stonecraft.datagen.ScTags;
import ctn.stonecraft.events.stonenugget.StoneNuggetOnHitBlockEvent;
import ctn.stonecraft.events.stonenugget.StoneNuggetOnHitEntityEvent;
import ctn.stonecraft.events.stonenugget.StoneNuggetSkipEvent;
import ctn.stonecraft.init.ScItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

import static ctn.stonecraft.core.StoneCraftEventHooks.*;
import static ctn.stonecraft.api.util.WorldUtil.*;

/**
 * 抽象石粒投射物类，实现石粒的基本行为和物理特性
 */
public abstract class AbsStoneNuggetProjectile extends ThrowableItemProjectile {
	public static final String SHOW_SKIP_RESULT_OWNER_TEXT  = "stonecraft:stone_nugget.show_skip_result.owner";
	public static final String SHOW_SKIP_RESULT_OTHERS_TEXT = "stonecraft:stone_nugget.show_skip_result.others";

	protected static final int RESULT_DISPLAY_DELAY = 20 * 2; // 成绩显示延迟(ticks)

	// region 物理模拟相关参数
	private double verticalVelocityLowAngleFactor;  // 垂直速度-低角度因子
	private double verticalVelocityHighAngleFactor; // 垂直速度-高角度因子
	private double lowAngleThreshold;               // 低角度阈值
	private double highAngleThreshold;              // 高角度阈值

	// 弹射相关参数
	private float maxBounceAngle; // 最大弹射角度
	private float minBounceAngle; // 最小弹射角度
	private float minBounceSpeed; // 最小弹射速度
	// endregion

	// region 状态变量
	private float   basicDamage        = 0;     // 基础伤害
	private double  basicGravity       = 0;     // 基础重力
	private float   basicWeight        = 0;     // 基础重量
	private int     skipCount          = 0;     // 水漂次数计数器
	private int     time               = 0;     // 存活时间计数器
	private boolean hasAnnouncedResult = false; // 成绩公告状态标记
	private float   damageBonus        = 0;     // 伤害加成
	private float   damageMultiplier   = 1;     // 伤害加成倍数
	private int     impactsCount       = 1;     // 剩余撞击次数
	private int     bouncesCount       = 0;     // 剩余弹射次数
	// endregion

	// region 其他变量
	@Nullable
	private UUID               hitEntityUUID;
	@Nullable
	private Entity             cachedHitEntity;
	@Nullable
	private ItemStack          weapon;
	private AbsStoneNuggetItem projectileItem;
  protected boolean SkipAllowed = true; //是否允许打水漂
	// endregion

	// region 构造方法
	public AbsStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder,
			EntityType<? extends AbsStoneNuggetProjectile> entityType, Position pos, Level level, @Nullable ItemStack weapon) {
		this(stoneNuggetProjectileBuilder, entityType, pos.x(), pos.y(), pos.z(), level, weapon);
	}

	public AbsStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder,
			EntityType<? extends AbsStoneNuggetProjectile> entityType, double x, double y, double z, Level level, @Nullable ItemStack weapon) {
		super(entityType, x, y, z, level);
		this.weapon = weapon;
		init(stoneNuggetProjectileBuilder, weapon);
	}

	public AbsStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder,
			EntityType<? extends AbsStoneNuggetProjectile> entityType, Level level, @Nullable ItemStack weapon) {
		super(entityType, level);
		this.weapon = weapon;
		init(stoneNuggetProjectileBuilder, weapon);
	}

	public AbsStoneNuggetProjectile(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder,
			EntityType<? extends AbsStoneNuggetProjectile> entityType, LivingEntity shooter, Level level, @Nullable ItemStack weapon) {
		super(entityType, shooter, level);
		this.weapon = weapon;
		init(stoneNuggetProjectileBuilder, weapon);
	}
	// endregion

	// region 初始化和数据保存
	public static int getResultDisplayDelay() {
		return RESULT_DISPLAY_DELAY;
	}

	/**
	 * 初始化配置属性
	 */
	private void init(StoneNuggetProjectileBuilder stoneNuggetProjectileBuilder, @Nullable ItemStack weapon) {
		if (stoneNuggetProjectileBuilder != null) {
			verticalVelocityLowAngleFactor  = stoneNuggetProjectileBuilder.verticalVelocityLowAngleFactor;
			verticalVelocityHighAngleFactor = stoneNuggetProjectileBuilder.verticalVelocityHighAngleFactor;
			lowAngleThreshold               = stoneNuggetProjectileBuilder.lowAngleThreshold;
			highAngleThreshold              = stoneNuggetProjectileBuilder.highAngleThreshold;
			maxBounceAngle                  = stoneNuggetProjectileBuilder.maxBounceAngle;
			minBounceAngle                  = stoneNuggetProjectileBuilder.minBounceAngle;
			minBounceSpeed                  = stoneNuggetProjectileBuilder.minBounceSpeed;
			projectileItem                  = (stoneNuggetProjectileBuilder.projectileItem == null) ? null : stoneNuggetProjectileBuilder.projectileItem.get();
			basicDamage                     = stoneNuggetProjectileBuilder.baseNuggetProps.damage;
			basicGravity                    = stoneNuggetProjectileBuilder.baseNuggetProps.gravity;
			basicWeight                     = stoneNuggetProjectileBuilder.baseNuggetProps.weight;
		}
		if (weapon != null && (weapon.getItem() instanceof Slingshot slingshot)) {
			damageBonus      = slingshot.getDamageBonus();
			damageMultiplier = slingshot.getDamageMultiplier();
		}
	}

	/**
	 * 写入NBT数据
	 */
	@Override
	public void addAdditionalSaveData(@NotNull CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putDouble("verticalVelocityLowAngleFactor", getVerticalVelocityLowAngleFactor());
		compound.putDouble("verticalVelocityHighAngleFactor", getVerticalVelocityHighAngleFactor());
		compound.putDouble("lowAngleThreshold", getLowAngleThreshold());
		compound.putDouble("highAngleThreshold", getHighAngleThreshold());
		compound.putFloat("maxBounceAngle", getMaxBounceAngle());
		compound.putFloat("minBounceAngle", getMinBounceAngle());
		compound.putFloat("minBounceSpeed", getMinBounceSpeed());
		compound.putInt("skipCount", getSkipCount());
		compound.putInt("time", getTime());
		compound.putBoolean("hasAnnouncedResult", isHasAnnouncedResult());
		compound.putFloat("damageBonus", getDamageBonus());
		compound.putInt("impactsRemaining", getImpactsCount());
		compound.putInt("bouncesCount", getBouncesCount());
		if (hitEntityUUID != null) {
			compound.putUUID("hitEntityUUID", this.hitEntityUUID);
		}
		Level level = level();
		RegistryAccess levelRegistryAccess = level.registryAccess();
		if (getWeapon() != null) {
			compound.put("weapon", getWeapon().save(levelRegistryAccess));
		}
		compound.putString("item", getItem().getDescriptionId());
	}

	/**
	 * 读取NBT数据
	 */
	@Override
	public void readAdditionalSaveData(@NotNull CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		Level level = level();
		damageMultiplier                = 1.0f;
		verticalVelocityLowAngleFactor  = compound.getDouble("verticalVelocityLowAngleFactor");
		verticalVelocityHighAngleFactor = compound.getDouble("verticalVelocityHighAngleFactor");
		lowAngleThreshold               = compound.getDouble("lowAngleThreshold");
		highAngleThreshold              = compound.getDouble("highAngleThreshold");
		maxBounceAngle                  = compound.getFloat("maxBounceAngle");
		minBounceAngle                  = compound.getFloat("minBounceAngle");
		minBounceSpeed                  = compound.getFloat("minBounceSpeed");
		skipCount                       = compound.getInt("skipCount");
		time                            = compound.getInt("time");
		hasAnnouncedResult              = compound.getBoolean("hasAnnouncedResult");
		damageBonus                     = compound.getFloat("damageBonus");
		impactsCount                    = compound.getInt("impactsRemaining");
		bouncesCount                    = compound.getInt("bouncesCount");
		if (compound.contains("hitEntityUUID")) {
			hitEntityUUID   = compound.getUUID("hitEntityUUID");
			cachedHitEntity = getCachedHitEntity();
		}
		RegistryAccess levelRegistryAccess = level.registryAccess();
		if (compound.contains("weapon", 10)) {
			weapon = ItemStack.parse(levelRegistryAccess, compound.getCompound("weapon")).orElse(null);
			if (getWeapon() != null && (getWeapon().getItem() instanceof Slingshot slingshot)) {
				damageMultiplier = slingshot.getDamageMultiplier();
			}
		} else {
			weapon = null;
		}
		if (compound.contains("item")) {
			ResourceLocation location = ResourceLocation.parse(compound.getString("item"));
			Item item = levelRegistryAccess.registryOrThrow(Registries.ITEM).get(location);
			if (item instanceof AbsStoneNuggetItem) {
				this.projectileItem = (AbsStoneNuggetItem) item;
			} else {
				this.projectileItem = ScItems.STONE_NUGGET.get();
			}
		} else {
			projectileItem = ScItems.STONE_NUGGET.get();
		}
		basicDamage  = getProjectileItem().Damage();
		basicGravity = getProjectileItem().Gravity();
		basicWeight  = getProjectileItem().Weight();
	}
	// endregion

	// region 主要游戏逻辑

	/**
	 * 每tick更新逻辑
	 */
	@Override
	public void tick() {
		super.tick();
		time = getTime() + 1;
		Level level = this.level();

		// 进行打水漂逻辑
    if(SkipAllowed){
      handleSkipLogic(level);
    }

		checkEntityCollisions();

		if (getOwner() != null && getOwner() instanceof Player && getSkipCount() > 0 && !level.isClientSide && getTime() >= getResultDisplayDelay() && !isHasAnnouncedResult()) {
			checkAndDisplaySkipResult();
		}
	}

	/**
	 * 检查实体碰撞
	 * 检测投射物与实体的碰撞，并处理碰撞结果
	 */
	protected void checkEntityCollisions() {
		if (cachedHitEntity == null) {
			return;
		}
		Vec3 vec3 = this.getDeltaMovement();
		Vec3 vec32 = this.position();
		Vec3 vec33 = vec32.add(vec3);
		HitResult hitresult = this.level().clip(new ClipContext(vec32, vec33, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
		if (hitresult.getType() != HitResult.Type.MISS) {
			vec33 = hitresult.getLocation();
		}
		EntityHitResult entityhitresult = this.findHitEntity(vec32, vec33);
		if (entityhitresult != null && !hitEntityBy(entityhitresult.getEntity())) {
			clearHitEntity();
		}
	}

	/**
	 * 处理实体事件
	 */
	@Override
	public void handleEntityEvent(byte id) {
		if (id != 3) {
			return;
		}
		ParticleOptions particleOptions = this.getParticle();

		Level level = this.level();
		// 生成碰撞粒子效果
		for (int i = 0; i < 8; i++) {
			level.addParticle(particleOptions, this.getX(),
					this.getY(),
					this.getZ(),
					((double) this.random.nextFloat() - 0.5) * 0.08,
					((double) this.random.nextFloat() - 0.5) * 0.08,
					((double) this.random.nextFloat() - 0.5) * 0.08);
		}
	}
	// endregion

	// region 水漂逻辑

	/**
	 * 检查并显示水漂成绩
	 */
	protected void checkAndDisplaySkipResult() {
		hasAnnouncedResult = true;
		showSkipResult();
	}

	/**
	 * 执行水漂逻辑
	 */
	protected void handleSkipLogic(final Level level) {
		Vec3 movement = getDeltaMovement();
		float pitchFromVelocity = getPitchFromVelocity(movement);
		float absPitch = Math.abs(pitchFromVelocity);
		double speed = movement.length();
		Vec3 pos = position();
		AABB boundingBox = this.getBoundingBox();
		double bottomY = boundingBox.minY;
		Vec3 bottomPos = new Vec3(pos.x, bottomY, pos.z);
		FluidState fluidState = getFluidState(level, bottomPos);

		// 检查是否满足弹射条件
		if (!canSkipBounce(level, absPitch, speed, fluidState, bottomPos, boundingBox, pos)) {
			return;
		}

		// 水漂成功，执行弹射逻辑
		performSkipBounce(level, movement, fluidState, bottomPos, absPitch, pos);
	}

	/**
	 * 判断是否可以水漂弹射
	 */
	protected boolean canSkipBounce(final Level level, float absPitch, double speed, FluidState fluidState, Vec3 bottomPos, AABB boundingBox, Vec3 pos) {
		// 检查角度和速度是否满足弹射条件
		if (absPitch < getMinBounceAngle() ||
		    absPitch > getMaxBounceAngle() ||
		    speed < getMinBounceSpeed()) {
			return false;
		}

		// 检查当前格子是否找到液体
		if (fluidState.isEmpty()) {
			return false;
		}

		// 检查是否接触液体表面
		if (!isInFluid(level, fluidState, bottomPos)) {
			return false;
		}

		// 检查是否浸入过深
		double y = boundingBox.maxY * Math.max(1, 0.001 * speed);
		Vec3 topPos = new Vec3(pos.x, y, pos.z);
		return !isInFluid(level, fluidState, topPos);
	}

	/**
	 * 执行水漂弹射
	 */
	protected void performSkipBounce(final Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos) {
		Vec3 deltaMovement = calculateBounceMovement(movement, absPitch);
		float floatHeight = getFloatHeight(level, fluidState, bottomPos);
		StoneNuggetSkipEvent.Pre event = stoneNuggetSkipPre(this, level, movement, fluidState, bottomPos, absPitch, pos, deltaMovement, floatHeight);
		if (event.isCanceled()) {
			return;
		}
		deltaMovement = event.getNewDeltaMovement();
		floatHeight   = event.getNewFloatHeight();

		// 弹射前
		onBeforeBounce(level, movement, fluidState, bottomPos, absPitch, pos);

		// 设置位置并进行弹射
		setPos(pos.x, floatHeight, pos.z);
		setDeltaMovement(deltaMovement);

		// 更新水漂计数和重置状态
		skipCount          = getSkipCount() + 1;
		hasAnnouncedResult = false;
		time               = 0;

		stoneNuggetSkipPost(level, movement, fluidState, bottomPos, absPitch, pos, deltaMovement, floatHeight, this);
	}

	/**
	 * 弹射前回调
	 */
	protected void onBeforeBounce(final Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos) {
		if (level instanceof ServerLevel serverLevel) {
			BlockPos blockpos = getOnPos();
			// 生成水花粒子效果
			int particleCount = Math.max(5, (int) movement.lengthSqr());
			for (int i = 0; i < particleCount; i++) {
				double random = level.random.nextDouble();
				double posX = (double) blockpos.getX() + random;
				double posZ = (double) blockpos.getZ() + random;
				int posY = blockpos.getY() + 1;
				serverLevel.sendParticles(ParticleTypes.SPLASH,
						posX, posY, posZ, 1,
						0.0, 0.0, 0.0, 1.0);
			}
		}
	}

	/**
	 * 显示水漂成绩
	 */
	public void showSkipResult() {
		if (level().isClientSide) {
			Minecraft.getInstance().gui.setOverlayMessage(Component.translatable(SHOW_SKIP_RESULT_OWNER_TEXT, getSkipCount()), false);
		}
	}

	/**
	 * 计算弹射后的物理参数
	 */
	protected @NotNull Vec3 calculateBounceMovement(Vec3 movement, float absPitch) {
		double angleFactor = absPitch / getMaxBounceAngle();

		// 计算恢复系数（弹性系数）
		double restitution = 0.8 - (angleFactor * 0.2);
		double newYVelocity = -movement.y * restitution;

		// 计算水平阻尼
		double horizontalDamping = 0.98 - (0.08 * angleFactor);
		double newXVelocity = movement.x * horizontalDamping;
		double newZVelocity = movement.z * horizontalDamping;

		// 根据入射角度调整垂直速度
		if (absPitch < getLowAngleThreshold()) {
			newYVelocity *= getVerticalVelocityLowAngleFactor();
		} else if (absPitch > getHighAngleThreshold()) {
			newYVelocity *= getVerticalVelocityHighAngleFactor();
		}

		return new Vec3(newXVelocity, newYVelocity, newZVelocity);
	}
	// endregion

	// region 碰撞处理

	/**
	 * 碰撞时的处理逻辑
	 */
	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		Level level = level();
		level.playSound(
				null,
				getX(),
				getY(),
				getZ(),
				SoundEvents.STONE_BREAK,
				SoundSource.NEUTRAL,
				0.5F,
				0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F)
		);
	}

	/**
	 * 命中偏移处理
	 */
	@Override
	protected @NotNull ProjectileDeflection hitTargetOrDeflectSelf(@NotNull HitResult hitResult) {
		ProjectileDeflection deflection = ProjectileDeflection.REVERSE;
		boolean is = bouncesCount > 0;
		ProjectileDeflection deflection2 = super.hitTargetOrDeflectSelf(hitResult);
		return is ? deflection : deflection2;
	}

	/**
	 * 获取破裂时产生的粒子效果
	 */
	public ParticleOptions getParticle() {
		ItemStack itemStack = this.getItem();
		ItemStack itemStack2 = getProjectileItem().getDefaultInstance();
		if (!itemStack.isEmpty()) {
			return new ItemParticleOption(ParticleTypes.ITEM, itemStack);
		} else if (!itemStack2.isEmpty()) {
			return new ItemParticleOption(ParticleTypes.ITEM, itemStack2);
		}
		return ParticleTypes.ITEM_SNOWBALL;
	}

	//region 命中方块

	/**
	 * 击中方块时的处理逻辑
	 */
	@Override
	protected void onHitBlock(@NotNull BlockHitResult result) {
		Level level = this.level();
		BlockPos blockpos = result.getBlockPos();

		boolean shouldDiscard = true;
		BlockState blockState = level.getBlockState(blockpos);
		boolean isBreakable = isBreakable(blockState);

		StoneNuggetOnHitBlockEvent.Pre eventPre = stoneNuggetOnHitBlockPre(this, result, level, blockpos, blockState, isBreakable, impactsCount, bouncesCount);
		if (eventPre.isCanceled()) {
			return;
		}
		isBreakable  = eventPre.isNewIsBreakable();
		impactsCount = eventPre.getNewImpactsCount();
		bouncesCount = eventPre.getNewBouncesCount();

		if (!level.isClientSide) {
			if (isBreakable) {
				// 进行破坏
				shouldDiscard = breakableBlock(level, blockpos);
			} else if (bouncesCount > 0) {
				// 进行弹跳
				shouldDiscard = blocksBounce();
			}

			if (shouldDiscard) {
				level.broadcastEntityEvent(this, (byte) 3);
				this.discard();
			} else if (isRemoved()) {
				super.onHitBlock(result);
			}

			if (getOwner() instanceof Player && getSkipCount() > 0 && !isHasAnnouncedResult()) {
				checkAndDisplaySkipResult();
			}
		}

		stoneNuggetOnHitBlockPost(result, level, blockpos, blockState, isBreakable, this, impactsCount, bouncesCount);
	}

	/**
	 * 方块破坏逻辑
	 *
	 * @return 是否删除
	 */
	protected boolean breakableBlock(Level level, BlockPos blockpos) {
		Vec3 movement = getDeltaMovement();
		double speed = movement.lengthSqr();
		if (speed < 0.5) {
			return true;
		}
		level.destroyBlock(blockpos, true, this, 512);

		if (impactsCount > 0) {
			hitSpeedReduction(movement);
			impactsCount--;
			return false;
		}

		return true;
	}

	/**
	 * 命中时进行速度缩减
	 *
	 * @param movement 命中速度
	 */
	protected void hitSpeedReduction(Vec3 movement) {
		int factor = impactsCount + 1;
		setDeltaMovement(new Vec3(movement.x / factor, movement.y / factor, movement.z / factor));
	}

	/**
	 * 是否可以破坏该方块判断逻辑
	 *
	 * @param blockState 待判断方块状态
	 * @return 是否可以破坏该方块
	 */
	protected boolean isBreakable(BlockState blockState) {
		return blockState.is(ScTags.ScBlocks.BREAKABLE_BY_STONE_NUGGET);
	}

	/**
	 * 命中方块时进行弹跳
	 *
	 * @return 是否删除
	 */
	protected boolean blocksBounce() {
		boolean shouldDiscard = false;
		// TODO 完成 v1.1 的方块弹跳

		bouncesCount--;
		return shouldDiscard;
	}
	//endregion

	//region 命中实体

	/**
	 * 击中实体时的处理逻辑
	 */
	@Override
	protected void onHitEntity(@NotNull EntityHitResult result) {
		Level level = this.level();
		Entity entity = result.getEntity();
		if (level.isClientSide || !canHitEntity(entity)) {
			return;
		}

		// 计算伤害值
		double speed = getDeltaMovement().lengthSqr();

		// 伤害计算
		// 基础伤害 * 速度 + (伤害加成 * 速度 不超过伤害加成) * 伤害倍数
		double damageBonus = Math.min(getDamageBonus(), Math.max(getDamageBonus(), getDamageBonus() * speed));
		float hurt = (float) ((getBasicDamage() * speed + damageBonus) * getDamageMultiplier());

		Entity owner = getOwner();
		DamageSource damageSource = this.damageSources().thrown(this, owner);

		// 进行处理前
		StoneNuggetOnHitEntityEvent.Pre preEvent = stoneNuggetOnHitEntityPre(this, result, level, entity, speed, owner, hurt, damageSource, impactsCount);
		if (preEvent.isCanceled()) {
			return;
		}
		hurt         = preEvent.getNewHurt();
		impactsCount = preEvent.getNewImpactsCount();

		boolean shouldDiscard = hurtEntity(entity, damageSource, hurt);

		if (shouldDiscard) {
			level.broadcastEntityEvent(this, (byte) 3);
			this.discard();
		} else if (isRemoved()) {
			super.onHitEntity(result);
		}

		// 结束处理
		stoneNuggetOnHitEntityPost(result, level, entity, speed, owner, hurt, damageSource, this, impactsCount);
	}

	/**
	 * 伤害实体
	 */
	protected boolean hurtEntity(Entity entity, DamageSource damageSource, float hurt) {
		Vec3 movement = getDeltaMovement();
		double speed = movement.lengthSqr();
		entity.hurt(damageSource, hurt);
		setHitEntity(entity);
		if (speed < 0.5) {
			return true;
		}

		// 如果还有穿透次数，则将当前实体加入忽略列表，减少穿透次数并返回false表示不删除投射物
		if (impactsCount > 0) {
			hitSpeedReduction(movement);
			impactsCount--;
			return false;
		}

		// 如果没有穿透次数了，则返回true表示应该删除投射物
		return true;
	}

	/**
	 * 判断是否可以命中指定实体
	 */
	@Override
	protected boolean canHitEntity(@NotNull Entity target) {
		boolean is = super.canHitEntity(target);
		if (is && cachedHitEntity == null) {
			return true;
		}
		return is && !cachedHitEntity.equals(target) && !hitEntityBy(target);
	}

	/**
	 * 获取表示实体命中的 EntityRayTraceResult
	 */
	@Nullable
	protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
		return ProjectileUtil.getEntityHitResult(
				this.level(), this, startVec, endVec, this.getBoundingBox().expandTowards(this.getDeltaMovement()).inflate(1.0), this::canHitEntity
		);
	}
	//endregion
	// endregion

	// region 获取器和设置器
	@Override
	protected @NotNull AbsStoneNuggetItem getDefaultItem() {
		if (getProjectileItem() == null) {
			return ScItems.STONE_NUGGET.get();
		}
		return getProjectileItem();
	}

	/**
	 * 获取投射物默认重力值
	 */
	@Override
	public double getDefaultGravity() {
		return getBasicGravity() * getWeight();
	}

	/**
	 * 获取投射物重量
	 */
	public float getWeight() {
		return getBasicWeight();
	}

	/**
	 * 获取水漂次数
	 */
	public int getSkipCount() {
		return skipCount;
	}

	/**
	 * 获取伤害加成
	 */
	public float getDamageBonus() {
		return damageBonus;
	}

	/**
	 * 设置伤害加成
	 */
	public void setDamageBonus(float damageBonus) {
		this.damageBonus = damageBonus;
	}

	/**
	 * 获取伤害加成倍数
	 */
	public float getDamageMultiplier() {
		return damageMultiplier;
	}

	/**
	 * 设置伤害加成倍数
	 */
	public void setDamageMultiplier(float damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
	}

	public double getVerticalVelocityLowAngleFactor() {
		return verticalVelocityLowAngleFactor;
	}

	public double getVerticalVelocityHighAngleFactor() {
		return verticalVelocityHighAngleFactor;
	}

	public double getLowAngleThreshold() {
		return lowAngleThreshold;
	}

	public double getHighAngleThreshold() {
		return highAngleThreshold;
	}

	public float getMaxBounceAngle() {
		return maxBounceAngle;
	}

	public float getMinBounceAngle() {
		return minBounceAngle;
	}

	public float getMinBounceSpeed() {
		return minBounceSpeed;
	}

	public float getBasicDamage() {
		return basicDamage;
	}

	public double getBasicGravity() {
		return basicGravity;
	}

	public float getBasicWeight() {
		return basicWeight;
	}

	public int getTime() {
		return time;
	}

	public boolean isHasAnnouncedResult() {
		return hasAnnouncedResult;
	}

	public int getImpactsCount() {
		return impactsCount;
	}

	public int getBouncesCount() {
		return bouncesCount;
	}

	public @Nullable ItemStack getWeapon() {
		return weapon;
	}

	public AbsStoneNuggetItem getProjectileItem() {
		return projectileItem;
	}

	public void setImpactsCount(int impactsCount) {
		this.impactsCount = impactsCount;
	}

	public void setBouncesCount(int bouncesCount) {
		this.bouncesCount = bouncesCount;
	}

	public @Nullable Entity getCachedHitEntity() {
		if (cachedHitEntity != null && !cachedHitEntity.isRemoved()) {
			return cachedHitEntity;
		} else if (hitEntityUUID != null && level() instanceof ServerLevel serverlevel) {
			cachedHitEntity = serverlevel.getEntity(hitEntityUUID);
			return cachedHitEntity;
		} else {
			return null;
		}
	}

	public void setHitEntity(@Nullable Entity hitEntity) {
		if (hitEntity == null) {
			return;
		}
		cachedHitEntity = hitEntity;
		hitEntityUUID   = hitEntity.getUUID();
	}

	public @Nullable UUID getHitEntityUUID() {
		if (hitEntityUUID == null) {
			if (cachedHitEntity == null) {
				return null;
			}
			hitEntityUUID = cachedHitEntity.getUUID();
		}
		return hitEntityUUID;
	}

	public void clearHitEntity() {
		hitEntityUUID   = null;
		cachedHitEntity = null;
	}

	public boolean hitEntityBy(Entity entity) {
		return entity.getUUID().equals(hitEntityUUID);
	}
	// endregion
}
