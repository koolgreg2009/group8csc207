package utils;

import java.util.concurrent.atomic.AtomicLong;

public class IdCounter {
    private static final AtomicLong idCounter = new AtomicLong(0);

    public static long getNextID() {
        return idCounter.getAndIncrement();
    }
}
