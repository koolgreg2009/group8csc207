package interface_adapter.preference;

import interface_adapter.ViewManagerModel;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.preference.PreferenceOutputBoundary;

public class PreferencePresenter implements PreferenceOutputBoundary {

    /**
     * The view manager model used to switch between views.
     */
    private final ViewManagerModel viewManagerModel;

    /**
     * The view model for the logged-in view.
     */
    private final LoggedInViewModel loggedInViewModel;
    private final DisplayPetsViewModel displayPetsViewModel;

    /**
     * The presenter for the preference use case.
     *
     * @param viewManagerModel the view Manager for our program to manage the change in views
     * @param loggedInViewModel the logged in view model that is previously and afterward displayed
     * @param displayPetsViewModel the Pets view model which is in charge of changing the pet listings after
     */
    public PreferencePresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, DisplayPetsViewModel displayPetsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.displayPetsViewModel = displayPetsViewModel;
    }

    /**
     * Preperation for the preferences to be executed successfully
     */
    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        displayPetsViewModel.firePropertyChanged();
    }
}

