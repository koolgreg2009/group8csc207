package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.display_bookmark_pets.DisplayBookmarkController;
import interface_adapter.display_bookmark_pets.DisplayBookmarkPresenter;
import use_case.display_bookmark_pets.DisplayBookmarkInputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkInteractor;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputBoundary;


/**
 * Factory class responsible for creating instances of {@link DisplayBookmarkController}.
 */
public class DisplayBookmarkUseCaseFactory {

    /**
     * Private constructor of {@link DisplayBookmarkUseCaseFactory} to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private DisplayBookmarkUseCaseFactory() {
    }

    /**
     * Creates and returns a {@link DisplayBookmarkController} instance.
     * Sets up the necessary dependencies, including the data access objects and presenter.
     *
     * @param bookmarkViewModel the view model that holds the state of the bookmarks.
     * @param userDAO the data access object for user-related operations.
     * @param petDAO the data access object for pet-related operations.
     * @return an instance of {@link DisplayBookmarkController}.
     */
    public static DisplayBookmarkController displayBookmarkUseCase(BookmarkViewModel bookmarkViewModel,
                                                                    UserDAOInterface userDAO,
                                                                    PetDAOInterface petDAO) {

        DisplayBookmarkPetsOutputBoundary displayBookmarkPresenter = new DisplayBookmarkPresenter(bookmarkViewModel);
        DisplayBookmarkInputBoundary displayBookmarkInteractor = new DisplayBookmarkInteractor(userDAO, petDAO,
                displayBookmarkPresenter);

        return new DisplayBookmarkController(displayBookmarkInteractor);
    }
}
