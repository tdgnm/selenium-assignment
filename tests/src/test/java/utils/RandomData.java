package utils;

import java.util.Random;

public class RandomData {
    private static final Random random = new Random();

    public static String getUsername() {
        return "user_" + random.nextInt(1000);
    }

    public static String getPassword() {
        return "passwd_" + random.nextInt(1000);
    }
}
