package use_case.pet_bio;

/**
 * The PetBioOutputBoundary interface defines the methods to implement the output data for the pet bio use case.
 * It contains the abstract methods that will be implemented by the PetBioInteractor class.
 *
 * @version 1.0
 * @since 2024-07-21
 */
public interface PetBioOutputBoundary {

    /**
     * Prepares the pet bio data for the output.
     *
     * @param petBio the petBio that is being prepared
     */
    void preparePetBio(PetBioOutputData petBio);
}
