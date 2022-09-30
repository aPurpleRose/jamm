package io.github.apurplerose.jamm.blockentity;

import io.github.apurplerose.jamm.Jamm;
import io.github.apurplerose.jamm.block.JammBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JammBlockEntities {

        public static final BlockEntityType<?> ASTRAL_ALTAR = FabricBlockEntityTypeBuilder.create(AstralAltarBlockEntity::new, JammBlocks.ASTRAL_ALTAR).build(null);
        public static final BlockEntityType<?> LUNAR_ALTAR = FabricBlockEntityTypeBuilder.create(LunarAltarBlockEntity::new, JammBlocks.LUNAR_ALTAR).build(null);
        public static final BlockEntityType<?> TEMPLATE_ALTAR = FabricBlockEntityTypeBuilder.create(WoodenAltarBlockEntity::new, JammBlocks.WOODEN_ALTAR).build(null);


        private static void register(String name, BlockEntityType<? extends BlockEntity> blockEntity){
                Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Jamm.MOD_ID, name), blockEntity);
        }

        public static void registerBlockEntities(){
                System.out.println("Registering Mod Block Entities for " + Jamm.MOD_ID);

                register("astral_altar", ASTRAL_ALTAR);
                register("lunar_altar", LUNAR_ALTAR);
                register("template_altar", TEMPLATE_ALTAR);
        }

}