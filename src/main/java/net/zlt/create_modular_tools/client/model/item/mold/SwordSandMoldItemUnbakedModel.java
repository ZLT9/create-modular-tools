package net.zlt.create_modular_tools.client.model.item.mold;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.block.mold.SwordSandMoldBlock;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SwordSandMoldItemUnbakedModel extends BaseSandMoldItemUnbakedModel {
    @Override
    protected BakedModel createDynamic(BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        return new SwordSandMoldItemDynamicBakedModel(baseSandMoldModel, interiorTopQuad, spriteGetter);
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
