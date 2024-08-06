package use_case.signup;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.AdopterUserFactory;
import entity.user.UserFactory;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

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
        Pattern emailRegex = Pattern.compile("^[\\w.%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Pattern phoneRegex = Pattern.compile("^[0-9]{10,15}$");
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else if (!emailRegex.matcher(signupInputData.getEmail()).matches()){
            userPresenter.prepareFailView("Invalid email address.");
        } else if (!phoneRegex.matcher(signupInputData.getPhone()).matches()){
            userPresenter.prepareFailView("Invalid phone number.");
        } else {
            LocalDateTime now = LocalDateTime.now();
            AdopterUser user = adopterUserFactory.createAdopter(signupInputData.getUsername(), signupInputData.getPassword(), signupInputData.getName(), signupInputData.getEmail(), signupInputData.getPhone());
            userDataAccessObject.save(user);
            SignupOutputData signupOutputData = new SignupOutputData(user.getName(), now.toString(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }


    }

}