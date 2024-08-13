package use_case.get_matching_strings;

import data_access.APIInfoInterface;

import java.util.ArrayList;
import java.util.List;

public class GetMatchStringInteractor implements GetMatchingStringInputBoundary{
    private final APIInfoInterface infoDAO;
    private final GetMatchingStringOutputBoundary infoPresenter;

    public GetMatchStringInteractor(APIInfoInterface FileApiInfoDAO, GetMatchingStringOutputBoundary infoPresenter){
        this.infoDAO = FileApiInfoDAO;
        this.infoPresenter = infoPresenter;
    }
    @Override
    public void execute(GetMatchingStringInputData inputData){
        List<String> filtered = new ArrayList<>();
        List<String> allString = infoDAO.getData(inputData.getKey());
        for (String string : allString) {
            if (string.toLowerCase().startsWith(inputData.getInput().toLowerCase()) && !string.equals(inputData.getInput())) {
                filtered.add(string);
            }
        }
        infoPresenter.prepareView(new GetMatchingStringOutputData(filtered));
    }
}
