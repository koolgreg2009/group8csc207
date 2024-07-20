package use_case.display_all_available_pets;

import entity.preference.UserPreference;


public class DisplayAllPetsInputData {
    private final UserPreference preferences;

    public DisplayAllPetsInputData(UserPreference preferences){
        this.preferences = preferences;
    }

    public UserPreference getPreferences(){
        return preferences;
    }
}
