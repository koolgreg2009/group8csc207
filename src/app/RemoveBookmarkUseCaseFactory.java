package app;

import data_access.UserDAOInterface;
import data_access.FileUserDAO;
import interface_adapter.bookmark.RemoveBookmarkController;
import interface_adapter.bookmark.RemoveBookmarkPresenter;
import use_case.bookmarks.BookmarkInputBoundary;
import use_case.bookmarks.RemoveBookmarkInteractor;
import use_case.bookmarks.RemoveBookmarkOutputBoundary;
import java.io.IOException;

/**
 * Factory class responsible for creating instances of {@link RemoveBookmarkController}.
 */
public class RemoveBookmarkUseCaseFactory {

    /**
     * Private constructor of {@link RemoveBookmarkUseCaseFactory} to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private RemoveBookmarkUseCaseFactory() {
    }

    /**
     * Creates and returns an {@link RemoveBookmarkController} instance.
     * Sets up the necessary dependencies including the data access object and presenter.
     *
     * @return an instance of {@link RemoveBookmarkController}, or {@code null} if an {@link IOException} occurs.
     */
    public static RemoveBookmarkController removeBookmarkUseCase(UserDAOInterface userDAO){

        RemoveBookmarkOutputBoundary bookmarkPresenter = new RemoveBookmarkPresenter();
        BookmarkInputBoundary removeBookmarkInteractor = new RemoveBookmarkInteractor(userDAO, bookmarkPresenter);
        return new RemoveBookmarkController(removeBookmarkInteractor);

    }
}
