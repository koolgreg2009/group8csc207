package interface_adapter.preference;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the state of the user's preferences, including various preference settings
 * and any associated errors. This class encapsulates the data needed for managing user
 * preferences and handling validation errors.
 */
public class PreferenceState {
    private String species = "";
    private String breed = "";
    private String minAge = "";
    private String maxAge = "";
    private String activityLevel = "";
    private String location = "";
    private String gender = "";
    private String breedError = "";
    private String minAgeError = "";
    private String maxAgeError = "";
    private String locationError = "";
    private boolean interaction;
    private List<String> matchingStrings = new ArrayList<>();

    /**
     * Gets the breed preference input by the user.
     *
     * @return The breed preference.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Gets the species preference input by the user.
     *
     * @return The species preference.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the minimum age preference input by the user.
     *
     * @return The minimum age preference.
     */
    public String getMinAge() {
        return minAge;
    }

    /**
     * Gets the maximum age preference input by the user.
     *
     * @return The maximum age preference.
     */
    public String getMaxAge() {
        return maxAge;
    }

    /**
     * Gets the activity level preference input by the user.
     *
     * @return The activity level preference.
     */
    public String getActivityLevel() {
        return activityLevel;
    }

    /**
     * Gets the location preference input by the user.
     *
     * @return The location preference.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the gender preference input by the user.
     *
     * @return The gender preference.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the breed preference input by the user.
     *
     * @param breed The breed preference to set.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Sets the species preference input by the user.
     *
     * @param species The species preference to set.
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets the minimum age preference input by the user.
     *
     * @param minAge The minimum age preference to set.
     */
    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    /**
     * Sets the maximum age preference input by the user.
     *
     * @param maxAge The maximum age preference to set.
     */
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * Sets the activity level preference input by the user.
     *
     * @param activityLevel The activity level preference to set.
     */
    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    /**
     * Sets the location preference input by the user.
     *
     * @param location The location preference to set.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the gender preference input by the user.
     *
     * @param gender The gender preference to set.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the error message related to the breed preference.
     *
     * @return The breed error message.
     */
    public String getBreedError() {
        return breedError;
    }

    /**
     * Gets the error message related to the minimum age preference.
     *
     * @return The minimum age error message.
     */
    public String getMinAgeError() {
        return minAgeError;
    }

    /**
     * Gets the error message related to the maximum age preference.
     *
     * @return The maximum age error message.
     */
    public String getMaxAgeError() {
        return maxAgeError;
    }

    /**
     * Gets the error message related to the location preference.
     *
     * @return The location error message.
     */
    public String getLocationError() {
        return locationError;
    }

    /**
     * Sets the error message related to the breed preference.
     *
     * @param breedError The breed error message to set.
     */
    public void setBreedError(String breedError) {
        this.breedError = breedError;
    }

    /**
     * Sets the error message related to the minimum age preference.
     *
     * @param minAgeError The minimum age error message to set.
     */
    public void setMinAgeError(String minAgeError) {
        this.minAgeError = minAgeError;
    }

    /**
     * Sets the error message related to the maximum age preference.
     *
     * @param maxAgeError The maximum age error message to set.
     */
    public void setMaxAgeError(String maxAgeError) {
        this.maxAgeError = maxAgeError;
    }

    /**
     * Sets the error message related to the location preference.
     *
     * @param locationError The location error message to set.
     */
    public void setLocationError(String locationError) {
        this.locationError = locationError;
    }

    /**
     * Gets the list of matching strings used for preference matching.
     *
     * @return The list of matching strings.
     */
    public List<String> getMatchingStrings() {
        return matchingStrings;
    }

    /**
     * Sets the list of matching strings used for preference matching.
     *
     * @param matchingStrings The list of matching strings to set.
     */
    public void setMatchingStrings(List<String> matchingStrings) {
        this.matchingStrings = matchingStrings;
    }

    /**
     * Sets the interaction status.
     *
     * @param interaction The interaction status to set.
     */
    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }

    /**
     * Gets the interaction status.
     *
     * @return The interaction status.
     */
    public boolean isInteraction() {
        return interaction;
    }

    /**
     * Clears all error messages in the preference state.
     */
    public void clearError(){
        breedError = "";
        minAgeError = "";
        maxAgeError = "";
        locationError = "";
    }

}

