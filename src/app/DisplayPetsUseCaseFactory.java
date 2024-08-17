package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.display_pets.DisplayPetsPresenter;
import interface_adapter.display_pets.DisplayPetsViewModel;
import use_case.display_pets.DisplayPetsInputBoundary;
import use_case.display_pets.DisplayPetsInteractor;
import use_case.display_pets.DisplayPetsOutputBoundary;
import view.DisplayPetsView;

/**
 * Factory class responsible for creating instances related to the display pets use case.
 */
public class DisplayPetsUseCaseFactory {

	/**
	 * Private constructor of {@link DisplayPetsUseCaseFactory} to prevent instantiation.
	 * This class is intended to be used as a factory for creating use case instances.
	 */
	private DisplayPetsUseCaseFactory() {
	}

	public static DisplayPetsView create(ViewManagerModel viewManagerModel,
										 DisplayPetsViewModel displayPetsViewModel,
										 LoggedInViewModel loggedInViewModel,
										 UserDAOInterface userDAO,
										 PetDAOInterface petDAO) {
		DisplayPetsController displayPetsController = createDisplayPetsUseCase(viewManagerModel, loggedInViewModel,
				userDAO, petDAO);
		return new DisplayPetsView(displayPetsViewModel, displayPetsController);

	}

	/**
	 * Creates and returns an instance of {@link DisplayPetsView}.
	 * Sets up the necessary dependencies including the view model and controller.
	 *
	 * @param viewManagerModel the model that manages the active view.
	 * @param loggedInViewModel the view model representing the logged-in user's state.
	 * @param userDAO the data access object for user-related operations.
	 * @param petDAO the data access object for pet-related operations.
	 * @return an instance of {@link DisplayPetsView}.
	 */
	public static DisplayPetsController createDisplayPetsUseCase(ViewManagerModel viewManagerModel,
																 LoggedInViewModel loggedInViewModel, UserDAOInterface userDAO, PetDAOInterface petDAO) {

		DisplayPetsOutputBoundary displayPetsOutputBoundary = new DisplayPetsPresenter(viewManagerModel,
				loggedInViewModel);

		DisplayPetsInputBoundary loginSuccessInteractor = new DisplayPetsInteractor(displayPetsOutputBoundary,
				userDAO, petDAO);

		return new DisplayPetsController(loginSuccessInteractor);
	}
}