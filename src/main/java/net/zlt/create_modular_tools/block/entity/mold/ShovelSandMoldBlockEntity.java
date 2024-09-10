package net.zlt.create_modular_tools.block.entity.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.mold.ShovelSandMoldBlock;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ShovelSandMoldBlockEntity extends SandMoldBlockEntity {
    public ShovelSandMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.SHOVEL_SAND_MOLD, pos, blockState);
    }

    @Override
    public Component getName() {
        return AllModularTools.SHOVEL.getToolCategorySingularName();
    }

    @Override
    public Collection<ToolModuleType> getCompatible() {
        return ShovelSandMoldBlock.s_getCompatible();
    }

    @Override
    public Collection<ToolModuleType> getRequired() {
        return ShovelSandMoldBlock.s_getRequired();
    }

    @Override
    public boolean isCompatible(ToolModuleType toolModuleType) {
        return ShovelSandMoldBlock.s_isCompatible(toolModuleType);
    }

    @Override
    protected CompoundTag getDefaultToolModulesNbt() {
        CompoundTag toolModulesNbt = new CompoundTag();
        for (ToolModuleType toolModuleType : ShovelSandMoldBlock.s_getRequired()) {
            toolModulesNbt.putString(toolModuleType.getTag(), "");
        }
        return toolModulesNbt;
    }
}
