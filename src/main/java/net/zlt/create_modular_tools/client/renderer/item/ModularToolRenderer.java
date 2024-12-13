package net.zlt.create_modular_tools.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.mixin.client.ItemRendererAccessor;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModularToolRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ItemDisplayContext mode, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        if (stack.isEmpty()) {
            return;
        }

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        BakedModel model = itemRenderer.getModel(stack, null, null, 0);
        ItemRendererAccessor itemRendererAccessor = (ItemRendererAccessor) itemRenderer;
        ItemColors itemColors = itemRendererAccessor.getItemColors();
        VertexConsumer buffer = ItemRenderer.getFoilBufferDirect(vertexConsumers, ItemBlockRenderTypes.getRenderType(stack, true), true, false);
        VertexConsumer foilBuffer = ItemRenderer.getFoilBufferDirect(vertexConsumers, ItemBlockRenderTypes.getRenderType(stack, true), true, stack.hasFoil());
        RandomSource randomSource = RandomSource.create();
        PoseStack.Pose pose = matrices.last();

        for (Direction direction : Direction.values()) {
            List<BakedQuad> quads = model.getQuads(null, direction, randomSource);

            if (quads.isEmpty()) {
                continue;
            }

            randomSource.setSeed(42L);

            if (direction.getAxis() == Direction.Axis.Z) {
                renderQuad(stack, quads.get(0), itemColors, foilBuffer, pose, light, overlay);
                renderQuadList(quads, 1, pose, stack, itemColors, buffer, light, overlay);
            } else {
                renderQuadList(quads, 0, pose, stack, itemColors, foilBuffer, light, overlay);
            }
        }

        randomSource.setSeed(42L);
        renderQuadList(model.getQuads(null, null, randomSource), 0, pose, stack, itemColors, foilBuffer, light, overlay);
    }

    private void renderQuad(ItemStack stack, BakedQuad bakedQuad, ItemColors itemColors, VertexConsumer buffer, PoseStack.Pose pose, int light, int overlay) {
        int i = -1;
        if (!stack.isEmpty() && bakedQuad.isTinted()) {
            i = itemColors.getColor(stack, bakedQuad.getTintIndex());
        }

        float f = (float) (i >> 16 & 0xFF) / 255.0F;
        float g = (float) (i >> 8 & 0xFF) / 255.0F;
        float h = (float) (i & 0xFF) / 255.0F;
        buffer.putBulkData(pose, bakedQuad, f, g, h, light, overlay);
    }

    private void renderQuadList(List<BakedQuad> bakedQuads, int firstIndex, PoseStack.Pose pose, ItemStack stack, ItemColors itemColors, VertexConsumer buffer, int light, int overlay) {
        for (int i = firstIndex; i < bakedQuads.size(); ++i) {
            renderQuad(stack, bakedQuads.get(i), itemColors, buffer, pose, light, overlay);
        }
    }
}
