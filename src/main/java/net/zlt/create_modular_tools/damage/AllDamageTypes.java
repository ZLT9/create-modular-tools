package net.zlt.create_modular_tools.damage;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllDamageTypes {
    private AllDamageTypes() {
    }

    public static final ResourceKey<DamageType> PASSIVE_BOOMERANG = register("passive_boomerang");
    public static final ResourceKey<DamageType> ACTIVE_BOOMERANG = register("active_boomerang");

    private static ResourceKey<DamageType> register(String path) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, CreateModularTools.asResource(path));
    }

    public static void init() {
    }
}
