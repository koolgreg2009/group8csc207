package use_case.preference;

import entity.preference.UserPreference;

/**
 * Encapsulates the output data for user preferences.
 *
 * <p>This class stores the user preferences and provides a method to access these preferences.
 */
public class PreferenceOutputData {
    private final UserPreference userPreference;

    /**
     * Constructs a {@code PreferenceOutputData} object with the specified user preferences.
     *
     * @param userPreference the user preferences to be stored
     */
    public PreferenceOutputData(UserPreference userPreference) {
        this.userPreference = userPreference;
    }

    /**
     * Returns the user preferences.
     *
     * @return the user preferences
     */
    public UserPreference getUserPreference() {
        return userPreference;
    }
}
