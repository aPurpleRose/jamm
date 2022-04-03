package io.github.apurplerose.jamm.world.structures;

import io.github.apurplerose.jamm.Jamm;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

public class JammStructures {

        public static final StructureFeature<StructurePoolFeatureConfig> RUN_DOWN_HOUSE = new RunDownHouseStructure(StructurePoolFeatureConfig.CODEC);


        public static void registerStructureFeatures() {

                FabricStructureBuilder.create(new Identifier(Jamm.MOD_ID, "run_down_house"), RUN_DOWN_HOUSE)
                        .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                        .defaultConfig(new StructureConfig(10, 5, 1570831457))
                        .adjustsSurface()
                        .register();


        }

}
