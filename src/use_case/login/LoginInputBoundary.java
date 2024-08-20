package use_case.login;

/**
 * Defines the contract for the input boundary of the login use case.
 * <p>
 * This interface provides a method to execute the login process using the provided input data.
 * Implementations of this interface handle the business logic required to log a user in.
 * </p>
 */
public interface LoginInputBoundary {

    /**
     * Executes the login process using the provided input data.
     *
     * @param loginInputData the input data required for the login process, including credentials
     */
    void execute(LoginInputData loginInputData);
}
