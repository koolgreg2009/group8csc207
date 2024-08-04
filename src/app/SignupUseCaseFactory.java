package app;

import java.io.IOException;

import javax.swing.JOptionPane;

import data_access.UserDAOInterface;
import entity.user.AdopterUserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import view.SignupView;

/**
 * The SignupUseCaseFactory class is responsible for creating instances of the components
 * required for the signup use case, including the view, controller, and interactor.
 * It sets up the necessary dependencies and wiring for the signup functionality.
 *
 */
public class SignupUseCaseFactory {

    /**
     * Prevents instantiation of this utility class.
     */
    private SignupUseCaseFactory() {}

    /**
     * Creates a SignupView instance, setting up the signup use case and its dependencies.
     *
     * @param viewManagerModel
     * @param loginViewModel
     * @param signupViewModel
     * @param userDataAccessObject
     * @return A SignupView instance configured with the provided dependencies.
     */
    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, UserDAOInterface userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    /**
     * Creates a SignupController instance and sets up the signup interactor and presenter.
     *
     * @param viewManagerModel
     * @param signupViewModel
     * @param loginViewModel
     * @param userDataAccessObject 
     * @return A SignupController instance configured with the provided dependencies.
     */
    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, UserDAOInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        AdopterUserFactory userFactory = new AdopterUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }

}
