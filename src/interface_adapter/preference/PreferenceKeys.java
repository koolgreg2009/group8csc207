package interface_adapter.preference;

/**
 * Represents the keys for user preferences related to breed and location.
 * Provides methods to access the breed key and location key used in preference filtering.
 */
public class PreferenceKeys {
    private String breedKey;
    private String locationKey;

    /**
     * Constructs a new {@code PreferenceKeys} object with the specified breed key and location key.
     *
     * @param breedKey     the key for the breed preference.
     * @param locationKey  the key for the location preference.
     */
    public PreferenceKeys(String breedKey, String locationKey) {
        this.breedKey = breedKey;
        this.locationKey = locationKey;
    }

    /**
     * Gets the breed key associated with the user preferences.
     *
     * @return the breed key as a {@code String}.
     */
    public String getBreedKey() {
        return breedKey;
    }

    /**
     * Gets the location key associated with the user preferences.
     *
     * @return the location key as a {@code String}.
     */
    public String getLocationKey() {
        return locationKey;
    }
}
