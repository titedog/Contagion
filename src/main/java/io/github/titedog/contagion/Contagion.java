package io.github.titedog.contagion;

import io.github.titedog.contagion.example.ContagionExampleMod;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Contagion implements ModInitializer {
	public static final String MOD_ID = "contagion";
	public static final String VERSION_TAG = "0.0.1";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String entry) {
		return new Identifier(MOD_ID, entry);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("ContagionLib " + VERSION_TAG + " initialized.");

		if(ContagionExampleMod.shouldRegisterExampleMod()) {
			ContagionExampleMod.run();
		}
	}
}