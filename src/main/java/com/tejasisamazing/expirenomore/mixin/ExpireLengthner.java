package com.tejasisamazing.expirenomore.mixin;

import com.mojang.authlib.GameProfile;
import com.tejasisamazing.expirenomore.ExpireNoMore;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

// Works by overriding the getExpirationDate method in the UserCache.Entry
// And then instead of returning the current expiration date, it returns a date a long time after
// (Specifically it adds 100 years)
@Mixin(targets = "net.minecraft.util.UserCache$Entry")
abstract class ExpireLengthner{
    @Shadow @Final
    private GameProfile profile;
    @Shadow @Final
    Date expirationDate;

    @Inject(method = "getExpirationDate()Ljava/util/Date;", at = @At("HEAD"), cancellable = true)
    private void getFutureExpirationDate(CallbackInfoReturnable<Date> returner) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);


        Calendar current_cal = Calendar.getInstance();
        current_cal.setTime(new Date());

        // Making it so that i dont update it when the year difference is more than 50 years.
        long year_diff = calendar.get(Calendar.YEAR) - current_cal.get(Calendar.YEAR);
        if (!(year_diff >= 50)) {

            System.out.println(year_diff);

            calendar.add(Calendar.YEAR, 100);
            Date new_date = calendar.getTime();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z", Locale.ROOT);

            ExpireNoMore.LOGGER.info(
                    "Changed usercache expire time of {"
                            + "\"name\": \"" + profile.getName() + "\", \"id\": " + profile.getId() + "}"
                            + " from ("
                            + dateFormat.format(expirationDate)
                            + ") to ("
                            + dateFormat.format(new_date)
                            + ")"
            );
            returner.setReturnValue(new_date);
        } else {
            Date new_date = calendar.getTime();
            returner.setReturnValue(new_date);
        }
    }
}