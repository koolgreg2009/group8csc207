package interface_adapter.pet_bio;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import interface_adapter.ViewModel;

/**
 * ViewModel for managing the state of the pet biography view.
 * Handles property change notifications and manages the state related to the pet's biography.
 */
public class PetBioViewModel extends ViewModel {
	private PetBioState state = new PetBioState();
	private final PropertyChangeSupport support = new PropertyChangeSupport(this);

	/**
	 * Constructs a new {@code PetBioViewModel} with the default view name "Pet Bio".
	 */
	public PetBioViewModel() {
		super("Pet Bio");
	}

	/**
	 * Fires a property change event for the state.
	 * Notifies listeners of changes in the pet bio state.
	 */
	@Override
	public void firePropertyChanged() {
		support.firePropertyChange("state", null, this.state);
	}

	/**
	 * Fires a property change event specifically for the notification.
	 * Notifies listeners of changes in the notification state.
	 */
	public void fireNotificationChanged() {
		support.firePropertyChange("notification", null, this.state);
	}

	/**
	 * Adds a property change listener to be notified of changes in the pet bio state.
	 *
	 * @param listener the {@code PropertyChangeListener} to add.
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		support.addPropertyChangeListener(listener);
	}

	/**
	 * Gets the current state of the pet biography view model.
	 *
	 * @return the {@code PetBioState} representing the current state.
	 */
	public PetBioState getState() {
		return state;
	}

}
