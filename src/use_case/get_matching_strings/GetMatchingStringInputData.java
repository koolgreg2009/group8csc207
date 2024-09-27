package use_case.get_matching_strings;

/**
 * Represents the input data required to retrieve matching strings.
 *
 * <p>This class encapsulates the key and input string used to find matching strings
 * based on some criteria.</p>
 */
public class GetMatchingStringInputData {
    private final String key;
    private final String input;

    /**
     * Constructs a GetMatchingStringInputData instance with the specified key and input.
     *
     * @param key   the key used for matching strings
     * @param input the input string to be matched
     */
    public GetMatchingStringInputData(String key, String input) {
        this.key = key;
        this.input = input;
    }

    /**
     * Gets the key used for matching strings.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets the input string to be matched.
     *
     * @return the input string
     */
    public String getInput() {
        return input;
    }
}
