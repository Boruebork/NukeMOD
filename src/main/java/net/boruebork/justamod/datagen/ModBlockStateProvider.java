package net.boruebork.justamod.datagen;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JustAMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile multiTextureBlock = models().cube(
                "multi_texture_block",
                modLoc("block/hs/hs_bottom"),  // down
                modLoc("block/hs/hs_top"),     // up
                modLoc("block/hs/hs_north"),   // north
                modLoc("block/hs/hs_side"),   // south
                modLoc("block/hs/hs_side"),    // west
                modLoc("block/hs/hs_side")     // east
        ).texture("particle", modLoc("block/hs/hs_north")); // particle texture

        // Assign model to block
        simpleBlockWithItem(ModBlocks.HIMARS_SPAWNER.get(), multiTextureBlock);

        blockWithItem(ModBlocks.ENRICHER);
        blockWithItem(ModBlocks.TITANIUM_BLOCK);
        blockWithItem(ModBlocks.TITANIUM_ORE);
        blockWithItem(ModBlocks.TUNGSTEN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_URANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TITANIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
        blockWithItem(ModBlocks.URANIUM_ORE);
        blockWithItem(ModBlocks.RARE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RARE_ORE);
        blockWithItem(ModBlocks.ENRICHED_URANIUM_BLOCK);
        blockWithItem(ModBlocks.MODERN_ALLOY_BLOCK);
        blockWithItem(ModBlocks.URANIUM_BLOCK);
        blockWithItem(ModBlocks.RARE_DUST_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}