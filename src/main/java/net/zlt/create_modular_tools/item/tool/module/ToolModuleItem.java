package net.zlt.create_modular_tools.item.tool.module;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.item.TooltipUtils;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ModularToolRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ToolModuleItem extends Item {
    protected final ToolModule TOOL_MODULE;

    public ToolModuleItem(ToolModule toolModule, Properties properties) {
        super(properties);
        TOOL_MODULE = toolModule;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (TooltipUtils.addHoldShift("create_modular_tools.tooltip.holdForAttributes", "create.tooltip.keyShift", tooltipComponents)) {
            tooltipComponents.add(Component.translatable("item.tool_module.create_modular_tools.attachable_to").withStyle(ChatFormatting.GRAY));
            for (ModularToolItem modularTool : ModularToolRegistry.getAll()) {
                if (modularTool.isCompatible(TOOL_MODULE.getType())) {
                    tooltipComponents.add(CommonComponents.space().append(modularTool.getToolCategoryPluralName()).withStyle(ChatFormatting.GRAY));
                }
            }
            tooltipComponents.add(CommonComponents.EMPTY);
            tooltipComponents.add(Component.translatable("item.tool_module.create_modular_tools.modifiers.tool").withStyle(ChatFormatting.GRAY));
            tooltipComponents.addAll(TOOL_MODULE.getDescription());
        }
    }
}
