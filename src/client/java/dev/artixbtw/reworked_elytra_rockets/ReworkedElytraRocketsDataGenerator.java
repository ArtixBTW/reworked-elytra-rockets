package dev.artixbtw.reworked_elytra_rockets;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;

public class ReworkedElytraRocketsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ReworkedElytraRocketsItemTagProvider::new);
		pack.addProvider(ReworkedElytraRocketsModelProvider::new);
		pack.addProvider(ReworkedElytraRocketsRecipeProvider::new);
	}
}
