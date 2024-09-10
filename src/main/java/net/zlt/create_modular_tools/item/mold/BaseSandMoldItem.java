package net.zlt.create_modular_tools.item.mold;

import com.simibubi.create.foundation.utility.Components;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.fluid.MoltenMetalFluid;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRecipeRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

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

        for (ToolModuleType toolModuleType : getCompatibleToolModuleTypes()) {
            ToolUtils.MoldSlot moldSlot = ToolUtils.getMoldSlot(toolModulesNbt, toolModuleType);
            if (moldSlot.state() == ToolUtils.MoldSlotState.ABSENT) {
                continue;
            }

            tooltipComponents.add(toolModuleType.getName().plainCopy().append(Component.literal(":")).withStyle(ChatFormatting.GRAY));

            if (moldSlot.state() == ToolUtils.MoldSlotState.SOLID) {
                ToolModule toolModule = (ToolModule) moldSlot.contents();

                tooltipComponents.add(CommonComponents.space().append(toolModule.getDisplayName()).withStyle(ChatFormatting.GRAY));

                if (Screen.hasShiftDown()) {
                    for (MutableComponent component : toolModule.getDescription()) {
                        tooltipComponents.add(CommonComponents.space().append(component));
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.FLUID) {
                Fluid fluid = (Fluid) moldSlot.contents();

                ToolModule toolModule = ToolModuleRecipeRegistry.get(toolModuleType, fluid);
                if (toolModule != null) {
                    tooltipComponents.add(CommonComponents.space().append(Components.translatable(fluid.defaultFluidState().createLegacyBlock().getBlock().getDescriptionId())).withStyle(ChatFormatting.GRAY));

                    if (Screen.hasShiftDown()) {
                        for (MutableComponent component : toolModule.getDescription()) {
                            tooltipComponents.add(CommonComponents.space().append(component));
                        }
                    }
                }
            } else if (moldSlot.state() == ToolUtils.MoldSlotState.EMPTY) {
                tooltipComponents.add(CommonComponents.space().append(Components.translatable("create_modular_tools.hint.mold.empty_slot")).withStyle(ChatFormatting.GRAY));
            }
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
            toolModulesNbt.putString(toolModuleType.getTag(), "");
        }

        return stack;
    }

    protected abstract Collection<ToolModuleType> getRequiredToolModuleTypes();

    protected abstract Collection<ToolModuleType> getCompatibleToolModuleTypes();

    public static boolean canBeFilledWith(Fluid fluid) {
        return fluid instanceof MoltenMetalFluid || fluid == Fluids.LAVA;
    }
}
