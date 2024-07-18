package use_case.displayAllAvailablePets;

import data_access.FilePetDAO;
import data_access.PetDAOInterface;
import entity.Pet;
import use_case.displayAllAvailablePets.displayAllPetsInputBoundary;
import use_case.displayAllAvailablePets.displayAllPetsOutputBoundary;

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
