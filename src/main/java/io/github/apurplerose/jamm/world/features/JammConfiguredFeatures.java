package io.github.apurplerose.jamm.world.features;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.block.JammBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class JammConfiguredFeatures {

        public static final RegistryKey<ConfiguredFeature<?, ?>> MYSTICAL_TREE_KEY = registerKey("mystical_spawn");

        public static final ConfiguredFeature<TreeFeatureConfig, ?> MYSTICAL_TREE = register("mystical",
                Feature.TREE.configure(new TreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(JammBlocks.MYSTICAL_LOG.getDefaultState()),
                        new StraightTrunkPlacer(7,2,1), //there are multiple TrunkPlacers for forks and stuff
                        new SimpleBlockStateProvider(JammBlocks.MYSTICAL_LEAVES.getDefaultState()),
                        new SimpleBlockStateProvider(JammBlocks.MYSTICAL_SAPLING.getDefaultState()),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), // in video 2, 0, 3
                        new TwoLayersFeatureSize(1, 0, 1)).build()));

        public static final ConfiguredFeature<?, ?> MYSTICAL_TREE_SPAWN = register(MYSTICAL_TREE
                .decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING))
                        .spreadHorizontally().applyChance(3)), MYSTICAL_TREE_KEY);





        private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
                return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(Jamm.MOD_ID, name));
        }

        private static ConfiguredFeature<TreeFeatureConfig, ?> register(String name, ConfiguredFeature<TreeFeatureConfig, ?> configuredFeature) {
                return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Jamm.MOD_ID, name), configuredFeature);
        }

        private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature, RegistryKey<ConfiguredFeature<?, ?>> key) {
                return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
        }

        public static void registerConfiguredFeatures() {


        }
}
