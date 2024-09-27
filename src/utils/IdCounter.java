package utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The {@code IdCounter} class provides a thread-safe mechanism for generating unique identifiers.
 * <p>
 * It uses an {@code AtomicLong} to ensure that each generated ID is unique and incremented in a thread-safe manner.
 */
public class IdCounter {
    private static final AtomicLong idCounter = new AtomicLong(0);

    /**
     * Returns the next unique identifier.
     * <p>
     * The ID is incremented atomically to ensure thread safety and uniqueness.
     *
     * @return the next unique identifier.
     */
    public static int getNextID() {
        return (int) idCounter.getAndIncrement();
    }
}
