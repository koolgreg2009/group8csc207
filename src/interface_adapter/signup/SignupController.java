package interface_adapter.signup;

import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

/**
 * The controller for the signup process, managing user input and interacting
 * with the signup use case. This class handles user input related to the signup
 * process and passes it to the use case interactor for processing.
 */
public class SignupController {
    final SignupInputBoundary userSignupUseCaseInteractor;

    /**
     * Constructs a new SignupController with the given use case interactor.
     *
     * @param userSignupUseCaseInteractor The interactor responsible for executing
     *                                    the signup use case.
     */
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the signup process with the provided user details. This method creates
     * a SignupInputData object with the provided details and passes it to the use case
     * interactor to handle the signup process.
     *
     * @param username  The username chosen by the user for signup.
     * @param password1 The first password entered by the user.
     * @param password2 The second password entered by the user for confirmation.
     * @param name      The name of the user.
     * @param email     The email address of the user.
     * @param phone     The phone number of the user.
     */
    public void execute(String username, String password1, String password2, String name, String email, String phone) {
        SignupInputData signupInputData = new SignupInputData(
                username, password1, password2, name, email, phone);

        userSignupUseCaseInteractor.execute(signupInputData);
    }
}
