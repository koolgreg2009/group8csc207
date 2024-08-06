package interface_adapter.login_success;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.login_success.DisplayPetsOutputBoundary;
import use_case.login_success.DisplayPetsOutputData;

public class DisplayPetsPresenter implements DisplayPetsOutputBoundary {

	private LoggedInViewModel loggedInViewModel;
	private ViewManagerModel viewManagerModel;

	public DisplayPetsPresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel) {
		this.viewManagerModel = viewManagerModel;
		this.loggedInViewModel = loggedInViewModel;
	}

	@Override
	public void prepareLoggedIn(DisplayPetsOutputData loggedInOutput) {
		loggedInViewModel.getState().setPets(loggedInOutput.getPets());
		loggedInViewModel.getState().setUsername(loggedInOutput.getUsername());
		loggedInViewModel.firePropertyChanged();
		viewManagerModel.setActiveView(loggedInViewModel.getViewName());
		viewManagerModel.firePropertyChanged();
	}
}
