package net.zlt.create_modular_tools.item.tool;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.simibubi.create.foundation.utility.Components;
import io.github.fabricators_of_create.porting_lib.item.DamageableItem;
import io.github.fabricators_of_create.porting_lib.tool.ToolAction;
import io.github.fabricators_of_create.porting_lib.tool.addons.ToolActionItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.item.CustomEnchantableItem;
import net.zlt.create_modular_tools.item.FireproofItem;
import net.zlt.create_modular_tools.item.TooltipUtils;
import net.zlt.create_modular_tools.item.WaterproofItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.ModularToolRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ModularToolItem extends Item implements DamageableItem, ToolActionItem, FireproofItem, WaterproofItem, CustomEnchantableItem {
    protected final List<ToolModuleType> COMPATIBLE;
    protected final List<ToolModuleType> REQUIRED;
    protected final TreeSet<ToolModuleType> COMPATIBLE_BY_LAYER;

    public ModularToolItem(Properties properties) {
        super(properties.stacksTo(1));

        COMPATIBLE = new ArrayList<>();
        REQUIRED = new ArrayList<>();
        COMPATIBLE_BY_LAYER = new TreeSet<>(Comparator.comparingInt(ToolModuleType::getLayer).thenComparing(ToolModuleType::getTag));
    }

    @Override
    public boolean isSuitableFor(ItemStack stack, BlockState state) {
        if (isBroken(stack)) {
            return false;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null && toolModule.isSuitableForWhenAttached(state)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        if (isBroken(stack)) {
            return false;
        }

        if (level.isClientSide || state.getDestroySpeed(level, pos) == 0.0f) {
            return true;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return true;
        }

        int durabilityDamage = 0;
        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                durabilityDamage += toolModule.getMiningDurabilityDamageWhenAttached();
            }
        }

        hurtAndBreak(stack, durabilityDamage, miningEntity, miningEntity.getUsedItemHand());

        return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemStack stack = context.getItemInHand();
        if (isBroken(stack)) {
            return InteractionResult.PASS;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return InteractionResult.PASS;
        }

        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());

        InteractionResult result = InteractionResult.PASS;
        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                InteractionResult currentResult = toolModule.useOnWhenAttached(blockState, context, this);
                if (currentResult == InteractionResult.SUCCESS) {
                    result = InteractionResult.SUCCESS;
                } else if (currentResult == InteractionResult.CONSUME && result != InteractionResult.SUCCESS) {
                    result = InteractionResult.CONSUME;
                }
            }
        }

        return result;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (isBroken(stack)) {
            return 1.0f;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return 1.0f;
        }

        float destroySpeed = 1.0f;
        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                destroySpeed += toolModule.getDestroySpeedBonusWhenAttached(state);
            }
        }

        return destroySpeed;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(player.getMainHandItem());
        if (toolModulesNbt.isEmpty()) {
            return true;
        }

        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null && !toolModule.canAttackBlockWhenAttached(state, level, pos, player)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (isBroken(stack)) {
            return true;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return true;
        }

        int durabilityDamage = 0;
        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                durabilityDamage += toolModule.getAttackDurabilityDamageWhenAttached();
            }
        }

        hurtAndBreak(stack, durabilityDamage, attacker, attacker.getUsedItemHand());

        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (isBroken(stack)) {
            tooltipComponents.add(Components.translatable("create_modular_tools.hint.modular_tool.broken").withStyle(ChatFormatting.RED));
        }

        if (TooltipUtils.addHoldShift("create_modular_tools.tooltip.holdForAttributes", "create.tooltip.keyShift", tooltipComponents)) {
            CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
            if (toolModulesNbt.isEmpty()) {
                return;
            }

            for (ToolModuleType toolModuleType : COMPATIBLE) {
                CompoundTag toolModuleNbt = toolModulesNbt.getCompound(toolModuleType.getTag());
                ToolModuleItem toolModule = ToolModuleRegistry.get(toolModuleNbt.getString("id"));
                if (toolModule != null) {
                    tooltipComponents.add(toolModule.getDescription());
                    tooltipComponents.addAll(toolModule.getStatsDescription(toolModuleNbt.getCompound("tag")));
                }
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        if (slot != EquipmentSlot.MAINHAND || isBroken(stack)) {
            return super.getAttributeModifiers(stack, slot);
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return super.getAttributeModifiers(stack, slot);
        }

        float attackDamage = 0.0f;
        float attackSpeed = 0.0f;

        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                attackDamage += toolModule.getAttackDamageWhenAttached();
                attackSpeed += toolModule.getAttackSpeedWhenAttached();
            }
        }

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
            Attributes.ATTACK_DAMAGE,
            new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", attackDamage, AttributeModifier.Operation.ADDITION)
        );
        builder.put(
            Attributes.ATTACK_SPEED,
            new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", attackSpeed, AttributeModifier.Operation.ADDITION)
        );
        return builder.build();
    }

    @Override
    public boolean canBeDepleted() {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F - (float) stack.getDamageValue() * 13.0F / (float) getMaxDamage(stack));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float maxDamage = (float) getMaxDamage(stack);
        float f = Math.max(0.0F, (maxDamage - (float) stack.getDamageValue()) / maxDamage);
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return 0;
        }

        int durability = 0;
        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                durability += toolModule.getDurabilityWhenAttached();
            }
        }

        return durability;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        if (isBroken(stack)) {
            return false;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null && toolModule.canPerformActionWhenAttached(toolAction)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isFireproof(ItemStack stack) {
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null && toolModule.isFireproofWhenAttached()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isWaterproof(ItemStack stack) {
        if (isBroken(stack)) {
            return false;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null && toolModule.isWaterproofWhenAttached()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);

        CompoundTag toolModulesNbt = new CompoundTag();
        for (ToolModuleType toolModuleType : REQUIRED) {
            CompoundTag toolModuleNbt = new CompoundTag();
            toolModuleNbt.putString("id", ToolModuleRegistry.getAllOfType(toolModuleType).get(0).getId());
            toolModulesNbt.put(toolModuleType.getTag(), toolModuleNbt);
        }

        CompoundTag nbt = stack.getOrCreateTag();
        nbt.put(SandMoldBlockEntity.TOOL_MODULES_TAG, toolModulesNbt);

        return stack;
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        if (isBroken(stack)) {
            return 0;
        }

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return 0;
        }

        int enchantmentValue = 0;
        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                enchantmentValue += toolModule.getEnchantmentValue();
            }
        }

        return enchantmentValue;
    }

    public float getAttackDamage(ItemStack stack) {
        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(stack);
        if (toolModulesNbt.isEmpty()) {
            return 0.0f;
        }

        float attackDamage = 0.0f;
        for (ToolModuleType toolModuleType : COMPATIBLE) {
            ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
            if (toolModule != null) {
                attackDamage += toolModule.getAttackDamageWhenAttached();
            }
        }

        return attackDamage;
    }

    public boolean canReplace(Mob mob, ItemStack candidate, ItemStack existing) {
        return false;
    }

    public boolean canBeReplacedByModularTool(ItemStack candidate) {
        return false;
    }

    public boolean canBeReplacedBy(Mob mob, ItemStack candidate, ItemStack existing) {
        return false;
    }

    public boolean canApplyEnchantmentOf(EnchantmentCategory category) {
        return false;
    }

    public void hurtAndBreak(ItemStack stack, int amount, LivingEntity entity, InteractionHand interactionHand) {
        if (!isBroken(stack) && !entity.level().isClientSide && (!(entity instanceof Player player) || !player.getAbilities().instabuild) && stack.hurt(amount, entity.getRandom(), entity instanceof ServerPlayer serverPlayer ? serverPlayer : null)) {
            stack.setDamageValue(getMaxDamage(stack));
            entity.broadcastBreakEvent(interactionHand);
        }
    }

    public boolean isBroken(ItemStack stack) {
        return getDamage(stack) >= getMaxDamage(stack);
    }

    public String getId() {
        return ModularToolRegistry.getId(this);
    }

    public abstract Component getToolCategorySingularName();

    public abstract Component getToolCategoryPluralName();

    @Environment(EnvType.CLIENT)
    public abstract ResourceLocation getIcon();

    public void addCompatible(ToolModuleType toolModuleType) {
        if (isCompatible(toolModuleType)) {
            CreateModularTools.LOGGER.error("The given tool module type is already compatible with this modular tool: {}", toolModuleType);
            throw new IllegalArgumentException();
        }

        COMPATIBLE.add(toolModuleType);
        COMPATIBLE_BY_LAYER.add(toolModuleType);
    }

    public void addCompatible(ToolModuleType... toolModuleTypes) {
        for (ToolModuleType toolModuleType : toolModuleTypes) {
            addCompatible(toolModuleType);
        }
    }

    public void addRequired(ToolModuleType toolModuleType) {
        if (isRequired(toolModuleType)) {
            CreateModularTools.LOGGER.error("The given tool module type is already required by this modular tool: {}", toolModuleType);
            throw new IllegalArgumentException();
        }

        REQUIRED.add(toolModuleType);
        addCompatible(toolModuleType);
    }

    public void addRequired(ToolModuleType... toolModuleTypes) {
        for (ToolModuleType toolModuleType : toolModuleTypes) {
            addRequired(toolModuleType);
        }
    }

    public boolean isCompatible(ToolModuleType toolModuleType) {
        return COMPATIBLE.contains(toolModuleType);
    }

    public boolean isRequired(ToolModuleType toolModuleType) {
        return REQUIRED.contains(toolModuleType);
    }

    @Unmodifiable
    public List<ToolModuleType> getCompatible() {
        return COMPATIBLE;
    }

    @Unmodifiable
    public Set<ToolModuleType> getCompatibleByLayer() {
        return COMPATIBLE_BY_LAYER;
    }

    @Unmodifiable
    public List<ToolModuleType> getRequired() {
        return REQUIRED;
    }
}
