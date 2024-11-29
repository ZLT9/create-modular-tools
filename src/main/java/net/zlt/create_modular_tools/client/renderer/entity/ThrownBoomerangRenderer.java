package net.zlt.create_modular_tools.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.client.model.entity.ThrownBoomerangModel;
import net.zlt.create_modular_tools.entity.ThrownBoomerang;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ThrownBoomerangRenderer extends EntityRenderer<ThrownBoomerang> {
    private final ThrownBoomerangModel MODEL;
    private final ResourceLocation TEXTURE_LOCATION;

    public ThrownBoomerangRenderer(ResourceLocation bakedModelLocation, ResourceLocation textureLocation, Item item, EntityRendererProvider.Context context) {
        super(context);
        MODEL = new ThrownBoomerangModel(bakedModelLocation, item.getDefaultInstance());
        TEXTURE_LOCATION = textureLocation;
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownBoomerang entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public void render(ThrownBoomerang entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getCustomYRot() - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(entity.getCustomXRot() + 90.0f));
        poseStack.mulPose(Axis.YP.rotationDegrees(90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(entity.getCustomYaw()));
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(buffer, MODEL.renderType(getTextureLocation(entity)), false, entity.isFoil());
        MODEL.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }
}
