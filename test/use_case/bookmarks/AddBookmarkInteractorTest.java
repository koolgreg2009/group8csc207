package use_case.bookmarks;

import data_access.UserDAOInterface;
import entity.Bookmark;
import entity.user.AdopterUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AddBookmarkInteractorTest {
    private UserDAOInterface userDAO;
    private AddBookmarkOutputBoundary presenter;
    private AddBookmarkInteractor interactor;

    @BeforeEach
    void setUp() {
        userDAO = Mockito.mock(UserDAOInterface.class);
        presenter = Mockito.mock(AddBookmarkOutputBoundary.class);
        interactor = new AddBookmarkInteractor(presenter, userDAO);
    }

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
