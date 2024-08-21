package use_case.login;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import data_access.UserDAOInterface;
import entity.user.AdopterUser;

/**
 * Unit tests for the {@link LoginInteractor} use case class.
 * This class verifies the behavior of the {@link LoginInteractor} class's execute method
 * for handling login scenarios including non-existent users, incorrect passwords, and successful logins.
 */
class LoginInteractorTest {

    @Mock
    private UserDAOInterface userDAO;

    @Mock
    private LoginOutputBoundary loginPresenter;

    @InjectMocks
    private LoginInteractor loginInteractor;

    /**
     * Initializes the mock objects and the {@link LoginInteractor} instance before each test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the {@link LoginInteractor#execute(LoginInputData)} method when the user does not exist in the system.
     * Verifies that the method correctly handles the case where the user account does not exist
     * and updates the presenter with an appropriate failure message.
     */
    @Test
    void testUserDoesNotExist() {
        when(userDAO.existsByName(anyString())).thenReturn(false);
        LoginInputData inputData = new LoginInputData("nonexistentUser", "password");

        loginInteractor.execute(inputData);

        verify(loginPresenter).prepareFailView("The account 'nonexistentUser' does not exist.");
    }

    /**
     * Tests the {@link LoginInteractor#execute(LoginInputData)} method when the user exists but provides an incorrect password.
     * Verifies that the method correctly handles the case where the password is incorrect
     * and updates the presenter with an appropriate failure message.
     */
    @Test
    void testIncorrectPassword() {
        AdopterUser adopterUser = new AdopterUser("existingUser", "correctPassword", "John Doe", "john.doe@example.com", "123-456-7890");
        when(userDAO.existsByName(anyString())).thenReturn(true);
        when(userDAO.get(anyString())).thenReturn(adopterUser);
        LoginInputData inputData = new LoginInputData("existingUser", "wrongPassword");

        loginInteractor.execute(inputData);

        verify(loginPresenter).prepareFailView("Incorrect password for existingUser.");
    }

    /**
     * Tests the {@link LoginInteractor#execute(LoginInputData)} method when the user exists and provides the correct password.
     * Verifies that the method correctly handles the successful login scenario
     * and updates the presenter with a success view containing the username.
     */
    @Test
    void testSuccessfulLogin() {
        AdopterUser adopterUser = new AdopterUser("existingUser", "correctPassword", "John Doe", "john.doe@example.com", "123-456-7890");
        when(userDAO.existsByName("existingUser")).thenReturn(true);
        when(userDAO.get("existingUser")).thenReturn(adopterUser);
        LoginInputData inputData = new LoginInputData("existingUser", "correctPassword");
        loginInteractor.execute(inputData);

        ArgumentCaptor<LoginOutputData> captor = ArgumentCaptor.forClass(LoginOutputData.class);
        verify(loginPresenter).prepareSuccessView(captor.capture());

        LoginOutputData capturedOutputData = captor.getValue();
        assertEquals("existingUser", capturedOutputData.getUsername());
    }
}
