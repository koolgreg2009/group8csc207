package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the signup process, this handles communication between view and presenter including the state of the
 * signup process
 *
 * @version 1.0
 * @since 2024-07-20
 */
public class SignupViewModel extends ViewModel {

    public final String TITLE_LABEL = "Signup View";
    public final String USERNAME_LABEL = "Choose username";
    public final String PASSWORD_LABEL = "Choose password";
    public final String REPEAT_PASSWORD_LABEL = "Enter password again";

    public final String SIGNUP_BUTTON_LABEL = "Sign up";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private SignupState state = new SignupState();

    /**
     * Constructor for the Signup View Model with a default title "sign up".
     */
    public SignupViewModel() {
        super("sign up");
    }

    /**
     * Sets the state of the signup process.
     *
     * @param state the state that the signup process is being set to
     */
    public void setState(SignupState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View

    /**
     * Lets the listeners know that there has been a change in the state property.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a listener for any property changes.
     *
     * @param listener the listener being added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the signup process.
     *
     * @return the state that the signup process is in
     */
    public SignupState getState() {
        return state;
    }
}
