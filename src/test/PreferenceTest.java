package test;

import data_access.FileUserDAO;
import entity.preference.UserPreference;
import entity.user.AdopterUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.preference.PreferenceData;
import use_case.preference.PreferenceInteractor;
import use_case.preference.PreferenceOutputBoundary;
import use_case.preference.PreferenceOutputData;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PreferenceTest {

    private File tempFile;
    private FileUserDAO userDAO;
    private PreferenceInteractor interactor;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = File.createTempFile("test_users", ".json");
        userDAO = new FileUserDAO(tempFile.getPath());
        PreferenceOutputBoundary presenter = new PreferenceOutputBoundary() {
            @Override
            public void preparePreferenceView(PreferenceOutputData outputData) {
            }
        };
        interactor = new PreferenceInteractor(userDAO, presenter);
    }

    @AfterEach
    void tearDown() {
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void execute_shouldUpdateUserPreferences() {
        String username = "testUser";
        AdopterUser user = new AdopterUser(username, "password", "name", "email", "phone");
        userDAO.save(user);

        UserPreference newPreferences = new UserPreference();
        PreferenceData preferenceData = new PreferenceData(username, newPreferences);

        interactor.execute(preferenceData);

        User updatedUser = userDAO.get(username);
        assertNotNull(updatedUser);
        assertInstanceOf(AdopterUser.class, updatedUser);
        assertEquals(newPreferences, ((AdopterUser) updatedUser).getPreferences());
    }
}
