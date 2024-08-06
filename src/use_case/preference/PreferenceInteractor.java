package use_case.preference;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.User;

/** This is the interactor for the use case of editing an adopter user's pet preference data.
 *
 * @version 2.0
 * @since 2024-07-18
 */
public class PreferenceInteractor implements PreferenceInputBoundary {
    final UserDAOInterface userDataAccessObject;
    final PreferenceOutputBoundary userPresenter;

    /** This is the constructor for editing preferences.
     *
     * @param userDataAccessObject Access object for the adopter user that you are changing preferences for
     * @param preferenceOutputBoundary output boundary for new preferences to be passed through and presented
     */
    public PreferenceInteractor(UserDAOInterface userDataAccessObject,
                                PreferenceOutputBoundary preferenceOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = preferenceOutputBoundary;
    }

    /** Executes the use case to edit the adopter user's preferences.
     *
     * @param preferenceData is the preference data for the adopter user which is trying to edit preferences
     */
    @Override
    public void execute(PreferenceData preferenceData){
        User user = userDataAccessObject.get(preferenceData.getUsername());

        ((AdopterUser) user).setPreferences(preferenceData.getUserPreference());

        userDataAccessObject.save(user);
        PreferenceOutputData outputData = new PreferenceOutputData(((AdopterUser) user).getPreferences());
        userPresenter.preparePreferenceView(outputData);
    }

}
