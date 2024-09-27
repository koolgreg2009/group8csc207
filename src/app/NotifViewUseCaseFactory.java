package app;

import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_notifis.GetNotifController;
import interface_adapter.get_notifis.GetNotifPresenter;
import interface_adapter.get_notifis.NotifViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.get_notif.GetNotifInputBoundary;
import use_case.get_notif.GetNotifInteractor;
import use_case.get_notif.GetNotifOutputBoundary;
import view.NotifView;

/**
 * The NotifViewUseCaseFactory class provides a factory method to create instances of {@link NotifView}.
 * This factory centralizes the creation logic for NotifView, ensuring that all necessary dependencies
 * are provided during instantiation.
 */
public class NotifViewUseCaseFactory {

    /**
     * Constructor for the NotifViewCaseFactory.
     */
    private NotifViewUseCaseFactory() {}

    /**
     * Creates a new instance of {@link NotifView}.
     *
     * @param loggedInViewModel the view model for managing logged-in user state
     * @param viewManagerModel the view model for managing the different views in the application
     * @param notifViewModel the view model for managing notification data
     * @return a new {@link NotifView} instance
     */
    public static NotifView createNotifView(LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel,
                                            NotifViewModel notifViewModel) {
        return new NotifView(loggedInViewModel, viewManagerModel, notifViewModel);
    }

    /**
     * Creates and returns an instance of {@link GetNotifController}.
     * Sets up the necessary dependencies including the interactor and presenter.
     *
     * @param notifViewModel the view model for notifications.
     * @param userDAO the data access object for user data.
     * @return an instance of {@link GetNotifController}.
     */
    public static GetNotifController createUpdateNotifUseCase(NotifViewModel notifViewModel, UserDAOInterface userDAO) {
        GetNotifOutputBoundary getNotifPresenter = new GetNotifPresenter(notifViewModel);
        GetNotifInputBoundary getNotifInteractor = new GetNotifInteractor(userDAO, getNotifPresenter);
        return new GetNotifController(getNotifInteractor);
    }
}
