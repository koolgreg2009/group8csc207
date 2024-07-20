package use_case.adopt;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;

import java.util.List;

/**Interactor responsible for notifying user that their bookmarked
 * pet has been adopted.
 */
public class Adopt implements AdoptInputBoundary {
    final PetDAOInterface petDAO;
    final AdoptOutputBoundary userPresenter;
    final UserDAOInterface userDAO;

    /**
     * Constructor for Adopt
     *
     * @param petDAO the pet DAO interface
     * @param userPresenter the adopt output boundary
     * @param userDAO the DAO for the user data
     */
    public Adopt(PetDAOInterface petDAO, AdoptOutputBoundary userPresenter, UserDAOInterface userDAO){
        this.petDAO = petDAO;
        this.userPresenter = userPresenter;
        this.userDAO = userDAO;
    }

    /**
     * Executes Adopt. Gets user and pet data and marks the adopted pet unavailable.
     * Also sends user notification that pet has been adopted.
     *
     */
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