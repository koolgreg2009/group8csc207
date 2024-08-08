package use_case.get_notif;

import java.util.ArrayList;
import java.util.List;

public class GetNotifOutputData {
    private final List<String> notifs;

    public GetNotifOutputData(List<String> notifs) {
        this.notifs = notifs;
    }

    public List<String> getNotif(){
        return notifs;
        }
    }

