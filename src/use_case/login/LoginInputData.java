package use_case.login;

/**
 * The LoginInputData class encapsulates the data required for logging in a user.
 * It includes fields for username and password.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginInputData {

    final private String username;
    final private String password;

    /**
     * Constructs a new LoginInputData object with the specified username and password.
     *
     * @param username
     * @param password
     */
    public LoginInputData(String username, String password) {
        this.username = username.trim();
        this.password = password.trim();
    }

    /**
     * Returns the username of the user attempting to log in.
     *
     * @return The username.
     */
    String getUsername() {
        return username;
    }

    /**
     * Returns the password of the user attempting to log in.
     *
     * @return The password.
     */
    String getPassword() {
        return password;
    }

}
