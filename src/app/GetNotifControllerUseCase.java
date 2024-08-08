package app;

import data_access.UserDAOInterface;
import interface_adapter.get_notifis.GetNotifController;
import interface_adapter.get_notifis.GetNotifPresenter;
import interface_adapter.get_notifis.NotifViewModel;
import use_case.get_notif.GetNotifInteractor;
import use_case.get_notif.GetNotifInputBoundary;
import use_case.get_notif.GetNotifOutputBoundary;

public class GetNotifControllerUseCase {
    public static GetNotifController creatUpdateNotifUseCase(NotifViewModel notifViewModel, UserDAOInterface userDAO) {
        GetNotifOutputBoundary getNotifPresenter = new GetNotifPresenter(notifViewModel);
        GetNotifInputBoundary getNotifInteractor = new GetNotifInteractor(userDAO, getNotifPresenter);
        return new GetNotifController(getNotifInteractor);
    }
}
