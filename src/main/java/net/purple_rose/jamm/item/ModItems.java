package net.purple_rose.jamm.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.purple_rose.jamm.Jamm;
import net.purple_rose.jamm.item.custom.AmethystWandItem;
import net.purple_rose.jamm.item.custom.DarkAmethystWandItem;
import net.purple_rose.jamm.item.custom.DowsingRodItem;
import net.purple_rose.jamm.item.custom.TutorialBookItem;

public class ModItems {

    public static final Item AMETHYST = registerItem("amethyst",
            new Item(new FabricItemSettings().group(ModItemGroup.JAMM)));
    public static final Item AMETHYST_WAND = registerItem("amethyst_wand",
            new AmethystWandItem(new FabricItemSettings().group(ModItemGroup.JAMM).maxCount(1)));
    public static final Item DARK_AMETHYST = registerItem("dark_amethyst",
            new Item(new FabricItemSettings().group(ModItemGroup.JAMM)));
    public static final Item DARK_AMETHYST_WAND = registerItem("dark_amethyst_wand",
            new DarkAmethystWandItem(new FabricItemSettings().group(ModItemGroup.JAMM).maxCount(1)));
    public static final Item DOWSING_ROD = registerItem("dowsing_rod",
            new DowsingRodItem(new FabricItemSettings().group(ModItemGroup.JAMM).maxDamage(10)));
    public static final Item TUTORIAL_BOOK = registerItem("tutorial_book",
            new TutorialBookItem(new FabricItemSettings().group(ModItemGroup.JAMM)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(Jamm.MOD_ID, name), item);
    }

    public static void registerItems(){
        System.out.println("Registering Mod Items for " + Jamm.MOD_ID);
    }
}