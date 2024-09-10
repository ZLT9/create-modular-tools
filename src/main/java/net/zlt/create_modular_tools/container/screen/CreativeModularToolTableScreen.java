package net.zlt.create_modular_tools.container.screen;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.zlt.create_modular_tools.CreateModularTools;
import net.zlt.create_modular_tools.block.entity.mold.SandMoldBlockEntity;
import net.zlt.create_modular_tools.container.menu.CreativeModularToolTableMenu;
import net.zlt.create_modular_tools.item.tool.ModularToolItem;
import net.zlt.create_modular_tools.tool.ModularToolRegistry;
import net.zlt.create_modular_tools.tool.ToolUtils;
import net.zlt.create_modular_tools.tool.module.ToolModule;
import net.zlt.create_modular_tools.tool.module.ToolModuleRegistry;
import net.zlt.create_modular_tools.tool.module.ToolModuleType;
import org.jetbrains.annotations.Unmodifiable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CreativeModularToolTableScreen extends AbstractContainerScreen<CreativeModularToolTableMenu> {
    private static final ResourceLocation BG_LOCATION = CreateModularTools.asResource("textures/gui/container/creative_modular_tool_table.png");

    private int buttonContainerLeft;
    private int buttonContainerTop;
    private int buttonContainerRight;
    private int buttonContainerBottom;
    private int scrollBarLeft;
    private int scrollBarTop;
    private int scrollBarRight;
    private int scrollBarBottom;
    private int firstButtonIndex;
    private float scrollOffset;
    private boolean scrolling;
    private ItemStack hoveredButton;
    @Unmodifiable
    private List<ItemStack> toolModules;

    public CreativeModularToolTableScreen(CreativeModularToolTableMenu containerMenu, Inventory inventory, Component title) {
        super(containerMenu, inventory, title);

        --titleLabelY;

        firstButtonIndex = 0;
        scrollOffset = 0.0f;
        scrolling = false;
        hoveredButton = null;

        updateSelectedToolModules();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        ToolModuleType selectedToolModuleType = menu.getSelectedToolModuleType();
        ModularToolItem selectedModularTool = menu.getSelectedModularTool();
        for (int i = 0; i < selectedModularTool.getCompatible().size(); ++i) {
            if (selectedModularTool.getCompatible().get(i) != selectedToolModuleType) {
                guiGraphics.blit(BG_LOCATION, leftPos + 27 * i, topPos - 28, 200, 0, 26, 32);
            }
        }

        int modularToolCount = ModularToolRegistry.getAll().size();
        for (int i = 0; i < modularToolCount; ++i) {
            if (ModularToolRegistry.getAll().get(i) != selectedModularTool) {
                guiGraphics.blit(BG_LOCATION, leftPos - 28, topPos + 4 + 27 * i, 176, 64, 32, 26);
            }
        }

        guiGraphics.blit(BG_LOCATION, leftPos, topPos, 0, 0, imageWidth, imageHeight);

        int selectedToolModuleTypeIndex = -(menu.getSelectedToolModuleTypeId() + 1) - ModularToolRegistry.getAll().size();
        if (selectedToolModuleTypeIndex == 0) {
            guiGraphics.blit(BG_LOCATION, leftPos, topPos - 28, 226, 0, 26, 32);
        } else {
            guiGraphics.blit(BG_LOCATION, leftPos + 27 * selectedToolModuleTypeIndex, topPos - 28, 200, 32, 26, 32);
        }

        guiGraphics.blit(BG_LOCATION, leftPos - 28, topPos + 4 + 27 * ModularToolRegistry.getAll().indexOf(selectedModularTool), 208, 64, 32, 26);

        for (int i = 0; i < selectedModularTool.getCompatible().size(); ++i) {
            guiGraphics.blit(selectedModularTool.getCompatible().get(i).getIcon(selectedModularTool), leftPos + 5 + 27 * i, topPos - 28 + 9, 0, 0, 16, 16, 16, 16);
        }

        for (int i = 0; i < modularToolCount; ++i) {
            guiGraphics.blit(ModularToolRegistry.getAll().get(i).getIcon(), leftPos - 19, topPos + 9 + 27 * i, 0, 0, 16, 16, 16, 16);
        }

        hoveredButton = null;
        boolean canScroll = firstButtonIndex != 0;
        int x = 0;
        int y = 0;
        int count = 0;
        for (ItemStack toolModuleStack : toolModules) {
            if (count < firstButtonIndex) {
                ++count;
                continue;
            }

            int buttonX = leftPos + 11 + 18 * x;
            int buttonY = topPos + 15 + 18 * y;
            boolean isButtonHovered = mouseX >= buttonX && mouseX < buttonX + 18 && mouseY >= buttonY && mouseY < buttonY + 18;

            CompoundTag toolModulesNbt = ToolUtils.getToolModulesNbt(menu.getSlot(0).getItem());
            ToolModule toolModule = toolModulesNbt.isEmpty() ? null : ToolModuleRegistry.get(toolModulesNbt.getString(selectedToolModuleType.getTag()));

            guiGraphics.blit(BG_LOCATION, buttonX, buttonY, 0, (toolModule == null ? toolModuleStack.is(Items.BARRIER) : toolModuleStack.is(toolModule.getItem())) ? 184 : isButtonHovered ? 202 : 166, 18, 18);
            guiGraphics.renderFakeItem(toolModuleStack, buttonX + 1, buttonY + 1);

            if (isButtonHovered) {
                hoveredButton = toolModuleStack;
            }

            ++x;
            if (x == 6) {
                x = 0;
                ++y;
                if (y == 3) {
                    canScroll = true;
                    break;
                }
            }
        }

        guiGraphics.blit(BG_LOCATION, leftPos + 122, topPos + 15 + (int) (39.0f * scrollOffset), canScroll ? 176 : 188, 0, 12, 15);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        if (hoveredButton != null) {
            if (hoveredButton.is(Items.BARRIER)) {
                guiGraphics.renderTooltip(font, Component.translatable("gui.none"), mouseX, mouseY);
            } else {
                guiGraphics.renderTooltip(font, hoveredButton, mouseX, mouseY);
            }
        } else if (mouseX >= leftPos) {
            if (mouseY >= topPos) {
                renderTooltip(guiGraphics, mouseX, mouseY);
            } else if (mouseY >= topPos - 28) {
                ModularToolItem selectedModularTool = menu.getSelectedModularTool();
                int relativeMouseX = mouseX - leftPos;
                int hoveredToolModuleType = relativeMouseX / 27;
                if (hoveredToolModuleType >= 0 && hoveredToolModuleType < selectedModularTool.getCompatible().size() && relativeMouseX - hoveredToolModuleType * 27 < 26) {
                    guiGraphics.renderTooltip(font, selectedModularTool.getCompatible().get(hoveredToolModuleType).getName(), mouseX, mouseY);
                }
            }
        } else if (mouseX >= leftPos - 28 && mouseY >= topPos + 4) {
            int relativeMouseY = mouseY - (topPos + 4);
            int hoveredModularTool = relativeMouseY / 27;
            if (hoveredModularTool >= 0 && hoveredModularTool < ModularToolRegistry.getAll().size() && relativeMouseY - hoveredModularTool * 27 < 26) {
                guiGraphics.renderTooltip(font, ModularToolRegistry.getAll().get(hoveredModularTool).getToolCategorySingularName(), mouseX, mouseY);
            }
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        scrolling = false;

        if (mouseX >= buttonContainerLeft && mouseX < buttonContainerRight && mouseY >= buttonContainerTop && mouseY < buttonContainerBottom) {
            int buttonId = (int) ((mouseX - buttonContainerLeft) / 18) + (int) ((mouseY - buttonContainerTop) / 18) * 6 + firstButtonIndex;
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player != null && menu.clickMenuButton(minecraft.player, buttonId)) {
                Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0f));
                minecraft.gameMode.handleInventoryButtonClick(menu.containerId, buttonId);
                return true;
            }
        }

        if (mouseX >= scrollBarLeft && mouseX < scrollBarRight && mouseY >= scrollBarTop && mouseY < scrollBarBottom) {
            scrolling = true;
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }


    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (scrolling) {
            int count = toolModules.size();
            if (count > 18) {
                int top = topPos + 14;
                int bottom = top + 54;
                scrollOffset = Mth.clamp(((float) mouseY - (float) top - 7.5f) / ((float) (bottom - top) - 15.0f), 0.0f, 1.0f);
                firstButtonIndex = (int) ((scrollOffset * Math.max(0, Math.ceil(count / 6.0f) - 3)) + 0.5) * 6;
                return true;
            }
        }

        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        int count = toolModules.size();
        if (count > 18) {
            int offscreenRowCount = (int) Math.max(0, Math.ceil(count / 6.0f) - 3);
            scrollOffset = Mth.clamp(scrollOffset - (float) (delta / offscreenRowCount), 0.0f, 1.0f);
            firstButtonIndex = (int) ((double) (scrollOffset * offscreenRowCount) + 0.5) * 6;
        }

        return true;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0) {
            if (mouseX >= leftPos) {
                if (mouseY >= topPos - 28 && mouseY < topPos) {
                    int relativeMouseX = (int) (mouseX - leftPos);
                    int hoveredToolModuleType = relativeMouseX / 27;
                    if (hoveredToolModuleType >= 0 && hoveredToolModuleType < menu.getSelectedModularTool().getCompatible().size() && relativeMouseX - hoveredToolModuleType * 27 < 26) {
                        int toolModuleTypeId = -(ModularToolRegistry.getAll().size() + hoveredToolModuleType + 1);
                        menu.clickMenuButton(Minecraft.getInstance().player, toolModuleTypeId);
                        Minecraft.getInstance().gameMode.handleInventoryButtonClick(menu.containerId, toolModuleTypeId);
                        updateSelectedToolModules();
                        scrollOffset = 0.0f;
                        firstButtonIndex = 0;
                        return true;
                    }
                }
            } else if (mouseX >= leftPos - 28 && mouseY >= topPos + 4) {
                int relativeMouseY = (int) (mouseY - (topPos + 4));
                int hoveredModularTool = relativeMouseY / 27;
                if (hoveredModularTool >= 0 && hoveredModularTool < ModularToolRegistry.getAll().size() && relativeMouseY - hoveredModularTool * 27 < 26) {
                    int modularToolId = -(hoveredModularTool + 1);
                    menu.clickMenuButton(Minecraft.getInstance().player, modularToolId);
                    Minecraft.getInstance().gameMode.handleInventoryButtonClick(menu.containerId, modularToolId);
                    updateSelectedToolModules();
                    scrollOffset = 0.0f;
                    firstButtonIndex = 0;
                    return true;
                }
            }
        }

        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        boolean w = keyCode == InputConstants.KEY_W;
        boolean a = keyCode == InputConstants.KEY_A;
        boolean s = keyCode == InputConstants.KEY_S;
        boolean d = keyCode == InputConstants.KEY_D;
        if (a || d) {
            int toolModuleTypeId = menu.getSelectedToolModuleTypeId() + (a ? 1 : -1);
            int firstToolModuleTypeId = -(ModularToolRegistry.getAll().size() + 1);
            if (toolModuleTypeId <= firstToolModuleTypeId && toolModuleTypeId > firstToolModuleTypeId - menu.getSelectedModularTool().getCompatible().size()) {
                menu.clickMenuButton(Minecraft.getInstance().player, toolModuleTypeId);
                Minecraft.getInstance().gameMode.handleInventoryButtonClick(menu.containerId, toolModuleTypeId);
                updateSelectedToolModules();
                scrollOffset = 0.0f;
                firstButtonIndex = 0;
                return true;
            }
        } else if (w || s) {
            int modularToolId = menu.getSelectedModularToolId() + (w ? 1 : -1);
            if (modularToolId < 0 && modularToolId >= -ModularToolRegistry.getAll().size()) {
                menu.clickMenuButton(Minecraft.getInstance().player, modularToolId);
                Minecraft.getInstance().gameMode.handleInventoryButtonClick(menu.containerId, modularToolId);
                updateSelectedToolModules();
                scrollOffset = 0.0f;
                firstButtonIndex = 0;
                return true;
            }
        }

        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    protected void init() {
        super.init();
        buttonContainerLeft = leftPos + 11;
        buttonContainerTop = topPos + 15;
        buttonContainerRight = buttonContainerLeft + 108;
        buttonContainerBottom = buttonContainerTop + 54;
        scrollBarLeft = leftPos + 122;
        scrollBarTop = buttonContainerTop;
        scrollBarRight = scrollBarLeft + 12;
        scrollBarBottom = scrollBarTop + 54;
    }

    private void updateSelectedToolModules() {
        ToolModuleType selectedToolModuleType = menu.getSelectedToolModuleType();
        List<ItemStack> updatedToolModules = ToolModuleRegistry.getAllOfType(selectedToolModuleType).stream().map(toolModule -> new ItemStack(toolModule.getItem())).toList();
        if (menu.getSelectedModularTool().isRequired(selectedToolModuleType)) {
            toolModules = updatedToolModules;
        } else {
            toolModules = new ArrayList<>();
            toolModules.add(Items.BARRIER.getDefaultInstance());
            toolModules.addAll(updatedToolModules);
        }
    }
}
