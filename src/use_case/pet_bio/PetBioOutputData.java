package use_case.pet_bio;

import dto.PetDTO;

/**
 * The PetBioOutputData class encapsulates the output data for the pet bio use case.
 * It includes the pet's details and the username of the viewer.
 */
public class PetBioOutputData {

    private PetDTO pet;
	private String viewUser;

    /**
     * Constructs a new PetBioOutputData object with the specified pet details and viewer's username.
     *
     * @param viewUser the username of the user viewing the pet's bio
     * @param petDTO the details of the pet whose bio is being output
     */
    public PetBioOutputData(String viewUser, PetDTO petDTO) {
        this.pet = petDTO;
        this.viewUser = viewUser;
    }

    /**
     * Returns the PetDTO object containing the pet's details.
     *
     * @return the PetDTO object with the pet's bio details
     */
    public PetDTO getPet() {
        return pet;
    }

    /**
     * Returns the username of the user viewing the pet's bio.
     *
     * @return the username of the viewer
     */
	public String getViewUser() {
		return viewUser;
	}

}
