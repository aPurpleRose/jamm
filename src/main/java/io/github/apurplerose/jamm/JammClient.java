package io.github.apurplerose.jamm;

import io.github.apurplerose.jamm.gui.screen.JammScreens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class JammClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        JammScreens.registerScreens();
    }
}
