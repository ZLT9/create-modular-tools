package net.zlt.create_modular_tools.block.entity.mold;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.mold.AxeSandMoldBlock;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxeSandMoldBlockEntity extends SandMoldBlockEntity {
    public AxeSandMoldBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllMoldBlockEntityTypes.AXE_SAND_MOLD, pos, blockState);
    }

    @Override
    public Component getName() {
        return AllModularTools.AXE.getToolCategorySingularName();
    }

    @Override
    public Collection<ToolModuleType> getCompatible() {
        return AxeSandMoldBlock.s_getCompatible();
    }

    @Override
    public Collection<ToolModuleType> getRequired() {
        return AxeSandMoldBlock.s_getRequired();
    }

    @Override
    public boolean isCompatible(ToolModuleType toolModuleType) {
        return AxeSandMoldBlock.s_isCompatible(toolModuleType);
    }

    @Override
    protected CompoundTag getDefaultToolModulesNbt() {
        CompoundTag toolModulesNbt = new CompoundTag();
        for (ToolModuleType toolModuleType : AxeSandMoldBlock.s_getRequired()) {
            CompoundTag slotNbt = new CompoundTag();
            slotNbt.putString("state", ToolUtils.MoldSlotState.EMPTY.toString());
            toolModulesNbt.put(toolModuleType.getTag(), slotNbt);
        }
        return toolModulesNbt;
    }
}
