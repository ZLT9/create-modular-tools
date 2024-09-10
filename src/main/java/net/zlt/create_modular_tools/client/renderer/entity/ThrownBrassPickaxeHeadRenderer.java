package net.zlt.create_modular_tools.client.renderer.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.client.AllToolModuleModelIds;
import net.zlt.create_modular_tools.entity.ThrownBoomerang;
import net.zlt.create_modular_tools.item.AllItems;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ThrownBrassPickaxeHeadRenderer extends ThrownBoomerangRenderer {
    public static final ResourceLocation TEXTURE_LOCATION = CreateModularTools.asResource("textures/item/brass_pickaxe_head.png");

    public ThrownBrassPickaxeHeadRenderer(EntityRendererProvider.Context context) {
        super(CreateModularTools.asResource("item/brass_pickaxe_head"), AllItems.BRASS_PICKAXE_HEAD, context);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownBoomerang entity) {
        return TEXTURE_LOCATION;
    }
}
