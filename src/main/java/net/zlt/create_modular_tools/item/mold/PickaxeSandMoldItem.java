package net.zlt.create_modular_tools.item.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.mold.PickaxeSandMoldBlock;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeSandMoldItem extends BaseSandMoldItem {
    public PickaxeSandMoldItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected Collection<ToolModuleType> getRequiredToolModuleTypes() {
        return PickaxeSandMoldBlock.s_getRequired();
    }

    @Override
    protected Collection<ToolModuleType> getCompatibleToolModuleTypes() {
        return PickaxeSandMoldBlock.s_getCompatible();
    }
}
