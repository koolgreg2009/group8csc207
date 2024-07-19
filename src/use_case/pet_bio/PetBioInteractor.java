package use_case.pet_bio;


import data_access.PetDAOInterface;
import entity.Pet;

public class PetBioInteractor implements PetBioInputBoundary{
    final PetBioOutputBoundary bioPresenter;
    final PetDAOInterface petDAO;

    public PetBioInteractor(PetBioOutputBoundary bioPresenter, PetDAOInterface petDAO) {
        this.bioPresenter = bioPresenter;
        this.petDAO = petDAO;
    }

    /**
     * Goes into the pet's own page and allows the user to view the pet's
     * information such as its bio, donater and attributes.
     */
    @Override
    public void execute(PetBioInputData petBioInputData) {
        int petID = petBioInputData.getPetID();
        Pet pet = petDAO.get(petID);
        PetBioOutputData petBioOutputData = new PetBioOutputData(pet);
        bioPresenter.preparePetBio(petBioOutputData);
    }
}
