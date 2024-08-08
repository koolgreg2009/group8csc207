package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.get_breed.GetBreedController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.display_pets.DisplayPetsPresenter;
import interface_adapter.pet_bio.PetBioViewModel;
import use_case.display_pets.DisplayPetsInputBoundary;
import use_case.display_pets.DisplayPetsInteractor;
import use_case.display_pets.DisplayPetsOutputBoundary;
import view.PetDetailView;

/**
 * Factory class for creating PetDetailView and its related use cases.
 */
public class PetDetailUseCaseFactory {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private PetDetailUseCaseFactory() {
	}

	/**
	 * Creates a PetDetailView with its associated ViewModel and Controller.
	 *
	 * @param viewManagerModel   the ViewManagerModel instance
	 * @param petDetailViewModel the PetBioViewModel instance
	 * @param loggedInViewModel  the LoggedInViewModel instance
	 * @param userDAO            the UserDAOInterface instance
	 * @param petDAO             the PetDAOInterface instance
	 * @return a new PetDetailView instance
	 */
	public static PetDetailView create(ViewManagerModel viewManagerModel,
									   PetBioViewModel petDetailViewModel,
									   LoggedInViewModel loggedInViewModel,
									   UserDAOInterface userDAO,
									   PetDAOInterface petDAO) {
		DisplayPetsController displayPetsController = DisplayPetsUseCaseFactory.createLoginSuccessUseCase(viewManagerModel, loggedInViewModel,
				userDAO, petDAO);
		GetBreedController getBreedController = GetBreedUseCaseFactory.createGetBreedUseCase(petDetailViewModel);
		return new PetDetailView(petDetailViewModel, displayPetsController, getBreedController);

	}

}