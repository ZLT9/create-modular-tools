package net.zlt.create_modular_tools.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.advancement.BoomerangCatchTrigger;
import net.zlt.create_modular_tools.advancement.BoomerangHitEntityTrigger;
import net.zlt.create_modular_tools.advancement.BoomerangStopTrigger;
import net.zlt.create_modular_tools.advancement.BoomerangThrowTrigger;
import net.zlt.create_modular_tools.block.entity.mold.MoldBlockEntity;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.AllToolModules;

import java.util.function.Consumer;

public class DataGenerator implements DataGeneratorEntrypoint {
    public static final ResourceLocation ADVANCEMENTS_BACKGROUND = CreateModularTools.asResource("textures/block/mold_bottom.png");

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(AdvancementsProvider::new);
    }

    static class AdvancementsProvider extends FabricAdvancementProvider {
        protected AdvancementsProvider(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateAdvancement(Consumer<Advancement> consumer) {
            ItemStack rootStack = new ItemStack(AllItems.MODULAR_PICKAXE);
            CompoundTag rootStackToolModulesNbt = new CompoundTag();
            CompoundTag pickaxeHeadNbt = new CompoundTag();
            pickaxeHeadNbt.putString("id", AllToolModules.BRASS_PICKAXE_HEAD.getId());
            rootStackToolModulesNbt.put(AllToolModuleTypes.PICKAXE_HEAD.getTag(), pickaxeHeadNbt);
            CompoundTag toolHandleNbt = new CompoundTag();
            toolHandleNbt.putString("id", AllToolModules.NETHERITE_TOOL_HANDLE.getId());
            rootStackToolModulesNbt.put(AllToolModuleTypes.TOOL_HANDLE.getTag(), toolHandleNbt);
            CompoundTag toolGripNbt = new CompoundTag();
            toolGripNbt.putString("id", AllToolModules.ZINC_TOOL_GRIP.getId());
            rootStackToolModulesNbt.put(AllToolModuleTypes.TOOL_GRIP.getTag(), toolGripNbt);
            CompoundTag toolWrapNbt = new CompoundTag();
            toolWrapNbt.putString("id", AllToolModules.PURPLE_WOOL_TOOL_WRAP.getId());
            rootStackToolModulesNbt.put(AllToolModuleTypes.TOOL_WRAP.getTag(), toolWrapNbt);
            CompoundTag rootStackNbt = rootStack.getOrCreateTag();
            rootStackNbt.put(MoldBlockEntity.TOOL_MODULES_TAG, rootStackToolModulesNbt);

            Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(
                    rootStack,
                    Component.translatable("advancements.create_modular_tools.root.title"),
                    Component.translatable("advancements.create_modular_tools.root.description"),
                    ADVANCEMENTS_BACKGROUND,
                    FrameType.TASK,
                    false,
                    false,
                    false
                )
                .addCriterion("for_free", InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .save(consumer, CreateModularTools.ID + "/root");

            Advancement hiddenPotentialAdvancement = Advancement.Builder.advancement()
                .parent(rootAdvancement)
                .display(
                    AllItems.WOODEN_PICKAXE_HEAD,
                    Component.translatable("advancements.create_modular_tools.hidden_potential.title"),
                    Component.translatable("advancements.create_modular_tools.hidden_potential.description"),
                    ADVANCEMENTS_BACKGROUND,
                    FrameType.GOAL,
                    true,
                    false,
                    true
                )
                .addCriterion("threw_pickaxe_head", new BoomerangThrowTrigger.TriggerInstance(ContextAwarePredicate.ANY))
                .save(consumer, CreateModularTools.ID + "/hidden_potential");

            Advancement minersInterceptionAdvancement = Advancement.Builder.advancement()
                .parent(hiddenPotentialAdvancement)
                .display(
                    AllItems.STONE_PICKAXE_HEAD,
                    Component.translatable("advancements.create_modular_tools.miners_interception.title"),
                    Component.translatable("advancements.create_modular_tools.miners_interception.description"),
                    ADVANCEMENTS_BACKGROUND,
                    FrameType.TASK,
                    true,
                    false,
                    false
                )
                .addCriterion("stopped_pickaxe_head", new BoomerangStopTrigger.TriggerInstance(ContextAwarePredicate.ANY))
                .save(consumer, CreateModularTools.ID + "/miners_interception_0");

            Advancement minersReflexAdvancement = Advancement.Builder.advancement()
                .parent(hiddenPotentialAdvancement)
                .display(
                    AllItems.IRON_PICKAXE_HEAD,
                    Component.translatable("advancements.create_modular_tools.miners_reflex.title"),
                    Component.translatable("advancements.create_modular_tools.miners_reflex.description"),
                    ADVANCEMENTS_BACKGROUND,
                    FrameType.TASK,
                    true,
                    false,
                    false
                )
                .addCriterion("caught_pickaxe_head", new BoomerangCatchTrigger.TriggerInstance(ContextAwarePredicate.ANY))
                .save(consumer, CreateModularTools.ID + "/miners_reflex_00");

            Advancement minersPrecisionAdvancement = Advancement.Builder.advancement()
                .parent(hiddenPotentialAdvancement)
                .display(
                    AllItems.COPPER_PICKAXE_HEAD,
                    Component.translatable("advancements.create_modular_tools.miners_precision.title"),
                    Component.translatable("advancements.create_modular_tools.miners_precision.description"),
                    ADVANCEMENTS_BACKGROUND,
                    FrameType.TASK,
                    true,
                    false,
                    false
                )
                .addCriterion("hit_entity_with_thrown_pickaxe_head", new BoomerangHitEntityTrigger.TriggerInstance(ContextAwarePredicate.ANY))
                .save(consumer, CreateModularTools.ID + "/miners_precision_000");
        }
    }
}
