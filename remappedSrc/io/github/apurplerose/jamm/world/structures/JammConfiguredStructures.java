package io.github.apurplerose.jamm.world.structures;

import io.github.apurplerose.jamm.Jamm;
import net.minecraft.structure.PlainsVillageData;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class JammConfiguredStructures {

        public static final ConfiguredStructureFeature<?, ?> CONFIGURED_RUN_DOWN_HOUSE = JammStructures.RUN_DOWN_HOUSE
                .configure(new StructurePoolFeatureConfig(() -> PlainsVillageData.STRUCTURE_POOLS, 0));


        public static void registerConfiguredStructures() {
                Registry<ConfiguredStructureFeature<?,?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
                Registry.register(registry, new Identifier(Jamm.MOD_ID, "configured_run_down_house"), CONFIGURED_RUN_DOWN_HOUSE);
        }

}