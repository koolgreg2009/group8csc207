package app;

import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.AddBookmarkPresenter;
import use_case.bookmarks.*;
import java.io.IOException;

/**
 * Factory class responsible for creating instances of {@link AddBookmarkController}.
 */
public class AddBookmarkUseCaseFactory {

    /**
     * Private constructor of {@link AddBookmarkUseCaseFactory} to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private AddBookmarkUseCaseFactory() {
    }

    /**
     * Creates and returns an {@link AddBookmarkController} instance.
     * Sets up the necessary dependencies including the data access object and presenter.
     *
     * @return an instance of {@link AddBookmarkController}, or {@code null} if an {@link IOException} occurs.
     */
    public static AddBookmarkController createAddBookmarkUseCase(UserDAOInterface userDAO) {
        AddBookmarkOutputBoundary bookmarkPresenter = new AddBookmarkPresenter();
        BookmarkInputBoundary addBookmarkInteractor = new AddBookmarkInteractor(bookmarkPresenter, userDAO);
        return new AddBookmarkController(addBookmarkInteractor);


    }

}