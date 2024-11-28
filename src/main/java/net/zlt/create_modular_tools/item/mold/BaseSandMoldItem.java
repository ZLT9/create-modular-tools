package net.zlt.create_modular_tools.item.mold;

import com.google.common.collect.Maps;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.BaseSandMoldBlock;
import net.zlt.create_modular_tools.fluid.MoltenMetalFluid;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.mold.MoldRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRecipeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleTypeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleUtils;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseSandMoldItem extends BlockItem {
    public BaseSandMoldItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            return;
        }

        boolean isShiftDown = Screen.hasShiftDown();

        Map<Enchantment, List<Integer>> resultEnchantments = Maps.newHashMap();
        Set<MutableComponent> resultFeatures = new HashSet<>();
        for (ToolModuleType toolModuleType : getCompatibleToolModuleTypes()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() == ToolUtils.MoldSlotState.ABSENT) {
                continue;
            }

            if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID) {
                ToolModuleItem toolModule = (ToolModuleItem) moldSlot.contents();

                tooltipComponents.add(toolModuleType.getName().plainCopy().append(Component.literal(":")).append(CommonComponents.space()).append(toolModule == null ? Components.translatable("create_modular_tools.hint.mold.unknown") : toolModule.getDescription()).withStyle(ChatFormatting.GRAY));

                CompoundTag slotContentsTag = moldSlot.tag();

                if (resultEnchantments != null && slotContentsTag != null) {
                    resultEnchantments = ToolModuleUtils.mergeEnchantments(resultEnchantments, EnchantmentHelper.deserializeEnchantments(slotContentsTag.getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND)));
                }

                if (toolModule != null) {
                    resultFeatures.addAll(toolModule.getFeaturesDescription());

                    if (isShiftDown) {
                        for (MutableComponent component : toolModule.getStatsDescription(slotContentsTag)) {
                            tooltipComponents.add(CommonComponents.space().append(component));
                        }
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                Fluid fluid = (Fluid) moldSlot.contents();
                tooltipComponents.add(toolModuleType.getName().plainCopy().append(Component.literal(":")).append(CommonComponents.space()).append(Components.translatable(fluid == null ? "create_modular_tools.hint.mold.unknown" : fluid.defaultFluidState().createLegacyBlock().getBlock().getDescriptionId())).withStyle(ChatFormatting.GRAY));

                ToolModuleItem toolModule = ToolModuleRecipeRegistry.get(toolModuleType, fluid);
                if (toolModule != null) {
                    resultFeatures.addAll(toolModule.getFeaturesDescription());

                    if (isShiftDown) {
                        for (MutableComponent component : toolModule.getStatsDescription(null)) {
                            tooltipComponents.add(CommonComponents.space().append(component));
                        }
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                tooltipComponents.add(toolModuleType.getName().plainCopy().append(Component.literal(":")).append(CommonComponents.space()).append(Components.translatable("create_modular_tools.hint.mold.empty_slot")).withStyle(ChatFormatting.GRAY));
            }
        }

        if (isShiftDown && !resultFeatures.isEmpty()) {
            tooltipComponents.add(Components.translatable("create_modular_tools.hint.mold.resulting_features").append(Components.literal(":")).withStyle(ChatFormatting.GRAY));

            for (MutableComponent feature : resultFeatures) {
                tooltipComponents.add(feature.withStyle(ChatFormatting.GRAY));
            }
        }

        if (resultEnchantments == null) {
            tooltipComponents.add(Component.translatable("create_modular_tools.hint.mold.incompatible_enchantments").withStyle(ChatFormatting.RED));
        } else if (isShiftDown && !resultEnchantments.isEmpty()) {
            tooltipComponents.add(Component.translatable("create_modular_tools.hint.mold.resulting_enchantments").append(Component.literal(":")).withStyle(ChatFormatting.GRAY));
            resultEnchantments.forEach((enchantment, levels) -> tooltipComponents.add(CommonComponents.space().append(enchantment.getFullname(levels.get(0))).withStyle(ChatFormatting.GRAY)));
        }
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);

        CompoundTag nbt = stack.getOrCreateTag();
        nbt.putUUID("UUID", UUID.randomUUID());

        CompoundTag blockEntityNbt = new CompoundTag();
        nbt.put(BlockItem.BLOCK_ENTITY_TAG, blockEntityNbt);

        CompoundTag toolModulesNbt = new CompoundTag();
        blockEntityNbt.put(SandMoldBlockEntity.TOOL_MODULES_TAG, toolModulesNbt);

        for (ToolModuleType toolModuleType : getRequiredToolModuleTypes()) {
            CompoundTag slotNbt = new CompoundTag();
            slotNbt.putString("state", ToolUtils.MoldSlotState.EMPTY.toString());
            toolModulesNbt.put(toolModuleType.getTag(), slotNbt);
        }

        return stack;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        if (super.isFoil(stack)) {
            return true;
        }

        if (!(getBlock() instanceof BaseSandMoldBlock moldBlock)) {
            return false;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack.getTag());
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        for (String key : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(key);
            if (toolModuleType == null || !MoldRegistry.isCompatible(moldBlock.getModularTool(), toolModuleType)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(key);
            if (ToolUtils.MoldSlotState.fromName(slotNbt.getString("state")) == ToolUtils.MoldSlotState.SOLID && !slotNbt.getCompound("tag").getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND).isEmpty()) {
                return true;
            }
        }

        return false;
    }

    protected abstract Collection<ToolModuleType> getRequiredToolModuleTypes();

    protected abstract Collection<ToolModuleType> getCompatibleToolModuleTypes();

    public static boolean canBeFilledWith(@Nullable Fluid fluid) {
        return fluid instanceof MoltenMetalFluid || fluid == Fluids.LAVA;
    }
}
