package io.github.apurplerose.jamm.util;

import io.github.apurplerose.jamm.block.JammBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class JammRenderHelper {

        public static void setRenderLayers() {
                //BlockRenderLayerMap.INSTANCE.putBlock(JammBlocks.MYSTICAL_SAPLING, RenderLayer.getCutout());
                BlockRenderLayerMap.INSTANCE.putBlock(JammBlocks.MYSTICAL_LEAVES, RenderLayer.getCutout());
        }

}
