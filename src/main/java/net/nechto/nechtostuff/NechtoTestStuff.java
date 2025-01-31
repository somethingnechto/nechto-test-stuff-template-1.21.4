package net.nechto.nechtostuff;

import net.fabricmc.api.ModInitializer;

import net.nechto.nechtostuff.block.ModBlocks;
import net.nechto.nechtostuff.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NechtoTestStuff implements ModInitializer {
	public static final String MOD_ID = "nechtostuff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}