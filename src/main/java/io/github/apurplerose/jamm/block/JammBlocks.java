package io.github.apurplerose.jamm.block;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.fluid.JammFluids;
import io.github.apurplerose.jamm.item.JammItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import io.github.apurplerose.jamm.item.JammItemGroup;

public class JammBlocks {

        //<editor-fold desc="ores">
        public static final Block AMETHYST_ORE = new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool(), UniformIntProvider.create(1, 7));
        public static final Block DARK_AMETHYST_ORE = new DarkAmethystOre();
        //</editor-fold>

        //<editor-fold desc="altars">
        public static final Block ASTRAL_ALTAR = new AstralAltarBlock();
        public static final Block LUNAR_ALTAR = new LunarAltarBlock();
        public static final Block WOODEN_ALTAR = new WoodenAltarBlock();
        //</editor-fold>

        //<editor-fold desc="trees">
        public static final Block MYSTICAL_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_LOG));
        public static final Block MYSTICAL_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.OAK_WOOD));
        public static final Block STRIPPED_MYSTICAL_LOG = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_LOG));
        public static final Block STRIPPED_MYSTICAL_WOOD = new PillarBlock(FabricBlockSettings.copy(Blocks.STRIPPED_OAK_WOOD));
        public static final Block MYSTICAL_PLANKS = new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS));

        public static final Block MYSTICAL_LEAVES =  new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES));
        //public static final Block MYSTICAL_SAPLING = new JammSaplingBlock(new MysticalSaplingGenerator(), FabricBlockSettings.copy(Blocks.JUNGLE_SAPLING));
        //</editor-fold>

        // https://www.pinterest.de/pin/503699539567418170/ inspiration for look, final huge tree, biome and also the shrooms

        //<editor-fold desc="misc">
        public static final Block AMETHYST_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3.0f).requiresTool());
        public static final Block DARK_AMETHYST_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool());
        public static final Block STATUS_BLOCK = new StatusBlock();
        public static final Block TEST_BLOCK = new TestBlock();
        public static final Block LIQUID_STARDUST_BLOCK = new JammFluidBlock(JammFluids.STARDUST_STILL, FabricBlockSettings.of(Material.WATER)
                .noCollision().nonOpaque().dropsNothing());
        //</editor-fold>


        private static Block register(String name, Block block){
                JammItems.register(name, new BlockItem(block, new FabricItemSettings().group(JammItemGroup.JAMM)));
                return Registry.register(Registry.BLOCK, new Identifier(Jamm.MOD_ID, name), block);
        }

        private static Block registerWithoutItem(String name, Block block){
                return Registry.register(Registry.BLOCK, new Identifier(Jamm.MOD_ID, name), block);
        }

        public static void registerBlocks(){
                System.out.println("Registering Mod Blocks for " + Jamm.MOD_ID);

                //<editor-fold desc="ores">
                register("amethyst_ore", AMETHYST_ORE);
                register("dark_amethyst_ore", DARK_AMETHYST_ORE);
                //</editor-fold>

                //<editor-fold desc="altars">
                register("astral_altar", ASTRAL_ALTAR);
                register("lunar_altar", LUNAR_ALTAR);
                register("wooden_altar", WOODEN_ALTAR);
                //</editor-fold>

                //<editor-fold desc="trees">
                register("mystical_log", MYSTICAL_LOG);
                register("mystical_wood", MYSTICAL_WOOD);
                register("stripped_mystical_log", STRIPPED_MYSTICAL_LOG);
                register("stripped_mystical_wood", STRIPPED_MYSTICAL_WOOD);
                register("mystical_planks", MYSTICAL_PLANKS);

                register("mystical_leaves", MYSTICAL_LEAVES);
                //register("mystical_sapling", MYSTICAL_SAPLING);
                //</editor-fold>

                //<editor-fold desc="misc">
                register("amethyst_block", AMETHYST_BLOCK);
                register("dark_amethyst_block", DARK_AMETHYST_BLOCK);
                register("status_block", STATUS_BLOCK);
                register("test_block", TEST_BLOCK);
                registerWithoutItem("liquid_stardust_block", LIQUID_STARDUST_BLOCK);
                //</editor-fold>
        }
}
