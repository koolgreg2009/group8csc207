package interface_adapter.signup;

import interface_adapter.*;
import interface_adapter.display_pets.DisplayPetsState;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.preference.PreferenceViewModel;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The presenter for the signup process, responsible for updating the view models
 * based on the results from the signup use case. It handles success and failure
 * scenarios by interacting with the `SignupViewModel` and `LoginViewModel`.
 *
 * @version 1.0
 * @since 2024-07-20
 */
public class SignupPresenter implements SignupOutputBoundary {



    /** The model for managing views and switching between them. */
    private final ViewManagerModel viewManagerModel;

    private final PreferenceViewModel preferenceViewModel;

    private final SignupViewModel signupViewModel;

    private final DisplayPetsViewModel displayPetsViewModel;
    /**
     * Constructs a new SignupPresenter with the given view models and view manager model.
     *
     * @param viewManagerModel
     * @param signupViewModel
     * @param preferenceViewModel
     */
    public SignupPresenter(ViewManagerModel viewManagerModel, PreferenceViewModel preferenceViewModel, SignupViewModel signupViewModel, DisplayPetsViewModel displayPetsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.preferenceViewModel = preferenceViewModel;
        this.signupViewModel = signupViewModel;
        this.displayPetsViewModel = displayPetsViewModel;
    }

    /**
     * Prepares the view for a successful signup by updating the login view model
     * and switching to the login view.
     *
     * @param response
     */
    @Override
    public void prepareSuccessView(SignupOutputData response) {
        SessionManager.login(response.getUsername());
        DisplayPetsState state = displayPetsViewModel.getState();
        state.setUsername(SessionManager.getCurrentUser());
        viewManagerModel.setActiveView(preferenceViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    /**
     * Prepares the view for a failed signup by updating the signup view model
     * with the provided error message.
     *
     * @param error
     */
    @Override
    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

}
