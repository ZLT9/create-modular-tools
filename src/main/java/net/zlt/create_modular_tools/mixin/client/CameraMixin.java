package net.zlt.create_modular_tools.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Camera;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.FogType;
import net.zlt.create_modular_tools.client.CameraFluidGetter;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camera.class)
@Environment(EnvType.CLIENT)
public abstract class CameraMixin implements CameraFluidGetter {
    @Unique
    @Nullable
    private static FluidState fluidInCamera;

    @Override
    @Nullable
    public FluidState createModularTools$getFluidInCamera() {
        return fluidInCamera;
    }

    @Inject(method = "getFluidInCamera", at = @At(value = "RETURN", ordinal = 0))
    private void createModularTools$clearFluidInUninitializedCamera(CallbackInfoReturnable<FogType> cir) {
        fluidInCamera = null;
    }

    @Inject(method = "getFluidInCamera", at = @At(value = "RETURN", ordinal = 1))
    private void createModularTools$grabFluidInUnderwaterCamera(CallbackInfoReturnable<FogType> cir, @Local FluidState fluidState) {
        fluidInCamera = fluidState;
    }

    @Inject(method = "getFluidInCamera", at = @At(value = "RETURN", ordinal = 2))
    private void createModularTools$grabFluidInCameraInLava(CallbackInfoReturnable<FogType> cir, @Local(ordinal = 1) FluidState fluidState2) {
        fluidInCamera = fluidState2;
    }

    @Inject(method = "getFluidInCamera", at = @At(value = "RETURN", ordinal = 3))
    private void createModularTools$clearFluidInCameraInPowderSnow(CallbackInfoReturnable<FogType> cir) {
        fluidInCamera = null;
    }

    @Inject(method = "getFluidInCamera", at = @At(value = "RETURN", ordinal = 4))
    private void createModularTools$clearFluidInCamera(CallbackInfoReturnable<FogType> cir) {
        fluidInCamera = null;
    }
}
