package io.github.apurplerose.jamm.block;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.block.custom.AstralAltarBlock;
import io.github.apurplerose.jamm.block.custom.LunarAltarBlock;
import io.github.apurplerose.jamm.item.JammItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import io.github.apurplerose.jamm.block.custom.StatusBlock;
import io.github.apurplerose.jamm.item.JammItemGroup;

public class JammBlocks {

    // ores
    public static final Block AMETHYST_ORE = registerBlock("amethyst_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool()));
    public static final Block DARK_AMETHYST_ORE = registerBlock("dark_amethyst_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));

    // altars
    public static final Block ASTRAL_ALTAR = registerBlock("astral_altar",
            new AstralAltarBlock(FabricBlockSettings.of(Material.WOOD).strength(.5f)));
    public static final Block LUNAR_ALTAR = new LunarAltarBlock();
    public static final Block TEMPLATE_ALTAR = registerBlock("template_altar",
            new AstralAltarBlock(FabricBlockSettings.of(Material.WOOD).strength(.5f)));

    // misc
    public static final Block AMETHYST_BLOCK = registerBlock("amethyst_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool()));
    public static final Block STATUS_BLOCK = registerBlock("status_block",
            new StatusBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f).requiresTool()));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Jamm.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(Jamm.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(JammItemGroup.JAMM)));
    }

    public static Block register(String name, Block block){
        JammItems.register(name, new BlockItem(block, new FabricItemSettings().group(JammItemGroup.JAMM)));
        return Registry.register(Registry.BLOCK, new Identifier(Jamm.MOD_ID, name), block);
    }

    public static void registerBlocks(){
        System.out.println("Registering Mod Blocks for " + Jamm.MOD_ID);

        register("lunar_altar", LUNAR_ALTAR);
        //register("template_altar", TEMPLATE_ALTAR);
    }
}
