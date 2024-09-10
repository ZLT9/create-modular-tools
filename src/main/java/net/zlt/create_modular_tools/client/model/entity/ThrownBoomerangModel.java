package net.zlt.create_modular_tools.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ThrownBoomerangModel extends Model {
    private final BakedModel BAKED_MODEL;
    private final ItemStack ITEM_STACK;

    public ThrownBoomerangModel(ResourceLocation bakedModelLocation, ItemStack itemStack) {
        super(RenderType::entitySolid);
        BAKED_MODEL = Minecraft.getInstance().getModelManager().getModel(bakedModelLocation);
        ITEM_STACK = itemStack;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.getItemRenderer().render(ITEM_STACK, ItemDisplayContext.NONE, false, poseStack, minecraft.renderBuffers().bufferSource(), packedLight, packedOverlay, BAKED_MODEL);
    }
}
