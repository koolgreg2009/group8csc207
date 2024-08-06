package interface_adapter.login_success;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.List;

import interface_adapter.ViewModel;

public class DisplayPetsViewModel extends ViewModel {
    private DisplayPetsState state = new DisplayPetsState();
    public DisplayPetsViewModel() {
        super("login success");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
	public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
    	List<PropertyChangeListener> listeners = Arrays.asList(support.getPropertyChangeListeners());
		if (!listeners.contains(listener)) {
			support.addPropertyChangeListener(listener);
		}
    }
    
    public void resetPropertyChangeListener() {
    	PropertyChangeListener[] listeners = support.getPropertyChangeListeners();
    	for (PropertyChangeListener l: listeners) {
    		support.removePropertyChangeListener(l);
    	}
    }

    public DisplayPetsState getState() {
        return state;
    }

    public String getLoggedInUser() {
        return state.getUsername();
    }
}