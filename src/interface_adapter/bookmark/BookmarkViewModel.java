package interface_adapter.bookmark;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BookmarkViewModel extends ViewModel {
    public final String PREF_BUTTON_LABEL = "My Preferences";
    public final String HOME_BUTTON_LABEL = "Home Page";
    public final String LOGOUT_BUTTON_LABEL = "Logout";
    public final String NOTIF_BUTTON_LABEL = "Notifications";

    private BookmarkState state = new BookmarkState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public BookmarkViewModel() {
        super("bookmark");
    }

    public void setState(BookmarkState state){
        BookmarkState oldState = this.state;
        this.state = state;
        support.firePropertyChange("state", oldState, state);
    }
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public BookmarkState getState(){
        return state;
    }
}
