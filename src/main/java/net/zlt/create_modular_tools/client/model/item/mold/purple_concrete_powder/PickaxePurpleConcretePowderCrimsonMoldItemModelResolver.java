package net.zlt.create_modular_tools.client.model.item.mold.purple_concrete_powder;

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
public class PickaxePurpleConcretePowderCrimsonMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation PICKAXE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD_MODEL_ID = CreateModularTools.asResource("item/pickaxe_purple_concrete_powder_crimson_mold");

    @Override
    public ResourceLocation getModelId() {
        return PICKAXE_PURPLE_CONCRETE_POWDER_CRIMSON_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new PickaxePurpleConcretePowderCrimsonMoldItemUnbakedModel();
    }
}
