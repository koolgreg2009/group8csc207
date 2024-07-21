package use_case.pet_bio;

/**
 * Input data for the PetBio use case and encapsulates the pet ID.
 *
 * @version 1.0
 * @since 2024-07-21
 */
public class PetBioInputData {

    private final int petID;

    /**
     * The constructor for the PetBioInputData which is created with the pet ID.
     *
     * @param petID the pet ID being held by the PetBioInputData object
     */
    public PetBioInputData(int petID) {
        this.petID = petID;
    }

    /**
     * Get the pet ID from the PetBioInputData ojbect.
     *
     * @return the pet ID
     */
    public int getPetID() {return petID;}
}
