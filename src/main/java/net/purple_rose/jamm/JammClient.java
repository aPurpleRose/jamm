package net.purple_rose.jamm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.purple_rose.jamm.gui.handler.JammHandlers;
import net.purple_rose.jamm.gui.screen.AstralAltarScreen;
import net.purple_rose.jamm.gui.screen.JammScreens;

@Environment(EnvType.CLIENT)
public class JammClient implements ClientModInitializer {

    /*@Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        JammScreens.registerScreens();
    }*/

    @Override
    public void onInitializeClient(){
        ScreenRegistry.register(JammHandlers.ASTRAL_ALTAR, AstralAltarScreen::new);
    }
}
