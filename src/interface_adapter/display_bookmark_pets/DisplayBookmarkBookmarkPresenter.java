package interface_adapter.display_bookmark_pets;

import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputData;

public class DisplayBookmarkBookmarkPresenter implements DisplayBookmarkPetsOutputBoundary {

    //private final BookmarkViewModel bookmarkViewModel;


    @Override
    public void displayPetsOutput(DisplayBookmarkPetsOutputData displayBookmarkPetsOutputData) {
//        LoggedInState state = loggedInViewModel.getState();
//        state.setPets(displayBookmarkPetsOutputData.getPets());
//        state.setUsername(SessionManager.getCurrentUser());
//        loggedInViewModel.firePropertyChanged();
        // do this but for bookmark state etc...
    }
}
