package com.adonis.prism.registry;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.adonis.prism.CreatePrism.REGISTRATE;

public class CPItems {
    
    // Honeycomb Mold Item
    public static final ItemEntry<Item> HONEYCOMB_MOLD = REGISTRATE
            .item("honeycomb_mold", Item::new)
            .properties(p -> p.stacksTo(64))
            .register();
    
    public static void register() {
        // Static initialization
    }
}