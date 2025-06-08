package net.boruebork.justamod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class PolisherItem extends Item {
    private static final Map<Block, Block> POLISH_MAP =
            Map.of(
                    Blocks.DIORITE, Blocks.POLISHED_DIORITE,
                    Blocks.ANDESITE, Blocks.POLISHED_ANDESITE,
                    Blocks.BASALT, Blocks.POLISHED_BASALT,
                    Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE,
                    Blocks.GRANITE, Blocks.POLISHED_GRANITE,
                    Blocks.TUFF, Blocks.POLISHED_TUFF,
                    Blocks.COBBLED_DEEPSLATE, Blocks.POLISHED_DEEPSLATE

            );


    public PolisherItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(POLISH_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()){
                level.setBlockAndUpdate(context.getClickedPos(), POLISH_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
