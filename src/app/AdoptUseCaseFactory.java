package app;

import data_access.FilePetDAO;
import data_access.FileUserDAO;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.adopt.AdoptController;
import interface_adapter.adopt.AdoptPresenter;
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
    public static AdoptController createAdoptUsecase(){
        try{
            PetDAOInterface pet = new FilePetDAO("./pets.json");
            UserDAOInterface user = new FileUserDAO("./users.json");
            AdoptOutputBoundary adoptPresenter = new AdoptPresenter();
            AdoptInputBoundary adoptInteractor = new Adopt(pet, adoptPresenter, user);
            return new AdoptController(adoptInteractor);
        } catch(IOException e){
            System.out.println("File not found");
            return null;
        }
    }
}
