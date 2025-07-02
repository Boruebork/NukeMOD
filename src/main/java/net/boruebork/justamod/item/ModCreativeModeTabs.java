package net.boruebork.justamod.item;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JustAMod.MOD_ID);

    public static final Supplier<CreativeModeTab> JUST_A_CREATIVE_MODE_TAB = CREATIVE_MODE_TAB.register("just_a_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.NEPTUNIUM.get()))
                    .title(Component.translatable("creativetab.justamod.just_a_tab"))
                    .displayItems((ItemDisplayParameters, output) ->{
                        output.accept(ModItems.NEPTUNIUM);
                        output.accept(ModItems.RAW_TITANIUM);
                        output.accept(ModItems.TITANIUM);
                        output.accept(ModItems.RAW_TUNGSTEN);
                        output.accept(ModItems.TUNGSTEN_INGOT);
                        output.accept(ModItems.DIAMOND_ROD);
                        output.accept(ModItems.DIRTY_RARE_DUST);
                        output.accept(ModItems.RARE_DUST);
                        output.accept(ModItems.GEAR);
                        output.accept(ModItems.URANIUM_DUST);
                        output.accept(ModItems.ENRICHED_URANIUM_DUST);
                        output.accept(ModItems.HEAVY_WATER);
                        output.accept(ModItems.MODERN_ALLOY);
                        output.accept(ModItems.NUCLEAR_WARHEAD);


                    })
                    .build());
    public static final Supplier<CreativeModeTab> JUST_A_CREATIVE_MODE_TAB_2 = CREATIVE_MODE_TAB.register("just_a_block_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.TITANIUM_ORE.get()))
                    .title(Component.translatable("creativetab.justamod.just_a_bloc_tab"))
                    .displayItems((ItemDisplayParameters, output) ->{
                        output.accept(ModBlocks.TITANIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE);
                        output.accept(ModBlocks.TITANIUM_BLOCK);
                        output.accept(ModBlocks.TUNGSTEN_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
                        //Tungsten_Block
                        output.accept(ModBlocks.URANIUM_ORE);
                        output.accept(ModBlocks.DEEPSLATE_URANIUM_ORE);
                        output.accept(ModBlocks.URANIUM_BLOCK);
                        output.accept(ModBlocks.ENRICHED_URANIUM_BLOCK);
                        output.accept(ModBlocks.RARE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_RARE_ORE);
                        output.accept(ModBlocks.RARE_DUST_BLOCK);
                        output.accept(ModBlocks.MODERN_ALLOY_BLOCK);
                        output.accept(ModBlocks.ENRICHER);

                    })
                    .build());
    static final Supplier<CreativeModeTab> JUST_A_CREATIVE_MODE_TAB_3 = CREATIVE_MODE_TAB.register("machine_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.POLISHER.get()))
                    .title(Component.translatable("creativetab.justamod.machine_tab"))
                    .displayItems((ItemDisplayParameters, output) ->{
                        output.accept(ModItems.GEAR);
                        output.accept(ModItems.POLISHER);
                        output.accept(ModItems.NUCLEAR_WARHEAD);

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
