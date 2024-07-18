package use_case.preference;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;

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
     * @param signupOutputBoundary output boundary for new preferences to be passed through and presented
     */
    public PreferenceInteractor(UserDAOInterface userDataAccessObject,
                                PreferenceOutputBoundary signupOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = signupOutputBoundary;
    }

    /** Executes the use case to edit the adopter user's preferences.
     *
     * @param PreferenceData is the preference data for the adopter user which is trying to edit preferences
     */
    @Override
    public void execute(PreferenceData PreferenceData){
        AdopterUser user = userDataAccessObject.get(PreferenceData.getUsername());

        user.setPreferences(PreferenceData.getPreference());

        userDataAccessObject.save(user);

        System.out.println(user.getUsername() + " preferences have been updated");
    }

}
