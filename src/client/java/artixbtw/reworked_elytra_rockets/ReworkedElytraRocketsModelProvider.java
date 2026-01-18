package artixbtw.reworked_elytra_rockets;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ReworkedElytraRocketsModelProvider extends FabricModelProvider {
	public ReworkedElytraRocketsModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(CustomItems.BOOST_ROCKET, ModelTemplates.FLAT_ITEM);
	}

    @Override
    public String getName() {
        return ReworkedElytraRocketsModelProvider.class.getSimpleName();
    }
}
