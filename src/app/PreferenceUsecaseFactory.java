package app;

import data_access.APIInfoInterface;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.get_matching.GetMatchingController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.preference.PreferenceController;
import interface_adapter.preference.PreferencePresenter;
import interface_adapter.preference.PreferenceViewModel;
import use_case.preference.PreferenceInputBoundary;
import use_case.preference.PreferenceInteractor;
import use_case.preference.PreferenceOutputBoundary;
import view.PreferenceView;

import static app.DisplayPetsUseCaseFactory.createDisplayPetsUseCase;
import static app.GetMatchingStringUseCaseFactory.createMatchingUseCase;


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

    /**
     * Creates and returns a new preference view with specified viewManagerModel, loggedInViewModel, userDAO,
     * displayPetsViewModel.
     *
     * @param viewManagerModel the view Manager Model for our program.
     * @param loggedInViewModel the logged in view model that is connected to the preference view.
     * @param preferenceViewModel the preference vew model for the preference view being created
     * @param userDAO the data access object that accesses the user information
     * @param displayPetsViewModel the connector to update the pets via the display pets view model
     *
     * @return the new preference view object holding all of these parameters
     */
    public static PreferenceView create(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            PreferenceViewModel preferenceViewModel,
            UserDAOInterface userDAO,
            DisplayPetsViewModel displayPetsViewModel,
            PetDAOInterface petDAO,
            APIInfoInterface infoDAO){
        GetMatchingController matchingController = createMatchingUseCase(infoDAO, preferenceViewModel);
        PreferenceController preferenceController = createPreferenceUseCase(viewManagerModel, loggedInViewModel, userDAO, displayPetsViewModel);
        DisplayPetsController displayPetsController = createDisplayPetsUseCase(viewManagerModel, loggedInViewModel, userDAO, petDAO);
        return new PreferenceView(preferenceViewModel, preferenceController, matchingController, displayPetsController);

    }


}
