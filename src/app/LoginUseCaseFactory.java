package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login_success.DisplayPetsViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import view.LoginView;

/**
 * The LoginUseCaseFactory class is responsible for creating instances of the components
 * required for the login use case, including the view, controller, and interactor.
 * It sets up the necessary dependencies and wiring for the login functionality.
 */
public class LoginUseCaseFactory {

    /**
     * Prevents instantiation of this utility class.
     */
    private LoginUseCaseFactory() {
    }

    /**
     * Creates a LoginView instance, setting up the login use case and its dependencies.
     *
     * @param viewManagerModel
     * @param loginViewModel
     * @param displayPetsViewModel
     * @param userDAO
     * @param petDAO 
     * @return A LoginView instance configured with the provided dependencies.
     */
    public static LoginView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel, DisplayPetsViewModel displayPetsViewModel, SignupViewModel signupViewModel,
            UserDAOInterface userDAO, PetDAOInterface petDAO) {
            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, displayPetsViewModel, userDAO, petDAO);
            return new LoginView(loginViewModel, loginController, viewManagerModel, signupViewModel);

        }
    /**
     * Creates a LoginController instance and sets up the login interactor and presenter.
     *
     * @param viewManagerModel
     * @param loginViewModel
     * @param displayPetsViewModel
     * @param userDAO
     * @param petDAO 
     * @return A LoginController instance configured with the provided dependencies.
     */

    private static LoginController createLoginUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            DisplayPetsViewModel displayPetsViewModel,
            UserDAOInterface userDAO, PetDAOInterface petDAO){

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, displayPetsViewModel, loginViewModel);


        LoginInputBoundary loginInteractor = new LoginInteractor(
                userDAO, petDAO, loginOutputBoundary);

        return new LoginController(loginInteractor);
    }
}
    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
//    private LoginUseCaseFactory() {
//
//    }
//
//    /**
//     * Creates and returns a {@link LoginController} instance.
//     * Sets up the necessary dependencies including the data access object and presenter.
//     *
//     * @return an instance of {@link LoginController}, or {@code null} if an {@link IOException} occurs.
//     */
//    public static LoginController createUserLoginUseCase() {
//
//        try{
//            UserDAOInterface userDAO = new FileUserDAO("./users.json");
//            LoginOutputBoundary userPresenter = new LoginPresenter();
//            LoginInputBoundary LoginInteractor = new LoginInteractor(userDAO, userPresenter);
//
//            return new LoginController(LoginInteractor);
//
//        } catch (IOException e) {
//            System.out.println("Could not open user data file.");
//            return null;
//        }
//    }
//}
