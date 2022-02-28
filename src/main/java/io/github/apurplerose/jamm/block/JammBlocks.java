package io.github.apurplerose.jamm.block;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.block.custom.*;
import io.github.apurplerose.jamm.item.JammItems;
import io.github.apurplerose.jamm.world.features.tree.MysticalSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import io.github.apurplerose.jamm.item.JammItemGroup;

public class JammBlocks {

        // ores
        public static final Block AMETHYST_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool(), UniformIntProvider.create(1, 7));
        public static final Block DARK_AMETHYST_ORE = new DarkAmethystOre();

        // altars
        public static final Block ASTRAL_ALTAR = new AstralAltarBlock();
        public static final Block LUNAR_ALTAR = new LunarAltarBlock();
        public static final Block TEMPLATE_ALTAR = new TemplateAltarBlock();

        // wood
        public static final Block MYSTICAL_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG));
        public static final Block MYSTICAL_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD));
        public static final Block STRIPPED_MYSTICAL_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG));
        public static final Block STRIPPED_MYSTICAL_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD));
        public static final Block MYSTICAL_PLANKS = new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS));

        public static final Block MYSTICAL_LEAVES =  new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
        public static final Block MYSTICAL_SAPLING = new JammSaplingBlock(new MysticalSaplingGenerator(), FabricBlockSettings.copy(Blocks.JUNGLE_SAPLING));

        // https://www.pinterest.de/pin/503699539567418170/ inspiration for look, final huge tree, biome and also the shrooms

        // misc
        public static final Block AMETHYST_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool());
        public static final Block STATUS_BLOCK = new StatusBlock();
        public static final Block TEST_BLOCK = new TestBlock();


        private static Block register(String name, Block block){
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

                register("mystical_log", MYSTICAL_LOG);
                register("mystical_wood", MYSTICAL_WOOD);
                register("stripped_mystical_log", STRIPPED_MYSTICAL_LOG);
                register("stripped_mystical_wood", STRIPPED_MYSTICAL_WOOD);
                register("mystical_planks", MYSTICAL_PLANKS);

                register("mystical_leaves", MYSTICAL_LEAVES);
                register("mystical_sapling", MYSTICAL_SAPLING);

                register("amethyst_block", AMETHYST_BLOCK);
                register("status_block", STATUS_BLOCK);
                register("test_block", TEST_BLOCK);
        }
}
