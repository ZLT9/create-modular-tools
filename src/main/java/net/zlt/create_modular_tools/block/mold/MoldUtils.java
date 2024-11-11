package net.zlt.create_modular_tools.block.mold;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.item.mold.BaseSandMoldItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleTypeRegistry;

public final class MoldUtils {
    private MoldUtils() {
    }

    public static boolean isMoldSolid(ItemStack moldStack) {
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(moldStack.getTag());
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        BaseSandMoldBlock moldBlock = ((BaseSandMoldBlock) ((BaseSandMoldItem) moldStack.getItem()).getBlock());

        for (String key : toolModulesNbt.getAllKeys()) {
            ToolModuleType toolModuleType = ToolModuleTypeRegistry.get(key);
            if (toolModuleType == null || !moldBlock.isCompatible(toolModuleType)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(key);
            if (ToolUtils.MoldSlotState.fromName(slotNbt.getString("state")) != ToolUtils.MoldSlotState.SOLID || !ToolModuleRegistry.containsId(slotNbt.getString("id"))) {
                return false;
            }
        }

        return true;
    }
}
