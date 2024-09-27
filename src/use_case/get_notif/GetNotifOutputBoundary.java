package use_case.get_notif;

/**
 * This interface defines the contract for presenting notifications.
 *
 * <p>Implementations of this interface will handle the logic required to present the output data
 * that contains notifications to the user.</p>
 */
public interface GetNotifOutputBoundary {

    /**
     * Updates the view with the notifications.
     *
     * @param getNotifOutputData the data containing the notifications to be presented
     */
    void updateNotif(GetNotifOutputData getNotifOutputData);
}
