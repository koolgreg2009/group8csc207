package use_case.login;

/**
 * The LoginInputBoundary interface defines the contract for the input boundary of the Login use case.
 * It provides a method for executing the login process with the given input data.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public interface LoginInputBoundary {

    /**
     * Executes the login process using the provided input data.
     *
     * @param loginInputData
     */
    void execute(LoginInputData loginInputData);
}
