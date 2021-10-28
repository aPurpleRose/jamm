package net.purple_rose.jamm.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.purple_rose.jamm.Jamm;
import net.purple_rose.jamm.block.custom.AstralAltarBlock;
import net.purple_rose.jamm.block.custom.LunarAltarBlock;
import net.purple_rose.jamm.block.custom.StatusBlock;
import net.purple_rose.jamm.block.custom.TemplateAltarBlock;
import net.purple_rose.jamm.item.ModItemGroup;

public class ModBlocks {

    public static final Block AMETHYST_ORE = registerBlock("amethyst_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));
    public static final Block AMETHYST_BLOCK = registerBlock("amethyst_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));
    public static final Block ASTRAL_ALTAR = registerBlock("astral_altar",
            new AstralAltarBlock(FabricBlockSettings.of(Material.WOOD).strength(.5f)));
    public static final Block DARK_AMETHYST_ORE = registerBlock("dark_amethyst_ore",
            new LunarAltarBlock(FabricBlockSettings.of(Material.STONE).strength(4.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 3).requiresTool()));
    public static final Block LUNAR_ALTAR = registerBlock("lunar_altar",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(.5f).nonOpaque()));
    public static final Block TEMPLATE_ALTAR = registerBlock("template_altar",
            new TemplateAltarBlock(FabricBlockSettings.of(Material.WOOD).strength(.5f)));

    public static final Block STATUS_BLOCK = registerBlock("status_block",
            new StatusBlock(FabricBlockSettings.of(Material.STONE).strength(5.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 2).requiresTool()));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Jamm.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(Jamm.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(ModItemGroup.JAMM)));
    }

    public static void registerBlocks(){
        System.out.println("Registering Mod Blocks for " + Jamm.MOD_ID);
    }
}
