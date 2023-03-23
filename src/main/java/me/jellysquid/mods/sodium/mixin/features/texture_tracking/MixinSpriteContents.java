package me.jellysquid.mods.sodium.mixin.features.texture_tracking;

import me.jellysquid.mods.sodium.client.render.texture.SpriteContentsExtended;
import net.minecraft.client.texture.SpriteContents;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SpriteContents.class)
public abstract class MixinSpriteContents implements SpriteContentsExtended {
    @Shadow
    @Final
    @Nullable
    private SpriteContents.Animation animation;

    @Unique
    private boolean active;

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean hasAnimation() {
        return this.animation != null;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }
}
