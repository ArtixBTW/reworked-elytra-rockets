package artixbtw.reworked_elytra_rockets.items;

import java.util.List;

import artixbtw.reworked_elytra_rockets.ReworkedElytraRockets;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.component.Fireworks;

public class BoostRocketItem extends FireworkRocketItem {
    private static final int STACK_SIZE = 16;
    private static final int FLIGHT_DURATION = 3;
    private static final float USE_COOLDOWN_SECONDS = 25.0f;

    public static final Identifier IDENTIFIER = ReworkedElytraRockets.identifierFromPath("boost_rocket");

    public static final Properties DEFAULT_PROPERTIES = new Properties()
            .stacksTo(STACK_SIZE)
            .useCooldown(USE_COOLDOWN_SECONDS)
            .component(
                    DataComponents.FIREWORKS,
                    new Fireworks(FLIGHT_DURATION, List.of()));

    public BoostRocketItem() {
        this(DEFAULT_PROPERTIES);
    }

    public BoostRocketItem(Properties properties) {
        super(properties);
    }
}
