package interface_adapter.preference;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class PreferenceViewModel extends ViewModel {
    public PreferenceViewModel() {
        super("preference");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
