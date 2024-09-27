package interface_adapter.display_pets;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.display_pets.DisplayPetsOutputBoundary;
import use_case.display_pets.DisplayPetsOutputData;

/**
 * The {@link DisplayPetsPresenter} class implements the {@link DisplayPetsOutputBoundary} interface to handle
 * the presentation logic for displaying pets. It updates the view models with the output data from the use case
 * and manages the view state.
 */
public class DisplayPetsPresenter implements DisplayPetsOutputBoundary {
	private LoggedInViewModel loggedInViewModel;
	private ViewManagerModel viewManagerModel;

	/**
	 * Constructs a {@link DisplayPetsPresenter} with the specified view models.
	 *
	 * @param viewManagerModel the model responsible for managing the active view
	 * @param loggedInViewModel the view model that holds the state of the logged-in user
	 */
	public DisplayPetsPresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel) {
		this.viewManagerModel = viewManagerModel;
		this.loggedInViewModel = loggedInViewModel;
	}

	/**
	 * Prepares the view for displaying pets based on the output data from the use case.
	 * Updates the {@link LoggedInViewModel} with the pet data and username, and sets the active view in the
	 * {@link ViewManagerModel}.
	 *
	 * @param loggedInOutput the output data containing the list of pets and the username
	 */
	@Override
	public void prepareLoggedIn(DisplayPetsOutputData loggedInOutput) {
		loggedInViewModel.getState().setPets(loggedInOutput.getPets());
		loggedInViewModel.getState().setUsername(loggedInOutput.getUsername());
		loggedInViewModel.firePropertyChanged();
		viewManagerModel.setActiveView(loggedInViewModel.getViewName());
		viewManagerModel.firePropertyChanged();
	}
}
