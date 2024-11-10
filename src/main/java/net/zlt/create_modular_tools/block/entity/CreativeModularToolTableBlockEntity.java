package net.zlt.create_modular_tools.block.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.container.menu.CreativeModularToolTableMenu;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.AllModularTools;
import net.zlt.create_modular_tools.tool.ModularToolRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CreativeModularToolTableBlockEntity extends BlockEntity implements WorldlyContainer, MenuProvider {
    public static final String MODULAR_TOOL_TAG = "ModularTool";

    private ItemStack modularToolStack;

    public CreativeModularToolTableBlockEntity(BlockPos pos, BlockState blockState) {
        super(AllBlockEntityTypes.CREATIVE_MODULAR_TOOL_TABLE, pos, blockState);
        modularToolStack = null;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        if (modularToolStack == null) {
            resetModularTool();
        }

        CompoundTag saved = new CompoundTag();
        if (!(modularToolStack.getItem() instanceof ModularToolItem modularToolItem)) {
            tag.put(MODULAR_TOOL_TAG, saved);
            return;
        }

        String modularToolId = modularToolItem.getId();
        saved.putString("id", modularToolId);

        CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(modularToolStack);
        if (toolModulesNbt.isEmpty()) {
            tag.put(MODULAR_TOOL_TAG, saved);
            return;
        }

        CompoundTag savedToolModulesNbt = new CompoundTag();
        for (ToolModuleType toolModuleType : modularToolItem.getCompatible()) {
            CompoundTag toolModuleNbt = toolModulesNbt.getCompound(toolModuleType.getTag());
            if (ToolModuleRegistry.containsId(toolModuleNbt.getString("id"))) {
                savedToolModulesNbt.put(toolModuleType.getTag(), toolModuleNbt.copy());
            }
        }
        saved.put(SandMoldBlockEntity.TOOL_MODULES_TAG, savedToolModulesNbt);

        tag.put(MODULAR_TOOL_TAG, saved);
    }

    @Override
    public void load(CompoundTag tag) {
        CompoundTag loaded = tag.getCompound(MODULAR_TOOL_TAG);
        if (loaded.isEmpty()) {
            resetModularTool();
            return;
        }

        ModularToolItem loadedModularTool = ModularToolRegistry.get(loaded.getString("id"));
        if (loadedModularTool == null) {
            resetModularTool();
            return;
        }

        setModularTool(loadedModularTool, loaded.getCompound(SandMoldBlockEntity.TOOL_MODULES_TAG));
    }

    @Override
    @Nullable
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int slot) {
        if (slot != 0) {
            throw new IndexOutOfBoundsException();
        }

        return modularToolStack;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        if (slot != 0) {
            throw new IndexOutOfBoundsException();
        }

        ItemStack originalModularToolStack = modularToolStack;

        modularToolStack = modularToolStack.copy();
        setChanged();

        return originalModularToolStack;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        return removeItem(slot, 1);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        if (slot != 0) {
            throw new IndexOutOfBoundsException();
        }

        if (stack.getItem() instanceof ModularToolItem) {
            modularToolStack = stack;
        }
    }

    @Override
    public void clearContent() {
        removeItem(0, 1);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        return false;
    }

    @Override
    public boolean canTakeItem(Container target, int index, ItemStack stack) {
        return false;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[]{};
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    @Nullable
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new CreativeModularToolTableMenu(i, inventory, this);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    private void setModularTool(ModularToolItem modularTool, @Nullable CompoundTag toolModulesTag) {
        modularToolStack = new ItemStack(modularTool);

        CompoundTag toolModulesNbt = new CompoundTag();
        if (toolModulesTag != null && !toolModulesTag.isEmpty()) {
            for (ToolModuleType toolModuleType : modularTool.getCompatible()) {
                if (toolModulesTag.contains(toolModuleType.getTag(), CompoundTag.TAG_COMPOUND)) {
                    toolModulesNbt.put(toolModuleType.getTag(), toolModulesTag.getCompound(toolModuleType.getTag()).copy());
                }
            }
        }
        for (ToolModuleType toolModuleType : modularTool.getRequired()) {
            if (!toolModulesNbt.contains(toolModuleType.getTag(), CompoundTag.TAG_COMPOUND)) {
                CompoundTag toolModuleNbt = new CompoundTag();
                toolModuleNbt.putString("id", ToolModuleRegistry.getAllOfType(toolModuleType).get(0).getId());
                toolModulesNbt.put(toolModuleType.getTag(), toolModuleNbt);
            }
        }

        CompoundTag nbt = modularToolStack.getOrCreateTag();
        nbt.putString("id", modularTool.getId());
        nbt.put(SandMoldBlockEntity.TOOL_MODULES_TAG, toolModulesNbt);

        setChanged();
    }

    private void resetModularTool() {
        setModularTool(AllModularTools.SWORD, null);
    }
}
