package interface_adapter;

/**
 * Represents the state of the login process, encapsulating user input and any validation errors related to login.
 */
public class LoginState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;

    /**
     * Constructs a new LoginState by copying the values from another LoginState instance.
     *
     * @param copy the LoginState instance to copy values from
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
    public LoginState() {}

    /**
     * Gets the username for login.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the error message related to the username, if any.
     *
     * @return the username error message, or null if no error
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the password for login.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the error message related to the password, if any.
     *
     * @return the password error message, or null if no error
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Sets the username for login.
     *
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the error message related to the username.
     *
     * @param usernameError the username error message to set
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password for login.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the error message related to the password.
     *
     * @param passwordError the password error message to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }
}
