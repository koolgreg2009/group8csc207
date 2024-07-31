package use_case.adopt;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;

import java.util.List;

/**
 * Interactor responsible for notifying user that their bookmarked
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
     * Executes the adoption process for a pet.
     * <p>
     * This method retrieves a pet by its ID and checks if the pet is available for adoption. If the pet
     * is already adopted, it prints a message indicating that the pet is unavailable. If the pet is available,
     * it marks the pet as unavailable, removes the pet from all user bookmarks, and notifies the users that
     * the pet has found a home. Finally, it prepares the adoption output data and presents it using the
     * {@code userPresenter}.
     *
     * @param adoptInputData the input data containing the pet ID to be adopted
     */
    @Override
    public void execute(AdoptInputData adoptInputData) {
        Pet pet =  petDAO.get(adoptInputData.getPetID());
        if (!pet.isAvailable()){
            System.out.println("Pet" + pet.getPetID() + " has already been adopted and is unavailable.");
        }
        else {
            pet.markUnavailable();
            List<String> users = userDAO.removePetFromAllUserBookmarks(pet.getPetID());
            petDAO.save(pet);
            for (String u : users) {
                userDAO.get(u).addNotif("This pet has found a home");
            }
            AdoptOutputData outputData = new AdoptOutputData(pet.getOwner(), pet.getEmail(), pet.getPhoneNum(),
                    String.valueOf(pet.getPetID()));
            userPresenter.prepareAdopt(outputData);
        }
    }
}