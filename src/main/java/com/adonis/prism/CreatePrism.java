package com.adonis.prism;

import com.adonis.prism.registry.*;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Random;

@Mod(CreatePrism.MOD_ID)
public class CreatePrism {
    public static final String MOD_ID = "prism";
    public static final String NAME = "Create Prism";
    public static final Random RANDOM = new Random();

    public static final CPRegistrate REGISTRATE = CPRegistrate.create(MOD_ID)
            .setTooltipModifierFactory(item ->
                    new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE)
                            .andThen(TooltipModifier.mapNull(KineticStats.create(item)))
            );

    public CreatePrism(IEventBus modEventBus, ModContainer modContainer) {
        // Register Registrate
        REGISTRATE.registerEventListeners(modEventBus);

        CPBlocks.register();
        CPBlockEntities.register();
        CPItems.register();
        CPCreativeTab.register(modEventBus);
        CPPartialModels.register();

        // Register events
        modEventBus.addListener(this::onCommonSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Initialize partial models
            CPPartialModels.init();
        });
    }

    public static ResourceLocation asResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}