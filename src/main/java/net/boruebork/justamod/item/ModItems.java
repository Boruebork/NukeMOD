package net.boruebork.justamod.item;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.entity.ModEntities;
import net.boruebork.justamod.item.custom.PolisherItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(JustAMod.MOD_ID);

    public static final DeferredItem<Item> TITANIUM = ITEMS.register("titanium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NEPTUNIUM = ITEMS.register("neptunium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_ROD = ITEMS.register("diamond_rod",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RARE_DUST = ITEMS.register("rare_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLISHER = ITEMS.register("polisher",
            () -> new PolisherItem(new Item.Properties().durability(32)));
    public static final DeferredItem<Item> GEAR = ITEMS.register("gear",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIRTY_RARE_DUST = ITEMS.register("dirty_rare_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> URANIUM_DUST = ITEMS.register("uranium_dust",
            () -> new Item(new Item.Properties()));
     public static final DeferredItem<Item> HEAVY_WATER = ITEMS.register("heavy_water",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENRICHED_URANIUM_DUST = ITEMS.register("enriched_uranium_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MODERN_ALLOY = ITEMS.register("modern_alloy",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NUCLEAR_WARHEAD = ITEMS.register("nuclear_warhead",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
