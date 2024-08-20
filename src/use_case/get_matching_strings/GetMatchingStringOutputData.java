package use_case.get_matching_strings;

import java.util.List;

/**
 * Represents the output data for the get matching strings use case.
 *
 * <p>This class holds the list of strings that match the criteria specified
 * in the input data. It is used to communicate the results of the matching
 * strings operation to the output boundary.</p>
 */
public class GetMatchingStringOutputData {
    private final List<String> matchingStrings;

    /**
     * Constructs a GetMatchingStringOutputData with the specified list of matching strings.
     *
     * @param matchingStrings the list of strings that match the criteria
     */
    public GetMatchingStringOutputData(List<String> matchingStrings) {
        this.matchingStrings = matchingStrings;
    }

    /**
     * Gets the list of matching strings.
     *
     * @return the list of strings that match the criteria
     */
    public List<String> getMatchingStrings() {
        return matchingStrings;
    }
}
