package interface_adapter.bookmark;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import view.ViewManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BookmarkViewModel extends ViewModel {
    public final String PREF_BUTTON_LABEL = "My Preferences";
    public final String HOME_BUTTON_LABEL = "Home Page";
    public final String LOGOUT_BUTTON_LABEL = "Logout";
    public final String NOTIF_BUTTON_LABEL = "Notifications";

    private BookmarkState bookmarkState = new BookmarkState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    private final ViewManagerModel viewManagerModel;

    public BookmarkViewModel(ViewManagerModel viewManagerModel) {
        super("bookmark");
        this.viewManagerModel = viewManagerModel;
    }

    public void setState(BookmarkState newState){
        this.bookmarkState = newState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.bookmarkState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public BookmarkState getState(){
        return bookmarkState;
    }

    // Want to provide methods that cater to the specific needs of the view. If the view is
    // to display pet gender, age, name, etc., have methods to reflect that.

    // Need methods to add/remove bookmark via accessing the state. return bookmarkState.getAllBookmarks();

    // In UI, use methods to get pet details (check with Kevin what info are we putting on).
}
