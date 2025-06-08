package net.boruebork.justamod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public class NukeEntity extends Entity {


    public NukeEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void tick() {

    }
    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {    }
}
