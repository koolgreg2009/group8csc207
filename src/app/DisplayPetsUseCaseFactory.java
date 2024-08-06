package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login_success.DisplayPetsController;
import interface_adapter.login_success.DisplayPetsPresenter;
import interface_adapter.login_success.DisplayPetsViewModel;
import use_case.login_success.DisplayPetsInputBoundary;
import use_case.login_success.DisplayPetsInteractor;
import use_case.login_success.DisplayPetsOutputBoundary;
import view.DisplayPetsView;

public class DisplayPetsUseCaseFactory {

	private DisplayPetsUseCaseFactory() {
	}

	public static DisplayPetsView create(ViewManagerModel viewManagerModel,
										 DisplayPetsViewModel displayPetsViewModel, LoggedInViewModel loggedInViewModel, UserDAOInterface userDAO,
										 PetDAOInterface petDAO) {
		DisplayPetsController displayPetsController = createLoginSuccessUseCase(viewManagerModel, loggedInViewModel,
				userDAO, petDAO);
		return new DisplayPetsView(displayPetsViewModel, displayPetsController);

	}

	private static DisplayPetsController createLoginSuccessUseCase(ViewManagerModel viewManagerModel,
																   LoggedInViewModel loggedInViewModel, UserDAOInterface userDAO, PetDAOInterface petDAO) {

		DisplayPetsOutputBoundary displayPetsOutputBoundary = new DisplayPetsPresenter(viewManagerModel,
				loggedInViewModel);

		DisplayPetsInputBoundary loginSuccessInteractor = new DisplayPetsInteractor(displayPetsOutputBoundary,
				userDAO, petDAO);

		return new DisplayPetsController(loginSuccessInteractor);
	}
}