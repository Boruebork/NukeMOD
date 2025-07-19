package net.boruebork.justamod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.entity.custom.HIMARSMob;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class HIMARSRenderer<T extends HIMARSMob> extends EntityRenderer<T>{
    private final EntityModel<T> model;
    public HIMARSRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new HIMARSModel<>(context.bakeLayer(HIMARSModel.LAYER_LOCATION));
        this.shadowRadius = 0.5F;
    }

    @Override
    public void render(T p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        Vec3 root = new Vec3(1, 1.2f, -0.9f);
        poseStack.scale(4, 4, 4);
        poseStack.mulPose(Axis.XP.rotationDegrees(180)); // Fixed rotation
        poseStack.rotateAround(Axis.YP.rotationDegrees(p_entity.getYRot()), (float) root.x,(float) root.y, (float) root.z);
        poseStack.translate(root.x, root.y, root.z);
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
    public @NotNull ResourceLocation getTextureLocation(T t) {
        return ResourceLocation.fromNamespaceAndPath(JustAMod.MOD_ID, "textures/entity/himars.png");
    }

    /*@Override
    public boolean shouldRender(T livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }*/
}
