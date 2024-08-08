package use_case.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.UserFactory;

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
    void testPhoneWrongFormat() {
        // Arrange
        when(userDAO.existsByName(anyString())).thenReturn(false);
        AdopterUser newUser = new AdopterUser("newUser", "password", "John Doe", "john.doe@example.com", "123-456-7890");
        when(adopterUserFactory.createAdopter(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn(newUser);
        SignupInputData inputData = new SignupInputData("newUser", "password", "password", "John Doe", "john.doe@example.com", "123-456-7890");

        // Act
        signupInteractor.execute(inputData);

        // Assert
        verify(signupPresenter).prepareFailView("Invalid phone number.");
    }

    @Test
    void testSuccessfulSignup() {
        // Arrange
        when(userDAO.existsByName(anyString())).thenReturn(false);
        AdopterUser newUser = new AdopterUser("newUser", "password", "John Doe", "john.doe@example.com", "1234567890");
        when(adopterUserFactory.createAdopter(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn(newUser);
        LocalDateTime now = LocalDateTime.now();
        SignupInputData inputData = new SignupInputData("newUser", "password", "password", "John Doe", "john.doe@example.com", "1234567890");

        // Act
        signupInteractor.execute(inputData);
		ArgumentCaptor<SignupOutputData> outputCaptor = ArgumentCaptor.forClass(SignupOutputData.class);
		verify(signupPresenter).prepareSuccessView(outputCaptor.capture());


        // Assert
        verify(userDAO).save(newUser);
		SignupOutputData output = outputCaptor.getValue();
		assertEquals("newUser", output.getUsername());
    }
}
