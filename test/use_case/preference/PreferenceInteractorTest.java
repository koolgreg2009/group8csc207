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

class PreferenceInteractorTest {

    private UserDAOInterface userDataAccessObject;
    private PreferenceOutputBoundary userPresenter;
    private PreferenceInteractor interactor;

    @BeforeEach
    void setUp() {
        userDataAccessObject = mock(UserDAOInterface.class);
        userPresenter = mock(PreferenceOutputBoundary.class);
        interactor = new PreferenceInteractor(userDataAccessObject, userPresenter, null);
    }

    @Test
    void testEditUserPreferencesSuccess() {
        // Given
        String username = "testUser";
        UserPreference newPreferences = new UserPreference("Cat", List.of("British Shorthair"), 1, 5, "Low", "New York", "Female");
        AdopterUser user = new AdopterUser(username, "password", "Test Name", "test@example.com", "1234567890");
        when(userDataAccessObject.get(username)).thenReturn(user);

        // Prepare input data
        PreferenceData inputData = new PreferenceData(username, newPreferences, null);

        // Execute the use case
        interactor.execute(inputData);

        // Verify that the preferences were updated and saved
        verify(userDataAccessObject).get(username);
        verify(userDataAccessObject).save(user);
        verify(userPresenter).prepareSuccessView();

        // Verify the user's preferences were updated
        assertEquals(newPreferences, user.getPreferences());
    }
}