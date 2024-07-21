package app;

import data_access.FilePetDAO;
import data_access.PetDAOInterface;
import interface_adapter.adopt.AdoptController;
import interface_adapter.display_all_pets.DisplayAllPetsController;
import interface_adapter.display_all_pets.DisplayAllPetsPresenter;
import use_case.display_all_available_pets.DisplayAllPetsInputBoundary;
import use_case.display_all_available_pets.DisplayAllPetsInteractor;
import use_case.display_all_available_pets.DisplayAllPetsOutputBoundary;

import java.io.IOException;

/**
 * Factory class responsible for creating instances of {@link DisplayAllPetsController}.
 */
public class DisplayAllPetsUseCaseFactory {

    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private DisplayAllPetsUseCaseFactory() {
    }

    /**
     * Creates and returns an {@link DisplayAllPetsController} instance.
     * Sets up the necessary dependencies including the data access object and presenter.
     *
     * @return an instance of {@link DisplayAllPetsController}, or {@code null} if an {@link IOException} occurs.
     */
    public static DisplayAllPetsController createDisplayAllPetsUsecase() {
        try {
            PetDAOInterface filePetDAO = new FilePetDAO("./pets.json");
            DisplayAllPetsOutputBoundary displayAllPetsPresenter = new DisplayAllPetsPresenter();
            DisplayAllPetsInputBoundary displayAllPetsInteractor = new DisplayAllPetsInteractor(filePetDAO,
                    displayAllPetsPresenter);
            return new DisplayAllPetsController(displayAllPetsInteractor);
        } catch (IOException e) {
            System.out.println("Error creating file pet DAO");
            return null;
        }
    }
}