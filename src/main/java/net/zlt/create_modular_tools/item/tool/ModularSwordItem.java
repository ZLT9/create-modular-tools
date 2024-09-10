package net.zlt.create_modular_tools.item.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModularSwordItem extends ModularToolItem {
    public static final ResourceLocation ICON_ID = CreateModularTools.asResource("textures/gui/container/sword.png");

    public ModularSwordItem(Properties properties) {
        super(properties);

        addRequired(AllToolModuleTypes.SWORD_BLADE, AllToolModuleTypes.TOOL_HANDLE);
        addCompatible(AllToolModuleTypes.SWORD_GUARD, AllToolModuleTypes.SWORD_POMMEL);
    }

    @Override
    public boolean canReplace(Mob mob, ItemStack candidate, ItemStack existing) {
        Item existingItem = existing.getItem();

        float existingAttackDamage;
        if (existingItem instanceof SwordItem existingSwordItem) {
            existingAttackDamage = existingSwordItem.getDamage();
        } else if (existingItem instanceof ModularToolItem existingModularTool && existingModularTool.canBeReplacedByModularTool(candidate)) {
            existingAttackDamage = existingModularTool.getAttackDamage(existing);
        } else {
            return true;
        }

        float attackDamage = getAttackDamage(candidate);
        if (attackDamage != existingAttackDamage) {
            return attackDamage > existingAttackDamage;
        }

        return mob.canReplaceEqualItem(candidate, existing);
    }

    @Override
    public boolean canBeReplacedByModularTool(ItemStack candidate) {
        return candidate.getItem() instanceof ModularSwordItem;
    }

    @Override
    public boolean canBeReplacedBy(Mob mob, ItemStack candidate, ItemStack existing) {
        if (candidate.getItem() instanceof SwordItem candidateSword) {
            float attackDamage = getAttackDamage(existing);
            float candidateAttackDamage = candidateSword.getDamage();
            if (candidateAttackDamage != attackDamage) {
                return candidateAttackDamage > attackDamage;
            }

            return mob.canReplaceEqualItem(candidate, existing);
        }

        return false;
    }

    @Override
    public boolean canApplyEnchantmentOf(EnchantmentCategory category) {
        return category == EnchantmentCategory.WEAPON;
    }

    @Override
    public Component getToolCategorySingularName() {
        return Component.translatable("tool_category.create_modular_tools.sword.singular");
    }

    @Override
    public Component getToolCategoryPluralName() {
        return Component.translatable("tool_category.create_modular_tools.sword.plural");
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ResourceLocation getIcon() {
        return ICON_ID;
    }
}
