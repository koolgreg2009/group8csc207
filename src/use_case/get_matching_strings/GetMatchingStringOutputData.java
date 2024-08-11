package use_case.get_matching_strings;

import java.util.List;

public class GetMatchingStringOutputData {
    private final List<String> matchingStrings;
    public GetMatchingStringOutputData(List<String> matchingStrings) {
        this.matchingStrings = matchingStrings;
    }
    public List<String> getMatchingStrings() {
        return matchingStrings;
    }
}
