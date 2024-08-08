package interface_adapter.get_notifis;

import interface_adapter.logged_in.NotificationState;
import use_case.get_notif.GetNotifOutputBoundary;
import use_case.get_notif.GetNotifOutputData;

public class GetNotifPresenter implements GetNotifOutputBoundary {
    private final NotifViewModel notifViewModel;

    public GetNotifPresenter(NotifViewModel notifViewModel) {
        this.notifViewModel = notifViewModel;
    }

    @Override
    public void updateNotif(GetNotifOutputData updateNotifOutputData) {
        NotificationState notifState = notifViewModel.getState();
        notifState.setNotif(updateNotifOutputData.getNotif());
        notifViewModel.firePropertyChanged();
    }
}
