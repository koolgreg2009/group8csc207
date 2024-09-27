package interface_adapter.get_notifis;

import use_case.get_notif.GetNotifInputBoundary;
import use_case.get_notif.GetNotifInputData;

/**
 * Controller for handling requests to retrieve notifications for a given user.
 * Delegates the request to the {@link GetNotifInputBoundary} for processing.
 */
public class GetNotifController {
    private final GetNotifInputBoundary getNotifInteractor;

    /**
     * Constructs a new {@code GetNotifController} with the specified input boundary.
     *
     * @param getNotifInteractor the {@code GetNotifInputBoundary} used to process notification retrieval requests.
     */
    public GetNotifController(GetNotifInputBoundary getNotifInteractor) {
        this.getNotifInteractor = getNotifInteractor;
    }

    /**
     * Executes the request to retrieve notifications for a user.
     * Delegates the task to the {@code GetNotifInputBoundary} by providing the username as input data.
     *
     * @param username the username for which notifications are to be retrieved.
     */
    public void execute(String username){
        this.getNotifInteractor.execute(new GetNotifInputData(username));
    }
}
