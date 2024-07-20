package interface_adapter.login;

import use_case.login.LoginInputData;
import use_case.login.LoginInputBoundary;

/**
 * The LoginController class handles user login requests and interacts with the login use case.
 * It takes user input for login and delegates the processing to the login use case interactor.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginController {

    /** The interactor for processing login input data. */
    final LoginInputBoundary loginUseCaseInteractor;

    /**
     * Constructs a new LoginController with the specified login use case interactor.
     *
     * @param loginUseCaseInteractor
     */
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the login process with the provided username and password.
     * Creates a LoginInputData object with the provided credentials and invokes the login use case interactor.
     *
     * @param username
     * @param password
     */
    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }
}
