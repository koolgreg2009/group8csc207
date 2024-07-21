package app;

import java.io.IOException;
import javax.swing.JOptionPane;

import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import entity.user.AdopterUserFactory;
import entity.user.UserFactory;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.AddBookmarkPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.bookmarks.AddBookmarkInteractor;
import use_case.bookmarks.AddBookmarkOutputBoundary;
import use_case.bookmarks.BookmarkInputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.signup.SignupUserDataAccessInterface;
import view.SignupView;

/**
 * The SignupUseCaseFactory class is responsible for creating instances of the components
 * required for the signup use case, including the view, controller, and interactor.
 * It sets up the necessary dependencies and wiring for the signup functionality.
 *
 * @version 1.0
 * @since 2024-07-19
 */
public class SignupUseCaseFactory {
//
//    /**
//     * Prevents instantiation of this utility class.
//     */
//    private SignupUseCaseFactory() {}
//
//    /**
//     * Creates a SignupView instance, setting up the signup use case and its dependencies.
//     *
//     * @param viewManagerModel
//     * @param loginViewModel
//     * @param signupViewModel
//     * @param userDataAccessObject
//     * @return A SignupView instance configured with the provided dependencies.
//     */
////    public static SignupView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, UserDAOInterface userDataAccessObject) {
////
////        try {
////            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel);
////            return new SignupView(signupController, signupViewModel);
////        } catch (IOException e) {
////            JOptionPane.showMessageDialog(null, "Could not open user data file.");
////        }
////
////        return null;
////    }
//
//    /**
//     * Creates a SignupController instance and sets up the signup interactor and presenter.
//     *
//     * @param viewManagerModel
//     * @param signupViewModel
//     * @param loginViewModel
//     * @return A SignupController instance configured with the provided dependencies.
//     */
//    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException {
//    	UserDAOInterface userDataAccessObject = new FileUserDAO("./users.json");
//
//        // Notice how we pass this method's parameters to the Presenter.
//        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
//
//        AdopterUserFactory userFactory = new AdopterUserFactory();
//
//        SignupInputBoundary userSignupInteractor = new SignupInteractor(
//                userDataAccessObject, signupOutputBoundary, userFactory);
//
//        return new SignupController(userSignupInteractor);
//    }
    private SignupUseCaseFactory() {

    }

    private static SignupController createUserSignupUseCase() {

        try{
            UserDAOInterface userDAO = new FileUserDAO("./users.json");
            SignupOutputBoundary userPresenter = new SignupPresenter();
            UserFactory adopterUserFactory = new AdopterUserFactory();
            SignupInputBoundary SignupInteractor = new SignupInteractor(userDAO, userPresenter, adopterUserFactory);

            return new SignupController(SignupInteractor);

        } catch (IOException e) {
            System.out.println("Could not open user data file.");
            return null;
        }

    }

}
