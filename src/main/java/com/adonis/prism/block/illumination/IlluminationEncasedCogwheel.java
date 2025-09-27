package com.adonis.prism.block.illumination;

import com.adonis.prism.block.glass.GlassEncasedCogwheel;
import net.minecraft.world.level.block.Block;
import java.util.function.Supplier;

public class IlluminationEncasedCogwheel extends GlassEncasedCogwheel {
    public IlluminationEncasedCogwheel(Properties properties, boolean large, Supplier<Block> casing) {
        super(properties.lightLevel(s -> 15), large, casing);
    }
}