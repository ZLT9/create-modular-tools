package net.zlt.create_modular_tools.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.item.mold.AllMoldItems;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllCreativeModeTabs {
    private AllCreativeModeTabs() {
    }

    public static final ResourceKey<CreativeModeTab> BASE_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), CreateModularTools.asResource("base"));
    public static final CreativeModeTab BASE = register(BASE_KEY, FabricItemGroup.builder()
        .icon(() -> new ItemStack(AllMoldItems.SAND_MOLD))
        .title(Component.translatable("itemGroup.create_modular_tools.base"))
        .build());

    private static CreativeModeTab register(ResourceKey<CreativeModeTab> key, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key, tab);
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(BASE_KEY).register(entries -> {
            entries.accept(AllItems.CREATIVE_MODULAR_TOOL_TABLE);

            entries.accept(AllItems.MOLTEN_IRON_BUCKET);
            entries.accept(AllItems.MOLTEN_COPPER_BUCKET);
            entries.accept(AllItems.MOLTEN_GOLD_BUCKET);
            entries.accept(AllItems.MOLTEN_NETHERITE_BUCKET);
            entries.accept(AllItems.MOLTEN_ZINC_BUCKET);
            entries.accept(AllItems.MOLTEN_BRASS_BUCKET);
            entries.accept(AllItems.MOLTEN_DIAMOND_BUCKET);

            entries.accept(AllMoldItems.SAND_MOLD);

            entries.accept(AllItems.WOODEN_TOOL_HANDLE);
            entries.accept(AllItems.STONE_TOOL_HANDLE);
            entries.accept(AllItems.IRON_TOOL_HANDLE);
            entries.accept(AllItems.COPPER_TOOL_HANDLE);
            entries.accept(AllItems.GOLDEN_TOOL_HANDLE);
            entries.accept(AllItems.NETHERITE_TOOL_HANDLE);
            entries.accept(AllItems.ZINC_TOOL_HANDLE);
            entries.accept(AllItems.BRASS_TOOL_HANDLE);
            entries.accept(AllItems.DIAMOND_TOOL_HANDLE);

            entries.accept(AllItems.WOODEN_SWORD_BLADE);
            entries.accept(AllItems.STONE_SWORD_BLADE);
            entries.accept(AllItems.IRON_SWORD_BLADE);
            entries.accept(AllItems.COPPER_SWORD_BLADE);
            entries.accept(AllItems.GOLDEN_SWORD_BLADE);
            entries.accept(AllItems.NETHERITE_SWORD_BLADE);
            entries.accept(AllItems.ZINC_SWORD_BLADE);
            entries.accept(AllItems.BRASS_SWORD_BLADE);
            entries.accept(AllItems.DIAMOND_SWORD_BLADE);

            entries.accept(AllItems.WOODEN_SHOVEL_HEAD);
            entries.accept(AllItems.STONE_SHOVEL_HEAD);
            entries.accept(AllItems.IRON_SHOVEL_HEAD);
            entries.accept(AllItems.COPPER_SHOVEL_HEAD);
            entries.accept(AllItems.GOLDEN_SHOVEL_HEAD);
            entries.accept(AllItems.NETHERITE_SHOVEL_HEAD);
            entries.accept(AllItems.ZINC_SHOVEL_HEAD);
            entries.accept(AllItems.BRASS_SHOVEL_HEAD);
            entries.accept(AllItems.DIAMOND_SHOVEL_HEAD);

            entries.accept(AllItems.WOODEN_PICKAXE_HEAD);
            entries.accept(AllItems.STONE_PICKAXE_HEAD);
            entries.accept(AllItems.IRON_PICKAXE_HEAD);
            entries.accept(AllItems.COPPER_PICKAXE_HEAD);
            entries.accept(AllItems.GOLDEN_PICKAXE_HEAD);
            entries.accept(AllItems.NETHERITE_PICKAXE_HEAD);
            entries.accept(AllItems.ZINC_PICKAXE_HEAD);
            entries.accept(AllItems.BRASS_PICKAXE_HEAD);
            entries.accept(AllItems.DIAMOND_PICKAXE_HEAD);

            entries.accept(AllItems.WOODEN_AXE_HEAD);
            entries.accept(AllItems.STONE_AXE_HEAD);
            entries.accept(AllItems.IRON_AXE_HEAD);
            entries.accept(AllItems.COPPER_AXE_HEAD);
            entries.accept(AllItems.GOLDEN_AXE_HEAD);
            entries.accept(AllItems.NETHERITE_AXE_HEAD);
            entries.accept(AllItems.ZINC_AXE_HEAD);
            entries.accept(AllItems.BRASS_AXE_HEAD);
            entries.accept(AllItems.DIAMOND_AXE_HEAD);

            entries.accept(AllItems.WOODEN_HOE_HEAD);
            entries.accept(AllItems.STONE_HOE_HEAD);
            entries.accept(AllItems.IRON_HOE_HEAD);
            entries.accept(AllItems.COPPER_HOE_HEAD);
            entries.accept(AllItems.GOLDEN_HOE_HEAD);
            entries.accept(AllItems.NETHERITE_HOE_HEAD);
            entries.accept(AllItems.ZINC_HOE_HEAD);
            entries.accept(AllItems.BRASS_HOE_HEAD);
            entries.accept(AllItems.DIAMOND_HOE_HEAD);

            entries.accept(AllItems.WOODEN_TOOL_GRIP);
            entries.accept(AllItems.STONE_TOOL_GRIP);
            entries.accept(AllItems.IRON_TOOL_GRIP);
            entries.accept(AllItems.COPPER_TOOL_GRIP);
            entries.accept(AllItems.GOLDEN_TOOL_GRIP);
            entries.accept(AllItems.NETHERITE_TOOL_GRIP);
            entries.accept(AllItems.ZINC_TOOL_GRIP);
            entries.accept(AllItems.BRASS_TOOL_GRIP);
            entries.accept(AllItems.DIAMOND_TOOL_GRIP);

            entries.accept(AllItems.WOODEN_SWORD_GUARD);
            entries.accept(AllItems.STONE_SWORD_GUARD);
            entries.accept(AllItems.IRON_SWORD_GUARD);
            entries.accept(AllItems.COPPER_SWORD_GUARD);
            entries.accept(AllItems.GOLDEN_SWORD_GUARD);
            entries.accept(AllItems.NETHERITE_SWORD_GUARD);
            entries.accept(AllItems.ZINC_SWORD_GUARD);
            entries.accept(AllItems.BRASS_SWORD_GUARD);
            entries.accept(AllItems.DIAMOND_SWORD_GUARD);

            entries.accept(AllItems.WOODEN_SWORD_POMMEL);
            entries.accept(AllItems.STONE_SWORD_POMMEL);
            entries.accept(AllItems.IRON_SWORD_POMMEL);
            entries.accept(AllItems.COPPER_SWORD_POMMEL);
            entries.accept(AllItems.GOLDEN_SWORD_POMMEL);
            entries.accept(AllItems.NETHERITE_SWORD_POMMEL);
            entries.accept(AllItems.ZINC_SWORD_POMMEL);
            entries.accept(AllItems.BRASS_SWORD_POMMEL);
            entries.accept(AllItems.DIAMOND_SWORD_POMMEL);
        });
    }
}
