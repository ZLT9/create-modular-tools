package net.zlt.create_modular_tools.damage;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.zlt.create_modular_tools.CreateModularTools;

public final class AllDamageTypes {
    private AllDamageTypes() {
    }

    public static final ResourceKey<DamageType> PASSIVE_BOOMERANG = ResourceKey.create(Registries.DAMAGE_TYPE, CreateModularTools.asResource("passive_boomerang"));
    public static final ResourceKey<DamageType> ACTIVE_BOOMERANG = ResourceKey.create(Registries.DAMAGE_TYPE, CreateModularTools.asResource("active_boomerang"));
}
