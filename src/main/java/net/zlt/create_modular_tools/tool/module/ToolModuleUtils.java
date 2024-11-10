package net.zlt.create_modular_tools.tool.module;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class ToolModuleUtils {
    private ToolModuleUtils() {
    }

    @Environment(EnvType.CLIENT)
    @Nullable
    public static BakedModel getToolModuleModel(ToolModuleType toolModuleType, ModularToolItem modularTool, CompoundTag toolModulesNbt) {
        ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getString(toolModuleType.getTag()));
        if (toolModule == null) {
            return null;
        }

        ResourceLocation toolModuleModelId = toolModule.getModelId(modularTool, toolModulesNbt);
        if (toolModuleModelId == null) {
            return null;
        }

        return Minecraft.getInstance().getModelManager().getModel(toolModuleModelId);
    }
}
