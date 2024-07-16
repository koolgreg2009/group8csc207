package use_case;

import java.util.List;

/** The PreferenceData class bundles user input data for their Preference profile.
 *
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
     * @param gender
     */

    public PreferenceData(String location, List<String> species, List<String> breeds, int minAge,
                          int maxAge, String activityLevel, String gender) {
        this.location = location;
        this.species = species;
        this.breeds = breeds;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.activityLevel = activityLevel;
        this.gender = gender;
    }

    /** Gets the location that the user set for their search.
     * @return the location as a String.
     */
    String getLocation() {return location;}

    /** Gets the species that the user prefers in their search.
     * @return the species as a List of Strings.
     */
    List<String> getSpecies() {return species;}

    /** Gets the breeds that the user prefers in their search.
     * @return the breeds as a List of Strings.
     */
    List<String> getBreeds() {return breeds;}

    /** Gets the minimum age of pet that the user prefers.
     * @return the minimum age as an int.
     */
    int getMinAge() {return minAge;}

    /** Gets the maximum age of pet that the user prefers.
     * @return the maximum age as an int.
     */
    int getMaxAge() {return maxAge;}

    /** Gets the activity level of pet that the user prefers.
     * @return the activity level as a String.
     */
    String getActivityLevel() {return activityLevel;}

    /** Gets the gender of the pet that the user prefers.
     * @return the gender as a String.
     */
    String getGender() {return gender;}

}
