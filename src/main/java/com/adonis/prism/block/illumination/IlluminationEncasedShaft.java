package com.adonis.prism.block.illumination;

import com.adonis.prism.block.glass.GlassEncasedShaft;
import net.minecraft.world.level.block.Block;
import java.util.function.Supplier;

public class IlluminationEncasedShaft extends GlassEncasedShaft {
    public IlluminationEncasedShaft(Properties properties, Supplier<Block> casing) {
        super(properties.lightLevel(s -> 15), casing);
    }
}