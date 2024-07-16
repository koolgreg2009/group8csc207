package app;


import java.io.IOException;

import javax.swing.JOptionPane;

import data_access.FileUserDAO;
import data_access.UserDAOInterface;
import data_access.UserSignupDAInterface;
import entity.User.AdopterUserFactory;
import entity.User.UserFactory;
import interface_adapter.LoginViewModel;
import interface_adapter.SignupController;
import interface_adapter.SignupPresenter;
import interface_adapter.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.SignupInputBoundary;
import use_case.SignupInteractor;
import use_case.SignupOutputBoundary;
import view.SignupView;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException {
    	FileUserDAO userDataAccessObject = new FileUserDAO("./users.json");

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        AdopterUserFactory userFactory = new AdopterUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }
}
