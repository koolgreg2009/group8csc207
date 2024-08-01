package use_case.get_breed_info;

/**
 * This interface defines the contract for presenting breed information.
 *
 * <p>Implementations of this interface will handle the logic required to present the output data
 * that contains breed information to the user.
 */
public interface GetBreedOutputBoundary {

    /**
     * Prepares and presents the breed information based on the output data.
     *
     * @param breedOutputData the data containing the breed information to be presented
     */
    void prepareGetBreedView(GetBreedOutputData breedOutputData);
    void prepareFailView(String errorMessage);
}
