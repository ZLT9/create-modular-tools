package net.zlt.create_modular_tools.tool;

import com.google.common.collect.BiMap;
import com.mojang.datafixers.util.Pair;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.fabricmc.fabric.mixin.content.registry.HoeItemAccessor;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.block.entity.mold.ToolMaterialMoldBlockEntity;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class ToolUtils {
    private ToolUtils() {
    }

    public enum MoldSlotState {
        ABSENT("absent"),
        EMPTY("empty"),
        SOLID("solid"),
        FLUID("fluid");

        private final String name;

        MoldSlotState(String name) {
            this.name = name;
        }

        @Nullable
        public static MoldSlotState fromName(String name) {
            for (MoldSlotState state : MoldSlotState.values()) {
                if (state.name.equals(name)) {
                    return state;
                }
            }

            return null;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public record MoldSlot(MoldSlotState state, @Nullable Object contents, @Nullable CompoundTag tag) {
    }

    public static MoldSlot getMoldSlot(CompoundTag toolModulesNbt, String toolModuleTypeTag) {
        if (!toolModulesNbt.contains(toolModuleTypeTag, Tag.TAG_COMPOUND)) {
            return new MoldSlot(MoldSlotState.ABSENT, null, null);
        }

        CompoundTag slotNbt = toolModulesNbt.getCompound(toolModuleTypeTag);
        MoldSlotState slotState = MoldSlotState.fromName(slotNbt.getString(AllTagNames.MOLD_SLOT_STATE));
        String slotContentsId = slotNbt.getString(AllTagNames.TOOL_MODULE_ID);

        if (slotState == MoldSlotState.EMPTY) {
            return new MoldSlot(MoldSlotState.EMPTY, null, null);
        }

        if (slotState == MoldSlotState.SOLID) {
            return new MoldSlot(MoldSlotState.SOLID, ToolModuleRegistry.get(slotContentsId), slotNbt.contains("tag", Tag.TAG_COMPOUND) ? slotNbt.getCompound("tag") : null);
        }

        if (slotState == MoldSlotState.FLUID) {
            return new MoldSlot(MoldSlotState.FLUID, BuiltInRegistries.FLUID.get(new ResourceLocation(slotContentsId)), null);
        }

        return new MoldSlot(null, null, null);
    }

    public static MoldSlot getMoldSlot(CompoundTag toolModulesNbt, ToolModuleType toolModuleType) {
        return getMoldSlot(toolModulesNbt, toolModuleType.getTag());
    }

    public static CompoundTag getToolModulesNbt(ItemStack stack) {
        CompoundTag nbt = stack.getTag();
        return nbt == null || nbt.isEmpty() ? new CompoundTag() : nbt.getCompound(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG);
    }

    public static CompoundTag getToolModulesNbt(@Nullable CompoundTag nbt) {
        if (nbt == null || nbt.isEmpty()) {
            return new CompoundTag();
        }

        CompoundTag blockEntityNbt = nbt.getCompound(BlockItem.BLOCK_ENTITY_TAG);
        return blockEntityNbt.isEmpty() ? new CompoundTag() : blockEntityNbt.getCompound(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG);
    }

    public static boolean didBlockChange(BlockState originalBlockState, UseOnContext context) {
        return context.getLevel().getBlockState(context.getClickedPos()) != originalBlockState;
    }

    public static InteractionResult wrenchOnUse(BlockState originalBlockState, UseOnContext context) {
        if (didBlockChange(originalBlockState, context)) {
            return InteractionResult.PASS;
        }

        Player player = context.getPlayer();
        if (player == null || !player.mayBuild()) {
            return InteractionResult.PASS;
        }

        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        Block block = blockState.getBlock();

        if (block instanceof IWrenchable wrenchable) {
            return player.isShiftKeyDown() ? wrenchable.onSneakWrenched(blockState, context) : wrenchable.onWrenched(blockState, context);
        }

        if (player.isShiftKeyDown() && AllTags.AllBlockTags.WRENCH_PICKUP.matches(blockState)) {
            if (level instanceof ServerLevel serverLevel) {
                if (!player.isCreative()) {
                    Block.getDrops(blockState, serverLevel, blockPos, level.getBlockEntity(blockPos), player, context.getItemInHand()).forEach(itemStack -> player.getInventory().placeItemBackInInventory(itemStack));
                }

                blockState.spawnAfterBreak(serverLevel, blockPos, ItemStack.EMPTY, true);
                level.destroyBlock(blockPos, false);
                AllSoundEvents.WRENCH_REMOVE.playOnServer(level, blockPos, 1.0f, level.getRandom().nextFloat() * 0.5f + 0.5f);
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public static InteractionResult shovelOnUse(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        if (didBlockChange(originalBlockState, context)) {
            return InteractionResult.PASS;
        }

        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);

        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        }

        Player player = context.getPlayer();
        BlockState blockState2 = ShovelItem.FLATTENABLES.get(blockState.getBlock());
        BlockState blockState3 = null;

        if (blockState2 != null && level.getBlockState(blockPos.above()).isAir()) {
            level.playSound(player, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0f, 1.0f);
            blockState3 = blockState2;
        } else if (blockState.getBlock() instanceof CampfireBlock && blockState.getValue(CampfireBlock.LIT)) {
            if (!level.isClientSide) {
                level.levelEvent(null, 1009, blockPos, 0);
            }

            CampfireBlock.dowse(player, level, blockPos, blockState);
            blockState3 = blockState.setValue(CampfireBlock.LIT, Boolean.FALSE);
        }

        if (blockState3 != null) {
            if (!level.isClientSide) {
                level.setBlock(blockPos, blockState3, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, blockState3));

                if (player != null) {
                    modularTool.hurtAndBreak(context.getItemInHand(), 1, player, context.getHand());
                }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    public static InteractionResult axeOnUse(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        if (didBlockChange(originalBlockState, context)) {
            return InteractionResult.PASS;
        }

        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState blockState = level.getBlockState(blockPos);
        Optional<BlockState> optional = axeGetStripped(blockState);
        Optional<BlockState> optional2 = WeatheringCopper.getPrevious(blockState);
        Optional<BlockState> optional3 = Optional.ofNullable((Block) ((BiMap<?, ?>) HoneycombItem.WAX_OFF_BY_BLOCK.get()).get(blockState.getBlock()))
            .map(block -> block.withPropertiesOf(blockState));
        ItemStack itemStack = context.getItemInHand();
        Optional<BlockState> optional4 = Optional.empty();
        if (optional.isPresent()) {
            level.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            optional4 = optional;
        } else if (optional2.isPresent()) {
            level.playSound(player, blockPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.levelEvent(player, 3005, blockPos, 0);
            optional4 = optional2;
        } else if (optional3.isPresent()) {
            level.playSound(player, blockPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.levelEvent(player, 3004, blockPos, 0);
            optional4 = optional3;
        }

        if (optional4.isPresent()) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, itemStack);
            }

            level.setBlock(blockPos, optional4.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, optional4.get()));

            if (player != null) {
                modularTool.hurtAndBreak(itemStack, 1, player, context.getHand());
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @SuppressWarnings({"UnreachableCode", "UnstableApiUsage"})
    public static InteractionResult hoeOnUse(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        if (didBlockChange(originalBlockState, context)) {
            return InteractionResult.PASS;
        }

        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = HoeItemAccessor.getTillingActions().get(level.getBlockState(blockPos).getBlock());
        if (pair == null) {
            return InteractionResult.PASS;
        }

        Predicate<UseOnContext> predicate = pair.getFirst();
        Consumer<UseOnContext> consumer = pair.getSecond();
        if (predicate.test(context)) {
            Player player = context.getPlayer();
            level.playSound(player, blockPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!level.isClientSide) {
                consumer.accept(context);
                if (player != null) {
                    modularTool.hurtAndBreak(context.getItemInHand(), 1, player, context.getHand());
                }
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    public static Optional<BlockState> axeGetStripped(BlockState unstrippedState) {
        return Optional.ofNullable(AxeItem.STRIPPABLES.get(unstrippedState.getBlock()))
            .map(block -> block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, unstrippedState.getValue(RotatedPillarBlock.AXIS)));
    }

    public static boolean canReplaceByDiggerModularTool(Mob mob, ItemStack candidate, ItemStack existing) {
        Item existingItem = existing.getItem();

        if (existingItem instanceof BlockItem) {
            return true;
        }

        float existingAttackDamage;
        if (existingItem instanceof DiggerItem existingDiggerItem) {
            existingAttackDamage = existingDiggerItem.getAttackDamage();
        } else if (existingItem instanceof ModularToolItem existingModularTool && existingModularTool.canBeReplacedByModularTool(candidate)) {
            existingAttackDamage = existingModularTool.getAttackDamage(existing);
        } else {
            return false;
        }

        float attackDamage = ((ModularToolItem) candidate.getItem()).getAttackDamage(candidate);
        if (attackDamage != existingAttackDamage) {
            return attackDamage > existingAttackDamage;
        }

        return mob.canReplaceEqualItem(candidate, existing);
    }

    public static boolean canDiggerModularToolBeReplacedBy(Mob mob, ItemStack candidate, ItemStack existing) {
        Item candidateItem = candidate.getItem();

        if (candidateItem instanceof SwordItem) {
            return true;
        }

        if (candidateItem instanceof DiggerItem candidateDigger) {
            float attackDamage = ((ModularToolItem) existing.getItem()).getAttackDamage(existing);
            float candidateAttackDamage = candidateDigger.getAttackDamage();
            if (candidateAttackDamage != attackDamage) {
                return candidateAttackDamage > attackDamage;
            }

            return mob.canReplaceEqualItem(candidate, existing);
        }

        return false;
    }
}
