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
public class ModularHoeItem extends ModularToolItem {
    public static final ResourceLocation ICON_ID = CreateModularTools.asResource("textures/gui/container/hoe.png");

    public ModularHoeItem(Properties properties) {
        super(properties);

        addRequired(AllToolModuleTypes.HOE_HEAD, AllToolModuleTypes.TOOL_HANDLE);
        addCompatible(AllToolModuleTypes.TOOL_GRIP);
    }

    @Override
    public boolean canReplace(Mob mob, ItemStack candidate, ItemStack existing) {
        Item existingItem = existing.getItem();

        if (existingItem instanceof BlockItem) {
            return true;
        }

        float existingAttackDamage;
        if (existingItem instanceof DiggerItem existingDiggerItem) {
            existingAttackDamage = existingDiggerItem.getAttackDamage();
        } else if (existingItem instanceof ModularToolItem existingModularTool && existingModularTool.canBeReplacedByModularTool(candidate)) {
            existingAttackDamage = existingModularTool.getAttackDamage(existing);
        } else {
            return false;
        }

        float attackDamage = getAttackDamage(candidate);
        if (attackDamage != existingAttackDamage) {
            return attackDamage > existingAttackDamage;
        }

        return mob.canReplaceEqualItem(candidate, existing);
    }

    @Override
    public boolean canBeReplacedByModularTool(ItemStack candidate) {
        Item candidateItem = candidate.getItem();
        return candidateItem instanceof ModularShovelItem || candidateItem instanceof ModularPickaxeItem || candidateItem instanceof ModularAxeItem || candidateItem instanceof ModularHoeItem;
    }

    @Override
    public boolean canBeReplacedBy(Mob mob, ItemStack candidate, ItemStack existing) {
        Item candidateItem = candidate.getItem();

        if (candidateItem instanceof SwordItem) {
            return true;
        }

        if (candidateItem instanceof DiggerItem candidateDigger) {
            float attackDamage = getAttackDamage(existing);
            float candidateAttackDamage = candidateDigger.getAttackDamage();
            if (candidateAttackDamage != attackDamage) {
                return candidateAttackDamage > attackDamage;
            }

            return mob.canReplaceEqualItem(candidate, existing);
        }

        return false;
    }

    @Override
    public boolean canApplyEnchantmentOf(EnchantmentCategory category) {
        return category == EnchantmentCategory.DIGGER;
    }

    @Override
    public Component getToolCategorySingularName() {
        return Component.translatable("tool_category.create_modular_tools.hoe.singular");
    }

    @Override
    public Component getToolCategoryPluralName() {
        return Component.translatable("tool_category.create_modular_tools.hoe.plural");
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ResourceLocation getIcon() {
        return ICON_ID;
    }
}
