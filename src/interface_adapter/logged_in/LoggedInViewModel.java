package interface_adapter.logged_in;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The LoggedInViewModel class represents the view model for the logged-in state of the application.
 * It holds the state of the currently logged-in user and manages changes to this state.
 * This class also provides methods for handling property change events.
 *
 */
public class LoggedInViewModel extends ViewModel {
    public final String TITLE_LABEL = "Logged In View";
    private NotificationState notifState = new NotificationState();
    private LoggedInState state = new LoggedInState();
    public final String PREFERENCE_BUTTON_LABEL = "My Preferences";
    public final String BOOKMARK_BUTTON_LABEL = "My Bookmarks";
    public final String LOGOUT_BUTTON_LABEL = "Log out";
    public String NOTIF_BUTTON= "Notifications";

    /**
     * Constructs a new LoggedInViewModel with a predefined view name.
     */
    public LoggedInViewModel() {
        super("logged in");
    }

    /** Support for firing property change events. */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Fires a property change event to notify listeners of a change in the state.
     */
    @Override
	public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Fires a property change event to notify listeners about changes to the notification state.
     * This method triggers a property change event with the property name "notification".
     */
    public void fireNotificationChanged() {
        support.firePropertyChange("notification", null,
                this.state);
    }

    /**
     * Adds a listener for property change events.
     *
     * @param listener
     */
    @Override
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
        return state.getUsername();
    }

    /**
     * Setter for notification popup in state
     *
     * @param message msg to user to be displayed
     * @param isSuccess whether if user action was successful
     */
    public void setNotification(String message, boolean isSuccess) {
        this.state.setNotificationMessage(message);
        this.state.setNotificationSuccess(isSuccess);
        fireNotificationChanged();
    }



}