package io.github.apurplerose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class TemplateAltarBlockEntity extends AbstractAltarBlockEntity {

    public TemplateAltarBlockEntity(BlockPos pos, BlockState state) {
        super(JammBlockEntities.TEMPLATE_ALTAR, pos, state);
    }

}
