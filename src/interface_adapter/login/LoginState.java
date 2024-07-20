package interface_adapter.login;

/**
 * Represents the state of the login view model, including user credentials
 * and any associated errors. This class encapsulates the data needed for
 * managing the login state and handling user input validation.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginState {

    /** The username input by the user. */
    private String username = "";

    /** Error message related to the username, if any. */
    private String usernameError = null;

    /** The password input by the user. */
    private String password = "";

    /** Error message related to the password, if any. */
    private String passwordError = null;

    /**
     * Constructs a new LoginState as a copy of the provided LoginState.
     *
     * @param copy
     */
    public LoginState(LoginState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
    }

    /**
     * Constructs a new LoginState with default values.
     */
    public LoginState() {} // Because of the previous copy constructor, the default constructor must be explicit.

    /**
     * Gets the username input by the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the error message related to the username.
     *
     * @return The username error message, or null if there is no error.
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the password input by the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the error message related to the password.
     *
     * @return The password error message, or null if there is no error.
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Sets the username input by the user.
     *
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the error message related to the username.
     *
     * @param usernameError
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password input by the user.
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the error message related to the password.
     *
     * @param passwordError
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}
