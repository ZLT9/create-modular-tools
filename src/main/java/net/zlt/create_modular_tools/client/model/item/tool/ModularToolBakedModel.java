package net.zlt.create_modular_tools.client.model.item.tool;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
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

@Environment(EnvType.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ModularToolBakedModel implements BakedModel {
    private final BakedModel DYNAMIC_MODEL;
    private final BakedModel DUMMY_MODEL;
    private final ItemOverrides OVERRIDES;
    private final List<BakedQuad> QUADS;

    public ModularToolBakedModel(ModularToolUnbakedModel unbakedModel, BakedModel dummyModel) {
        DYNAMIC_MODEL = unbakedModel.bakeDynamic(dummyModel);
        DUMMY_MODEL = dummyModel;
        OVERRIDES = new Overrides(unbakedModel);
        QUADS = List.of();
    }

    public ModularToolBakedModel(BakedModel dummyModel, List<BakedQuad> quads) {
        DYNAMIC_MODEL = null;
        DUMMY_MODEL = dummyModel;
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
    public TextureAtlasSprite getParticleIcon() {
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(new ResourceLocation("minecraft", "item/stick"));
    }

    @Override
    public ItemTransforms getTransforms() {
        return DUMMY_MODEL.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return OVERRIDES;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return false;
    }

    @Override
    public boolean isCustomRenderer() {
        return true;
    }

    private class Overrides extends ItemOverrides {
        private static final Cache<UUID, BakedModel> MODEL_CACHE = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .build();

        private final ModularToolUnbakedModel UNBAKED_MODEL;

        public Overrides(ModularToolUnbakedModel unbakedModel) {
            super();
            UNBAKED_MODEL = unbakedModel;
        }

        @Override
        @Nullable
        public BakedModel resolve(BakedModel model, ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
            try {
                CompoundTag nbt = stack.getTag();
                return MODEL_CACHE.get(nbt.getUUID("UUID"), () -> UNBAKED_MODEL.bakeOverride(stack, DUMMY_MODEL));
            } catch (Exception e) {
                return DYNAMIC_MODEL;
            }
        }
    }
}
