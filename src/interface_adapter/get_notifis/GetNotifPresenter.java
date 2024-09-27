package interface_adapter.get_notifis;

import interface_adapter.logged_in.NotificationState;
import use_case.get_notif.GetNotifOutputBoundary;
import use_case.get_notif.GetNotifOutputData;

/**
 * Presenter for handling and presenting notification information.
 * Implements {@link GetNotifOutputBoundary} to process the output data from the use case layer and update the view model.
 */
public class GetNotifPresenter implements GetNotifOutputBoundary {
    private final NotifViewModel notifViewModel;

    /**
     * Constructs a new {@code GetNotifPresenter} with the specified view model.
     *
     * @param notifViewModel the {@code NotifViewModel} used to update the notification state and notify changes.
     */
    public GetNotifPresenter(NotifViewModel notifViewModel) {
        this.notifViewModel = notifViewModel;
    }

    /**
     * Updates the view with the notification information.
     * Sets the notifications in the view model state from {@code GetNotifOutputData} and triggers property change notifications.
     *
     * @param updateNotifOutputData the data containing the notification information to be displayed.
     */
    @Override
    public void updateNotif(GetNotifOutputData updateNotifOutputData) {
        NotificationState notifState = notifViewModel.getState();
        notifState.setNotif(updateNotifOutputData.getNotif());
        notifViewModel.firePropertyChanged();
    }
}
