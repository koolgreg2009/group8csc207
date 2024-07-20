package use_case.get_breed_info;

import data_access.CatDAOInterface;

public class GetBreedInteractor implements GetBreedInputBoundary {
    private final CatDAOInterface catDAO;
    private final GetBreedOutputBoundary getBreedPresenter;

    public GetBreedInteractor(CatDAOInterface catDAO, GetBreedOutputBoundary getBreedPresenter) {
        this.catDAO = catDAO;
        this.getBreedPresenter = getBreedPresenter;
    }

    @Override
    public void execute(GetBreedInputData breedInputData){
        String breedInfo = this.catDAO.getBreedInformation(breedInputData.getBreedName());
        GetBreedOutputData outputData = new GetBreedOutputData(breedInfo);
        this.getBreedPresenter.prepareGetBreedView(outputData);
    }
}
