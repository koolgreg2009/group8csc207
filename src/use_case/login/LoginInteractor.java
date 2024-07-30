package use_case.login;

import data_access.UserDAOInterface;
import entity.user.User;

/**
 * The LoginInteractor class implements the LoginInputBoundary interface and handles the login process.
 * It validates the login data, checks if the user exists, and verifies the password.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginInteractor implements LoginInputBoundary {
    final UserDAOInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    /**
     * Constructs a new LoginInteractor with the specified dependencies.
     *
     * @param userDataAccessInterface
     * @param loginOutputBoundary
     */
    public LoginInteractor(UserDAOInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    /**
     * Executes the login process with the given input data.
     * Validates the data, checks if the user exists, and verifies the password.
     *
     * @param loginInputData
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView("The account '" + username+"' does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getUsername());

                LoginOutputData loginOutputData = new LoginOutputData(user.getUsername());
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}