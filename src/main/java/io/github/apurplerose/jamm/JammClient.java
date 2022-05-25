package io.github.apurplerose.jamm;

import io.github.apurplerose.jamm.fluid.JammFluids;
import io.github.apurplerose.jamm.gui.screen.JammScreens;
import io.github.apurplerose.jamm.util.JammRenderHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;

@Environment(EnvType.CLIENT)
public class JammClient implements ClientModInitializer {

        @Override
        public void onInitializeClient() {
                JammScreens.registerScreens();
                JammRenderHelper.setRenderLayers();

                FluidRenderHandlerRegistry.INSTANCE.register(JammFluids.STARDUST_STILL,
                        new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                                SimpleFluidRenderHandler.WATER_FLOWING,
                                SimpleFluidRenderHandler.WATER_OVERLAY, 0xffffff));
                FluidRenderHandlerRegistry.INSTANCE.register(JammFluids.STARDUST_FLOWING,
                        new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                                SimpleFluidRenderHandler.WATER_FLOWING,
                                SimpleFluidRenderHandler.WATER_OVERLAY, 0xffffff));
        }
}
