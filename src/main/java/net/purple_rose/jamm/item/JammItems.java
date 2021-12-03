package net.purple_rose.jamm.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.purple_rose.jamm.Jamm;
import net.purple_rose.jamm.item.custom.*;

public class JammItems {

    public static final Item AMETHYST = registerItem("amethyst",
            new Item(new FabricItemSettings().group(JammItemGroup.JAMM)));

    public static final Item AMETHYST_AXE = registerItem("amethyst_axe",
            new AmethystAxeItem(JammToolMaterial.AMETHYST, 2.5f, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM)));
    public static final Item AMETHYST_HOE = registerItem("amethyst_hoe",
            new AmethystHoeItem(JammToolMaterial.AMETHYST, 2, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM)));
    public static final Item AMETHYST_PICKAXE = registerItem("amethyst_pickaxe",
            new AmethystPickaxeItem(JammToolMaterial.AMETHYST, 2, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM)));

    public static final Item AMETHYST_SHOVEL = registerItem("amethyst_shovel",
            new ShovelItem(JammToolMaterial.AMETHYST, 2.5f, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM)));
    public static final Item AMETHYST_SWORD = registerItem("amethyst_sword",
            new SwordItem(JammToolMaterial.AMETHYST, 2, 1f,
                    new FabricItemSettings().group(JammItemGroup.JAMM)));

    public static final Item AMETHYST_WAND = registerItem("amethyst_wand",
            new AmethystWandItem(new FabricItemSettings().group(JammItemGroup.JAMM).maxCount(1)));
    public static final Item DARK_AMETHYST = registerItem("dark_amethyst",
            new Item(new FabricItemSettings().group(JammItemGroup.JAMM)));
    public static final Item DARK_AMETHYST_WAND = registerItem("dark_amethyst_wand",
            new DarkAmethystWandItem(new FabricItemSettings().group(JammItemGroup.JAMM).maxCount(1)));
    public static final Item DOWSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(JammItemGroup.JAMM).maxDamage(10)));
    public static final Item TUTORIAL_BOOK = registerItem("tutorial_book",
            new TutorialBookItem(new FabricItemSettings().group(JammItemGroup.JAMM)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Jamm.MOD_ID, name), item);
    }

    public static void registerItems(){
        System.out.println("Registering Mod Items for " + Jamm.MOD_ID);
    }
}