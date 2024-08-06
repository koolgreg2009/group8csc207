package use_case.pet_bio;

import dto.pet.PetDTO;

/**
 * The PetBioOutputData class encapsulates the output data of the pet bio use case.
 * It includes fields for the username and a flag indicating if the login attempt failed.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class PetBioOutputData {

    private PetDTO pet;
	private String viewUser;

    /**
     * Constructs a new PetBioOutputData object with the specified pet.
     * @param viewUser 
     *
     * @param petDTO the pet whose bio is being output
     */
    public PetBioOutputData(String viewUser, PetDTO petDTO) {
        this.pet = petDTO;
        this.viewUser = viewUser;
    }

    /**
     * Get the pet from the PetBioOutputData object.
     *
     * @return the pet from the PetBioOutputData object
     */
    public PetDTO getPet() {
        return pet;
    }

	public String getViewUser() {
		return viewUser;
	}

}
