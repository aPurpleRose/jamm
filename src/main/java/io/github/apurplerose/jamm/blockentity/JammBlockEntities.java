package io.github.apurplerose.jamm.blockentity;

import io.github.apurplerose.jamm.Jamm;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import io.github.apurplerose.jamm.block.JammBlocks;

public class JammBlockEntities {

    public static final BlockEntityType<?> LUNAR_ALTAR_ENTITY = FabricBlockEntityTypeBuilder.create(LunarAltarBlockEntity::new, JammBlocks.LUNAR_ALTAR).build(null);
    public static final BlockEntityType<?> ASTRAL_ALTAR_ENTITY = FabricBlockEntityTypeBuilder.create(AstralAltarBlockEntity::new, JammBlocks.ASTRAL_ALTAR).build(null);
    public static final BlockEntityType<?> TEMPLATE_ALTAR_ENTITY = FabricBlockEntityTypeBuilder.create(TemplateAltarBlockEntity::new, JammBlocks.TEMPLATE_ALTAR).build(null);
    //so probably I need id instead? thats the difference between the both altars and only one is working


    public static void registerBlockEntities(){
        System.out.println("Registering Mod Block Entities for " + Jamm.MOD_ID);

        register("lunar_altar", LUNAR_ALTAR_ENTITY);
        register("astral_altar", ASTRAL_ALTAR_ENTITY);
        register("template_altar", TEMPLATE_ALTAR_ENTITY);
    }

    private static void register(String name, BlockEntityType<? extends BlockEntity> blockEntity){
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Jamm.MOD_ID, name), blockEntity);
    }
}