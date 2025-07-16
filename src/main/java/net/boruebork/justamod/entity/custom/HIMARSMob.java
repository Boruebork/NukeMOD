package net.boruebork.justamod.entity.custom;

import net.boruebork.justamod.entity.ModEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.IKeyMappingExtension;


public class HIMARSMob extends Entity {
    public float dispawnTime;
    public float health;
    public float maxHealth = 50;
    public final float maxDispawnTime = 60;
    public boolean isRided = true;
    public Player playerWhoSpawned;
    public int currentNukes;
    public final int maNukes = 4;

    public HIMARSMob(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.health = maxHealth;

    }

    @Override
    public void tick() {
        if (!this.level().isClientSide()){
            this.dispawnWhenNotRided();
            if (this.isRided){
                Options Input = Minecraft.getInstance().options;
                IKeyMappingExtension forward = Input.keyUp;

                if (Input.keyAttack.isDown()) {
                    if (this.currentNukes > 0) {
                        ModEntities.NUKE.get().spawn((ServerLevel) this.level(), this.getOnPos(), MobSpawnType.MOB_SUMMONED);
                    };
                    this.currentNukes--;
                }
            }
        }
        //ModEntities.NUKE.get().spawn((ServerLevel) this.level(), this.getOnPos(), MobSpawnType.MOB_SUMMONED);
        super.tick();
    }
    private void dispawnWhenNotRided() {
        if (!this.isRided) {
            this.dispawnTime -= 0.05f;
        } else {
            this.dispawnTime = maxDispawnTime;
        }
        if (this.dispawnTime <= 0) {
            this.discard();
        }
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand) {
        if (!level().isClientSide()){
            Entity himars = this;
            this.isRided = true;
            player.startRiding(himars);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    protected void applyGravity() {
        super.applyGravity();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        this.dispawnTime= tag.getFloat("removetime");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        tag.putFloat("removetime", this.dispawnTime);
    }

    @Override
    protected void removePassenger(Entity passenger) {
        this.playerWhoSpawned = (Player) passenger;
        this.dispawnTime = maxDispawnTime;
    }
}
