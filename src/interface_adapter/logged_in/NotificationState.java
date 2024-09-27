package interface_adapter.logged_in;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the state of notifications for a user.
 * Maintains a list of notification messages.
 */
public class NotificationState {
    private List<String> notifications = new ArrayList();

    /**
     * Constructs a new, empty {@code NotificationState} object.
     */
    public NotificationState() {}

    /**
     * Constructs a new {@code NotificationState} object by copying the state from another {@code NotificationState} instance.
     *
     * @param copy the {@code NotificationState} instance to copy from.
     */
    public NotificationState(NotificationState copy) {
        notifications = copy.notifications;
    }

    /**
     * Returns the list of notification messages.
     *
     * @return the list of notifications as a {@code List<String>}.
     */
    public List<String> getNotif() {
        return notifications;
    }

    /**
     * Sets the list of notification messages.
     *
     * @param notif the list of notifications to set.
     */
    public void setNotif(List<String> notif) {
        this.notifications = notif;
    }
}
