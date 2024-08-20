package use_case.bookmarks;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the {@link AddBookmarkInteractor} use case class.
 * This class verifies the correct behavior of the {@link AddBookmarkInteractor} class's execute method
 * for handling bookmark addition scenarios.
 */
class AddBookmarkInteractorTest {
    private UserDAOInterface userDAO;
    private AddBookmarkOutputBoundary presenter;
    private AddBookmarkInteractor interactor;

    /**
     * Sets up the test environment before each test method is executed.
     * Mocks dependencies for {@link AddBookmarkInteractor} and initializes the {@link AddBookmarkInteractor} instance.
     */
    @BeforeEach
    void setUp() {
        userDAO = Mockito.mock(UserDAOInterface.class);
        presenter = Mockito.mock(AddBookmarkOutputBoundary.class);
        interactor = new AddBookmarkInteractor(presenter, userDAO);
    }

    /**
     * Tests the {@link AddBookmarkInteractor#execute(BookmarkInputData)} method when the bookmark already exists.
     * Verifies that the presenter’s prepareErrorView method is called with the appropriate error message.
     */
    @Test
    void testExecuteBookmarkAlreadyExists() {
        when(userDAO.userHasBookmark("user1", 1)).thenReturn(true);

        BookmarkInputData inputData = new BookmarkInputData("user1", 1);
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareErrorView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Bookmark already exists", errorMessage);
    }

    /**
     * Tests the {@link AddBookmarkInteractor#execute(BookmarkInputData)} method for successfully adding a bookmark.
     * Verifies that the presenter’s prepareSuccessView method is called with the correct data, including
     * checking that the bookmark was added to the user's bookmarks.
     */
    @Test
    void testExecuteBookmarkAddedSuccessfully() {
        when(userDAO.userHasBookmark("user1", 1)).thenReturn(false);

        AdopterUser user = new AdopterUser("user1", "password", "User One", "email1@example.com", "123");
        when(userDAO.get("user1")).thenReturn(user);

        BookmarkInputData inputData = new BookmarkInputData("user1", 1);
        interactor.execute(inputData);

        ArgumentCaptor<BookmarkOutputData> argumentCaptor = ArgumentCaptor.forClass(BookmarkOutputData.class);
        verify(presenter).prepareSuccessView(argumentCaptor.capture());

        BookmarkOutputData outputData = argumentCaptor.getValue();
        assertEquals("user1", outputData.getUsername());
        assertTrue(outputData.getAllBookmarks().stream().anyMatch(bookmark -> bookmark.getPetID() == 1));
    }
}
