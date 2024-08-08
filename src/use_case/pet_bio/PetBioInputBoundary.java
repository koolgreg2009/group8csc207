package use_case.pet_bio;

/**
 * The PetBioInputBoundary interface is the input boundary for the pet bio use case.
 * It contains the abstract methods that will be implemented by the PetBioInteractor class.
 *
 * @version 1.0
 * @since 2024-07-21
 */
public interface PetBioInputBoundary {

    /** An abstract execute class that will be implemented in the PetBioInteractor class.
     *
     * @param petBioInputData the PetBioInputData that is being picked up through the input boundary.
     */
    void execute(PetBioInputData petBioInputData);
}
