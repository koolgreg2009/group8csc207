package use_case.get_matching_strings;

public class GetMatchingStringInputData {
    private final String key;
    private final String input;
    public GetMatchingStringInputData(String key, String input) {
        this.key = key;
        this.input = input;
    }
    public String getKey() {
        return key;
    }
    public String getInput() {
        return input;
    }
}
