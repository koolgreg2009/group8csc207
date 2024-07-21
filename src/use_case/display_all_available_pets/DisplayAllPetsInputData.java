package use_case.display_all_available_pets;

import entity.preference.UserPreference;
import entity.user.User;


public class DisplayAllPetsInputData {
    private final String user;

    public DisplayAllPetsInputData(String user){
        this.user = user;
    }

    public String getUser(){
        return this.user;
    }
}
