package use_case.get_matching_strings;

import data_access.APIInfoInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Interactor responsible for processing requests to find strings that match a given input.
 *
 * <p>This class interacts with the data access object to retrieve a list of strings and filters them based on the
 * provided key and input string. It then sends the filtered results to the output boundary for presentation.</p>
 */
public class GetMatchStringInteractor implements GetMatchingStringInputBoundary{
    private final APIInfoInterface infoDAO;
    private final GetMatchingStringOutputBoundary infoPresenter;

    /**
     * Constructs a GetMatchStringInteractor with the specified API info data access object and output boundary.
     *
     * @param FileApiInfoDAO the data access object for retrieving strings
     * @param infoPresenter the output boundary for presenting the results
     */
    public GetMatchStringInteractor(APIInfoInterface FileApiInfoDAO, GetMatchingStringOutputBoundary infoPresenter){
        this.infoDAO = FileApiInfoDAO;
        this.infoPresenter = infoPresenter;
    }

    /**
     * Executes the process of finding and filtering matching strings based on the input data.
     *
     * <p>This method retrieves a list of all strings associated with the specified key, filters them to include only
     * those that start with the given input string (excluding exact matches), and then passes the results to the
     * output boundary for presentation.</p>
     *
     * @param inputData the data containing the key and input string used for filtering
     */
    @Override
    public void execute(GetMatchingStringInputData inputData){
        String key = inputData.getKey();
        List<String> filtered = new ArrayList<>();
        List<String> allString = infoDAO.getData(key);
        for (String string : allString) {
            if (string.toLowerCase().startsWith(inputData.getInput().toLowerCase()) && !string.equals(inputData.getInput())) {
                filtered.add(string);
            }

        infoPresenter.prepareSuccessView(new GetMatchingStringOutputData(filtered));
        }
    }
}
