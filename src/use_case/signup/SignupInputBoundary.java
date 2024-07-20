package use_case.signup;

/** The SignupInputBoundary interface is the input boundary for the Signup use case.
 *  It provides an abstract method for executing the signup with the given input data.
 *
 * @version 1.0
 * @since 2024-07-19
 */

public interface SignupInputBoundary {

    /**
     * Executes the signup process using the provided signupInputData.
     *
     * @param signupInputData
     */
    void execute(SignupInputData signupInputData);
}
