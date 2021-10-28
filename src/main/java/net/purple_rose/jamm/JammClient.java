package net.purple_rose.jamm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.purple_rose.jamm.gui.screen.JammScreens;

@Environment(EnvType.CLIENT)
public class JammClient implements ClientModInitializer {

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        JammScreens.registerScreens();
    }
}
