package io.github.titedog.contagion.example;

import io.github.titedog.contagion.Contagion;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;

public class ContagionExampleMod {

    public static boolean shouldRegisterExampleMod() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    public static void run() {
        Contagion.LOGGER.info("Registered Contagion Example Mod.");

        ItemGroup EXAMPLE_ITEM_GROUP = FabricItemGroupBuilder.build(
                Contagion.id("example_item_group"),
                () -> new ItemStack(Blocks.COBBLESTONE));
        Block EXAMPLE_STICKY_BLOCK = new Block(FabricBlockSettings.of(Material.PORTAL));
        Registry.register(Registry.BLOCK, Contagion.id("example_sticky_block"), EXAMPLE_STICKY_BLOCK);
        Registry.register(Registry.ITEM, Contagion.id("example_sticky_block"), new BlockItem(EXAMPLE_STICKY_BLOCK, new FabricItemSettings().group(EXAMPLE_ITEM_GROUP)));
    }
}