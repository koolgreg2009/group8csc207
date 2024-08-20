package interface_adapter.get_notifis;

import interface_adapter.ViewModel;
import interface_adapter.logged_in.NotificationState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel for managing and updating notification information in the user interface.
 * Extends {@link ViewModel} to handle state changes and property change notifications.
 */
public class NotifViewModel extends ViewModel {
    private NotificationState state = new NotificationState();
    public final String BACK_BUTTON_LABEL = "Back";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a new {@code NotifViewModel} with a default initialization message.
     */
    public NotifViewModel() {
        super("notification");
    }

    /**
     * Sets the notification state for this ViewModel.
     *
     * @param state the {@code NotificationState} to set.
     */
    public void setState(NotificationState state) {
        this.state = state;
    }

    /**
     * Fires a property change event to notify listeners about changes to the state.
     * This method triggers a property change event with the property name "state".
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to receive notifications about state changes.
     *
     * @param listener the {@code PropertyChangeListener} to add.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current notification state of this ViewModel.
     *
     * @return the {@code NotificationState} representing the current state.
     */
    public NotificationState getState() {
        return state;
    }
}