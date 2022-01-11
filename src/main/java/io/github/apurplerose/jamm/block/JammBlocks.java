package io.github.apurplerose.jamm.block;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.block.custom.*;
import io.github.apurplerose.jamm.item.JammItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import io.github.apurplerose.jamm.item.JammItemGroup;

public class JammBlocks {

        // ores
        public static final Block AMETHYST_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool());
        public static final Block DARK_AMETHYST_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());

        // altars
        public static final Block ASTRAL_ALTAR = new AstralAltarBlock();
        public static final Block LUNAR_ALTAR = new LunarAltarBlock();
        public static final Block TEMPLATE_ALTAR = new TemplateAltarBlock();

        // misc
        public static final Block AMETHYST_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool());
        public static final Block STATUS_BLOCK = new StatusBlock();


        public static Block register(String name, Block block){
                JammItems.register(name, new BlockItem(block, new FabricItemSettings().group(JammItemGroup.JAMM)));
                return Registry.register(Registry.BLOCK, new Identifier(Jamm.MOD_ID, name), block);
        }

        public static void registerBlocks(){
                System.out.println("Registering Mod Blocks for " + Jamm.MOD_ID);

                register("amethyst_ore", AMETHYST_ORE);
                register("dark_amethyst_ore", DARK_AMETHYST_ORE);

                register("astral_altar", ASTRAL_ALTAR);
                register("lunar_altar", LUNAR_ALTAR);
                register("template_altar", TEMPLATE_ALTAR);

                register("amethyst_block", AMETHYST_BLOCK);
                register("status_block", STATUS_BLOCK);
        }
}
