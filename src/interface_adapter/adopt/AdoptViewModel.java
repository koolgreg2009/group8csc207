package interface_adapter.adopt;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class AdoptViewModel extends ViewModel {
    public AdoptViewModel() {
        super("Notification");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
