package net.zlt.create_modular_tools.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class AttackableArrow extends Projectile {
    @Nullable
    private BlockState lastState;
    protected boolean inGround;
    protected int inGroundTime;
    public AbstractArrow.Pickup pickup = AbstractArrow.Pickup.DISALLOWED;
    public int shakeTime;
    private int life;
    private double baseDamage = 2.0;
    private SoundEvent soundEvent = getDefaultHitGroundSoundEvent();
    public final int KNOCKBACK = 2;

    protected AttackableArrow(EntityType<? extends AttackableArrow> entityType, Level level) {
        super(entityType, level);
    }

    protected AttackableArrow(EntityType<? extends AttackableArrow> entityType, double x, double y, double z, Level level) {
        this(entityType, level);
        setPos(x, y, z);
    }

    protected AttackableArrow(EntityType<? extends AttackableArrow> entityType, LivingEntity shooter, Level level) {
        this(entityType, shooter.getX(), shooter.getEyeY() - 0.1f, shooter.getZ(), level);
        setOwner(shooter);
        if (shooter instanceof Player) {
            pickup = AbstractArrow.Pickup.ALLOWED;
        }
    }

    public void setSoundEvent(SoundEvent soundEvent) {
        this.soundEvent = soundEvent;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        double d = getBoundingBox().getSize() * 10.0;
        if (Double.isNaN(d)) {
            d = 1.0;
        }

        d *= 64.0 * getViewScale();
        return distance < d * d;
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        super.shoot(x, y, z, velocity, inaccuracy);
        life = 0;
    }

    @Override
    public void lerpMotion(double x, double y, double z) {
        super.lerpMotion(x, y, z);
        life = 0;
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 vec3 = getDeltaMovement();
        if (xRotO == 0.0f && yRotO == 0.0f) {
            double d = vec3.horizontalDistance();
            setYRot((float) (Mth.atan2(vec3.x, vec3.z) * 180.0f / (float) Math.PI));
            setXRot((float) (Mth.atan2(vec3.y, d) * 180.0f / (float) Math.PI));
            yRotO = getYRot();
            xRotO = getXRot();
        }

        BlockPos blockPos = blockPosition();
        BlockState blockState = level().getBlockState(blockPos);
        if (!blockState.isAir()) {
            VoxelShape voxelShape = blockState.getCollisionShape(level(), blockPos);
            if (!voxelShape.isEmpty()) {
                Vec3 vec32 = position();

                for (AABB aABB : voxelShape.toAabbs()) {
                    if (aABB.move(blockPos).contains(vec32)) {
                        inGround = true;
                        break;
                    }
                }
            }
        }

        if (shakeTime > 0) {
            --shakeTime;
        }

        if (isInWaterOrRain() || blockState.is(Blocks.POWDER_SNOW)) {
            clearFire();
        }

        if (inGround) {
            if (lastState != blockState && shouldFall()) {
                startFalling();
            } else if (!level().isClientSide) {
                tickDespawn();
            }

            ++inGroundTime;
        } else {
            inGroundTime = 0;
            Vec3 vec33 = position();
            Vec3 vec32 = vec33.add(vec3);
            HitResult hitResult = level().clip(new ClipContext(vec33, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
            if (hitResult.getType() != HitResult.Type.MISS) {
                vec32 = hitResult.getLocation();
            }

            EntityHitResult entityHitResult = findHitEntity(vec33, vec32);
            if (entityHitResult != null) {
                hitResult = entityHitResult;
            }

            if (hitResult.getType() == HitResult.Type.ENTITY) {
                Entity entity = ((EntityHitResult) hitResult).getEntity();
                Entity entity2 = getOwner();
                if (entity instanceof Player && entity2 instanceof Player && !((Player) entity2).canHarmPlayer((Player) entity)) {
                    hitResult = null;
                }
            }

            if (hitResult != null) {
                onHit(hitResult);
                hasImpulse = true;
            }

            vec3 = getDeltaMovement();
            double e = vec3.x;
            double f = vec3.y;
            double g = vec3.z;
            double h = getX() + e;
            double j = getY() + f;
            double k = getZ() + g;
            double l = vec3.horizontalDistance();
            setYRot((float) (Mth.atan2(e, g) * 180.0f / (float) Math.PI));

            setXRot((float) (Mth.atan2(f, l) * 180.0f / (float) Math.PI));
            setXRot(lerpRotation(xRotO, getXRot()));
            setYRot(lerpRotation(yRotO, getYRot()));
            float m = 0.99f;
            if (isInWater()) {
                for (int o = 0; o < 4; ++o) {
                    level().addParticle(ParticleTypes.BUBBLE, h - e * 0.25, j - f * 0.25, k - g * 0.25, e, f, g);
                }

                m = getWaterInertia();
            }

//            setDeltaMovement(vec3.scale(m));
            if (!isNoGravity()) {
                Vec3 vec34 = getDeltaMovement();
                setDeltaMovement(vec34.x, vec34.y - 0.05f, vec34.z);
            }

            setPos(h, j, k);
            checkInsideBlocks();
        }
    }

    private boolean shouldFall() {
        return inGround && level().noCollision(new AABB(position(), position()).inflate(0.06));
    }

    private void startFalling() {
        inGround = false;
        Vec3 vec3 = getDeltaMovement();
        setDeltaMovement(
            vec3.multiply(random.nextFloat() * 0.2f, random.nextFloat() * 0.2f, random.nextFloat() * 0.2f)
        );
        life = 0;
    }

    @Override
    public void move(MoverType type, Vec3 pos) {
        super.move(type, pos);
        if (type != MoverType.SELF && shouldFall()) {
            startFalling();
        }
    }

    protected void tickDespawn() {
        ++life;
        if (life >= 1200) {
            discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        float f = (float) getDeltaMovement().length();
        int i = Mth.ceil(Mth.clamp((double) f * baseDamage, 0.0, 2.147483647E9));
        Entity entity2 = getOwner();
        DamageSource damageSource;
        if (entity2 == null) {
            damageSource = damageSources().thrown(this, this);
        } else {
            damageSource = damageSources().thrown(this, entity2);
            if (entity2 instanceof LivingEntity) {
                ((LivingEntity) entity2).setLastHurtMob(entity);
            }
        }

        boolean bl = entity.getType() == EntityType.ENDERMAN;
        int j = entity.getRemainingFireTicks();
        if (isOnFire() && !bl) {
            entity.setSecondsOnFire(5);
        }

        if (entity.hurt(damageSource, (float) i)) {
            if (bl) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity) {
                if (!level().isClientSide) {
                    livingEntity.setArrowCount(livingEntity.getArrowCount() + 1);
                }

                double d = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                Vec3 vec3 = getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(KNOCKBACK * 0.6 * d);
                if (vec3.lengthSqr() > 0.0) {
                    livingEntity.push(vec3.x, 0.1, vec3.z);
                }

                if (!level().isClientSide && entity2 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingEntity, entity2);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity) entity2, livingEntity);
                }

                doPostHurtEffects(livingEntity);
                if (livingEntity != entity2 && livingEntity instanceof Player && entity2 instanceof ServerPlayer && !isSilent()) {
                    ((ServerPlayer) entity2).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0f));
                }
            }

            playSound(soundEvent, 1.0f, 1.2f / (random.nextFloat() * 0.2f + 0.9f));
        } else {
            entity.setRemainingFireTicks(j);
//            setDeltaMovement(getDeltaMovement().scale(-0.1));
            setYRot(getYRot() + 180.0f);
            yRotO += 180.0f;
            if (!level().isClientSide && getDeltaMovement().lengthSqr() < 1.0E-7) {
                if (pickup == AbstractArrow.Pickup.ALLOWED) {
                    spawnAtLocation(getPickupItem(), 0.1f);
                }

                discard();
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        lastState = level().getBlockState(result.getBlockPos());
        super.onHitBlock(result);
        Vec3 vec3 = result.getLocation().subtract(getX(), getY(), getZ());
        setDeltaMovement(vec3);
        Vec3 vec32 = vec3.normalize().scale(0.05f);
        setPosRaw(getX() - vec32.x, getY() - vec32.y, getZ() - vec32.z);
        playSound(getHitGroundSoundEvent(), 1.0f, 1.2f / (random.nextFloat() * 0.2f + 0.9f));
        inGround = true;
        shakeTime = 7;
        setSoundEvent(SoundEvents.ARROW_HIT);
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.ARROW_HIT;
    }

    protected final SoundEvent getHitGroundSoundEvent() {
        return soundEvent;
    }

    protected void doPostHurtEffects(LivingEntity target) {
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 startVec, Vec3 endVec) {
        return ProjectileUtil.getEntityHitResult(
            level(), this, startVec, endVec, getBoundingBox().expandTowards(getDeltaMovement()).inflate(1.0), this::canHitEntity
        );
    }

    @Override
    protected boolean canHitEntity(Entity target) {
        return super.canHitEntity(target);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putShort("life", (short) life);
        if (lastState != null) {
            compound.put("inBlockState", NbtUtils.writeBlockState(lastState));
        }

        compound.putByte("shake", (byte) shakeTime);
        compound.putBoolean("inGround", inGround);
        compound.putByte("pickup", (byte) pickup.ordinal());
        compound.putDouble("damage", baseDamage);
        compound.putString("SoundEvent", BuiltInRegistries.SOUND_EVENT.getKey(soundEvent).toString());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        life = compound.getShort("life");
        if (compound.contains("inBlockState", 10)) {
            lastState = NbtUtils.readBlockState(level().holderLookup(Registries.BLOCK), compound.getCompound("inBlockState"));
        }

        shakeTime = compound.getByte("shake") & 255;
        inGround = compound.getBoolean("inGround");
        if (compound.contains("damage", 99)) {
            baseDamage = compound.getDouble("damage");
        }

        pickup = AbstractArrow.Pickup.byOrdinal(compound.getByte("pickup"));
        if (compound.contains("SoundEvent", 8)) {
            soundEvent = BuiltInRegistries.SOUND_EVENT
                .getOptional(new ResourceLocation(compound.getString("SoundEvent")))
                .orElse(getDefaultHitGroundSoundEvent());
        }
    }

    @Override
    public void setOwner(@Nullable Entity owner) {
        super.setOwner(owner);
        if (owner instanceof Player) {
            pickup = ((Player) owner).getAbilities().instabuild ? AbstractArrow.Pickup.CREATIVE_ONLY : AbstractArrow.Pickup.ALLOWED;
        }
    }

    @Override
    public void playerTouch(Player player) {
        if (!level().isClientSide && inGround && shakeTime <= 0) {
            if (tryPickup(player)) {
                player.take(this, 1);
                discard();
            }
        }
    }

    protected boolean tryPickup(Player player) {
        return switch (pickup) {
            case ALLOWED -> player.getInventory().add(getPickupItem());
            case CREATIVE_ONLY -> player.getAbilities().instabuild;
            default -> false;
        };
    }

    protected abstract ItemStack getPickupItem();

    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    protected float getEyeHeight(Pose pose, EntityDimensions dimensions) {
        return 0.13f;
    }

    protected float getWaterInertia() {
        return 0.6f;
    }
}
