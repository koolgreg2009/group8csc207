package use_case.adopt;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;

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
        Pet uwu =  petDAO.get(adoptInputData.getPetID());
        uwu.markUnavailable();
        List<String> users = userDAO.removePetFromAllUserBookmarks(uwu.getPetID());
        petDAO.save(uwu);
        for(String u : users){
            userDAO.get(u).addNotif("This pet has found a home");
        }
        AdoptOutputData owo = new AdoptOutputData(uwu);
        userPresenter.prepareAdopt(owo);
    }
}