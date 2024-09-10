package net.zlt.create_modular_tools.block.entity.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.mold.PickaxeSandMoldBlock;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeSandMoldBlockEntity extends SandMoldBlockEntity {
    public PickaxeSandMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.PICKAXE_SAND_MOLD, pos, blockState);
    }

    @Override
    public Component getName() {
        return AllModularTools.PICKAXE.getToolCategorySingularName();
    }

    @Override
    public Collection<ToolModuleType> getCompatible() {
        return PickaxeSandMoldBlock.s_getCompatible();
    }

    @Override
    public Collection<ToolModuleType> getRequired() {
        return PickaxeSandMoldBlock.s_getRequired();
    }

    @Override
    public boolean isCompatible(ToolModuleType toolModuleType) {
        return PickaxeSandMoldBlock.s_isCompatible(toolModuleType);
    }

    @Override
    protected CompoundTag getDefaultToolModulesNbt() {
        CompoundTag toolModulesNbt = new CompoundTag();
        for (ToolModuleType toolModuleType : PickaxeSandMoldBlock.s_getRequired()) {
            toolModulesNbt.putString(toolModuleType.getTag(), "");
        }
        return toolModulesNbt;
    }
}
