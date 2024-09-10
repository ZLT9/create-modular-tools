package net.zlt.create_modular_tools.item.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.zlt.create_modular_tools.block.mold.HoeSandMoldBlock;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HoeSandMoldItem extends BaseSandMoldItem {
    public HoeSandMoldItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected Collection<ToolModuleType> getRequiredToolModuleTypes() {
        return HoeSandMoldBlock.s_getRequired();
    }

    @Override
    protected Collection<ToolModuleType> getCompatibleToolModuleTypes() {
        return HoeSandMoldBlock.s_getCompatible();
    }
}
