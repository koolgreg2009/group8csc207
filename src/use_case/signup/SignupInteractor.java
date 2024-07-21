package use_case.signup;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.AdopterUserFactory;
import entity.user.UserFactory;

import java.time.LocalDateTime;

/**
 * The SignupInteractor class implements the SignupInputBoundary interface and handles the signup process.
 * It validates the signup data, checks if the user already exists, and creates a new user if valid.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class SignupInteractor implements SignupInputBoundary {

    final UserDAOInterface userDataAccessObject;
    final SignupOutputBoundary userPresenter;
    final UserFactory adopterUserFactory;

    /**
     * Constructs a new SignupInteractor with the specified dependencies.
     *
     * @param userSignupDAInterface
     * @param signupOutputBoundary
     * @param adopterUserFactory
     */
    public SignupInteractor(UserDAOInterface userSignupDAInterface, SignupOutputBoundary signupOutputBoundary,  UserFactory adopterUserFactory) {
        this.userDataAccessObject = userSignupDAInterface;
        this.userPresenter = signupOutputBoundary;
        this.adopterUserFactory = adopterUserFactory;
    }

    /**
     * Executes the signup process with the given input data.
     * Validates the data and creates a new user if valid.
     *
     * @param signupInputData
     */
    @Override
    public void execute(SignupInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            LocalDateTime now = LocalDateTime.now();
            AdopterUser user = adopterUserFactory.create(signupInputData.getUsername(), signupInputData.getPassword(), signupInputData.getName(), signupInputData.getEmail(), signupInputData.getPhone());
            userDataAccessObject.save(user);

            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }

}