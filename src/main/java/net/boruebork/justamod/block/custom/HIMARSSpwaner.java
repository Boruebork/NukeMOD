package net.boruebork.justamod.block.custom;

import net.boruebork.justamod.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class HIMARSSpwaner extends Block {
    public HIMARSSpwaner(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = ModEntities.HIMARS.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
            player.startRiding(entity);
            level.destroyBlock(pos, false);
        }

        return InteractionResult.SUCCESS;
    }
    
}
