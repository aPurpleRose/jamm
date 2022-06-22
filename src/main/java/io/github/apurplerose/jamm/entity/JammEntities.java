package io.github.apurplerose.jamm.entity;

import io.github.apurplerose.jamm.Jamm;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammEntities
{
        public static final EntityType<MagicBulletEntity> MagicBulletEntityType = Registry.register(Registry.ENTITY_TYPE, new Identifier(Jamm.MOD_ID, "magic_bullet"),
                FabricEntityTypeBuilder.<MagicBulletEntity>create(SpawnGroup.MISC, MagicBulletEntity::new)
                        .dimensions(EntityDimensions.fixed(0.125f, 0.125f))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());


}
