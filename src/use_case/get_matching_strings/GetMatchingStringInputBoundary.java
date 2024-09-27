package use_case.get_matching_strings;

/**
 * Defines the contract for retrieving matching strings based on the provided input data.
 *
 * <p>Implementations of this interface will handle the logic for processing the input data to retrieve
 * matching strings and provide the results accordingly.</p>
 */
public interface GetMatchingStringInputBoundary {

    /**
     * Executes the logic to retrieve matching strings based on the provided input data.
     *
     * @param inputData the data used to find matching strings
     */
    void execute(GetMatchingStringInputData inputData);
}
