package io.github.titedog.contagion.mixin;

import io.github.titedog.contagion.util.MinecraftConstants;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
    private static final Text CONTAGION_VERSION = Text.of("contagion label test");

    private TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void contagion$render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        int w = textRenderer.getWidth(CONTAGION_VERSION);
        int x = width - w - 2;
        textRenderer.draw(matrices, CONTAGION_VERSION, x, height - 20, MinecraftConstants.textColor);
    }
}