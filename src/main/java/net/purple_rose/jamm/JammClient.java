package net.purple_rose.jamm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.purple_rose.jamm.screen.AstralAltarScreen;
import net.purple_rose.jamm.screen.ModScreenHandlers;

@Environment(EnvType.CLIENT)
public class JammClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.ASTRAL_ALTAR_SCREEN_HANDLER, AstralAltarScreen::new);
    }
}
