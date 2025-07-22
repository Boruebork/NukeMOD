package net.boruebork.justamod.events;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.entity.ModEntities;
import net.boruebork.justamod.entity.client.HIMARSModel;
import net.boruebork.justamod.entity.client.HIMARSRenderer;
import net.boruebork.justamod.entity.client.NukeModel;
import net.boruebork.justamod.entity.client.NukeRenderer;
import net.boruebork.justamod.entity.custom.HIMARSMob;
import net.boruebork.justamod.keybyinds.ModKeyBinds;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = JustAMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(NukeModel.LAYER_LOCATION, NukeModel::createBodyLayer);
        event.registerLayerDefinition(HIMARSModel.LAYER_LOCATION, HIMARSModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void entityRender(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.NUKE.get(), NukeRenderer::new);
        event.registerEntityRenderer(ModEntities.HIMARS.get(), HIMARSRenderer::new);
    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.HIMARS.get(), HIMARSMob.createAttributesC().build());
    }
    @SubscribeEvent
    public static void registerKeyBindings(RegisterKeyMappingsEvent event){
        ModKeyBinds.register(event);
    }
    @SubscribeEvent // on the game event bus only on the physical client
    public static void onClientTick(ClientTickEvent.Post event) {
        while (ModKeyBinds.RELOAD_KEY.consumeClick()) {
            // Execute logic to perform on click here
        }
    }
    @SubscribeEvent // on the mod event bus
    public static void register(final RegisterPayloadHandlersEvent event) {
        // Sets the current network version
        final PayloadRegistrar registrar = event.registrar("1");
    }
}
