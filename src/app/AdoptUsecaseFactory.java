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

/** Class AdoptUsecaseFactory that takes all the info and returns an AdoptController
 */
public class AdoptUsecaseFactory {
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
