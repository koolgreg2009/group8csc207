package use_case.display_all_available_pets;

import entity.preference.UserPreference;
import entity.user.User;

/**
 * Encapsulates the input data required to display all pets for a specific user.
 *
 * <p>This class stores the user identifier and provides a method to access this user identifier.
 */
public class DisplayAllPetsInputData {
    private final String user;

    /**
     * Constructs a {@code DisplayAllPetsInputData} object with the specified user identifier.
     *
     * @param user the identifier of the user
     */
    public DisplayAllPetsInputData(String user){
        this.user = user;
    }

    /**
     * Returns the identifier of the user.
     *
     * @return the user identifier
     */
    public String getUser(){
        return this.user;
    }
}
