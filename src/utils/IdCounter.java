package utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The IdCounter class provides a thread-safe mechanism for generating unique identifiers.
 * It uses an AtomicLong to ensure that each generated ID is unique and incremented in a thread-safe manner.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class IdCounter {

    /** The atomic counter for generating unique IDs. */
    private static final AtomicLong idCounter = new AtomicLong(0);

    /**
     * Returns the next unique identifier.
     * The ID is incremented atomically to ensure thread safety and uniqueness.
     *
     * @return The next unique identifier.
     */
    public static int getNextID() {
        return (int) idCounter.getAndIncrement();
    }
}
