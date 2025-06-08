package net.boruebork.justamod.datagen;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JustAMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TITANIUM.get());
        basicItem(ModItems.RAW_TITANIUM.get());
        basicItem(ModItems.URANIUM_DUST.get());
        basicItem(ModItems.TUNGSTEN_INGOT.get());
        basicItem(ModItems.RAW_TUNGSTEN.get());
        basicItem(ModItems.RARE_DUST.get());
        basicItem(ModItems.DIRTY_RARE_DUST.get());
        basicItem(ModItems.DIAMOND_ROD.get());
        basicItem(ModItems.NEPTUNIUM.get());
        basicItem(ModItems.URANIUM_DUST.get());
        basicItem(ModItems.POLISHER.get());
        basicItem(ModItems.GEAR.get());
        basicItem(ModItems.HEAVY_WATER.get());
        basicItem(ModItems.ENRICHED_URANIUM_DUST.get());
        basicItem(ModItems.MODERN_ALLOY.get());
        basicItem(ModItems.NUCLEAR_WARHEAD.get());
    }
}