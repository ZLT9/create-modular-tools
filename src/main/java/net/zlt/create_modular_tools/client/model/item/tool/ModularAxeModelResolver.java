package net.zlt.create_modular_tools.client.model.item.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.model.SingleModelResolver;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class ModularAxeModelResolver extends SingleModelResolver {
    public static final ResourceLocation MODULAR_AXE_MODEL_ID = CreateModularTools.asResource("item/modular_axe");

    @Override
    public ResourceLocation getModelId() {
        return MODULAR_AXE_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new ModularToolUnbakedModel(AllModularTools.AXE);
    }
}
