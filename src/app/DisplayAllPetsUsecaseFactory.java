package app;

import data_access.FilePetDAO;
import data_access.PetDAOInterface;
import interface_adapter.display_all_pets.DisplayAllPetsController;
import interface_adapter.display_all_pets.DisplayAllPetsPresenter;
import use_case.display_all_available_pets.DisplayAllPetsInputBoundary;
import use_case.display_all_available_pets.DisplayAllPetsInteractor;
import use_case.display_all_available_pets.DisplayAllPetsOutputBoundary;

import java.io.IOException;

public class DisplayAllPetsUsecaseFactory {
    private DisplayAllPetsUsecaseFactory() {
    }

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