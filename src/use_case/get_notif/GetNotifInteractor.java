package use_case.get_notif;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;

import java.util.List;

public class GetNotifInteractor implements GetNotifInputBoundary{
    final UserDAOInterface userDAO;
    final GetNotifOutputBoundary userPresenter;

    public GetNotifInteractor(UserDAOInterface userDAO, GetNotifOutputBoundary userPresenter) {
        this.userDAO = userDAO;
        this.userPresenter = userPresenter;
    }

    public void execute(GetNotifInputData getNotifInputData){
        AdopterUser user = ((AdopterUser) userDAO.get(getNotifInputData.getUser()));
        List<String> listNotifs = user.getNotifications();

        GetNotifOutputData outputData = new GetNotifOutputData(listNotifs);
        userPresenter.updateNotif(outputData);
    }
}
