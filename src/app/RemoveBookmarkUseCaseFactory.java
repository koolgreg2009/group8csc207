package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.AdoptController;
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
    public static RemoveBookmarkController removeBookmarkUseCase(UserDAOInterface userDAO,
                                                                 BookmarkViewModel bookmarkViewModel){

        RemoveBookmarkOutputBoundary bookmarkPresenter = new RemoveBookmarkPresenter(bookmarkViewModel);
        BookmarkInputBoundary removeBookmarkInteractor = new RemoveBookmarkInteractor(userDAO, bookmarkPresenter);
        return new RemoveBookmarkController(removeBookmarkInteractor);
    }

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
        RemoveBookmarkController removeBookmarkController = removeBookmarkUseCase(userDAO, bookmarkViewModel);
        AddBookmarkController addBookmarkController = AddBookmarkUseCaseFactory.createAddBookmarkUseCase(userDAO,
                loggedInViewModel);
        PetBioController petBioController = LoggedInUseCaseFactory.createPetBioUseCase(viewManagerModel,petBioViewModel,
                petDAO);
        AdoptController adoptController = AdoptUseCaseFactory.createAdoptUseCase(petDAO, userDAO,
                loggedInViewModel, displayPetsViewModel);
        return new BookmarkView(bookmarkViewModel, loggedInViewModel, preferenceViewModel, loginViewModel,
                viewManagerModel, notifViewModel, petBioController, adoptController, removeBookmarkController, addBookmarkController);
    }
}

