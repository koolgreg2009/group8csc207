package app;


import data_access.FilePetDAO;
import data_access.FileUserDAO;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.preference.UserPreference;
import interface_adapter.ProfileViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.adopt.AdoptController;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.bookmark.RemoveBookmarkController;
import interface_adapter.display_all_pets.DisplayAllPetsController;
import interface_adapter.get_breed.GetBreedController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.preference.PreferenceController;
import interface_adapter.preference.PreferenceViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import view.*;
import view.LoginView;
import view.SignupView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // From Paul Gries's example
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Login Page");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        BookmarkViewModel bookmarkViewModel = new BookmarkViewModel();
        PreferenceViewModel preferenceViewModel = new PreferenceViewModel();
        ProfileViewModel profileViewModel = new ProfileViewModel();
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

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDAO);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, signupViewModel, userDAO);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = new LoggedInView(loggedInViewModel, bookmarkViewModel, preferenceViewModel, loginViewModel, profileViewModel, viewManagerModel);
        views.add(loggedInView, loggedInView.viewName);

        BookmarkView bookmarkView = new BookmarkView();
        views.add(bookmarkView, bookmarkView.viewName);

        ProfileView profileView = new ProfileView();
        views.add(profileView, profileView.viewName);

        PreferenceView preferenceView = new PreferenceView();
        views.add(preferenceView, preferenceView.viewName);

        viewManagerModel.setActiveView(loginView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}

