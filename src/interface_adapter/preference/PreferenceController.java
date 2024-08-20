package interface_adapter.preference;

import entity.preference.UserPreference;
import interface_adapter.SessionManager;
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
     * @param species       the indicated species preference as a {@code String}.
     * @param breeds        a {@code List<String>} of indicated breed preferences.
     * @param breedKey      a {@code String} representing the breed key.
     * @param minAge        an {@code Integer} specifying the minimum age preference.
     * @param maxAge        an {@code Integer} specifying the maximum age preference.
     * @param activityLevel a {@code String} indicating the preferred activity level (e.g., high, medium, low).
     * @param location      a {@code String} representing the location preference.
     * @param locationKey   a {@code String} representing the location key.
     * @param gender        a {@code String} of either 'M' or 'F' to indicate preferred gender.
     */
    public void execute(String species, List<String> breeds, String breedKey, Integer minAge, Integer maxAge, String activityLevel, String location, String locationKey, String gender){
        UserPreference preferences = new UserPreference(species, breeds, minAge, maxAge, activityLevel, location, gender);
        PreferenceData initialPreferences = new PreferenceData(SessionManager.getCurrentUser(), preferences, new PreferenceKeys(breedKey, locationKey));
        preferenceInteractor.execute(initialPreferences);
    }
}
