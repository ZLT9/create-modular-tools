package net.zlt.create_modular_tools.sound;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllSoundEvents {
    private AllSoundEvents() {
    }

    public static final SoundEvent ENCHANTED_TOOL_MODULE = register("enchanted_tool_module");

    private static SoundEvent register(String id) {
        ResourceLocation location = CreateModularTools.asResource(id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, location, SoundEvent.createVariableRangeEvent(location));
    }

    public static void init() {
    }
}
