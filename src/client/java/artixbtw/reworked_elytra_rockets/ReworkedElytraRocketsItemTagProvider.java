package artixbtw.reworked_elytra_rockets;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

public class ReworkedElytraRocketsItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ReworkedElytraRocketsItemTagProvider(
			FabricDataOutput output,
			CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		valueLookupBuilder(CustomTags.ENABLED_FIREWORK_ROCKETS)
				.add(CustomItems.BOOST_ROCKET)
				.setReplace(true);
	}
}
