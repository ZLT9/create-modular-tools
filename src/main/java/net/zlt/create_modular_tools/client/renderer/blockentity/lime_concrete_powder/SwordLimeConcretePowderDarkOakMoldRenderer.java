package net.zlt.create_modular_tools.client.renderer.blockentity.lime_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.lime_concrete_powder.SwordLimeConcretePowderDarkOakMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordLimeConcretePowderDarkOakMoldRenderer extends ToolLimeConcretePowderMoldRenderer<SwordLimeConcretePowderDarkOakMoldBlockEntity> {
    public SwordLimeConcretePowderDarkOakMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_LIME_CONCRETE_POWDER_DARK_OAK_MOLD;
    }
}
