package use_case.bookmarks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import data_access.UserDAOInterface;
import entity.Bookmark;
import entity.user.AdopterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Unit test class for RemoveBookmarkInteractor.
 * This class tests the functionality of the RemoveBookmarkInteractor using JUnit 5 and Mockito.
 */
public class RemoveBookmarkInteractorTest {

    private UserDAOInterface userDAO;
    private RemoveBookmarkOutputBoundary removeOutputBoundary;
    private RemoveBookmarkInteractor removeBookmarkInteractor;
    private AdopterUser user;
    private ArrayList<Bookmark> allBookmarks;
    private int petID;
    private LocalDateTime time;
    private String username;

    /**
     * Sets up the necessary objects before each test is run.
     * Initializes the mock objects and sets up the test data.
     */
    @BeforeEach
    public void setUp() {
        petID = 31;
        username = "Test User";
        time = LocalDateTime.of(2022,7,5,9,38);
        allBookmarks = new ArrayList<>();
        allBookmarks.add(new Bookmark(petID, time));

        userDAO = mock(UserDAOInterface.class);
        user = mock(AdopterUser.class);
        removeOutputBoundary = mock(RemoveBookmarkOutputBoundary.class);
        removeBookmarkInteractor = new RemoveBookmarkInteractor(userDAO, removeOutputBoundary);

        when(userDAO.get(username)).thenReturn(user);
        when(user.getBookmarks()).thenReturn(allBookmarks);
    }

    /**
     * Tests the success scenario of removing a bookmark.
     * Verifies that the bookmark is correctly removed from the user's list of bookmarks.
     */
    @Test
    public void testExecuteSuccessfullyRemovesBookmark() {
        removeBookmarkInteractor.execute(new BookmarkInputData(username, petID));

        verify(user).getBookmarks();
        verify(userDAO).save(user);
        verify(removeOutputBoundary).prepareSuccessView(any(BookmarkOutputData.class));
        assertTrue(allBookmarks.isEmpty(), "Bookmark list should be empty after removal");
    }
}
