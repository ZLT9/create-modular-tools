package net.zlt.create_modular_tools.block.mold.red_sand;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolRedSandMoldBlock extends ToolMaterialMoldBlock {
    public ToolRedSandMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemStack getMaterialStack() {
        return Items.RED_SAND.getDefaultInstance();
    }
}
