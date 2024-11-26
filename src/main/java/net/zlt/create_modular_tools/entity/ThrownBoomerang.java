package net.zlt.create_modular_tools.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.zlt.create_modular_tools.advancement.AllCriterionTriggers;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.BaseSandMoldBlock;
import net.zlt.create_modular_tools.damage.AllDamageTypes;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.sound.AllSoundEvents;
import net.zlt.create_modular_tools.tool.ToolUtils;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ThrownBoomerang extends AttackableArrow {
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrownBoomerang.class, EntityDataSerializers.BOOLEAN);
    private ItemStack boomerangItem;
    @Nullable
    private Vec3 origin;
    private Phase phase;
    private float initialSpeed;
    private Vec3 atReturning;
    private boolean isCustomRotSet;
    private float customXRot;
    private float customYRot;
    private float customYaw;
    protected final ToolModuleItem TOOL_MODULE;
    private final boolean IS_VALID;

    public ThrownBoomerang(ToolModuleItem toolModule, Item item, EntityType<? extends ThrownBoomerang> entityType, Level level) {
        super(entityType, level);
        boomerangItem = item.getDefaultInstance();
        setNoGravity(true);
        TOOL_MODULE = toolModule;
        IS_VALID = false;
    }

    public ThrownBoomerang(ToolModuleItem toolModule, EntityType<? extends ThrownBoomerang> entityType, Level level, LivingEntity shooter, ItemStack stack) {
        super(entityType, shooter, level);
        boomerangItem = stack.copy();
        entityData.set(ID_FOIL, stack.hasFoil());
        setNoGravity(true);
        TOOL_MODULE = toolModule;
        IS_VALID = true;
    }

    @Override
    public void shootFromRotation(Entity shooter, float x, float y, float z, float velocity, float inaccuracy) {
        super.shootFromRotation(shooter, x, y, z, velocity, inaccuracy);

        origin = position();
        initialSpeed = velocity;
        phase = Phase.INITIAL;

        setOwner(shooter);
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public float getPickRadius() {
        return 1.0f;
    }

    @Override
    public boolean isAttackable() {
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (!level().isClientSide) {
            spawnAtLocation(getPickupItem(), 0.1f);
            discard();

            if (source.getEntity() instanceof ServerPlayer serverPlayer) {
                AllCriterionTriggers.BOOMERANG_STOPPED.trigger(serverPlayer);
            }
        }

        return super.hurt(source, amount);
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (!level().isClientSide) {
            player.getInventory().placeItemBackInInventory(getPickupItem());
            discard();

            if (player instanceof ServerPlayer serverPlayer) {
                AllCriterionTriggers.BOOMERANG_CAUGHT.trigger(serverPlayer);
            }
        }
        return InteractionResult.sidedSuccess(level().isClientSide);
    }

    @Override
    protected void defineSynchedData() {
        entityData.define(ID_FOIL, false);
    }

    @Override
    public void tick() {
        if (!level().isClientSide && !IS_VALID) {
            spawnAtLocation(getPickupItem(), 0.1f);
            discard();

            super.tick();
            setRotation();
            return;
        }

        if (inGround) {
            if (!level().isClientSide) {
                spawnAtLocation(getPickupItem(), 0.1f);
                discard();
            }

            super.tick();
            setRotation();
            return;
        }

        if (origin == null || level().isClientSide) {
            super.tick();
            setRotation();
            return;
        }

        if (phase == Phase.INITIAL) {
            if (position().subtract(origin).lengthSqr() >= 10.0) {
                phase = Phase.SLOWING_DOWN;
            }
        } else if (phase == Phase.SLOWING_DOWN) {
            setDeltaMovement(getDeltaMovement().scale(0.8));

            if (getDeltaMovement().lengthSqr() <= 0.0025) {
                setDeltaMovement(getDeltaMovement().normalize().scale(0.05).reverse());

                phase = Phase.SPEEDING_UP;
            }
        } else if (phase == Phase.SPEEDING_UP) {
            setDeltaMovement(getDeltaMovement().scale(1.2));

            if (getDeltaMovement().lengthSqr() >= initialSpeed * initialSpeed) {
                setDeltaMovement(getDeltaMovement().normalize().scale(initialSpeed));

                atReturning = position().subtract(origin);

                phase = Phase.RETURNING;
            }
        } else if (phase == Phase.RETURNING) {
            if (position().subtract(origin).dot(atReturning) < 0.0) {
                setNoGravity(false);

                phase = Phase.FALLING;
            }
        }

        super.tick();
        setRotation();
    }

    @Override
    protected ItemStack getPickupItem() {
        return boomerangItem.copy();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        BlockPos blockPos = result.getBlockPos();
        BlockEntity blockEntity = level().getBlockEntity(blockPos);
        if (!(blockEntity instanceof SandMoldBlockEntity sandMoldBlockEntity) || !sandMoldBlockEntity.isCompatible(TOOL_MODULE.getType())) {
            return;
        }

        CompoundTag toolModulesNbt = sandMoldBlockEntity.getToolModulesNbt();
        if (!toolModulesNbt.contains(TOOL_MODULE.getType().getTag(), Tag.TAG_COMPOUND)) {
            for (String key : toolModulesNbt.getAllKeys()) {
                if (ToolUtils.MoldSlotState.fromName(toolModulesNbt.getCompound(key).getString("state")) == ToolUtils.MoldSlotState.FLUID) {
                    return;
                }
            }
        }
        ToolUtils.MoldSlot slot = ToolUtils.getMoldSlot(toolModulesNbt, TOOL_MODULE.getType().getTag());
        if (slot.state() == ToolUtils.MoldSlotState.EMPTY || slot.state() == ToolUtils.MoldSlotState.SOLID) {
            if (!level().isClientSide) {
                if (slot.state() == ToolUtils.MoldSlotState.SOLID) {
                    ToolModuleItem toolModule = (ToolModuleItem) slot.contents();
                    if (toolModule != null) {
                        Containers.dropItemStack(level(), blockPos.getX(), blockPos.getY(), blockPos.getZ(), toolModule.getDefaultInstance());
                    }
                }
                sandMoldBlockEntity.putToolModule(TOOL_MODULE.getType(), TOOL_MODULE, boomerangItem.getTag());
            }
            SoundEvent toolModuleSound = TOOL_MODULE.getSound();
            if (toolModuleSound != null) {
                level().playSound(null, blockPos, toolModuleSound, SoundSource.BLOCKS, 0.5f, 0.8f);
            }
            boolean isNewToolModuleEnchanted = boomerangItem.isEnchanted();
            if (isNewToolModuleEnchanted) {
                level().playSound(null, blockPos, AllSoundEvents.ENCHANTED_TOOL_MODULE, SoundSource.BLOCKS, 0.5f, 0.8f);
            }
            BaseSandMoldBlock.playMoldSlotSound(level(), blockPos, null, slot.state() == ToolUtils.MoldSlotState.SOLID, isNewToolModuleEnchanted ? null : slot.tag());
        }

        discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity target = result.getEntity();
        float f = getAttackDamage();
        if (target instanceof LivingEntity livingTarget) {
            f += EnchantmentHelper.getDamageBonus(boomerangItem, livingTarget.getMobType());
        }

        if (!level().isClientSide && target instanceof ThrownBoomerang) {
            spawnAtLocation(getPickupItem(), 0.1f);
            discard();
        }

        Entity owner = getOwner();
        DamageSource damageSource = owner == null ? passiveDamageSource(level(), this, this) : owner == target ? passiveDamageSource(level(), this, owner) : activeDamageSource(level(), this, owner);
        if (target.hurt(damageSource, f)) {
            if (target.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (target instanceof LivingEntity livingTarget) {
                if (owner instanceof LivingEntity livingOwner) {
                    EnchantmentHelper.doPostHurtEffects(livingTarget, owner);
                    EnchantmentHelper.doPostDamageEffects(livingOwner, livingTarget);
                }

                doPostHurtEffects(livingTarget);

                if (getOwner() instanceof ServerPlayer serverPlayer) {
                    AllCriterionTriggers.BOOMERANG_HIT_ENTITY.trigger(serverPlayer);
                }
            }
        }

        playSound(SoundEvents.TRIDENT_HIT, 1.0f, 1.0f);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.put("Boomerang", boomerangItem.save(new CompoundTag()));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("Boomerang", Tag.TAG_COMPOUND)) {
            boomerangItem = ItemStack.of(nbt.getCompound("Boomerang"));
        }
    }

    @Override
    public boolean shouldRender(double x, double y, double z) {
        return true;
    }

    public boolean isFoil() {
        return entityData.get(ID_FOIL);
    }

    public static DamageSource passiveDamageSource(Level level, Entity causingEntity, Entity directEntity) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(AllDamageTypes.PASSIVE_BOOMERANG), causingEntity, directEntity);
    }

    public static DamageSource activeDamageSource(Level level, Entity causingEntity, Entity directEntity) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(AllDamageTypes.ACTIVE_BOOMERANG), causingEntity, directEntity);
    }

    protected void setRotation() {
        if (!isCustomRotSet) {
            customXRot = xRotO;
            customYRot = yRotO;
            isCustomRotSet = true;
        }

        customYaw += 50.0f;
    }

    public float getCustomXRot() {
        return customXRot;
    }

    public float getCustomYRot() {
        return customYRot;
    }

    public float getCustomYaw() {
        return customYaw;
    }

    protected abstract float getAttackDamage();

    public enum Phase {
        INITIAL,
        SLOWING_DOWN,
        SPEEDING_UP,
        RETURNING,
        FALLING
    }
}
