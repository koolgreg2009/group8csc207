package app;


import data_access.FilePetDAO;
import data_access.FileUserDAO;
import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import entity.Pet;
import interface_adapter.get_breed.GetBreedController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.pet_bio.PetBioController;
import interface_adapter.pet_bio.PetBioPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginUserDataAccessInterface;
import use_case.pet_bio.PetBioInteractor;
import use_case.pet_bio.PetBioOutputBoundary;
import use_case.pet_bio.PetBioOutputData;
import use_case.signup.SignupInteractor;
import view.LoginView;
import view.LoggedInView;
import view.SignupView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        //catapi use case:
        GetBreedController getBreedController = GetBreedUsecaseFactory.createGetBreedUsecase();
        getBreedController.execute();
    }

    // This main2 is temporary, just for Phase 1.
    public static void main2(String[] args) {
        //To read input from console
        Scanner scanner = new Scanner(System.in);

        //Prompt user
        System.out.println("Sign up or log in? 1 for sign up, 2 for log in.");
        int command = scanner.nextInt();

        if (command == 1){
            System.out.println("Username: ");
            String username = scanner.next();
            System.out.println("Password: ");
            String password = scanner.next();
            System.out.println("Repeat password: ");
            String repeatPassword = scanner.next();
            System.out.println("Name: ");
            String name = scanner.next();
            // fill out the rest, accomplish boundaries for line 89 to initiate
            //SignupInteractor signupInteractor = new SignupInteractor();
            //fill out execute's parameters with variables
            // signupInteractor.execute();
        }
        //FILL THE LOG IN PATHWAY
        else if (command == 2) {}

        // continue going after the if else statement and pretend you are in the home page now, call the next use case
        // SOME IDEAS ABOUT USER FLOW, OPEN TO CHANGE:
        // in the home page, after it presents all the pets on console, it can prompt user to bookmark a certain pet.
        // After, it needs to prompt the user to select a pet (goes into another use case) to view details.
        // Perhaps after this, the pet can then be unavailable and goes into the next use case
        // yadayada we can play around with the order about how things go

        //PetBio part
        PetBioController petBioController = PetBioUseCaseFactory.createPetBioUseCase();
        petBioController.execute();
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
