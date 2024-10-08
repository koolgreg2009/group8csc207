package app;

import data_access.CatBreedDAO;
import data_access.CatDAOInterface;
import interface_adapter.get_breed.GetBreedController;
import interface_adapter.get_breed.GetBreedPresenter;
import interface_adapter.pet_bio.PetBioViewModel;
import use_case.get_breed_info.GetBreedInputBoundary;
import use_case.get_breed_info.GetBreedInteractor;
import use_case.get_breed_info.GetBreedOutputBoundary;

/**
 * Factory class responsible for creating instances of {@link GetBreedController}.
 */
public class GetBreedUseCaseFactory {

    /**
     * Private constructor to prevent instantiation.
     * This class is intended to be used as a factory for creating use case instances.
     */
    private GetBreedUseCaseFactory() {
    }

    /**
     * Creates and returns an {@link GetBreedController} instance.
     * Sets up the necessary dependencies including the data access object and presenter.
     *
     * @return an instance of {@link GetBreedController}.
     */
    public static GetBreedController createGetBreedUseCase(PetBioViewModel petBioViewModel) {
        CatDAOInterface catDao = new CatBreedDAO();
        GetBreedOutputBoundary getBreedPresenter = new GetBreedPresenter(petBioViewModel);
        GetBreedInputBoundary getBreedInteractor = new GetBreedInteractor(catDao, getBreedPresenter);
        return new GetBreedController(getBreedInteractor);
    }
}