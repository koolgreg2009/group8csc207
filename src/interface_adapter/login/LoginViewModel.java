package interface_adapter.login;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for managing the state of the login view.
 * Handles the login form's state and property change notifications.
 * Provides labels for the login view and manages login-related state.
 */
public class LoginViewModel extends ViewModel {
    public final String TITLE_LABEL = "Log In View";
    public final String USERNAME_LABEL = "Enter username";
    public final String PASSWORD_LABEL = "Enter password";
    public final String LOGIN_BUTTON_LABEL = "Log in";
    public final String SIGNUP_BUTTON_LABEL = "Sign Up";
    private LoginState state = new LoginState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a new {@code LoginViewModel} with a default view name.
     */
    public LoginViewModel() {
        super("log in");
    }

    /**
     * Sets the state of the login view model.
     *
     * @param state the {@code LoginState} to set.
     */
    public void setState(LoginState state) {
        this.state = state;
    }

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
     * @param listener the {@code PropertyChangeListener} to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the login view model.
     *
     * @return the current {@code LoginState}.
     */
    public LoginState getState() {
        return state;
    }
}
