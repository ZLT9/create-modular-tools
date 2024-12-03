package net.zlt.create_modular_tools.client.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.block.entity.mold.ToolMaterialMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.ToolMaterialMoldBlock;
import net.zlt.create_modular_tools.block.mold.MaterialMoldBlock;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.mold.MoldRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolMaterialMoldRenderer<T extends ToolMaterialMoldBlockEntity> implements BlockEntityRenderer<T> {
    private static final ModelPart TOP = createInteriorLayer().bakeRoot();
    private static final Map<ResourceLocation, Material> MATERIALS = new HashMap<>();

    @Override
    public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        CompoundTag toolModulesNbt = blockEntity.getToolModulesNbt();
        boolean isEnchanted = false;
        List<ResourceLocation> absentToolModuleIds = new ArrayList<>();
        List<ResourceLocation> presentToolModuleIds = new ArrayList<>();

        for (ToolModuleType toolModuleType : MoldRegistry.getCompatible(getMoldBlock().getModularTool())) {
            if (!toolModulesNbt.contains(toolModuleType.getTag(), CompoundTag.TAG_COMPOUND)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(toolModuleType.getTag());
            ToolUtils.MoldSlotState slotState = ToolUtils.MoldSlotState.fromName(slotNbt.getString(AllTagNames.MOLD_SLOT_STATE));
            if (slotState == ToolUtils.MoldSlotState.EMPTY) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(getMoldBlock(), toolModulesNbt);
                if (moldTopTexture == null) {
                    continue;
                }

                ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(getMoldBlock(), toolModulesNbt);
                if (moldTopTextureId != null) {
                    absentToolModuleIds.add(moldTopTextureId);
                }

                continue;
            }

            ToolModuleItem toolModule = ToolModuleRegistry.get(slotNbt.getString(AllTagNames.TOOL_MODULE_ID));
            if (toolModule == null) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(getMoldBlock(), toolModulesNbt);
                if (moldTopTexture == null) {
                    continue;
                }

                ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(getMoldBlock(), toolModulesNbt);
                if (moldTopTextureId != null) {
                    presentToolModuleIds.add(moldTopTextureId);
                }

                continue;
            }

            ResourceLocation toolModuleModelId = toolModule.getModelId(getMoldBlock().getModularTool(), toolModulesNbt);
            if (toolModuleModelId != null) {
                presentToolModuleIds.add(toolModuleModelId);
            }

            if (!isEnchanted && !slotNbt.getCompound("tag").getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND).isEmpty()) {
                isEnchanted = true;
            }
        }

        poseStack.pushPose();

        poseStack.translate(0.5, 0.0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-blockEntity.getBlockState().getValue(MaterialMoldBlock.FACING).toYRot()));
        poseStack.translate(-0.5, 0.1875, -0.5);

        TOP.render(poseStack, getBaseMaterial().buffer(buffer, resourceLocation -> RenderType.cutout(), isEnchanted), packedLight, packedOverlay);

        for (ResourceLocation toolModuleId : absentToolModuleIds) {
            TOP.render(poseStack, getMaterial(toolModuleId).buffer(buffer, resourceLocation -> RenderType.cutout()), packedLight, packedOverlay);
        }

        for (ResourceLocation toolModuleId : presentToolModuleIds) {
            TOP.render(poseStack, getMaterial(toolModuleId).buffer(buffer, resourceLocation -> RenderType.cutout()), packedLight, packedOverlay);
        }

        poseStack.popPose();
    }

    private static Material getMaterial(ResourceLocation id) {
        return MATERIALS.computeIfAbsent(id, s -> new Material(InventoryMenu.BLOCK_ATLAS, id));
    }

    private static LayerDefinition createInteriorLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeListBuilder cubeListBuilder = CubeListBuilder.create().texOffs(0, 0).addBox(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 0.0f, EnumSet.of(Direction.NORTH));
        partdefinition.addOrReplaceChild("top", cubeListBuilder, PartPose.rotation((float) (Math.PI / 2), 0.0f, 0.0f));
        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    protected abstract ToolMaterialMoldBlock getMoldBlock();

    protected abstract Material getBaseMaterial();
}
