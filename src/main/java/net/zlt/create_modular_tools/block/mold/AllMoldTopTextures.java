package net.zlt.create_modular_tools.block.mold;

import net.zlt.create_modular_tools.tool.module.ToolModuleType;

public final class AllMoldTopTextures {
    private AllMoldTopTextures() {
    }

    public static final ToolModuleType.MoldTopTexture SWORD_BLADE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 11, 0, 5, 5)) {
                return !isIn(x, y, 11, 0, 2, 1) && (x != 11 || y != 1) && !isIn(x, y, 14, 4, 2, 1) && (x != 15 || y != 3);
            }
            if (isIn(x, y, 6, 5, 5, 5)) {
                return !isIn(x, y, 6, 5, 2, 1) && (x != 6 || y != 6) && !isIn(x, y, 9, 9, 2, 1) && (x != 10 || y != 8);
            }
            if (isIn(x, y, 9, 3, 2, 2)) {
                return x != 9 || y != 3;
            }
            if (isIn(x, y, 11, 5, 2, 2)) {
                return x != 12 || y != 6;
            }
            return x == 5 && y == 8 || x == 7 && y == 10;
        }
    };

    public static final ToolModuleType.MoldTopTexture SHOVEL_HEAD = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 11, 2, 4, 4)) {
                return x != 14 || y != 2;
            }
            if (isIn(x, y, 8, 3, 3, 3)) {
                return !isIn(x, y, 8, 3, 2, 1) && (x != 8 || y != 4);
            }
            if (isIn(x, y, 11, 6, 3, 3)) {
                return !isIn(x, y, 12, 8, 2, 1) && (x != 13 || y != 7);
            }
            return x == 10 && y == 6;
        }
    };

    public static final ToolModuleType.MoldTopTexture PICKAXE_HEAD = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (x >= 5 && y >= 2 && x < 5 + 7 && y < 2 + 3) {
                return (x != 5 || y != 2) && (x != 5 || y != 4) && (x != 11 || y != 2);
            }
            if (x >= 12 && y >= 5 && x < 12 + 3 && y < 5 + 7) {
                return (x != 14 || y != 5) && (x != 12 || y != 11) && (x != 14 || y != 11);
            }
            return x == 11 && y == 5;
        }
    };

    public static final ToolModuleType.MoldTopTexture AXE_HEAD = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 11, 6, 3, 3)) {
                return x != 13 || y != 8;
            }
            if (isIn(x, y, 8, 1, 4, 6)) {
                return (x != 8 || y != 1) && (x != 11 || y != 1) && (x != 9 || y != 6) && (x != 11 || y != 4);
            }
            if (isIn(x, y, 6, 3, 2, 4)) {
                return (x != 6 || y != 3) && (x != 6 || y != 6);
            }
            return false;
        }
    };

    public static final ToolModuleType.MoldTopTexture HOE_HEAD = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 11, 5, 3, 2)) {
                return (x != 11 || y != 6) && (x != 13 || y != 6);
            }
            if (isIn(x, y, 6, 1, 6, 4)) {
                return (x != 6 || y != 1) && !isIn(x, y, 6, 3, 1, 2) && !isIn(x, y, 7, 4, 2, 1) && !isIn(x, y, 10, 1, 2, 1) && (x != 11 || y != 2);
            }
            return false;
        }
    };

    public static ToolModuleType.MoldTopTexture SWORD_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 0, 13, 3, 3)) {
                return (x != 0 || y != 13) && (x != 2 || y != 15);
            }
            if (isIn(x, y, 3, 10, 3, 3)) {
                return (x != 3 || y != 10) && (x != 5 || y != 12);
            }
            return x == 2 && y == 12 || x == 3 && y == 13 || x == 5 && y == 9 || x == 6 && y == 10;
        }
    };

    public static ToolModuleType.MoldTopTexture POMMEL_SWORD_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 3, 10, 3, 3)) {
                return (x != 3 || y != 10) && (x != 5 || y != 12);
            }
            return x == 2 && y == 13 || x == 2 && y == 12 || x == 3 && y == 13 || x == 5 && y == 9 || x == 6 && y == 10;
        }
    };

    public static ToolModuleType.MoldTopTexture SHOVEL_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 2, 12, 3, 3)) {
                return (x != 2 || y != 12) && (x != 4 || y != 14);
            }
            if (isIn(x, y, 5, 9, 3, 3)) {
                return (x != 5 || y != 9) && (x != 7 || y != 11);
            }
            if (isIn(x, y, 8, 6, 3, 3)) {
                return (x != 8 || y != 6) && (x != 10 || y != 8) && (x != 10 || y != 6);
            }
            return x == 4 && y == 11 || x == 5 && y == 12 || x == 7 && y == 8 || x == 8 && y == 9;
        }
    };

    public static ToolModuleType.MoldTopTexture GRIP_SHOVEL_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 5, 9, 3, 3)) {
                return (x != 5 || y != 9) && (x != 7 || y != 11);
            }
            if (isIn(x, y, 8, 6, 3, 3)) {
                return (x != 8 || y != 6) && (x != 10 || y != 8) && (x != 10 || y != 6);
            }
            return x == 4 && y == 12 || x == 4 && y == 11 || x == 5 && y == 12 || x == 7 && y == 8 || x == 8 && y == 9;
        }
    };

    public static final ToolModuleType.MoldTopTexture PICKAXE_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 2, 12, 3, 3)) {
                return (x != 2 || y != 12) && (x != 4 || y != 14);
            }
            if (isIn(x, y, 5, 9, 3, 3)) {
                return (x != 5 || y != 9) && (x != 7 || y != 11);
            }
            if (isIn(x, y, 8, 6, 3, 3)) {
                return (x != 8 || y != 6) && (x != 10 || y != 8);
            }
            if (isIn(x, y, 11, 3, 3, 3)) {
                return (x != 11 || y != 3) && (x != 13 || y != 5);
            }
            return x == 4 && y == 11 || x == 5 && y == 12 || x == 7 && y == 8 || x == 8 && y == 9 || x == 10 && y == 5 || x == 11 && y == 6;
        }
    };
    public static final ToolModuleType.MoldTopTexture GRIP_PICKAXE_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 5, 9, 3, 3)) {
                return (x != 5 || y != 9) && (x != 7 || y != 11);
            }
            if (isIn(x, y, 8, 6, 3, 3)) {
                return (x != 8 || y != 6) && (x != 10 || y != 8);
            }
            if (isIn(x, y, 11, 3, 3, 3)) {
                return (x != 11 || y != 3) && (x != 13 || y != 5);
            }
            return x == 4 && y == 12 || x == 4 && y == 11 || x == 5 && y == 12 || x == 7 && y == 8 || x == 8 && y == 9 || x == 10 && y == 5 || x == 11 && y == 6;
        }
    };

    public static ToolModuleType.MoldTopTexture AXE_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 2, 12, 3, 3)) {
                return (x != 2 || y != 12) && (x != 4 || y != 14);
            }
            if (isIn(x, y, 5, 9, 3, 3)) {
                return (x != 5 || y != 9) && (x != 7 || y != 11);
            }
            if (isIn(x, y, 8, 6, 3, 3)) {
                return (x != 8 || y != 6) && (x != 10 || y != 8);
            }
            if (isIn(x, y, 11, 4, 2, 2)) {
                return true;
            }
            return x == 4 && y == 11 || x == 5 && y == 12 || x == 7 && y == 8 || x == 8 && y == 9 || x == 10 && y == 5 || x == 11 && y == 6;
        }
    };

    public static ToolModuleType.MoldTopTexture GRIP_AXE_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 4, 10, 3, 3)) {
                return (x != 4 || y != 10) && (x != 6 || y != 12);
            }
            if (isIn(x, y, 7, 7, 3, 3)) {
                return (x != 7 || y != 7) && (x != 9 || y != 9);
            }
            if (isIn(x, y, 10, 4, 3, 3)) {
                return (x != 10 || y != 4) && (x != 12 || y != 6);
            }
            return x == 6 && y == 9 || x == 7 && y == 10 || x == 9 && y == 6 || x == 10 && y == 7;
        }
    };

    public static ToolModuleType.MoldTopTexture HOE_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 2, 12, 3, 3)) {
                return (x != 2 || y != 12) && (x != 4 || y != 14);
            }
            if (isIn(x, y, 5, 9, 3, 3)) {
                return (x != 5 || y != 9) && (x != 7 || y != 11);
            }
            if (isIn(x, y, 8, 6, 3, 3)) {
                return (x != 8 || y != 6) && (x != 10 || y != 8);
            }
            if (isIn(x, y, 11, 3, 3, 3)) {
                return (x != 11 || y != 3) && (x != 13 || y != 5);
            }
            return x == 4 && y == 11 || x == 5 && y == 12 || x == 7 && y == 8 || x == 8 && y == 9 || x == 10 && y == 5 || x == 11 && y == 6;
        }
    };

    public static ToolModuleType.MoldTopTexture GRIP_HOE_HANDLE = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 5, 9, 3, 3)) {
                return (x != 5 || y != 9) && (x != 7 || y != 11);
            }
            if (isIn(x, y, 8, 6, 3, 3)) {
                return (x != 8 || y != 6) && (x != 10 || y != 8);
            }
            if (isIn(x, y, 11, 3, 3, 3)) {
                return (x != 11 || y != 3) && (x != 13 || y != 5);
            }
            return x == 4 && y == 12 || x == 4 && y == 11 || x == 5 && y == 12 || x == 7 && y == 8 || x == 8 && y == 9 || x == 10 && y == 5 || x == 11 && y == 6;
        }
    };

    public static final ToolModuleType.MoldTopTexture GRIP = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 2, 12, 3, 3)) {
                return (x != 2 || y != 14) && (x != 4 || y != 12);
            }
            return false;
        }
    };

    public static final ToolModuleType.MoldTopTexture GUARD = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            return isIn(x, y, 2, 6, 2, 2) || isIn(x, y, 4, 8, 2, 3) || isIn(x, y, 6, 10, 2, 3) || isIn(x, y, 8, 12, 2, 2) || isIn(x, y, 3, 8, 1, 2) || x == 4 && y == 7 || x == 5 && y == 11 || x == 6 && y == 9 || x == 8 && y == 11;
        }
    };

    public static final ToolModuleType.MoldTopTexture POMMEL = new ToolModuleType.MoldTopTexture() {
        @Override
        public boolean clicked(int x, int y) {
            if (isIn(x, y, 0, 13, 3, 3)) {
                return x != 2 || y != 13;
            }
            return false;
        }
    };

    private static boolean isIn(int x, int y, int left, int top, int width, int height) {
        return x >= left && y >= top && x < left + width && y < top + height;
    }

    public static void init() {
    }
}
