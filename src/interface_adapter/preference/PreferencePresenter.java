package interface_adapter.preference;

import interface_adapter.SessionManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginState;
import use_case.login.LoginOutputData;
import use_case.preference.PreferenceOutputBoundary;
import use_case.preference.PreferenceOutputData;

public class PreferencePresenter implements PreferenceOutputBoundary {

    // need logged in view model (tell view manager what page to switch to) and view manager model (switch pages)
    /**
     * The view manager model used to switch between views.
     */
    private final ViewManagerModel viewManagerModel;

    /**
     * The view model for the logged-in view.
     */
    private final LoggedInViewModel loggedInViewModel;
    private final DisplayPetsViewModel displayPetsViewModel;

    public PreferencePresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, DisplayPetsViewModel displayPetsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.displayPetsViewModel = displayPetsViewModel;
    }

    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

//    @Override
//    public void prepareFailView(String error) {
//        // preparing for error pop up
//        LoginState loginState = PreferenceViewModel.getState();
//        loginState.setError(error);
//        loginViewModel.firePropertyChanged();
//    }
//}
