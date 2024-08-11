package interface_adapter.get_matching;

import interface_adapter.PreferenceState;
import interface_adapter.preference.PreferenceViewModel;
import use_case.get_matching_strings.GetMatchingStringOutputBoundary;
import use_case.get_matching_strings.GetMatchingStringOutputData;

public class GetMatchingPresenter implements GetMatchingStringOutputBoundary {
    private final PreferenceViewModel preferenceViewModel;
    public GetMatchingPresenter(PreferenceViewModel preferenceViewModel) {
        this.preferenceViewModel = preferenceViewModel;
    }
    @Override
    public void prepareView(GetMatchingStringOutputData data){
        PreferenceState state = preferenceViewModel.getState();
        state.setMatchingStrings(data.getMatchingStrings());
        preferenceViewModel.fireMatchPropertyChanged();
    }
}
