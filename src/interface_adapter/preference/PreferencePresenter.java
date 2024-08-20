package interface_adapter.preference;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.preference.PreferenceOutputBoundary;

/**
 * The presenter for managing user preferences, handling the interaction between the preference use case
 * and the various view models. This class is responsible for preparing the view based on the outcome
 * of the preference use case execution and updating the UI components accordingly.
 */
public class PreferencePresenter implements PreferenceOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;
    private final DisplayPetsViewModel displayPetsViewModel;
    private final PreferenceViewModel preferenceViewModel;

    /**
     * Constructs a {@code PreferencePresenter} with the specified view models and view manager model.
     *
     * @param viewManagerModel       the view manager for handling view transitions.
     * @param loggedInViewModel      the view model representing the logged-in user.
     * @param displayPetsViewModel   the view model responsible for displaying pet listings.
     * @param preferenceViewModel    the view model for managing and displaying user preferences.
     */
    public PreferencePresenter(ViewManagerModel viewManagerModel,
                               LoggedInViewModel loggedInViewModel,
                               DisplayPetsViewModel displayPetsViewModel,
                               PreferenceViewModel preferenceViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.displayPetsViewModel = displayPetsViewModel;
        this.preferenceViewModel = preferenceViewModel;
    }

    /**
     * Prepares the view to show the success state of the preference update.
     */
    @Override
    public void prepareSuccessView() {
        preferenceViewModel.getState().clearError();
        preferenceViewModel.firePropertyChanged("error");
        displayPetsViewModel.firePropertyChanged();
    }

    /**
     * Prepares the view to show an error state for an invalid breed.
     */
    @Override
    public void prepareBreedFail(){
        PreferenceState state = preferenceViewModel.getState();
        state.setBreedError("Invalid Breed");
        preferenceViewModel.firePropertyChanged("error");
    }

    /**
     * Prepares the view to show an error state for an invalid location.
     */
    @Override
    public void prepareLocationFail(){
        PreferenceState state = preferenceViewModel.getState();
        state.setLocationError("Invalid Location");
        preferenceViewModel.firePropertyChanged("error");
    }
}

