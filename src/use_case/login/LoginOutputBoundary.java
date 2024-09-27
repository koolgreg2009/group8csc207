package use_case.login;

/**
 * The LoginOutputBoundary interface defines the methods for presenting the output of the login use case.
 * It provides methods to handle the result of a login attempt, including both successful and failed attempts.
 */
public interface LoginOutputBoundary {

    /**
     * Prepares the view for a successful login process.
     * This method is called when the login is successful and should be used to present the user's data.
     *
     * @param user the output data containing the information of the logged-in user
     */
    void prepareSuccessView(LoginOutputData user);

    /**
     * Prepares the view for a failed login process.
     * This method is called when the login attempt fails and should be used to present an error message.
     *
     * @param error the error message indicating the reason for the failed login attempt
     */
    void prepareFailView(String error);
}