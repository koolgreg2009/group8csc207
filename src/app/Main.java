package app;


import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.FilePetDAO;
import data_access.FileUserDAO;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ProfileViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.NotifViewModel;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.display_pets.DisplayPetsViewModel;
import interface_adapter.pet_bio.PetBioViewModel;
import interface_adapter.preference.PreferenceViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;

public class Main {
    public static void main(String[] args) {
        // From Paul Gries's example
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Pet Adoption");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setResizable(true);
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        application.setSize(800, 500);
        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);
        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.

        LoginViewModel loginViewModel = new LoginViewModel();
        DisplayPetsViewModel displayPetsViewModel = new DisplayPetsViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        BookmarkViewModel bookmarkViewModel = new BookmarkViewModel();
        NotifViewModel notifViewModel = new NotifViewModel();
        PreferenceViewModel preferenceViewModel = new PreferenceViewModel();
        ProfileViewModel profileViewModel = new ProfileViewModel();
        PetBioViewModel petBioViewModel = new PetBioViewModel();
        // creating user and pet DAO to be used for all use cases. declared outside so compiler doesnt cry
        UserDAOInterface userDAO = null;
        PetDAOInterface petDAO = null;
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

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, preferenceViewModel, userDAO);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, displayPetsViewModel, signupViewModel, userDAO, petDAO);
        views.add(loginView, loginView.viewName);

        DisplayPetsView displayPetsView = DisplayPetsUseCaseFactory.create(viewManagerModel, displayPetsViewModel, loggedInViewModel, userDAO, petDAO);
        views.add(displayPetsView, displayPetsView.viewName);

        LoggedInView loggedInView = LoggedInUseCaseFactory.create(viewManagerModel, loggedInViewModel, bookmarkViewModel, preferenceViewModel, loginViewModel, profileViewModel, notifViewModel, userDAO, petDAO,
                petBioViewModel, displayPetsViewModel);
        views.add(loggedInView, loggedInView.viewName);

        PetDetailView petDetailView = PetDetailUseCaseFactory.create(viewManagerModel, petBioViewModel, loggedInViewModel, userDAO, petDAO);
        views.add(petDetailView, petDetailView.viewName);

//        BookmarkView bookmarkView = new BookmarkView();
//        views.add(bookmarkView, bookmarkView.viewName);

        NotifView notifView = new NotifView(loggedInViewModel,viewManagerModel,notifViewModel);
        views.add(notifView, notifView.viewName);

        ProfileView profileView = new ProfileView();
        views.add(profileView, profileView.viewName);

        PreferenceView preferenceView = PreferenceUsecaseFactory.create(viewManagerModel, loggedInViewModel, preferenceViewModel, userDAO, displayPetsViewModel);
        views.add(preferenceView, preferenceView.viewName);

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        //application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}