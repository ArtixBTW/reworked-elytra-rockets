package artixbtw.reworked_elytra_rockets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.level.Level;

@Mixin(FireworkRocketItem.class)
public class DisableVanillaFireworkRocketItemMixin {
	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(
			Level level,
			Player player,
			InteractionHand interactionHand,
			CallbackInfoReturnable<InteractionResult> cir) {
		// If flying then early return PASS
		if (player.isFallFlying()) {
			cir.setReturnValue(InteractionResult.PASS);
		}
	}
}
