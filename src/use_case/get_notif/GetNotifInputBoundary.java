package use_case.get_notif;

/**
 * Interface for the input boundary in the use case of retrieving notifications.
 *
 * <p>This interface defines the contract for interacting with the input data related to notifications. Implementations
 * will handle the logic required to process the request for retrieving notifications based on the provided input data.</p>
 */
public interface GetNotifInputBoundary {

    /**
     * Executes the process of retrieving notifications based on the provided input data.
     *
     * <p>This method takes the input data and performs the necessary operations to retrieve and manage notifications.</p>
     *
     * @param getNotifInputData the data required to retrieve notifications
     */
    void execute(GetNotifInputData getNotifInputData);
}
