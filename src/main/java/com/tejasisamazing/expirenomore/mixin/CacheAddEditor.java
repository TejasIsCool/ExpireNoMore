package com.tejasisamazing.expirenomore.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.authlib.GameProfile;
import net.minecraft.util.UserCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Calendar;


// Found another method that independently updates the usercache value. So the fix is here
@Mixin(UserCache.class)
public class CacheAddEditor {

    @Inject(method = "add(Lcom/mojang/authlib/GameProfile;)V", at = @At(value = "INVOKE",target = "java/util/Calendar.add (II)V"))
    public void add(GameProfile profile, CallbackInfo ci, @Local Calendar calendar) {
        calendar.add(Calendar.YEAR,100);
    }
}
