package interface_adapter.logged_in;

public class NotificationState {
    private String notifications = "";
    public NotificationState() {}
    public NotificationState(NotificationState copy) {
        notifications = copy.notifications;
    }
    public String getNotif() {
        return notifications;
    }
}
