package io.github.apurplerose.jamm.mixin;

import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NoiseChunkGenerator.class)
public class NoiseChunkGeneratorMixin {

        /*@Inject(
                method = "getEntitySpawnList(Lnet/minecraft/world/biome/Biome;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/collection/Pool;",
                at = @At(value = "HEAD"),
                cancellable = true
        )
        private void structureMobs(Biome biome, StructureAccessor accessor, SpawnGroup group, BlockPos pos,
                                   CallbackInfoReturnable<Pool<SpawnSettings.SpawnEntry>> cir) {
                Pool<SpawnSettings.SpawnEntry> pool = getStructureSpawns(biome, accessor, group, pos);

                if (pool != null) cir.setReturnValue(pool);
        }

        private static Pool<SpawnSettings.SpawnEntry> getStructureSpawns(Biome biome, StructureAccessor accessor, SpawnGroup group, BlockPos pos) {
                if (group == SpawnGroup.MONSTER) {
                        if (accessor.getStructureAt(pos, JammStructures.RUN_DOWN_HOUSE).hasChildren()) {
                                return RunDownHouseStructure.STRUCTURE_MONSTERS;
                        }
                } else if (group == SpawnGroup.CREATURE) {
                        if (accessor.getStructureAt(pos, JammStructures.RUN_DOWN_HOUSE).hasChildren()) {
                                return RunDownHouseStructure.STRUCTURE_CREATURES;
                        }
                }

                return null;
        }*/

}
