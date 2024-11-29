package net.zlt.create_modular_tools.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.AllToolModules;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ThrownDarkOakPickaxeHead extends ThrownBoomerang {
    public ThrownDarkOakPickaxeHead(EntityType<? extends ThrownBoomerang> entityType, Level level) {
        super(AllToolModules.DARK_OAK_PICKAXE_HEAD, AllItems.DARK_OAK_PICKAXE_HEAD, entityType, level);
    }

    public ThrownDarkOakPickaxeHead(Level level, LivingEntity shooter, ItemStack stack) {
        super(AllToolModules.DARK_OAK_PICKAXE_HEAD, AllEntityTypes.DARK_OAK_PICKAXE_HEAD, level, shooter, stack);
    }

    @Override
    protected float getAttackDamage() {
        return AllToolModules.DARK_OAK_PICKAXE_HEAD.getAttackDamageWhenAttached();
    }
}
