package net.zlt.create_modular_tools.item.tool.module.axe_head;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import net.zlt.create_modular_tools.tool.module.ToolModuleUtils;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BrassAxeHeadToolModuleItem extends AxeHeadToolModuleItem {
    public BrassAxeHeadToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getTierLevel() {
        return ToolModuleConstants.BRASS_TIER_LEVEL;
    }

    @Override
    public float getAttackDamageWhenAttached() {
        return 8.5f;
    }

    @Override
    public float getAttackSpeedWhenAttached() {
        return -2.82f;
    }

    @Override
    public int getDurabilityWhenAttached() {
        return ToolModuleConstants.BRASS_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public InteractionResult useOnWhenAttached(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        InteractionResult result = super.useOnWhenAttached(originalBlockState, context, modularTool);
        return result == InteractionResult.PASS ? ToolUtils.wrenchOnUse(originalBlockState, context) : result;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.BRASS_SOUND;
    }

    @Override
    public float getBaseDestroySpeedBonusWhenAttached() {
        return 5.5f;
    }

    @Override
    public List<MutableComponent> getFeaturesDescription() {
        return ToolModuleUtils.addWrenchingFeatureDescription(super.getFeaturesDescription());
    }
}
