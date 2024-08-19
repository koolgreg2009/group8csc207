package interface_adapter.preference;

public class PreferenceKeys {
    private String breedKey;
    private String locationKey;

    public PreferenceKeys(String breedKey, String locationKey) {
        this.breedKey = breedKey;
        this.locationKey = locationKey;
    }
    public String getBreedKey() {
        return breedKey;
    }
    public String getLocationKey() {
        return locationKey;
    }
}
