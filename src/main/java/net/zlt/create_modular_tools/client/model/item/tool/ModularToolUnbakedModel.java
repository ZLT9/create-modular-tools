package net.zlt.create_modular_tools.client.model.item.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.model.ModelHelper;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import net.zlt.create_modular_tools.tool.module.ToolModuleUtils;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModularToolUnbakedModel implements UnbakedModel {
    private final ModularToolItem MODULAR_TOOL;

    public ModularToolUnbakedModel(ModularToolItem modularTool) {
        MODULAR_TOOL = modularTool;
    }

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
        return new ModularToolBakedModel(this, Objects.requireNonNull(baker.getModel(new ResourceLocation("minecraft", "item/stick")).bake(baker, spriteGetter, state, location)));
    }

    public BakedModel bakeOverride(ItemStack stack, BakedModel dummyModel) {
        List<BakedQuad> bakedQuads = new ArrayList<>();

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return new ModularToolBakedModel(dummyModel, bakedQuads);
        }

        RandomSource randomSource = RandomSource.create();
        for (ToolModuleType toolModuleType : MODULAR_TOOL.getCompatibleByLayer()) {
            BakedModel toolModuleModel = ToolModuleUtils.getToolModuleModel(toolModuleType, MODULAR_TOOL, toolModulesNbt);
            if (toolModuleModel != null) {
                for (int i = 0; i <= ModelHelper.NULL_FACE_ID; i++) {
                    bakedQuads.addAll(toolModuleModel.getQuads(null, ModelHelper.faceFromIndex(i), randomSource));
                }
            }
        }

        return new ModularToolBakedModel(dummyModel, bakedQuads);
    }

    public BakedModel bakeDynamic(BakedModel dummyModel) {
        return new ModularToolDynamicBakedModel(dummyModel, MODULAR_TOOL);
    }
}
