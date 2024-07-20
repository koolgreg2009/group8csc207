package use_case.login;

/**
 * The LoginOutputBoundary interface defines the methods for presenting the output of the Login use case.
 * It provides methods to handle successful and failed login attempts.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface LoginOutputBoundary {

    /**
     * Prepares the view for a successful login process.
     *
     * @param user
     */
    void prepareSuccessView(LoginOutputData user);

    /**
     * Prepares the view for a failed login process.
     *
     * @param error
     */
    void prepareFailView(String error);
}