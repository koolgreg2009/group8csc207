package use_case.signup;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit test for the {@link SignupInteractor} class.
 * This class tests the functionality of the {@link SignupInteractor}'s execute method
 * which handles user signup logic, including validation and creation of new users.
 */
class SignupInteractorTest {
    private UserDAOInterface userDAO;
    private SignupOutputBoundary presenter;
    private UserFactory userFactory;
    private SignupInteractor interactor;

    /**
     * Sets up the test environment by initializing mocks and the {@link SignupInteractor} instance
     * before each test.
     */
    @BeforeEach
    void setUp() {
        userDAO = Mockito.mock(UserDAOInterface.class);
        presenter = Mockito.mock(SignupOutputBoundary.class);
        userFactory = Mockito.mock(UserFactory.class);
        interactor = new SignupInteractor(userDAO, presenter, userFactory);
    }

    @Test
    void testExecuteEmptyUsername() {
        SignupInputData inputData = new SignupInputData("", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Username cannot be empty.");
    }

    @Test
    void testExecuteEmptyPassword() {
        SignupInputData inputData = new SignupInputData("john", "", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Password cannot be empty.");
    }

    @Test
    void testExecuteEmptyRepeatPassword() {
        SignupInputData inputData = new SignupInputData("john", "password", "", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Repeat password cannot be empty.");
    }

    @Test
    void testExecuteEmptyName() {
        SignupInputData inputData = new SignupInputData("john", "password", "password", "", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Your name cannot be empty.");
    }

    @Test
    void testExecuteUsernameAlreadyExists() {
        when(userDAO.existsByName("john")).thenReturn(true);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Username already exists.");
    }

    @Test
    void testExecuteEmailAlreadyExists() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(true);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Email already in use.");
    }

    @Test
    void testExecutePhoneAlreadyExists() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(true);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Phone number already in use.");
    }

    @Test
    void testExecutePasswordsDoNotMatch() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(false);

        SignupInputData inputData = new SignupInputData("john", "password", "differentPassword", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Passwords don't match.");
    }

    @Test
    void testExecuteInvalidEmail() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(false);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "invalid-email", "1234567890");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Invalid email address.");
    }

    @Test
    void testExecuteInvalidPhone() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(false);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "invalid-phone");
        interactor.execute(inputData);

        verify(presenter).prepareFailView("Invalid phone number.");
    }

    @Test
    void testExecuteSuccessfulSignup() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(false);

        AdopterUser user = new AdopterUser("john", "password", "John Doe", "john@example.com", "1234567890");
        when(userFactory.createAdopter("john", "password", "John Doe", "john@example.com", "1234567890")).thenReturn(user);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<SignupOutputData> argumentCaptor = ArgumentCaptor.forClass(SignupOutputData.class);
        verify(presenter).prepareSuccessView(argumentCaptor.capture());

        SignupOutputData outputData = argumentCaptor.getValue();
        assertEquals("john", outputData.getUsername());
    }
}
