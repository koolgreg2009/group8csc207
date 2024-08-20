package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.display_pets.DisplayPetsState;
import interface_adapter.display_pets.DisplayPetsViewModel;

/**
 * The {@code DisplayPetsView} class represents a view component that listens for changes in the
 * {@code DisplayPetsViewModel} and interacts with the {@code DisplayPetsController}.
 * <p>
 * It extends {@code JPanel} and implements {@code PropertyChangeListener} to handle property change events
 * and trigger actions based on the updated state.
 */
public class DisplayPetsView extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
    public final String viewName = "login success";
	private DisplayPetsController displayPetsController;

	/**
	 * Constructs a {@code DisplayPetsView} with the specified view model and controller.
	 * <p>
	 * Registers this view as a listener to the {@code DisplayPetsViewModel}.
	 *
	 * @param displayPetsViewModel the view model to listen for property changes.
	 * @param displayPetsController the controller to execute actions based on state changes.
	 */
    public DisplayPetsView(DisplayPetsViewModel displayPetsViewModel,
						   DisplayPetsController displayPetsController) {
    	displayPetsViewModel.addPropertyChangeListener(this);
    	this.displayPetsController = displayPetsController;
	}

	/**
	 * Handles property change events from the {@code DisplayPetsViewModel}.
	 * <p>
	 * When a {@code DisplayPetsState} is received, it triggers the {@code DisplayPetsController}
	 * to execute an action using the updated state.
	 *
	 * @param evt the property change event containing the new value.
	 */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getNewValue() instanceof DisplayPetsState) {
			DisplayPetsState state = (DisplayPetsState) evt.getNewValue();
			this.displayPetsController.execute(state.getUsername());
		}
    }
}
