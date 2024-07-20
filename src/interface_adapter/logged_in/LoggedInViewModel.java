package interface_adapter.logged_in;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The LoggedInViewModel class represents the view model for the logged-in state of the application.
 * It holds the state of the currently logged-in user and manages changes to this state.
 * This class also provides methods for handling property change events.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoggedInViewModel extends ViewModel {

    /** The title label for the logged-in view. */
    public final String TITLE_LABEL = "Logged In View";

    /** The current state of the logged-in user. */
    private LoggedInState state = new LoggedInState();

    /** The label for the logout button. */
    public static final String LOGOUT_BUTTON_LABEL = "Log out";

    /** The username of the currently logged-in user. */
    private String loggedInUser;

    /**
     * Constructs a new LoggedInViewModel with a predefined view name.
     */
    public LoggedInViewModel() {
        super("logged in");
    }

    /**
     * Sets the state of the logged-in user.
     *
     * @param state
     */
    public void setState(LoggedInState state) {
        this.state = state;
    }

    /** Support for firing property change events. */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify listeners of a change in the state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a listener for property change events.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Returns the current state of the logged-in user.
     *
     * @return The current state.
     */
    public LoggedInState getState() {
        return state;
    }

    /**
     * Returns the username of the currently logged-in user.
     *
     * @return The username of the logged-in user.
     */
    public String getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Sets the username of the currently logged-in user.
     *
     * @param loggedInUser
     */
    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}