package use_case.adopt;

/**
 * This interface defines the contract for processing the adoption of a pet.
 *
 * <p>Implementations of this interface will handle the adoption process based on the provided
 * input data, ensuring that the pet is adopted according to the specified details.
 */
public interface AdoptInputBoundary {

    /**
     * Executes the adoption of the pet based on the input data.
     *
     * @param adoptInputData the data required to adopt the pet
     */
    void execute(AdoptInputData adoptInputData);
}
