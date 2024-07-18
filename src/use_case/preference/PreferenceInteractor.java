package use_case.preference;

/** The PreferenceInteractor class is the interactor for the preference data.
 *
 * @version 1.0
 * @since 2024-07-18
 */

public class PreferenceInteractor implements PreferenceInputBoundary {
    PreferenceData preferences;

    public PreferenceInteractor(PreferenceData preferenceData) {
        this.preferences = preferenceData;
    }

    public void createPreferenceProfile(PreferenceData preferenceData) {
        //???
    }
}
