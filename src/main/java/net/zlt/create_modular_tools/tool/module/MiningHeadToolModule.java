package net.zlt.create_modular_tools.tool.module;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class MiningHeadToolModule extends ToolModule {
    @Override
    public int getMiningDurabilityDamage() {
        return 1;
    }

    @Override
    public int getAttackDurabilityDamage() {
        return 2;
    }
}
