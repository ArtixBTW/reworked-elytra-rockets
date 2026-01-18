package artixbtw.reworked_elytra_rockets.items;

import java.util.List;
import java.util.function.Consumer;

import artixbtw.reworked_elytra_rockets.CustomComponents;
import artixbtw.reworked_elytra_rockets.CustomComponents.UseCooldownTooltip;
import artixbtw.reworked_elytra_rockets.ReworkedElytraRockets;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Fireworks;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;

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
                    new Fireworks(FLIGHT_DURATION, List.of()))
            .component(
                    CustomComponents.USE_COOLDOWN_TOOLTIP,
                    new CustomComponents.UseCooldownTooltip(true));

    public BoostRocketItem() {
        this(DEFAULT_PROPERTIES);
    }

    public BoostRocketItem(Properties properties) {
        super(properties);
    }

    // Make sure you can't use these on blocks, that would be an expensive mistake
    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(
            ItemStack stack,
            TooltipContext context,
            TooltipDisplay displayComponent,
            Consumer<Component> textConsumer,
            TooltipFlag type) {
        super.appendHoverText(stack, context, displayComponent, textConsumer, type);

        UseCooldownTooltip cooldown = components().get(CustomComponents.USE_COOLDOWN_TOOLTIP);

        if (cooldown == null)
            return;

        cooldown.addToTooltip(context, textConsumer, type, components());
    }
}
