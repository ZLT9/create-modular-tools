package net.zlt.create_modular_tools.block.mold.purple_concrete_powder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class PurpleConcretePowderMoldBlock extends MaterialMoldBlock {
    public PurpleConcretePowderMoldBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemStack getMaterialStack() {
        return Items.PURPLE_CONCRETE_POWDER.getDefaultInstance();
    }
}