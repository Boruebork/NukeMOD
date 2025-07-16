/*package net.boruebork.justamod.fluid;

import net.boruebork.justamod.JustAMod;
import net.boruebork.justamod.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
        DeferredRegister.create(Registries.FLUID, JustAMod.MOD_ID);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_SOAP_WATER = FLUIDS.register("oil_fluid",
            () -> new BaseFlowingFluid.Source(ModFluids.SOAP_WATER_FLUID_PROPERTIES) {});
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_SOAP_WATER = FLUIDS.register("flowing_oil_fluid",
            () -> new BaseFlowingFluid.Flowing(ModFluids.SOAP_WATER_FLUID_PROPERTIES));


    public static final BaseFlowingFluid.Properties SOAP_WATER_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidTypes.SOAP_WATER_FLUID_TYPE, SOURCE_SOAP_WATER, FLOWING_SOAP_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.SOAP_WATER_BLOCK)
            .bucket(ModItems.OIL_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}*/
