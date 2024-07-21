package app;

import data_access.FilePetDAO;
import data_access.PetDAOInterface;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.pet_bio.PetBioPresenter;
import use_case.pet_bio.PetBioInputBoundary;
import use_case.pet_bio.PetBioInteractor;
import use_case.pet_bio.PetBioOutputBoundary;

import java.io.IOException;

/**
 * Factory class responsible for creating instances of {@link PetBioController}.
 */
public class PetBioUseCaseFactory {

    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private PetBioUseCaseFactory() {
    }

    /**
     * Creates and returns a {@link PetBioController} instance.
     * Sets up the necessary dependencies including the data access object and presenter.
     *
     * @return an instance of {@link PetBioController}, or {@code null} if an {@link IOException} occurs.
     */
    public static PetBioController createPetBioUseCase() {
        try
        {
            PetDAOInterface petDAO = new FilePetDAO("./pets.json");
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
