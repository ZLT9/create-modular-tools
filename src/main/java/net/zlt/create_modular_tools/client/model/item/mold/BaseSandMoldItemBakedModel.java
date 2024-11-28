package net.zlt.create_modular_tools.client.model.item.mold;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.model.ModelHelper;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BaseSandMoldItemBakedModel implements BakedModel {
    private final BakedModel DYNAMIC_MODEL;
    private final ItemOverrides OVERRIDES;
    private final List<BakedQuad> QUADS;

    public BaseSandMoldItemBakedModel(BaseMoldItemUnbakedModel unbakedModel, BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
        DYNAMIC_MODEL = unbakedModel.bakeDynamic(baseSandMoldModel, interiorTopQuad, spriteGetter);
        OVERRIDES = new Overrides(unbakedModel, baseSandMoldModel, interiorTopQuad, spriteGetter);
        QUADS = List.of();
    }

    public BaseSandMoldItemBakedModel(List<BakedQuad> quads) {
        DYNAMIC_MODEL = null;
        OVERRIDES = ItemOverrides.EMPTY;
        QUADS = quads;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState blockState, @Nullable Direction face, RandomSource random) {
        ImmutableList.Builder<BakedQuad> quadListBuilder = ImmutableList.builder();
        for (BakedQuad quad : QUADS) {
            if (quad.getDirection() == face) {
                quadListBuilder.add(quad);
            }
        }
        return quadListBuilder.build();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean usesBlockLight() {
        return true;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(new ResourceLocation("minecraft", "block/sand"));
    }

    @Override
    public ItemTransforms getTransforms() {
        return ModelHelper.MODEL_TRANSFORM_BLOCK;
    }

    @Override
    public ItemOverrides getOverrides() {
        return OVERRIDES;
    }

    private class Overrides extends ItemOverrides {
        private static final Cache<UUID, BakedModel> MODEL_CACHE = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

        private final BaseMoldItemUnbakedModel UNBAKED_MODEL;
        private final BakedModel BASE_SAND_MOLD_MODEL;
        private final BakedQuad INTERIOR_TOP_QUAD;
        private final Function<Material, TextureAtlasSprite> SPRITE_GETTER;

        public Overrides(BaseMoldItemUnbakedModel unbakedModel, BakedModel baseSandMoldModel, BakedQuad interiorTopQuad, Function<Material, TextureAtlasSprite> spriteGetter) {
            super();
            UNBAKED_MODEL = unbakedModel;
            BASE_SAND_MOLD_MODEL = baseSandMoldModel;
            INTERIOR_TOP_QUAD = interiorTopQuad;
            SPRITE_GETTER = spriteGetter;
        }

        @Override
        @Nullable
        public BakedModel resolve(BakedModel model, ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
            try {
                CompoundTag nbt = stack.getTag();
                return MODEL_CACHE.get(nbt.getUUID("UUID"), () -> UNBAKED_MODEL.bakeOverride(nbt, BASE_SAND_MOLD_MODEL, INTERIOR_TOP_QUAD, SPRITE_GETTER));
            } catch (Exception e) {
                return DYNAMIC_MODEL;
            }
        }
    }
}
