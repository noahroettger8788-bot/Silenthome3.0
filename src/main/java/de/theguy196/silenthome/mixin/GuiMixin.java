package de.theguy196.silenthome.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;

@Mixin(Gui.class)
public abstract class GuiMixin {
    @Inject(method = "setOverlayMessage", at = @At("HEAD"), cancellable = true)
    private void silentHome$hideHomeOverlay(Component message, boolean animate, CallbackInfo ci) {
        String text = message.getString().toLowerCase(Locale.ROOT);
        if (text.contains("home")) {
            ci.cancel();
        }
    }
}
