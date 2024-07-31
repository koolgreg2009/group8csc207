package use_case.get_breed_info;

/**
 * This interface defines the contract for retrieving breed information.
 *
 * <p>Implementations of this interface will handle the logic required to fetch breed information
 * based on the provided input data.
 */
public interface GetBreedInputBoundary {

    /**
     * Executes the process of retrieving breed information based on the input data.
     *
     * @param breedInputData the data required to fetch the breed information
     */
    void execute(GetBreedInputData breedInputData);
}
