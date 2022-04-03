package io.github.apurplerose.jamm.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class WoodenAltarBlockEntity extends AbstractAltarBlockEntity {

        public WoodenAltarBlockEntity(BlockPos pos, BlockState state) {
                super(JammBlockEntities.TEMPLATE_ALTAR, pos, state);
        }

}
