package interface_adapter.preference;

import use_case.preference.PreferenceOutputBoundary;
import use_case.preference.PreferenceOutputData;

public class PreferencePresenter implements PreferenceOutputBoundary {

    @Override
    public void preparePreferenceView(PreferenceOutputData preferenceOutputData){
        System.out.println(preferenceOutputData.getUserPreference());
    }
}
