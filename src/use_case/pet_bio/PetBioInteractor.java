package use_case.pet_bio;


import data_access.PetDAOInterface;
import entity.Pet;

/**
 * The PetBioInteractor class implements the PetBioInputBoundary interface and handles the pet bio use case
 *
 * @version 1.0
 * @since 2024-07-21
 */
public class PetBioInteractor implements PetBioInputBoundary{
    final PetBioOutputBoundary bioPresenter;
    final PetDAOInterface petDAO;

    /**
     * The constructor for the PetBioInteractor object with the specified output boundary and pet data access object.
     *
     * @param bioPresenter the output boundary for the presenter
     * @param petDAO the data access object which provides access the information for the specified pet
     */
    public PetBioInteractor(PetBioOutputBoundary bioPresenter, PetDAOInterface petDAO) {
        this.bioPresenter = bioPresenter;
        this.petDAO = petDAO;
    }

    /**
     * Goes into the pet's own page and allows the user to view the pet's information such as bio, donator and
     * attributes
     * @param petBioInputData the PetBioInputData that is being picked up through the input boundary.
     */
    @Override
    public void execute(PetBioInputData petBioInputData) {
        int petID = petBioInputData.getPetID();
        Pet pet = petDAO.get(petID);
        PetBioOutputData petBioOutputData = new PetBioOutputData(pet);
        bioPresenter.preparePetBio(petBioOutputData);
    }
}
