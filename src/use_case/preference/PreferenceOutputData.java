package use_case.preference;

import entity.preference.UserPreference;

public class PreferenceOutputData {

    private final UserPreference userPreference;

    public PreferenceOutputData(UserPreference userPreference) {
        this.userPreference = userPreference;
    }

    public UserPreference getUserPreference() {
        return userPreference;
    }
}
