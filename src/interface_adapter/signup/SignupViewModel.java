package interface_adapter.signup;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for the signup process, handling communication between the view and presenter, including
 * managing the state of the signup process.
 */
public class SignupViewModel extends ViewModel {

    public final String TITLE_LABEL = "Signup View";
    public final String USERNAME_LABEL = "Choose username";
    public final String PASSWORD_LABEL = "Choose password";
    public final String REPEAT_PASSWORD_LABEL = "Enter password again";
    public final String NAME_LABEL = "Enter your name";
    public final String EMAIL_LABEL = "Enter your email (ex. johndoe@gmail.com)";
    public final String PHONE_LABEL = "Enter your phone number (ex. 1234567890)";

    public final String SIGNUP_BUTTON_LABEL = "Sign up";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private SignupState state = new SignupState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a new SignupViewModel with a default title "sign up".
     */
    public SignupViewModel() {
        super("sign up");
    }

    /**
     * Sets the state of the signup process.
     *
     * @param state the SignupState to set for the signup process
     */
    public void setState(SignupState state) {
        this.state = state;
    }

    /**
     * Notifies all registered listeners that the state property has changed.
     * This method is used to propagate changes in the signup state to any
     * listeners that are interested in the state changes.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to listen for changes in the state property.
     *
     * @param listener the PropertyChangeListener to be added
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves the current state of the signup process.
     *
     * @return the SignupState representing the current state of the signup process
     */
    public SignupState getState() {
        return state;
    }
}
