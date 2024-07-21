package use_case.display_all_available_pets;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;
import entity.user.AdopterUser;
import entity.user.User;

import java.util.List;

public class DisplayAllPetsInteractor implements DisplayAllPetsInputBoundary {
    private final PetDAOInterface filePetDAO;
    private final UserDAOInterface fileUserDAO;
    private final DisplayAllPetsOutputBoundary displayAllPetPresenter;

    public DisplayAllPetsInteractor(PetDAOInterface filePetDAO, UserDAOInterface fileUserDAO, DisplayAllPetsOutputBoundary displayAllPetPresenter){
        this.filePetDAO = filePetDAO;
        this.fileUserDAO = fileUserDAO;
        this.displayAllPetPresenter = displayAllPetPresenter;
    }

    @Override
    public void execute(DisplayAllPetsInputData displayAllPetsInputdata){
        User user = fileUserDAO.get(displayAllPetsInputdata.getUser());
        List<Pet> pets = filePetDAO.getPreferencePets(((AdopterUser) user).getPreferences());
        this.displayAllPetPresenter.displayAllPetsOutput(new DisplayAllPetsOutputData(pets));
    }
}
