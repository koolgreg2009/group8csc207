package app;

import data_access.UserDAOInterface;
import interface_adapter.get_notifis.GetNotifController;
import interface_adapter.get_notifis.GetNotifPresenter;
import interface_adapter.get_notifis.NotifViewModel;
import use_case.get_notif.GetNotifInteractor;
import use_case.get_notif.GetNotifInputBoundary;
import use_case.get_notif.GetNotifOutputBoundary;

/**
 * Factory class responsible for creating instances related to the notification retrieval use case.
 */
public class GetNotifControllerUseCase {

    /**
     * Creates and returns an instance of {@link GetNotifController}.
     * Sets up the necessary dependencies including the interactor and presenter.
     *
     * @param notifViewModel the view model for notifications.
     * @param userDAO the data access object for user data.
     * @return an instance of {@link GetNotifController}.
     */
    public static GetNotifController creatUpdateNotifUseCase(NotifViewModel notifViewModel, UserDAOInterface userDAO) {
        GetNotifOutputBoundary getNotifPresenter = new GetNotifPresenter(notifViewModel);
        GetNotifInputBoundary getNotifInteractor = new GetNotifInteractor(userDAO, getNotifPresenter);
        return new GetNotifController(getNotifInteractor);
    }
}
