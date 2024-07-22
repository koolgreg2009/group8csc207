package app;


import entity.preference.UserPreference;
import interface_adapter.adopt.AdoptController;
import interface_adapter.bookmark.AddBookmarkController;
import interface_adapter.bookmark.RemoveBookmarkController;
import interface_adapter.display_all_pets.DisplayAllPetsController;
import interface_adapter.get_breed.GetBreedController;
import interface_adapter.login.LoginController;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.preference.PreferenceController;
import interface_adapter.signup.SignupController;
//import view.LoginView;
//import view.SignupView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // From Paul Gries's example
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
//        JFrame application = new JFrame("Pet Adoption App");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        CardLayout cardLayout = new CardLayout();
//
//        // The various View objects. Only one view is visible at a time.
//        JPanel views = new JPanel(cardLayout);
//        application.add(views);
//
//        // This keeps track of and manages which view is currently showing.
//        ViewManagerModel viewManagerModel = new ViewManagerModel();
//        new ViewManager(views, cardLayout, viewManagerModel);
//
//        // The data for the views, such as username and password, are in the ViewModels.
//        // This information will be changed by a presenter object that is reporting the
//        // results from the use case. The ViewModels are observable, and will
//        // be observed by the Views.
//        LoginViewModel loginViewModel = new LoginViewModel();
//        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
//        SignupViewModel signupViewModel = new SignupViewModel();
//
//        UserDAOInterface userDataAccessObject;
//        try {
//            userDataAccessObject = new FileUserDAO("./users.json");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
//        views.add(signupView, signupView.viewName);
//
//        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
//        views.add(loginView, loginView.viewName);
//
//        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
//        views.add(loggedInView, loggedInView.viewName);
//
//        viewManagerModel.setActiveView(signupView.viewName);
//        viewManagerModel.firePropertyChanged();
//
//        application.pack();
//        application.setVisible(true);
        //For our use case (part we need to edit)
        //catapi use case:
//        SignupController signupController = SignupUseCaseFactory.createUserSignupUseCase();
//        signupController.execute(); // try fail signup (different password or already exists)
//        signupController.execute(); // try successful signup

        LoginController loginController = LoginUseCaseFactory.createUserLoginUseCase();
        loginController.execute(); // try fail sign in (different password)
//        loginController.execute(); // try successful sign in
        AdoptController adoptController = AdoptUseCaseFactory.createAdoptUseCase();
        adoptController.execute();
        PreferenceController preferenceController = PreferenceUsecaseFactory.createPreferenceUsecase();
        preferenceController.execute(); // try some preference

        DisplayAllPetsController displayAllPetsController = DisplayAllPetsUseCaseFactory.createDisplayAllPetsUseCase();
        displayAllPetsController.execute();
        preferenceController.execute(); // try another preference
        displayAllPetsController.execute();

        AddBookmarkController addBookmarkController = AddBookmarkUseCaseFactory.createAddBookmarkUseCase();
        addBookmarkController.execute();
        RemoveBookmarkController removeBookmarkController = RemoveBookmarkUseCaseFactory.removeBookmarkUseCase();
        removeBookmarkController.execute();
        PetBioController petBioController = PetBioUseCaseFactory.createPetBioUseCase();
        petBioController.execute();
        GetBreedController getBreedController = GetBreedUseCaseFactory.createGetBreedUseCase();
        getBreedController.execute();
//        AdoptController adoptController = AdoptUseCaseFactory.createAdoptUseCase();
        adoptController.execute();
    }
}

//    public class ConsoleInputExample {
//        public static void main(String[] args) {
//            // Create a Scanner object to read input from the console
//            Scanner scanner = new Scanner(System.in);
//
//            // Prompt the user to enter some input
//            System.out.print("Enter your name: ");
//            String name = scanner.nextLine();
//
//            System.out.print("Enter your age: ");
//            int age = scanner.nextInt();
//
//            // Display the input back to the user
//            System.out.println("Your name is " + name + " and you are " + age + " years old.");
//
//            // Close the scanner
//            scanner.close();
//        }
//    }
