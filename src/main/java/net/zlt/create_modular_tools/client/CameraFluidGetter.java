package net.zlt.create_modular_tools.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.level.material.FluidState;

@Environment(EnvType.CLIENT)
public interface CameraFluidGetter {
    FluidState createModularTools$getFluidInCamera();
}
