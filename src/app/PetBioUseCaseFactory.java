package app;

import data_access.FilePetDAO;
import data_access.PetDAOInterface;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.pet_bio.PetBioPresenter;
import use_case.pet_bio.PetBioInputBoundary;
import use_case.pet_bio.PetBioInteractor;
import use_case.pet_bio.PetBioOutputBoundary;

import java.io.IOException;

public class PetBioUseCaseFactory {

    public static PetBioController createPetBioUseCase() {
        try {
            PetDAOInterface petDAO = new FilePetDAO("/pets.json");
            PetBioOutputBoundary bioPresenter = new PetBioPresenter();
            PetBioInputBoundary petBioInteractor = new PetBioInteractor(bioPresenter, petDAO);
            return new PetBioController(petBioInteractor);
        }
        catch (IOException e) {
            System.out.println("Could not open pet data file");
            return null;
        }

    }
}
