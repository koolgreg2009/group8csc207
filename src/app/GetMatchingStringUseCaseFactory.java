package app;

import data_access.APIInfoInterface;
import interface_adapter.get_matching.GetMatchingController;
import interface_adapter.get_matching.GetMatchingPresenter;
import interface_adapter.preference.PreferenceViewModel;
import use_case.get_matching_strings.GetMatchStringInteractor;
import use_case.get_matching_strings.GetMatchingStringInputBoundary;
import use_case.get_matching_strings.GetMatchingStringOutputBoundary;

/**
 * Factory class responsible for creating instances related to the get matching strings use case.
 */
public class GetMatchingStringUseCaseFactory {

    /**
     * Private constructor of {@link GetMatchingStringUseCaseFactory} to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private GetMatchingStringUseCaseFactory(){
    }

    /**
     * Creates and returns an instance of {@link GetMatchingController}.
     * Sets up the necessary dependencies including the interactor and presenter.
     *
     * @param infoDAO the data access object for API information.
     * @param preferenceViewModel the view model representing the user's preferences.
     * @return an instance of {@link GetMatchingController}.
     */
    public static GetMatchingController createMatchingUseCase(APIInfoInterface infoDAO, PreferenceViewModel preferenceViewModel){
        GetMatchingStringOutputBoundary matchingPresenter = new GetMatchingPresenter(preferenceViewModel);
        GetMatchingStringInputBoundary matchingInteractor = new GetMatchStringInteractor(infoDAO, matchingPresenter);
        return new GetMatchingController(matchingInteractor);
    }

}
