package use_case.get_notif;

/**
 * Data transfer object for input data required to retrieve notifications.
 *
 * <p>This class encapsulates the information needed to fetch notifications for a specific user.</p>
 */
public class GetNotifInputData {
    private String username;

    /**
     * Constructs a GetNotifInputData with the specified username.
     *
     * @param username the username for which notifications are to be retrieved
     */
    public GetNotifInputData(String username) {
        this.username = username;
    }

    /**
     * Returns the username associated with this input data.
     *
     * @return the username
     */
    public String getUser() {
        return username;
    }
}
