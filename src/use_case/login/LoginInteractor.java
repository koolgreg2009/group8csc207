package use_case.login;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.user.User;

/**
 * The LoginInteractor class implements the LoginInputBoundary interface and handles the login process.
 * It validates the provided login data, checks if the user exists, and verifies the password.
 */
public class LoginInteractor implements LoginInputBoundary {
    final UserDAOInterface userDataAccessObject;
    final LoginOutputBoundary loginPresenter;
	final private PetDAOInterface petDAO;

    /**
     * Constructs a new LoginInteractor with the specified dependencies.
     *
     * @param userDataAccessInterface the data access object for user-related operations
     * @param petDAO the data access object for pet-related operations (may be used in future extensions)
     * @param loginOutputBoundary the boundary for handling the output of the login process
     */
    public LoginInteractor(UserDAOInterface userDataAccessInterface,
                           PetDAOInterface petDAO, LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
        this.petDAO = petDAO;
    }

    /**
     * Executes the login process with the provided input data.
     * This includes validating the login data, checking if the user exists, and verifying the password.
     *
     * @param loginInputData the data required to log in, including username and password
     */
    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView("The account '" + username+"' does not exist.");
        } else {
            User user = userDataAccessObject.get(username);
			String pwd = user.getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {
				LoginOutputData loginOutputData = new LoginOutputData(user.getUsername());
				loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}