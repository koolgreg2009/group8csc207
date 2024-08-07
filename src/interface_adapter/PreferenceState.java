package interface_adapter;

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


    private String error = "";
    /**
     * Constructs a new PreferenceState as a copy of the provided PreferenceState.
     *
     * @param copy to create a copy of the preferences
     */
    public PreferenceState(PreferenceState copy) {
        species = copy.species;
//        usernameError = copy.usernameError;
        breed = copy.breed;
//        passwordError = copy.passwordError;
        minAge = copy.minAge;
//        passwordError = copy.passwordError;
        maxAge = copy.maxAge;
//        passwordError = copy.passwordError;
        activityLevel = copy.activityLevel;
//        passwordError = copy.passwordError;
        location = copy.location;
//        passwordError = copy.passwordError;
        gender = copy.gender;
//        passwordError = copy.passwordError;
        error = copy.error;
    }

    /**
     * Constructs a new LoginState with default values.
     */
    public PreferenceState() {} // Because of the previous copy constructor, the default constructor must be explicit.

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


    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
}
