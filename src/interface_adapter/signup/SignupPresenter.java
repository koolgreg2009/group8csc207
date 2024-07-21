package interface_adapter.signup;

import interface_adapter.*;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
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

//    /** The view model for the signup view. */
//    private final SignupViewModel signupViewModel;
//
//    /** The view model for the login view. */
//    private final LoginViewModel loginViewModel;
//
//    /** The model for managing views and switching between them. */
//    private ViewManagerModel viewManagerModel;
//
//    /**
//     * Constructs a new SignupPresenter with the given view models and view manager model.
//     *
//     * @param viewManagerModel
//     * @param signupViewModel
//     * @param loginViewModel
//     */
//    public SignupPresenter(ViewManagerModel viewManagerModel,
//                           SignupViewModel signupViewModel,
//                           LoginViewModel loginViewModel) {
//        this.viewManagerModel = viewManagerModel;
//        this.signupViewModel = signupViewModel;
//        this.loginViewModel = loginViewModel;
//    }
//
//    /**
//     * Prepares the view for a successful signup by updating the login view model
//     * and switching to the login view.
//     *
//     * @param response
//     */
//    @Override
//    public void prepareSuccessView(SignupOutputData response) {
//        // On success, switch to the login view.
//        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
//        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
//
//        SignupState signupState = signupViewModel.getState();
//        LoginState loginState = loginViewModel.getState();
//        loginState.setUsername(response.getUsername());
//        this.loginViewModel.setState(loginState);
//        loginViewModel.firePropertyChanged();
//        viewManagerModel.setActiveView(loginViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }
//
//    /**
//     * Prepares the view for a failed signup by updating the signup view model
//     * with the provided error message.
//     *
//     * @param error
//     */
//    @Override
//    public void prepareFailView(String error) {
//        SignupState signupState = signupViewModel.getState();
//        signupState.setUsernameError(error);
//        signupViewModel.firePropertyChanged();
//    }

    @Override
    public void prepareSuccessView(SignupOutputData response) {
        System.out.println(response.getUsername() + " has successfully been signed up.");
    }

    @Override
    public void prepareFailView(String error) {
        System.out.println(error);
    }

}
