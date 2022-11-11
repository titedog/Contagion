package io.github.titedog.contagion;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Contagion implements ModInitializer {
	public static final String MOD_ID = "contagion";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("ContagionLib initialized.");
	}
}