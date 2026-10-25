package ctn.stonecraft.client.renderer;

import ctn.stonecraft.common.entity.projectile.stone_arrow.StoneArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class StoneArrowRenderer extends ArrowRenderer<StoneArrowEntity> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath("stonecraft", "textures/entity/stone_arrow.png");

    public StoneArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(StoneArrowEntity entity) {
        return TEXTURE;
    }
}