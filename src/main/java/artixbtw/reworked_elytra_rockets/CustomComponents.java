package artixbtw.reworked_elytra_rockets;

import java.util.function.Consumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;
import net.minecraft.world.item.component.UseCooldown;

public class CustomComponents {
    public static void initialize() {
    }

    public static final DataComponentType<UseCooldownTooltip> USE_COOLDOWN_TOOLTIP = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            ReworkedElytraRockets.identifierFromPath("use_cooldown_tooltip"),
            DataComponentType.<UseCooldownTooltip>builder()
                    .persistent(UseCooldownTooltip.CODEC)
                    .networkSynchronized(UseCooldownTooltip.STREAM_CODEC)
                    .build());

    public static record UseCooldownTooltip(boolean enabled) implements TooltipProvider {
        @Override
        public void addToTooltip(
                Item.TooltipContext context,
                Consumer<Component> tooltipAdder,
                TooltipFlag flag,
                DataComponentGetter componentGetter) {
            UseCooldown useCooldown = componentGetter.get(DataComponents.USE_COOLDOWN);

            if (useCooldown == null || !enabled) {
                System.out.println("AAAAAAAAAAAAAAAAAA");
                return;
            }

            Component component = Component.translatable(
                    "item.reworked-elytra-rockets.boost_rocket.cooldown_tooltip",
                    useCooldown.seconds())
                    .withStyle(ChatFormatting.GRAY);

            tooltipAdder.accept(component);
        }

        public static final Codec<UseCooldownTooltip> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                        Codec.BOOL.fieldOf("enabled").forGetter(UseCooldownTooltip::enabled))
                        .apply(builder, UseCooldownTooltip::new));

        public static final StreamCodec<ByteBuf, UseCooldownTooltip> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.BOOL, UseCooldownTooltip::enabled,
                UseCooldownTooltip::new);
    }
}
