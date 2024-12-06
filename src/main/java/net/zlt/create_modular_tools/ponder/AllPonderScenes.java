package net.zlt.create_modular_tools.ponder;

import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.utility.Pointing;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.zlt.create_modular_tools.AllTagNames;
import net.zlt.create_modular_tools.block.AllBlocks;
import net.zlt.create_modular_tools.block.entity.mold.ToolMaterialMoldBlockEntity;
import net.zlt.create_modular_tools.block.mold.AllMoldBlocks;
import net.zlt.create_modular_tools.fluid.AllFluids;
import net.zlt.create_modular_tools.item.AllItems;
import net.zlt.create_modular_tools.item.mold.AllMoldItems;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.AllToolModuleTypes;
import net.zlt.create_modular_tools.tool.module.AllToolModules;

public final class AllPonderScenes {
    private AllPonderScenes() {
    }

    public static void moldSetup(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("mold_setup", "Setting up Molds");
        scene.configureBasePlate(0, 0, 5);
        scene.world.showSection(util.select.layer(0), Direction.UP);

        BlockPos mold = util.grid.at(2, 1, 2);

        scene.idle(5);
        scene.world.showSection(util.select.position(mold), Direction.DOWN);
        scene.idle(20);

        scene.overlay.showText(40)
            .text("Place a mold to start preparing it for use")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(60);

        ItemStack sand = new ItemStack(Items.SAND);
        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick().withItem(sand), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Use sand, red sand, or concrete powder to fill it")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.replaceBlocks(util.select.position(mold), AllMoldBlocks.SAND_OAK_MOLD.defaultBlockState(), true);
        scene.idle(40);

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick(), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Right-Click with an empty hand to remove its contents")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.replaceBlocks(util.select.position(mold), AllBlocks.OAK_MOLD.defaultBlockState(), true);
        scene.idle(40);

        scene.addKeyframe();

        scene.world.replaceBlocks(util.select.position(mold), AllMoldBlocks.SAND_OAK_MOLD.defaultBlockState(), false);
        ItemStack pickaxe = new ItemStack(Items.IRON_PICKAXE);
        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick().withItem(pickaxe), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Use a tool to cast its shape")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.replaceBlocks(util.select.position(mold), AllMoldBlocks.PICKAXE_SAND_OAK_MOLD.defaultBlockState(), true);
        scene.idle(40);

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick(), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Right-Click with an empty hand to remove its shape")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.replaceBlocks(util.select.position(mold), AllMoldBlocks.SAND_OAK_MOLD.defaultBlockState(), true);
        scene.idle(40);
    }

    public static void moldUsing(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("mold_using", "Using Molds");

        BlockPos mold = util.grid.at(2, 1, 2);
        BlockPos spout = mold.above(2);
        BlockPos fan = mold.south(2);
        BlockPos water = mold.south();
        BlockPos cog = fan.south();
        BlockPos largeCog = cog.below().west();
        BlockPos bottomGearbox = mold.east(3).below();
        BlockPos endShaft = spout.east();

        scene.configureBasePlate(0, 0, 5);
        scene.world.showSection(util.select.layer(0).substract(util.select.position(largeCog)).substract(util.select.position(bottomGearbox)), Direction.UP);

        scene.world.modifyBlockEntity(mold, ToolMaterialMoldBlockEntity.class, ToolMaterialMoldBlockEntity::clearToolModules);

        scene.idle(5);
        scene.world.showSection(util.select.position(mold), Direction.DOWN);
        scene.idle(20);

        ItemStack grip = new ItemStack(AllItems.COPPER_TOOL_GRIP);
        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick().withItem(grip), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Use a compatible tool module to put it in the mold")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.modifyBlockEntity(mold, ToolMaterialMoldBlockEntity.class, be -> be.putToolModule(AllToolModuleTypes.TOOL_GRIP, AllToolModules.COPPER_TOOL_GRIP, null));
        scene.idle(40);

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick(), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Right-Click a module with an empty hand to remove it from the mold")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.modifyBlockEntity(mold, ToolMaterialMoldBlockEntity.class, be -> be.putToolModule(AllToolModuleTypes.TOOL_GRIP, null, null));
        scene.idle(40);

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick(), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Right-Click the shape of an optional tool module to remove it from the mold")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.modifyBlockEntity(mold, ToolMaterialMoldBlockEntity.class, be -> be.removeToolModule(AllToolModuleTypes.TOOL_GRIP));
        scene.idle(40);

        // Spout

        scene.addKeyframe();

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).rightClick().withItem(new ItemStack(AllItems.ZINC_TOOL_HANDLE)), 10);
        scene.idle(5);
        scene.world.modifyBlockEntity(mold, ToolMaterialMoldBlockEntity.class, be -> be.putToolModule(AllToolModuleTypes.TOOL_HANDLE, AllToolModules.ZINC_TOOL_HANDLE, null));
        scene.idle(25);

        ItemStack inputMoldStack = new ItemStack(AllMoldItems.PICKAXE_SAND_OAK_MOLD);
        ItemStack outputMoldStack = new ItemStack(AllMoldItems.PICKAXE_SAND_OAK_MOLD);
        ItemStack solidMoldStack = new ItemStack(AllMoldItems.PICKAXE_SAND_OAK_MOLD);
        CompoundTag inputMoldStackNbt = inputMoldStack.getOrCreateTag();
        CompoundTag outputMoldStackNbt = outputMoldStack.getOrCreateTag();
        CompoundTag solidMoldStackNbt = solidMoldStack.getOrCreateTag();
        CompoundTag inputBlockEntityNbt = new CompoundTag();
        CompoundTag outputBlockEntityNbt = new CompoundTag();
        CompoundTag solidBlockEntityNbt = new CompoundTag();
        scene.world.modifyBlockEntity(mold, ToolMaterialMoldBlockEntity.class, be -> {
            CompoundTag inputToolModulesNbt = be.getToolModulesNbt();
            inputBlockEntityNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, inputToolModulesNbt);

            CompoundTag outputToolModulesNbt = inputToolModulesNbt.copy();
            CompoundTag outputPickaxeHeadNbt = outputToolModulesNbt.getCompound(AllToolModuleTypes.PICKAXE_HEAD.getTag());
            outputPickaxeHeadNbt.putString(AllTagNames.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.FLUID.toString());
            outputPickaxeHeadNbt.putString(AllTagNames.TOOL_MODULE_ID, BuiltInRegistries.FLUID.getKey(AllFluids.MOLTEN_BRASS).toString());
            outputBlockEntityNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, outputToolModulesNbt);

            CompoundTag solidToolModulesNbt = inputToolModulesNbt.copy();
            CompoundTag solidPickaxeHeadNbt = solidToolModulesNbt.getCompound(AllToolModuleTypes.PICKAXE_HEAD.getTag());
            solidPickaxeHeadNbt.putString(AllTagNames.MOLD_SLOT_STATE, ToolUtils.MoldSlotState.SOLID.toString());
            solidPickaxeHeadNbt.putString(AllTagNames.TOOL_MODULE_ID, AllToolModules.BRASS_PICKAXE_HEAD.getId());
            solidBlockEntityNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, solidToolModulesNbt);
        });
        inputMoldStackNbt.put(BlockItem.BLOCK_ENTITY_TAG, inputBlockEntityNbt);
        outputMoldStackNbt.put(BlockItem.BLOCK_ENTITY_TAG, outputBlockEntityNbt);
        solidMoldStackNbt.put(BlockItem.BLOCK_ENTITY_TAG, solidBlockEntityNbt);

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(mold), Pointing.DOWN).leftClick(), 40);
        scene.idle(7);
        scene.overlay.showText(40)
            .text("Left-Click the mold to grab it")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(mold, Direction.WEST));
        scene.idle(20);
        scene.world.destroyBlock(mold);
        scene.world.hideSection(util.select.position(mold), Direction.UP);
        scene.idle(40);

        scene.world.setBlock(mold, com.simibubi.create.AllBlocks.DEPOT.getDefaultState(), false);
        scene.world.showSection(util.select.fromTo(mold, spout), Direction.DOWN);
        scene.idle(20);
        scene.world.createItemOnBeltLike(mold, Direction.NORTH, inputMoldStack);
        scene.idle(20);

        scene.overlay.showText(40)
            .text("Use a Spout to pour lava or molten metal into the mold's empty slots")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(spout, Direction.WEST));
        scene.idle(20);
        scene.world.modifyBlockEntityNBT(util.select.position(spout), SpoutBlockEntity.class, nbt -> nbt.putInt("ProcessingTicks", 20));
        scene.idle(20);
        scene.world.removeItemsFromBelt(mold);
        scene.world.createItemOnBeltLike(mold, Direction.UP, outputMoldStack);
        scene.world.modifyBlockEntityNBT(util.select.position(spout), SpoutBlockEntity.class, nbt -> nbt.putBoolean("Splash", true));
        scene.idle(20);

        // Encased Fan

        scene.addKeyframe();

        scene.world.hideSection(util.select.position(spout), Direction.UP);
        scene.idle(10);
        scene.world.showSection(util.select.fromTo(fan, cog), Direction.DOWN);
        scene.world.showSection(util.select.position(largeCog), Direction.UP);
        scene.world.setKineticSpeed(util.select.fromTo(fan, largeCog), -32);
        scene.idle(10);
        scene.world.showSection(util.select.position(water), Direction.EAST);
        scene.idle(10);

        scene.overlay.showText(40)
            .text("Use an Encased Fan with water to solidify the molten metal in the mold")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(fan, Direction.WEST));
        scene.idle(20);
        scene.world.removeItemsFromBelt(mold);
        scene.world.createItemOnBeltLike(mold, Direction.UP, solidMoldStack);
        scene.idle(20);

        // Mechanical Press

        scene.addKeyframe();

        scene.world.hideSection(util.select.position(largeCog), Direction.DOWN);
        scene.world.hideSection(util.select.fromTo(water, cog), Direction.UP);
        scene.idle(10);
        scene.world.replaceBlocks(util.select.position(spout), com.simibubi.create.AllBlocks.MECHANICAL_PRESS.getDefaultState().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), false);
        scene.world.showSection(util.select.position(spout), Direction.DOWN);
        scene.world.showSection(util.select.fromTo(bottomGearbox, endShaft), Direction.UP);
        scene.world.setKineticSpeed(util.select.fromTo(bottomGearbox, endShaft), 32);
        scene.world.setKineticSpeed(util.select.position(spout), 32);
        scene.idle(10);

        scene.overlay.showText(40)
            .text("Use a Mechanical Press to assemble the modular tool")
            .placeNearTarget()
            .pointAt(util.vector.blockSurface(spout, Direction.WEST));
        scene.idle(10);
        scene.world.modifyBlockEntity(spout, MechanicalPressBlockEntity.class, be -> be.getPressingBehaviour().start(PressingBehaviour.Mode.BELT));
        scene.idle(30);
        scene.world.modifyBlockEntity(spout, MechanicalPressBlockEntity.class, be -> be.getPressingBehaviour().makePressingParticleEffect(util.vector.centerOf(mold.south()).add(0, 8 / 16f, 0), solidMoldStack));
        scene.world.removeItemsFromBelt(mold);
        scene.world.createItemOnBeltLike(mold, Direction.UP, AllMoldItems.PICKAXE_SAND_OAK_MOLD.getDefaultInstance());
        ItemStack modularPickaxe = new ItemStack(AllItems.MODULAR_PICKAXE);
        CompoundTag modularPickaxeNbt = modularPickaxe.getOrCreateTag();
        CompoundTag toolModulesNbt = new CompoundTag();
        CompoundTag handleNbt = new CompoundTag();
        handleNbt.putString(AllTagNames.TOOL_MODULE_ID, AllToolModules.ZINC_TOOL_HANDLE.getId());
        CompoundTag headNbt = new CompoundTag();
        headNbt.putString(AllTagNames.TOOL_MODULE_ID, AllToolModules.BRASS_PICKAXE_HEAD.getId());
        toolModulesNbt.put(AllToolModuleTypes.TOOL_HANDLE.getTag(), handleNbt);
        toolModulesNbt.put(AllToolModuleTypes.PICKAXE_HEAD.getTag(), headNbt);
        modularPickaxeNbt.put(ToolMaterialMoldBlockEntity.TOOL_MODULES_TAG, toolModulesNbt);
        scene.world.createItemEntity(util.vector.centerOf(mold.above()), util.vector.of(0, 0, 0), modularPickaxe);
    }

    public static void init() {
    }
}
