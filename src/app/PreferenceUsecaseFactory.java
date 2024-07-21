package app;

import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import interface_adapter.preference.PreferenceController;
import interface_adapter.preference.PreferencePresenter;
import use_case.preference.PreferenceInputBoundary;
import use_case.preference.PreferenceInteractor;
import use_case.preference.PreferenceOutputBoundary;

import java.io.IOException;

/**
 * Preference Usecase factory which takes all the data and returns a Preference controller
 */
public class PreferenceUsecaseFactory {

    /**
     * Constructor for Preference usecase factory which takes all the info the json path and gives a new preference
     * controller, and catches IO exceptions in case that occurs with the file reading.
     *
     * @return the new preference controller or null if IOException is caught
     */
    public static PreferenceController createPreferenceUsecase() {
        try {
            UserDAOInterface userDAO = new FileUserDAO("./users.json");
            PreferenceOutputBoundary preferencePresenter = new PreferencePresenter();
            PreferenceInputBoundary preferenceInteractor = new PreferenceInteractor(userDAO,preferencePresenter);
            return new PreferenceController(preferenceInteractor);

        }
        catch (IOException e) {
            System.out.println("Could not open user data file");
            return null;
        }
    }
}
