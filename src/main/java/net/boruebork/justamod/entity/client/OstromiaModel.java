public class OstromiaModel<T extends OstromiaEntity> extends EntityModel<T>  {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ClawsAndFeathers.MOD_ID, "ostromia"), "main");
    private final ModelPart body;
    private final ModelPart head;

    public OstromiaModel(ModelPart root) {
        this.body = root.getChild("Body");
        this.head = root.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, 0.0F, -10.0F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 5.0F));

        PartDefinition Right_wing = partdefinition.addOrReplaceChild("Right_wing", CubeListBuilder.create().texOffs(32, 0).addBox(-8.5F, 0.0F, -1.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 43).addBox(-5.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 16.0F, -3.5F, 0.0F, 0.0F, -1.4399F));

        PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 9.7248F, -5.0523F, 0.0873F, 0.0F, 0.0F));

        PartDefinition Neck = Head.addOrReplaceChild("Neck", CubeListBuilder.create(), PartPose.offset(0.0F, 1.1577F, 2.3131F));

        PartDefinition Neck_r1 = Neck.addOrReplaceChild("Neck_r1", CubeListBuilder.create().texOffs(28, 42).addBox(-2.0F, -15.5F, -8.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, -2.0F, -0.3665F, 0.0F, 0.0F));

        PartDefinition Head2 = Head.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(32, 8).addBox(3.5F, 1.3129F, -10.0106F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(28, 31).addBox(2.5F, 0.8129F, -7.0106F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -1.3423F, 0.8131F));

        PartDefinition cube_r1 = Head2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 42).addBox(7.5F, -15.8F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 6.0F, 0.1134F, 0.2443F, 0.0F));

        PartDefinition cube_r2 = Head2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 8).addBox(-9.5F, -15.8F, -5.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 16.0F, 6.0F, 0.1134F, -0.2443F, 0.0F));

        PartDefinition Right_leg = partdefinition.addOrReplaceChild("Right_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 27.0F, 1.0F));

        PartDefinition kneeR = Right_leg.addOrReplaceChild("kneeR", CubeListBuilder.create().texOffs(20, 47).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -7.0F, 4.0F));

        PartDefinition bone2 = Right_leg.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, 0.0F, -2.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -11.0F, 3.0F));

        PartDefinition Left_leg = partdefinition.addOrReplaceChild("Left_leg", CubeListBuilder.create(), PartPose.offset(1.0F, 20.0F, 4.0F));

        PartDefinition bone = Left_leg.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(10, 47).addBox(-2.0F, 0.0F, -2.5F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -4.0F, 0.0F));

        PartDefinition kneeL = Left_leg.addOrReplaceChild("kneeL", CubeListBuilder.create().texOffs(44, 48).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

        PartDefinition Tail = partdefinition.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(30, 16).addBox(-1.5F, 0.0F, 12.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 31).addBox(-2.5F, 1.0F, 18.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 5.0F));

        PartDefinition Left_wing = partdefinition.addOrReplaceChild("Left_wing", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-0.5F, 0.0F, -1.0F, 9.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 43).mirror().addBox(0.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 16.0F, -3.5F, 0.0F, 0.0F, 1.4399F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(OstromiaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk( OstromiaAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, OstromiaAnimations.IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45f);

        this.head.yRot = headYaw * ((float) Math.PI / 180f);
        this.head.xRot = headPitch * ((float) Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color ) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);

    }

    @Override
    public ModelPart root(){};
}
