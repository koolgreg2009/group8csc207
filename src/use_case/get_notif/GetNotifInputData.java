package use_case.get_notif;

import java.util.ArrayList;
import java.util.List;

public class GetNotifInputData {
    private String username;

    public GetNotifInputData(String username) {
        this.username = username;
    }

    public String getUser() {
        return username;
    }
}
