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

    /**
     * Constructs a new LoginOutputData object with the specified details.
     *
     * @param username the username for the new login
     */
    public LoginOutputData(String username) {
        this.username = username;
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
