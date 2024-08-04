package interface_adapter.preference;

import interface_adapter.PreferenceState;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PreferenceViewModel extends ViewModel {

    /** The label for the save button. */
    public final String SAVE_BUTTON_LABEL = "Save Preferences";

    public PreferenceViewModel() {
        super("preference");
    }


    /** The current state of the login view. */
    private PreferenceState state = new PreferenceState();


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
     * Adds a property change listener to be notified of changes in the login
     * state.
     *
     * @param listener listener for the property change
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the login view model.
     *
     * @return The current login state.
     */
    public PreferenceState getState() {
        return state;
    }
}

