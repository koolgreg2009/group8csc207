package use_case.preference;

import entity.preference.UserPreference;

/** The InitialPreferenceData class bundles user input data for their Preference profile
 * after they create profile.
 *
 * @version 2.0
 * @since 2024-07-16
 */
public class PreferenceData {

    private UserPreference userPreference;
    private String username;

    /** This is the initializer for class PreferenceData
     * @param userPreference This is the set of user preferences as established in the
     *                       entity package.
     * @param username This is the username of the adopter user.
     */

    public PreferenceData(String username, UserPreference userPreference) {
        this.userPreference = userPreference;
        this.username = username;
    }

    /** Gets the user preferences of the specified user.
     * @return the user preferences as a UserPreference object.
     */
    public UserPreference getUserPreference() {
        return userPreference;
    }

    /** Gets the username of the adopter.
     * @return a String of the adopter's username.
     */
    public String getUsername() {
        return username;
    }

}
