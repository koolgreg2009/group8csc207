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

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the username is empty.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the username cannot be empty.
     */
    @Test
    void testExecuteEmptyUsername() {
        SignupInputData inputData = new SignupInputData("", "password", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Username cannot be empty.", errorMessage);
    }

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the password is empty.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the password cannot be empty.
     */
    @Test
    void testExecuteEmptyPassword() {
        SignupInputData inputData = new SignupInputData("john", "", "password", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Password cannot be empty.", errorMessage);
    }

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the repeat password field is empty.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the repeat password cannot be empty.
     */
    @Test
    void testExecuteEmptyRepeatPassword() {
        SignupInputData inputData = new SignupInputData("john", "password", "", "John Doe", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Repeat Password cannot be empty.", errorMessage);
    }

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the name field is empty.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the name cannot be empty.
     */
    @Test
    void testExecuteEmptyName() {
        SignupInputData inputData = new SignupInputData("john", "password", "password", "", "john@example.com", "1234567890");
        interactor.execute(inputData);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(presenter).prepareFailView(argumentCaptor.capture());

        String errorMessage = argumentCaptor.getValue();
        assertEquals("Your name cannot be empty.", errorMessage);
    }

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the username already exists.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the username already exists.
     */
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

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the email already exists.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the email is already in use.
     */
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

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the phone number already exists.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the phone number is already in use.
     */
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

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when passwords do not match.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the passwords do not match.
     */
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

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the email address is invalid.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the email address is invalid.
     */
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

    /**
     * Tests the {@link SignupInteractor#execute(SignupInputData)} method when the phone number is invalid.
     * <p>
     * The test verifies that the presenter receives the correct error message indicating that the phone number is invalid.
     */
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

    /**
     * Tests the successful execution of user signup.
     * <p>
     * This test ensures that when all validation checks pass (i.e., the username, email, and phone number are unique),
     * the {@link SignupInteractor} correctly creates a new {@link AdopterUser} and the {@link SignupOutputBoundary}
     * is informed of the successful signup.
     * </p>
     *
     * @see SignupInteractor
     * @see SignupOutputBoundary
     * @see SignupInputData
     * @see SignupOutputData
     * @see AdopterUser
     */
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
