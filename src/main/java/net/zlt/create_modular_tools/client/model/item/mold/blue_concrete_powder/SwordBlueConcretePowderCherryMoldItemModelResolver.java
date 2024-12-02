package net.zlt.create_modular_tools.client.model.item.mold.blue_concrete_powder;

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
public class SwordBlueConcretePowderCherryMoldItemModelResolver extends SingleModelResolver {
    public static final ResourceLocation SWORD_BLUE_CONCRETE_POWDER_CHERRY_MOLD_MODEL_ID = CreateModularTools.asResource("item/sword_blue_concrete_powder_cherry_mold");

    @Override
    public ResourceLocation getModelId() {
        return SWORD_BLUE_CONCRETE_POWDER_CHERRY_MOLD_MODEL_ID;
    }

    @Override
    public UnbakedModel createUnbaked() {
        return new SwordBlueConcretePowderCherryMoldItemUnbakedModel();
    }
}
