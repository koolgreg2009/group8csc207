package interface_adapter.get_notifis;

import interface_adapter.ViewModel;
import interface_adapter.logged_in.NotificationState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NotifViewModel extends ViewModel {
    private NotificationState state = new NotificationState();
    public final String BACK_BUTTON_LABEL = "Back";

    public NotifViewModel() {
        super("notification");
    }

    public void setState(NotificationState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public NotificationState getState() {
        return state;
    }
}