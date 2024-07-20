package use_case.signup;

/**
 * The SignupOutputBoundary interface defines the methods for presenting the output of the Signup use case.
 * It provides methods to handle successful and failed signup processes.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface SignupOutputBoundary {

    /**
     * Prepares the view for a successful signup process.
     *
     * @param user
     */
    void prepareSuccessView(SignupOutputData user);

    /**
     * Prepares the view for a failed signup process.
     *
     * @param error
     */

    void prepareFailView(String error);
}