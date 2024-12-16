package net.zlt.create_modular_tools.mixin.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.zlt.create_modular_tools.client.CameraFluidGetter;
import net.zlt.create_modular_tools.fluid.CustomFogLava;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class FogRendererMixin {
    @Shadow
    private static float fogRed;

    @Shadow
    private static float fogGreen;

    @Shadow
    private static float fogBlue;

    @Inject(method = "setupColor", at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/FogRenderer;biomeChangedTime:J", opcode = Opcodes.PUTSTATIC, ordinal = 2))
    private static void createModularTools$setMoltenMetalFogRed(Camera activeRenderInfo, float partialTicks, ClientLevel level, int renderDistanceChunks, float bossColorModifier, CallbackInfo ci) {
        if (!(((CameraFluidGetter) activeRenderInfo).createModularTools$getFluidInCamera().getType() instanceof CustomFogLava customFogLava)) {
            return;
        }

        float[] color = customFogLava.getColor();
        fogRed = color[0];
        fogGreen = color[1];
        fogBlue = color[2];
    }
}
