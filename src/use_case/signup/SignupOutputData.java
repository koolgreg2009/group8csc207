package use_case.signup;

/**
 * The {@code SignupOutputData} class encapsulates the output data of the signup process.
 * <p>
 * It includes fields for the username, creation time, and a flag indicating if the signup process failed.
 */
public class SignupOutputData {

    private final String username;
    private String creationTime;
    private boolean useCaseFailed;

    /**
     * Constructs a new {@code SignupOutputData} object with the specified details.
     *
     * @param username       the username of the user who signed up.
     * @param creationTime   the time when the signup was completed.
     * @param useCaseFailed  a flag indicating if the signup process failed (true) or succeeded (false).
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
}
