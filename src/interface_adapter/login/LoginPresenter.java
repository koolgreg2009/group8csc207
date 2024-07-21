package interface_adapter.login;

import interface_adapter.SessionManager;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupState;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupOutputData;

/**
 * The LoginPresenter class implements the LoginOutputBoundary interface
 * to handle the presentation logic for login use cases. It updates the view models
 * based on the result of the login operation and manages view transitions.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginPresenter implements LoginOutputBoundary {

//    /** The view model for the login view. */
//    private final LoginViewModel loginViewModel;
//
//    /** The view model for the logged-in view. */
//    private final LoggedInViewModel loggedInViewModel;
//
//    /** The view manager model used to switch between views. */
//    private ViewManagerModel viewManagerModel;
//
//    /**
//     * Constructs a LoginPresenter with the specified view models and view manager model.
//     *
//     * @param viewManagerModel
//     * @param loggedInViewModel
//     * @param loginViewModel
//     */
//    public LoginPresenter(ViewManagerModel viewManagerModel,
//                          LoggedInViewModel loggedInViewModel,
//                          LoginViewModel loginViewModel) {
//        this.viewManagerModel = viewManagerModel;
//        this.loggedInViewModel = loggedInViewModel;
//        this.loginViewModel = loginViewModel;
//    }
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
        System.out.println(data.getUsername() + " has successfully been logged in.");
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println(error);
    }
}