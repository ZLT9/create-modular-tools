package net.zlt.create_modular_tools.item.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.mold.SwordSandMoldBlock;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordSandMoldItem extends BaseSandMoldItem {
    public SwordSandMoldItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected Collection<ToolModuleType> getRequiredToolModuleTypes() {
        return SwordSandMoldBlock.s_getRequired();
    }

    @Override
    protected Collection<ToolModuleType> getCompatibleToolModuleTypes() {
        return SwordSandMoldBlock.s_getCompatible();
    }
}
