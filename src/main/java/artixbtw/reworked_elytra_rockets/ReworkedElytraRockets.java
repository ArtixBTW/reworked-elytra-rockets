package artixbtw.reworked_elytra_rockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class ReworkedElytraRockets implements ModInitializer {
	public static final String MOD_ID = "reworked-elytra-rockets";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier identifierFromPath(String path) {
		return Identifier.fromNamespaceAndPath(ReworkedElytraRockets.MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		CustomComponents.initialize();
		CustomItems.initialize();
		CustomTags.initialize();
	}
}
