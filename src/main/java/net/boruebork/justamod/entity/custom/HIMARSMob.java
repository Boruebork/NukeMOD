package net.boruebork.justamod.entity.custom;

import net.boruebork.justamod.entity.ModEntities;
import net.boruebork.justamod.item.ModItems;
import net.boruebork.justamod.keybyinds.ModKeyBinds;
import net.boruebork.justamod.screen.custom.UraniumEnricherScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Consumer;


public class HIMARSMob extends LivingEntity {
    public boolean isControlled = true;
    public float speed = 0;
    public final float maxSpeed = 10;
    public final float minSpeed = -2;
    public float rotY = 0;
    public float rotX = 0;
    public final float deltaTime = 0.05f;
    public Vec2 rotationOfSpawnedNuke;
    private boolean rocketlaunched = false;
    private int dispawnTime;
    private final int maxDispawnTime = 5*60*20;
    private final int maxRockets = 4;
    private int currentRockets;
    public Player playerRider;


    public HIMARSMob(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
        this.setRot(0 ,0);
        this.speed = 0;
        this.playerRider = (Player) this.getFirstPassenger();
        this.currentRockets = 0;
        this.dispawnTime = maxDispawnTime;
    }

    @Override
    public void onAddedToLevel() {
        if (this.getFirstPassenger() != null){
            this.playerRider = (Player) this.getFirstPassenger();
            this.playerRider.sendSystemMessage(this.playerRider.getName());
        }
        super.onAddedToLevel();
    }

    @Override
    public void travel(Vec3 travelVector) {
        Options Input = Minecraft.getInstance().options;
        if (!this.level().isClientSide){
            if (this.isControlled){
                travelVector = Vec3.directionFromRotation(new Vec2(rotX, rotY));
                if (!Input.keyAttack.isDown()){
                    this.rocketlaunched = false;
                }
                if (Input.keyAttack.isDown() && !this.rocketlaunched && this.currentRockets > 0){
                    EntityType<?> nuke = ModEntities.NUKE.get();
                    this.rocketlaunched = true;
                    this.currentRockets--;
                    this.rotationOfSpawnedNuke = this.getFirstPassenger().getRotationVector();
                    nuke.spawn((ServerLevel) this.level(), this.getOnPos(), MobSpawnType.TRIGGERED);
                }
                if (Input.keyUp.isDown()){
                    this.speed += 0.1f;
                }
                if (Input.keyDown.isDown()){
                    this.speed -=  0.1f;
                }
                if (Input.keyRight.isDown()){
                    this.rotY += 3;
                }
                if (Input.keyLeft.isDown()){
                    this.rotY -= 3;
                }
                this.move(MoverType.SELF, new Vec3(
                        travelVector.x * deltaTime * speed,
                        travelVector.y * deltaTime * speed,
                        travelVector.z * deltaTime *speed
                ));

            }
        }
        super.travel(travelVector);
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide){
            dispawnWhenNotRidedForTooLong();
            if (this.getHealth() <= 0.5f){
                explode(6);
            }
            this.setRot(rotY, rotX);
            if (this.speed > maxSpeed){
                this.speed = maxSpeed;
            }
            if (this.speed < minSpeed){
                this.speed = minSpeed;
            }
            if (ModKeyBinds.RELOAD_KEY.isDown()){
                if (this.playerRider != null && this.currentRockets < maxRockets){
                    Inventory playerInv = this.playerRider.getInventory();
                    ItemStack rocket = ModItems.NUCLEAR_WARHEAD.toStack();
                    this.playerRider.sendSystemMessage(Component.literal("Missiles Reloading from Inventory!"));
                    for (int i = 0; i < 36; ++i){
                        if (this.currentRockets >= maxRockets) {
                            break;
                        }else {
                            reloadRockets(playerInv, i, rocket);
                        }
                    }
                    this.playerRider.sendSystemMessage(Component.literal(String.valueOf(this.currentRockets)));

                }else {
                    assert this.playerRider != null;
                    this.playerRider.sendSystemMessage(Component.literal("Cannot reload missiles or the current Driver is null"));
                }
            }
        }
        super.tick();
    }
    private void reloadRockets(Inventory playerInv, int index, ItemStack rocket){
        if (playerInv.getItem(index) == rocket) {
            this.currentRockets++;
            playerInv.removeItem(index, 1);
            if (this.currentRockets <= maxRockets) {
                reloadRockets(playerInv, index, rocket);
            }
        }
    }
    private void dispawnWhenNotRidedForTooLong(){
        if (!this.isControlled){
            this.dispawnTime--;
        }else {
            this.dispawnTime = maxDispawnTime;
        }
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        getRided(player);
        this.isControlled = true;
        this.playerRider = player;
        this.playerRider.sendSystemMessage(this.playerRider.getName());
        player.sendSystemMessage(Component.literal(String.valueOf(this.currentRockets)));
        return InteractionResult.SUCCESS;
    }

    private void getRided(Player player) {
        player.startRiding(this);
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return List.of(ItemStack.EMPTY);
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot equipmentSlot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack) {

    }

    @Override
    public HumanoidArm getMainArm() {
        return null;
    }
    public static AttributeSupplier.Builder createAttributesC(){
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 100d)
                .add(Attributes.MOVEMENT_SPEED, 2);

    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
    }

    @Override
    protected void removePassenger(Entity passenger) {
        this.isControlled = false;
        this.speed = 0;
        this.playerRider = null;
        super.removePassenger(passenger);
    }
    private  void explode(float explosionPower){
        this.level().explode(
                    this,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    explosionPower, // Explosion radius
                    Level.ExplosionInteraction.MOB
        );
    }

    @Override
    public void load(CompoundTag tag) {
        this.speed = tag.getFloat("speed");
        this.currentRockets = tag.getInt("cr");
        super.load(tag);
    }

    @Override
    public boolean save(CompoundTag tag) {
        tag.putInt("cr", this.currentRockets);
        tag.putFloat("speed", this.speed);
        return super.save(tag);
    }
}