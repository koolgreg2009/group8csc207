package interface_adapter.bookmark;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class BookmarkViewModel extends ViewModel {
    public BookmarkViewModel() {
        super("bookmark");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
