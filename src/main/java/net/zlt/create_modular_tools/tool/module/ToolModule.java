package net.zlt.create_modular_tools.tool.module;

import com.tterrag.registrate.fabric.TriFunction;
import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolModule {
    private final List<TriFunction<@Nullable ResourceLocation, ModularToolItem, CompoundTag, @Nullable ResourceLocation>> MODEL_ID_GETTERS = new ArrayList<>();
    private final List<Supplier<List<ResourceLocation>>> MODEL_IDS = new ArrayList<>();

    public String getId() {
        return ToolModuleRegistry.getId(this);
    }

    public int getTierLevel() {
        return 0;
    }

    public boolean isSuitableFor(BlockState blockState) {
        return false;
    }

    public int getMiningDurabilityDamage() {
        return 0;
    }

    public int getAttackDurabilityDamage() {
        return 0;
    }

    public float getDestroySpeedBonus(BlockState blockState) {
        return getBaseDestroySpeedBonus();
    }

    public float getBaseDestroySpeedBonus() {
        return 0.0f;
    }

    public float getAttackDamage() {
        return 0.0f;
    }

    public float getAttackSpeed() {
        return 0.0f;
    }

    public int getDurability() {
        return 0;
    }

    public boolean isFireproof() {
        return false;
    }

    public boolean isWaterproof() {
        return false;
    }

    public int getEnchantmentValue() {
        return 0;
    }

    public abstract ToolModuleType getType();

    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return true;
    }

    public boolean canPerformAction(ToolAction toolAction) {
        return false;
    }

    public InteractionResult useOn(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        return InteractionResult.PASS;
    }

    public abstract Item getItem();

    @Nullable
    public SoundEvent getSound() {
        return null;
    }

    public Component getDisplayName() {
        return getItem().getDescription();
    }

    public List<MutableComponent> getDescription() {
        List<MutableComponent> description = new ArrayList<>();

        if (isFireproof()) {
            description.add(0, CommonComponents.space().append(Component.translatable("feature.create_modular_tools.fireproof")).withStyle(ChatFormatting.GRAY));
        }

        if (isWaterproof()) {
            description.add(0, CommonComponents.space().append(Component.translatable("feature.create_modular_tools.waterproof")).withStyle(ChatFormatting.GRAY));
        }

        float attackDamage = getAttackDamage();
        if (attackDamage > 0.0f) {
            description.add(CommonComponents.space().append(Component.literal("+")).append(Component.literal(String.valueOf(attackDamage))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_damage")).withStyle(ChatFormatting.BLUE));
        } else if (attackDamage < 0.0f) {
            description.add(CommonComponents.space().append(Component.literal(String.valueOf(attackDamage))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_damage")).withStyle(ChatFormatting.RED));
        }

        float attackSpeed = getAttackSpeed();
        if (attackSpeed > 0.0f) {
            description.add(CommonComponents.space().append(Component.literal("+")).append(Component.literal(String.valueOf(attackSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_speed")).withStyle(ChatFormatting.BLUE));
        } else if (attackSpeed < 0.0f) {
            description.add(CommonComponents.space().append(Component.literal(String.valueOf(attackSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_speed")).withStyle(ChatFormatting.RED));
        }

        float miningSpeed = getBaseDestroySpeedBonus();
        if (miningSpeed > 0.0f) {
            description.add(CommonComponents.space().append(Component.literal("+")).append(Component.literal(String.valueOf(miningSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.create_modular_tools.mining_speed")).withStyle(ChatFormatting.BLUE));
        } else if (miningSpeed < 0.0f) {
            description.add(CommonComponents.space().append(Component.literal(String.valueOf(miningSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.create_modular_tools.mining_speed")).withStyle(ChatFormatting.RED));
        }

        int durability = getDurability();
        if (durability > 0) {
            description.add(CommonComponents.space().append(Component.literal("+")).append(Component.literal(String.valueOf(durability))).append(CommonComponents.space()).append(Component.translatable("attribute.create_modular_tools.durability")).withStyle(ChatFormatting.BLUE));
        } else if (durability < 0) {
            description.add(CommonComponents.space().append(Component.literal(String.valueOf(durability))).append(CommonComponents.space()).append(Component.translatable("attribute.create_modular_tools.durability")).withStyle(ChatFormatting.RED));
        }

        return description;
    }

    @Environment(EnvType.CLIENT)
    public void registerModelIdGetter(TriFunction<@Nullable ResourceLocation, ModularToolItem, CompoundTag, ResourceLocation> modelIdGetter) {
        MODEL_ID_GETTERS.add(modelIdGetter);
    }

    @Environment(EnvType.CLIENT)
    public void registerModelIds(Supplier<List<ResourceLocation>> modelIds) {
        MODEL_IDS.add(modelIds);
    }

    @Environment(EnvType.CLIENT)
    @Nullable
    public ResourceLocation getModelId(ModularToolItem modularTool, CompoundTag toolNbt) {
        ResourceLocation modelId = null;
        for (TriFunction<@Nullable ResourceLocation, ModularToolItem, CompoundTag, @Nullable ResourceLocation> modelIdGetter : MODEL_ID_GETTERS) {
            modelId = modelIdGetter.apply(modelId, modularTool, toolNbt);
        }
        return modelId;
    }

    @Environment(EnvType.CLIENT)
    public Collection<ResourceLocation> getModelIds() {
        List<ResourceLocation> modelIds = new ArrayList<>();
        for (Supplier<List<ResourceLocation>> modelIdsSupplier : MODEL_IDS) {
            modelIds.addAll(modelIdsSupplier.get());
        }
        return modelIds;
    }
}
