package com.Haritpane.springBoot_haritpane_backend.util;

import java.util.concurrent.ThreadLocalRandom;

public class OtpUtil {

    private OtpUtil() {
        // Prevent object creation
    }

    public static String generateOtp() {

        return String.valueOf(
                ThreadLocalRandom.current().nextInt(100000, 1000000)
        );
    }
}
