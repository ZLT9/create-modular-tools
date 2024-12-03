package net.zlt.create_modular_tools.tool.module;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.zlt.create_modular_tools.AllTags;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class ToolModuleUtils {
    private ToolModuleUtils() {
    }

    @Environment(EnvType.CLIENT)
    @Nullable
    public static BakedModel getToolModuleModel(ToolModuleType toolModuleType, ModularToolItem modularTool, CompoundTag toolModulesNbt) {
        ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString(AllTags.TOOL_MODULE_ID));
        if (toolModule == null) {
            return null;
        }

        ResourceLocation toolModuleModelId = toolModule.getModelId(modularTool, toolModulesNbt);
        if (toolModuleModelId == null) {
            return null;
        }

        return Minecraft.getInstance().getModelManager().getModel(toolModuleModelId);
    }

    @Nullable
    public static Map<Enchantment, List<Integer>> mergeEnchantments(Map<Enchantment, List<Integer>> a, Map<Enchantment, Integer> b) {
        Map<Enchantment, List<Integer>> enchantmentMap = Maps.newHashMap();
        a.forEach((enchantment, levels) -> enchantmentMap.computeIfAbsent(enchantment, k -> new ArrayList<>()).addAll(levels));
        b.forEach((enchantment, level) -> enchantmentMap.computeIfAbsent(enchantment, k -> new ArrayList<>()).add(level));

        for (Map.Entry<Enchantment, List<Integer>> entry : enchantmentMap.entrySet()) {
            Enchantment enchantment1 = entry.getKey();
            for (Enchantment enchantment2 : enchantmentMap.keySet()) {
                if (enchantment1 != enchantment2 && !enchantment1.isCompatibleWith(enchantment2)) {
                    return null;
                }
            }
            List<Integer> levels = entry.getValue();
            if (enchantment1.isCurse()) {
                levels.set(0, 1);
                continue;
            }
            levels.sort(Collections.reverseOrder());
            int i = 0;
            while (i < levels.size() - 1) {
                if (levels.get(i).equals(levels.get(i + 1))) {
                    levels.set(i, levels.get(i) + 1);
                    levels.remove(i + 1);
                    levels.sort(Collections.reverseOrder());
                    i = 0;
                } else {
                    ++i;
                }
            }
        }

        return enchantmentMap;
    }
}