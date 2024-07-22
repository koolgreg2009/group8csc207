package use_case.signup;

import data_access.UserDAOInterface;
import entity.user.AdopterUser;
import entity.user.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//May not work at the moment. Needs update
class SignupInteractorTest {

    private UserDAOInterface userDataAccessObject;
    private SignupOutputBoundary userPresenter;
    private UserFactory adopterUserFactory;
    private SignupInteractor interactor;

    @BeforeEach
    void setUp() {
        userDataAccessObject = mock(UserDAOInterface.class);
        userPresenter = mock(SignupOutputBoundary.class);
        adopterUserFactory = mock(UserFactory.class);
        interactor = new SignupInteractor(userDataAccessObject, userPresenter, adopterUserFactory);
    }

    @Test
    void testSignupSuccess() {
        // Given
        String username = "newAdopter";
        String password = "password";
        String name = "Test Adopter";
        String email = "adopter@example.com";
        String phone = "1234567890";

        SignupInputData inputData = new SignupInputData(username, password, password, name, email, phone);
        AdopterUser adopterUser = new AdopterUser(username, password, name, email, phone);
        when(userDataAccessObject.existsByName(username)).thenReturn(false);
        when(adopterUserFactory.createAdopter(username, password, name, email, phone)).thenReturn(adopterUser);

        // Execute the use case
        interactor.execute(inputData);

        // Verify that the user was created and saved
        verify(userDataAccessObject).existsByName(username);
        verify(userDataAccessObject).save(adopterUser);
        verify(userPresenter).prepareSuccessView(any(SignupOutputData.class));

        // Capture the argument passed to prepareSuccessView
        ArgumentCaptor<SignupOutputData> captor = ArgumentCaptor.forClass(SignupOutputData.class);
        verify(userPresenter).prepareSuccessView(captor.capture());
        SignupOutputData outputData = captor.getValue();

        // Verify the output data
        assertEquals(username, outputData.getUsername());
    }

    @Test
    void testSignupUserAlreadyExists() {
        // Given
        String username = "existingAdopter";
        String password = "password";
        String name = "Test Adopter";
        String email = "adopter@example.com";
        String phone = "1234567890";

        SignupInputData inputData = new SignupInputData(username, password, password, name, email, phone);
        when(userDataAccessObject.existsByName(username)).thenReturn(true);

        // Execute the use case
        interactor.execute(inputData);

        // Verify that the failure response was presented
        verify(userDataAccessObject).existsByName(username);
        verify(userPresenter).prepareFailView("User already exists.");
    }

    @Test
    void testSignupPasswordsDoNotMatch() {
        // Given
        String username = "newAdopter";
        String password = "password";
        String repeatPassword = "differentPassword";
        String name = "Test Adopter";
        String email = "adopter@example.com";
        String phone = "1234567890";

        SignupInputData inputData = new SignupInputData(username, password, repeatPassword, name, email, phone);
        when(userDataAccessObject.existsByName(username)).thenReturn(false);

        // Execute the use case
        interactor.execute(inputData);

        // Verify that the failure response was presented
        verify(userDataAccessObject).existsByName(username);
        verify(userPresenter).prepareFailView("Passwords don't match.");
    }
}