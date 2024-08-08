package app;

import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_notifis.GetNotifController;
import interface_adapter.get_notifis.NotifViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import view.NotifView;

import static app.GetNotifControllerUseCase.creatUpdateNotifUseCase;

public class NotifViewUseCaseFactory {
    public NotifViewUseCaseFactory() {}

    public static NotifView create(LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel, NotifViewModel notifViewModel, UserDAOInterface userDAO) {
        GetNotifController getNotifController = creatUpdateNotifUseCase(notifViewModel, userDAO);
        return new NotifView(loggedInViewModel, viewManagerModel,notifViewModel);

    }
}
