package artixbtw.reworked_elytra_rockets.mixin;

import java.util.Set;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

@Mixin(FireworkRocketItem.class)
public class DisableVanillaFireworkRocketItemMixin {
	// TODO: either tag or config option
	private static final Set<Identifier> ROCKETS = Set.of(BuiltInRegistries.ITEM.getKey(Items.FIREWORK_ROCKET));

	// https://moddingtutorials.org/mixins/#using-this
	private final Item item = (Item) (Object) this; 

	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(
			Level level,
			Player player,
			InteractionHand interactionHand,
			CallbackInfoReturnable<InteractionResult> cir) {
		Identifier key = BuiltInRegistries.ITEM.getKey(item);

		if (player.isFallFlying() && ROCKETS.contains(key)) {
			cir.setReturnValue(InteractionResult.PASS);
		}
	}
}
