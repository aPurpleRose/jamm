package io.github.apurplerose.jamm.world.features;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.block.JammBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class JammConfiguredFeatures {

        public static final ConfiguredFeature<TreeFeatureConfig, ?> MYSTICAL_TREE = register("mystical",
                Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(JammBlocks.MYSTICAL_LOG),
                        new StraightTrunkPlacer(7,2,1), //there are multiple TrunkPlacers for forks and stuff
                        BlockStateProvider.of(JammBlocks.MYSTICAL_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), // in video 2, 0, 3
                        new TwoLayersFeatureSize(1, 0, 1)).build()));



        public static final ConfiguredFeature<RandomFeatureConfig, ?> MYSTICAL_TREE_RANDOM = register("mystical_feature",
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(List.of(new RandomFeatureEntry(
                        MYSTICAL_TREE.withWouldSurviveFilter(JammBlocks.MYSTICAL_SAPLING), 0.1f)),
                        MYSTICAL_TREE.withWouldSurviveFilter(JammBlocks.MYSTICAL_SAPLING))));


        private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
                return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Jamm.MOD_ID, name), configuredFeature);
        }

        public static void registerConfiguredFeatures() {


        }
}
