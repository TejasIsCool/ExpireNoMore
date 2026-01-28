package com.tejasisamazing.expirenomore.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.server.players.CachedUserNameToIdResolver;
import net.minecraft.server.players.NameAndId;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Calendar;


// Found another method that independently updates the usercache value. So the fix is here
@Mixin(CachedUserNameToIdResolver.class)
public class CacheAddEditor {


    @Inject(method = "addInternal",
        at = @At(value = "INVOKE", target = "java/util/Calendar.add (II)V"))
    private void addInternal(NameAndId nameAndId, CallbackInfoReturnable<Object> cir, @Local Calendar calendar) {
        calendar.add(Calendar.YEAR, 100);
    }
}


