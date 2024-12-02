package net.zlt.create_modular_tools.client.model.item.mold.purple_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AxePurpleConcretePowderBirchMoldItemUnbakedModel extends ToolPurpleConcretePowderBirchMoldItemUnbakedModel {
    @Override
    protected BakedModel createDynamic(BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        return new AxePurpleConcretePowderBirchMoldItemDynamicBakedModel(baseSandMoldModel, interiorTopQuad, spriteGetter);
    }

    @Override
    protected ToolMaterialMoldBlock getMoldBlock() {
        return AllMoldBlocks.AXE_PURPLE_CONCRETE_POWDER_BIRCH_MOLD;
    }
}
