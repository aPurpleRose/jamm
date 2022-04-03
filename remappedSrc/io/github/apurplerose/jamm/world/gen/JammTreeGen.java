package io.github.apurplerose.jamm.world.gen;

import io.github.apurplerose.jamm.world.features.JammPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class JammTreeGen {

        public static void generateTrees() {
                BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                        GenerationStep.Feature.VEGETAL_DECORATION, JammPlacedFeatures.MYSTICAL_TREE_KEY);
        }

}
