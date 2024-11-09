package net.zlt.create_modular_tools.item.tool;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModularPickaxeItem extends ModularToolItem {
    public static final ResourceLocation ICON_ID = CreateModularTools.asResource("textures/gui/container/pickaxe.png");

    public ModularPickaxeItem(Properties properties) {
        super(properties);

        addRequired(AllToolModuleTypes.PICKAXE_HEAD, AllToolModuleTypes.TOOL_HANDLE);
        addCompatible(AllToolModuleTypes.TOOL_GRIP);
    }

    @Override
    public boolean canReplace(Mob mob, ItemStack candidate, ItemStack existing) {
        return ToolUtils.canReplaceByDiggerModularTool(mob, candidate, existing);
    }

    @Override
    public boolean canBeReplacedByModularTool(ItemStack candidate) {
        Item candidateItem = candidate.getItem();
        return candidateItem instanceof ModularShovelItem || candidateItem instanceof ModularPickaxeItem || candidateItem instanceof ModularAxeItem || candidateItem instanceof ModularHoeItem;
    }

    @Override
    public boolean canBeReplacedBy(Mob mob, ItemStack candidate, ItemStack existing) {
        return ToolUtils.canDiggerModularToolBeReplacedBy(mob, candidate, existing);
    }

    @Override
    public boolean canApplyEnchantmentOf(EnchantmentCategory category) {
        return category == EnchantmentCategory.DIGGER;
    }

    @Override
    public Component getToolCategorySingularName() {
        return Component.translatable("tool_category.create_modular_tools.pickaxe.singular");
    }

    @Override
    public Component getToolCategoryPluralName() {
        return Component.translatable("tool_category.create_modular_tools.pickaxe.plural");
    }

    @Override
    @Environment(EnvType.CLIENT)
    public ResourceLocation getIcon() {
        return ICON_ID;
    }
}
