package net.zlt.create_modular_tools.block.mold;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;

public final class MoldUtils {
    private MoldUtils() {
    }

    public static boolean isMoldSolid(ItemStack moldStack) {
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(moldStack.getTag());
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        for (String key : toolModulesNbt.getAllKeys()) {
            if (!ToolModuleRegistry.containsId(toolModulesNbt.getString(key))) {
                return false;
            }
        }

        return true;
    }
}
