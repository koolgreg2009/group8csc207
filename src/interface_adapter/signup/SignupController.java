package interface_adapter.signup;

import use_case.pet_bio.PetBioInputData;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

//temp
import use_case.signup.SignupInteractor;

import java.util.Scanner;

/**
 * The controller for the signup process, managing user input and interacting
 * with the signup use case. It takes user input and passes it to the signup
 * use case interactor for processing.
 *
 * @version 1.0
 * @since 2024-07-20
 */
public class SignupController {

    /** The use case interactor for handling the signup process. */
    final SignupInputBoundary userSignupUseCaseInteractor;

    /**
     * Constructs a new SignupController with the given use case interactor.
     *
     * @param userSignupUseCaseInteractor
     */
    public SignupController(SignupInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the signup process with the provided user details.
     *
     * @param username
     * @param password1
     * @param password2
     */
//    public void execute(String username, String password1, String password2) {
//        SignupInputData signupInputData = new SignupInputData(
//                username, password1, password2, "", "", "");
//
//        userSignupUseCaseInteractor.execute(signupInputData);
//    }

    //This is a temporary execute method for Phase 1 to work around Terminals.
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scanner.next();
        System.out.println("Password: ");
        String password1 = scanner.next();
        System.out.println("Repeat password: ");
        String password2 = scanner.next();
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Phone: ");
        String phone = scanner.next();
        this.userSignupUseCaseInteractor.execute(new SignupInputData(username, password1, password2, name, email, phone));
    }
}
