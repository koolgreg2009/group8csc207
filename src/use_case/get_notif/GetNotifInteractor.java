package use_case.get_notif;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import java.util.List;

/**
 * Interactor responsible for retrieving notifications for a specific user.
 *
 * <p>This class handles the logic to fetch and present notifications associated with a user.</p>
 */
public class GetNotifInteractor implements GetNotifInputBoundary{
    final UserDAOInterface userDAO;
    final GetNotifOutputBoundary userPresenter;

    /**
     * Constructs a GetNotifInteractor with the specified user DAO and output boundary.
     *
     * @param userDAO the data access object for retrieving user data
     * @param userPresenter the output boundary to present the retrieved notifications
     */
    public GetNotifInteractor(UserDAOInterface userDAO, GetNotifOutputBoundary userPresenter) {
        this.userDAO = userDAO;
        this.userPresenter = userPresenter;
    }

    /**
     * Executes the retrieval of notifications based on the input data.
     *
     * @param getNotifInputData the data containing the username for which notifications are to be retrieved
     */
    public void execute(GetNotifInputData getNotifInputData){
        AdopterUser user = ((AdopterUser) userDAO.get(getNotifInputData.getUser()));
        List<String> listNotifs = user.getNotifications();

        GetNotifOutputData outputData = new GetNotifOutputData(listNotifs);
        userPresenter.updateNotif(outputData);
    }
}
