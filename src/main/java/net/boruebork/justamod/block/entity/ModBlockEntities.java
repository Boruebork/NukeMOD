package net.boruebork.justamod.block.entity;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, JustAMod.MOD_ID);


    public static final Supplier<BlockEntityType<EnricherBlockEntity>> URANIUM_ENRICHER_BE =
            BLOCK_ENTITIES.register("uranium_enricherr_be", () -> BlockEntityType.Builder.of(
                    EnricherBlockEntity::new, ModBlocks.ENRICHER.get()).build(null));
    public static final Supplier<BlockEntityType<LauncherBlockEntity>> LAUNCHER_BE =
            BLOCK_ENTITIES.register("launcher_be", () -> BlockEntityType.Builder.of(
                    LauncherBlockEntity::new, ModBlocks.LAUNCHER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}