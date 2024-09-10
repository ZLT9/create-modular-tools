package net.zlt.create_modular_tools.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public final class AllSoundTypes {
    private AllSoundTypes() {
    }

    public static final SoundType SAND_MOLD = new SoundType(
        1.0f, 1.0f,
        SoundEvents.WOOD_BREAK,
        SoundEvents.SAND_STEP,
        SoundEvents.WOOD_PLACE,
        SoundEvents.WOOD_HIT,
        SoundEvents.SAND_FALL
    );

    public static void init() {
    }
}
