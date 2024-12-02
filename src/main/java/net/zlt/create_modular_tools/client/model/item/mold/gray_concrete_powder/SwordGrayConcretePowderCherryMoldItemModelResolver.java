package net.zlt.create_modular_tools.client.model.item.mold.gray_concrete_powder;

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
public class SwordGrayConcretePowderCherryMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation SWORD_GRAY_CONCRETE_POWDER_CHERRY_MOLD_MODEL_ID = CreateModularTools.asResource("item/sword_gray_concrete_powder_cherry_mold");

    @Override
    public ResourceLocation getModelId() {
        return SWORD_GRAY_CONCRETE_POWDER_CHERRY_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new SwordGrayConcretePowderCherryMoldItemUnbakedModel();
    }
}
