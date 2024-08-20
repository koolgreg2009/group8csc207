package use_case.preference;

import entity.preference.UserPreference;
import interface_adapter.preference.PreferenceKeys;

import java.util.List;
import java.util.Map;

/**
 * The {@code PreferenceData} class bundles user input data for their preference profile
 * after the user creates their profile.
 */
public class PreferenceData {

    private UserPreference userPreference;
    private String username;
    private PreferenceKeys keys;

    /**
     * Constructs a {@code PreferenceData} object with the specified username, user preferences, and preference keys.
     *
     * @param username        the username of the user.
     * @param userPreference  the set of user preferences as established in the entity package.
     * @param keys            the preference keys associated with the user.
     */
    public PreferenceData(String username, UserPreference userPreference, PreferenceKeys keys) {
        this.userPreference = userPreference;
        this.username = username;
        this.keys = keys;
    }

    /**
     * Returns the user preferences of the specified user.
     *
     * @return the user preferences as a {@code UserPreference} object.
     */
    public UserPreference getUserPreference() {
        return userPreference;
    }

    /**
     * Returns the username of the user.
     *
     * @return a {@code String} representing the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the preference keys associated with the user.
     *
     * @return the {@code PreferenceKeys} object associated with the user.
     */
    public PreferenceKeys getKeys() {
        return keys;
    }
}
