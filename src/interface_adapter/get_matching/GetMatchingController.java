package interface_adapter.get_matching;

import use_case.get_matching_strings.GetMatchingStringInputBoundary;
import use_case.get_matching_strings.GetMatchingStringInputData;

public class GetMatchingController {
    private final GetMatchingStringInputBoundary matchInteractor;

    public GetMatchingController(GetMatchingStringInputBoundary matchInteractor) {
        this.matchInteractor = matchInteractor;
    }

    public void execute(String key, String input){
        matchInteractor.execute(new GetMatchingStringInputData(key, input));
    }
}

