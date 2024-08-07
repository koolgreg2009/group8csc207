package use_case.pet_bio;

import dto.PetDTO;

/**
 * The PetBioOutputData class encapsulates the output data of the pet bio use case.
 * It includes fields for the username and a flag indicating if the login attempt failed.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class PetBioOutputData {

    private PetDTO pet;

    /**
     * Constructs a new PetBioOutputData object with the specified pet.
     *
     * @param petDTO the pet whose bio is being output
     */
    public PetBioOutputData(PetDTO petDTO) {
        this.pet = petDTO;
    }

    /**
     * Get the pet from the PetBioOutputData object.
     *
     * @return the pet from the PetBioOutputData object
     */
    public PetDTO getPet() {
        return pet;
    }

}
