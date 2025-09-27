package com.adonis.prism.registry;

import com.adonis.prism.block.CopperTap.CopperTapBlock;
import com.adonis.prism.block.glass.*;
import com.adonis.prism.util.CasingTypes;
import com.adonis.prism.util.GlassBlockList;
import com.adonis.prism.block.illumination.*;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;

import static com.adonis.prism.CreatePrism.REGISTRATE;
import static com.adonis.prism.registry.builders.GlassBlockBuilders.*;

public class CPBlocks {

    // ========== Glass Casings ==========
    public static final GlassBlockList<GlassCasing> GLASS_CASINGS =
            new GlassBlockList<>(CasingTypes.NORMAL_CASINGS.holders,
                    holder -> glassCasing(REGISTRATE, holder, false));

    public static final GlassBlockList<GlassCasing> CLEAR_GLASS_CASINGS =
            new GlassBlockList<>(CasingTypes.NORMAL_CASINGS.holders,
                    holder -> glassCasing(REGISTRATE, holder, true));

    public static final GlassBlockList<IlluminationCasing> ILLUMINATION_CASINGS =
            new GlassBlockList<>(CasingTypes.ILLUMINATION_CASINGS.holders,
                    holder -> illuminationCasing(REGISTRATE, holder));

    // ========== Glass Encased Shafts ==========
    public static final GlassBlockList<GlassEncasedShaft> GLASS_ENCASED_SHAFTS =
            new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
                    holder -> glassEncasedShaft(REGISTRATE, holder.name(), false,
                            p -> new GlassEncasedShaft(p, () -> GLASS_CASINGS.getCasing(holder.name()))));

    public static final GlassBlockList<GlassEncasedShaft> CLEAR_GLASS_ENCASED_SHAFTS =
            new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
                    holder -> glassEncasedShaft(REGISTRATE, holder.name(), true,
                            p -> new GlassEncasedShaft(p, () -> CLEAR_GLASS_CASINGS.getCasing(holder.name()))));

    public static final GlassBlockList<IlluminationEncasedShaft> ILLUMINATION_ENCASED_SHAFTS =
            new GlassBlockList<>(CasingTypes.ILLUMINATION_ENCASED.holders,
                    holder -> illuminationEncasedShaft(REGISTRATE, holder.name(),
                            p -> new IlluminationEncasedShaft(p, () -> ILLUMINATION_CASINGS.getCasing(holder.name()))));

    // ========== Glass Encased Cogwheels ==========
    // Small Cogwheels
    public static final GlassBlockList<GlassEncasedCogwheel> SMALL_GLASS_ENCASED_COGWHEELS =
            new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
                    holder -> glassEncasedCogwheel(REGISTRATE, holder.name(), false, false,
                            p -> new GlassEncasedCogwheel(p, false, () -> GLASS_CASINGS.getCasing(holder.name()))));

    public static final GlassBlockList<GlassEncasedCogwheel> SMALL_CLEAR_GLASS_ENCASED_COGWHEELS =
            new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
                    holder -> glassEncasedCogwheel(REGISTRATE, holder.name(), false, true,
                            p -> new GlassEncasedCogwheel(p, false, () -> CLEAR_GLASS_CASINGS.getCasing(holder.name()))));

    public static final GlassBlockList<IlluminationEncasedCogwheel> SMALL_ILLUMINATION_ENCASED_COGWHEELS =
            new GlassBlockList<>(CasingTypes.ILLUMINATION_ENCASED.holders,
                    holder -> illuminationEncasedCogwheel(REGISTRATE, holder.name(), false,
                            p -> new IlluminationEncasedCogwheel(p, false, () -> ILLUMINATION_CASINGS.getCasing(holder.name()))));

    // Large Cogwheels
    public static final GlassBlockList<GlassEncasedCogwheel> LARGE_GLASS_ENCASED_COGWHEELS =
            new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
                    holder -> glassEncasedCogwheel(REGISTRATE, holder.name(), true, false,
                            p -> new GlassEncasedCogwheel(p, true, () -> GLASS_CASINGS.getCasing(holder.name()))));

    public static final GlassBlockList<GlassEncasedCogwheel> LARGE_CLEAR_GLASS_ENCASED_COGWHEELS =
            new GlassBlockList<>(CasingTypes.GENERAL_ENCASED.holders,
                    holder -> glassEncasedCogwheel(REGISTRATE, holder.name(), true, true,
                            p -> new GlassEncasedCogwheel(p, true, () -> CLEAR_GLASS_CASINGS.getCasing(holder.name()))));

    public static final GlassBlockList<IlluminationEncasedCogwheel> LARGE_ILLUMINATION_ENCASED_COGWHEELS =
            new GlassBlockList<>(CasingTypes.ILLUMINATION_ENCASED.holders,
                    holder -> illuminationEncasedCogwheel(REGISTRATE, holder.name(), true,
                            p -> new IlluminationEncasedCogwheel(p, true, () -> ILLUMINATION_CASINGS.getCasing(holder.name()))));

    // ========== Glass Scaffoldings ==========
    // Standard Glass Scaffoldings
    public static final BlockEntry<MetalScaffoldingBlock> ANDESITE_GLASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, "andesite", false, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> BRASS_GLASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, "brass", false, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> COPPER_GLASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, "copper", false, MetalScaffoldingBlock::new);

    // Clear Glass Scaffoldings
    public static final BlockEntry<MetalScaffoldingBlock> CLEAR_ANDESITE_GLASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, "andesite", true, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> CLEAR_BRASS_GLASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, "brass", true, MetalScaffoldingBlock::new);

    public static final BlockEntry<MetalScaffoldingBlock> CLEAR_COPPER_GLASS_SCAFFOLD =
            glassScaffolding(REGISTRATE, "copper", true, MetalScaffoldingBlock::new);

    // ========== Original Blocks ==========
    public static final BlockEntry<CopperTapBlock> COPPER_TAP = REGISTRATE
            .block("copper_tap", CopperTapBlock::new)
            .initialProperties(SharedProperties::copperMetal)
            .properties(prop -> prop
                    .mapColor(MapColor.COLOR_ORANGE)
                    .sound(SoundType.COPPER)
                    .noOcclusion())
            .transform(TagGen.axeOrPickaxe())
            .blockstate((ctx, prov) -> {
                prov.getVariantBuilder(ctx.get())
                        .forAllStates(state -> {
                            Direction dir = state.getValue(CopperTapBlock.FACING);
                            int yRot = (int) dir.toYRot();
                            return ConfiguredModel.builder()
                                    .modelFile(prov.models().getExistingFile(prov.modLoc("block/copper_tap")))
                                    .rotationY(yRot)
                                    .build();
                        });
            })
            .item()
            .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/copper_tap")))
            .build()
            .register();

    public static void register() {
        // Static initialization - forces all static fields to be initialized
    }
}