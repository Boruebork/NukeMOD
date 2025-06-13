package net.boruebork.justamod.entity.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class NukeEntity extends Entity {
    public Vec2 rotation = new Vec2(-90, 0);;
    public Vec3 moveTo;
    private float FPS = Minecraft.getInstance().getFps();
    private float deltaTime;
    private final float speed = 6;
    private final float yTop = 250;

    public NukeEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public void tick() {
        FPS = Minecraft.getInstance().getFps();
        deltaTime = 1 / FPS;
        moveTo = Vec3.directionFromRotation(rotation);
        if (!level().isClientSide()) {
            this.setRot(rotation.y, rotation.x);
            this.move(MoverType.SELF, new Vec3(
                    moveTo.x * deltaTime * speed,
                    moveTo.y * deltaTime * speed,
                    moveTo.z * deltaTime * speed
            ));
            if (position().y >= yTop){
               rotation = new Vec2(90, rotation.y);
            }
        }

    }
    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public boolean shouldRender(double x, double y, double z) {
        return true;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {    }
}
