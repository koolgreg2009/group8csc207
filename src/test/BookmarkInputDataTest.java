package test;

import org.junit.jupiter.api.Test;
import use_case.bookmarks.BookmarkInputData;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link BookmarkInputData} class.
 * <p>
 * This test class verifies the functionality of the {@link BookmarkInputData}
 * methods {@link BookmarkInputData#getUsername()} and {@link BookmarkInputData#getPetID()}.
 * </p>
 */
class BookmarkInputDataTest {

    private final BookmarkInputData testInput = new BookmarkInputData("test user", 145);

    /**
     * Tests the {@link BookmarkInputData#getUsername()} method.
     * <p>
     * Verifies that the username returned by {@code getUsername()} matches
     * the expected value "test user".
     * </p>
     */
    @Test
    void getUsername() {
        assertEquals("test user", testInput.getUsername());
    }

    /**
     * Tests the {@link BookmarkInputData#getPetID()} method.
     * <p>
     * Verifies that the pet ID returned by {@code getPetID()} matches
     * the expected value 145.
     * </p>
     */
    @Test
    void getPetID() {
        assertEquals(145, testInput.getPetID());
    }
}