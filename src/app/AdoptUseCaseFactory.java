package app;

import data_access.FilePetDAO;
import data_access.FileUserDAO;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.adopt.AdoptController;
import interface_adapter.adopt.AdoptPresenter;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.adopt.Adopt;
import use_case.adopt.AdoptInputBoundary;
import use_case.adopt.AdoptOutputBoundary;

import java.io.IOException;

/**
 * Factory class responsible for creating instances of {@link AdoptController}.
 */
public class AdoptUseCaseFactory {

    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private AdoptUseCaseFactory(){
    }

    /**
     * Creates and returns an {@link AdoptController} instance.
     * Sets up the necessary dependencies including the data access objects and presenter.
     *
     * @return an instance of {@link AdoptController}, or {@code null} if an {@link IOException} occurs.
     */
    public static AdoptController createAdoptUseCase(PetDAOInterface petDAO, UserDAOInterface userDAO, LoggedInViewModel loggedInViewModel, DisplayPetsViewModel displayPetsViewModel){
            AdoptOutputBoundary adoptPresenter = new AdoptPresenter(loggedInViewModel, displayPetsViewModel);
            AdoptInputBoundary adoptInteractor = new Adopt(petDAO, adoptPresenter, userDAO);
            return new AdoptController(adoptInteractor);

    }
}
