package interface_adapter.signup;

/**
 * Represents the state of the signup process, which includes user input and any validation errors.
 *
 * @version 1.0
 * @since 2024-07-20
 */
public class SignupState {
    private String username = "";
    private String usernameError = null;
    private String password = "";
    private String passwordError = null;
    private String repeatPassword = "";
    private String repeatPasswordError = null;

    /**
     * Constructor for creating a new copy of SignupState based on an existing SignupState.
     *
     * @param copy SignupState to copy
     */
    public SignupState(SignupState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
        password = copy.password;
        passwordError = copy.passwordError;
        repeatPassword = copy.repeatPassword;
        repeatPasswordError = copy.repeatPasswordError;
    }

    /**
     * Constructor to create a default SignupState that is empty.
     */
    // Because of the previous copy constructor, the default constructor must be explicit.
    public SignupState() {}

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the username error message
     *
     * @return the username error if there is one
     */
    public String getUsernameError() {
        return usernameError;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the password error message.
     *
     * @return the password error if there is one
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * Gets the repeated password
     *
     * @return the repeated password
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Gets the repeat password error.
     *
     * @return the repeat password error if there is one
     */
    public String getRepeatPasswordError() {
        return repeatPasswordError;
    }

    /**
     * Sets the username.
     *
     * @param username the username being set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the username error message.
     *
     * @param usernameError the error and message being sent if there is a username error
     */
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    /**
     * Sets the password.
     *
     * @param password the password being set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the password error message.
     *
     * @param passwordError the error and message being sent if there is a password error
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * Sets the repeated password
     *
     * @param repeatPassword the repeated password being set
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    /**
     * Sets the repeated password error message.
     *
     * @param repeatPasswordError the error and message being sent if there is a repeat password error
     */
    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }
}
