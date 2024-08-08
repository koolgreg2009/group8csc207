package use_case.signup;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SignupInteractorTest {
    private UserDAOInterface userDAO;
    private SignupOutputBoundary presenter;
    private UserFactory userFactory;
    private SignupInteractor interactor;

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

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Username cannot be empty.", errorMessage);
    }

    @Test
    void testExecuteEmptyPassword() {
        SignupInputData inputData = new SignupInputData("john", "", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Password cannot be empty.", errorMessage);
    }

    @Test
    void testExecuteEmptyRepeatPassword() {
        SignupInputData inputData = new SignupInputData("john", "password", "", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Repeat Password cannot be empty.", errorMessage);
    }

    @Test
    void testExecuteEmptyName() {
        SignupInputData inputData = new SignupInputData("john", "password", "password", "", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Your name cannot be empty.", errorMessage);
    }

    @Test
    void testExecuteUsernameAlreadyExists() {
        when(userDAO.existsByName("john")).thenReturn(true);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Username already exists.", errorMessage);
    }

    @Test
    void testExecuteEmailAlreadyExists() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(true);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Email already in use.", errorMessage);
    }

    @Test
    void testExecutePhoneAlreadyExists() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(true);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Phone number already in use.", errorMessage);
    }

    @Test
    void testExecutePasswordsDoNotMatch() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(false);

        SignupInputData inputData = new SignupInputData("john", "password", "differentPassword", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Passwords don't match.", errorMessage);
    }

    @Test
    void testExecuteInvalidEmail() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(false);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "invalid-email", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Invalid email address.", errorMessage);
    }

    @Test
    void testExecuteInvalidPhone() {
        when(userDAO.existsByName("john")).thenReturn(false);
        when(userDAO.existsByEmail("john@example.com")).thenReturn(false);
        when(userDAO.existsByPhone("1234567890")).thenReturn(false);

        SignupInputData inputData = new SignupInputData("john", "password", "password", "John Doe", "john@example.com", "invalid-phone");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Invalid phone number.", errorMessage);
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
