package net.zlt.create_modular_tools.loot.function;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.commands.arguments.NbtPathArgument;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SetUniqueIdFunction extends LootItemConditionalFunction {
    final String targetPathText;
    final NbtPathArgument.NbtPath targetPath;

    SetUniqueIdFunction(LootItemCondition[] predicates, String targetPathText) {
        super(predicates);
        this.targetPathText = targetPathText;
        targetPath = compileNbtPath(this.targetPathText);
    }

    static NbtPathArgument.NbtPath compileNbtPath(String nbtPathText) {
        try {
            return new NbtPathArgument().parse(new StringReader(nbtPathText));
        } catch (CommandSyntaxException e) {
            throw new IllegalArgumentException("Failed to parse path " + nbtPathText, e);
        }
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        try {
            targetPath.set(stack.getOrCreateTag(), NbtUtils.createUUID(UUID.randomUUID()));
        } catch (CommandSyntaxException e) {
            throw new RuntimeException(e);
        }

        return stack;
    }

    @Override
    public LootItemFunctionType getType() {
        return AllLootItemFunctionTypes.SET_UNIQUE_ID;
    }

    public static class Serializer extends LootItemConditionalFunction.Serializer<SetUniqueIdFunction> {
        @Override
        public void serialize(JsonObject json, SetUniqueIdFunction setUniqueIdFunction, JsonSerializationContext serializationContext) {
            super.serialize(json, setUniqueIdFunction, serializationContext);
            json.addProperty("target", setUniqueIdFunction.targetPathText);
        }

        @Override
        public SetUniqueIdFunction deserialize(JsonObject object, JsonDeserializationContext deserializationContext, LootItemCondition[] conditions) {
            return new SetUniqueIdFunction(conditions, GsonHelper.getAsString(object, "target"));
        }
    }
}
