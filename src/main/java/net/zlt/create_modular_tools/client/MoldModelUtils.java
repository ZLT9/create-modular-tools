package net.zlt.create_modular_tools.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class MoldModelUtils {
    private MoldModelUtils() {
    }

    public static void forEachMoldTopQuad(Collection<ToolModuleType> compatibleToolModuleTypes, CompoundTag toolModulesNbt, SandMoldBlock sandMoldBlock, ModularToolItem modularTool, Consumer<ResourceLocation> action) {
        List<ResourceLocation> existingToolModuleIds = new ArrayList<>();

        for (ToolModuleType toolModuleType : compatibleToolModuleTypes) {
            if (!toolModulesNbt.contains(toolModuleType.getTag(), CompoundTag.TAG_COMPOUND)) {
                continue;
            }

            CompoundTag slotNbt = toolModulesNbt.getCompound(toolModuleType.getTag());
            ToolUtils.MoldSlotState slotState = ToolUtils.MoldSlotState.fromName(slotNbt.getString("state"));
            if (slotState == ToolUtils.MoldSlotState.EMPTY) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(sandMoldBlock, toolModulesNbt);
                if (moldTopTexture == null) {
                    continue;
                }

                ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(sandMoldBlock, toolModulesNbt);
                if (moldTopTextureId != null) {
                    action.accept(moldTopTextureId);
                }

                continue;
            }

            ToolModuleItem toolModule = ToolModuleRegistry.get(slotNbt.getString("id"));
            if (toolModule == null) {
                ToolModuleType.MoldTopTexture moldTopTexture = toolModuleType.getMoldTopTexture(sandMoldBlock, toolModulesNbt);
                if (moldTopTexture == null) {
                    continue;
                }

                ResourceLocation moldTopTextureId = moldTopTexture.getTextureId(sandMoldBlock, toolModulesNbt);
                if (moldTopTextureId != null) {
                    existingToolModuleIds.add(moldTopTextureId);
                }

                continue;
            }

            ResourceLocation toolModuleModelId = toolModule.getModelId(modularTool, toolModulesNbt);
            if (toolModuleModelId != null) {
                existingToolModuleIds.add(toolModuleModelId);
            }
        }

        for (ResourceLocation toolModuleId : existingToolModuleIds) {
            action.accept(toolModuleId);
        }
    }
}
