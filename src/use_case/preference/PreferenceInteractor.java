package use_case.preference;

import data_access.APIInfoInterface;
import data_access.UserDAOInterface;
import entity.preference.UserPreference;
import entity.user.AdopterUser;
import entity.user.User;
import interface_adapter.preference.PreferenceKeys;

/**
 * {@code PreferenceInteractor} is the interactor for the use case of editing an adopter user's pet preference data.
 * It implements the {@code PreferenceInputBoundary} interface and handles the logic for updating user preferences.
 */
public class PreferenceInteractor implements PreferenceInputBoundary {
    final UserDAOInterface userDataAccessObject;
    final PreferenceOutputBoundary userPresenter;
    final APIInfoInterface infoDAO;


    /**
     * Constructs a {@code PreferenceInteractor} with the specified data access objects and presenter.
     *
     * @param userDataAccessObject  the data access object for the adopter user whose preferences are being changed.
     * @param userPresenter         the presenter for the preference use case.
     * @param infoDAO               the data access object for accessing pet data information.
     */
    public PreferenceInteractor(UserDAOInterface userDataAccessObject,
                                PreferenceOutputBoundary userPresenter,
                                APIInfoInterface infoDAO) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.infoDAO = infoDAO;
    }

    /**
     * Executes the use case to edit the adopter user's preferences.
     * <p>
     * Checks if the provided preferences are valid. If any of the fields are invalid, it prepares a failure view.
     * If both breed and location preferences are valid, it updates the user's preferences and prepares a success view.
     *
     * @param preferenceData the preference data for the adopter user attempting to edit their preferences.
     */
    @Override
    public void execute(PreferenceData preferenceData){
        boolean condition1 = true;
        boolean condition2 = true;
        PreferenceKeys keys = preferenceData.getKeys();
        UserPreference preference = preferenceData.getUserPreference();
        if(!preference.getBreeds().isEmpty() && !infoDAO.exists(preference.getBreeds(), keys.getBreedKey())){
            userPresenter.prepareBreedFail();
            condition1 = false;
        }
        if(!preference.getLocation().isEmpty() && !infoDAO.exists(preference.getLocation(), keys.getLocationKey())){
            userPresenter.prepareLocationFail();
            condition2 = false;
        }
        if (condition1 && condition2) {
            User user = userDataAccessObject.get(preferenceData.getUsername());
            ((AdopterUser) user).setPreferences(preference);
            userDataAccessObject.save(user);
            userPresenter.prepareSuccessView();
        }
    }
}
