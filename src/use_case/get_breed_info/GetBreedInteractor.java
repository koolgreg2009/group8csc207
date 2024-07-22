package use_case.get_breed_info;

import data_access.CatDAOInterface;

/**
 * The GetBreedInteractor class is responsible for interacting with the CatDAOInterface
 * to fetch breed information and then passing that information to the presenter
 * to prepare the view.
 */
public class GetBreedInteractor implements GetBreedInputBoundary {
    private final CatDAOInterface catDAO;
    private final GetBreedOutputBoundary getBreedPresenter;

    /**
     * Constructs a new GetBreedInteractor with the given data access object and presenter.
     *
     * @param catDAO The data access object used to fetch breed information.
     * @param getBreedPresenter The presenter used to prepare the breed information view.
     */
    public GetBreedInteractor(CatDAOInterface catDAO, GetBreedOutputBoundary getBreedPresenter) {
        this.catDAO = catDAO;
        this.getBreedPresenter = getBreedPresenter;
    }

    /**
     * Executes the use case to fetch breed information using the provided breed input data.
     * The fetched information is then passed to the presenter to prepare the view.
     *
     * @param breedInputData The input data containing the breed name to fetch information for.
     */
    @Override
    public void execute(GetBreedInputData breedInputData) {
        String breedInfo = this.catDAO.getBreedInformation(breedInputData.getBreedName());
        GetBreedOutputData outputData = new GetBreedOutputData(breedInfo);
        this.getBreedPresenter.prepareGetBreedView(outputData);
    }
}
