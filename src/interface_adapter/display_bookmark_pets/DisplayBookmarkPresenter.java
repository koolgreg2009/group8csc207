package interface_adapter.display_bookmark_pets;

import interface_adapter.SessionManager;
import interface_adapter.logged_in.LoggedInState;
import use_case.display.DisplayPetsOutputBoundary;
import use_case.display.DisplayPetsOutputData;

public class DisplayBookmarkPresenter implements DisplayPetsOutputBoundary {

    //private final BookmarkViewModel bookmarkViewModel;


    @Override
    public void displayPetsOutput(DisplayPetsOutputData displayPetsOutputData) {
//        LoggedInState state = loggedInViewModel.getState();
//        state.setPets(displayPetsOutputData.getPets());
//        state.setUsername(SessionManager.getCurrentUser());
//        loggedInViewModel.firePropertyChanged();
        // do this but for bookmark state etc...
    }
}
