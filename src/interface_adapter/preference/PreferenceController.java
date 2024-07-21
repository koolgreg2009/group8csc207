package interface_adapter.preference;

import entity.preference.UserPreference;
import use_case.preference.PreferenceData;
import use_case.preference.PreferenceInputBoundary; // no PreferenceInputBoundary yet


/**
 * This is the Controller for the user's preference profile.
 *
 * @version 1.0
 * @since 2024-07-16
 */

public class PreferenceController {

    private final PreferenceInputBoundary preferenceInteractor; // ???

    /** This is the initializer for PreferenceController
     * @param preferenceInteractor The interactor
     */
    public PreferenceController(PreferenceInputBoundary preferenceInteractor) {
        this.preferenceInteractor = preferenceInteractor;
    }

    /** This method passes the user's inputted initial preferences to the interactor.
     * @param location The user's preferred location
     * @param species The user's preferred species
     * @param breeds The user's preferred breeds
     * @param minAge The user's preferred minimum pet age
     * @param maxAge The user's preferred maximum pet age
     * @param activityLevel The user's preferred pet's activity level
     * @param gender The user's preferred pet gender
     */
    public void execute(String username, UserPreference preferences){
        PreferenceData initialPreferences = new PreferenceData(username, preferences);
        preferenceInteractor.execute(initialPreferences);
    }
}
