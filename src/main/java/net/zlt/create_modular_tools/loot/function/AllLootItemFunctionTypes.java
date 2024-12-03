package net.zlt.create_modular_tools.loot.function;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllLootItemFunctionTypes {
    private AllLootItemFunctionTypes() {
    }

    public static final LootItemFunctionType SET_UNIQUE_ID = register("set_unique_id", new SetUniqueIdFunction.Serializer());

    private static LootItemFunctionType register(String id, Serializer<? extends LootItemFunction> serializer) {
        return Registry.register(BuiltInRegistries.LOOT_FUNCTION_TYPE, CreateModularTools.asResource(id), new LootItemFunctionType(serializer));
    }

    public static void init() {
    }
}
