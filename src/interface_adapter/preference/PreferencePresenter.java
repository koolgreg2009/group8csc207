package interface_adapter.preference;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.preference.PreferenceOutputBoundary;

public class PreferencePresenter implements PreferenceOutputBoundary {

    /**
     * The view manager model used to switch between views.
     */
    private final ViewManagerModel viewManagerModel;

    /**
     * The view model for the logged-in view.
     */
    private final LoggedInViewModel loggedInViewModel;
    private final DisplayPetsViewModel displayPetsViewModel;
    private final PreferenceViewModel preferenceViewModel;

    /**
     * The presenter for the preference use case.
     *
     * @param viewManagerModel the view Manager for our program to manage the change in views
     * @param loggedInViewModel the logged in view model that is previously and afterward displayed
     * @param displayPetsViewModel the Pets view model which is in charge of changing the pet listings after
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
     * Preperation for the preferences to be executed successfully
     */
    @Override
    public void prepareSuccessView() {
        preferenceViewModel.getState().clearError();
        preferenceViewModel.firePropertyChanged("error");
        displayPetsViewModel.firePropertyChanged();
    }

    @Override
    public void prepareBreedFail(){
        PreferenceState state = preferenceViewModel.getState();
        state.setBreedError("Invalid Breed");
        preferenceViewModel.firePropertyChanged("error");
    }
    @Override
    public void prepareLocationFail(){
        PreferenceState state = preferenceViewModel.getState();
        state.setLocationError("Invalid Location");
        preferenceViewModel.firePropertyChanged("error");


    }
}

