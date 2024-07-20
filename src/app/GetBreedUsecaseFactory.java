package app;

import data_access.CatBreedDAO;
import data_access.CatDAOInterface;
import interface_adapter.get_breed.GetBreedController;
import interface_adapter.get_breed.GetBreedPresenter;
import use_case.get_breed_info.GetBreedInputBoundary;
import use_case.get_breed_info.GetBreedInteractor;
import use_case.get_breed_info.GetBreedOutputBoundary;

public class GetBreedUsecaseFactory {
    private GetBreedUsecaseFactory() {}
    public static GetBreedController createGetBreedUsecase(){
        CatDAOInterface catDao = new CatBreedDAO();
        GetBreedOutputBoundary getBreedPresenter = new GetBreedPresenter(); // atm this doesnt have anythihng else
        GetBreedInputBoundary getBreedInteractor = new GetBreedInteractor(catDao, getBreedPresenter);
        // creating interactor
        return new GetBreedController(getBreedInteractor); // creating controller
    }

}
