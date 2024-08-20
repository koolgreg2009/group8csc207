package use_case.pet_bio;

/**
 * Encapsulates the input data required for the PetBio use case.
 * This includes the pet ID and the username of the user viewing the pet bio.
 */
public class PetBioInputData {

    private final int petID;
	private String viewUser;

    /**
     * Constructs a PetBioInputData object with the specified username and pet ID.
     *
     * @param userName the username of the user viewing the pet bio
     * @param petID the ID of the pet whose bio is being accessed
     */
    public PetBioInputData(String userName, int petID) {
        this.petID = petID;
        this.viewUser = userName;
    }

    /**
     * Returns the pet ID from the PetBioInputData object.
     *
     * @return the pet ID
     */
    public int getPetID() {return petID;}

    /**
     * Returns the username of the user viewing the pet bio.
     *
     * @return the username
     */
	public String getViewUser() {
		return viewUser;
	}
}
