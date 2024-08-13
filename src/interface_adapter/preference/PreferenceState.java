package interface_adapter.preference;

import view.PreferenceTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the state of the login view model, including user credentials
 * and any associated errors. This class encapsulates the data needed for
 * managing the login state and handling user input validation.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class PreferenceState {


    private String species = "";

    private String breed = "";

    private String minAge = "";

    private String maxAge = "";

    private String activityLevel = "";

    private String location = "";

    private String gender = "";

    private String speciesError = "";
    private String breedError = "";
    private String minAgeError = "";
    private String maxAgeError = "";
    private String activityLevelError = "";
    private String locationError = "";
    private String genderError = "";
    private boolean interaction;
    private List<String> matchingStrings = new ArrayList<>();
    private PreferenceTextView currentInputField;

    /**
     * Constructs a new LoginState with default values.
     */
    /**
     * Gets the username input by the user.
     *
     * @return The username.
     */
    public String getBreed() {
        return breed;
    }


    /**
     * Gets the species input by the user.
     *
     * @return The species.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the minimum age input by the user.
     *
     * @return The minimum age the user wants
     */
    public String getMinAge() {
        return minAge;
    }

    /**
     * Gets the maximum age input by the user.
     *
     * @return The maximum age the user wants
     */
    public String getMaxAge() {
        return maxAge;
    }

    /**
     * Gets the activity level input by the user.
     *
     * @return The activity level input
     */
    public String getActivityLevel() {
        return activityLevel;
    }

    /**
     * Gets the location input by the user.
     *
     * @return The location input
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the activity level input by the user.
     *
     * @return The activity level input
     */
    public String getGender() {
        return gender;
    }


    /**
     * Sets the breed input by the user.
     *
     * @param breed The breed preference set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }


    /**
     * Sets the species input by the user.
     *
     * @param species the species preference set
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets the species input by the user.
     *
     * @param minAge the minimum age preference set
     */
    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    /**
     * Sets the species input by the user.
     *
     * @param maxAge the minimum age preference set
     */
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    /**
     * Sets the species input by the user.
     *
     * @param activityLevel the minimum age preference set
     */
    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    /**
     * Sets the species input by the user.
     *
     * @param location the minimum age preference set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the species input by the user.
     *
     * @param gender the minimum age preference set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setCurrentInputField(PreferenceTextView currentInputField){
        this.currentInputField = currentInputField;
    }
    public String getSpeciesError() {
        return speciesError;
    }
    public String getBreedError() {
        return breedError;
    }
    public String getMinAgeError() {
        return minAgeError;
    }
    public String getMaxAgeError() {
        return maxAgeError;
    }
    public String getActivityLevelError() {
        return activityLevelError;
    }
    public String getLocationError() {
        return locationError;
    }
    public String getGenderError() {
        return genderError;
    }
    public void setSpeciesError(String speciesError) {
        this.speciesError = speciesError;
    }
    public void setBreedError(String breedError) {
        this.breedError = breedError;
    }
    public void setMinAgeError(String minAgeError) {
        this.minAgeError = minAgeError;
    }
    public void setMaxAgeError(String maxAgeError) {
        this.maxAgeError = maxAgeError;
    }
    public void setActivityLevelError(String activityLevelError) {
        this.activityLevelError = activityLevelError;
    }
    public void setLocationError(String locationError) {
        this.locationError = locationError;
    }
    public void setGenderError(String genderError) {
        this.genderError = genderError;
    }
    public List<String> getMatchingStrings() {
        return matchingStrings;
    }
    public void setMatchingStrings(List<String> matchingStrings) {
        this.matchingStrings = matchingStrings;
    }
    public void setInteraction(boolean interaction) {
        this.interaction = interaction;
    }
    public boolean isInteraction() {
        return interaction;
    }

}
