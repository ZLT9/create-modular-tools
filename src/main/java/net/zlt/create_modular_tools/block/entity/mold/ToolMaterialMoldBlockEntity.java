package net.zlt.create_modular_tools.block.entity.mold;

import com.google.common.collect.Maps;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.zlt.create_modular_tools.AllTags;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;
import net.zlt.create_modular_tools.item.mold.ToolMaterialMoldItem;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.mold.MoldRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRecipeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleUtils;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolMaterialMoldBlockEntity extends BlockEntity implements IHaveGoggleInformation {
    public static final String TOOL_MODULES_TAG = "ToolModules";

    protected CompoundTag toolModulesNbt;

    public ToolMaterialMoldBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
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

        Map<Enchantment, List<Integer>> resultEnchantments = Maps.newHashMap();
        Set<MutableComponent> resultFeatures = new HashSet<>();
        for (ToolModuleType toolModuleType : MoldRegistry.getCompatible(getModularTool())) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() == ToolUtils.MoldSlotState.ABSENT) {
                continue;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID) {
                ToolModuleItem toolModule = (ToolModuleItem) moldSlot.contents();

                Lang.builder(CreateModularTools.ID)
                    .add(toolModuleType.getName().plainCopy())
                    .text(":")
                    .space()
                    .add(toolModule == null ? Components.translatable("create_modular_tools.hint.mold.unknown") : toolModule.getDescription().plainCopy())
                    .style(ChatFormatting.GRAY)
                    .forGoggles(tooltip);

                CompoundTag slotContentsTag = moldSlot.tag();

                if (resultEnchantments != null && slotContentsTag != null) {
                    resultEnchantments = ToolModuleUtils.mergeEnchantments(resultEnchantments, EnchantmentHelper.deserializeEnchantments(slotContentsTag.getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND)));
                }

                if (toolModule != null) {
                    resultFeatures.addAll(toolModule.getFeaturesDescription());

                    if (isPlayerSneaking) {
                        for (MutableComponent component : toolModule.getStatsDescription(slotContentsTag)) {
                            Lang.builder(CreateModularTools.ID)
                                .add(component)
                                .forGoggles(tooltip);
                        }
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                Fluid fluid = (Fluid) moldSlot.contents();
                Lang.builder(CreateModularTools.ID)
                    .add(toolModuleType.getName().plainCopy())
                    .text(":")
                    .space()
                    .add(Components.translatable(fluid == null ? "create_modular_tools.hint.mold.unknown" : fluid.defaultFluidState().createLegacyBlock().getBlock().getDescriptionId()))
                    .style(ChatFormatting.GRAY)
                    .forGoggles(tooltip);

                ToolModuleItem toolModule = ToolModuleRecipeRegistry.get(toolModuleType, fluid);
                if (toolModule != null) {
                    resultFeatures.addAll(toolModule.getFeaturesDescription());

                    if (isPlayerSneaking) {
                        for (MutableComponent component : toolModule.getStatsDescription(null)) {
                            Lang.builder(CreateModularTools.ID)
                                .add(component)
                                .forGoggles(tooltip);
                        }
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                Lang.builder(CreateModularTools.ID)
                    .add(toolModuleType.getName().plainCopy())
                    .text(":")
                    .space()
                    .translate("hint.mold.empty_slot")
                    .style(ChatFormatting.GRAY)
                    .forGoggles(tooltip);
            }
        }

        if (isPlayerSneaking && !resultFeatures.isEmpty()) {
            Lang.builder(CreateModularTools.ID)
                .translate("hint.mold.resulting_features")
                .text(":")
                .style(ChatFormatting.GRAY)
                .forGoggles(tooltip);

            for (MutableComponent feature : resultFeatures) {
                Lang.builder(CreateModularTools.ID)
                    .add(feature)
                    .style(ChatFormatting.GRAY)
                    .forGoggles(tooltip);
            }
        }

        if (resultEnchantments == null) {
            Lang.builder(CreateModularTools.ID)
                .translate("hint.mold.incompatible_enchantments")
                .style(ChatFormatting.RED)
                .forGoggles(tooltip);
        } else if (isPlayerSneaking && !resultEnchantments.isEmpty()) {
            Lang.builder(CreateModularTools.ID)
                .translate("hint.mold.resulting_enchantments")
                .text(":")
                .style(ChatFormatting.GRAY)
                .forGoggles(tooltip);

            resultEnchantments.forEach((enchantment, levels) ->
                Lang.builder(CreateModularTools.ID)
                    .add(CommonComponents.space().append(enchantment.getFullname(levels.get(0))))
                    .style(ChatFormatting.GRAY)
                    .forGoggles(tooltip)
            );
        }

        return true;
    }

    public void putToolModule(ToolModuleType toolModuleType, @Nullable ToolModuleItem toolModule, @Nullable CompoundTag toolModuleNbt) {
        if (MoldRegistry.isCompatible(getModularTool(), toolModuleType)) {
            CompoundTag slotNbt = new CompoundTag();
            if (toolModule == null) {
                slotNbt.putString(AllTags.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.EMPTY.toString());
            } else {
                slotNbt.putString(AllTags.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.SOLID.toString());
                slotNbt.putString(AllTags.TOOL_MODULE_ID, toolModule.getId());
                if (toolModuleNbt != null) {
                    slotNbt.put("tag", toolModuleNbt);
                }
            }
            toolModulesNbt.put(toolModuleType.getTag(), slotNbt);
            fixToolModulesNbt();
            setChanged();
            updateBlockStateLightLevel();
        }
    }

    public void removeToolModule(ToolModuleType toolModuleType) {
        if (MoldRegistry.isCompatible(getModularTool(), toolModuleType)) {
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

    public Component getName() {
        return getModularTool().getToolCategorySingularName();
    }

    protected CompoundTag getDefaultToolModulesNbt() {
        CompoundTag toolModulesNbt = new CompoundTag();
        for (ToolModuleType toolModuleType : MoldRegistry.getRequired(getModularTool())) {
            CompoundTag slotNbt = new CompoundTag();
            slotNbt.putString(AllTags.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.EMPTY.toString());
            toolModulesNbt.put(toolModuleType.getTag(), slotNbt);
        }
        return toolModulesNbt;
    }

    public abstract ModularToolItem getModularTool();

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
        if (blockState.getValue(MaterialMoldBlock.LIGHT_LEVEL) != lightLevel) {
            level.setBlock(getBlockPos(), getBlockState().setValue(MaterialMoldBlock.LIGHT_LEVEL, lightLevel), 23);
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

                if (ToolMaterialMoldItem.canBeFilledWith(fluid)) {
                    fluidSlots.add(toolModuleTypeTag);
                    fluids.add(fluid);
                } else {
                    CompoundTag slotNbt = new CompoundTag();
                    slotNbt.putString(AllTags.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.EMPTY.toString());
                    toolModulesNbt.put(toolModuleTypeTag, slotNbt);
                    hasEmptySlots = true;
                }
            }
        }

        if (!fluidSlots.isEmpty() && (hasEmptySlots || fluids.size() > 1)) {
            for (String fluid : fluidSlots) {
                CompoundTag slotNbt = new CompoundTag();
                slotNbt.putString(AllTags.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.EMPTY.toString());
                toolModulesNbt.put(fluid, slotNbt);
            }
        }

        for (ToolModuleType toolModuleType : MoldRegistry.getRequired(getModularTool())) {
            if (!(toolModulesNbt.contains(toolModuleType.getTag(), Tag.TAG_COMPOUND))) {
                CompoundTag slotNbt = new CompoundTag();
                slotNbt.putString(AllTags.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.EMPTY.toString());
                toolModulesNbt.put(toolModuleType.getTag(), slotNbt);
            }
        }
    }
}
