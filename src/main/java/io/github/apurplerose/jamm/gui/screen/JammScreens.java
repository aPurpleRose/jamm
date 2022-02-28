package io.github.apurplerose.jamm.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import io.github.apurplerose.jamm.gui.handler.JammHandlers;

@Environment(EnvType.CLIENT)
public class JammScreens {

    public static void registerScreens(){
        ScreenRegistry.register(JammHandlers.ASTRAL_ALTAR, AstralAltarScreen::new);
    }
}
