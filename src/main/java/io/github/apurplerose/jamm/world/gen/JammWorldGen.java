package io.github.apurplerose.jamm.world.gen;

import io.github.apurplerose.jamm.world.features.JammConfiguredFeatures;
import io.github.apurplerose.jamm.world.features.JammPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class JammWorldGen {

        public static void generateJammWorldGen() {
                //JammTreeGen.generateTrees();

                //JammStructures.registerStructureFeatures();
                //JammConfiguredStructures.registerConfiguredStructures();
                //addStructureSpawningToDimensionsAndBiomes();

                JammConfiguredFeatures.registerConfiguredFeatures();
                JammPlacedFeatures.registerPlacedFeatures();

                addFeatures();
        }


        public static void addFeatures() {
                BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, JammPlacedFeatures.AMETHYST_ORE_KEY);
                BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, JammPlacedFeatures.DARK_AMETHYST_ORE_KEY);
        }

}

/*
        public static void addStructureSpawningToDimensionsAndBiomes() {
                BiomeModifications.addStructure(
                        BiomeSelectors.categories(
                                Biome.Category.DESERT,
                                Biome.Category.EXTREME_HILLS,
                                Biome.Category.FOREST,
                                Biome.Category.ICY,
                                Biome.Category.JUNGLE,
                                Biome.Category.PLAINS,
                                Biome.Category.SAVANNA,
                                Biome.Category.TAIGA),
                        RegistryKey.of(
                                Registry.CONFIGURED_STRUCTURE_FEATURE_KEY,
                                BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getId(JammConfiguredStructures.CONFIGURED_RUN_DOWN_HOUSE))
                );


                Identifier runAfterFabricAPIPhase = new Identifier(Jamm.MOD_ID, "run_after_fabric_api");
                ServerWorldEvents.LOAD.addPhaseOrdering(Event.DEFAULT_PHASE, runAfterFabricAPIPhase);

                ServerWorldEvents.LOAD.register(runAfterFabricAPIPhase, (MinecraftServer minecraftServer, ServerWorld serverWorld) -> {
                        if (serverWorld.getChunkManager().getChunkGenerator() instanceof FlatChunkGenerator && serverWorld.getRegistryKey().equals(World.OVERWORLD)) {
                                return;
                        }

                        StructuresConfig worldStructureConfig = serverWorld.getChunkManager().getChunkGenerator().getStructuresConfig();

                        Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(worldStructureConfig.getStructures());

                        if(serverWorld.getRegistryKey().equals(World.OVERWORLD)) {
                                tempMap.put(JammStructures.RUN_DOWN_HOUSE, FabricStructureImpl.STRUCTURE_TO_CONFIG_MAP.get(JammStructures.RUN_DOWN_HOUSE));
                        } else {
                                tempMap.remove(JammStructures.RUN_DOWN_HOUSE);
                        }

                        ((StructuresConfigAccessor)worldStructureConfig).setStructures(tempMap);
                });
        }
*/
