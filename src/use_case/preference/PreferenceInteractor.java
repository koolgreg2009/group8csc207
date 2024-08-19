package use_case.preference;

import data_access.APIInfoInterface;
import data_access.UserDAOInterface;
import entity.preference.UserPreference;
import entity.user.AdopterUser;
import entity.user.User;
import interface_adapter.preference.PreferenceKeys;

/** This is the interactor for the use case of editing an adopter user's pet preference data.
 *
 * @version 2.0
 * @since 2024-07-18
 */
public class PreferenceInteractor implements PreferenceInputBoundary {
    final UserDAOInterface userDataAccessObject;
    final PreferenceOutputBoundary userPresenter;
    final APIInfoInterface infoDAO;


    /** This is the constructor for editing preferences.
     *
     * @param userDataAccessObject Access object for the adopter user that you are changing preferences for
     * @param userPresenter presenter for preference use case
     * @param infoDAO  DAO for accessing pet data info
     */
    public PreferenceInteractor(UserDAOInterface userDataAccessObject,
                                PreferenceOutputBoundary userPresenter,
                                APIInfoInterface infoDAO) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.infoDAO = infoDAO;
    }

    /** Executes the use case to edit the adopter user's preferences.
     *
     * @param preferenceData is the preference data for the adopter user which is trying to edit preferences
     * Checks if any of the fields are invalid. Then if both are true then store preference.
     */
    @Override
    public void execute(PreferenceData preferenceData){
        PreferenceKeys keys = preferenceData.getKeys();
        UserPreference preference = preferenceData.getUserPreference();
        if(!preference.getBreeds().isEmpty() && !infoDAO.exists(preference.getBreeds(), keys.getBreedKey())){
            userPresenter.prepareBreedFail();
        }
        if(!preference.getLocation().isEmpty() && !infoDAO.exists(preference.getLocation(), keys.getLocationKey())){
            userPresenter.prepareLocationFail();
        }
        if (infoDAO.exists(preference.getBreeds(), keys.getBreedKey()) && !infoDAO.exists(preference.getLocation(), keys.getLocationKey())) {
            User user = userDataAccessObject.get(preferenceData.getUsername());
            ((AdopterUser) user).setPreferences(preference);
            userDataAccessObject.save(user);
            userPresenter.prepareSuccessView();
        }
    }
}
