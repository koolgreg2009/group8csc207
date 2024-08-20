package use_case.signup;

/**
 * The {@code SignupInputBoundary} interface defines the input boundary for the signup use case.
 * <p>
 * It provides an abstract method for executing the signup process with the given input data.
 */
public interface SignupInputBoundary {

    /**
     * Executes the signup process using the provided {@code SignupInputData}.
     *
     * @param signupInputData the data required to perform the signup operation.
     */
    void execute(SignupInputData signupInputData);
}
