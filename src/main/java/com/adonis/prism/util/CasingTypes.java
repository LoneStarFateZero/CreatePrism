package com.adonis.prism.util;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.CasingBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum CasingTypes {

    NORMAL_CASINGS(
            createHolder("andesite", AllBlocks.ANDESITE_CASING),
            createHolder("brass", AllBlocks.BRASS_CASING),
            createHolder("copper", AllBlocks.COPPER_CASING),
            createHolder("train", AllBlocks.RAILWAY_CASING)
    ),

    SCAFFOLDING(
            createHolder("andesite", AllBlocks.ANDESITE_CASING),
            createHolder("brass", AllBlocks.BRASS_CASING),
            createHolder("copper", AllBlocks.COPPER_CASING)
    ),

    GENERAL_ENCASED(
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

    // 辅助方法来创建CasingHolder，明确使用Supplier版本
    private static CasingHolder createHolder(String name, com.tterrag.registrate.util.entry.BlockEntry<? extends CasingBlock> entry) {
        return new CasingHolder(name, entry::get);
    }
}