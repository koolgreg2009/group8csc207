package interface_adapter.display_all_pets;

import interface_adapter.SessionManager;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.display.DisplayPetsOutputBoundary;
import use_case.display.DisplayPetsOutputData;

public class DisplayPetsPresenter implements DisplayPetsOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;
    public DisplayPetsPresenter(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
    }

    public void displayPetsOutput(DisplayPetsOutputData displayPetsOutputData) {
        LoggedInState state = loggedInViewModel.getState();
        state.setPets(displayPetsOutputData.getPets());
        state.setUsername(SessionManager.getCurrentUser());
        loggedInViewModel.firePropertyChanged();
    }
}
