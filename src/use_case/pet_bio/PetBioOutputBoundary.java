package use_case.pet_bio;

/**
 * The PetBioOutputBoundary interface defines the contract for presenting the output of the pet bio use case.
 * It contains methods for preparing and handling the pet bio data to be presented to the user.
 */
public interface PetBioOutputBoundary {

    /**
     * Prepares the pet bio data for presentation.
     *
     * @param petBio the pet bio output data to be prepared and presented
     */
    void preparePetBio(PetBioOutputData petBio);
}
