package all.utils;

import java.util.UUID;
//@SuppressWarnings("all") 抑制警告

public class IdUtils {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", ".");
    }
}

