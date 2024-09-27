package app;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_notifis.NotifViewModel;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.pet_bio.PetBioViewModel;
import interface_adapter.preference.PreferenceViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;

import static app.NotifViewUseCaseFactory.createNotifView;

/**
 * The Main class serves as the entry point to the Pet Adoption application.
 * It initializes the application's main window, sets up the different views
 * using a CardLayout, and creates instances of the necessary view models
 * and data access objects.
 * <p>
 * The application displays a series of views to the user, including login,
 * signup, pet display, bookmarks, notifications, and user profile.
 * </p>
 */
public class Main {

    /**
     * The main method initializes and launches the Pet Adoption application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        JFrame application = new JFrame("Pet Adoption");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setResizable(true);
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        DisplayPetsViewModel displayPetsViewModel = new DisplayPetsViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        BookmarkViewModel bookmarkViewModel = new BookmarkViewModel();
        NotifViewModel notifViewModel = new NotifViewModel();
        PreferenceViewModel preferenceViewModel = new PreferenceViewModel();
        PetBioViewModel petBioViewModel = new PetBioViewModel();

        UserDAOInterface userDAO = null;
        PetDAOInterface petDAO = null;
        APIInfoInterface infoDAO = null;

        try{
            userDAO = new FileUserDAO("./users.json");
        } catch (IOException e) {
            System.out.println("Could not open user data file.");
        }
        try{
            petDAO = new FilePetDAO("./pets.json");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try{
            infoDAO = new FileApiInfoDAO("./data.json");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel,
                preferenceViewModel, userDAO, displayPetsViewModel);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, displayPetsViewModel,
                signupViewModel, userDAO, petDAO);
        views.add(loginView, loginView.viewName);

        DisplayPetsView displayPetsView = DisplayPetsUseCaseFactory.create(viewManagerModel, displayPetsViewModel,
                loggedInViewModel, userDAO, petDAO);
        views.add(displayPetsView, displayPetsView.viewName);

        LoggedInView loggedInView = LoggedInUseCaseFactory.create(viewManagerModel, loggedInViewModel,
                bookmarkViewModel, preferenceViewModel, loginViewModel, notifViewModel,
                userDAO, petDAO, petBioViewModel, displayPetsViewModel);
        views.add(loggedInView, loggedInView.viewName);

        PetDetailView petDetailView = PetDetailUseCaseFactory.create(viewManagerModel, petBioViewModel,
                loggedInViewModel, userDAO, petDAO);
        views.add(petDetailView, petDetailView.viewName);

        BookmarkView bookmarkView = RemoveBookmarkUseCaseFactory.create(bookmarkViewModel, loggedInViewModel,
                preferenceViewModel, loginViewModel, petBioViewModel, viewManagerModel, notifViewModel,
                displayPetsViewModel, userDAO,petDAO);
        views.add(bookmarkView, bookmarkView.viewName);

        NotifView notifView = createNotifView(loggedInViewModel, viewManagerModel, notifViewModel);
        views.add(notifView, notifView.viewName);

        ProfileView profileView = new ProfileView();
        views.add(profileView, profileView.viewName);

        PreferenceView preferenceView = PreferenceUsecaseFactory.create(viewManagerModel, loggedInViewModel,
                preferenceViewModel, userDAO, displayPetsViewModel, petDAO, infoDAO);
        views.add(preferenceView, preferenceView.viewName);

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}