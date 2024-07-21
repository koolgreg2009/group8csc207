package use_case.adopt;

/** This is the interface for input data for Adopt
 */
public interface AdoptInputBoundary {

    /**
     * Executes the adoption of the pet based on the input data.
     * @param adoptInputData the data required to adopt the pet
     */
    void execute(AdoptInputData adoptInputData);
}
