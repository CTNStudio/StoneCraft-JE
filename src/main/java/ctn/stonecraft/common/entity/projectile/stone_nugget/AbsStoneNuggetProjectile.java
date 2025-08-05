package ctn.stonecraft.common.entity.projectile.stone_nugget;

import ctn.stonecraft.common.item.stone_nugget.AbsStoneNuggetItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static ctn.stonecraft.api.tool.WorldTool.*;
import static ctn.stonecraft.init.ScEntityTypes.STONE_NUGGET;

/**
 * 抽象石粒投射物
 */
public abstract class AbsStoneNuggetProjectile<I extends AbsStoneNuggetItem> extends ThrowableItemProjectile {
	protected static final int RESULT_DISPLAY_DELAY = 20 * 2; // 成绩显示延迟(ticks)
	//region 属性变量
	
	// 物理模拟相关参数
	protected double verticalVelocityLowAngleFactor;  // 垂直速度-低角度因子
	protected double verticalVelocityHighAngleFactor; // 垂直速度-高角度因子
	protected double lowAngleThreshold;               // 低角度阈值
	protected double highAngleThreshold;              // 高角度阈值
	
	// 弹射相关参数
	protected float maxBounceAngle; // 最大弹射角度
	protected float minBounceAngle; // 最小弹射角度
	protected float minBounceSpeed; // 最小弹射速度
	//endregion
	
	//region 状态变量
	protected int     skipCount          = 0; // 水漂次数计数器
	protected int     time               = 0; // 存活时间计数器
	protected boolean hasAnnouncedResult = false; // 成绩公告状态标记
	//endregion
	
	protected Supplier<I> defaultItem;
	
	//region 构造方法
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, Position pos, Level level) {
		this(snpProperties, pos.x(), pos.y(), pos.z(), level);
	}
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, Position pos, Level level) {
		this(snpProperties, entityType, pos.x(), pos.y(), pos.z(), level);
	}
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, double x, double y, double z, Level level) {
		this(snpProperties, STONE_NUGGET.get(), x, y, z, level);
	}
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, Level level) {
		this(snpProperties, STONE_NUGGET.get(), level);
	}
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, LivingEntity shooter, Level level) {
		this(snpProperties, STONE_NUGGET.get(), shooter, level);
	}
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, double x, double y, double z, Level level) {
		super(entityType, x, y, z, level);
		init(snpProperties);
	}
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, Level level) {
		super(entityType, level);
		init(snpProperties);
	}
	
	public AbsStoneNuggetProjectile(SnpProperties<I> snpProperties, EntityType<AbsStoneNuggetProjectile> entityType, LivingEntity shooter, Level level) {
		super(entityType, shooter, level);
		init(snpProperties);
	}
	
	/**
	 * 初始化配置属性
	 *
	 * @param snpProperties 配置属性
	 */
	private void init(SnpProperties<I> snpProperties) {
		verticalVelocityLowAngleFactor  = snpProperties.verticalVelocityLowAngleFactor;
		verticalVelocityHighAngleFactor = snpProperties.verticalVelocityHighAngleFactor;
		lowAngleThreshold               = snpProperties.lowAngleThreshold;
		highAngleThreshold              = snpProperties.highAngleThreshold;
		maxBounceAngle                  = snpProperties.maxBounceAngle;
		minBounceAngle                  = snpProperties.minBounceAngle;
		minBounceSpeed                  = snpProperties.minBounceSpeed;
		defaultItem                     = snpProperties.defaultItem;
	}
	
	//endregion
	
	//region 主要功能方法
	
	@Override
	public void tick() {
		super.tick();
		time++;
		Level level = this.level();
		
		// 进行打水漂逻辑
		handleWaterSkimmingLogic(level);
		
		// 检查是否需要显示成绩
		if (level.isClientSide || time < RESULT_DISPLAY_DELAY || hasAnnouncedResult) {
			return;
		}
		checkAndDisplaySkipResult();
	}
	
	/**
	 * 显示水漂成绩
	 */
	protected void checkAndDisplaySkipResult() {
		hasAnnouncedResult = true;
		displaySkipResult();
	}
	
	/**
	 * 进行打水漂逻辑
	 *
	 * @param level 世界对象
	 */
	protected void handleWaterSkimmingLogic(final Level level) {
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
		if (!canBounce(level, absPitch, speed, fluidState, bottomPos, boundingBox, pos)) {
			return;
		}
		
		// 水漂成功，执行弹射逻辑
		executeBounce(level, movement, fluidState, bottomPos, absPitch, pos);
	}
	
	/**
	 * 判断是否可以弹射
	 *
	 * @param level       世界对象
	 * @param absPitch    绝对俯仰角
	 * @param speed       速度
	 * @param fluidState  流体状态
	 * @param bottomPos   底部位置
	 * @param boundingBox 碰撞箱
	 * @param pos         位置
	 * @return 是否可以弹射
	 */
	protected boolean canBounce(final Level level, float absPitch, double speed, FluidState fluidState, Vec3 bottomPos, AABB boundingBox, Vec3 pos) {
		// 检查角度和速度是否满足弹射条件
		if (absPitch < minBounceAngle ||
		    absPitch > maxBounceAngle ||
		    speed < minBounceSpeed) {
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
		double y = boundingBox.maxY * Math.max(1, 0.01 * speed);
		Vec3 topPos = new Vec3(pos.x, y, pos.z);
		return !isInFluid(level, fluidState, topPos);
	}
	
	/**
	 * 进行弹射
	 *
	 * @param level      世界对象
	 * @param movement   运动向量
	 * @param fluidState 流体状态
	 * @param bottomPos  底部位置
	 * @param absPitch   绝对俯仰角
	 * @param pos        位置
	 */
	protected void executeBounce(final Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos) {
		// 弹射前
		catapultPre(level, movement, fluidState, bottomPos, absPitch, pos);
		
		// 设置位置并进行弹射
		Vec3 deltaMovement = calculateBounceMovement(movement, absPitch);
		float floatHeight = getFloatHeight(level, fluidState, bottomPos);
		setPos(pos.x, floatHeight, pos.z);
		setDeltaMovement(deltaMovement);
		
		// 更新水漂计数和重置状态
		skipCount++;
		hasAnnouncedResult = false;
		time               = 0;
	}
	
	/**
	 * 计算弹射后的物理参数
	 *
	 * @param movement 原始运动向量
	 * @param absPitch 绝对俯仰角
	 * @return 新的运动向量
	 */
	protected @NotNull Vec3 calculateBounceMovement(Vec3 movement, float absPitch) {
		double angleFactor = absPitch / maxBounceAngle;
		
		// 计算恢复系数
		double restitution = 0.8 - (angleFactor * 0.2);
		double newYVelocity = -movement.y * restitution;
		
		// 计算水平阻尼
		double horizontalDamping = 0.98 - (0.08 * angleFactor);
		double newXVelocity = movement.x * horizontalDamping;
		double newZVelocity = movement.z * horizontalDamping;
		
		// 根据入射角度调整垂直速度
		if (absPitch < lowAngleThreshold) {
			newYVelocity *= verticalVelocityLowAngleFactor;
		} else if (absPitch > highAngleThreshold) {
			newYVelocity *= verticalVelocityHighAngleFactor;
		}
		
		return new Vec3(newXVelocity, newYVelocity, newZVelocity);
	}
	
	/**
	 * 弹射前
	 *
	 * @param level      世界对象
	 * @param movement   运动向量
	 * @param fluidState 流体状态
	 * @param bottomPos  底部位置
	 * @param absPitch   绝对俯仰角
	 * @param pos        位置
	 */
	protected void catapultPre(final Level level, Vec3 movement, FluidState fluidState, Vec3 bottomPos, float absPitch, Vec3 pos) {
		if (level.isClientSide) {
			return;
		}
		if (!(level instanceof ServerLevel serverLevel)) {
			return;
		}
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
	
	/**
	 * 显示水漂成绩
	 */
	public void displaySkipResult() {
		String text = "你的成绩是：" + skipCount + "次！";
		MutableComponent literal = Component.literal(text);
		Minecraft.getInstance().gui.setOverlayMessage(literal, false);
	}
	
	/**
	 * 获取投射物默认重力值
	 */
	@Override
	public double getDefaultGravity() {
		return getDefaultItem().getGravity() * getWeight();
	}
	
	/**
	 * 获取投射物重量
	 */
	public float getWeight() {
		return getDefaultItem().getWeight();
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
	
	//endregion
	
	//region 获取器方法
	
	/**
	 * 获取破裂时产生的粒子效果
	 *
	 * @return 粒子效果选项，根据当前物品或材料类型返回相应的粒子效果
	 */
	public ParticleOptions getParticle() {
		// 获取材料类型
		ItemStack itemstack = this.getItem();
		I defaultItem = this.getDefaultItem();
		if (!itemstack.isEmpty() && itemstack.is(defaultItem)) {
			return new ItemParticleOption(ParticleTypes.ITEM, itemstack);
		}
		// 如果材料为空，返回默认的雪球粒子效果
		return ParticleTypes.ITEM_SNOWBALL;
	}
	
	@Override
	protected @NotNull I getDefaultItem() {
		return defaultItem.get();
	}
	
	/**
	 * 击中目标时的处理逻辑
	 */
	@Override
	protected void onHit(@NotNull HitResult result) {
		super.onHit(result);
		Level level = this.level();
		if (level.isClientSide) {
			return;
		}
		level.broadcastEntityEvent(this, (byte) 3);
		this.discard();
		// 如果有水漂次数且未显示成绩，则显示成绩
		if (skipCount > 0 && !hasAnnouncedResult) {
			checkAndDisplaySkipResult();
		}
	}
	
	/**
	 * 击中实体时的处理逻辑
	 */
	@Override
	protected void onHitEntity(@NotNull EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		
		// 计算伤害值
		double movementSpeed = getDeltaMovement().length();
		float randomHurt = getRandom().nextFloat() * getHurtRandom();
		randomHurt = getRandom().nextBoolean() ? randomHurt : -randomHurt;
		
		Entity owner = getOwner();
		float hurt = (float) ((getBasicDamage() + randomHurt) * movementSpeed);
		entity.hurt(this.damageSources().thrown(this, owner), hurt);
	}
	
	/**
	 * 获取基础伤害浮动值
	 */
	public float getHurtRandom() {
		return getDefaultItem().getDamageRandom();
	}
	
	/**
	 * 获取基础伤害值
	 */
	public float getBasicDamage() {
		return getDefaultItem().getDamage();
	}
	
	/**
	 * 获取水漂次数
	 */
	public int getSkipCount() {
		return skipCount;
	}
	
	//endregion
}