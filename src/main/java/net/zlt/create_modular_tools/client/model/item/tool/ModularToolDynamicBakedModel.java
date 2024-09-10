package net.zlt.create_modular_tools.client.model.item.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModularToolDynamicBakedModel implements BakedModel {
    private final BakedModel DUMMY_MODEL;
    private final ModularToolItem MODULAR_TOOL;

    public ModularToolDynamicBakedModel(BakedModel dummyModel, ModularToolItem modularTool) {
        DUMMY_MODEL = dummyModel;
        MODULAR_TOOL = modularTool;
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
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(new ResourceLocation("minecraft", "item/stick"));
    }

    @Override
    public ItemTransforms getTransforms() {
        return DUMMY_MODEL.getTransforms();
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
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return;
        }

        ModelManager modelManager = Minecraft.getInstance().getModelManager();
        for (ToolModuleType toolModuleType : MODULAR_TOOL.getCompatibleByLayer()) {
            ToolModule toolModule = ToolModuleRegistry.get(toolModulesNbt.getString(toolModuleType.getTag()));
            if (toolModule == null) {
                continue;
            }

            ResourceLocation toolModuleModelId = toolModule.getModelId(MODULAR_TOOL, toolModulesNbt);
            if (toolModuleModelId == null) {
                continue;
            }

            BakedModel model = modelManager.getModel(toolModuleModelId);
            if (model == null) {
                continue;
            }

            model.emitItemQuads(stack, randomSupplier, context);
        }
    }
}
