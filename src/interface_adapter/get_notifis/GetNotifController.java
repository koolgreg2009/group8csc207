package interface_adapter.get_notifis;

import use_case.adopt.AdoptInputBoundary;
import use_case.adopt.AdoptInputData;
import use_case.get_notif.GetNotifInputBoundary;
import use_case.get_notif.GetNotifInputData;

public class GetNotifController {
    private final GetNotifInputBoundary getNotifInteractor;

    public GetNotifController(GetNotifInputBoundary getNotifInteractor) {
        this.getNotifInteractor = getNotifInteractor;
    }

    public void execute(String username){
        this.getNotifInteractor.execute(new GetNotifInputData(username));
    }
}
