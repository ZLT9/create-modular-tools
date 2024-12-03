package net.zlt.create_modular_tools.client.model.item.mold.white_concrete_powder;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.model.SingleModelResolver;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PickaxeWhiteConcretePowderJungleMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation PICKAXE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD_MODEL_ID = CreateModularTools.asResource("item/pickaxe_white_concrete_powder_jungle_mold");

    @Override
    public ResourceLocation getModelId() {
        return PICKAXE_WHITE_CONCRETE_POWDER_JUNGLE_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new PickaxeWhiteConcretePowderJungleMoldItemUnbakedModel();
    }
}