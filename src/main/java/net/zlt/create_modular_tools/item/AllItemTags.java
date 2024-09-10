package net.zlt.create_modular_tools.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.zlt.create_modular_tools.CreateModularTools;

public final class AllItemTags {
    private AllItemTags() {
    }

    public static final TagKey<Item> SWORDS_FOR_MOLDS = create("swords_for_molds");
    public static final TagKey<Item> SHOVELS_FOR_MOLDS = create("shovels_for_molds");
    public static final TagKey<Item> PICKAXES_FOR_MOLDS = create("pickaxes_for_molds");
    public static final TagKey<Item> AXES_FOR_MOLDS = create("axes_for_molds");
    public static final TagKey<Item> HOES_FOR_MOLDS = create("hoes_for_molds");

    private static TagKey<Item> create(String path) {
        return TagKey.create(BuiltInRegistries.ITEM.key(), CreateModularTools.asResource(path));
    }

    public static void init() {
    }
}
