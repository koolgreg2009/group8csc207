package interface_adapter.preference;

import entity.preference.UserPreference;
import interface_adapter.SessionManager;
import use_case.preference.PreferenceData;
import use_case.preference.PreferenceInputBoundary; // no PreferenceInputBoundary yet

import java.util.*;

import static java.util.stream.Collectors.toList;


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

    /**
     * The execution for the preference use case
     *
     * @param species       the indicated species preference as a String
     * @param breeds        the indicated breed
     * @param minAge        an Integer for the minimum age preferences
     * @param maxAge        an Integer for the maximum age preference
     * @param activityLevel a String indicated either a high, medium or low preferred activity level
     * @param location      a String that shows location preference
     * @param gender        a String of either 'M' or 'F' to indicate which gender they would prefer
     * @param locationKey   string to indicate to interactor what to read to validate location
     * @param breedKey      string to indicate to interactor what to read to validate breed
     */
    public void execute(String species, List<String> breeds, String breedKey, Integer minAge, Integer maxAge, String activityLevel, String location, String locationKey, String gender){
        UserPreference preferences = new UserPreference(species, breeds, minAge, maxAge, activityLevel, location, gender);
        PreferenceData initialPreferences = new PreferenceData(SessionManager.getCurrentUser(), preferences, new PreferenceKeys(breedKey, locationKey));
        preferenceInteractor.execute(initialPreferences);
    }
}
