package interface_adapter;

import java.beans.PropertyChangeListener;

/**
 * ViewModel for the profile view, handling communication between the view and the presenter
 * related to the user profile.
 */
public class ProfileViewModel extends ViewModel{

    /**
     * Constructs a new ProfileViewModel with the default view name "profile".
     */
    public ProfileViewModel() {
        super("profile");
    }

    /**
     * Fires a property change event to notify listeners of changes in the profile state.
     * This method is overridden but does not currently implement any functionality.
     */
    @Override
    public void firePropertyChanged() {
    }

    /**
     * Adds a property change listener to be notified of changes in the profile state.
     * This method is overridden but does not currently implement any functionality.
     *
     * @param listener the listener to be added
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }
}
