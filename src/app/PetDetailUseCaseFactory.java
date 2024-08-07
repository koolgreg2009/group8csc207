package app;

import data_access.PetDAOInterface;
import data_access.UserDAOInterface;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.display_pets.DisplayPetsController;
import interface_adapter.display_pets.DisplayPetsPresenter;
import interface_adapter.pet_bio.PetBioViewModel;
import use_case.display_pets.DisplayPetsInputBoundary;
import use_case.display_pets.DisplayPetsInteractor;
import use_case.display_pets.DisplayPetsOutputBoundary;
import view.PetDetailView;

public class PetDetailUseCaseFactory {

    private PetDetailUseCaseFactory() {
    }

	public static PetDetailView create(ViewManagerModel viewManagerModel,
									   PetBioViewModel petDetailViewModel, LoggedInViewModel loggedInViewModel, UserDAOInterface userDAO,
									   PetDAOInterface petDAO) {
			PetBioViewModel petDetailViewModel, LoggedInViewModel loggedInViewModel, UserDAOInterface userDAO,
			PetDAOInterface petDAO) {
		DisplayPetsController displayPetsController = createLoginSuccessUseCase(viewManagerModel, loggedInViewModel,
				userDAO, petDAO);
		return new PetDetailView(petDetailViewModel, displayPetsController);

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