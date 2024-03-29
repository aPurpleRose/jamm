package io.github.apurplerose.jamm.item;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.fluid.JammFluids;
import io.github.apurplerose.jamm.item.custom.DarkAmethystItem;
import io.github.apurplerose.jamm.item.custom.DowsingRodItem;
import io.github.apurplerose.jamm.item.custom.TutorialBookItem;
import io.github.apurplerose.jamm.item.custom.armor.AmethystChestplateArmorItem;
import io.github.apurplerose.jamm.item.custom.armor.SaturationAmethystChestplate;
import io.github.apurplerose.jamm.item.custom.tool.ModAxeItem;
import io.github.apurplerose.jamm.item.custom.tool.ModHoeItem;
import io.github.apurplerose.jamm.item.custom.tool.ModPickaxeItem;
import io.github.apurplerose.jamm.item.custom.wand.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammItems
{

        //<editor-fold desc="resources">
        public static final Item AMETHYST = new Item(defaults());
        public static final Item DARK_AMETHYST = new DarkAmethystItem(defaults());
        public static final Item INFUSED_AMETHYST = new Item(defaults());
        //</editor-fold>

        //<editor-fold desc="complex tools">
        public static final Item AMETHYST_AXE = new ModAxeItem(JammToolMaterial.AMETHYST, 5.5f, -3.05f, defaults());
        public static final Item AMETHYST_HOE = new ModHoeItem(JammToolMaterial.AMETHYST, -2, -0.5f, defaults());
        public static final Item AMETHYST_PICKAXE = new ModPickaxeItem(JammToolMaterial.AMETHYST, 1, -2.8f, defaults());

        public static final Item DARK_AMETHYST_PICKAXE = new ModPickaxeItem(JammToolMaterial.DARK_AMETHYST, 1, -2.8f, defaults());
        //</editor-fold>

        //<editor-fold desc="simple tools">
        public static final Item AMETHYST_SHOVEL = new ShovelItem(JammToolMaterial.AMETHYST, 1.5f, -3, defaults());
        public static final Item AMETHYST_SWORD = new SwordItem(JammToolMaterial.AMETHYST, 3, -2.4f, defaults());

        public static final Item DARK_AMETHYST_SWORD = new SwordItem(JammToolMaterial.DARK_AMETHYST, 3, -2.4f, defaults());
        //</editor-fold>

        //<editor-fold desc="orbs">
        public static final Item ORB = new Item(defaults());
        public static final Item AGILITY_ORB = new Item(defaults());
        public static final Item COMBAT_ORB = new Item(defaults());
        public static final Item CONDUIT_POWER_ORB = new Item(defaults());
        public static final Item HEALING_ORB = new Item(defaults());
        public static final Item MINING_ORB = new Item(defaults());
        public static final Item SATURATION_ORB = new Item(defaults());
        public static final Item TANK_ORB = new Item(defaults());
        //</editor-fold>

        //<editor-fold desc="armor">
        public static final Item AMETHYST_HELMET = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.HEAD, defaults());
        public static final Item AMETHYST_CHESTPLATE = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.CHEST, defaults());
        public static final Item AMETHYST_LEGGINGS = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.LEGS, defaults());
        public static final Item AMETHYST_BOOTS = new ArmorItem(JammArmorMaterial.AMETHYST, EquipmentSlot.FEET, defaults());

        // material has to be different, armors with the same material get the same effect because of the material to effect map, maybe this is fixable
        public static final Item AMETHYST_CHESTPLATE_AGILITY = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST_AGILITY, EquipmentSlot.CHEST, defaults(),
                new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, 2, false, false),
                new StatusEffectInstance(StatusEffects.SPEED, 20, 2, false, false));
        public static final Item AMETHYST_CHESTPLATE_COMBAT = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST_COMBAT, EquipmentSlot.CHEST, defaults(),
                new StatusEffectInstance(StatusEffects.HASTE, 20, 1, false, false),
                new StatusEffectInstance(StatusEffects.STRENGTH, 20, 1, false, false));
        public static final Item AMETHYST_CHESTPLATE_CONDUIT_POWER = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST_CONDUIT_POWER, EquipmentSlot.CHEST, defaults(),
                new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 20, 0, false, false));
        public static final Item AMETHYST_CHESTPLATE_HEALING = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST_HEALING, EquipmentSlot.CHEST, defaults(),
                new StatusEffectInstance(StatusEffects.REGENERATION, 20, 1, false, false));
        public static final Item AMETHYST_CHESTPLATE_MINING = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST_MINING, EquipmentSlot.CHEST, defaults(),
                new StatusEffectInstance(StatusEffects.HASTE, 20, 2, false, false),
                new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20, 0, false, false));
        public static final Item AMETHYST_CHESTPLATE_SATURATION = new SaturationAmethystChestplate(JammArmorMaterial.AMETHYST_SATURATION, EquipmentSlot.CHEST, defaults());
        public static final Item AMETHYST_CHESTPLATE_TANK = new AmethystChestplateArmorItem(JammArmorMaterial.AMETHYST_TANK, EquipmentSlot.CHEST, defaults(),
                new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 2, false, false),
                new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20, 0, false, false));


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
        //</editor-fold>

        //<editor-fold desc="wands">
        public static final Item AMETHYST_WAND = new WandItem();
        public static final Item DARK_AMETHYST_WAND = new WandItem();

        //<editor-fold desc="normal wands">
        public static final Item WAND_AGILITY_WEAK = new EffectWandItem(
                new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 1, false, false),
                new StatusEffectInstance(StatusEffects.SPEED, 200, 1, false, false));
        public static final Item WAND_AGILITY_STRONG = new EffectWandItem(
                new StatusEffectInstance(StatusEffects.JUMP_BOOST, 600, 3, false, false),
                new StatusEffectInstance(StatusEffects.SPEED, 600, 3, false, false));

        public static final Item WAND_HEALING_WEAK = new EffectWandItem(
                //new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 0, 0, false, false),
                new StatusEffectInstance(StatusEffects.REGENERATION, 60, 0, false, false));
        public static final Item WAND_HEALING_STRONG = new EffectWandItem(
                //new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 0, 1, false, false),
                new StatusEffectInstance(StatusEffects.REGENERATION, 60, 1, false, false));

        public static final Item WAND_LAUNCH_WEAK = new LaunchWand();
        public static final Item WAND_LAUNCH_STRONG = new LaunchWand(100, true);

        public static final Item WAND_LEVITATION_WEAK = new EffectWandItem(
                new StatusEffectInstance(StatusEffects.LEVITATION, 100, 0, false, false)); //1
        public static final Item WAND_LEVITATION_STRONG = new EffectWandItem(
                new StatusEffectInstance(StatusEffects.LEVITATION, 100, 2, false, false)); //3

        public static final Item WAND_REPULSION_WEAK = new RepulsionWand();
        public static final Item WAND_REPULSION_STRONG = new RepulsionWand(100, true);

        public static final Item WAND_SLOW_FALLING_WEAK = new EffectWandItem(
                new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, 0, false, false)
        );
        //</editor-fold>

        /*public static final Item AMETHYST_WAND_FREEZE = new EffectWandItem(
                new StatusEffectInstance(JammEffects.FREEZE, 100, 0, false, false));*/

        //<editor-fold desc="special wands">
        public static final Item BREAK_WAND = new BreakWandItem();
        public static final Item FIREBALL_WAND = new FireballWand();

        //<editor-fold desc="bullet wands">
        public static final Item BULLET_WAND_BREAK = new BulletWandItem(1);
        public static final Item BULLET_WAND_LAUNCH_WEAK = new BulletWandItem(2);
        public static final Item BULLET_WAND_LAUNCH_STRONG = new BulletWandItem(2, true);
        public static final Item BULLET_WAND_LIGHTNING = new BulletWandItem(3);
        public static final Item BULLET_WAND_NECROMANCY = new BulletWandItem(4);
        public static final Item BULLET_WAND_REPULSION_WEAK = new BulletWandItem(5);
        public static final Item BULLET_WAND_REPULSION_STRONG = new BulletWandItem(5, true);
        //</editor-fold>

        //</editor-fold>


        //<editor-fold desc="misc items">
        public static final Item DOWSING_ROD = new DowsingRodItem();
        public static final Item TUTORIAL_BOOK = new TutorialBookItem();
        public static final Item STARDUST_BUCKET = new BucketItem(JammFluids.STARDUST_STILL, new FabricItemSettings().group(JammItemGroup.JAMM).maxCount(1));


        //public static final Item MAGIC_BULLET = new MagicBulletItem(defaults().maxCount(16));

        //</editor-fold>


        public static Item register(String name, Item item){
                return Registry.register(Registry.ITEM, new Identifier(Jamm.MOD_ID, name), item);
        }

        public static Item register(Identifier id, Item item){
                return Registry.register(Registry.ITEM, id, item);
        }

        public static void registerItems()
        {
                System.out.println("Registering Mod Items for " + Jamm.MOD_ID);

                //<editor-fold desc="resources">
                register("amethyst", AMETHYST);
                register("dark_amethyst", DARK_AMETHYST);
                register("infused_amethyst", INFUSED_AMETHYST);
                //</editor-fold>

                //<editor-fold desc="tools">
                register("amethyst_axe", AMETHYST_AXE);
                register("amethyst_hoe", AMETHYST_HOE);
                register("amethyst_pickaxe", AMETHYST_PICKAXE);
                register("dark_amethyst_pickaxe", DARK_AMETHYST_PICKAXE);

                register("amethyst_shovel", AMETHYST_SHOVEL);
                register("amethyst_sword", AMETHYST_SWORD);
                register("dark_amethyst_sword", DARK_AMETHYST_SWORD);
                //</editor-fold>

                //<editor-fold desc="orbs">
                register("orb", ORB);
                register("agility_orb", AGILITY_ORB);
                register("combat_orb", COMBAT_ORB);
                register("conduit_power_orb", CONDUIT_POWER_ORB);
                register("healing_orb", HEALING_ORB);
                register("mining_orb", MINING_ORB);
                register("saturation_orb", SATURATION_ORB);
                register("tank_orb", TANK_ORB);
                //</editor-fold>

                //<editor-fold desc="armor">
                register("amethyst_helmet", AMETHYST_HELMET);
                register("amethyst_chestplate", AMETHYST_CHESTPLATE);
                register("amethyst_leggings", AMETHYST_LEGGINGS);
                register("amethyst_boots", AMETHYST_BOOTS);
                //</editor-fold>

                //<editor-fold desc="special chestplate">
                register("amethyst_chestplate_agility", AMETHYST_CHESTPLATE_AGILITY);
                register("amethyst_chestplate_combat", AMETHYST_CHESTPLATE_COMBAT);
                register("amethyst_chestplate_conduit_power", AMETHYST_CHESTPLATE_CONDUIT_POWER);
                register("amethyst_chestplate_healing", AMETHYST_CHESTPLATE_HEALING);
                register("amethyst_chestplate_mining", AMETHYST_CHESTPLATE_MINING);
                register("amethyst_chestplate_saturation", AMETHYST_CHESTPLATE_SATURATION);
                register("amethyst_chestplate_tank", AMETHYST_CHESTPLATE_TANK);

                //</editor-fold>

                //<editor-fold desc="wands">
                register("amethyst_wand", AMETHYST_WAND);
                register("dark_amethyst_wand", DARK_AMETHYST_WAND);

                register("wand_agility_weak", WAND_AGILITY_WEAK);
                register("wand_agility_strong", WAND_AGILITY_STRONG);
                register("wand_healing_weak", WAND_HEALING_WEAK);
                register("wand_healing_strong", WAND_HEALING_STRONG);
                register("wand_launch_weak", WAND_LAUNCH_WEAK);
                register("wand_launch_strong", WAND_LAUNCH_STRONG);
                register("wand_levitation_weak", WAND_LEVITATION_WEAK);
                register("wand_levitation_strong", WAND_LEVITATION_STRONG);
                register("wand_repulsion_weak", WAND_REPULSION_WEAK);
                register("wand_repulsion_strong", WAND_REPULSION_STRONG);
                register("wand_slow_falling_weak", WAND_SLOW_FALLING_WEAK);

                register("break_wand", BREAK_WAND);
                register("fireball_wand", FIREBALL_WAND);

                register("bullet_wand_break", BULLET_WAND_BREAK);
                register("bullet_wand_launch_weak", BULLET_WAND_LAUNCH_WEAK);
                register("bullet_wand_launch_strong", BULLET_WAND_LAUNCH_STRONG);
                register("bullet_wand_lightning", BULLET_WAND_LIGHTNING);
                register("bullet_wand_necromancy", BULLET_WAND_NECROMANCY);
                register("bullet_wand_repulsion_weak", BULLET_WAND_REPULSION_WEAK);
                register("bullet_wand_repulsion_strong", BULLET_WAND_REPULSION_STRONG);


                //</editor-fold>

                //<editor-fold desc="misc">
                register("tutorial_book", TUTORIAL_BOOK);
                register("stardust_bucket", STARDUST_BUCKET);
                //</editor-fold>

                // tests
                register("dowsing_rod", DOWSING_ROD);
                //register("magic_bullet", MAGIC_BULLET);
        }

        public static Item.Settings defaults()
        {
                return new FabricItemSettings().group(JammItemGroup.JAMM);
        }
}