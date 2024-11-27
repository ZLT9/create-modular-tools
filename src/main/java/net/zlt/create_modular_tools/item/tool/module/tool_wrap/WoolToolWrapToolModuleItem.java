package net.zlt.create_modular_tools.item.tool.module.tool_wrap;

import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;

public class WoolToolWrapToolModuleItem extends ToolWrapToolModuleItem {
    public WoolToolWrapToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.WOOD_TIER_LEVEL;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 1.0f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return 1.0f;
    }

    @Override
    public int getEnchantmentValue() {
        return 1;
    }
}
