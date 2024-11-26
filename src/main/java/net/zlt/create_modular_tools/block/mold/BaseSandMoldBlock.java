package net.zlt.create_modular_tools.block.mold;

import com.simibubi.create.content.kinetics.deployer.DeployerFakePlayer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.sound.AllSoundEvents;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseSandMoldBlock extends SandMoldBlock implements EntityBlock {
    public BaseSandMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!(level.getBlockEntity(pos) instanceof SandMoldBlockEntity sandMoldBlockEntity)) {
            return InteractionResult.PASS;
        }

        ItemStack stack = player.getItemInHand(hand);
        if (!stack.isEmpty()) {
            CompoundTag toolModulesNbt = sandMoldBlockEntity.getToolModulesNbt();

            if (stack.getItem() instanceof ToolModuleItem toolModule) {
                if (!sandMoldBlockEntity.isCompatible(toolModule.getType())) {
                    return InteractionResult.PASS;
                }

                if (!toolModulesNbt.contains(toolModule.getType().getTag(), Tag.TAG_COMPOUND)) {
                    for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
                        if (ToolUtils.MoldSlotState.fromName(toolModulesNbt.getCompound(toolModuleTypeTag).getString("state")) == ToolUtils.MoldSlotState.FLUID) {
                            return InteractionResult.PASS;
                        }
                    }
                }

                ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModule.getType());
                if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                    return InteractionResult.PASS;
                }

                if (!level.isClientSide) {
                    if (!player.isCreative()) {
                        stack.shrink(1);
                        if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID && moldSlot.contents() != null) {
                            ItemStack returnedToolModuleStack = ((ToolModuleItem) moldSlot.contents()).getDefaultInstance();
                            returnedToolModuleStack.setTag(moldSlot.tag());
                            player.getInventory().placeItemBackInInventory(returnedToolModuleStack);
                        }
                    }
                    sandMoldBlockEntity.putToolModule(toolModule.getType(), toolModule, stack.getTag());
                }

                SoundEvent toolModuleSound = toolModule.getSound();
                if (toolModuleSound != null) {
                    level.playSound(player, pos, toolModuleSound, SoundSource.BLOCKS, 0.5f, 0.8f);
                }

                boolean isNewToolModuleEnchanted = stack.isEnchanted();
                if (isNewToolModuleEnchanted) {
                    level.playSound(player, pos, AllSoundEvents.ENCHANTED_TOOL_MODULE, SoundSource.BLOCKS, 0.5f, 0.8f);
                }

                playMoldSlotSound(level, pos, player, moldSlot.state() == ToolUtils.MoldSlotState.SOLID, isNewToolModuleEnchanted ? null : moldSlot.tag());

                return InteractionResult.sidedSuccess(level.isClientSide);
            }

            for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
                if (ToolUtils.MoldSlotState.fromName(toolModulesNbt.getCompound(toolModuleTypeTag).getString("state")) != ToolUtils.MoldSlotState.EMPTY) {
                    return InteractionResult.PASS;
                }
            }

            return super.use(state, level, pos, player, hand, hit);
        }

        HitCoords hitCoords = getHitCoords(pos, state.getValue(FACING), hit);
        if (hitCoords == null) {
            return InteractionResult.PASS;
        }

        CompoundTag toolModulesNbt = sandMoldBlockEntity.getToolModulesNbt();

        List<ToolModuleType> existingToolModuleTypes = new ArrayList<>();
        Iterator<ToolModuleType> it = getCompatible().descendingIterator();
        while (it.hasNext()) {
            ToolModuleType toolModuleType = it.next();

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() == ToolUtils.MoldSlotState.ABSENT) {
                continue;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                return InteractionResult.PASS;
            }

            existingToolModuleTypes.add(toolModuleType);
        }

        boolean isDeployer = player instanceof DeployerFakePlayer;
        for (ToolModuleType toolModuleType : existingToolModuleTypes) {
            ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(this, toolModulesNbt);
            if (moldTopTexture == null) {
                continue;
            }

            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);

            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY && (isDeployer || isRequired(toolModuleType))) {
                continue;
            }

            if (!isDeployer && !moldTopTexture.clicked(hitCoords.X, hitCoords.Y)) {
                continue;
            }

            if (!level.isClientSide) {
                if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                    sandMoldBlockEntity.removeToolModule(toolModuleType);
                } else if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID) {
                    sandMoldBlockEntity.putToolModule(toolModuleType, null, null);

                    if (!player.isCreative() && moldSlot.contents() != null) {
                        ItemStack returnedToolModuleStack = ((ToolModuleItem) moldSlot.contents()).getDefaultInstance();
                        returnedToolModuleStack.setTag(moldSlot.tag());
                        player.getInventory().placeItemBackInInventory(returnedToolModuleStack);
                    }
                }
            }

            playMoldSlotSound(level, pos, player, moldSlot.state() == ToolUtils.MoldSlotState.SOLID, moldSlot.tag());

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    public static void playMoldSlotSound(Level level, BlockPos pos, @Nullable Player player, boolean isReplacing, @Nullable CompoundTag previousContentsNbt) {
        level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 0.25f, 0.8f);

        if (isReplacing) {
            level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2f, 1.0f + level.random.nextFloat());

            if (previousContentsNbt != null && !previousContentsNbt.getList(ItemStack.TAG_ENCH, CompoundTag.TAG_COMPOUND).isEmpty()) {
                level.playSound(player, pos, AllSoundEvents.ENCHANTED_TOOL_MODULE, SoundSource.BLOCKS, 0.5f, 0.8f);
            }
        }
    }

    public boolean isCompatible(ToolModuleType toolModuleType) {
        return getCompatible().contains(toolModuleType);
    }

    public boolean isRequired(ToolModuleType toolModuleType) {
        return getRequired().contains(toolModuleType);
    }

    @Unmodifiable
    public abstract TreeSet<ToolModuleType> getCompatible();

    @Unmodifiable
    public abstract List<ToolModuleType> getRequired();
}
