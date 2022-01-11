package io.github.apurplerose.jamm;

import io.github.apurplerose.jamm.item.JammItems;
import net.fabricmc.api.ModInitializer;
import io.github.apurplerose.jamm.block.JammBlocks;
import io.github.apurplerose.jamm.blockentity.JammBlockEntities;
import io.github.apurplerose.jamm.gui.handler.JammHandlers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Jamm implements ModInitializer {

	public static final String MOD_ID = "jamm";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		JammItems.registerItems();
		JammBlocks.registerBlocks();
		JammBlockEntities.registerBlockEntities();
		JammHandlers.registerHandlers();

		System.out.println("Hello Fabric world!");
	}
}