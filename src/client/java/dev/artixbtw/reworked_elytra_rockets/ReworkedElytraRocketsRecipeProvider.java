package dev.artixbtw.reworked_elytra_rockets;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

public class ReworkedElytraRocketsRecipeProvider extends FabricRecipeProvider {
    public ReworkedElytraRocketsRecipeProvider(FabricDataOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                shapeless(RecipeCategory.TOOLS, CustomItems.BOOST_ROCKET, 2)
                        .requires(Items.PAPER)
                        .requires(Items.GUNPOWDER)
                        .requires(Items.GHAST_TEAR)
                        .unlockedBy(getHasName(Items.ELYTRA), has(Items.ELYTRA))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return ReworkedElytraRocketsRecipeProvider.class.getSimpleName();
    }
}
