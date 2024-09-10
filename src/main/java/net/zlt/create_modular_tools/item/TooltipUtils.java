package net.zlt.create_modular_tools.item;

import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TooltipUtils {
    public static Style styleFromFormat(ChatFormatting format) {
        return Style.EMPTY.applyFormat(format);
    }

    public static Style styleFromColor(int hex) {
        return Style.EMPTY.withColor(hex);
    }

    public static boolean addHoldShift(String key, List<Component> tooltipComponents) {
        return addHoldShift(key, "create.tooltip.keyShift", tooltipComponents, HoldShiftPalette.DEFAULT);
    }
    public static boolean addHoldShift(String key, List<Component> tooltipComponents, HoldShiftPalette palette) {
        return addHoldShift(key, "create.tooltip.keyShift", tooltipComponents, palette);
    }

    public static boolean addHoldShift(String holdKey, String shiftKey, List<Component> tooltipComponents) {
        return addHoldShift(holdKey, shiftKey, tooltipComponents, HoldShiftPalette.DEFAULT);
    }

    public static boolean addHoldShift(String holdKey, String shiftKey, List<Component> tooltipComponents, HoldShiftPalette palette) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable(holdKey, Component.translatable(shiftKey).withStyle(palette.shiftDown)).withStyle(palette.background));
            tooltipComponents.add(CommonComponents.EMPTY);
            return true;
        }

        tooltipComponents.add(Component.translatable(holdKey, Component.translatable(shiftKey).withStyle(palette.shiftUp)).withStyle(palette.background));
        return false;
    }

    public record HoldShiftPalette(Style background, Style shiftUp, Style shiftDown) {
        public static final HoldShiftPalette DEFAULT = fromFormats(ChatFormatting.DARK_GRAY, ChatFormatting.GRAY, ChatFormatting.WHITE);

        public static HoldShiftPalette fromFormats(ChatFormatting background, ChatFormatting shiftUp, ChatFormatting shiftDown) {
            return new HoldShiftPalette(styleFromFormat(background), styleFromFormat(shiftUp), styleFromFormat(shiftDown));
        }
    }
}
