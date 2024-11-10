package net.zlt.create_modular_tools.container.menu;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.zlt.create_modular_tools.block.entity.CreativeModularToolTableBlockEntity;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.item.tool.module.ToolModuleItem;
import net.zlt.create_modular_tools.tool.ModularToolRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CreativeModularToolTableMenu extends AbstractContainerMenu {
    private final Container CONTAINER;
    private ToolModuleType selectedToolModuleType;
    private int selectedToolModuleTypeId;
    private ModularToolItem selectedModularTool;
    private int selectedModularToolId;

    public CreativeModularToolTableMenu(int id, Inventory inventory) {
        this(id, inventory, new SimpleContainer(1));
    }

    public CreativeModularToolTableMenu(int id, Inventory inventory, Container container) {
        super(AllMenuTypes.CREATIVE_MODULAR_TOOL_TABLE, id);

        checkContainerSize(container, 1);

        CONTAINER = container;

        selectedModularTool = ModularToolRegistry.getAll().get(0);
        selectedModularToolId = -1;

        selectedToolModuleType = selectedModularTool.getCompatible().get(0);
        selectedToolModuleTypeId = -(ModularToolRegistry.getAll().size() + 1);

        container.startOpen(inventory.player);

        if (container instanceof CreativeModularToolTableBlockEntity && container.getItem(0).getItem() instanceof ModularToolItem oldModularTool && oldModularTool != selectedModularTool) {
            setSelectedModularToolInContainer(oldModularTool);
        }

        addSlot(new Slot(container, 0, 145, 33) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                set(stack.copy());

                SoundManager soundManager = Minecraft.getInstance().getSoundManager();
                soundManager.play(SimpleSoundInstance.forUI(SoundEvents.ITEM_PICKUP, 2.0f, 0.1f));
                soundManager.play(SimpleSoundInstance.forUI(SoundEvents.WOODEN_BUTTON_CLICK_ON, 1.0f, 0.2f));

                CompoundTag nbt = stack.getOrCreateTag();
                nbt.putUUID("UUID", UUID.randomUUID());
                nbt.remove("id");

                super.onTake(player, stack);
            }
        });

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                addSlot(new Slot(inventory, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }
        for (int x = 0; x < 9; ++x) {
            addSlot(new Slot(inventory, x, 8 + x * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return CONTAINER.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (id < 0) {
            int tabIndex = -(id + 1);
            if (tabIndex < ModularToolRegistry.getAll().size()) {
                if (selectedModularToolId == id) {
                    return true;
                }

                ModularToolItem oldSelectedModularTool = selectedModularTool;

                selectedModularTool = ModularToolRegistry.getAll().get(tabIndex);
                selectedModularToolId = id;

                selectedToolModuleType = selectedModularTool.getCompatible().get(0);
                selectedToolModuleTypeId = -(ModularToolRegistry.getAll().size() + 1);

                setSelectedModularToolInContainer(oldSelectedModularTool);
            } else if (selectedToolModuleTypeId != id) {
                tabIndex = tabIndex - ModularToolRegistry.getAll().size();
                if (tabIndex < selectedModularTool.getCompatible().size()) {
                    selectedToolModuleType = selectedModularTool.getCompatible().get(tabIndex);
                    selectedToolModuleTypeId = id;
                }
            }

            return true;
        }

        ItemStack modularToolStack = CONTAINER.getItem(0);

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(modularToolStack);
        if (toolModulesNbt.isEmpty()) {
            return false;
        }

        if (!selectedModularTool.isRequired(selectedToolModuleType)) {
            if (id == 0) {
                if (ToolModuleRegistry.containsId(toolModulesNbt.getCompound(selectedToolModuleType.getTag()).getString("id"))) {
                    toolModulesNbt.remove(selectedToolModuleType.getTag());
                    CONTAINER.setChanged();
                    broadcastChanges();
                }

                return true;
            }

            --id;
        }

        if (!(modularToolStack.getItem() instanceof ModularToolItem modularTool)) {
            return true;
        }

        List<ToolModuleItem> toolModules = ToolModuleRegistry.getAllOfType(selectedToolModuleType);
        if (id >= toolModules.size()) {
            return false;
        }

        if (!modularTool.isCompatible(selectedToolModuleType)) {
            CompoundTag newToolModulesNbt = new CompoundTag();
            for (ToolModuleType toolModuleType : selectedModularTool.getCompatible()) {
                ToolModuleItem toolModule = ToolModuleRegistry.get(toolModulesNbt.getCompound(toolModuleType.getTag()).getString("id"));
                if (toolModule == null && selectedModularTool.isRequired(toolModuleType)) {
                    toolModule = ToolModuleRegistry.getAllOfType(toolModuleType).get(0);
                }
                if (toolModule != null) {
                    CompoundTag newToolModuleNbt = new CompoundTag();
                    newToolModuleNbt.putString("id", toolModule.getId());
                    newToolModulesNbt.put(toolModuleType.getTag(), newToolModuleNbt);
                }
            }

            ItemStack newModularTool = new ItemStack(selectedModularTool);
            CONTAINER.setItem(0, newModularTool);

            CompoundTag newModularToolNbt = newModularTool.getOrCreateTag();
            newModularToolNbt.putString("id", selectedModularTool.getId());
            newModularToolNbt.put(SandMoldBlockEntity.TOOL_MODULES_TAG, newToolModulesNbt);

            toolModulesNbt = newToolModulesNbt;
        }

        CompoundTag toolModuleNbt = new CompoundTag();
        toolModuleNbt.putString("id", toolModules.get(id).getId());
        toolModulesNbt.put(selectedToolModuleType.getTag(), toolModuleNbt);

        CONTAINER.setChanged();
        broadcastChanges();

        return true;
    }

    public ToolModuleType getSelectedToolModuleType() {
        return selectedToolModuleType;
    }

    public int getSelectedToolModuleTypeId() {
        return selectedToolModuleTypeId;
    }

    public ModularToolItem getSelectedModularTool() {
        return selectedModularTool;
    }

    public int getSelectedModularToolId() {
        return selectedModularToolId;
    }

    private void setSelectedModularToolInContainer(ModularToolItem oldModularTool) {
        CompoundTag newToolModulesNbt = new CompoundTag();
        CompoundTag oldToolModulesNbt = ToolUtils.getToolModulesNbt(CONTAINER.getItem(0));

        if (!oldToolModulesNbt.isEmpty()) {
            for (ToolModuleType toolModuleType : oldModularTool.getCompatible()) {
                String toolModuleId = oldToolModulesNbt.getCompound(toolModuleType.getTag()).getString("id");
                if (ToolModuleRegistry.containsId(toolModuleId) && selectedModularTool.isCompatible(toolModuleType)) {
                    CompoundTag newToolModuleNbt = new CompoundTag();
                    newToolModuleNbt.putString("id", toolModuleId);
                    newToolModulesNbt.put(toolModuleType.getTag(), newToolModuleNbt);
                }
            }
        }

        for (ToolModuleType toolModuleType : selectedModularTool.getRequired()) {
            if (!newToolModulesNbt.contains(toolModuleType.getTag(), Tag.TAG_STRING)) {
                CompoundTag newToolModuleNbt = new CompoundTag();
                newToolModuleNbt.putString("id", ToolModuleRegistry.getAllOfType(toolModuleType).get(0).getId());
                newToolModulesNbt.put(toolModuleType.getTag(), newToolModuleNbt);
            }
        }

        ItemStack newModularToolStack = new ItemStack(selectedModularTool);
        CONTAINER.setItem(0, newModularToolStack);

        CompoundTag newModularToolNbt = newModularToolStack.getOrCreateTag();
        newModularToolNbt.putString("id", selectedModularTool.getId());
        newModularToolNbt.put(SandMoldBlockEntity.TOOL_MODULES_TAG, newToolModulesNbt);

        CONTAINER.setChanged();
        broadcastChanges();
    }
}
