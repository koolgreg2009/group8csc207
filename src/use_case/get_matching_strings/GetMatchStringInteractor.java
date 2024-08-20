package use_case.get_matching_strings;

import data_access.APIInfoInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses infoDao to retrieve all strings in a data category based on key from inputData
 * If string from dao matches input string without case sensitivity and string does exactly match input string
 * add to filtered arraylist.
 * Invokes presenter with filtered arraylist.
 */
public class GetMatchStringInteractor implements GetMatchingStringInputBoundary{
    private final APIInfoInterface infoDAO;
    private final GetMatchingStringOutputBoundary infoPresenter;

    public GetMatchStringInteractor(APIInfoInterface FileApiInfoDAO, GetMatchingStringOutputBoundary infoPresenter){
        this.infoDAO = FileApiInfoDAO;
        this.infoPresenter = infoPresenter;
    }
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
