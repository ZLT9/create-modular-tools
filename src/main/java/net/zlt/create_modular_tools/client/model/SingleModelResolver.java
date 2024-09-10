package net.zlt.create_modular_tools.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelResolver;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class SingleModelResolver implements ModelResolver {
    @Override
    @Nullable
    public UnbakedModel resolveModel(Context context) {
        return context.id().equals(getModelId()) ? createUnbaked() : null;
    }

    public abstract ResourceLocation getModelId();

    public abstract UnbakedModel createUnbaked();
}
