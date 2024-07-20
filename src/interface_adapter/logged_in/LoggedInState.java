package interface_adapter.logged_in;

/**
 * The LoggedInState class represents the state of a logged-in user.
 * It maintains the username of the currently logged-in user and provides methods to access and modify this information.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoggedInState {
    private String username = "";

    /**
     * Constructs a new LoggedInState object by copying the state from another LoggedInState instance.
     *
     * @param copy
     */
    public LoggedInState(LoggedInState copy) {
        username = copy.username;
    }

    /**
     * Constructs a new, empty LoggedInState object.
     */
    public LoggedInState() {}

    /**
     * Returns the username of the currently logged-in user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the currently logged-in user.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
