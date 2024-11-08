package net.zlt.create_modular_tools.client.model.item.mold;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.model.ModelHelper;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.Utils;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.client.MoldModelUtils;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseSandMoldItemUnbakedModel implements UnbakedModel {
    @Override
    public Collection<ResourceLocation> getDependencies() {
        return List.of();
    }

    @Override
    public void resolveParents(Function<ResourceLocation, UnbakedModel> resolver) {
    }

    @Override
    @Nullable
    public BakedModel bake(ModelBaker baker, Function<Material, TextureAtlasSprite> spriteGetter, ModelState state, ResourceLocation location) {
        BakedModel baseSandMoldModel = baker.getModel(CreateModularTools.asResource("block/sand_mold")).bake(baker, spriteGetter, state, location);
        if (baseSandMoldModel == null) {
            return null;
        }

        BakedQuad interiorTopQuad = null;
        float interiorTopQuadY = 1.0f;
        for (BakedQuad quad : baseSandMoldModel.getQuads(null, Direction.UP, RandomSource.create())) {
            float quadY = Utils.getBakedQuadY(quad.getVertices(), 0);
            if (quadY < interiorTopQuadY) {
                interiorTopQuad = quad;
                interiorTopQuadY = quadY;
            }
        }
        if (interiorTopQuad == null) {
            return baseSandMoldModel;
        }

        return createBaked(this, baseSandMoldModel, interiorTopQuad, spriteGetter);
    }

    public BakedModel bakeOverride(@Nullable CompoundTag nbt, BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        List<BakedQuad> quads = new ArrayList<>();

        for (int i = 0; i <= ModelHelper.NULL_FACE_ID; ++i) {
            quads.addAll(baseSandMoldModel.getQuads(null, ModelHelper.faceFromIndex(i), RandomSource.create()));
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(nbt);
        if (toolModulesNbt.isEmpty()) {
            return createOverride(quads);
        }

        MoldModelUtils.forEachMoldTopQuad(getCompatible(), toolModulesNbt, getMoldBlock(), getModularTool(), id -> {
            int[] topQuadVertices = Utils.copyArray(interiorTopQuad.getVertices());
            Utils.setBakedQuadUV(topQuadVertices, spriteGetter.apply(new Material(InventoryMenu.BLOCK_ATLAS, id)), Direction.NORTH);
            quads.add(new BakedQuad(topQuadVertices, interiorTopQuad.getTintIndex(), Direction.UP, interiorTopQuad.getSprite(), interiorTopQuad.isShade()));
        });

        return createOverride(quads);
    }

    public BakedModel bakeDynamic(BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        return createDynamic(baseSandMoldModel, interiorTopQuad, spriteGetter);
    }

    protected BakedModel createBaked(BaseSandMoldItemUnbakedModel unbakedModel, BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        return new BaseSandMoldItemBakedModel(unbakedModel, baseSandMoldModel, interiorTopQuad, spriteGetter);
    }

    protected BakedModel createOverride(List<BakedQuad> quads) {
        return new BaseSandMoldItemBakedModel(quads);
    }

    protected abstract BakedModel createDynamic(BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter);

    protected abstract Collection<ToolModuleType> getCompatible();

    protected abstract SandMoldBlock getMoldBlock();

    protected abstract ModularToolItem getModularTool();
}
