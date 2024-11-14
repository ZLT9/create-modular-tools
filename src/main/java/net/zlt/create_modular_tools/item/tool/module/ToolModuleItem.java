package net.zlt.create_modular_tools.item.tool.module;

import com.tterrag.registrate.fabric.TriFunction;
import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.item.TooltipUtils;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ModularToolRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ToolModuleItem extends Item {
    private final List<TriFunction<@Nullable ResourceLocation, ModularToolItem, CompoundTag, @Nullable ResourceLocation>> MODEL_ID_GETTERS = new ArrayList<>();
    private final List<Supplier<List<ResourceLocation>>> MODEL_IDS = new ArrayList<>();

    public ToolModuleItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (TooltipUtils.addHoldShift("create_modular_tools.tooltip.holdForAttributes", "create.tooltip.keyShift", tooltipComponents)) {
            tooltipComponents.add(Component.translatable("item.tool_module.create_modular_tools.attachable_to").withStyle(ChatFormatting.GRAY));
            for (ModularToolItem modularTool : ModularToolRegistry.getAll()) {
                if (modularTool.isCompatible(getType())) {
                    tooltipComponents.add(CommonComponents.space().append(modularTool.getToolCategoryPluralName()).withStyle(ChatFormatting.GRAY));
                }
            }
            tooltipComponents.add(CommonComponents.EMPTY);
            tooltipComponents.add(Component.translatable("item.tool_module.create_modular_tools.modifiers.tool").withStyle(ChatFormatting.GRAY));
            tooltipComponents.addAll(getStatsDescription(stack.getTag()));
        }
    }

    public String getId() {
        return ToolModuleRegistry.getId(this);
    }

    public int getTierLevel() {
        return 0;
    }

    public abstract ToolModuleType getType();

    public boolean isSuitableForWhenAttached(BlockState blockState) {
        return false;
    }

    public int getMiningDurabilityDamageWhenAttached() {
        return 0;
    }

    public int getAttackDurabilityDamageWhenAttached() {
        return 0;
    }

    public float getDestroySpeedBonusWhenAttached(BlockState blockState) {
        return getBaseDestroySpeedBonusWhenAttached();
    }

    public float getBaseDestroySpeedBonusWhenAttached() {
        return 0.0f;
    }

    public float getAttackDamageWhenAttached() {
        return 0.0f;
    }

    public float getAttackSpeedWhenAttached() {
        return 0.0f;
    }

    public int getDurabilityWhenAttached() {
        return 0;
    }

    public boolean isFireproofWhenAttached() {
        return false;
    }

    public boolean isWaterproofWhenAttached() {
        return false;
    }

    public boolean canAttackBlockWhenAttached(BlockState state, Level level, BlockPos pos, Player player) {
        return true;
    }

    public boolean canPerformActionWhenAttached(ToolAction toolAction) {
        return false;
    }

    public InteractionResult useOnWhenAttached(BlockState originalBlockState, UseOnContext context, ModularToolItem modularTool) {
        return InteractionResult.PASS;
    }

    @Nullable
    public SoundEvent getSound() {
        return null;
    }

    public List<MutableComponent> getStatsDescription(@Nullable CompoundTag nbt) {
        List<MutableComponent> description = new ArrayList<>();

        if (nbt != null) {
            EnchantmentHelper.deserializeEnchantments(nbt.getList(ItemStack.TAG_ENCH, Tag.TAG_COMPOUND)).forEach((enchantment, enchantmentLevel) -> description.add(CommonComponents.space().append(enchantment.getFullname(enchantmentLevel))));
        }

        if (isFireproofWhenAttached()) {
            description.add(0, CommonComponents.space().append(Component.translatable("feature.create_modular_tools.fireproof")).withStyle(ChatFormatting.GRAY));
        }

        if (isWaterproofWhenAttached()) {
            description.add(0, CommonComponents.space().append(Component.translatable("feature.create_modular_tools.waterproof")).withStyle(ChatFormatting.GRAY));
        }

        float attackDamage = getAttackDamageWhenAttached();
        if (attackDamage > 0.0f) {
            description.add(CommonComponents.space().append(Component.literal("+")).append(Component.literal(String.valueOf(attackDamage))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_damage")).withStyle(ChatFormatting.BLUE));
        } else if (attackDamage < 0.0f) {
            description.add(CommonComponents.space().append(Component.literal(String.valueOf(attackDamage))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_damage")).withStyle(ChatFormatting.RED));
        }

        float attackSpeed = getAttackSpeedWhenAttached();
        if (attackSpeed > 0.0f) {
            description.add(CommonComponents.space().append(Component.literal("+")).append(Component.literal(String.valueOf(attackSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_speed")).withStyle(ChatFormatting.BLUE));
        } else if (attackSpeed < 0.0f) {
            description.add(CommonComponents.space().append(Component.literal(String.valueOf(attackSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.name.generic.attack_speed")).withStyle(ChatFormatting.RED));
        }

        float miningSpeed = getBaseDestroySpeedBonusWhenAttached();
        if (miningSpeed > 0.0f) {
            description.add(CommonComponents.space().append(Component.literal("+")).append(Component.literal(String.valueOf(miningSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.create_modular_tools.mining_speed")).withStyle(ChatFormatting.BLUE));
        } else if (miningSpeed < 0.0f) {
            description.add(CommonComponents.space().append(Component.literal(String.valueOf(miningSpeed))).append(CommonComponents.space()).append(Component.translatable("attribute.create_modular_tools.mining_speed")).withStyle(ChatFormatting.RED));
        }

        int durability = getDurabilityWhenAttached();
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
