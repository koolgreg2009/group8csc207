package use_case.display_all_available_pets;

import data_access.PetDAOInterface;
import entity.Pet;

import java.util.List;

public class displayAllPetsInteractor implements displayAllPetsInputBoundary{
    final PetDAOInterface filePetDAO;
    final displayAllPetsOutputBoundary displayAllPetPresenter;

    public displayAllPetsInteractor(PetDAOInterface filePetDAO, displayAllPetsOutputBoundary displayAllPetPresenter){
        this.filePetDAO = filePetDAO;
        this.displayAllPetPresenter = displayAllPetPresenter;
    }

    @Override
    public void execute(displayInputData displayInputdata){
        List<Pet> pets = filePetDAO.getPreferencePets(displayInputdata.getPreferences());
        // return the pets via controller
        System.out.println(pets);
    }
}
