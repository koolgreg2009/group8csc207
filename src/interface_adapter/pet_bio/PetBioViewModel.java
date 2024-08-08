package interface_adapter.pet_bio;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import interface_adapter.ViewModel;

public class PetBioViewModel extends ViewModel {
	private PetBioState state = new PetBioState();

	public PetBioViewModel() {
		super("Pet Bio");
	}

	private final PropertyChangeSupport support = new PropertyChangeSupport(this);

	@Override
	public void firePropertyChanged() {
		support.firePropertyChange("state", null, this.state);
	}

	public void fireNotificationChanged() {
		support.firePropertyChange("notification", null, this.state);
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	public PetBioState getState() {
		return state;
	}

}
