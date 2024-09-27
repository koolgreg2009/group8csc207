package use_case.pet_bio;

/**
 * The PetBioInputBoundary interface defines the input boundary for the pet bio use case.
 * It provides an abstract method for executing the use case with the provided input data.
 */
public interface PetBioInputBoundary {

    /**
     * Executes the use case with the given input data.
     *
     * @param petBioInputData the input data required for the pet bio use case
     */
    void execute(PetBioInputData petBioInputData);
}
