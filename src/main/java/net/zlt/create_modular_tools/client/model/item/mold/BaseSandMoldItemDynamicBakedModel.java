package net.zlt.create_modular_tools.client.model.item.mold;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.material.BlendMode;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.ModelHelper;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.Utils;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class BaseSandMoldItemDynamicBakedModel implements BakedModel {
    private static final RenderMaterial MATERIAL_CUTOUT_MIPPED = RendererAccess.INSTANCE.getRenderer().materialFinder().blendMode(BlendMode.CUTOUT_MIPPED).find();

    private final BakedModel BASE_SAND_MOLD_MODEL;
    private final BakedQuad INTERIOR_TOP_QUAD;
    private final Function<Material, TextureAtlasSprite> SPRITE_GETTER;

    public BaseSandMoldItemDynamicBakedModel(BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        BASE_SAND_MOLD_MODEL = baseSandMoldModel;
        INTERIOR_TOP_QUAD = interiorTopQuad;
        SPRITE_GETTER = spriteGetter;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction direction, RandomSource random) {
        return List.of();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean usesBlockLight() {
        return true;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(new ResourceLocation("minecraft", "block/sand"));
    }

    @Override
    public ItemTransforms getTransforms() {
        return ModelHelper.MODEL_TRANSFORM_BLOCK;
    }

    @Override
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<RandomSource> randomSupplier, RenderContext context) {
        QuadEmitter emitter = context.getEmitter();

        for (int i = 0; i <= ModelHelper.NULL_FACE_ID; i++) {
            Direction face = ModelHelper.faceFromIndex(i);

            for (BakedQuad quad : BASE_SAND_MOLD_MODEL.getQuads(null, face, randomSupplier.get())) {
                emitter.fromVanilla(quad, MATERIAL_CUTOUT_MIPPED, face);
                emitter.emit();
            }
        }

        CompoundTag nbt = stack.getTag();
        if (nbt == null) {
            return;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(nbt);
        if (toolModulesNbt.isEmpty()) {
            return;
        }

        int[] topQuadVertices = Utils.copyArray(INTERIOR_TOP_QUAD.getVertices());
        BakedQuad topQuad = new BakedQuad(topQuadVertices, INTERIOR_TOP_QUAD.getTintIndex(), Direction.UP, INTERIOR_TOP_QUAD.getSprite(), INTERIOR_TOP_QUAD.isShade());

        List<ResourceLocation> existingToolModuleIds = new ArrayList<>();
        for (ToolModuleType toolModuleType : getCompatible()) {
            if (!toolModulesNbt.contains(toolModuleType.getTag())) {
                continue;
            }

            String toolModuleId = toolModulesNbt.getString(toolModuleType.getTag());
            if (toolModuleId.isEmpty()) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(getMoldBlock(), toolModulesNbt);
                if (moldTopTexture != null) {
                    ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(getMoldBlock(), toolModulesNbt);
                    if (moldTopTextureId != null) {
                        Utils.setBakedQuadUV(topQuadVertices, SPRITE_GETTER.apply(new Material(InventoryMenu.BLOCK_ATLAS, moldTopTextureId)), Direction.NORTH);
                        emitter.fromVanilla(topQuad, MATERIAL_CUTOUT_MIPPED, Direction.UP).emit();
                    }
                }
            } else {
                ToolModule toolModule = ToolModuleRegistry.get(toolModuleId);
                if (toolModule == null) {
                    ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(getMoldBlock(), toolModulesNbt);
                    if (moldTopTexture != null) {
                        ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(getMoldBlock(), toolModulesNbt);
                        if (moldTopTextureId != null) {
                            existingToolModuleIds.add(moldTopTextureId);
                        }
                    }
                } else {
                    ResourceLocation toolModuleModelId = toolModule.getModelId(getModularTool(), toolModulesNbt);
                    if (toolModuleModelId != null) {
                        existingToolModuleIds.add(toolModuleModelId);
                    }
                }
            }
        }
        for (ResourceLocation toolModuleId : existingToolModuleIds) {
            Utils.setBakedQuadUV(topQuadVertices, SPRITE_GETTER.apply(new Material(InventoryMenu.BLOCK_ATLAS, toolModuleId)), Direction.NORTH);
            emitter.fromVanilla(topQuad, MATERIAL_CUTOUT_MIPPED, Direction.UP);
            emitter.emit();
        }
    }

    protected abstract Collection<ToolModuleType> getCompatible();

    protected abstract SandMoldBlock getMoldBlock();

    protected abstract ModularToolItem getModularTool();
}
