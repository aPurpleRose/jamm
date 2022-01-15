package io.github.apurplerose.jamm.item;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.item.custom.*;
import io.github.apurplerose.jamm.item.custom.armor.AmethystChestplateArmorItem;
import io.github.apurplerose.jamm.item.custom.tool.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammItems {

        // resources
        public static final Item AMETHYST = new Item(defaults());
        public static final Item DARK_AMETHYST = new Item(defaults());

        // "complex" tools
        public static final Item AMETHYST_AXE = new ModAxeItem(JammToolMaterial.AMETHYST, 5.5f, -3.05f, defaults());
        public static final Item AMETHYST_HOE = new ModHoeItem(JammToolMaterial.AMETHYST, -2, -0.5f, defaults());
        public static final Item AMETHYST_PICKAXE = new ModPickaxeItem(JammToolMaterial.AMETHYST, 1, -2.8f, defaults());

        public static final Item DARK_AMETHYST_PICKAXE = new ModPickaxeItem(JammToolMaterial.DARK_AMETHYST, 1, -2.8f, defaults());

        // "simple" tools
        public static final Item AMETHYST_SHOVEL = new ShovelItem(JammToolMaterial.AMETHYST, 1.5f, -3, defaults());
        public static final Item AMETHYST_SWORD = new SwordItem(JammToolMaterial.AMETHYST, 3, -2.4f, defaults());

        public static final Item DARK_AMETHYST_SWORD = new SwordItem(JammToolMaterial.DARK_AMETHYST, 3, -2.4f, defaults());

        // armor
        public static final Item AMETHYST_HELMET = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.HEAD, defaults());
        public static final Item AMETHYST_CHESTPLATE = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.CHEST, defaults());
        public static final Item AMETHYST_LEGGINGS = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.LEGS, defaults());
        public static final Item AMETHYST_BOOTS = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.FEET, defaults());

        public static final Item AGILITY_AMETHYST_CHESTPLATE = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.CHEST, defaults(),
                new StatusEffect[]{StatusEffects.JUMP_BOOST, StatusEffects.SPEED});
        public static final Item TANK_AMETHYST_CHESTPLATE = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST_TANK, EquipmentSlot.CHEST, defaults(),
                new StatusEffect[]{StatusEffects.RESISTANCE});
        /* plan:
         * armor gives effects like high jump and speed and ..., maybe a custom paranoia effect when the armor gives too much strong effects
         * in order to grant these effects, you have to insert amulets into the chestplate via crafting, maybe you can also get them back somehow
         * amulets also grant effects when holding in inventory but weaker and maybe need more magic refilling?
         *
         * public static final Item AGILITY_AMETHYST_CHESTPLATE = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.CHEST, defaults(),
         *      new StatusEffect[]{StatusEffects.JUMP_BOOST, StatusEffects.SPEED});
         *
         * public static final Item TANK_AMETHYST_CHESTPLATE = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.CHEST, defaults(),
         *      new StatusEffect[]{StatusEffects.SLOWNESS, StatusEffects.HEALTH_BOOST});
         *
         * ASSASSINS_AMETHYST_CHESTPLATE (speed, jump boost (and less fall damage), strength, but less protection hp?)
         * MAGICIANS_AMETHYST_CHESTPLATE (custom enchants that help with magic somehow)
         * never eat
         *
         * different tiers, class DarkAmethystChestplateArmorItem is another step up beside different tiers in normal amethyst
         *
         */

        // custom items
        public static final Item AMETHYST_WAND = new AmethystWandItem();
        public static final Item DARK_AMETHYST_WAND = new DarkAmethystWandItem();
        public static final Item DOWSING_ROD = new DowsingRodItem();
        public static final Item TUTORIAL_BOOK = new TutorialBookItem();


        public static Item register(String name, Item item){
                return Registry.register(Registry.ITEM, new Identifier(Jamm.MOD_ID, name), item);
        }

        public static Item register(Identifier id, Item item){
                return Registry.register(Registry.ITEM, id, item);
        }

        public static void registerItems(){

                System.out.println("Registering Mod Items for " + Jamm.MOD_ID);

                // resources
                register("amethyst", AMETHYST);
                register("dark_amethyst", DARK_AMETHYST);

                // tools
                register("amethyst_axe", AMETHYST_AXE);
                register("amethyst_hoe", AMETHYST_HOE);
                register("amethyst_pickaxe", AMETHYST_PICKAXE);
                register("dark_amethyst_pickaxe", DARK_AMETHYST_PICKAXE);

                register("amethyst_shovel", AMETHYST_SHOVEL);
                register("amethyst_sword", AMETHYST_SWORD);
                register("dark_amethyst_sword", DARK_AMETHYST_SWORD);

                // armor
                register("amethyst_helmet", AMETHYST_HELMET);
                register("amethyst_chestplate", AMETHYST_CHESTPLATE);
                register("amethyst_leggings", AMETHYST_LEGGINGS);
                register("amethyst_boots", AMETHYST_BOOTS);

                // special chestplate
                register("agility_amethyst_chestplate", AGILITY_AMETHYST_CHESTPLATE);
                register("tank_amethyst_chestplate", TANK_AMETHYST_CHESTPLATE);

                // misc
                register("amethyst_wand", AMETHYST_WAND);
                register("dark_amethyst_wand", DARK_AMETHYST_WAND);
                register("dowsing_rod", DOWSING_ROD);
                register("tutorial_book", TUTORIAL_BOOK);
        }

        public static Item.Settings defaults()
        {
                return new FabricItemSettings().group(JammItemGroup.JAMM);
        }
}