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
import net.minecraft.resources.ResourceLocation;

public class HIMARSModel<T extends HIMARSMob> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(JustAMod.MOD_ID, "himars"), "main");
	private final ModelPart body;
	private final ModelPart interior;
	private final ModelPart guns;
	private final ModelPart wheels;
	private final ModelPart wheels2;
	private final ModelPart forwardwheels;

	public HIMARSModel(ModelPart root) {
		this.body = root.getChild("body");
		this.interior = this.body.getChild("interior");
		this.guns = root.getChild("guns");
		this.wheels = root.getChild("wheels");
		this.wheels2 = root.getChild("wheels2");
		this.forwardwheels = root.getChild("forwardwheels");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(54, 76).addBox(-11.0F, -13.0F, -14.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 67).addBox(-11.0F, -12.0F, -12.0F, 12.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 76).addBox(-11.0F, -8.0F, -20.0F, 12.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 22).addBox(-11.0F, -4.0F, -20.0F, 12.0F, 4.0F, 41.0F, new CubeDeformation(0.0F))
		.texOffs(48, 76).addBox(0.0F, -13.0F, -14.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 67).addBox(-11.0F, -13.0F, -19.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition interior = body.addOrReplaceChild("interior", CubeListBuilder.create().texOffs(0, 48).addBox(-5.0F, -5.0F, -15.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition guns = partdefinition.addOrReplaceChild("guns", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, 4.5F, -2.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.5F, -1.5F, -2.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.5F, -1.5F, -2.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.5F, 4.5F, -2.0F, 6.0F, 5.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 15.5F, 16.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition wheels = partdefinition.addOrReplaceChild("wheels", CubeListBuilder.create().texOffs(0, 1).addBox(-1.0F, 2.0F, 5.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(-1.0F, 2.0F, 10.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(-1.0F, 2.0F, 15.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 17.0F, 0.0F));

		PartDefinition wheels2 = partdefinition.addOrReplaceChild("wheels2", CubeListBuilder.create().texOffs(0, 1).addBox(-1.0F, -2.0F, -0.25F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(-1.0F, -2.0F, 4.75F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(-1.0F, -2.0F, 9.75F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, 21.0F, 5.25F, 0.0F, 0.0F, -3.1416F));

		PartDefinition forwardwheels = partdefinition.addOrReplaceChild("forwardwheels", CubeListBuilder.create().texOffs(0, 1).addBox(10.0F, -4.0F, -1.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, 23.0F, -16.0F));

		PartDefinition cube_r1 = forwardwheels.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 1).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(HIMARSMob entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		guns.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		wheels.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		wheels2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		forwardwheels.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}