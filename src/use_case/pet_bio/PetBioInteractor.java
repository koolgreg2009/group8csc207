package use_case.pet_bio;

import data_access.PetDAOInterface;
import dto.PetDTO;
import entity.Pet;

/**
 * The PetBioInteractor class implements the PetBioInputBoundary interface and handles the logic for the pet bio use case.
 * It retrieves pet information and prepares it for presentation.
 */
public class PetBioInteractor implements PetBioInputBoundary{
    final PetBioOutputBoundary bioPresenter;
    final PetDAOInterface petDAO;

    /**
     * Constructs a PetBioInteractor with the specified output boundary and pet data access object.
     *
     * @param bioPresenter the output boundary for presenting the pet bio information
     * @param petDAO the data access object for retrieving pet information
     */
    public PetBioInteractor(PetBioOutputBoundary bioPresenter, PetDAOInterface petDAO) {
        this.bioPresenter = bioPresenter;
        this.petDAO = petDAO;
    }

    /**
     * Retrieves the pet information based on the provided input data and prepares it for presentation.
     *
     * <p>This method fetches the pet details using the pet ID from the PetDAOInterface and creates a PetDTO object.
     * It then passes the PetDTO along with the username to the output boundary for presentation.</p>
     *
     * @param petBioInputData the input data containing the pet ID and the username of the viewer
     */
    @Override
    public void execute(PetBioInputData petBioInputData) {
        int petID = petBioInputData.getPetID();
        Pet pet = petDAO.get(petID);
		PetBioOutputData petBioOutputData = new PetBioOutputData(petBioInputData.getViewUser(),
				new PetDTO(pet.getPetID(), pet.getName(), pet.getBreed(), pet.getGender(), pet.getSpecies(),
						pet.getPetAge(), pet.getBio(), pet.getOwner(), pet.getEmail(), pet.getPhoneNum(),
						pet.getActivityLevel(), pet.getLocation(), pet.getImgUrl()));
		bioPresenter.preparePetBio(petBioOutputData);
    }
}
