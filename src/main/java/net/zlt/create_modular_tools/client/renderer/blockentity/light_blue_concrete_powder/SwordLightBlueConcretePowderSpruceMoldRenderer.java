package net.zlt.create_modular_tools.client.renderer.blockentity.light_blue_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.light_blue_concrete_powder.SwordLightBlueConcretePowderSpruceMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordLightBlueConcretePowderSpruceMoldRenderer extends ToolLightBlueConcretePowderMoldRenderer<SwordLightBlueConcretePowderSpruceMoldBlockEntity> {
    public SwordLightBlueConcretePowderSpruceMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_LIGHT_BLUE_CONCRETE_POWDER_SPRUCE_MOLD;
    }
}
