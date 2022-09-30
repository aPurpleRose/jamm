package io.github.apurplerose.jamm.world.features;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class JammPlacedFeatures {

        // net/minecraft/world/gen/feature/OrePlacedFeatures

        public static PlacedFeature AMETHYST_ORE = new PlacedFeature(
                RegistryEntry.of(JammConfiguredFeatures.AMETHYST_ORE),
                Arrays.asList(
                        CountPlacementModifier.of(7), // veins per chunk
                        SquarePlacementModifier.of(), //horizontal spread
                        HeightRangePlacementModifier.uniform(YOffset.belowTop(-32), YOffset.belowTop(-4))
                )
        );
        public static PlacedFeature DARK_AMETHYST_ORE = new PlacedFeature(
                RegistryEntry.of(JammConfiguredFeatures.DARK_AMETHYST_ORE),
                Arrays.asList(
                        CountPlacementModifier.of(3), // veins per chunk
                        SquarePlacementModifier.of(), //horizontal spread
                        HeightRangePlacementModifier.uniform(YOffset.belowTop(-48), YOffset.belowTop(-24))
                )
        );

        public static final RegistryKey<PlacedFeature> AMETHYST_ORE_KEY = registerKey("amethyst_ore");
        public static final RegistryKey<PlacedFeature> DARK_AMETHYST_ORE_KEY = registerKey("dark_amethyst_ore");


        public static void registerPlacedFeatures() {
                registerFeature("amethyst_ore", AMETHYST_ORE);
                registerFeature("dark_amethyst_ore", DARK_AMETHYST_ORE);
        }


        private static PlacedFeature registerFeature(String name, PlacedFeature feature) {
                return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Jamm.MOD_ID, name), feature);
        }

        private static RegistryKey<PlacedFeature> registerKey(String name) {
                return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Jamm.MOD_ID, name));
        }


}
