package interface_adapter;

import java.beans.PropertyChangeListener;

public class ProfileViewModel extends ViewModel{
    public ProfileViewModel() {
        super("profile");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
