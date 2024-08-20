package use_case.preference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data_access.UserDAOInterface;
import entity.preference.UserPreference;
import entity.user.AdopterUser;

/**
 * Unit test for the {@link PreferenceInteractor} class.
 * This class tests the functionality of the {@link PreferenceInteractor}'s execute method
 * which is responsible for editing user preferences.
 */
class PreferenceInteractorTest {

    private UserDAOInterface userDataAccessObject;
    private PreferenceOutputBoundary userPresenter;
    private PreferenceInteractor interactor;

    /**
     * Sets up the test environment, initializing the {@link PreferenceInteractor} instance
     * with mocked dependencies before each test.
     */
    @BeforeEach
    void setUp() {
        userDataAccessObject = mock(UserDAOInterface.class);
        userPresenter = mock(PreferenceOutputBoundary.class);
        interactor = new PreferenceInteractor(userDataAccessObject, userPresenter, null);
    }

    /**
     * Tests the {@link PreferenceInteractor#execute(PreferenceData)} method for successfully editing
     * user preferences.
     *
     * The test verifies that:
     * 1. The user is fetched from the mock DAO.
     * 2. The user's preferences are updated and saved.
     * 3. The presenter is called to prepare a success view.
     * 4. The updated preferences are correctly set on the user object.
     */
    @Test
    void testEditUserPreferencesSuccess() {
        // Given
        String username = "testUser";
        UserPreference newPreferences = new UserPreference("Cat", List.of("British Shorthair"), 1, 5, "Low", "New York", "Female");
        AdopterUser user = new AdopterUser(username, "password", "Test Name", "test@example.com", "1234567890");
        when(userDataAccessObject.get(username)).thenReturn(user);

        PreferenceData inputData = new PreferenceData(username, newPreferences, null);

        interactor.execute(inputData);

        verify(userDataAccessObject).get(username);
        verify(userDataAccessObject).save(user);
        verify(userPresenter).prepareSuccessView();

        assertEquals(newPreferences, user.getPreferences());
    }
}