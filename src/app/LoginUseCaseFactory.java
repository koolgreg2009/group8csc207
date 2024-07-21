package app;

import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import entity.user.AdopterUserFactory;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;

import javax.swing.*;
import java.io.IOException;

/**
 * The LoginUseCaseFactory class is responsible for creating instances of the components
 * required for the login use case, including the view, controller, and interactor.
 * It sets up the necessary dependencies and wiring for the login functionality.
 */
public class LoginUseCaseFactory {
//
//    /**
//     * Prevents instantiation of this utility class.
//     */
//    private LoginUseCaseFactory() {}
//
//    /**
//     * Creates a LoginView instance, setting up the login use case and its dependencies.
//     *
//     * @param viewManagerModel
//     * @param loginViewModel
//     * @param loggedInViewModel
//     * @param userDataAccessObject
//     * @return A LoginView instance configured with the provided dependencies.
//     */
//    public static LoginView create(
//            ViewManagerModel viewManagerModel,
//            LoginViewModel loginViewModel,
//            LoggedInViewModel loggedInViewModel,
//            UserDAOInterface userDataAccessObject) {
//
//        try {
//            LoginController loginController = createLoginUseCase(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
//            return new LoginView(loginViewModel, loginController);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "Could not open user data file.");
//        }
//
//        return null;
//    }
//
//    /**
//     * Creates a LoginController instance and sets up the login interactor and presenter.
//     *
//     * @param viewManagerModel
//     * @param loginViewModel
//     * @param loggedInViewModel
//     * @param userDataAccessObject
//     * @return A LoginController instance configured with the provided dependencies.
//     */
//
//    private static LoginController createLoginUseCase(
//            ViewManagerModel viewManagerModel,
//            LoginViewModel loginViewModel,
//            LoggedInViewModel loggedInViewModel,
//            UserDAOInterface userDataAccessObject) throws IOException {
//
//        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
//
//        UserFactory userFactory = new AdopterUserFactory();
//
//        LoginInputBoundary loginInteractor = new LoginInteractor(
//                userDataAccessObject, loginOutputBoundary);
//
//        return new LoginController(loginInteractor);
//    }
    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private LoginUseCaseFactory() {

    }

    /**
     * Creates and returns a {@link LoginController} instance.
     * Sets up the necessary dependencies including the data access object and presenter.
     *
     * @return an instance of {@link LoginController}, or {@code null} if an {@link IOException} occurs.
     */
    public static LoginController createUserLoginUseCase() {

        try{
            UserDAOInterface userDAO = new FileUserDAO("./users.json");
            LoginOutputBoundary userPresenter = new LoginPresenter();
            LoginInputBoundary LoginInteractor = new LoginInteractor(userDAO, userPresenter);

            return new LoginController(LoginInteractor);

        } catch (IOException e) {
            System.out.println("Could not open user data file.");
            return null;
        }
    }
}
