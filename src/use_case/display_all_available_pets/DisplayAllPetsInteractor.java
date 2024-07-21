package use_case.display_all_available_pets;

import data_access.PetDAOInterface;
import entity.Pet;

import java.util.List;

public class DisplayAllPetsInteractor implements DisplayAllPetsInputBoundary {
    final PetDAOInterface filePetDAO;
    final DisplayAllPetsOutputBoundary displayAllPetPresenter;

    public DisplayAllPetsInteractor(PetDAOInterface filePetDAO, DisplayAllPetsOutputBoundary displayAllPetPresenter){
        this.filePetDAO = filePetDAO;
        this.displayAllPetPresenter = displayAllPetPresenter;
    }

    @Override
    public void execute(DisplayAllPetsInputData displayAllPetsInputdata){
        List<Pet> pets = filePetDAO.getPreferencePets(displayAllPetsInputdata.getPreferences());

        this.displayAllPetPresenter.displayAllPetsOutput(new DisplayAllPetsOutputData(pets));
    }
}
