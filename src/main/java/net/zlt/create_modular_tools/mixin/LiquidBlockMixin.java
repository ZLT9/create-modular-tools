package net.zlt.create_modular_tools.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.zlt.create_modular_tools.fluid.SolidifiableFluid;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LiquidBlock.class)
public abstract class LiquidBlockMixin {
    @Shadow
    @Final
    protected FlowingFluid fluid;

    @Shadow
    protected abstract void fizz(LevelAccessor level, BlockPos pos);

    @Inject(method = "shouldSpreadLiquid", at = @At("HEAD"), cancellable = true)
    private void createModularTools$solidify(Level level, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (fluid instanceof SolidifiableFluid solidifiableFluid) {
            Block result = solidifiableFluid.solidify(level, pos, state);
            if (result != null) {
                level.setBlock(pos, result.defaultBlockState(), 3);
                fizz(level, pos);
                cir.setReturnValue(false);
            }
        }
    }

    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;OBSIDIAN:Lnet/minecraft/world/level/block/Block;"))
    private Block createModularTools$solidifyByWaterSource(Block original) {
        return fluid instanceof SolidifiableFluid solidifiableFluid ? solidifiableFluid.solidifySourceByWater() : original;
    }

    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;COBBLESTONE:Lnet/minecraft/world/level/block/Block;"))
    private Block createModularTools$solidifyByFlowingWater(Block original) {
        return fluid instanceof SolidifiableFluid solidifiableFluid ? solidifiableFluid.solidifyFlowingByWater() : original;
    }

    @ModifyExpressionValue(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;BASALT:Lnet/minecraft/world/level/block/Block;"))
    private Block createModularTools$solidifyByBlueIceAndSoulSoil(Block original) {
        return fluid instanceof SolidifiableFluid solidifiableFluid ? solidifiableFluid.solidifyByBlueIceAndSoulSoil() : original;
    }
}
