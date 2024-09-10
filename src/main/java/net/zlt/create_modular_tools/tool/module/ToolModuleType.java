package net.zlt.create_modular_tools.tool.module;

import com.tterrag.registrate.fabric.TriFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.zlt.create_modular_tools.block.mold.SandMoldBlock;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ToolModuleType {
    private final Component NAME;
    private final String TAG;
    private final int LAYER;
    private final long REQUIRED_MOLTEN_METAL_AMOUNT;
    private final List<TriFunction<@Nullable MoldTopTexture, SandMoldBlock, CompoundTag, @Nullable MoldTopTexture>> MOLD_TOP_TEXTURE_GETTERS = new ArrayList<>();
    private final Map<ModularToolItem, ResourceLocation> ICONS = new HashMap<>();

    public ToolModuleType(Component name, String tag, int layer, long requiredMoltenMetalAmount) {
        NAME = name;
        TAG = tag;
        LAYER = layer;
        REQUIRED_MOLTEN_METAL_AMOUNT = requiredMoltenMetalAmount;
    }

    public Component getName() {
        return NAME;
    }

    public String getTag() {
        return TAG;
    }

    public int getLayer() {
        return LAYER;
    }

    @Environment(EnvType.CLIENT)
    public ResourceLocation getIcon(ModularToolItem modularTool) {
        return ICONS.get(modularTool);
    }

    @Environment(EnvType.CLIENT)
    public void putIcon(ModularToolItem modularTool, ResourceLocation icon) {
        ICONS.put(modularTool, icon);
    }

    public void registerMoldTopTextureGetter(TriFunction<@Nullable MoldTopTexture, SandMoldBlock, CompoundTag, MoldTopTexture> moldTopTextureGetter) {
        MOLD_TOP_TEXTURE_GETTERS.add(moldTopTextureGetter);
    }

    @Nullable
    public MoldTopTexture getMoldTopTexture(SandMoldBlock moldBlock, CompoundTag moldNbt) {
        MoldTopTexture moldTopTexture = null;
        for (TriFunction<@Nullable MoldTopTexture, SandMoldBlock, CompoundTag, @Nullable MoldTopTexture> moldTopTextureGetter : MOLD_TOP_TEXTURE_GETTERS) {
            moldTopTexture = moldTopTextureGetter.apply(moldTopTexture, moldBlock, moldNbt);
        }
        return moldTopTexture;
    }

    public long getRequiredMoltenMetalAmount() {
        return REQUIRED_MOLTEN_METAL_AMOUNT;
    }

    public static class MoldTopTexture {
        private final List<TriFunction<@Nullable ResourceLocation, SandMoldBlock, CompoundTag, @Nullable ResourceLocation>> TEXTURE_ID_GETTERS = new ArrayList<>();

        public boolean clicked(int x, int y) {
            return false;
        }

        @Environment(EnvType.CLIENT)
        public void registerTextureIdGetter(TriFunction<@Nullable ResourceLocation, SandMoldBlock, CompoundTag, @Nullable ResourceLocation> textureIdGetter) {
            TEXTURE_ID_GETTERS.add(textureIdGetter);
        }

        @Environment(EnvType.CLIENT)
        @Nullable
        public ResourceLocation getTextureId(SandMoldBlock sandMoldBlock, CompoundTag moldNbt) {
            ResourceLocation id = null;
            for (TriFunction<@Nullable ResourceLocation, SandMoldBlock, CompoundTag, @Nullable ResourceLocation> textureIdGetter : TEXTURE_ID_GETTERS) {
                id = textureIdGetter.apply(id, sandMoldBlock, moldNbt);
            }
            return id;
        }
    }
}
