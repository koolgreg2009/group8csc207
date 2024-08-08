package interface_adapter.logged_in;

import java.util.ArrayList;
import java.util.List;

public class NotificationState {
    private List<String> notifications = new ArrayList();
    public NotificationState() {}
    public NotificationState(NotificationState copy) {
        notifications = copy.notifications;
    }
    public List<String> getNotif() {
        return notifications;
    }
    public void setNotif(List<String> notif) {
        this.notifications = notif;
    }
}
