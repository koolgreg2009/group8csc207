package use_case.display_all_available_pets;

import entity.preference.UserPreference;


public class displayInputData {
    private final UserPreference preferences;

    public displayInputData(UserPreference preferences){
        this.preferences = preferences;
    }

    public UserPreference getPreferences(){
        return preferences;
    }
}
