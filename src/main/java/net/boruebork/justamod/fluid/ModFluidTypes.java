/*package net.boruebork.justamod.fluid;

import net.boruebork.justamod.JustAMod;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_flow");
    public static final ResourceLocation SOAP_OVERLAY_RL = ResourceLocation.fromNamespaceAndPath(JustAMod.MOD_ID, "misc/in_soap_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, JustAMod.MOD_ID);

    public static final DeferredHolder<FluidType, FluidType> SOAP_WATER_FLUID_TYPE = register("soap_water_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));



    private static DeferredHolder<FluidType, FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFlowingFluid.Properties(WATER_STILL_RL, WATER_FLOWING_RL, SOAP_OVERLAY_RL, ));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
}*/
