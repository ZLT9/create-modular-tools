package net.zlt.create_modular_tools.client.model.item.mold.yellow_concrete_powder;

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
public class SwordYellowConcretePowderDarkOakMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation SWORD_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD_MODEL_ID = CreateModularTools.asResource("item/sword_yellow_concrete_powder_dark_oak_mold");

    @Override
    public ResourceLocation getModelId() {
        return SWORD_YELLOW_CONCRETE_POWDER_DARK_OAK_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new SwordYellowConcretePowderDarkOakMoldItemUnbakedModel();
    }
}
