package io.github.apurplerose.jamm.world.features.tree;

import io.github.apurplerose.jamm.world.features.JammConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MysticalSaplingGenerator extends SaplingGenerator {

        @Nullable
        @Override
        protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
                return JammConfiguredFeatures.MYSTICAL_TREE;
        }

}