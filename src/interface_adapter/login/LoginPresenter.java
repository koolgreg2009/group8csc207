package interface_adapter.login;

import interface_adapter.SessionManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.login_success.DisplayPetsState;
import interface_adapter.login_success.DisplayPetsViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

/**
 * The LoginPresenter class implements the LoginOutputBoundary interface
 * to handle the presentation logic for login use cases. It updates the view models
 * based on the result of the login operation and manages view transitions.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginPresenter implements LoginOutputBoundary {

    /** The view manager model used to switch between views. */
    private final ViewManagerModel viewManagerModel;
    /** The view model for the login view. */
    private final LoginViewModel loginViewModel;

    /** The view model for the success logged-in view. */
    private final DisplayPetsViewModel displayPetsViewModel;


//    /**
//     * Constructs a LoginPresenter with the specified view models and view manager model.
//     *
//     * @param viewManagerModel
//     * @param displayPetsViewModel
//     * @param loginViewModel
//     */
    public LoginPresenter(ViewManagerModel viewManagerModel, DisplayPetsViewModel displayPetsViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.displayPetsViewModel = displayPetsViewModel;
        this.loginViewModel = loginViewModel;
    }
//
//    /**
//     * Prepares the success view when login is successful.
//     * Updates the logged-in state and switches to the logged-in view.
//     *
//     * @param response
//     */
//    @Override
//    public void prepareSuccessView(LoginOutputData response) {
//        // On success, switch to the logged in view.
//
//        LoggedInState loggedInState = loggedInViewModel.getState();
//        loggedInState.setUsername(response.getUsername());
//        this.loggedInViewModel.setState(loggedInState);
//        this.loggedInViewModel.firePropertyChanged();
//
//        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
//        this.viewManagerModel.firePropertyChanged();
//    }
//
//    /**
//     * Prepares the fail view when login fails.
//     * Updates the login view model with the error message.
//     *
//     * @param error
//     */
//    @Override
//    public void prepareFailView(String error) {
//        LoginState loginState = loginViewModel.getState();
//        loginState.setUsernameError(error);
//        loginViewModel.firePropertyChanged();
//    }
    @Override
    public void prepareSuccessView(LoginOutputData data) {
        SessionManager.login(data.getUsername());
        DisplayPetsState state = displayPetsViewModel.getState();
        state.setUsername(SessionManager.getCurrentUser());
        displayPetsViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // prepareing for error pop up
        LoginState loginState = loginViewModel.getState();
        loginState.setError(error);
        loginViewModel.firePropertyChanged();
    }
}