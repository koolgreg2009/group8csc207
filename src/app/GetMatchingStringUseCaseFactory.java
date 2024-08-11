package app;

import data_access.APIInfoInterface;
import data_access.FileApiInfoDAO;
import interface_adapter.get_matching.GetMatchingController;
import interface_adapter.get_matching.GetMatchingPresenter;
import interface_adapter.preference.PreferenceViewModel;
import use_case.get_matching_strings.GetMatchStringInteractor;
import use_case.get_matching_strings.GetMatchingStringInputBoundary;
import use_case.get_matching_strings.GetMatchingStringOutputBoundary;

public class GetMatchingStringUseCaseFactory {
    private GetMatchingStringUseCaseFactory(){
    }
    public static GetMatchingController createMatchingUseCase(APIInfoInterface infoDAO, PreferenceViewModel preferenceViewModel){
        GetMatchingStringOutputBoundary matchingPresenter = new GetMatchingPresenter(preferenceViewModel);
        GetMatchingStringInputBoundary matchingInteractor = new GetMatchStringInteractor(infoDAO, matchingPresenter);
        return new GetMatchingController(matchingInteractor);
    }

}
