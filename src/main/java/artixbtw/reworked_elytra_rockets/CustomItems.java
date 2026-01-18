package artixbtw.reworked_elytra_rockets;

import java.util.function.Function;

import artixbtw.reworked_elytra_rockets.items.BoostRocketItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class CustomItems {
    public static final Item BOOST_ROCKET = register(BoostRocketItem.IDENTIFIER, BoostRocketItem::new, BoostRocketItem.DEFAULT_PROPERTIES);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(group -> group.addAfter(Items.ELYTRA, CustomItems.BOOST_ROCKET));
    }

    public static <GenericItem extends Item> GenericItem register(
            Identifier identifier,
            Function<Item.Properties, GenericItem> itemFactory,
            Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, identifier);

        // Create the item instance.
        GenericItem item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
