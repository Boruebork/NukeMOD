package net.boruebork.justamod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.entity.custom.NukeEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;

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
        Vec3 root = new Vec3(0, 1.3f, 0);
        poseStack.scale(2, 2, 2);
        poseStack.translate((float) root.x, (float) -root.y, (float) root.z);
        poseStack.rotateAround(Axis.YP.rotationDegrees(-entityYaw), (float) -root.x, (float) -root.y, (float) -root.z);
        poseStack.rotateAround(Axis.XP.rotationDegrees(Mth.lerp(partialTick, p_entity.xRotO, p_entity.getXRot())), (float) -root.x,(float) root.y, (float) -root.z);
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
