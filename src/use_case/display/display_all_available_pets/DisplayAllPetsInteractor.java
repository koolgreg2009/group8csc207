package use_case.display.display_all_available_pets;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;
import entity.user.AdopterUser;
import entity.user.User;
import use_case.display.DisplayPetsOutputBoundary;
import use_case.display.DisplayPetsOutputData;

import java.util.List;

/**
 * The DisplayAllPetsInteractor class is responsible for fetching all available pets that match
 * the preferences of a given user. It interacts with the PetDAOInterface and UserDAOInterface
 * to retrieve data and passes the result to the presenter to prepare the view.
 */
public class DisplayAllPetsInteractor implements DisplayAllPetsInputBoundary {
    private final PetDAOInterface filePetDAO;
    private final UserDAOInterface fileUserDAO;
    private final DisplayPetsOutputBoundary displayAllPetPresenter;

    /**
     * Constructs a new DisplayAllPetsInteractor with the given data access objects and presenter.
     *
     * @param filePetDAO The data access object used to fetch pet information.
     * @param fileUserDAO The data access object used to fetch user information.
     * @param displayAllPetPresenter The presenter used to prepare the view for displaying all pets.
     */
    public DisplayAllPetsInteractor(PetDAOInterface filePetDAO, UserDAOInterface fileUserDAO, DisplayPetsOutputBoundary displayAllPetPresenter) {
        this.filePetDAO = filePetDAO;
        this.fileUserDAO = fileUserDAO;
        this.displayAllPetPresenter = displayAllPetPresenter;
    }

    /**
     * Executes the use case to fetch all available pets that match the preferences of the given user.
     * The fetched pets are then passed to the presenter to prepare the view.
     *
     * @param displayAllPetsInputData The input data containing the user information.
     */
    @Override
    public void execute(DisplayAllPetsInputData displayAllPetsInputData) {
        User user = fileUserDAO.get(displayAllPetsInputData.getUser());
        List<Pet> pets = filePetDAO.getPreferencePets(((AdopterUser) user).getPreferences());
        this.displayAllPetPresenter.displayPetsOutput(new DisplayPetsOutputData(pets));
    }
}
