package net.boruebork.justamod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.entity.custom.NukeEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NukeRenderer<T extends NukeEntity> extends EntityRenderer<T>{
    private final EntityModel<T> model;
    public NukeRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new NukeModel<>(context.bakeLayer(NukeModel.LAYER_LOCATION));
        this.shadowRadius = 0.5F;
    }

    @Override
    public void render(T p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        this.model.renderToBuffer(
                poseStack,
                bufferSource.getBuffer(this.model.renderType(this.getTextureLocation(p_entity))),
                packedLight,
                OverlayTexture.NO_OVERLAY
        );
        poseStack.popPose();
        super.render(p_entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return ResourceLocation.fromNamespaceAndPath(JustAMod.MOD_ID, "textures/entity/nuke.png");

    }
}
