package io.github.titedog.contagion.registry;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.ArrayList;

/**
 * A small holder class for custom sticky blocks.
 * @since 1.0
 */
public class StickyBlockRegistry {
    public static final ArrayList<Block> STICKY_BLOCKS = new ArrayList<>();

    static {
        STICKY_BLOCKS.add(Blocks.SLIME_BLOCK);
        STICKY_BLOCKS.add(Blocks.HONEY_BLOCK);
    }
}