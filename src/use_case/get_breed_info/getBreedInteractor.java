package use_case.get_breed_info;

import data_access.CatDAOInterface;

public class getBreedInteractor implements getBreedInputBoundary{
    private final CatDAOInterface catDAO;
    private final getBreedOutputBoundary getBreedPresenter;

    public getBreedInteractor(CatDAOInterface catDAO, getBreedOutputBoundary getBreedPresenter) {
        this.catDAO = catDAO;
        this.getBreedPresenter = getBreedPresenter;
    }

    @Override
    public void execute(getBreedInputData breedInputData){
        String breedInfo = this.catDAO.getBreedInformation(breedInputData.getBreedName());
        getBreedOutputData outputData = new getBreedOutputData(breedInfo);
        this.getBreedPresenter.prepareGetBreedView(outputData);
    }
}
