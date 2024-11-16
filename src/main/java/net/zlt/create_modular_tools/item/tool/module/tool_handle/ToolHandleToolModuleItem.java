package net.zlt.create_modular_tools.item.tool.module.tool_handle;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolHandleToolModuleItem extends ToolModuleItem {
    public ToolHandleToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.TOOL_HANDLE;
    }

    @Override
    public boolean canApplyEnchantment(Enchantment enchantment) {
        return enchantment == Enchantments.UNBREAKING ||
            enchantment == Enchantments.MENDING ||
            enchantment == Enchantments.VANISHING_CURSE;
    }
}
