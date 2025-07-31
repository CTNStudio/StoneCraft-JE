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
	private int              hydroplaningCount;
	
	private int     time              = 0;
	private boolean isAnnounceResults = false;
	
	//region 构建方法
	public StoneNuggetProjectile(double x, double y, double z, Level level) {
		this(STONE_NUGGET.get(), x, y, z, level);
	}
	
	public StoneNuggetProjectile(Level level) {
		this(STONE_NUGGET.get(), level);
	}
	
	public StoneNuggetProjectile(LivingEntity shooter, Level level) {
		this(STONE_NUGGET.get(), shooter, level);
	}
	
	public StoneNuggetProjectile(EntityType<StoneNuggetProjectile> entityType, double x, double y, double z, Level level) {
		super(entityType, x, y, z, level);
	}
	
	public StoneNuggetProjectile(EntityType<StoneNuggetProjectile> entityType, Level level) {
		super(entityType, level);
	}
	
	public StoneNuggetProjectile(EntityType<StoneNuggetProjectile> entityType, LivingEntity shooter, Level level) {
		super(entityType, shooter, level);
	}
	//endregion
	
	//region 功能方法
	
	@Override
	public void tick() {
		super.tick();
		Level level = this.level();
		time++;
		Vec3 movement = getDeltaMovement();
		double length = movement.length();
		Vec3 pos = position();
		AABB aabb = this.getBoundingBox();
		double aabbBottomY = aabb.minY;
		double aabbTopY = aabb.maxY;
		liquidContact:
		{
			float pitchFromVelocity = getPitchFromVelocity(movement);
			float abs = Math.abs(pitchFromVelocity);
			
			// 角度判断：打水漂的最佳角度通常在5-20度之间
			if (abs < 0 || abs > 20 || length < 0.001) {
				break liquidContact;
			}
			
			Vec3 posBottomY = new Vec3(pos.x, aabbBottomY, pos.z);
			Vec3 posTopY = new Vec3(pos.x, aabbTopY * Math.max(1, 0.01 * length), pos.z);
			FluidState fluidState = getFluidState(level, posBottomY);
			
			// 检查是否找到液体
			if (fluidState.isEmpty()) {
				break liquidContact;
			}
			
			// 检查是否接触液体表面
			if (!isInFluid(level, fluidState, posBottomY)) {
				break liquidContact;
			}
			
			// 检查是否浸入过深
			if (isInFluid(level, fluidState, posTopY)) {
				break liquidContact;
			}
			if (!level.isClientSide) {
				if (level instanceof ServerLevel serverLevel){
					BlockPos blockpos = getOnPos();
					for (int i = 0; i < Math.max(5, movement.lengthSqr()); i++) {
						serverLevel.sendParticles(
								ParticleTypes.SPLASH,
								(double)blockpos.getX() + level.random.nextDouble(),
								blockpos.getY() + 1,
								(double)blockpos.getZ() + level.random.nextDouble(),
								1,
								0.0,
								0.0,
								0.0,
								1.0
						);
					}
				}
			}
			float floatHeight = getFloatHeight(level, fluidState, posBottomY);
			
			// 计算入射角和反射角
			double velocityY = movement.y;
			
			// 反射角近似等于入射角，但会因为能量损失而减小
			// 垂直速度反向并乘以恢复系数（0.6-0.8之间）
			// 根据入射角度调整恢复系数，角度越小恢复系数越大
			double angleFactor = abs / 30.0; // 基于最大角度30度
			double restitution = 0.8 - (angleFactor * 0.2); // 角度越小恢复系数越大(0.6-0.8)
			double newYVelocity = -velocityY * restitution;
			
			// 水平速度也会有损失，且与入射角相关
			// 入射角越大，水平速度损失越多
			double horizontalDamping = 0.98 - (0.08 * angleFactor); // 减少水平速度损失以提高游戏性
			double newXVelocity = movement.x * horizontalDamping;
			double newZVelocity = movement.z * horizontalDamping;
			
			// 根据角度调整新的垂直速度，使弹跳更符合物理规律
			// 角度越小，垂直速度应该越小以保持贴近水面
			if (abs < 10) {
				// 对于较小角度，进一步减小垂直速度以保持贴近水面
				newYVelocity *= 0.7;
			} else if (abs > 10) {
				// 对于较大角度，增加垂直速度以确保能跳出水面
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
			o("你的成绩是：" + hydroplaningCount + "次！");
		}
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
			for (int i = 0; i < Math.max(8, movement.lengthSqr()); i++) {
				level.addParticle(particleoptions,
						this.getX(), this.getY(), this.getZ(),
						movement.x, movement.y, movement.z);
			}
		}
	}
	
	private static void o(String text) {
		Minecraft.getInstance().gui.setOverlayMessage(Component.literal(text), false);
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
				o("你的成绩是：" + hydroplaningCount + "次！");
			}
		}
	}
	//endregion
	
	//region get方法
	/**
	 * 基本重力（下坠）
	 */
	@Override
	public double getDefaultGravity() {
		return getDefaultItem().getGravity() * getWeight();
	}
	
	/**
	 * 基本伤害
	 */
	public float getBasicHurt() {
		return getDefaultItem().getHurt();
	}
	
	/**
	 * 基本伤害浮动
	 */
	public float getHurtRandom() {
		return getDefaultItem().getHurtRandom();
	}
	
	/**
	 * 基本重量
	 */
	public float getWeight() {
		return getDefaultItem().getWeight();
	}
	
	/**
	 * 材料
	 */
	public ItemLike getMaterial() {
		return getDefaultItem().getMaterial();
	}
	
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
	
	@Override
	protected @NotNull StoneNuggetItem getDefaultItem() {
		return ScItems.STONE_NUGGET.get();
	}
	//endregion
}