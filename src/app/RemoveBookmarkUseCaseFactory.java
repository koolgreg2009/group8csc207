package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.AdoptController;
import interface_adapter.display_bookmark_pets.DisplayBookmarkController;
import interface_adapter.get_notifis.NotifViewModel;
import interface_adapter.bookmark.*;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.pet_bio.PetBioViewModel;
import interface_adapter.preference.PreferenceViewModel;
import use_case.bookmarks.*;
import view.BookmarkView;

import java.io.IOException;

/**
 * Factory class responsible for creating instances of use cases related to removing bookmarked pets.
 * This includes creating controllers for removing bookmarks, as well as setting up the {@link BookmarkView}.
 */
public class RemoveBookmarkUseCaseFactory {

    /**
     * Private constructor of {@link RemoveBookmarkUseCaseFactory} to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private RemoveBookmarkUseCaseFactory() {
    }

    /**
     * Creates and returns a {@link RemoveBookmarkController} instance.
     * This method sets up the necessary dependencies, including the data access object and presenter.
     *
     * @param userDAO the data access object for user data
     * @param bookmarkViewModel the view model for managing bookmark data
     * @param petDAO the data access object for pet data
     * @return an instance of {@link RemoveBookmarkController}, or {@code null} if an {@link IOException} occurs
     */
    public static RemoveBookmarkController removeBookmarkUseCase(UserDAOInterface userDAO,
                                                                 BookmarkViewModel bookmarkViewModel,
                                                                 PetDAOInterface petDAO){
        DisplayBookmarkController displayBookmarkController = DisplayBookmarkUseCaseFactory.displayBookmarkUseCase(
                bookmarkViewModel, userDAO, petDAO);
        RemoveBookmarkOutputBoundary bookmarkPresenter = new RemoveBookmarkPresenter(bookmarkViewModel,
                displayBookmarkController);
        BookmarkInputBoundary removeBookmarkInteractor = new RemoveBookmarkInteractor(userDAO, bookmarkPresenter,
                petDAO);
        return new RemoveBookmarkController(removeBookmarkInteractor);
    }

    /**
     * Creates and returns a {@link BookmarkView} instance.
     * This method sets up all necessary controllers and dependencies required by the {@link BookmarkView}.
     *
     * @param bookmarkViewModel the view model for managing bookmark data
     * @param loggedInViewModel the view model for managing logged-in user state
     * @param preferenceViewModel the view model for managing user preferences
     * @param loginViewModel the view model for managing login state
     * @param petBioViewModel the view model for managing pet bio data
     * @param viewManagerModel the view model for managing different views in the application
     * @param notifViewModel the view model for managing notification data
     * @param displayPetsViewModel the view model for managing the display of pets
     * @param userDAO the data access object for user data
     * @param petDAO the data access object for pet data
     * @return an instance of {@link BookmarkView}
     */
    public static BookmarkView create(BookmarkViewModel bookmarkViewModel,
                                      LoggedInViewModel loggedInViewModel,
                                      PreferenceViewModel preferenceViewModel,
                                      LoginViewModel loginViewModel,
                                      PetBioViewModel petBioViewModel,
                                      ViewManagerModel viewManagerModel,
                                      NotifViewModel notifViewModel,
                                      DisplayPetsViewModel displayPetsViewModel,
                                      UserDAOInterface userDAO,
                                      PetDAOInterface petDAO) {
        RemoveBookmarkController removeBookmarkController = removeBookmarkUseCase(userDAO, bookmarkViewModel, petDAO);
        AddBookmarkController addBookmarkController = AddBookmarkUseCaseFactory.createAddBookmarkUseCase(userDAO,
                loggedInViewModel);
        PetBioController petBioController = LoggedInUseCaseFactory.createPetBioUseCase(viewManagerModel,petBioViewModel,
                petDAO);
        AdoptController adoptController = AdoptUseCaseFactory.createAdoptUseCase(petDAO, userDAO,
                loggedInViewModel, displayPetsViewModel);
        return new BookmarkView(bookmarkViewModel, loggedInViewModel, preferenceViewModel, loginViewModel,
                viewManagerModel, notifViewModel, petBioController, adoptController, removeBookmarkController,
                addBookmarkController);
    }
}

