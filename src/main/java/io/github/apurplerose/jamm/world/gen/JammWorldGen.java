package io.github.apurplerose.jamm.world.gen;

import io.github.apurplerose.jamm.Jamm;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.FlatChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.HashMap;

/*public class JammWorldGen {

        public static void generateJammWorldGen() {
                JammTreeGen.generateTrees();

                JammStructures.registerStructureFeatures();
                JammConfiguredStructures.registerConfiguredStructures();
                addStructureSpawningToDimensionsAndBiomes();
        }


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

}*/
