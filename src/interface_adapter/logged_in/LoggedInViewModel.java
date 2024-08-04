package interface_adapter.logged_in;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import interface_adapter.ViewModel;

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
    private NotificationState notState = new NotificationState();
    
    private LoggedInState state = new LoggedInState();

    /** Label for Profile button */
    public final String PROFILE_BUTTON_LABEL = "Profile";

    /** Label for Preference button */
    public final String PREFERENCE_BUTTON_LABEL = "My Preferences";

    /** Label for Bookmark button */
    public final String BOOKMARK_BUTTON_LABEL = "My Bookmarks";

    /** The label for the logout button. */
    public final String LOGOUT_BUTTON_LABEL = "Log out";

    /** The username of the currently logged-in user. */
    private String loggedInUser;

    public String NOTIF_BUTTON= "Notifications";

    /**
     * Constructs a new LoggedInViewModel with a predefined view name.
     */
    public LoggedInViewModel() {
        super("logged in");
    }

//    /**
//     * Sets the state of the logged-in user.
//     *
//     * @param state
//     */
//    public void setState(LoggedInState state) {
//        this.state = state;
//    }

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