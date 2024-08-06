package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import interface_adapter.login_success.DisplayPetsController;
import interface_adapter.login_success.DisplayPetsState;
import interface_adapter.login_success.DisplayPetsViewModel;

public class DisplayPetsView extends JPanel implements PropertyChangeListener {
	private static final long serialVersionUID = 1L;
    public final String viewName = "login success";
	private DisplayPetsController displayPetsController;

    public DisplayPetsView(DisplayPetsViewModel displayPetsViewModel,
						   DisplayPetsController displayPetsController) {
    	displayPetsViewModel.addPropertyChangeListener(this);
    	this.displayPetsController = displayPetsController;
	}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getNewValue() instanceof DisplayPetsState) {
			DisplayPetsState state = (DisplayPetsState) evt.getNewValue();
			this.displayPetsController.execute(state.getUsername());
		}
    }
}
