package com.adonis.prism.util;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.CasingBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum CasingTypes {

    // 空置普通机壳
    NORMAL_CASINGS(
            createHolder("andesite", AllBlocks.ANDESITE_CASING),
            createHolder("brass", AllBlocks.BRASS_CASING),
            createHolder("copper", AllBlocks.COPPER_CASING),
            createHolder("train", AllBlocks.RAILWAY_CASING)
    ),

    // 脚手架
    SCAFFOLDING(
            createHolder("andesite", AllBlocks.ANDESITE_CASING),
            createHolder("brass", AllBlocks.BRASS_CASING),
            createHolder("copper", AllBlocks.COPPER_CASING)
    ),

    // 装填普通机壳
    GENERAL_ENCASED(
            createHolder("andesite", AllBlocks.ANDESITE_CASING),
            createHolder("brass", AllBlocks.BRASS_CASING),
            createHolder("copper", AllBlocks.COPPER_CASING),
            createHolder("train", AllBlocks.RAILWAY_CASING)
    ),

    // 空置照明机壳
    ILLUMINATION_CASINGS(
            createHolder("andesite", AllBlocks.ANDESITE_CASING),
            createHolder("brass", AllBlocks.BRASS_CASING),
            createHolder("copper", AllBlocks.COPPER_CASING),
            createHolder("train", AllBlocks.RAILWAY_CASING)
    ),

    // 装填照明机壳
    ILLUMINATION_ENCASED(
            createHolder("andesite", AllBlocks.ANDESITE_CASING),
            createHolder("brass", AllBlocks.BRASS_CASING),
            createHolder("train", AllBlocks.RAILWAY_CASING)
    );

    public final List<String> names = new ArrayList<>();
    public final List<Supplier<CasingBlock>> casings = new ArrayList<>();
    public final List<CasingHolder> holders = new ArrayList<>();

    CasingTypes(CasingHolder... holdersParam) {
        for (CasingHolder holder : holdersParam) {
            this.casings.add(holder.casing());
            this.names.add(holder.name());
            this.holders.add(holder);
        }
    }

    private static CasingHolder createHolder(String name, com.tterrag.registrate.util.entry.BlockEntry<? extends CasingBlock> entry) {
        return new CasingHolder(name, entry::get);
    }
}