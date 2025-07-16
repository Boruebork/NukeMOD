package net.boruebork.justamod.entity.client;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.entity.custom.HIMARSMob;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;

public class HIMARSModel<T extends HIMARSMob> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(JustAMod.MOD_ID, "himars"), "main");
	private final ModelPart guns;
	private final ModelPart bb_main;

	public HIMARSModel(ModelPart root) {
		this.guns = root.getChild("guns");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition guns = partdefinition.addOrReplaceChild("guns", CubeListBuilder.create().texOffs(-26, -22).addBox(-6.5F, 0.5F, -12.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(-26, -22).addBox(-6.5F, -5.5F, -12.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(-26, -22).addBox(0.5F, -5.5F, -12.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(-26, -22).addBox(0.5F, 0.5F, -12.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 11.5F, 6.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -7.0F, -20.0F, 12.0F, 4.0F, 41.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-11.0F, -11.0F, -20.0F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 45).addBox(-11.0F, -15.0F, -12.0F, 12.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 54).addBox(0.0F, -16.0F, -14.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 54).addBox(-11.0F, -16.0F, -14.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-11.0F, -16.0F, -19.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {;
		guns.render(poseStack, vertexConsumer, packedLight, packedOverlay);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay);

	}

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}
}