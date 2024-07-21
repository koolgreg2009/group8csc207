package use_case.login;

/**
 * The LoginOutputData class encapsulates the output data of the login process.
 * It includes fields for the username and a flag indicating if the login attempt failed.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginOutputData {

    private final String username;
    private boolean useCaseFailed;

    /**
     * Constructs a new LoginOutputData object with the specified details.
     *
     * @param username the username for the new login
     * @param useCaseFailed boolean to see if the login worked
     */
    public LoginOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Returns the username of the user who attempted to log in.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

}
