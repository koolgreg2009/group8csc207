package interface_adapter.display_all_pets;

import data_access.FilePetDAO;
import data_access.PetDAOInterface;
import entity.preference.UserPreference;
import interface_adapter.SessionManager;
import use_case.display_all_available_pets.DisplayAllPetsInputBoundary;
import use_case.display_all_available_pets.DisplayAllPetsInputData;

public class DisplayAllPetsController {
    private final DisplayAllPetsInputBoundary displayAllPetsInteractor;

    public DisplayAllPetsController(DisplayAllPetsInputBoundary displayAllPetsInteractor) {
        this.displayAllPetsInteractor = displayAllPetsInteractor;
    }

    public void execute(){
        this.displayAllPetsInteractor.execute(new DisplayAllPetsInputData(SessionManager.getCurrentUser()));

    }
}
