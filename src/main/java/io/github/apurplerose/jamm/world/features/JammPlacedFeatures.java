package io.github.apurplerose.jamm.world.features;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

/*public class JammPlacedFeatures {

        public static final RegistryKey<PlacedFeature> MYSTICAL_TREE_KEY = registerKey("mystical_spawn");


        public static final PlacedFeature MYSTICAL_PLACED = registerPlacedFeature("mystical_spawn",
                JammConfiguredFeatures.MYSTICAL_TREE_RANDOM.withPlacement(VegetationPlacedFeatures.modifiers(
                        PlacedFeatures.createCountExtraModifier(1, 0.1f, 2))));


        public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
                return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
                return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

        private static PlacedFeature registerPlacedFeature(String name, PlacedFeature placedFeature) {
                return Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(Jamm.MOD_ID, name), placedFeature);
        }

        private static RegistryKey<PlacedFeature> registerKey(String name) {
                return RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Jamm.MOD_ID, name));
        }

}*/
