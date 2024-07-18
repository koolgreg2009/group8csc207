package use_case.displayAllAvailablePets;

import entity.Preference.UserPreference;


public class displayInputData {
    private final UserPreference preferences;

    public displayInputData(UserPreference preferences){
        this.preferences = preferences;
    }

    public UserPreference getPreferences(){
        return preferences;
    }
}
