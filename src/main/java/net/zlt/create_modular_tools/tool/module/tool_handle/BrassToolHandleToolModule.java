package net.zlt.create_modular_tools.tool.module.tool_handle;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleConstants;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BrassToolHandleToolModule extends ToolModule {
    @Override
    public int getTierLevel() {
        return ToolModuleConstants.BRASS_TIER_LEVEL;
    }

    @Override
    public float getBaseDestroySpeedBonus() {
        return -0.18f;
    }

    @Override
    public float getAttackSpeed() {
        return -0.18f;
    }

    @Override
    public int getDurability() {
        return ToolModuleConstants.BRASS_DURABILITY;
    }

    @Override
    public int getEnchantmentValue() {
        return 4;
    }

    @Override
    public ToolModuleType getType() {
        return AllToolModuleTypes.TOOL_HANDLE;
    }

    @Override
    public InteractionResult useOn(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        return ToolUtils.wrenchOnUse(originalBlockState, context);
    }

    @Override
    public Item getItem() {
        return AllItems.BRASS_TOOL_HANDLE;
    }

    @Override
    @Nullable
    public SoundEvent getSound() {
        return ToolModuleConstants.BRASS_SOUND;
    }

    @Override
    public List<MutableComponent> getDescription() {
        List<MutableComponent> description = super.getDescription();
        description.add(0, CommonComponents.space().append(Component.translatable("feature.create_modular_tools.wrenching")).withStyle(ChatFormatting.GRAY));
        return description;
    }
}
