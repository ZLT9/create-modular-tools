package net.zlt.create_modular_tools.block.mold.magenta_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.magenta_concrete_powder.AxeMagentaConcretePowderOakMoldBlockEntity;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.AllModularTools;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeMagentaConcretePowderOakMoldBlock extends ToolMagentaConcretePowderOakMoldBlock {
    public AxeMagentaConcretePowderOakMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AxeMagentaConcretePowderOakMoldBlockEntity(pos, state);
    }

    @Override
    public ModularToolItem getModularTool() {
        return AllModularTools.AXE;
    }
}
