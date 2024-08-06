package interface_adapter.preference;

import interface_adapter.PreferenceState;
import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PreferenceViewModel extends ViewModel {

    /** The label for the login button. */
    public final String SAVE_BUTTON_LABEL = "Save Preferences";

    /** The current state of the login view. */
    private PreferenceState state = new PreferenceState();

    public PreferenceViewModel() {
        super("preference");
    }

    /**
     * Sets the state of the preference view model.
     *
     * @param state the state that is being set
     */
    public void setState(PreferenceState state) {
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
     * Adds a property change listener to be notified of changes in the preference
     * state.
     *
     * @param listener the listener for the preference property changes
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the preference view model.
     *
     * @return The current preference state.
     */
    public PreferenceState getState() {
        return state;
    }
}

