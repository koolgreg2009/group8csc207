package interface_adapter.preference;

import entity.preference.UserPreference;
import utils.SessionManager;
import use_case.preference.PreferenceData;
import use_case.preference.PreferenceInputBoundary;
import java.util.*;

/**
 * Controller for managing the user's preference profile.
 * Handles the interaction between the user preference input and the use case logic for updating preferences.
 */
public class PreferenceController {
    private final PreferenceInputBoundary preferenceInteractor; // ???

    /**
     * Constructs a new {@code PreferenceController} with the specified preference interactor.
     *
     * @param preferenceInteractor the {@code PreferenceInputBoundary} used to handle preference updates.
     */
    public PreferenceController(PreferenceInputBoundary preferenceInteractor) {
        this.preferenceInteractor = preferenceInteractor;
    }

    /**
     * Executes the preference use case by creating a {@code UserPreference} object
     * and passing it along with additional data to the interactor.
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
        PreferenceData initialPreferences = new PreferenceData(SessionManager.getInstance().getCurrentUser(), preferences, new PreferenceKeys(breedKey, locationKey));
        preferenceInteractor.execute(initialPreferences);
    }
}
