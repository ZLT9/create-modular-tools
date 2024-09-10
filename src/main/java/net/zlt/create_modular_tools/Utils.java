package net.zlt.create_modular_tools;

import com.simibubi.create.foundation.model.BakedQuadHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;

import java.util.Arrays;

public abstract class Utils {
    private Utils() {
    }

    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    public static void setBakedQuadUV(int[] vertices, TextureAtlasSprite sprite, Direction facing) {
        if (!Direction.Plane.HORIZONTAL.test(facing)) {
            return;
        }

        float u0 = sprite.getU0();
        float v0 = sprite.getV0();
        float u1 = sprite.getU1();
        float v1 = sprite.getV1();

        if (facing == Direction.SOUTH) {
            BakedQuadHelper.setU(vertices, 0, u0);
            BakedQuadHelper.setV(vertices, 0, v0);
            BakedQuadHelper.setU(vertices, 1, u0);
            BakedQuadHelper.setV(vertices, 1, v1);
            BakedQuadHelper.setU(vertices, 2, u1);
            BakedQuadHelper.setV(vertices, 2, v1);
            BakedQuadHelper.setU(vertices, 3, u1);
            BakedQuadHelper.setV(vertices, 3, v0);
        } else if (facing == Direction.WEST) {
            BakedQuadHelper.setU(vertices, 0, u0);
            BakedQuadHelper.setV(vertices, 0, v1);
            BakedQuadHelper.setU(vertices, 1, u1);
            BakedQuadHelper.setV(vertices, 1, v1);
            BakedQuadHelper.setU(vertices, 2, u1);
            BakedQuadHelper.setV(vertices, 2, v0);
            BakedQuadHelper.setU(vertices, 3, u0);
            BakedQuadHelper.setV(vertices, 3, v0);
        } else if (facing == Direction.NORTH) {
            BakedQuadHelper.setU(vertices, 0, u1);
            BakedQuadHelper.setV(vertices, 0, v1);
            BakedQuadHelper.setU(vertices, 1, u1);
            BakedQuadHelper.setV(vertices, 1, v0);
            BakedQuadHelper.setU(vertices, 2, u0);
            BakedQuadHelper.setV(vertices, 2, v0);
            BakedQuadHelper.setU(vertices, 3, u0);
            BakedQuadHelper.setV(vertices, 3, v1);
        } else if (facing == Direction.EAST) {
            BakedQuadHelper.setU(vertices, 0, u1);
            BakedQuadHelper.setV(vertices, 0, v0);
            BakedQuadHelper.setU(vertices, 1, u0);
            BakedQuadHelper.setV(vertices, 1, v0);
            BakedQuadHelper.setU(vertices, 2, u0);
            BakedQuadHelper.setV(vertices, 2, v1);
            BakedQuadHelper.setU(vertices, 3, u1);
            BakedQuadHelper.setV(vertices, 3, v1);
        }
    }

    public static float getBakedQuadY(int[] vertices, int vertexIndex) {
        return Float.intBitsToFloat(vertices[vertexIndex * BakedQuadHelper.VERTEX_STRIDE + BakedQuadHelper.Y_OFFSET]);
    }
}
