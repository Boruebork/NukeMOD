package net.boruebork.justamod.datagen;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.block.ModBlocks;
import net.boruebork.justamod.item.ModItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        // Add an instance of our generator to the list parameter. This can be done as many times as you want.
        // Having multiple generators is purely for organization, all functionality can be achieved with a single generator.
        super(output, lookupProvider, existingFileHelper, List.of(new ModAdvancementgenerator()));
    }
    private static final class ModAdvancementgenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
            HolderGetter<Biome> biomes = registries.lookupOrThrow(Registries.BIOME);
            HolderGetter<Structure> structures = registries.lookupOrThrow(Registries.STRUCTURE);
            String id = "advancements." + JustAMod.MOD_ID + ".";
            // Generate your advancements here.

            AdvancementSubProvider.createPlaceholder("justamod:justamod/root");

            // Create an advancement builder using the static #advancement() method.
            Advancement.Builder builder = Advancement.Builder.advancement();
            //Adding Criterion
            builder.addCriterion("pickup_dirt", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIRT));
            //        .addCriterion("get_titanium", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.TITANIUM));
            //AdvancementGen
            //ROOT
            AdvancementHolder root = builder.display(
                            new ItemStack(Items.TRIDENT),
                            // The advancement title and description. Don't forget to add translations for these!
                            Component.translatable("advancements.justamod.root.title"),
                            Component.translatable("advancements.justamod.root.description"),
                            // The background texture. Use null if you don't want a background texture (for non-root advancements).
                            ModBlocks.TITANIUM_BLOCK.getId(),
                            // The frame type. Valid values are AdvancementType.TASK, CHALLENGE, or GOAL.
                            AdvancementType.TASK,
                            // Whether to show the advancement toast or not.
                            true,
                            // Whether to announce the advancement into chat or not.
                            true,
                            // Whether the advancement should be hidden or not.
                            false
                    )
                    .requirements(AdvancementRequirements.allOf(List.of("pickup_dirt")))
                    .save(saver, ResourceLocation.fromNamespaceAndPath("justamod", "justamod/root"), existingFileHelper);
     //OBTAIN TITANIUM
            /*AdvancementHolder obtain_titanium = builder.parent(root)
                    .display(
                            new ItemStack(ModItems.TITANIUM.get()),
                            // The advancement title and description. Don't forget to add translations for these!
                            Component.translatable("advancements.justamod.obtain_titanium.title"),
                            Component.translatable("advancements.justamod.obtain_titanium.description"),
                            // The background texture. Use null if you don't want a background texture (for non-root advancements).
                            null,
                            // The frame type. Valid values are AdvancementType.TASK, CHALLENGE, or GOAL.
                            AdvancementType.TASK,
                            // Whether to show the advancement toast or not.
                            true,
                            // Whether to announce the advancement into chat or not.
                            true,
                            // Whether the advancement should be hidden or not.
                            false
                    ).requirements(AdvancementRequirements.allOf(List.of("get_titanium")))
                    .save(saver, ResourceLocation.fromNamespaceAndPath("justamod", "justamod/heavy_stuff"), existingFileHelper);
*/


        }
    }
}
