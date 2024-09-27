package interface_adapter.login;

/**
 * Represents the state of the login view model, including user credentials and any associated errors.
 * Encapsulates the data needed for managing the login state and handling user input validation.
 */
public class LoginState {
    private String username = "";
    private String password = "";
    private String error = "";

    /**
     * Constructs a new {@code LoginState} as a copy of the provided {@code LoginState}.
     *
     * @param copy the {@code LoginState} instance to copy from.
     */
    public LoginState(LoginState copy) {
        username = copy.username;
        password = copy.password;
        error = copy.error;
    }

    /**
     * Constructs a new {@code LoginState} with default values.
     */
    public LoginState() {} // Because of the previous copy constructor, the default constructor must be explicit.

    /**
     * Gets the username input by the user.
     *
     * @return the username as a {@code String}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password input by the user.
     *
     * @return the password as a {@code String}.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the username input by the user.
     *
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password input by the user.
     *
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the error message related to the login attempt.
     *
     * @return the error message as a {@code String}.
     */
    public String getError() {
        return error;
    }

    /**
     * Sets the error message related to the login attempt.
     *
     * @param error the error message to set.
     */
    public void setError(String error) {
        this.error = error;
    }
}
