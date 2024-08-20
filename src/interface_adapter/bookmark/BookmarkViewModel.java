package interface_adapter.bookmark;

import dto.BookmarkDTO;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * ViewModel for managing bookmarks.
 */
public class BookmarkViewModel extends ViewModel {
    public final String PREF_BUTTON_LABEL = "My Preferences";
    public final String HOME_BUTTON_LABEL = "Home Page";
    public final String LOGOUT_BUTTON_LABEL = "Logout";
    public final String NOTIF_BUTTON_LABEL = "Notifications";

    private BookmarkState bookmarkState = new BookmarkState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructor for BookmarkViewModel.
     */
    public BookmarkViewModel() {
        super("bookmark");
    }

    /**
     * Retrieves the current state of bookmarks.
     *
     * @return the current BookmarkState instance
     */
    public BookmarkState getBookmarkState(){
        return bookmarkState;
    }

    /**
     * Notifies listeners of state changes.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("bookmark",
                null, this.bookmarkState);
    }

    /**
     * Notifies listeners that the notification state has changed.
     */
    public void fireNotificationChanged() {
        support.firePropertyChange("notification",
                null, this.bookmarkState);
    }

    /**
     * Adds a PropertyChangeListener.
     *
     * @param listener the PropertyChangeListener to add
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Retrieves all bookmarked pets.
     *
     * @return a list of all bookmarked pets
     */
    public List<BookmarkDTO> getAllBookmarks(){
        return bookmarkState.getAllBookmarks();
    }

    /**
     * Gets the username of the logged-in user.
     *
     * @return the username of the logged-in user
     */
    public String getLoggedInUser(){
        return bookmarkState.getUsername();
    }

    /**
     * Sets the notification message and success status, then notifies listeners of the change.
     *
     * @param message the notification message
     * @param isSuccess the success status of the notification
     */
    public void setNotification(String message, boolean isSuccess) {
        this.bookmarkState.setNotifMessage(message);
        this.bookmarkState.setNotifSuccess(isSuccess);
        fireNotificationChanged();
    }
}
