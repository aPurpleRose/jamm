package net.purple_rose.jamm;

import net.fabricmc.api.ModInitializer;
import net.purple_rose.jamm.block.ModBlocks;
import net.purple_rose.jamm.blockentity.ModBlockEntities;
import net.purple_rose.jamm.gui.screen.JammScreens;
import net.purple_rose.jamm.item.ModItems;
import net.purple_rose.jamm.gui.handler.JammHandlers;
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

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		JammHandlers.registerHandlers();

		System.out.println("Hello Fabric world!");
	}
}
