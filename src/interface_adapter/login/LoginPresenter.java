package interface_adapter.login;

import interface_adapter.SessionManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsState;
import interface_adapter.display_pets.DisplayPetsViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * Presenter for handling the presentation logic of login operations.
 * Implements {@link LoginOutputBoundary} to manage view updates and transitions based on the result of the login process.
 */
public class LoginPresenter implements LoginOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final LoginViewModel loginViewModel;
    private final DisplayPetsViewModel displayPetsViewModel;

    /**
     * Constructs a new {@code LoginPresenter} with the specified view models and session manager.
     *
     * @param viewManagerModel the {@code ViewManagerModel} used to manage view transitions.
     * @param displayPetsViewModel the {@code DisplayPetsViewModel} used to update pet display state.
     * @param loginViewModel the {@code LoginViewModel} used to update login state.
     */
    public LoginPresenter(ViewManagerModel viewManagerModel, DisplayPetsViewModel displayPetsViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.displayPetsViewModel = displayPetsViewModel;
        this.loginViewModel = loginViewModel;
    }

    /**
     * Prepares the view for a successful login.
     * Updates the display pets view model with the current user’s username and triggers property change notifications.
     *
     * @param data the {@code LoginOutputData} containing information about the logged-in user.
     */
    @Override
    public void prepareSuccessView(LoginOutputData data) {
        SessionManager.login(data.getUsername());
        DisplayPetsState state = displayPetsViewModel.getState();
        state.setUsername(SessionManager.getCurrentUser());
        displayPetsViewModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed login attempt.
     * Updates the login view model with an error message and triggers property change notifications.
     *
     * @param error the error message to display in case of a failed login.
     */
    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setError(error);
        loginViewModel.firePropertyChanged();
    }
}