package test;

import org.junit.jupiter.api.Test;
import use_case.bookmarks.BookmarkInputData;

import static org.junit.jupiter.api.Assertions.*;

class BookmarkInputDataTest {

    private final BookmarkInputData testInput = new BookmarkInputData("test user", 145);

    @Test
    void getUsername() {
        assertEquals("test user", testInput.getUsername());
    }

    @Test
    void getPetID() {
        assertEquals(145, testInput.getPetID());
    }
}