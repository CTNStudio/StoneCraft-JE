package ctn.stonecraft.common.entity.projectile.stone_nugget.flint;

import ctn.stonecraft.common.entity.projectile.stone_nugget.BasicStoneNuggetProjectile;
import ctn.stonecraft.common.entity.projectile.stone_nugget.StoneNuggetProjectileBuilder;
import ctn.stonecraft.common.item.stone_nugget.BaseNuggetProps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class FlintProjectile extends BasicStoneNuggetProjectile {

  //燧石作为弹药的基本属性
  public static BaseNuggetProps FLINT_BASE_NUGGET_PROPS = BaseNuggetProps.defaultFlintNuggetProps();

  private static final float MAX_FIRE_TIME = 5.0f;    //最短燃烧时间
  private static final float MIN_FIRE_TIME = 3.0f;    //最长燃烧时间

  // region 构造方法
  public FlintProjectile(StoneNuggetProjectileBuilder builder,
                         EntityType<? extends BasicStoneNuggetProjectile> entityType,
                         Position pos, Level level, ItemStack weapon) {
    super(builder, entityType, pos, level, weapon);
    initProps();
  }

  public FlintProjectile(StoneNuggetProjectileBuilder builder,
                         EntityType<? extends BasicStoneNuggetProjectile> entityType,
                         double x, double y, double z, Level level, ItemStack weapon) {
    super(builder, entityType, x, y, z, level, weapon);
    initProps();
  }

  public FlintProjectile(StoneNuggetProjectileBuilder builder,
                         EntityType<? extends BasicStoneNuggetProjectile> entityType,
                         Level level, ItemStack weapon) {
    super(builder, entityType, level, weapon);
    initProps();
  }

  public FlintProjectile(StoneNuggetProjectileBuilder builder,
                         EntityType<? extends BasicStoneNuggetProjectile> entityType,
                         LivingEntity shooter, Level level, ItemStack weapon) {
    super(builder, entityType, shooter, level, weapon);
    initProps();
  }
  // endregion

  private void initProps(){
    setItem(new ItemStack(Items.FLINT)); //设置发射模型为燧石
    this.SkipAllowed = false;   //不允许打水漂
  }
  /**
   * 使用燧石材质作为破碎效果
   */
  @Override
  public ParticleOptions getParticle() {
    ItemStack flintStack = new ItemStack(Items.FLINT);
    return new ItemParticleOption(ParticleTypes.ITEM, flintStack);
  }

  /**
   * 命中实体
   */
  @Override
  protected void onHitEntity(@NotNull EntityHitResult result) {
    super.onHitEntity(result);

    // 命中实体时点燃目标
    if (!level().isClientSide && result.getEntity() instanceof LivingEntity target) {
      float fireSeconds = MIN_FIRE_TIME + random.nextFloat() * (MAX_FIRE_TIME - MIN_FIRE_TIME);      // 点燃目标 3-5 秒
      target.igniteForSeconds(fireSeconds);
      // 生成火焰粒子效果
      spawnFireParticles(target.position());
      // 播放点燃音效
      playIgniteSound(target.position());

    }
  }

  /**
   * 命中方块时生成火焰
   */
  @Override
  protected void onHitBlock(@NotNull BlockHitResult result) {
    super.onHitBlock(result);
    boolean ignited = false;
    if (!level().isClientSide) {
      BlockPos hitPos = result.getBlockPos();
      Vec3 movement = getDeltaMovement();
      double speed = movement.lengthSqr();

      // 尝试点燃命中的方块
      if (tryIgniteBlock(hitPos, result)) {
        spawnFireParticles(result.getLocation());
        ignited = true;

      }
      // 尝试在命中点附近生成火焰
      BlockPos firePos = hitPos.relative(result.getDirection());
      if (tryPlaceFire(firePos)) {
        spawnFireParticles(Vec3.atCenterOf(firePos));
        ignited = true;
      }
      // 如果成功点燃，生成粒子和音效
      if (ignited) {
        spawnFireParticles(result.getLocation());
        playIgniteSound(result.getLocation());
      }
    }
  }

  /**
   * 尝试点燃方块（营火、蜡烛等）
   */
  private boolean tryIgniteBlock(BlockPos pos, BlockHitResult hitResult) {
    Level level = level();
    BlockState state = level.getBlockState(pos);

    // 尝试点燃可点燃方块
    if (
        tryIgniteLitBlock(level, pos, state, CampfireBlock.class, BlockStateProperties.LIT) ||  //营火
        tryIgniteLitBlock(level, pos, state, CandleBlock.class, CandleBlock.LIT) ||             //蜡烛
        tryIgniteLitBlock(level, pos, state, CandleCakeBlock.class, CandleCakeBlock.LIT)        //生日蛋糕蜡烛
    ) {
      spawnFireParticles(hitResult.getLocation());
      return true;
    }

    // 尝试点燃 TNT
    if (tryIgniteTnt(level, pos, state, hitResult)) {
      spawnFireParticles(hitResult.getLocation());
      return true;
    }
    return false;
  }

  /**
   * 尝试点燃带 LIT 属性的方块
   */
  private boolean tryIgniteLitBlock(Level level, BlockPos pos, BlockState state,
                                    Class<? extends Block> blockClass, BooleanProperty litProperty) {
    if (!blockClass.isInstance(state.getBlock())) {
      return false;
    }

    if (!state.hasProperty(litProperty) || state.getValue(litProperty)) {
      return false;
    }

    level.setBlock(pos, state.setValue(litProperty, true), 3);
    level.gameEvent(getOwner(), GameEvent.BLOCK_CHANGE, pos);
    return true;
  }

  /**
   * 尝试点燃 TNT
   */
  private boolean tryIgniteTnt(Level level, BlockPos pos, BlockState state, BlockHitResult hitResult) {
    if (!state.is(Blocks.TNT)) {
      return false;
    }

    LivingEntity owner = getOwner() instanceof LivingEntity ? (LivingEntity) getOwner() : null;
    Blocks.TNT.onCaughtFire(state, level, pos, hitResult.getDirection(), owner);
    level.removeBlock(pos, false);
    return true;
  }

  /**
   * 尝试在指定位置放置火焰
   */
  private boolean tryPlaceFire(BlockPos pos) {
    Level level = level();
    BlockState state = level.getBlockState(pos);
    Vec3 movement = getDeltaMovement();
    Direction direction = Direction.getNearest(movement.x, movement.y, movement.z);
    // 检查位置是否可以放置火焰
    if (state.isAir() && BaseFireBlock.canBePlacedAt(level, pos, direction)) {
      // 放置火焰
      BlockState fireState = BaseFireBlock.getState(level, pos);
      level.setBlock(pos, fireState, 3);
      level.gameEvent(getOwner(), GameEvent.BLOCK_PLACE, pos);
      return true;
    }

    return false;
  }

  /**
   * 生成火焰粒子效果
   */
  private void spawnFireParticles(Vec3 pos) {
    Level level = level();

    // 必须在服务端执行
    if (!(level instanceof ServerLevel serverLevel)) {
      return;
    }

    // 生成火焰粒子
    serverLevel.sendParticles(
      ParticleTypes.FLAME,           // 粒子类型
      pos.x, pos.y + 0.2, pos.z,     // 位置
      30,                             // 粒子数量
      0.2, 0.2, 0.2,                 // 扩散范围 (x, y, z)
      0.05                            // 速度
    );

    // 💨 生成烟雾粒子
    serverLevel.sendParticles(
      ParticleTypes.LARGE_SMOKE,
      pos.x, pos.y + 0.2, pos.z,
      15,
      0.15, 0.15, 0.15,
      0.02
    );

    // ✨ 生成火花粒子（增强视觉效果）
    serverLevel.sendParticles(
      ParticleTypes.LAVA,
      pos.x, pos.y + 0.1, pos.z,
      5,
      0.1, 0.1, 0.1,
      0.0
    );
  }

  /**
   * 播放点燃音效
   */
  private void playIgniteSound(Vec3 pos) {
    Level level = level();
    level.playSound(
      null,
      pos.x, pos.y, pos.z,
      SoundEvents.FLINTANDSTEEL_USE,  // 打火石音效
      SoundSource.NEUTRAL,
      1.0F,
      0.8F + random.nextFloat() * 0.4F  // 随机音调 0.8-1.2
    );

}

}

