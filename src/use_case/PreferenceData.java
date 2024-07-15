package use_case;

import java.util.List;

/** The PreferenceData class bundles user input data for their Preference profile.
 *
 * @author Jane Li
 * @version 1.0
 * @since 2024-07-15
 */
public class PreferenceData {

    private String location; // location user wants to adopt pet
    private List<String> species; // species the user is willing to consider
    private List<String> breeds;
    private int minAge;
    private int maxAge;
    private String activityLevel;
    private String gender;

    /** This is the initializer for PreferenceData.
     * @param location
     * @param species
     * @param breeds
     * @param minAge
     * @param maxAge
     * @param activityLevel
     */
    public PreferenceData(String location, List<String> species, List<String> breeds, int minAge,
                          int maxAge, String activityLevel) {
        this.location = location;
        this.species = species;
        this.breeds = breeds;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.activityLevel = activityLevel;
        this.gender = gender;
    }

    /**
     * Returns the location that the user set for their search.
     * @return the location as a String.
     */
    String getLocation() {return location;}

    /**
     * Returns the species that the user prefers in their search.
     * @return the species as a List of Strings.
     */
    List<String> getSpecies() {return species;}

    /**
     * Returns the breeds that the user prefers in their search.
     * @return the breeds as a List of Strings.
     */
    List<String> getBreeds() {return breeds;}

    /**
     * Returns the minimum age of pet that the user prefers.
     * @return the minimum age as an int.
     */
    int getMinAge() {return minAge;}

    /**
     * Returns the maximum age of pet that the user prefers.
     * @return the maximum age as an int.
     */
    int getMaxAge() {return maxAge;}

    /**
     * Returns the activity level of pet that the user prefers.
     * @return the activity level as a String.
     */
    String getActivityLevel() {return activityLevel;}

    /**
     * Returns the gender of the pet that the user prefers.
     * @return the gender as a String.
     */
    String getGender() {return gender;}

}
