package use_case.pet_bio;

import entity.Pet;

/**
 * The PetBioOutputData class encapsulates the output data of the pet bio use case.
 * It includes fields for the username and a flag indicating if the login attempt failed.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class PetBioOutputData {

    private Pet pet;

    /**
     * Constructs a new PetBioOutputData object with the specified pet.
     *
     * @param pet the pet whose bio is being output
     */
    public PetBioOutputData(Pet pet) {
        this.pet = pet;
    }

    /**
     * Get the pet from the PetBioOutputData object.
     *
     * @return the pet from the PetBioOutputData object
     */
    public Pet getPet() {
        return pet;
    }

}
