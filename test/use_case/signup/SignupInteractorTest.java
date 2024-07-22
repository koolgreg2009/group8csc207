package use_case.signup;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SignupInteractorTest {

    @Mock
    private UserDAOInterface userDAO;

    @Mock
    private SignupOutputBoundary signupPresenter;

    @Mock
    private UserFactory adopterUserFactory;

    @InjectMocks
    private SignupInteractor signupInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserAlreadyExists() {
        // Arrange
        when(userDAO.existsByName(anyString())).thenReturn(true);
        SignupInputData inputData = new SignupInputData("existingUser", "password", "password", "John Doe", "john.doe@example.com", "123-456-7890");

        // Act
        signupInteractor.execute(inputData);

        // Assert
        verify(signupPresenter).prepareFailView("User already exists.");
    }

    @Test
    void testPasswordsDoNotMatch() {
        // Arrange
        when(userDAO.existsByName(anyString())).thenReturn(false);
        SignupInputData inputData = new SignupInputData("newUser", "password", "differentPassword", "John Doe", "john.doe@example.com", "123-456-7890");

        // Act
        signupInteractor.execute(inputData);

        // Assert
        verify(signupPresenter).prepareFailView("Passwords don't match.");
    }

    @Test
    void testSuccessfulSignup() {
        // Arrange
        when(userDAO.existsByName(anyString())).thenReturn(false);
        AdopterUser newUser = new AdopterUser("newUser", "password", "John Doe", "john.doe@example.com", "123-456-7890");
        when(adopterUserFactory.createAdopter(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn(newUser);
        LocalDateTime now = LocalDateTime.now();
        SignupInputData inputData = new SignupInputData("newUser", "password", "password", "John Doe", "john.doe@example.com", "123-456-7890");

        // Act
        signupInteractor.execute(inputData);

        // Assert
        verify(userDAO).save(newUser);
        verify(signupPresenter).prepareSuccessView(new SignupOutputData(newUser.getName(), now.toString(), false));
    }
}
