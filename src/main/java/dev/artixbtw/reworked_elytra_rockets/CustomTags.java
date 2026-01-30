package dev.artixbtw.reworked_elytra_rockets;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CustomTags {
    public static final TagKey<Item> ENABLED_FIREWORK_ROCKETS = TagKey.create(
            Registries.ITEM,
            ReworkedElytraRockets.identifierFromPath("enabled_firework_rockets"));

    public static void initialize() {
    }
}
