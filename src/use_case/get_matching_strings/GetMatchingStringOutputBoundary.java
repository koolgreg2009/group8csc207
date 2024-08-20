package use_case.get_matching_strings;

/**
 * This interface defines the contract for presenting matching string results.
 *
 * <p>Implementations of this interface will handle the logic required to present
 * the output data that contains matching strings to the user.</p>
 */
public interface GetMatchingStringOutputBoundary {

    /**
     * Prepares and presents the results of the matching strings operation.
     *
     * @param data the data containing the results of the matching strings operation
     */
    void prepareSuccessView(GetMatchingStringOutputData data);
}
