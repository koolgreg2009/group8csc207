package use_case.login;

/**
 * Encapsulates the data required for logging in a user.
 * <p>
 * This class holds the username and password for the login process. It ensures that the provided
 * data is properly encapsulated and can be used by the login use case.
 * </p>
 */
public class LoginInputData {
    final private String username;
    final private String password;

    /**
     * Constructs a new LoginInputData object with the specified username and password.
     *
     * @param username the username of the user attempting to log in
     * @param password the password of the user attempting to log in
     */
    public LoginInputData(String username, String password) {
        this.username = username.trim();
        this.password = password.trim();
    }

    /**
     * Returns the username of the user attempting to log in.
     *
     * @return the username
     */
    String getUsername() {
        return username;
    }

    /**
     * Returns the password of the user attempting to log in.
     *
     * @return the password
     */
    String getPassword() {
        return password;
    }

}
