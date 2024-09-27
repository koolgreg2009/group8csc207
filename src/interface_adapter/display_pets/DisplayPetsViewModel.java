package interface_adapter.display_pets;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;
import java.util.List;

import interface_adapter.ViewModel;

/**
 * ViewModel for managing the state and property changes in the display pets view.
 * Extends {@link ViewModel} to handle state changes and property change notifications.
 */
public class DisplayPetsViewModel extends ViewModel {
    private DisplayPetsState state = new DisplayPetsState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a new {@code DisplayPetsViewModel} with a default initialization message.
     */
    public DisplayPetsViewModel() {
        super("login success");
    }

    /**
     * Fires a property change event to notify listeners about changes to the state.
     * This method triggers a property change event with the property name "state".
     */
    @Override
	public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to receive notifications about state changes.
     *
     * @param listener the {@code PropertyChangeListener} to add.
     */
    @Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
    	List<PropertyChangeListener> listeners = Arrays.asList(support.getPropertyChangeListeners());
		if (!listeners.contains(listener)) {
			support.addPropertyChangeListener(listener);
		}
    }

    /**
     * Gets the current state of this ViewModel.
     *
     * @return the {@code DisplayPetsState} representing the current state.
     */
    public DisplayPetsState getState() {
        return state;
    }

}