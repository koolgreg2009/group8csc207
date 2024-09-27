package use_case.get_breed_info;

/**
 * Defines the contract for presenting breed information.
 *
 * <p>Implementations of this interface are responsible for handling the presentation of breed information
 * based on the provided output data. It includes methods for successfully preparing and presenting the breed
 * information, as well as handling and presenting errors.</p>
 */
public interface GetBreedOutputBoundary {

    /**
     * Prepares and presents the breed information based on the given output data.
     *
     * @param breedOutputData the data containing the breed information to be presented
     */
    void prepareGetBreedView(GetBreedOutputData breedOutputData);

    /**
     * Prepares and presents an error message when the breed information cannot be retrieved.
     *
     * @param errorMessage the error message to be presented
     */
    void prepareFailView(String errorMessage);
}
