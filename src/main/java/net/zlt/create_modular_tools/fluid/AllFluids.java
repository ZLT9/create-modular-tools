package net.zlt.create_modular_tools.fluid;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluids;
import net.zlt.create_modular_tools.CreateModularTools;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public final class AllFluids {
    private AllFluids() {
    }

    public static final FlowingFluid MOLTEN_IRON = register("molten_iron", new MoltenIronFluid.Source());
    public static final FlowingFluid MOLTEN_COPPER = register("molten_copper", new MoltenCopperFluid.Source());
    public static final FlowingFluid MOLTEN_GOLD = register("molten_gold", new MoltenGoldFluid.Source());
    public static final FlowingFluid MOLTEN_NETHERITE = register("molten_netherite", new MoltenNetheriteFluid.Source());
    public static final FlowingFluid MOLTEN_ZINC = register("molten_zinc", new MoltenZincFluid.Source());
    public static final FlowingFluid MOLTEN_BRASS = register("molten_brass", new MoltenBrassFluid.Source());
    public static final FlowingFluid MOLTEN_DIAMOND = register("molten_diamond", new MoltenDiamondFluid.Source());

    public static final FlowingFluid FLOWING_MOLTEN_IRON = register("flowing_molten_iron", new MoltenIronFluid.Flowing());
    public static final FlowingFluid FLOWING_MOLTEN_COPPER = register("flowing_molten_copper", new MoltenCopperFluid.Flowing());
    public static final FlowingFluid FLOWING_MOLTEN_GOLD = register("flowing_molten_gold", new MoltenGoldFluid.Flowing());
    public static final FlowingFluid FLOWING_MOLTEN_NETHERITE = register("flowing_molten_netherite", new MoltenNetheriteFluid.Flowing());
    public static final FlowingFluid FLOWING_MOLTEN_ZINC = register("flowing_molten_zinc", new MoltenZincFluid.Flowing());
    public static final FlowingFluid FLOWING_MOLTEN_BRASS = register("flowing_molten_brass", new MoltenBrassFluid.Flowing());
    public static final FlowingFluid FLOWING_MOLTEN_DIAMOND = register("flowing_molten_diamond", new MoltenDiamondFluid.Flowing());

    private static FlowingFluid register(String path, FlowingFluid fluid) {
        return Registry.register(BuiltInRegistries.FLUID, CreateModularTools.asResource(path), fluid);
    }

    @SuppressWarnings("UnstableApiUsage")
    public static void init() {
        FluidVariantAttributes.register(MOLTEN_IRON, FluidVariantAttributes.getHandler(Fluids.LAVA));
        FluidVariantAttributes.register(MOLTEN_COPPER, FluidVariantAttributes.getHandler(Fluids.LAVA));
        FluidVariantAttributes.register(MOLTEN_GOLD, FluidVariantAttributes.getHandler(Fluids.LAVA));
        FluidVariantAttributes.register(MOLTEN_NETHERITE, FluidVariantAttributes.getHandler(Fluids.LAVA));
        FluidVariantAttributes.register(MOLTEN_ZINC, FluidVariantAttributes.getHandler(Fluids.LAVA));
        FluidVariantAttributes.register(MOLTEN_BRASS, FluidVariantAttributes.getHandler(Fluids.LAVA));
        FluidVariantAttributes.register(MOLTEN_DIAMOND, FluidVariantAttributes.getHandler(Fluids.LAVA));
    }
}
