package use_case.signup;

/**
 * The SignupOutputData class encapsulates the output data of the signup process.
 * It includes fields for username, creation time, and a flag indicating if the use case failed.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class SignupOutputData {

    private final String username;
    private String creationTime;
    private boolean useCaseFailed;

    /**
     * Constructs a new SignupOutputData object with the specified details.
     *
     * @param username
     * @param creationTime
     * @param useCaseFailed
     */
    public SignupOutputData(String username, String creationTime, boolean useCaseFailed) {
        this.username = username;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Returns the username of the user who signed up.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the time when the user account was created.
     *
     * @return The creation time.
     */
//    public String getCreationTime() {
//        return creationTime;
//    }
//
//    /**
//     * Sets the time when the user account was created.
//     *
//     * @param creationTime The new creation time.
//     */
//    public void setCreationTime(String creationTime) {
//        this.creationTime = creationTime;
//    }

}
