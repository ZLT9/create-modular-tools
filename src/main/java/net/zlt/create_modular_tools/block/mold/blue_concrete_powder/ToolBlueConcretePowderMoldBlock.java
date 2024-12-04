package net.zlt.create_modular_tools.block.mold.blue_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolBlueConcretePowderMoldBlock extends ToolMaterialMoldBlock {
    public ToolBlueConcretePowderMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemStack getMaterialStack() {
        return Items.BLUE_CONCRETE_POWDER.getDefaultInstance();
    }
}
