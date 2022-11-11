package io.github.titedog.contagion.mixin;

import io.github.titedog.contagion.registry.StickyBlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonHandler.class)
public class PistonHandlerMixin {
    @Inject(method = "isBlockSticky", at = @At("HEAD"), cancellable = true)
    private static void contagion$isBlockSticky(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if(StickyBlockRegistry.STICKY_BLOCKS.contains(state.getBlock())) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "isAdjacentBlockStuck", at = @At("HEAD"), cancellable = true)
    private static void contagion$isAdjacentBlockStuck(BlockState state, BlockState adjacentState, CallbackInfoReturnable<Boolean> cir) {
        if(StickyBlockRegistry.STICKY_BLOCKS.contains(state.getBlock())
            && StickyBlockRegistry.STICKY_BLOCKS.contains(adjacentState.getBlock())
            && state.getBlock() != adjacentState.getBlock()) {
            cir.setReturnValue(false);
        } else {
            cir.setReturnValue(StickyBlockRegistry.STICKY_BLOCKS.contains(state.getBlock())
            || StickyBlockRegistry.STICKY_BLOCKS.contains(adjacentState.getBlock()));
        }
    }
}