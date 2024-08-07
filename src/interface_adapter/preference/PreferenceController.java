package interface_adapter.preference;

import entity.preference.UserPreference;
import interface_adapter.SessionManager;
import use_case.preference.PreferenceData;
import use_case.preference.PreferenceInputBoundary; // no PreferenceInputBoundary yet

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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


    public void execute(String species, List<String> breeds, Integer minAge, Integer maxAge, String activityLevel, String location, String gender){

        UserPreference preferences = new UserPreference(species, breeds, minAge, maxAge, activityLevel, location, gender);
        PreferenceData initialPreferences = new PreferenceData(SessionManager.getCurrentUser(), preferences);
        preferenceInteractor.execute(initialPreferences);
    }
}
