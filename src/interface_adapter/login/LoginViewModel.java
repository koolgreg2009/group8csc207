package interface_adapter.login;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The ViewModel for the login view, managing the state of the login form and
 * handling property change notifications. This class provides the labels for
 * the login view and manages the login state.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class LoginViewModel extends ViewModel {

    /** The title label for the login view. */
    public final String TITLE_LABEL = "Log In View";

    /** The label for the username input field. */
    public final String USERNAME_LABEL = "Enter username";

    /** The label for the password input field. */
    public final String PASSWORD_LABEL = "Enter password";

    /** The label for the login button. */
    public final String LOGIN_BUTTON_LABEL = "Log in";

    /** The label for the cancel button. */
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    /** The current state of the login view. */
    private LoginState state = new LoginState();

    /**
     * Constructs a new LoginViewModel with a default view name.
     */
    public LoginViewModel() {
        super("log in");
    }

    /**
     * Sets the state of the login view model.
     *
     * @param state
     */
    public void setState(LoginState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify listeners of changes in the
     * login state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to be notified of changes in the login
     * state.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the login view model.
     *
     * @return The current login state.
     */
    public LoginState getState() {
        return state;
    }
}
