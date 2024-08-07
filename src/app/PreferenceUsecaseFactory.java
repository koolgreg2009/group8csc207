package app;

import data_access.FileUserDAO;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.preference.PreferenceController;
import interface_adapter.preference.PreferencePresenter;
import interface_adapter.preference.PreferenceViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.preference.PreferenceInputBoundary;
import use_case.preference.PreferenceInteractor;
import use_case.preference.PreferenceOutputBoundary;
import view.LoginView;
import view.PreferenceView;

import java.io.IOException;

/**
 * Preference Usecase factory which takes all the data and returns a Preference controller
 */
public class PreferenceUsecaseFactory {

    /**
     * Constructor for Preference usecase factory which takes all the info the json path and gives a new preference
     * controller, and catches IO exceptions in case that occurs with the file reading.
     *
     * @return the new preference controller or null if IOException is caught
     */
    public static PreferenceController createPreferenceUseCase(ViewManagerModel viewManagerModel,
                                                               LoggedInViewModel loggedInViewModel, UserDAOInterface userDAO, DisplayPetsViewModel displayPetsViewModel) {

            PreferenceOutputBoundary preferencePresenter = new PreferencePresenter(viewManagerModel, loggedInViewModel, displayPetsViewModel);
            PreferenceInputBoundary preferenceInteractor = new PreferenceInteractor(userDAO, preferencePresenter);
            return new PreferenceController(preferenceInteractor);
    }

    public static PreferenceView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            PreferenceViewModel preferenceViewModel,
            UserDAOInterface userDAO,
            DisplayPetsViewModel displayPetsViewModel) {
        PreferenceController preferenceController = createPreferenceUseCase(viewManagerModel, loggedInViewModel, userDAO, displayPetsViewModel);
        return new PreferenceView(preferenceViewModel, preferenceController, viewManagerModel, loggedInViewModel);

    }


}
