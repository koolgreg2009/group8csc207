package interface_adapter.get_matching;

import use_case.get_matching_strings.GetMatchingStringInputBoundary;
import use_case.get_matching_strings.GetMatchingStringInputData;

/**
 * Controller for handling requests to find matching strings based on a key and input.
 * Delegates the request to the {@link GetMatchingStringInputBoundary} for processing.
 */
public class GetMatchingController {
    private final GetMatchingStringInputBoundary matchInteractor;

    /**
     * Constructs a new {@code GetMatchingController} with the specified input boundary.
     *
     * @param matchInteractor the {@code GetMatchingStringInputBoundary} used to process matching string requests.
     */
    public GetMatchingController(GetMatchingStringInputBoundary matchInteractor) {
        this.matchInteractor = matchInteractor;
    }

    /**
     * Executes the request to find matching strings.
     * Delegates the task to the {@code GetMatchingStringInputBoundary} by providing the key and input as input data.
     *
     * @param key the key to use for matching.
     * @param input the input string to match against the key.
     */
    public void execute(String key, String input){
        matchInteractor.execute(new GetMatchingStringInputData(key, input));
    }
}

