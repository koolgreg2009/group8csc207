package use_case;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;
import entity.user.User;

import java.util.List;

/** This is the Adopt use case where it notifies user and updates files
 */
public class Adopt implements AdoptInputBoundary {
    final PetDAOInterface petDAO;
    final AdoptOutputBoundary userPresenter;
    final UserDAOInterface userDAO;

    public Adopt(PetDAOInterface petDAO, AdoptOutputBoundary userPresenter, UserDAOInterface userDAO){
        this.petDAO = petDAO;
        this.userPresenter = userPresenter;
        this.userDAO = userDAO;
    }

    @Override
    public void execute(AdoptInputData adoptInputData) {
        userPresenter.prepareAdopt("Pet has found a home");
        Pet uwu =  petDAO.get(adoptInputData.getPetID());
        uwu.markUnavailable();
        List<String> users = userDAO.removePetFromAllUserBookmarks(uwu.getPetID());
        petDAO.save(uwu);
        System.out.println("Pet " + uwu + " has been Adopted");
    }
}