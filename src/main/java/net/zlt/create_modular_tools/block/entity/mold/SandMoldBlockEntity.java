package net.zlt.create_modular_tools.block.entity.mold;

import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.utility.Components;
import com.simibubi.create.foundation.utility.Lang;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.item.mold.BaseSandMoldItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRecipeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class SandMoldBlockEntity extends BlockEntity implements IHaveGoggleInformation {
    public static final String TOOL_MODULES_TAG = "ToolModules";

    protected CompoundTag toolModulesNbt;

    public SandMoldBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        clearToolModules();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put(TOOL_MODULES_TAG, toolModulesNbt);
    }

    @Override
    public void load(CompoundTag tag) {
        toolModulesNbt = tag.contains(TOOL_MODULES_TAG, Tag.TAG_COMPOUND) ? tag.getCompound(TOOL_MODULES_TAG) : getDefaultToolModulesNbt();
        fixToolModulesNbt();
        updateBlockStateLightLevel();
    }

    @Override
    @Nullable
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        Lang.builder(CreateModularTools.ID)
            .translate("hint.mold.modular_tool_type")
            .add(CommonComponents.space())
            .add(getName().plainCopy())
            .forGoggles(tooltip);

        for (ToolModuleType toolModuleType : getCompatible()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() == ToolUtils.MoldSlotState.ABSENT) {
                continue;
            }

            Lang.builder(CreateModularTools.ID)
                .add(toolModuleType.getName().plainCopy())
                .text(":")
                .style(ChatFormatting.GRAY)
                .forGoggles(tooltip);

            if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID) {
                ToolModule toolModule = (ToolModule) moldSlot.contents();

                Lang.builder(CreateModularTools.ID)
                    .space()
                    .add(toolModule.getDisplayName().plainCopy())
                    .style(ChatFormatting.GRAY)
                    .forGoggles(tooltip);

                if (isPlayerSneaking) {
                    for (MutableComponent component : toolModule.getDescription()) {
                        Lang.builder(CreateModularTools.ID)
                            .space()
                            .add(component)
                            .forGoggles(tooltip);
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                Fluid fluid = (Fluid) moldSlot.contents();
                ToolModule toolModule = ToolModuleRecipeRegistry.get(toolModuleType, fluid);
                if (toolModule != null) {
                    Lang.builder(CreateModularTools.ID)
                        .space()
                        .add(Components.translatable(fluid.defaultFluidState().createLegacyBlock().getBlock().getDescriptionId()))
                        .style(ChatFormatting.GRAY)
                        .forGoggles(tooltip);

                    if (isPlayerSneaking) {
                        for (MutableComponent component : toolModule.getDescription()) {
                            Lang.builder(CreateModularTools.ID)
                                .space()
                                .add(component)
                                .forGoggles(tooltip);
                        }
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                Lang.builder(CreateModularTools.ID)
                    .space()
                    .translate("hint.mold.empty_slot")
                    .style(ChatFormatting.GRAY)
                    .forGoggles(tooltip);
            }
        }

        return true;
    }

    public void putToolModule(ToolModuleType toolModuleType, @Nullable ToolModule toolModule) {
        if (isCompatible(toolModuleType)) {
            toolModulesNbt.putString(toolModuleType.getTag(), toolModule == null ? "" : toolModule.getId());
            fixToolModulesNbt();
            setChanged();
            updateBlockStateLightLevel();
        }
    }

    public void removeToolModule(ToolModuleType toolModuleType) {
        if (isCompatible(toolModuleType)) {
            toolModulesNbt.remove(toolModuleType.getTag());
            fixToolModulesNbt();
            setChanged();
            updateBlockStateLightLevel();
        }
    }

    public void clearToolModules() {
        toolModulesNbt = getDefaultToolModulesNbt();
        fixToolModulesNbt();
        setChanged();
        updateBlockStateLightLevel();
    }

    @Unmodifiable
    public CompoundTag getToolModulesNbt() {
        return toolModulesNbt;
    }

    public abstract Component getName();

    public abstract Collection<ToolModuleType> getCompatible();

    public abstract Collection<ToolModuleType> getRequired();

    public abstract boolean isCompatible(ToolModuleType toolModuleType);

    protected abstract CompoundTag getDefaultToolModulesNbt();

    protected void updateBlockStateLightLevel() {
        if (level == null || level.isClientSide) {
            return;
        }

        int lightLevel = 0;
        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag);
            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                continue;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                lightLevel += 3;
            }
        }
        lightLevel = Math.min(15, lightLevel);

        BlockState blockState = getBlockState();
        if (blockState.getValue(SandMoldBlock.LIGHT_LEVEL) != lightLevel) {
            level.setBlock(getBlockPos(), getBlockState().setValue(SandMoldBlock.LIGHT_LEVEL, lightLevel), 23);
        }
    }

    protected void fixToolModulesNbt() {
        boolean hasEmptySlots = false;
        List<String> fluidSlots = new ArrayList<>();
        Set<Fluid> fluids = new HashSet<>();

        for (String toolModuleTypeTag : toolModulesNbt.getAllKeys()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleTypeTag);
            if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                hasEmptySlots = true;
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                Fluid fluid = (Fluid) moldSlot.contents();

                if (BaseSandMoldItem.canBeFilledWith(fluid)) {
                    fluidSlots.add(toolModuleTypeTag);
                    fluids.add(fluid);
                } else {
                    toolModulesNbt.putString(toolModuleTypeTag, "");
                    hasEmptySlots = true;
                }
            }
        }

        if (!fluidSlots.isEmpty() && (hasEmptySlots || fluids.size() > 1)) {
            for (String fluid : fluidSlots) {
                toolModulesNbt.putString(fluid, "");
            }
        }

        for (ToolModuleType toolModuleType : getRequired()) {
            if (!(toolModulesNbt.contains(toolModuleType.getTag(), Tag.TAG_STRING))) {
                toolModulesNbt.putString(toolModuleType.getTag(), "");
            }
        }
    }
}
