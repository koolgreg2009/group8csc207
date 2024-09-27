package use_case.signup;

/**
 * The {@code SignupOutputBoundary} interface defines the methods for presenting the output of the Signup use case.
 * <p>
 * It provides methods to handle the outcome of the signup process, including both successful and failed scenarios.
 */
public interface SignupOutputBoundary {

    /**
     * Prepares the view for a successful signup process.
     *
     * @param user the data related to the successfully signed-up user.
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * Prepares the view for a failed signup process.
     *
     * @param error a message describing the error that occurred during signup.
     */
    void prepareFailView(String error);
}