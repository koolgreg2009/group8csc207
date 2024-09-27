package interface_adapter.get_matching;

import interface_adapter.preference.PreferenceState;
import interface_adapter.preference.PreferenceViewModel;
import use_case.get_matching_strings.GetMatchingStringOutputBoundary;
import use_case.get_matching_strings.GetMatchingStringOutputData;

/**
 * Presenter for formatting and presenting matching strings information.
 * Implements {@link GetMatchingStringOutputBoundary} to handle the output data from the use case layer and update the view model.
 */
public class GetMatchingPresenter implements GetMatchingStringOutputBoundary {
    private final PreferenceViewModel preferenceViewModel;

    /**
     * Constructs a new {@code GetMatchingPresenter} with the specified view model.
     *
     * @param preferenceViewModel the {@code PreferenceViewModel} used to update the preference state and notify changes.
     */
    public GetMatchingPresenter(PreferenceViewModel preferenceViewModel) {
        this.preferenceViewModel = preferenceViewModel;
    }

    /**
     * Prepares the view with the matching strings information.
     * Updates the preference state with the matching strings from {@code GetMatchingStringOutputData} and notifies the view model.
     *
     * @param data the data containing matching strings to be displayed.
     */
    @Override
    public void prepareSuccessView(GetMatchingStringOutputData data){
        PreferenceState state = preferenceViewModel.getState();
        state.setMatchingStrings(data.getMatchingStrings());
        preferenceViewModel.firePropertyChanged("matches");
    }
}
