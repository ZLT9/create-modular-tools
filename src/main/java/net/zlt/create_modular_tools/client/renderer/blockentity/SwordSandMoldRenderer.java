package net.zlt.create_modular_tools.client.renderer.blockentity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.zlt.create_modular_tools.block.entity.mold.SwordSandMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.block.mold.SwordSandMoldBlock;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordSandMoldRenderer extends BaseSandMoldRenderer<SwordSandMoldBlockEntity> {
    public SwordSandMoldRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    protected Collection<ToolModuleType> getCompatible() {
        return SwordSandMoldBlock.s_getCompatible();
    }

    @Override
    protected SandMoldBlock getMoldBlock() {
        return AllMoldBlocks.SWORD_SAND_MOLD;
    }

    @Override
    protected ModularToolItem getModularTool() {
        return AllModularTools.SWORD;
    }
}
