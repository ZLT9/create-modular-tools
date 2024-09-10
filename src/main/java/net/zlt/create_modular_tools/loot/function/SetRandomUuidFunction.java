package net.zlt.create_modular_tools.loot.function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SetRandomUuidFunction extends LootItemConditionalFunction {
    protected SetRandomUuidFunction(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        stack.getOrCreateTag().putUUID("UUID", UUID.randomUUID());
        return stack;
    }

    @Override
    public LootItemFunctionType getType() {
        return AllLootItemFunctionTypes.SET_RANDOM_UUID;
    }

    public static class Serializer extends LootItemConditionalFunction.Serializer<SetRandomUuidFunction> {
        @Override
        public SetRandomUuidFunction deserialize(JsonObject object, JsonDeserializationContext deserializationContext, LootItemCondition[] conditions) {
            return new SetRandomUuidFunction(conditions);
        }
    }
}
