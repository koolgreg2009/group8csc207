//package app;
//
//import data_access.FilePetDAO;
//import data_access.FileUserDAO;
//import data_access.PetDAOInterface;
//import data_access.UserDAOInterface;
//import interface_adapter.display_all_pets.DisplayAllPetsController;
//import interface_adapter.display_all_pets.DisplayPetsPresenter;
//import interface_adapter.logged_in.LoggedInViewModel;
//import use_case.display.display_all_available_pets.DisplayAllPetsInputBoundary;
//import use_case.display.display_all_available_pets.DisplayAllPetsInteractor;
//import use_case.display.DisplayPetsOutputBoundary;
//
//import java.io.IOException;
//
///**
// * Factory class responsible for creating instances of {@link DisplayAllPetsController}.
// */
//public class DisplayAllPetsUseCaseFactory {
//
//    /**
//     * Private constructor to prevent instantiation.
//     * This class is intended to be used as a factory for creating use case instances.
//     */
//    private DisplayAllPetsUseCaseFactory() {
//    }
//
//    /**
//     * Creates and returns an {@link DisplayAllPetsController} instance.
//     * Sets up the necessary dependencies including the data access object and presenter.
//     *
//     * @return an instance of {@link DisplayAllPetsController}, or {@code null} if an {@link IOException} occurs.
//     */
//    public static DisplayAllPetsController createDisplayAllPetsUseCase(UserDAOInterface userDAO, PetDAOInterface petDAO, LoggedInViewModel loggedInViewModel) {
//
//        DisplayPetsOutputBoundary displayAllPetsPresenter = new DisplayPetsPresenter(loggedInViewModel);
//        DisplayAllPetsInputBoundary displayAllPetsInteractor = new DisplayAllPetsInteractor(petDAO, userDAO,
//                displayAllPetsPresenter);
//        return new DisplayAllPetsController(displayAllPetsInteractor);
//
//    }
//}