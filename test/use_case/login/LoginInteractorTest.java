package use_case.login;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;

class LoginInteractorTest {

    @Mock
    private UserDAOInterface userDAO;

    @Mock
    private LoginOutputBoundary loginPresenter;

    @InjectMocks
    private LoginInteractor loginInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserDoesNotExist() {
        // Arrange
        when(userDAO.existsByName(anyString())).thenReturn(false);
        LoginInputData inputData = new LoginInputData("nonexistentUser", "password");

        // Act
        loginInteractor.execute(inputData);

        // Assert
        verify(loginPresenter).prepareFailView("nonexistentUser: Account does not exist.");
    }

    @Test
    void testIncorrectPassword() {
        // Arrange
        AdopterUser adopterUser = new AdopterUser("existingUser", "correctPassword", "John Doe", "john.doe@example.com", "123-456-7890");
        when(userDAO.existsByName(anyString())).thenReturn(true);
        when(userDAO.get(anyString())).thenReturn(adopterUser);
        LoginInputData inputData = new LoginInputData("existingUser", "wrongPassword");

        // Act
        loginInteractor.execute(inputData);

        // Assert
        verify(loginPresenter).prepareFailView("Incorrect password for existingUser.");
    }

    @Test
    void testSuccessfulLogin() {
        // Arrange
        AdopterUser adopterUser = new AdopterUser("existingUser", "correctPassword", "John Doe", "john.doe@example.com", "123-456-7890");
        when(userDAO.existsByName(anyString())).thenReturn(true);
        when(userDAO.get(anyString())).thenReturn(adopterUser);
        LoginInputData inputData = new LoginInputData("existingUser", "correctPassword");

        // Act
        loginInteractor.execute(inputData);

        // Assert
        verify(loginPresenter).prepareSuccessView(new LoginOutputData("existingUser"));
    }
}
