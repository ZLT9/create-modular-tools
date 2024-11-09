package net.zlt.create_modular_tools.advancement;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class AllCriterionTriggers {
    private AllCriterionTriggers() {
    }

    public static final BoomerangThrowTrigger BOOMERANG_THROWN = register(new BoomerangThrowTrigger());

    public static final BoomerangCatchTrigger BOOMERANG_CAUGHT = register(new BoomerangCatchTrigger());

    public static final BoomerangStopTrigger BOOMERANG_STOPPED = register(new BoomerangStopTrigger());

    public static final BoomerangHitEntityTrigger BOOMERANG_HIT_ENTITY = register(new BoomerangHitEntityTrigger());

    private static <T extends CriterionTrigger<?>> T register(T criterionTrigger) {
        return CriteriaTriggers.register(criterionTrigger);
    }

    public static void init() {
    }
}
