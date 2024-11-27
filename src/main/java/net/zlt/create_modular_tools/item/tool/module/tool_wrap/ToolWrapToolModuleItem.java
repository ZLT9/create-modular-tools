package net.zlt.create_modular_tools.item.tool.module.tool_wrap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolWrapToolModuleItem extends ToolModuleItem {
    public ToolWrapToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.TOOL_WRAP;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return super.canApplyAtEnchantingTable(stack, enchantment) ||
            enchantment == Enchantments.VANISHING_CURSE;
    }
}
