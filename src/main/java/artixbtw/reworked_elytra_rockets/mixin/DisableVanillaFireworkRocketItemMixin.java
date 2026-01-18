package artixbtw.reworked_elytra_rockets.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import artixbtw.reworked_elytra_rockets.CustomTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FireworkRocketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@Mixin(FireworkRocketItem.class)
public class DisableVanillaFireworkRocketItemMixin {
	@Inject(at = @At("HEAD"), method = "use", cancellable = true)
	public void use(
			Level level,
			Player player,
			InteractionHand hand,
			CallbackInfoReturnable<InteractionResult> cir) {
		ItemStack itemStack = player.getItemInHand(hand);

		if (player.isFallFlying() && !itemStack.is(CustomTags.ENABLED_FIREWORK_ROCKETS)) {
			cir.setReturnValue(InteractionResult.PASS);
		}
	}
}
