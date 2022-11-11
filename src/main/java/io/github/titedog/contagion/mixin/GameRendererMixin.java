package io.github.titedog.contagion.mixin;

import io.github.titedog.contagion.registry.SpectatorShaders;
import net.minecraft.client.gl.ShaderEffect;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Shadow @Nullable private ShaderEffect shader;

    @Shadow protected abstract void loadShader(Identifier id);

    /**
     * @author titedog
     * @reason Reconstruct method for custom shader support.
     */
    @Inject(method = "onCameraEntitySet", at = @At("HEAD"), cancellable = true)
    private void corpus$loadCustomSpectatorShaders(Entity entity, CallbackInfo ci) {
        ci.cancel();

        if(shader != null) {
            shader.close();
            shader = null;
        }

        if(entity != null && SpectatorShaders.hasShaders(entity.getType())) {
            for(Identifier s: SpectatorShaders.getShaders(entity.getType())) {
                loadShader(s);
            }
        }
    }
}