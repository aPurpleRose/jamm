package io.github.apurplerose.jamm.item;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.item.custom.*;
import io.github.apurplerose.jamm.item.custom.tool.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammItems {

    // resources
    public static final Item AMETHYST = new Item(new FabricItemSettings().group(JammItemGroup.JAMM));
    public static final Item DARK_AMETHYST = new Item(new FabricItemSettings().group(JammItemGroup.JAMM));

    // complex tools
    public static final Item AMETHYST_AXE = new AmethystAxeItem(JammToolMaterial.AMETHYST, 2.5f, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM));
    public static final Item AMETHYST_HOE = new AmethystHoeItem(JammToolMaterial.AMETHYST, 2, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM));
    public static final Item AMETHYST_PICKAXE = new AmethystPickaxeItem(JammToolMaterial.AMETHYST, 2, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM));

    // simple tools
    public static final Item AMETHYST_SHOVEL = new ShovelItem(JammToolMaterial.AMETHYST, 2.5f, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM));
    public static final Item AMETHYST_SWORD = new SwordItem(JammToolMaterial.AMETHYST, 2, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM));

    // custom items
    public static final Item AMETHYST_WAND = new AmethystWandItem(new FabricItemSettings().group(JammItemGroup.JAMM).maxCount(1));
    public static final Item DARK_AMETHYST_WAND = new DarkAmethystWandItem(new FabricItemSettings().group(JammItemGroup.JAMM).maxCount(1));
    public static final Item DOWSING_ROD = new DowsingRodItem(new FabricItemSettings().group(JammItemGroup.JAMM).maxDamage(10));
    public static final Item TUTORIAL_BOOK = new TutorialBookItem(new FabricItemSettings().group(JammItemGroup.JAMM));


    public static Item register(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Jamm.MOD_ID, name), item);
    }

    public static Item register(Identifier id, Item item){
        return Registry.register(Registry.ITEM, id, item);
    }

    public static void registerItems(){

        System.out.println("Registering Mod Items for " + Jamm.MOD_ID);

        register("amethyst", AMETHYST);
        register("dark_amethyst", DARK_AMETHYST);

        register("amethyst_axe", AMETHYST_AXE);
        register("amethyst_hoe", AMETHYST_HOE);
        register("amethyst_pickaxe", AMETHYST_PICKAXE);

        register("amethyst_shovel", AMETHYST_SHOVEL);
        register("amethyst_sword", AMETHYST_SWORD);

        register("amethyst_wand", AMETHYST_WAND);
        register("dark_amethyst_wand", DARK_AMETHYST_WAND);
        register("dowsing_rod", DOWSING_ROD);
        register("tutorial_book", TUTORIAL_BOOK);
    }
}