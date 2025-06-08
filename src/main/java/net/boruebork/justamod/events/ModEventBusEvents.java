package net.boruebork.justamod.events;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.entity.ModEntities;
import net.boruebork.justamod.entity.client.NukeModel;
import net.boruebork.justamod.entity.client.NukeRenderer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = JustAMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(NukeModel.LAYER_LOCATION, NukeModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void entityRender(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ModEntities.NUKE.get(), NukeRenderer::new);
    }
}
