package net.purple_rose.jamm.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.purple_rose.jamm.Jamm;
import net.purple_rose.jamm.block.ModBlocks;

public class ModBlockEntities {

    public static final BlockEntityType<?> LUNAR_ALTAR_ENTITY = FabricBlockEntityTypeBuilder.create(LunarAltarEntity::new, ModBlocks.LUNAR_ALTAR).build(null);
    public static final BlockEntityType<?> ASTRAL_ALTAR_ENTITY = FabricBlockEntityTypeBuilder.create(AstralAltarEntity::new, ModBlocks.ASTRAL_ALTAR).build(null);


    public static void registerBlockEntities(){
        System.out.println("Registering Mod Block Entities for " + Jamm.MOD_ID);

        register("lunar_altar", LUNAR_ALTAR_ENTITY);
        register("astral_altar", ASTRAL_ALTAR_ENTITY);
    }

    private static void register(String name, BlockEntityType<? extends BlockEntity> blockEntity){
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Jamm.MOD_ID, name), blockEntity);
    }
}