package interface_adapter.signup;

import interface_adapter.*;
import interface_adapter.display_pets.DisplayPetsState;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.preference.PreferenceViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * The presenter for the signup process, responsible for updating the view models
 * based on the results from the signup use case. It handles success and failure
 * scenarios by interacting with the `SignupViewModel` and `DisplayPetsViewModel`,
 * and manages view transitions through the `ViewManagerModel`.
 */
public class SignupPresenter implements SignupOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PreferenceViewModel preferenceViewModel;
    private final SignupViewModel signupViewModel;
    private final DisplayPetsViewModel displayPetsViewModel;

    /**
     * Constructs a new SignupPresenter with the given view models and view manager model.
     *
     * @param viewManagerModel          The view manager model responsible for handling
     *                                  view transitions.
     * @param preferenceViewModel       The view model for managing user preferences.
     * @param signupViewModel           The view model for managing signup-related state.
     * @param displayPetsViewModel      The view model for displaying pet listings.
     */
    public SignupPresenter(ViewManagerModel viewManagerModel, PreferenceViewModel preferenceViewModel, SignupViewModel signupViewModel, DisplayPetsViewModel displayPetsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.preferenceViewModel = preferenceViewModel;
        this.signupViewModel = signupViewModel;
        this.displayPetsViewModel = displayPetsViewModel;
    }

    /**
     * Prepares the view for a successful signup by updating the login view model
     * with the current username and transitioning to the preferences view.
     *
     * @param response The output data from the signup use case containing user details.
     */
    @Override
    public void prepareSuccessView(SignupOutputData response) {
        SessionManager.getInstance().login(response.getUsername());
        DisplayPetsState state = displayPetsViewModel.getState();
        state.setUsername(SessionManager.getInstance().getCurrentUser());
        viewManagerModel.setActiveView(preferenceViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed signup by updating the signup view model
     * with the provided error message.
     *
     * @param error The error message to be displayed in the signup view.
     */
    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}
