package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.bookmark.BookmarkViewModel;
import interface_adapter.display_bookmark_pets.DisplayBookmarkController;
import interface_adapter.display_bookmark_pets.DisplayBookmarkPresenter;
import interface_adapter.logged_in.LoggedInViewModel;
import use_case.display_bookmark_pets.DisplayBookmarkInputBoundary;
import use_case.display_bookmark_pets.DisplayBookmarkInteractor;
import use_case.display_bookmark_pets.DisplayBookmarkPetsOutputBoundary;

public class DisplayBookmarkUseCaseFactory {
//    public static DisplayPetsView create(ViewManagerModel viewManagerModel,
//                                         DisplayPetsViewModel displayPetsViewModel, LoggedInViewModel loggedInViewModel, UserDAOInterface userDAO,
//                                         PetDAOInterface petDAO) {
//        DisplayPetsController displayPetsController = createLoginSuccessUseCase(viewManagerModel, loggedInViewModel,
//                userDAO, petDAO);
//        return new DisplayPetsView(displayPetsViewModel, displayPetsController);

    public static DisplayBookmarkController displayBookmarkUseCase(ViewManagerModel viewManagerModel,
                                                                    LoggedInViewModel loggedInViewModel,
                                                                    BookmarkViewModel bookmarkViewModel,
                                                                    UserDAOInterface userDAO,
                                                                    PetDAOInterface petDAO) {

        DisplayBookmarkPetsOutputBoundary displayBookmarkPresenter = new DisplayBookmarkPresenter(bookmarkViewModel);
        DisplayBookmarkInputBoundary displayBookmarkInteractor = new DisplayBookmarkInteractor(userDAO, petDAO,
                displayBookmarkPresenter);

        return new DisplayBookmarkController(displayBookmarkInteractor);
    }
}
