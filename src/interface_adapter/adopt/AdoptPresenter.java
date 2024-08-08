package interface_adapter.adopt;

import interface_adapter.SessionManager;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.adopt.AdoptOutputBoundary;
import use_case.adopt.AdoptOutputData;
import view.LoggedInView;

/** Adopt presenter class to present the message
 */
public class AdoptPresenter implements AdoptOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;
    private final DisplayPetsViewModel displayPetsViewModel;

    public AdoptPresenter(LoggedInViewModel loggedInViewModel, DisplayPetsViewModel displayPetsViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.displayPetsViewModel = displayPetsViewModel;
    }

    /**
     * method thats called when pet is adopted.
     */
    @Override
    public void prepareAdopt(AdoptOutputData adoptoutdata) {
        loggedInViewModel.setNotification("Thank you " + SessionManager.getCurrentUser() + " for adopting " + adoptoutdata.getID() + "\n" + "You may contact the owner " + adoptoutdata.getPetOwner() + " through: \n" + adoptoutdata.getOwnerEmail() + " and " + adoptoutdata.getOwnerPhone(), true);
        displayPetsViewModel.firePropertyChanged();
    }
}
