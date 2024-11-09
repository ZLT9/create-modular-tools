package net.zlt.create_modular_tools.item.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.mold.AxeSandMoldBlock;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeSandMoldItem extends BaseSandMoldItem {
    public AxeSandMoldItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected Collection<ToolModuleType> getRequiredToolModuleTypes() {
        return AxeSandMoldBlock.s_getRequired();
    }

    @Override
    protected Collection<ToolModuleType> getCompatibleToolModuleTypes() {
        return AxeSandMoldBlock.s_getCompatible();
    }
}
