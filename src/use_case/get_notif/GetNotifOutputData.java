package use_case.get_notif;

import java.util.List;

/**
 * Represents the output data containing notifications for the user.
 * <p>
 * This class is used to encapsulate the list of notifications that will be presented to the user.
 * </p>
 */
public class GetNotifOutputData {
    private final List<String> notifs;

    /**
     * Constructs a new instance of GetNotifOutputData with the specified list of notifications.
     *
     * @param notifs the list of notifications to be encapsulated in this output data
     */
    public GetNotifOutputData(List<String> notifs) {
        this.notifs = notifs;
    }

    /**
     * Gets the list of notifications.
     *
     * @return the list of notifications
     */
    public List<String> getNotif(){
        return notifs;
        }
    }

