package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ProfileViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.AdoptController;
import interface_adapter.adopt.NotifViewModel;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.bookmark.RemoveBookmarkController;
//import interface_adapter.display_all_pets.DisplayAllPetsController;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.pet_bio.PetBioPresenter;
import interface_adapter.pet_bio.PetBioViewModel;
import interface_adapter.preference.PreferenceViewModel;
import use_case.pet_bio.PetBioInputBoundary;
import use_case.pet_bio.PetBioInteractor;
import use_case.pet_bio.PetBioOutputBoundary;
import view.LoggedInView;

/**
 * The LoginUseCaseFactory class is responsible for creating instances of the components
 * required for the login use case, including the view, controller, and interactor.
 * It sets up the necessary dependencies and wiring for the login functionality.
 */
public class LoggedInUseCaseFactory {

    /**
     * Prevents instantiation of this utility class.
     */
    private LoggedInUseCaseFactory() {
    }

    /**
     * Creates a LoggedInView instance, setting up the login use case and its dependencies.
     * @param petBioViewModel
     *
     * @return A LoggedInView instance configured with the provided dependencies.
     */
    public static LoggedInView create(ViewManagerModel viewManagerModel,
                                      LoggedInViewModel loggedInViewModel,
                                      BookmarkViewModel bookmarkViewModel,
                                      PreferenceViewModel preferenceViewModel,
                                      LoginViewModel loginViewModel,
                                      ProfileViewModel profileViewModel, NotifViewModel notifViewModel,
                                      UserDAOInterface userDAO,
                                      PetDAOInterface petDAO,
                                      PetBioViewModel petBioViewModel,
                                      DisplayPetsViewModel displayPetsViewModel) {
        PetBioController petBioController = createPetBioUseCase(viewManagerModel, petBioViewModel, loggedInViewModel,
                petDAO);
        AdoptController adoptController = AdoptUseCaseFactory.createAdoptUseCase(petDAO, userDAO, loggedInViewModel, displayPetsViewModel);
        AddBookmarkController addBookmarkController = AddBookmarkUseCaseFactory.createAddBookmarkUseCase(userDAO, loggedInViewModel);
        RemoveBookmarkController removeBookmarkController = RemoveBookmarkUseCaseFactory.removeBookmarkUseCase(userDAO);
        return new LoggedInView(petBioController, loggedInViewModel, bookmarkViewModel,
                preferenceViewModel, loginViewModel, profileViewModel, notifViewModel, viewManagerModel,
                adoptController, addBookmarkController, removeBookmarkController);

    }
    /**
     * Creates a PetBioController instance and sets up the pet bio interactor and presenter.
     * @return A PetBioController instance configured with the provided dependencies.
     */

    private static PetBioController createPetBioUseCase(
            ViewManagerModel viewManagerModel,
            PetBioViewModel petBioViewModel,
            LoggedInViewModel loggedInViewModel,
            PetDAOInterface petDAO){

        PetBioOutputBoundary petBioOutputBoundary = new PetBioPresenter(viewManagerModel, petBioViewModel);


        PetBioInputBoundary petBioInteractor = new PetBioInteractor(petBioOutputBoundary, petDAO);

        return new PetBioController(petBioInteractor);
    }

}