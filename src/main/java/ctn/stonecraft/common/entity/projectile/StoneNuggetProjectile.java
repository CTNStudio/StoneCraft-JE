package ctn.stonecraft.common.entity.projectile;

import ctn.stonecraft.common.item.StoneNuggetItem;
import ctn.stonecraft.init.ScItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import static ctn.stonecraft.api.tool.WorldTool.*;
import static ctn.stonecraft.init.ScEntityTypes.STONE_NUGGET;

/**
 * 石粒投射物
 */
public class StoneNuggetProjectile extends ThrowableItemProjectile {
	/// 水漂次数
	protected int     hydroplaningCount;
	protected int     time              = 0;
	// 弹射参数
	protected float   maxAngle          = 20.0f;
	protected float   minAngle          = 0.0f;
	protected float   minSpeed          = 0.001f;
	private   boolean isAnnounceResults = false;
	
	//region 构建方法
	public StoneNuggetProjectile(double x, double y, double z, Level level) {
		this(STONE_NUGGET.get(), x, y, z, level);
	}
	
	public StoneNuggetProjectile(EntityType<StoneNuggetProjectile> entityType, double x, double y, double z, Level level) {
		super(entityType, x, y, z, level);
	}
	
	public StoneNuggetProjectile(Level level) {
		this(STONE_NUGGET.get(), level);
	}
	
	public StoneNuggetProjectile(EntityType<StoneNuggetProjectile> entityType, Level level) {
		super(entityType, level);
	}
	
	public StoneNuggetProjectile(LivingEntity shooter, Level level) {
		this(STONE_NUGGET.get(), shooter, level);
	}
	
	public StoneNuggetProjectile(EntityType<StoneNuggetProjectile> entityType, LivingEntity shooter, Level level) {
		super(entityType, shooter, level);
	}
	//endregion
	
	//region 功能方法
	
	@Override
	public void tick() {
		super.tick();
		time++;
		Level level = this.level();
		liquidContact:
		{
			Vec3 movement = getDeltaMovement();
			float pitchFromVelocity = getPitchFromVelocity(movement);
			float abs = Math.abs(pitchFromVelocity);
			
			double length = movement.length();
			if (abs < minAngle || abs > maxAngle || length < minSpeed) {
				break liquidContact;
			}
			
			Vec3 pos = position();
			AABB aabb = this.getBoundingBox();
			double aabbBottomY = aabb.minY;
			Vec3 posBottomY = new Vec3(pos.x, aabbBottomY, pos.z);
			FluidState fluidState = getFluidState(level, posBottomY);
			
			// 检查当前格子是否找到液体
			if (fluidState.isEmpty()) {
				break liquidContact;
			}
			
			// 检查是否接触液体表面
			if (!isInFluid(level, fluidState, posBottomY)) {
				break liquidContact;
			}
			
			// 检查是否浸入过深
			Vec3 posTopY = new Vec3(pos.x, aabb.maxY * Math.max(1, 0.01 * length), pos.z);
			if (isInFluid(level, fluidState, posTopY)) {
				break liquidContact;
			}
			
			// 成功
			// TODO 增加事件
			
			if (!level.isClientSide) {
				if (level instanceof ServerLevel serverLevel) {
					BlockPos blockpos = getOnPos();
					for (int i = 0; i < Math.max(5, movement.lengthSqr()); i++) {
						double random = level.random.nextDouble();
						double posX = (double) blockpos.getX() + random;
						double posZ = (double) blockpos.getZ() + random;
						int posY = blockpos.getY() + 1;
						serverLevel.sendParticles(ParticleTypes.SPLASH, posX, posY, posZ, 1, 0.0, 0.0, 0.0, 1.0);
					}
				}
			}
			float floatHeight = getFloatHeight(level, fluidState, posBottomY);
			
			double angleFactor = abs / maxAngle;
			double restitution = 0.8 - (angleFactor * 0.2);
			double newYVelocity = -movement.y * restitution;
			
			double horizontalDamping = 0.98 - (0.08 * angleFactor);
			double newXVelocity = movement.x * horizontalDamping;
			double newZVelocity = movement.z * horizontalDamping;
			
			if (abs < 10) {
				newYVelocity *= 0.7;
			} else if (abs > 10) {
				newYVelocity *= 1.3;
			}
			
			// 设置新的位置和速度
			setPos(pos.x, floatHeight, pos.z);
			setDeltaMovement(new Vec3(newXVelocity, newYVelocity, newZVelocity));
			
			hydroplaningCount++;
			isAnnounceResults = false;
			time              = 0;
		}
		if (!level.isClientSide && time >= 20 * 2 && !isAnnounceResults) {
			isAnnounceResults = true;
			sendGrades();
		}
	}
	
	/**
	 * 发送成绩
	 */
	private void sendGrades() {
		Minecraft.getInstance().gui.setOverlayMessage(Component.literal(("你的成绩是：" + hydroplaningCount + "次！")), false);
	}
	
	/**
	 * 基本重力（下坠）
	 */
	@Override
	public double getDefaultGravity() {
		return getDefaultItem().getGravity() * getWeight();
	}
	
	/**
	 * 基本重量
	 */
	public float getWeight() {
		return getDefaultItem().getWeight();
	}
	
	/**
	 * 粒子
	 */
	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			ParticleOptions particleoptions = this.getParticle();
			Vec3 movement = getDeltaMovement();
			Level level = this.level();
			double random = level.random.nextDouble();
			for (int i = 0; i < Math.max(8, movement.lengthSqr()); i++) {
				level.addParticle(particleoptions,
						this.getX(), this.getY(), this.getZ(),
						movement.x + random, movement.y + random, movement.z + random);
			}
		}
	}
	//endregion
	
	//region get方法
	
	/**
	 * 获取破裂时产生的粒子效果
	 *
	 * @return 粒子效果选项，根据当前物品或材料类型返回相应的粒子效果
	 */
	public ParticleOptions getParticle() {
		// 获取材料类型
		ItemLike material = getMaterial();
		if (material == null) {
			ItemStack itemstack = this.getItem();
			StoneNuggetItem defaultItem = this.getDefaultItem();
			// 如果当前物品不为空且不是默认物品，则使用当前物品的粒子效果
			if (!itemstack.isEmpty() && !itemstack.is(defaultItem)) {
				return new ItemParticleOption(ParticleTypes.ITEM, itemstack);
			}
			// 如果材料为空，返回默认的雪球粒子效果
			return ParticleTypes.ITEM_SNOWBALL;
		}
		// 根据材料类型返回相应的粒子效果
		return switch (material) {
			case Block block -> {
				BlockState state = block.defaultBlockState();
				yield new BlockParticleOption(ParticleTypes.BLOCK, state);
			}
			case Item item -> {
				ItemStack stack = item.getDefaultInstance();
				yield new ItemParticleOption(ParticleTypes.ITEM, stack);
			}
			default -> ParticleTypes.ITEM_SNOWBALL;
		};
	}
	
	/**
	 * 材料
	 */
	public ItemLike getMaterial() {
		return getDefaultItem().getMaterial();
	}
	
	@Override
	protected @NotNull StoneNuggetItem getDefaultItem() {
		return ScItems.STONE_NUGGET.get();
	}
	
	/**
	 * 击中调用
	 */
	@Override
	protected void onHit(HitResult result) {
		// TODO 增加更多效果：破坏玻璃，多次机打
		super.onHit(result);
		Level level = this.level();
		if (!level.isClientSide) {
			level.broadcastEntityEvent(this, (byte) 3);
			this.discard();
			if (hydroplaningCount > 0 && !isAnnounceResults) {
				isAnnounceResults = true;
				sendGrades();
			}
		}
	}
	
	/**
	 * 击中生物调用
	 */
	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		
		// 当前速度
		double movement = getDeltaMovement().length();
		
		// 伤害浮动
		float randomHurt = getRandom().nextFloat() * getHurtRandom();
		randomHurt = getRandom().nextBoolean() ? randomHurt : -randomHurt;
		
		// 获取发射者
		Entity owner = getOwner();
		
		// 伤害计算
		float hurt = (float) ((getBasicHurt() + randomHurt) * movement);
		entity.hurt(this.damageSources().thrown(this, owner), hurt);
	}
	
	/**
	 * 基本伤害浮动
	 */
	public float getHurtRandom() {
		return getDefaultItem().getHurtRandom();
	}
	
	/**
	 * 基本伤害
	 */
	public float getBasicHurt() {
		return getDefaultItem().getHurt();
	}
	
	public int getHydroplaningCount() {
		return hydroplaningCount;
	}
	//endregion
}